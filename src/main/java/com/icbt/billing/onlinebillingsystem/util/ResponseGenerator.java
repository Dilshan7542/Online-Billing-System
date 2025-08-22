package com.icbt.billing.onlinebillingsystem.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icbt.billing.onlinebillingsystem.dto.UserDTO;

public class ResponseGenerator {
  static ObjectMapper mapper = new ObjectMapper();
    public static String generateSuccessResponse(Object body,String message) {
        try {
       return mapper.writeValueAsString(new ResponseEntity<>("000",message,body));
        } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
        }
    }
    public static String generateErrorResponse(Object body,String message) {
        try {
            return mapper.writeValueAsString(new ResponseEntity<>("001",message,body));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
