package com.gojabz.server

import java.lang.reflect.Method

class RpcMethodDispatcher( val basePackage: String ) {

  private def searchRpcMethod( aClass: Class[_], methodName: String ): Method = {
    val method = aClass.getMethod( methodName )
    method
  }

  private def searchRpcClass( className: String ): Class[_] = {
    val aClass = Class.forName( basePackage + className )
    println( "found class " + aClass.getName )
    aClass
  }

  def runRpcMethod( rpcClassName: String, rpcMethodName: String ) = {
    val rpcClass = searchRpcClass( rpcClassName )
    val rpcClassInstance = rpcClass.getConstructor().newInstance()
    val rpcMethod = searchRpcMethod( rpcClass, rpcMethodName )

    println( "invoking method " + rpcMethod.getName + " on instance of "
        + rpcClassInstance.getClass.getName + "..." )
    rpcMethod.invoke( rpcClassInstance )
    println( "done with " + rpcMethod.getName )
  }
}
