package com.gojabz.server.rpc.json

import com.gojabz.server.rpc.dto.TestDto
import com.google.gson.Gson

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

object Deserializer {
	def deserialize( input: String, clazz: Class[_] ): Any = {
		val gson = new Gson
		gson.fromJson( input, clazz )
	}
}