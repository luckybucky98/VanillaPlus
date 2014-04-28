package q;

public class ConfigurationHandler {
	
	public void load(){
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
	}
	
	public void loadItems(){
		ItemPebbleid = config,get("Item ID's", "Pebble", 600).getInt();
	}
	
	public void loadBlocks(){
		BlockRockCrusherid = config.get("Block ID's", "Rock Crusher", 700).getInt();
	}

}
