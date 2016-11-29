package com.hackathon.lambda;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpotCheckResponse {
	@JsonProperty("predicted")
	Double predicted;
	@JsonProperty("actual")
	Double actual;
	@JsonProperty("dieviations")
	Double dieviations;
}
