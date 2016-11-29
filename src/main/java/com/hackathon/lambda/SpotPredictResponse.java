package com.hackathon.lambda;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

public class SpotPredictResponse {
	@JsonProperty	
	public Double value;
	
	public String toString(){
		Gson g=new Gson();
		return g.toJson(this);
	}
}
