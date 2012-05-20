package com.gojabz.server.rpc

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import com.gojabz.server.rpc.dto.TestDto
import com.gojabz.server.rpc.json.JsonDeserializer

class RpcServlet extends HttpServlet {

  private val basePackage = "com.gojabz.server.rpc"

  override def doGet(request: HttpServletRequest, response: HttpServletResponse) = {
    response.getOutputStream.print("called scala doGet() from URI "
      + request.getPathInfo + ", " + request.getQueryString)
    val rpcDispatcher = new RpcMethodDispatcher( basePackage )
    val rpcClassName = request.getPathInfo.replace('/', '.')
    // TODO: make method name the last element of the path instead of the query string:
    rpcDispatcher.runRpcMethod(rpcClassName, request.getQueryString)

    // test json deserializer:
    val deserializer = new JsonDeserializer
    val deserialized = deserializer.deserialize( classOf[TestDto],
        "{ code:3, message:\"json parsed!\" }" )
    // type casting (maybe we can improve this):
    val testDto = deserialized match {
      case d: TestDto => d
      case _ => throw new IllegalArgumentException
    }
    println( "code: " + testDto.code + ", message: " + testDto.message )
  }
}