package com.hackathon.lambda;

import com.google.gson.Gson;

public class Deltas {
	public double lat;
	public double lon;
	public double accuracy;
	static Gson g=new Gson();
	public String toString(){
		return g.toJson(this);
	}
	public String toChart(){
		String s=String.format("[ %f, %f, %f],",lat,lon,accuracy);
		return s;
	}
}
