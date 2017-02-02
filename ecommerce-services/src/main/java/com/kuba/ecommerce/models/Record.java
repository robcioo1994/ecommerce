package com.kuba.ecommerce.models;

import com.google.gson.annotations.SerializedName;
import com.kuba.ecommerce.lists.AttributesList;
import com.kuba.ecommerce.models.values.Value;

import java.lang.*;
import java.util.List;

public class Record<T extends Value> {

    @SerializedName("item")
    protected com.kuba.ecommerce.models.Object item;
    @SerializedName("attributeEvaluations")
    protected List<MyPair<T>> attributeEvaluations;
    @SerializedName("keyAttribute")
    protected KeyAttribute keyAttribute;

    public Record(com.kuba.ecommerce.models.Object item, List<MyPair<T>> attributeEvaluations, KeyAttribute keyAttribute) {
        this.item = item;
        this.attributeEvaluations = attributeEvaluations;
        this.keyAttribute = keyAttribute;
    }



    public com.kuba.ecommerce.models.Object getObject() {
        return item;
    }

    public KeyAttribute getKeyAttribute() {
        return keyAttribute;
    }

    @Override
    public String toString() {
        return item.toString() + " " + keyAttribute.toString();
    }

    public AttributesList getDifferentAttributes(Record other) {
        AttributesList attributes = new AttributesList();
        for(int i=0;i<getAttributeEvaluations().size(); i++) {
            MyPair thisAttribute = getAttributeEvaluations().get(i);
            MyPair otherAttribute = ((List<MyPair>)other.getAttributeEvaluations()).get(i);
            //if(!thisAttribute.attribute.equals(otherAttribute.attribute)) continue;
            if(!(thisAttribute.value).isEqual(otherAttribute.value)) {
                attributes.add(thisAttribute.attribute);
            }
        }
        return attributes;
    }

    public MyPair getAttributeEvaluation(Attribute attribute) {
        for(MyPair pair : this.attributeEvaluations) {
            if(pair.attribute.equals(attribute)) return pair;
        }
        return null;
    }

    public void setAttributeEvaluations(List<MyPair<T>> attributeEvaluations) {
        this.attributeEvaluations = attributeEvaluations;
    }

    public List<MyPair<T>> getAttributeEvaluations() {
        return attributeEvaluations;
    }

    public void setKeyAttribute(KeyAttribute keyAttribute) {
        this.keyAttribute = keyAttribute;
    }
}
