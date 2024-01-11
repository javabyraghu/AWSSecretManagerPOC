package com.app.raghu.util;

import com.app.raghu.entity.SFCustomKeys;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	public static SFCustomKeys convertToType(String secret) {
		try {
			return new ObjectMapper().readValue(secret, SFCustomKeys.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
