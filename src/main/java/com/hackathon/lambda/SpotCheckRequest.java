package com.hackathon.lambda;

import swagger.model.Query.CountryEnum;

public class SpotCheckRequest {
	Double lat;
	Double lon;
	CountryEnum country;
	LandscapeEnum landscape;
	Column column;
	
	public SpotCheckRequest(){}

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
	
	
}
