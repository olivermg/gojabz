package com.gojabz.server

import java.lang.reflect.Method

class RpcMethodDispatcher {

  private def searchRpcMethod(method: String): Array[Method] = {
    val aClass = this.getClass
    println("this name: " + aClass.getName)
    val methods = aClass.getMethods
    methods
  }

  def runRpcMethod(method: String) = {
    val methods = searchRpcMethod(method)
    methods.foreach(m => println(m.getName))
  }
}