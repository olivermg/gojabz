package com.gojabz.server.rpc

import com.gojabz.server.rpc.json.JsonDeserializer

object DeserializerFactory {

  private var deserializerClass: Class[_ <: Deserializer] = classOf[JsonDeserializer]

  def setDeserializerClass( clazz: Class[_ <: Deserializer] ) = {
    this.deserializerClass = clazz
  }

  def getInstance: Deserializer = {
    val constructor = this.deserializerClass.getConstructor()
    constructor.newInstance()
  }
}