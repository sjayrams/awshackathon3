package com.hackathon.lambda;

import swagger.model.Query.CountryEnum;

public class SpotCheckRequest {
	Double lat;
	Double lon;
	CountryEnum country;
	Column column;
}
