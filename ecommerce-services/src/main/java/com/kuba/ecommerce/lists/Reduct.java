package com.kuba.ecommerce.lists;

import com.kuba.ecommerce.models.Attribute;

import java.util.ArrayList;


public class Reduct extends ArrayList<Attribute> {

    public boolean containsAttribute(Attribute attribute) {
        for(int i = 0; i< this.size(); i++) {
            if(this.get(i).equals(attribute)) return true;
        }
        return false;
    }
}
