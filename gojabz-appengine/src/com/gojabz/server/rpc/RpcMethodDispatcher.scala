package com.gojabz.server.rpc

import java.lang.reflect.Method
import com.gojabz.server.rpc.dto.BaseDto

class RpcMethodDispatcher( val basePackage: String ) {

  private def searchRpcMethod( aClass: Class[RpcClass], methodName: String ): Method = {
    val method = aClass.getMethod( methodName )
    method
  }

  private def searchRpcClass( className: String ): Class[RpcClass] = {
    val aClass = Class.forName( basePackage + className )
    println( "found class " + aClass.getName )
    val rpcClass = aClass match {
      case c: Class[RpcClass] => c
      case _ => throw new IllegalArgumentException
    }
    rpcClass
  }

  private def deserializeRequestDto( dtoClazz: Class[_ <: BaseDto], rpcData: String ): BaseDto = {
    val serializer = SerializerFactory.getInstance
    val deserialized = serializer.deserialize( dtoClazz, rpcData )
    val deserializedDto = deserialized match {
      case d: BaseDto => d
      case _ => throw new IllegalArgumentException
    }
    deserializedDto
  }

  def runRpcMethod( rpcClassName: String, rpcMethodName: String, rpcData: String ): BaseDto = {
    val rpcClass = searchRpcClass( rpcClassName )
    val rpcClassInstance = rpcClass.getConstructor().newInstance()
    val rpcMethod = searchRpcMethod( rpcClass, rpcMethodName )
    val requestDtoType = rpcClassInstance.getRequestObject
    val requestDto = deserializeRequestDto( requestDtoType, rpcData )

    println( "invoking method " + rpcMethod.getName + " on instance of "
        + rpcClassInstance.getClass.getName + " with dtoType " + requestDto.getClass.getName + "..." )
    val responseObj = rpcMethod.invoke( rpcClassInstance )
    val responseDtoType = rpcClassInstance.getResponseObject
    // TODO: figure out how to cast responseObj to responseDtoType:
    val responseDto = responseObj.asInstanceOf[BaseDto]
    println( "done with " + rpcMethod.getName )
    responseDto
  }
}
