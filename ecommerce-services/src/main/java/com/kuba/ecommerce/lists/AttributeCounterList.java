package com.kuba.ecommerce.lists;

import javafx.util.Pair;
import com.kuba.ecommerce.lists.auxiliary.AttributeCounter;
import com.kuba.ecommerce.models.Attribute;
import com.kuba.ecommerce.utils.IndexWrapper;

import java.util.ArrayList;

public class AttributeCounterList extends ArrayList<AttributeCounter> {


    public AttributeCounter getForAttribute(Attribute attribute) {
        for(int i =0; i<size(); i++) {
            if(get(i).attribute.equals(attribute)) {
                return get(i);
            }
        }
        return null;
    }

    @Override
    public boolean add(AttributeCounter attributeCounter) {
        attributeCounter.index = size();
        return super.add(attributeCounter);
    }

    public static Attribute getBest(AttributeCounterList attributes) {
        AttributeCounter best = null;
        for(AttributeCounter attribute : attributes) {
            if (best == null) best = attribute;
            else if (attribute.count > best.count) best = attribute;
        }
        return best != null ? best.attribute : null;
    }
}
