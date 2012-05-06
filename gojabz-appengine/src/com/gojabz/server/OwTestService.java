package com.gojabz.server;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OwTestService extends HttpServlet {

	private static final long serialVersionUID = -8237270753703937892L;

	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println( "called doPost() in OwTestService!" );
		response.addHeader( "OwTestHeader", "POST" );
	}

	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response )
	{
		System.out.println( "called doGet() in OwTestService!" );
		response.addHeader( "OwTestHeader", "GET" );
	}
}
