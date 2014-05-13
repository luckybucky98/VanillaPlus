package com.cricket.vanillaplus.client;

import com.cricket.vanillaplus.CommonProxy;

public class ClientProxy extends CommonProxy {
	public void initCapes(){
		DevCapes.getInstance().registerConfig("html://www.github.com/TheCricket/VanillaPlus/capes/DevloperCricket.png","VanillaPlus");
	}
}
