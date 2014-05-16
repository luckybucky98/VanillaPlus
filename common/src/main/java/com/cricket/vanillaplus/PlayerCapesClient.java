package com.cricket.vanillaplus;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.multiplayer.NetClientHandler;
import net.minecraft.client.renderer.IImageBuffer;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureObject;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Session;
import net.minecraft.util.StringUtils;
import net.minecraft.world.World;

import com.cricket.vanillaplus.client.ClientProxy;

public class PlayerCapesClient extends EntityClientPlayerMP{

	private final Random rand = new Random();
	private ResourceLocation vanillaPlusCape;
	private ThreadDownloadImageData vanillaPlusCapeImage;
	
	public PlayerCapesClient(Minecraft minecraft, World world, Session session, NetClientHandler netClientHandler) {
		super(minecraft, world, session, netClientHandler);
		if(!VanillaPlus.playersClient.containsKey(this.getGameProfile().getName())){
			VanillaPlus.playersClient.put(this.getGameProfile().getName(), this);
		}
	}
	
	@Override
	protected void setupCustomSkin(){
		super.setupCustomSkin();
		if(ClientProxy.capeMap.containsKey(this.getGameProfile().getName())){
			this.vanillaPlusCape = PlayerCapesClient.getLocationCape2(this.getGameProfile().getName());
			this.vanillaPlusCapeImage = PlayerCapesClient.getDownloadImage(this.vanillaPlusCape, PlayerCapesClient.getCapeURL(this.getGameProfile().getName()), null, null);
		}
	}
	
	public static ResourceLocation getLocationCape2(String par0Str){
		return new ResourceLocation("cloaksVP/" + StringUtils.stripControlCodes(par0Str));
	}
	
	private static ThreadDownloadImageData getDownloadImage(ResourceLocation resourceLocation, String string, ResourceLocation par2ResourceLocation, IImageBuffer iImageBuffer){
		TextureManager textureManager = Minecraft.getMinecraft().getTextureManager();
		Object object = textureManager.getTexture(resourceLocation);
		
		if(object == null){
			object = new ThreadDownloadImageData(string, par2ResourceLocation, iImageBuffer);
			textureManager.loadTexture(resourceLocation, (TextureObject) object);
		}
		return (ThreadDownloadImageData) object;
	}
	
	public static String getCapeURL(String string){
		return ClientProxy.capeMap.get(string);
	}
	
	@Override
	public ResourceLocation getLocationCape(){
		if((ConfigManager.overrideCapes || !super.getTextureCape().isTextureUploaded()) && this.vanillaPlusCape != null){
			return this.vanillaPlusCape;
		}
		return super.getLocationCape();
	}
	
	@Override
	public ThreadDownloadImageData getTextureCape(){
		if((ConfigManager.overrideCapes || !super.getTextureCape().isTextureUploaded()) && this.vanillaPlusCape != null){
			return this.vanillaPlusCapeImage;
		}
		return super.getTextureCape();
	}
	
	
	
	
	
}
