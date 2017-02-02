package com.kuba.ecommerce.models;

import com.kuba.ecommerce.models.values.FuzzyValue;

/**
 * Simple 2-element relation
 */
public class Relation<Item extends FuzzyRelationElement, Attribute extends FuzzyRelationElement> {

    private Item itemA;
    private Attribute itemB;
    private FuzzyValue value;

    public Relation(Item itemA, Attribute itemB, FuzzyValue value) {
        this.itemA = itemA;
        this.itemB = itemB;
        this.value = value;
    }

    public Item getItem() {
        return itemA;
    }

    public Attribute getAttribute() {
        return itemB;
    }

    public FuzzyValue getRelationValue() {
        return value;
    }
}
