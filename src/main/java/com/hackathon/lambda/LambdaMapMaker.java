package com.hackathon.lambda;

import java.awt.Point;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.googlecode.charts4j.GeographicalArea;
import com.googlecode.charts4j.MapChart;
import com.hackathon.AAA;
import com.hackathon.AAADal;
import com.hackathon.utils.RestClient;
import com.hackathon.utils.f2s;

public class LambdaMapMaker implements RequestHandler<SpotPredictRequest, MapResponse> {
	public static AAADal dao=getdao();
	public static RestClient rc=new RestClient();

	@Override
	public MapResponse handleRequest(SpotPredictRequest mr, Context arg1) {
		try {
			int index=0;
			List<AAA> somepoints=dao.getRandomLocationData("UGA");
			ArrayList<Deltas> deltas=new ArrayList<Deltas>();
			for(AAA alpha:somepoints){
				List<AAA> points=dao.getData(alpha.getLat(), alpha.getLon());
				AAA fromServer=points.get(0);
				SpotPredictRequestML scrml=new SpotPredictRequestML();
				scrml.country=fromServer.getCountry();
				scrml.landscape=fromServer.getLandscape();
				scrml.latitude=fromServer.getLat();
				scrml.longitude=fromServer.getLon();
				scrml.column="CIAF";
				PredictionML pml=rc.post("https://i96lpa9xz4.execute-api.us-east-1.amazonaws.com/mock/predict", scrml.toJson(), PredictionML.class);
				System.out.println(alpha.getCountry()+"\t"+alpha.getLat());
				Deltas delta=new Deltas();
				delta.lat=Double.parseDouble(fromServer.getLat());
				delta.lon=Double.parseDouble(fromServer.getLon());
				delta.accuracy=1-Math.abs(Double.parseDouble(fromServer.getCiaf())-pml.Prediction.predictedValue);
				index++;
				System.out.println(index+"\t"+delta);
				deltas.add(delta);
			}
			String intermediate="";
			for(Deltas d:deltas){
				intermediate+=d.toChart()+"\n";
			}
			String tr=f2s.getString();
			String output=String.format(tr, intermediate);
			write(output,"output.html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private void write(String output, String file) {
		try(  PrintWriter out = new PrintWriter( file)  ){
		    out.println( output );
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("fine");
	}

	private static AAADal getdao() {
		try {
			return new AAADal();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args){
		LambdaMapMaker lmm=new LambdaMapMaker();
		lmm.handleRequest(null, null);
	}

}
