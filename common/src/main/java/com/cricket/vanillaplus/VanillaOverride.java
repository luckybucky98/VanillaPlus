package com.cricket.vanillaplus;

import java.util.Arrays;
import java.util.Map;

import net.minecraft.launchwrapper.IClassTransformer;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TypeInsnNode;

import com.google.common.eventbus.EventBus;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

public class VanillaOverride extends DummyModContainer implements IFMLLoadingPlugin, IClassTransformer{

	public VanillaOverride() {
		super(new ModMetadata());
		ModMetadata meta = getMetadata();
		meta.modId = "VPCore";
		meta.name = "VanillaPlus Core";
		meta.version = "1.0";
		meta.description = "Core Mod for VanillaPlus";
		meta.authorList = Arrays.asList("Cricket");
		meta.url = "";
		meta.screenshots = new String[0];
		meta.parent = "VanillaPlus";
	}
	
	@Override
	public boolean registerBus(EventBus bus, LoadController controller){
		bus.register(this);
		return true;
	}
	
	private FMLDeobfuscatingRemapper remapper;
	
	@Override
	public byte[] transform(String name, String transformedName, byte[] data) {
		remapper = FMLDeobfuscatingRemapper.INSTANCE;
		byte[] newData = data;
		
		if(name.equals("ajq")){
			System.out.println("[Vanilla Plus] Doing some patchy doodles on the furnace");
			newData = patchVanillaSterf(data, true);
			if(newData != data){
				System.out.println("[Vanilla Plus] Tada! Ya got yerself a new furnace");
			} else {
				System.out.println("[Vanilla Plus] We dun goofed should probably report this to Cricket");
			}
		}
		if(name.equals("net.minecraft.block.BlockFurnace")) {
			System.out.println("[Vanilla Plus] Patching the vanilla class: " + name);
			newData = patchVanillaSterf(data, false);
			if(newData != data) {
				System.out.println("[Vanilla Plus] Tada! Ya got yerself a new furnace");
			} else {
				System.out.println("[Vanilla Plus] We dun goofed should probably report this to Cricket");
			}
		}
		return newData;
	}

	@Override
	public String[] getASMTransformerClass() {
		return new String[]{VanillaOverride.class.getName()};
	}

	@Override
	public String getModContainerClass() {
		return VanillaOverride.class.getName();
	}
	
	public String getAccessTransformerClass(){
		return "com.cricket.vanillaplus.AccessTransformers";
	}

	@Override
	public String getSetupClass() {
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) {}
	
	public byte[] patchVanillaSterf(byte[] data, boolean obfuscated){
		String registerItems = obfuscated ? "l" : "registerItems";
		ClassNode classNode = new ClassNode();
		ClassReader classReader = new ClassReader(data);
		classReader.accept(classNode, 0);
		
		boolean furnaceFound = false;
		
		for(int c = 0; c < classNode.methods.size(); ++c){
			MethodNode method = classNode.methods.get(c);
			if(method.name.equals(registerItems) && method.desc.equals("()V")){
				for(int d = 0; d < method.instructions.size(); ++d){
					AbstractInsnNode instruction = method.instructions.get(d);
					if(instruction.getType() == AbstractInsnNode.LDC_INSN){
						LdcInsnNode ldcInstruction = (LdcInsnNode)instruction;
						if(ldcInstruction.cst.equals("furnace")){
							if(!furnaceFound){
								((TypeInsnNode)method.instructions.get(d+1)).desc = "com.cricket.vanillaplus.blocks.BlockFurnace";
								((MethodInsnNode)method.instructions.get(d+3)).owner = "com.cricket.vanillaplus.blocks.BlockFurnace";
							}
							furnaceFound = true;
						}
					}
				}
			}
		}
		ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);
		classNode.accept(writer);
		return writer.toByteArray();
		
	}
}
