package com.cricket.vanillaplus.special;

public enum Month {
	JANUARY("January"),  FEBRUARY("February"),  MARCH("March"),  APRIL("April"),  MAY("May"),  JUNE("June"),  JULY("July"),  AUGUST("August"),  SEPTEMBER("September"),  OCTOBER("October"),  NOVEMBER("November"),  DECEMBER("December");
	
	private final String name;
	
	private Month(String n){
		this.name = n;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int month(){
		return ordinal() + 1;
	}
	
}
