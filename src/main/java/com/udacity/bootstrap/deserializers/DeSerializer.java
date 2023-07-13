package com.udacity.bootstrap.deserializers;



import java.io.Closeable;
import java.util.Map;

public interface DeSerializer<T> extends Closeable {
    void configure(Map<String, ?> var1, boolean var2);

    T deserialize(Class<T> tClass,byte[] var1);

    void close();
}