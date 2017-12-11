package com.paytoplay.utils;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

public class CommonUtil {
    /**
     *
     * @param source modifiable no threadsafe set
     * @param <T> entity type
     * @return unmodifiable threadsafe set of objects
     */
    public static <T> Set<T> getSafeSet (Set<T> source){
        return Collections.unmodifiableSet(Optional.ofNullable(source).orElse(Collections.emptySet()));
    }
}
