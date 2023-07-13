package com.udacity.bootstrap.deserializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class DeSerializerImpl<T> implements DeSerializer<T> {

    @Override
    public void configure(Map<String, ?> var1, boolean var2) {

    }

    @Override
    public T deserialize(Class<T> tClass,byte[] var1) {
        ObjectMapper mapper = new ObjectMapper();
        T t = null;
        try {
            t = mapper.readValue(var1, tClass);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return t;
    }


    @Override
    public void close() {

    }
}
