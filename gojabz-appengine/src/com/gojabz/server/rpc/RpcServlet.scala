package com.gojabz.server.rpc

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import com.gojabz.server.rpc.dto.TestDto
import com.gojabz.server.rpc.json.JsonSerializer

class RpcServlet extends HttpServlet {

  private val basePackage = "com.gojabz.server.rpc"

  override def doPost(request: HttpServletRequest, response: HttpServletResponse) = {
    println("called scala doGet() from URI " + request.getPathInfo + ", " + request.getQueryString)
    val rpcDispatcher = new RpcMethodDispatcher( basePackage )
    val rpcClassName = request.getPathInfo.replace('/', '.')
    val rpcBody = request.getReader.readLine
    println( "body: " + rpcBody )

    // TODO: make method name the last element of the path instead of the query string:
    val responseDto = rpcDispatcher.runRpcMethod(rpcClassName, request.getQueryString, rpcBody)
    
    // TODO: just a test here. figure out sane logic without explicit type casting:
    val testDto = responseDto.asInstanceOf[TestDto]
    println( "code: " + testDto.code + ", message: " + testDto.message )

    // TODO: find out response dto class properly:
    val serializer = SerializerFactory.getInstance
    response.getOutputStream.print( serializer.serialize( classOf[TestDto], responseDto ) + "\n" )
  }
}