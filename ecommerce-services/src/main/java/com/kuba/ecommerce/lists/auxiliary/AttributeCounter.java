package com.kuba.ecommerce.lists.auxiliary;

import com.kuba.ecommerce.models.Attribute;


public class AttributeCounter {

    public int index;
    public Attribute attribute;
    public int count;

    public AttributeCounter(Attribute attribute) {
        this.attribute = attribute;
        this.count = 1;
    }

    public AttributeCounter(Attribute attribute, int count) {
        this.attribute = attribute;
        this.count = count;
    }

    public AttributeCounter(int index, Attribute attribute, int count) {
        this.index = index;
        this.attribute = attribute;
        this.count = count;
    }
}
