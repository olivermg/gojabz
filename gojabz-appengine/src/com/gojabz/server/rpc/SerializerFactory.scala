package com.gojabz.server.rpc

import com.gojabz.server.rpc.json.JsonSerializer

object SerializerFactory {

  private var serializerClass: Class[_ <: Serializer] = classOf[JsonSerializer]

  def setSerializerClass( clazz: Class[_ <: Serializer] ) = {
    this.serializerClass = clazz
  }

  def getInstance: Serializer = {
    val constructor = this.serializerClass.getConstructor()
    constructor.newInstance()
  }
}