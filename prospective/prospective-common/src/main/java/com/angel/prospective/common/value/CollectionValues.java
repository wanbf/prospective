package com.angel.prospective.common.value;

import java.util.Collection;

/**
 * Created by wanbf on 2017/11/17.
 */
public final class CollectionValues {
    public static boolean isNullOrEmpty(Collection<?> value) {
        return value == null || value.isEmpty();
    }

    private CollectionValues() {
    }
}
