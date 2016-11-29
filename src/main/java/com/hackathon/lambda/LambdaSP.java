package com.hackathon.lambda;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.hackathon.utils.RestClient;

import swagger.model.Query.CountryEnum;

public class LambdaSP implements RequestHandler<SpotPredictRequest,SpotPredictResponse>{

	@Override
	public SpotPredictResponse handleRequest(SpotPredictRequest spr, Context arg1) {
		RestClient rc=new RestClient();
		SpotPredictRequestML sprml=new SpotPredictRequestML();
		sprml.country=spr.country.name();
		sprml.landscape=spr.landscape.name();
		sprml.latitude=spr.lat.toString();
		sprml.longitude=spr.lon.toString();
		sprml.column=spr.column.name();
		PredictionML pml=rc.post("https://i96lpa9xz4.execute-api.us-east-1.amazonaws.com/mock/predict", sprml.toJson(), PredictionML.class);
		SpotPredictResponse spresponse=new SpotPredictResponse();
		System.out.println(pml.toString());
		spresponse.value=pml.Prediction.predictedValue;
		System.out.println(spresponse.toString());
		return spresponse;
	}
	public static void main(String[] args){
		LambdaSP sp=new LambdaSP();
		SpotPredictRequest spr=new SpotPredictRequest();
		spr.column=Column.ACCESS;
		spr.landscape=LandscapeEnum.L000;
		spr.lat=39.661;
		spr.lon=-19.667;
		spr.country=CountryEnum.GHN;
		sp.handleRequest(spr,null);
		spr.country=CountryEnum.KEN;
		sp.handleRequest(spr,null);
		spr.country=CountryEnum.RWA;
		sp.handleRequest(spr, null);
	}
}
