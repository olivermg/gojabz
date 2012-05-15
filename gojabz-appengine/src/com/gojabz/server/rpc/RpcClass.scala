package com.gojabz.server.rpc

trait RpcClass {
	def getRequestObject: Any
	def getResponseObject: Any
}
