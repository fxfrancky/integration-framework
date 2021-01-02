package com.domain.tools;

import java.util.Collection;

public class CollectionsUtils {

    public static boolean isNullOrEmptyCollection(Collection < ? > collection){
        return (collection==null || collection.isEmpty());
    }
}
