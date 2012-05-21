package com.gojabz.server.rpc.json

import com.gojabz.server.rpc.dto.TestDto
import com.google.gson.Gson
import com.gojabz.server.rpc.Serializer
import com.gojabz.server.rpc.dto.BaseDto

/*
 * for gson usage examples, view https://sites.google.com/site/gson/gson-user-guide
 *
 * also have a look at the doc for instance creators:
 * http://google-gson.googlecode.com/svn/tags/1.2.3/docs/javadocs/com/google/gson/InstanceCreator.html
 * 
 * later on, we maybe also want to use custom (de)serializers for our DTOs:
 * https://sites.google.com/site/gson/gson-user-guide#TOC-Custom-Serialization-and-Deserialization
 * this would be necessary to enforce parameter checking for JSON requests
 */

class JsonSerializer extends Serializer {

	override def deserialize( clazz: Class[_ <: BaseDto], input: String ): BaseDto = {
		val gson = new Gson
		gson.fromJson( input, clazz )
	}

	override def serialize( clazz: Class[_ <: BaseDto], obj: BaseDto ): String = {
		val gson = new Gson
		gson.toJson( obj )
	}
}
