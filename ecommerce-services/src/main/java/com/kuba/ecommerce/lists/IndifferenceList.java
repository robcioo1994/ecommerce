package com.kuba.ecommerce.lists;

import javafx.util.Pair;
import com.kuba.ecommerce.models.Attribute;
import com.kuba.ecommerce.models.MyPair;
import com.kuba.ecommerce.models.Object;

import java.util.ArrayList;
import java.util.List;

public class IndifferenceList extends ArrayList<Pair<ArrayList<MyPair>,ArrayList<Object>>>{

    public Pair<ArrayList<MyPair>, ArrayList<Object>> getIndifference(List<MyPair> attributeEvaluations) {
        for(int i =0; i < size(); i++) {
            boolean matches = true;
            List<MyPair> current = get(i).getKey();
            for(int j = 0; j<attributeEvaluations.size(); j++) {
                if(!attributeEvaluations.get(j).value.isEqual(current.get(j).value)) matches = false;
            }
            if(matches) {
                return get(i);
            }
        }
        return null;
    }

    public void print() {
        System.out.print("{");
        for(int i = 0; i<size(); i++) {
            Pair<ArrayList<MyPair>,ArrayList<Object>> pair = get(i);
            System.out.print("{");
            for(Object object : pair.getValue()) {
                System.out.print(object.toString());
            }
            System.out.print("}");
        }
        System.out.print("}\n");
    }
}
