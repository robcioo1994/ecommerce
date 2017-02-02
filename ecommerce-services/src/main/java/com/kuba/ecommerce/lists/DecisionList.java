package com.kuba.ecommerce.lists;

import javafx.util.Pair;
import com.kuba.ecommerce.models.KeyAttribute;
import com.kuba.ecommerce.models.Object;

import java.util.ArrayList;
import java.util.List;

public class DecisionList extends ArrayList<Pair<KeyAttribute,List<Object>>> {

    public Pair<KeyAttribute,List<Object>> getDecisionList(KeyAttribute keyAttribute) {
        for(int i = 0; i < size(); i++) {
            if(get(i).getKey().equals(keyAttribute)) return get(i);
        }
        return null;
    }
}
