package com.kuba.ecommerce.lists;

import com.kuba.ecommerce.models.Attribute;

import java.util.ArrayList;

public class AttributesSpecifications extends ArrayList<AttributesSpecifications.AttributeSpecification> {

    public AttributeSpecification getSpecsByAttribute(Attribute attribute) {
        for(int i =0 ; i<this.size(); i++) {
            if(this.get(i).getAttribute().equals(attribute)) return this.get(i);
        }
        return null;
    }

    public static class AttributeSpecification {

        private Attribute attribute;
        private double meanValue;
        private double standardDeviation;

        public AttributeSpecification(Attribute attribute, double meanValue, double standardDeviation) {
            this.attribute = attribute;
            this.meanValue = meanValue;
            this.standardDeviation = standardDeviation;
        }

        public Attribute getAttribute() {
            return attribute;
        }

        public double getMeanValue() {
            return meanValue;
        }

        public double getStandardDeviation() {
            return standardDeviation;
        }

    }
}
