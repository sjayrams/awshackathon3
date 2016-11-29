package com.hackathon.lambda;

import com.google.gson.Gson;

public class SpotPredictRequestML {

	public String column;
	public String landscape;
	public String latitude;
	public String longitude;
	public String country="TZA";
	
	public static SpotPredictRequestML sample(){
		SpotPredictRequestML out=new SpotPredictRequestML();
		out.column="ACCESS";
		out.country="TZA";
		out.landscape="L11";
		out.longitude="34.661";
		out.latitude="-10.067";
		return out;
		
		/**
		 *    "column":"ACCESS",
       "country": "TZA",
       "landscape": "L11",
       "longitude":"34.661",
       "latitude":"-10.067"
		 */
	}

	public String toJson() {
		Gson g=new Gson();
		return g.toJson(this);
	}
	public String toJson(SpotPredictRequestML in) {
		Gson g=new Gson();
		return g.toJson(in);
	}

}
