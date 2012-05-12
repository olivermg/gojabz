package com.gojabz.server

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class OwTestScalaService extends HttpServlet {

  override def doGet(request: HttpServletRequest, response: HttpServletResponse) = {
    println("called scala doGet()!")
    response.getOutputStream.print("called scala doGet() from URI "
      + request.getPathInfo + ", " + request.getQueryString)
    val rpcDispatcher = new RpcMethodDispatcher("com.gojabz.server")
    val rpcClassName = request.getPathInfo.replace('/', '.')
    rpcDispatcher.runRpcMethod(rpcClassName, request.getQueryString)
  }

  protected def labern = {
    println("ich labere jetzt!")
  }
}