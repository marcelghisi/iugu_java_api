package com.iugu.serializers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonDeserializer;

public class PropertyObjectDeserializer extends JsonDeserializer<Map<String,String>> {
	
	
	@Override
	public Map<String, String> deserialize(JsonParser parser,
			org.codehaus.jackson.map.DeserializationContext context)
			throws IOException, JsonProcessingException {
		 Map<String, String>  retMap = 
             new HashMap<String, String>();

//		 //Map<String, String> map = new Gson().fromJson(jsonInput, new TypeToken<Map<String, String>>() {}.getType());
//		  TypeToken<HashMap<String,String>[]>  typeRef = new TypeToken< HashMap<String,String>[] >() {};
//            
//            ObjectMapper mapper = new ObjectMapper(); 
//            HashMap<String, String>[] maps = mapper.readValue(parser, typeRef);
//            
//            for (HashMap<String, String> oneMap : maps){ 
//                String name = oneMap.get("key"); 
//                String value = oneMap.get("value"); 
//                retMap.put(name, value);    
//          }        
          return retMap;
                    
    	}

}
