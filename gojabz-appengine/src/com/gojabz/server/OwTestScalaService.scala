package com.gojabz.server

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class OwTestScalaService extends HttpServlet {

  override def doGet(request: HttpServletRequest, response: HttpServletResponse) = {
	  println( "called scala doGet()!" )
	  response.getOutputStream.print("called scala doGet()")
	  val rpcDispatcher = new RpcMethodDispatcher
	  rpcDispatcher.runRpcMethod("blabla")
  }
}