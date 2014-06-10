package com.cricket.vanillaplus.special;

public class YearlyDate {
	public Month month;
	public int day;
	
	public YearlyDate(Month m, int d){
		this.month = m;
		this.day = d;
	}
	
	public YearlyDate(int m, int d){
		this(Month.values()[(m - 1)], d);
	}
	
	public boolean equals(Object obj){
		return ((obj instanceof YearlyDate)) && (((YearlyDate)obj).month == this.month) &&(((YearlyDate)obj).day == this.day);
	}
	
	public int hashCode(){
		int code = 1;
		code = 31 * code + this.month.ordinal();
		code = 31 * code + this.day;
		return code;
	}
}
