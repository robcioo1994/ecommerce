package com.kuba.ecommerce.models;

import com.kuba.ecommerce.lists.AttributesList;

import java.util.ArrayList;
import java.util.List;

public class Implicant {

    private Record record;
    private com.kuba.ecommerce.models.Object object;
    private KeyAttribute keyAttribute;
    private List<AttributesList> elements;

    public Implicant(Record record) {
        this.record = record;
        this.object = record.getObject();
        this.keyAttribute = record.getKeyAttribute();
        this.elements = new ArrayList<>();
    }

    public com.kuba.ecommerce.models.Object getObject() {
        return object;
    }

    public void setObject(com.kuba.ecommerce.models.Object object) {
        this.object = object;
    }

    public KeyAttribute getKeyAttribute() {
        return keyAttribute;
    }

    public void setKeyAttribute(KeyAttribute keyAttribute) {
        this.keyAttribute = keyAttribute;
    }

    public List<AttributesList> getElements() {
        return elements;
    }

    public void setElements(List<AttributesList> elements) {
        this.elements = elements;
    }

    public Record getRecord() {
        return record;
    }

    public Implicant optimize(boolean simple) {
        //region remove same attributes
        List<AttributesList> toDelete = new ArrayList<>();
        for(AttributesList attributeList : this.elements) {
            for(AttributesList list : this.elements) {
                if(list != attributeList) {
                    if(attributeList.equals(list)) {
                        if(!toDelete.contains(list))
                            toDelete.add(attributeList);
                    }
                }
            }
        }
        for(AttributesList delete : toDelete) {
            this.elements.remove(delete);
        }
        //endregion remove same attributes

        //region simple optimization
        toDelete = new ArrayList<>();
        for(AttributesList attributeList : this.elements) {
            for(AttributesList list : this.elements) {
                if(list != attributeList) {
                    if(list.contains(attributeList)) {
                        toDelete.add(list);
                    }
                }
            }
        }
        for(AttributesList delete : toDelete) {
            this.elements.remove(delete);
        }
        //endregion simple optimization
        return this;
    }
}
