package com.kuba.ecommerce.control;

import com.kuba.ecommerce.algorithms.Algorithm;
import javafx.util.Pair;
import com.kuba.ecommerce.lists.*;
import com.kuba.ecommerce.models.*;
import com.kuba.ecommerce.models.Object;
import com.kuba.ecommerce.models.values.DiscreteValue;
import com.kuba.ecommerce.models.values.FuzzyValue;
import com.kuba.ecommerce.tests.Test;

import java.util.ArrayList;
import java.util.List;

public class Fuzzyficator {

    public static Pair<List<Record>, AttributesSpecifications> fuzzyInput(List<Record> records, Controller controller) {
        List<Record> fuzzyfiedRecords = new ArrayList<>();
        AttributesSpecifications attributesSpecifications = new AttributesSpecifications();
        AttributesList attributes = Algorithm.extractAttributes(records);


        KeyAttributeSpecifications keyAttributeSpecifications = new KeyAttributeSpecifications();
        for(Record record : records) {
            if(keyAttributeSpecifications.getMinValue() == null || keyAttributeSpecifications.getMinValue() > record.getKeyAttribute().getDiscreteValue().getValue()) {
                keyAttributeSpecifications.setMinValue(record.getKeyAttribute().getDiscreteValue().getValue());
            }
            if(keyAttributeSpecifications.getMaxValue() == null || keyAttributeSpecifications.getMaxValue() < record.getKeyAttribute().getDiscreteValue().getValue()) {
                keyAttributeSpecifications.setMaxValue(record.getKeyAttribute().getDiscreteValue().getValue());
            }
        }

        for(Attribute currentAttribute : attributes) {
            int elements = records.size();
            double sumOfEvaluation = 0;
            for(Record record : records) {
                MyPair attributeEval = record.getAttributeEvaluation(currentAttribute);
                sumOfEvaluation += attributeEval.value.getValue();
            }
            double meanValue = sumOfEvaluation/elements;

            double sumOfSquareDifference = 0;
            for(Record record : records) {
                MyPair attributeEval = record.getAttributeEvaluation(currentAttribute);
                sumOfSquareDifference += Math.pow(attributeEval.value.getValue() - meanValue, 2);
            }
            double standardDeviation = Math.sqrt(sumOfSquareDifference/elements);
            attributesSpecifications.add(new AttributesSpecifications.AttributeSpecification(currentAttribute, meanValue, standardDeviation));
        }

        double sumOfKeyAttributes = 0;
        for(Record record : records) {
            sumOfKeyAttributes += record.getKeyAttribute().getDiscreteValue().getValue();
        }
        double meanKeyAttributeValue = sumOfKeyAttributes/records.size();

        double sumOfSquareDifference = 0;
        for(Record record : records) {
            sumOfSquareDifference += Math.pow(record.getKeyAttribute().getDiscreteValue().getValue() - meanKeyAttributeValue, 2);
        }
        double standardKeyDeviation = Math.sqrt(sumOfSquareDifference/records.size());

        //region COG
        DiscreteValue minValue = null, maxValue = null;
        for(Record record : records) {
            if(minValue == null) {
                minValue = record.getKeyAttribute().getDiscreteValue();
            }
            if(maxValue == null) {
                maxValue = record.getKeyAttribute().getDiscreteValue();
            }
            DiscreteValue value = record.getKeyAttribute().getDiscreteValue();
            if(minValue.getValue() > value.getValue()) {
                minValue = value;
            }
            if(maxValue.getValue() < value.getValue()) {
                maxValue = value;
            }
        }
        controller.setConstans(maxValue);
        //endregion COG

        for(Record record : records) {
            List<MyPair> fuzzyAttributeEvaluations = new ArrayList<>();

            //region fuzzy attributes
            for(MyPair attributeEval : (List<MyPair>) record.getAttributeEvaluations()) {
                AttributesSpecifications.AttributeSpecification specs = attributesSpecifications.getSpecsByAttribute(attributeEval.attribute);
                double meanValue = specs.getMeanValue();
                double standardDeviation = specs.getStandardDeviation();

                double low, medium, high;

                double discreteValue = attributeEval.value.getValue();

                low = discreteValue >= meanValue ? 0 :
                        (1 - Math.exp(
                                -(Math.pow(discreteValue - meanValue, 2))
                                        / (2*Math.pow(standardDeviation,2))));

                medium = Math.exp(
                        -(Math.pow(discreteValue - meanValue, 2))
                                / (2*Math.pow(standardDeviation,2)));

                high = discreteValue <= meanValue ? 0 :
                        (1 - Math.exp(
                                -(Math.pow(discreteValue - meanValue, 2))
                                        / (2*Math.pow(standardDeviation,2))));

                FuzzyValue value = new FuzzyValue(low,medium,high);

                MyPair newPair = new MyPair(attributeEval.attribute, value);

                fuzzyAttributeEvaluations.add(newPair);
            }
            record.setAttributeEvaluations(fuzzyAttributeEvaluations);

            KeyAttribute keyAttribute = record.getKeyAttribute();

            double meanValue = meanKeyAttributeValue;
            double standardDeviation = standardKeyDeviation;

            double low, medium, high;

            double discreteValue = keyAttribute.getDiscreteValue().getValue();

            low = discreteValue >= meanValue ? 0 :
                    (1 - Math.exp(
                            -(Math.pow(discreteValue - meanValue, 2))
                                    / (2*Math.pow(standardDeviation,2))));

            medium = Math.exp(
                    -(Math.pow(discreteValue - meanValue, 2))
                            / (2*Math.pow(standardDeviation,2)));

            high = discreteValue <= meanValue ? 0 :
                    (1 - Math.exp(
                            -(Math.pow(discreteValue - meanValue, 2))
                                    / (2*Math.pow(standardDeviation,2))));

            FuzzyValue value = new FuzzyValue(low,medium,high);
            //endregion fuzzy attributes


            keyAttribute.setFuzyyValue(value);
            double cog = 0;
            String valueClass = value.toString();
            switch (valueClass) {
                case "HIGH": cog = keyAttributeSpecifications.getMaxValue(); break;
                case "MEDIUM": cog = (keyAttributeSpecifications.getMaxValue()+keyAttributeSpecifications.getMinValue())/2; break;
                case "LOW": cog = keyAttributeSpecifications.getMinValue(); break;
            }
            keyAttribute.setCog(cog);
            record.setKeyAttribute(keyAttribute);
            fuzzyfiedRecords.add(record);
        }



        return new Pair(fuzzyfiedRecords, attributesSpecifications);
    }

    public static Record fuzzyCrisp(Record record, AttributesSpecifications attributeSpecyfications) {
        List<MyPair> fuzzyAttributeEvaluation = new ArrayList<>();
        for(MyPair discreteEvaluation : (List<MyPair>) record.getAttributeEvaluations()) {
            double meanValue = attributeSpecyfications.getSpecsByAttribute(discreteEvaluation.attribute).getMeanValue();
            double standardDeviation = attributeSpecyfications.getSpecsByAttribute(discreteEvaluation.attribute).getStandardDeviation();

            double low, medium, high;

            double discreteValue = discreteEvaluation.value.getValue();

            low = discreteValue >= meanValue ? 0 :
                    (1 - Math.exp(
                            -(Math.pow(discreteValue - meanValue, 2))
                                    / (2*Math.pow(standardDeviation,2))));

            medium = Math.exp(
                    -(Math.pow(discreteValue - meanValue, 2))
                            / (2*Math.pow(standardDeviation,2)));

            high = discreteValue <= meanValue ? 0 :
                    (1 - Math.exp(
                            -(Math.pow(discreteValue - meanValue, 2))
                                    / (2*Math.pow(standardDeviation,2))));

            FuzzyValue value = new FuzzyValue(low,medium,high);
            MyPair fuzzyEvaluation = new MyPair(discreteEvaluation.attribute, value);
            fuzzyAttributeEvaluation.add(fuzzyEvaluation);
        }
        record.setAttributeEvaluations(fuzzyAttributeEvaluation);
        return record;
    }
}
