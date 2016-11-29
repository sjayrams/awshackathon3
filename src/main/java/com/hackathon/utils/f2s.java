package com.hackathon.utils;

import java.io.BufferedReader;
import java.io.FileReader;

public class f2s {

	public static String getString(){
		try(BufferedReader br = new BufferedReader(new FileReader("template.html"))) {
	    String out="";
			for(String line; (line = br.readLine()) != null; ) {
	        out+=line+"\n";
	    }
	    return out;
	    // line is not isible here.
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args){
	System.out.println(	f2s.getString());
	}
}
