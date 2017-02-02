package com.kuba.ecommerce.utils;

import com.kuba.ecommerce.models.values.FuzzyRange;

public class ValuesUtils {

    public static boolean inFuzzyRange(Double value, FuzzyRange range) {
        return value >= range.getStartValue() && value <= range.getEndValue();
    }
}
