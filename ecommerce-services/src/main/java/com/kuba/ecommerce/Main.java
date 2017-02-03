package com.kuba.ecommerce;

import com.kuba.ecommerce.control.Controller;
import javafx.util.Pair;
import com.kuba.ecommerce.models.Attribute;
import com.kuba.ecommerce.models.MyPair;
import com.kuba.ecommerce.models.Object;
import com.kuba.ecommerce.models.Record;
import com.kuba.ecommerce.models.values.DiscreteValue;
import com.kuba.ecommerce.tests.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Record> records = Test.getObject();

        Controller controller = new Controller(Controller.Mode.FUZZY);
        controller.setLearningSet(records.subList(1, records.size()-2));
        controller.generateRules();

        controller.getDecision(records.get(0));
        controller.getDecision(records.get(records.size()-1));
    }


}
