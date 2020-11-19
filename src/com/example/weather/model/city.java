package com.example.weather.model;

public class city {
	private int id;
	private String CityName;
	private String CityCode;
	private int provinceId;
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public String CityName(){
		return CityName;
	}
	public void getCityName(String CityName){
		this.CityName=CityName;
	}
	public String CityCode(){
		return CityCode;
	}
	public void getCityCode(String CityCode){
		this.CityCode=CityCode;
	}
	public int getprovinceId(){
		return provinceId;
	}
	public void setprovinceId(int provinceId){
		this.provinceId=provinceId;
	}
}
