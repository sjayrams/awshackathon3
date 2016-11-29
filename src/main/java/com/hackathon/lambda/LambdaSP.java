package com.hackathon.lambda;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.hackathon.utils.RestClient;

public class LambdaSP implements RequestHandler<SpotPredictRequest,SpotPredictResponse>{

	@Override
	public SpotPredictResponse handleRequest(SpotPredictRequest arg0, Context arg1) {
		RestClient rc=new RestClient();
		PredictionML pml=rc.post("https://i96lpa9xz4.execute-api.us-east-1.amazonaws.com/mock/predict", SpotPredictRequestML.sample().toJson(), PredictionML.class);
		SpotPredictResponse spr=new SpotPredictResponse();
		System.out.println(pml.toString());
		spr.value=pml.Prediction.predictedValue;
		System.out.println(spr.toString());
		return spr;
	}
	public static void main(String[] args){
		LambdaSP sp=new LambdaSP();
		sp.handleRequest(null,null);
	}
}
