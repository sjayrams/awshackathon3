package com.hackathon.lambda;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PredictionML {
	@JsonProperty
	Prediction Prediction;

	@Override
	public String toString() {
		return "PredictionML [Prediction=" + Prediction + "]";
	}
	
	
	
}
