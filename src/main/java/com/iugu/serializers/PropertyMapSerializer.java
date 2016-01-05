package com.iugu.serializers;

import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.jboss.logging.Property;

public class PropertyMapSerializer extends JsonSerializer<Map<String,String>> {

	@Override
	public void serialize(Map<String,String> data, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
//		Property values[] = new Property[data.size()];
//		int i = 0;
//		for(String key: data.keySet()){
//			values[i++] = new Property(key, data.get(key));
//		}
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.writeValue(generator, values);
	}

}
