package com.gojabz.server.rpc

import com.gojabz.server.rpc.dto.BaseDto

trait Serializer {

  def serialize( clazz: Class[_ <: BaseDto], obj: BaseDto ): String
  def deserialize( clazz: Class[_ <: BaseDto], input: String): BaseDto

}