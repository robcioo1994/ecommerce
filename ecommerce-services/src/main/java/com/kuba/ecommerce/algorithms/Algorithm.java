package com.kuba.ecommerce.algorithms;

import javafx.util.Pair;
import com.kuba.ecommerce.lists.*;
import com.kuba.ecommerce.models.*;
import com.kuba.ecommerce.models.Object;
import com.kuba.ecommerce.operators.Approximation;
import com.kuba.ecommerce.utils.ConsoleWriter;

import java.lang.System;
import java.util.*;

public class Algorithm {

    public static DecisionList divideByDecisions(List<Record> records) {

        DecisionList decisionsSplit = new DecisionList();

        for(Record record : records) {
            Pair<KeyAttribute, List<Object>> forDecision = decisionsSplit.getDecisionList(record.getKeyAttribute());
            if(forDecision != null) {
                forDecision.getValue().add(record.getObject());
            } else {
                List<Object> objects = new ArrayList<>();
                objects.add(record.getObject());
                forDecision = new Pair<KeyAttribute, List<Object>>(record.getKeyAttribute(), objects);
                decisionsSplit.add(forDecision);
            }
        }
        for(Pair<KeyAttribute, List<Object>> pair : decisionsSplit) {
            System.out.println("Attribute " + pair.getKey().toString()+" :");
            System.out.print("Values: ");
            for(Object object : pair.getValue()) {
                System.out.print(object.toString()+",");
            }
            System.out.println();
        }
        return decisionsSplit;
    }

    public static IndifferenceList indiferrenceDivide(List<Record> records) {

        IndifferenceList indifferenceList = new IndifferenceList();

        for(Record record : records) {
            Pair<ArrayList<MyPair>, ArrayList<Object>> forIndifference = indifferenceList.getIndifference(record.getAttributeEvaluations());
            if(forIndifference != null) {
                forIndifference.getValue().add(record.getObject());
            } else {
                ArrayList<Object> objects = new ArrayList<>();
                objects.add(record.getObject());
                forIndifference = new Pair<ArrayList<MyPair>, ArrayList<Object>>((ArrayList<MyPair>) record.getAttributeEvaluations(), objects);
                indifferenceList.add(forIndifference);
            }
        }
        System.out.print("Abstraction class division:");
        indifferenceList.print();
        return indifferenceList;
    }

    public static double evaluateApproximation(IndifferenceList indifferenceList, List<Object> decisions, int totalSize, Approximation approximation) {
        double approximationValue;
        int counter = 0;
        for(Pair<ArrayList<MyPair>,ArrayList<Object>> pair : indifferenceList) {
            boolean isContained = isFullyContained(pair.getValue(), decisions);
            if(isContained) counter++;
        }
        approximationValue = (double)counter/(double)totalSize;
        return approximationValue;
    }

    private static boolean isFullyContained(List<Object> what, List<Object> source) {
        checkCandidate: for(Object candidate : what) {
            for(Object toCheck : source) {
                if((candidate).equals((toCheck))) {
                    continue checkCandidate;
                }
            }
            return false;
        }
        return true;
    }

    public static List<Record> normalize(List<Record> toNormalize, DecisionList decisionList, IndifferenceList indifferenceList) {
        List<Object> toDelete = new ArrayList<>();
        for(Pair<?, ArrayList<Object>> pair : indifferenceList) {
            List<Object> classOfAbstract = pair.getValue();
            HashMap<Object, KeyAttribute> objectDecisionMap = new HashMap();
            if(classOfAbstract.size() <= 1) continue;
            Pair<KeyAttribute, Double> bestApproximation = new Pair<KeyAttribute,Double>(null, 0d);
            for(Object object: pair.getValue()) {
                for(Pair<KeyAttribute, List<Object>> decision : decisionList) {
                    if(isFullyContained(Arrays.asList(object), decision.getValue())) {
                        objectDecisionMap.put(object, decision.getKey());
                        double approximation = evaluateApproximation(indifferenceList, pair.getValue(), toNormalize.size(), Approximation.DOWN );
                        if(approximation > bestApproximation.getValue()) {
                            bestApproximation = new Pair<>(decision.getKey(), approximation);
                        }
                    }
                }
            }
            for(Object object : classOfAbstract) {
                if(objectDecisionMap.get(object) != bestApproximation.getKey()) toDelete.add(object);
            }
        }
        deletion: while(!toDelete.isEmpty()) {
            Object delete = toDelete.get(0);
            for(Record record : toNormalize) {
                if(record.getObject().equals(delete)) {
                    toNormalize.remove(record);
                    toDelete.remove(delete);
                    continue deletion;
                }
            }
        }
        return toNormalize;
    }

    public static AttributesList[][] getAttributeDifferenceMatrix(List<Record> records) {
        AttributesList[][] attributesMatrix = new AttributesList[records.size()][records.size()];

        for(int row = 0; row<records.size(); row++) {
            for(int col = 0; col<records.size(); col++) {
                Record recordA = records.get(row);
                Record recordB = records.get(col);
                AttributesList attributes = recordA.getDifferentAttributes(recordB);
                attributesMatrix[row][col] = attributes;
            }
        }
        return attributesMatrix;
    }

    public static AttributesList[][] reduceAttribute(AttributesList[][] attDiffMatrix, Attribute best) {
        for(int row = 0; row<attDiffMatrix.length; row++) {
            for(int col = 0; col<attDiffMatrix.length; col++) {
                AttributesList currentList = attDiffMatrix[row][col];
                if(currentList.contains(best)) {
                    attDiffMatrix[row][col] = new AttributesList();
                }
            }
        }
        return attDiffMatrix;
    }

    public static Reduct reduceAttributes(AttributesList[][] attDiffMatrix) {
        Reduct reduct = new Reduct();

        while(AttributeCounterList.getBest(AttributesList.countAttributes(attDiffMatrix)) != null) {
            Attribute best = AttributeCounterList.getBest(AttributesList.countAttributes(attDiffMatrix));
            reduct.add(best);
            attDiffMatrix = reduceAttribute(attDiffMatrix, best);
        }
        return reduct;
    }

    public static ArrayList<List<Pair<Record,AttributesList>>> getImplicantMatrix(AttributesList[][] attDiffMatrix, List<Record> records) {
        ArrayList<List<Pair<Record,AttributesList>>> implicantMatrix = new ArrayList<>();
        for(int row = 0; row < records.size(); row++) {
            List<Pair<Record,AttributesList>> what = new ArrayList<>();
            for(int col = 0; col < records.size(); col++) {
                AttributesList attributes = new AttributesList();
                if(!(row == col || records.get(row).getKeyAttribute().equals(records.get(col).getKeyAttribute()))) {
                    attributes = attDiffMatrix[row][col];
                }
                what.add(new Pair(records.get(row), attributes));
            }
            implicantMatrix.add(what);
        }
        return implicantMatrix;
    }

    public static ImplicantList generateImplicants(ArrayList<List<Pair<Record, AttributesList>>> a, Reduct reduct) {
        ImplicantList implicants = new ImplicantList();
        for(List<Pair<Record, AttributesList>> i : a) {
            Implicant implicant = new Implicant(i.get(0).getKey());
            for(int relatedAttributesIndex = 0; relatedAttributesIndex < i.size(); relatedAttributesIndex++) {
                Pair<Record, AttributesList> relatedAttributes = i.get(relatedAttributesIndex);
                if(!relatedAttributes.getValue().isEmpty()) {
                    AttributesList attributes = new AttributesList();
                    for(int attributeIndex = 0; attributeIndex < relatedAttributes.getValue().size(); attributeIndex++) {
                        if(reduct.containsAttribute(relatedAttributes.getValue().get(attributeIndex)))
                            attributes.add(relatedAttributes.getValue().get(attributeIndex));
                    }
                    implicant.getElements().add(attributes);
                }
            }
            implicants.add(implicant.optimize(true));
        }
        ConsoleWriter.writeImplicants(implicants);
        return implicants;
    }

    public static List<Rule> generateRules(List<Implicant> implicantList) {
        List<Rule> rules = new ArrayList();
        Map<KeyAttribute, List<Implicant>> ruleElementsMap = new HashMap<>();
        //region group by keyAttribute
        for(Implicant implicant : implicantList) {
            List<Implicant> implicants = new ArrayList<>();
            for(KeyAttribute keyAttribute : ruleElementsMap.keySet()) {
                if(keyAttribute.equals(implicant.getKeyAttribute())) implicants = ruleElementsMap.get(keyAttribute);
            }
            implicants.add(implicant);
            KeyAttribute matchingKey = null;
            for(KeyAttribute keyAttribute : ruleElementsMap.keySet()) {
                if(keyAttribute.equals(implicant.getKeyAttribute())) matchingKey = keyAttribute;
            }
            if(matchingKey == null) ruleElementsMap.put(implicant.getKeyAttribute(), implicants);
            else ruleElementsMap.replace(matchingKey, implicants);
        }
        //endregion group by keyAttribute
        for(KeyAttribute keyAttribute : ruleElementsMap.keySet()) {
            List<Implicant> implicants = ruleElementsMap.get(keyAttribute);

            Rule rule = new Rule(keyAttribute, implicants);
            if(implicants.size() != 0)
                rules.add(rule);
        }
        ConsoleWriter.writeRules(rules);
        return rules;
    }

    public static AttributesList extractAttributes(List<Record> records) {
        AttributesList attributes = new AttributesList();
        for(MyPair myPair : (List<MyPair>) records.get(0).getAttributeEvaluations()) {
            attributes.add(myPair.attribute);
        }
        return attributes;
    }
}
