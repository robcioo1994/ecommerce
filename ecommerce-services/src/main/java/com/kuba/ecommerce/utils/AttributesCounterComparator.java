package com.kuba.ecommerce.utils;

import com.kuba.ecommerce.lists.AttributeCounterList;
import com.kuba.ecommerce.lists.auxiliary.AttributeCounter;

public class AttributesCounterComparator implements java.util.Comparator<AttributeCounter> {

    @Override
    public int compare(AttributeCounter o1, AttributeCounter o2) {
        return o1.count - o2.count;
    }


}