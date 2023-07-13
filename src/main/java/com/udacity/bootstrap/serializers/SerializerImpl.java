package com.udacity.bootstrap.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;


import java.util.Map;
@Component
public class SerializerImpl<T> implements Serializer<T>{
    @Override public void configure(Map<String, ?> map, boolean b) {

    }

    @Override public byte[] serialize( T arg1) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retVal = objectMapper.writeValueAsString(arg1).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }

    @Override public void close() {

    }

}

