package com.kuba.ecommerce.utils;

import javafx.util.Pair;
import com.kuba.ecommerce.lists.AttributesList;
import com.kuba.ecommerce.models.*;
import com.kuba.ecommerce.models.Object;

import java.lang.System;
import java.util.List;

public class ConsoleWriter {

    public static void writeImplicants(List<Implicant> implicants) {
        for(Implicant implicant : implicants) {
            String iString = implicant.getObject().toString() + Chars.LOGIC_IMPLICATION;
            for(int index = 0; index<implicant.getElements().size(); index++) {
                AttributesList attributesList = implicant.getElements().get(index);
                iString += Chars.LEFT_BRACKET;
                for(int attributeIndex = 0; attributeIndex < attributesList.size(); attributeIndex++) {
                    Attribute attribute = attributesList.get(attributeIndex);
                    iString += attribute.getName();
                    if(attributeIndex < attributesList.size()-1) iString += Chars.LOGIC_OR;
                }
                iString += Chars.RIGHT_BRACKET;
                if(index < implicant.getElements().size()-1) iString += Chars.LOGIC_AND;
            }
            System.out.println(iString);
        }
    }

    public static void writeRules(List<Rule> rules) {
        for(Rule rule : rules) {
            System.out.println("Rule for key attribute:" + rule.getKeyAttribute().toString());
            String iRule = "";
            List<Pair<Object, List<List<List<MyPair>>>>> ruleElements = rule.getElements();
            for(int i = 0; i<ruleElements.size(); i++) {
                Pair<Object, List<List<List<MyPair>>>> currentRuleElement = ruleElements.get(i);
                Object currentRuleObject = currentRuleElement.getKey();
                List<List<List<MyPair>>> ruleElementsList = currentRuleElement.getValue();
                for(int j = 0; j<ruleElementsList.size(); j++) {
                    List<List<MyPair>> ruleImplicants = ruleElementsList.get(j);
                    for(int k = 0; k<ruleImplicants.size(); k++) {
                        List<MyPair> implicantElements = ruleImplicants.get(k);
                        if(implicantElements.size() > 1) iRule += Chars.LEFT_BRACKET;
                        for(int l = 0; l<implicantElements.size(); l++) {
                            MyPair expectedAttributeAndValue = implicantElements.get(l);
                            iRule += "f"+Chars.LEFT_BRACKET+currentRuleObject+","+expectedAttributeAndValue.attribute.getName()+Chars.RIGHT_BRACKET+"="+expectedAttributeAndValue.value.toString();
                            if (l < implicantElements.size() - 1) {
                                iRule += " "+Chars.LOGIC_OR+" ";
                            }
                        }
                        if(implicantElements.size() > 1) iRule += Chars.RIGHT_BRACKET;
                        if(k < ruleImplicants.size()-1) {
                            iRule += " "+Chars.LOGIC_AND+" ";
                        }
                    }
                    if(j < ruleElementsList.size() - 1) {
                        iRule += " "+Chars.LOGIC_OR+" ";
                    }
                }
                if(i < ruleElements.size() -1 ) {
                    iRule += " "+Chars.LOGIC_OR+" ";
                }
            }
            System.out.println(iRule);
        }
    }

    public static void writeDescision(Record record, double outPutValue) {
        System.out.print("Object id:"+record.getObject().getId()+" value:"+outPutValue);
    }
}
