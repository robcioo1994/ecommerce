package com.kuba.ecommerce.models;

import javafx.util.Pair;
import com.kuba.ecommerce.lists.AttributeCounterList;
import com.kuba.ecommerce.lists.AttributesList;
import com.kuba.ecommerce.models.values.DiscreteValue;
import com.kuba.ecommerce.models.values.FuzzyValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rule {

    private final KeyAttribute keyAttribute;
    private List<Pair<Object, List<List<List<MyPair>>>>> elements;

    public Rule(KeyAttribute keyAttribute, List<Implicant> implicantList) {
        this.keyAttribute = keyAttribute;
        this.elements = new ArrayList<>();
        Map<Object, List<Implicant>> ruleElementsMap = new HashMap<>();
        for(Implicant implicant : implicantList) {
            //if(implicant.getElements().size() == 0) continue;
            List<Implicant> implicants = new ArrayList<>();
            for(Object obj : ruleElementsMap.keySet()) {
                if(obj.equals(implicant.getKeyAttribute())) implicants = ruleElementsMap.get(obj);
            }
            implicants.add(implicant);
            Object matchingKey = null;
            for(Object obj : ruleElementsMap.keySet()) {
                if(obj.equals(implicant.getKeyAttribute())) matchingKey = obj;
            }
            if(matchingKey == null) ruleElementsMap.put(implicant.getObject(), implicants);
            else ruleElementsMap.replace(matchingKey, implicants);
        }
        for(Object object : ruleElementsMap.keySet()) {
            Pair<Object, List<List<List<MyPair>>>> what;
            List<List<List<MyPair>>> sublist = new ArrayList<>();
            List<Implicant> relatedImplicants = ruleElementsMap.get(object);
            for(Implicant implicant : relatedImplicants) {
                List<List<MyPair>> listOfMyPairs = new ArrayList<>();
                List<AttributesList> listOfImplicantElements = implicant.getElements();
                for(AttributesList attributesList : listOfImplicantElements) {
                    List<MyPair> myPairs = new ArrayList<>();
                    List<Attribute> implicantElementAttributes = attributesList;
                    for(Attribute attribute : implicantElementAttributes) {
                        MyPair myPair = implicant.getRecord().getAttributeEvaluation(attribute);
                        myPairs.add(myPair);
                    }
                    if(myPairs.size() > 0)
                        listOfMyPairs.add(myPairs);
                }
                if(listOfMyPairs.size() > 0)
                sublist.add(listOfMyPairs);
            }
            if(sublist.size() > 0) {
                what = new Pair<>(object, sublist);
                elements.add(what);
            }
        }
    }

    public KeyAttribute getKeyAttribute() {
        return keyAttribute;
    }

    public List<Pair<Object, List<List<List<MyPair>>>>> getElements() {
        return elements;
    }

    public double calculateValue(Record record) {
        double value = 0;
        for (Pair<Object, List<List<List<MyPair>>>> ruleElement : elements) {

            List<List<List<MyPair>>> sublistA = ruleElement.getValue();
            sublistA:
            for (List<List<MyPair>> sublistB : sublistA) {
                double sublistBvalue = 1;
                sublistB:
                for (List<MyPair> sublistC : sublistB) {
                    double sublistCvalue = 0;
                    sublistC:
                    for (MyPair attributeEval : sublistC) {
                        MyPair currentEval = record.getAttributeEvaluation(attributeEval.attribute);
                        FuzzyValue fuzzyRuleValue = (FuzzyValue) attributeEval.value;
                        String level = fuzzyRuleValue.toString();
                        switch (level) {
                            case "HIGH":
                                sublistCvalue = Math.max(value, ((FuzzyValue) currentEval.value).getHigh());
                                break;
                            case "MEDIUM":
                                sublistCvalue = Math.max(value, ((FuzzyValue) currentEval.value).getMedium());
                                break;
                            case "LOW":
                                sublistCvalue = Math.max(value, ((FuzzyValue) currentEval.value).getLow());
                                break;
                        }
                    }
                    sublistBvalue = Math.min(sublistCvalue, sublistBvalue);
                }
                value = Math.max(value, sublistBvalue);
            }
        }
        return value;
    }
}
