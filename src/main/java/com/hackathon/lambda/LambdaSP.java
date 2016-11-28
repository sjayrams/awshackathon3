package com.hackathon.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaSP implements RequestHandler<SpotPredictRequest,SpotPredictResponse>{

	@Override
	public SpotPredictResponse handleRequest(SpotPredictRequest arg0, Context arg1) {
		SpotPredictResponse spr=new SpotPredictResponse();
		spr.value=1.00;
		return spr;
	}

}
