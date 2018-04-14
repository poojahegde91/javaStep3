package com.stackroute.datamunger.query;

import static org.hamcrest.CoreMatchers.nullValue;

//header class
public class Header {

	/*
	 * this class should contain a member variable which is a String array, to hold
	 * the headers.
	 */
	//private String headers;
	private String [] headers;
	

	public void setHeaders(String [] headers) {
		this.headers = headers;
	}



	public String[] getHeaders() {
		
		return headers;
	}

}
