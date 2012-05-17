package com.gojabz.server.rpc

import com.gojabz.server.rpc.dto.BaseDto

trait RpcClass {
	def getRequestObject: Class[_ <: BaseDto]
	def getResponseObject: Class[_ <: BaseDto]
}
