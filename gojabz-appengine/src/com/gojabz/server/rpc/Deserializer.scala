package com.gojabz.server.rpc

trait Deserializer {

  def deserialize( clazz: Class[_], input: String): Any

}