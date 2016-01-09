package com.iugu.serializers;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public abstract class ErrorDeserializer extends JsonDeserializer<String> {

	  @Override
	  public String deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		  
		  
	        JsonToken firstToken = jp.getCurrentToken();
	        if (firstToken == JsonToken.START_ARRAY) {
	        	System.out.println("STARTARRAY");
	        }
	        
	        if (firstToken == JsonToken.START_OBJECT) {
	        	System.out.println("STARTOBJECT");
	        }
	        
	        if (firstToken == JsonToken.VALUE_STRING) {
	        	System.out.println("VALUE STRING");
	        }
	        
	        return null;
	  }
}
