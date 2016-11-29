package com.hackathon.lambda;

import com.google.gson.Gson;

import swagger.model.Query.CountryEnum;

public class SpotPredictRequest {
	
	Double lat;
	Double lon;
	CountryEnum country;
	LandscapeEnum landscape;
	Column column;
	
	public SpotPredictRequest(){}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public CountryEnum getCountry() {
		return country;
	}

	public void setCountry(CountryEnum country) {
		this.country = country;
	}

	public LandscapeEnum getLandscape() {
		return landscape;
	}

	public void setLandscape(LandscapeEnum landscape) {
		this.landscape = landscape;
	}

	public Column getColumn() {
		return column;
	}

	public void setColumn(Column column) {
		this.column = column;
	}
	public static void main(String[] args){
		SpotPredictRequest spr = new SpotPredictRequest();
		spr.column=Column.ACCESS;
		spr.country=CountryEnum.TZA;
		spr.lat=0.0;
		spr.lon=0.0;
		spr.landscape=LandscapeEnum.L000;
		Gson g=new Gson();
		System.out.println(g.toJson(spr));
	}
}
