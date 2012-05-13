package com.gojabz.server

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import com.gojabz.server.rpc.json.Deserializer
import com.gojabz.server.rpc.dto.TestDto

class OwTestScalaService extends HttpServlet {

  override def doGet(request: HttpServletRequest, response: HttpServletResponse) = {
    println("called scala doGet()!")
    response.getOutputStream.print("called scala doGet() from URI "
      + request.getPathInfo + ", " + request.getQueryString)
    val rpcDispatcher = new RpcMethodDispatcher("com.gojabz.server")
    val rpcClassName = request.getPathInfo.replace('/', '.')
    rpcDispatcher.runRpcMethod(rpcClassName, request.getQueryString)
    
    // test json deserializer:
    val testDto = Deserializer.deserialize( "{ code:3, message:\"blabla\" }" )
    println( "code: " + testDto.code + ", message: " + testDto.message )
  }

  protected def labern = {
    println("ich labere jetzt!")
  }
}