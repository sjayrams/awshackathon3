package com.hackathon.lambda;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Prediction {
	@JsonProperty
	double predictedValue;
	@JsonProperty
	HashMap<String,String> details;
	@Override
	public String toString() {
		return "Prediction [predictedValue=" + predictedValue + ", details=" + details + "]";
	}
	
	
}
