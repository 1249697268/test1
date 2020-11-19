package com.example.weather.model;

public class country {
	private int id;
	private String CountryName;
	private String CountryCode;
	private int cityId;
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public String CountryName(){
		return CountryName;
	}
	public void getCountryName(String CountryName){
		this.CountryName=CountryName;
	}
	public String CountryCode(){
		return CountryCode;
	}
	public void getCountryCode(String CountryCode){
		this.CountryCode=CountryCode;
	}
	public int getcityId(){
		return cityId;
	}
	public void setcityId(int cityId){
		this.cityId=cityId;
	}
}
