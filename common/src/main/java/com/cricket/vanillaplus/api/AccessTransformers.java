package com.cricket.vanillaplus.api;

import java.io.IOException;

import cpw.mods.fml.common.asm.transformers.AccessTransformer;

public class AccessTransformers extends AccessTransformer{

	public AccessTransformers() throws IOException {
		super("vanillaplus_at.cfg");
	}

}
