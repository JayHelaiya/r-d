package com.jay.customer.utility;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * This util is used to convert json to object & object to json.
 * @author Mobifin Java Team
 *
 */
@SuppressWarnings("unchecked")
public class JsonUtil {
	
	private JsonUtil(){
	}
    
	private static ObjectMapper mapper = new ObjectMapper();
    
	static{
    	mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, Boolean.FALSE);
    }

	public static <T> T toObject(final byte[] json, Class<?> aClass)  {
    	try {
    		  return (T) mapper.readValue(json, aClass);
		} catch (IOException e) {
		}
		return null;
      
    }

   public static String toJson(Object aClass) {
	    try{
	    	if(aClass == null){
	    		return "";
	    	}
	    	return mapper.writeValueAsString(aClass);
	    } catch (IOException e) {
	    	//LoggerService.exception("UTIL", "Invalid JSON", e);
	    	//throw new MobifinX1Exception(ResponseCode.UNABLE_TO_PARSE_JSON);
		}
	    return null;
    }
    
   /*public static String getValueOfSpecificKeyFromJsonData(String jsonString, String key) throws MobifinX1Exception{
		try{
			JsonNode actualObj = mapper.readTree(jsonString);
			if(actualObj != null){
				JsonNode jsonNode = actualObj.get(key);
				if(jsonNode!=null){
					return jsonNode.asText();
				}
			}
		} catch (IOException e) {
			LoggerService.exception("UTIL", "Invalid JSON", e);
			throw new MobifinX1Exception(ResponseCode.UNABLE_TO_PARSE_JSON);
		}
		return null;
	}
	
    public static <K extends Object, V extends Object> Map<K, V> toSingleMap(String jsonStr) throws MobifinX1Exception{
		try {
			return mapper.readValue(jsonStr, new TypeReference<HashMap<Object,Object>>(){});
		} catch (IOException e) {
			LoggerService.exception("UTIL", "Invalid JSON", e);
			throw new MobifinX1Exception(ResponseCode.UNABLE_TO_PARSE_JSON);
		}
	}
	
    
    public static <K extends Object, V extends Object> Map<K, V> toMap(String jsonStr) throws MobifinX1Exception{
		try {
			return mapper.readValue(jsonStr, new TypeReference<HashMap<String,Map<String,String>>>(){});
		} catch (IOException e) {
		LoggerService.exception("UTIL", "Invalid JSON", e);
			throw new MobifinX1Exception(ResponseCode.UNABLE_TO_PARSE_JSON);
		}
	}*/
}