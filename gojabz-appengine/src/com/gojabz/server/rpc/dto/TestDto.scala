package com.gojabz.server.rpc.dto

class TestDto( val code: Int, val message: String ) {
  def this() = this( 0, "" )	// gson needs default constructor
}
