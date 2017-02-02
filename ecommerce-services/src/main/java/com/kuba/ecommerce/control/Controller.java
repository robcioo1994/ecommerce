package com.kuba.ecommerce.control;

import com.kuba.ecommerce.algorithms.Algorithm;
import javafx.util.Pair;
import com.kuba.ecommerce.lists.*;
import com.kuba.ecommerce.models.KeyAttribute;
import com.kuba.ecommerce.models.Record;
import com.kuba.ecommerce.models.Rule;
import com.kuba.ecommerce.models.values.DiscreteValue;
import com.kuba.ecommerce.models.values.Value;
import com.kuba.ecommerce.tests.Test;
import com.kuba.ecommerce.utils.ConsoleWriter;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final Mode mode;
    private List<Record> learningSet;
    private List<Rule> rules;
    private AttributesSpecifications attributeSpecyfications;
    //private KeyAttributeSpecifications keyAttributeSpecifications;
    private double constans;

    public Controller(Mode mode) {
        this.mode = mode;
    }

    public void setLearningSet(List<Record> records) {
        if(mode == Mode.FUZZY) {
            Pair<List<Record>, AttributesSpecifications> fuzzyficationResult = Fuzzyficator.fuzzyInput(records, this);
            this.learningSet = fuzzyficationResult.getKey();
            this.attributeSpecyfications = fuzzyficationResult.getValue();
        }

//        keyAttributeSpecifications = new KeyAttributeSpecifications();
//        for(Record record : records) {
//            if(keyAttributeSpecifications.getMinValue() > record.getKeyAttribute().getDiscreteValue().getValue()) {
//                keyAttributeSpecifications.setMaxValue(record.getKeyAttribute().getDiscreteValue().getValue());
//            }
//            if(keyAttributeSpecifications.getMaxValue() < record.getKeyAttribute().getDiscreteValue().getValue()) {
//                keyAttributeSpecifications.setMaxValue(record.getKeyAttribute().getDiscreteValue().getValue());
//            }
//        }

        this.learningSet = records;
    }

    public void generateRules() {

        DecisionList decisionList = Algorithm.divideByDecisions(learningSet);

        IndifferenceList indifferenceList = Algorithm.indiferrenceDivide(learningSet);

        List<Record> normalized = Algorithm.normalize(learningSet, decisionList, indifferenceList);

        AttributesList[][] attDiffMatrix = Algorithm.getAttributeDifferenceMatrix(normalized);

        Reduct reduct = Algorithm.reduceAttributes(attDiffMatrix);

        attDiffMatrix = Algorithm.getAttributeDifferenceMatrix(normalized);

        ArrayList<List<Pair<Record,AttributesList>>> a = Algorithm.getImplicantMatrix(attDiffMatrix, learningSet);

        ImplicantList implicantList = Algorithm.generateImplicants(a,reduct);
        List<Rule> rules = Algorithm.generateRules(implicantList);
        this.rules = rules;
    }

    public double getDecision(Record record) {
        Record fuzzyfied = Fuzzyficator.fuzzyCrisp(record, attributeSpecyfications);
        List<Pair<Rule, Value>> ruleValues = new ArrayList<>();
        for (Rule rule : rules) {
            double value = rule.calculateValue(record);
            ruleValues.add(new Pair(rule, new DiscreteValue(value)));
        }
        double outPutValue = 0;

        double sumOfRuleImplication = 0;
        double sumOfValues = 0;

        for(Pair<Rule,Value> ruleValue : ruleValues) {
            sumOfRuleImplication += ruleValue.getValue().getValue() * ruleValue.getKey().getKeyAttribute().getCog();
            sumOfValues += ruleValue.getValue().getValue();
        }

        outPutValue = (sumOfRuleImplication/sumOfValues);//*constans; ?

        ConsoleWriter.writeDescision(record, outPutValue);
        return outPutValue;
    }

    public void setConstans(DiscreteValue value) {
        this.constans = value.getValue();
    }
//
//    public KeyAttributeSpecifications getKeyAttributeSpecifications() {
//        return keyAttributeSpecifications;
//    }

    public enum Mode {
        DISCRETE, FUZZY
    }
}
