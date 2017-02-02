package com.kuba.ecommerce.lists;

import com.kuba.ecommerce.lists.auxiliary.AttributeCounter;
import com.kuba.ecommerce.models.Attribute;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AttributesList extends ArrayList<Attribute> {

    public static AttributeCounterList countAttributes(AttributesList[][] attDiffMatrix) {
        AttributeCounterList counterList = new AttributeCounterList();
        for(int row = 0; row<attDiffMatrix.length; row++) {
            for(int col = 0; col<attDiffMatrix.length; col++) {
                List<Attribute> attributes = attDiffMatrix[row][col];
                for(Attribute attribute : attributes) {
                    AttributeCounter count = counterList.getForAttribute(attribute);
                    if(count != null) {
                        counterList.set(count.index, new AttributeCounter(count.index, attribute, count.count + 1));
                    } else {
                        counterList.add(new AttributeCounter(attribute));
                    }
                }
            }
        }
        return counterList;
    }

    public boolean contains(Attribute attribute) {
        for(Attribute a : this) {
            if(a.equals(attribute)) return true;
        }
        return false;
    }

    public boolean contains(AttributesList other) {
        if(this.size() < other.size()) return false;
        findAttributes: for(int i = 0; i<other.size(); i++) {
            Attribute toFind = other.get(i);
            for(int j = 0; j<this.size(); j++) {
                if(this.get(j).equals(toFind)) continue findAttributes;
            }
            return false;
        }
        return true;
    }

    public boolean equals(AttributesList other) {
        if(this.size() != other.size()) return false;
        else {
            for(int i = 0; i<this.size(); i++) {
                Attribute attribute = this.get(i);
                boolean foundSameAttribute = false;
                checkForSameAttribute : for(int j = 0; j<other.size(); j++) {
                    if(other.get(j).equals(attribute)) {
                        foundSameAttribute = true;
                        break checkForSameAttribute;
                    }
                }
                if(!foundSameAttribute) return false;
            }
            return true;
        }
    }
}
