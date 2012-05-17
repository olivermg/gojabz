package com.gojabz.server.rpc

import com.gojabz.server.rpc.dto.TestDto
import com.gojabz.server.rpc.dto.BaseDto

class RpcBlaClass extends RpcClass {

  def getRequestObject(): Class[_ <: BaseDto] = {
    classOf[TestDto]
  }

  def getResponseObject(): Class[_ <: BaseDto] = {
    classOf[TestDto]
  }

  protected def labern = {
    println("ich labere jetzt!")
  }
}