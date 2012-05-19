package com.gojabz.server.rpc

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import com.gojabz.server.rpc.dto.TestDto
import com.gojabz.server.rpc.json.Deserializer

class RpcServlet extends HttpServlet {

    override def doGet(request: HttpServletRequest, response: HttpServletResponse) = {
    println("called scala doGet()!")
    response.getOutputStream.print("called scala doGet() from URI "
      + request.getPathInfo + ", " + request.getQueryString)
    val rpcDispatcher = new RpcMethodDispatcher("com.gojabz.server.rpc")
    val rpcClassName = request.getPathInfo.replace('/', '.')
    rpcDispatcher.runRpcMethod(rpcClassName, request.getQueryString)

    // test json deserializer:
    val deserialized = Deserializer.deserialize( "{ code:3, message:\"json parsed!\" }", classOf[TestDto] )
    // type casting (maybe we can improve this):
    val testDto = deserialized match {
      case d: TestDto => d
      case _ => throw new IllegalArgumentException
    }
    println( "code: " + testDto.code + ", message: " + testDto.message )
  }

}