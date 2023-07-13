package com.udacity.bootstrap.serializers;

import com.udacity.bootstrap.entity.AirTag;

import java.io.Closeable;
import java.util.Map;

public interface Serializer<T> extends Closeable {
    void configure(Map<String, ?> var1, boolean var2);

    byte[] serialize(T var1);

    void close();
}