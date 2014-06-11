package com.cricket.vanillaplus;

import net.minecraftforge.common.MinecraftForge;

public class VPEventHandler {

    public static void init(){
        MinecraftForge.EVENT_BUS.register(new VPEvent());
    }
}
