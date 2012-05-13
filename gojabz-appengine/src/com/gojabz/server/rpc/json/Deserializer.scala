package com.gojabz.server.rpc.json

import com.gojabz.server.rpc.dto.TestDto
import com.google.gson.Gson

/*
 * for gson usage examples, view https://sites.google.com/site/gson/gson-user-guide
 *
 * also have a look at the doc for instance creators:
 * http://google-gson.googlecode.com/svn/tags/1.2.3/docs/javadocs/com/google/gson/InstanceCreator.html
 */

object Deserializer {
	def deserialize( input: String ): TestDto = {
		val gson = new Gson
		gson.fromJson( input, classOf[TestDto] )
	}
}