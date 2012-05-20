package com.gojabz.server.rpc

import com.gojabz.server.rpc.dto.BaseDto

trait Deserializer {

  def deserialize( clazz: Class[_ <: BaseDto], input: String): BaseDto

}