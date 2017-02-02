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
        controller.setLearningSet(records);
        controller.generateRules();

        controller.getDecision(new Record(new Object(-1), Arrays.asList(
                new MyPair<>(new Attribute("a"), new DiscreteValue(1.33)),
                new MyPair<>(new Attribute("b"), new DiscreteValue(0)),
                new MyPair<>(new Attribute("c"), new DiscreteValue(1))),
                null));

        controller.getDecision(new Record(new Object(-1), Arrays.asList(
                new MyPair<>(new Attribute("a"), new DiscreteValue(4)),
                new MyPair<>(new Attribute("b"), new DiscreteValue(5)),
                new MyPair<>(new Attribute("c"), new DiscreteValue(3))),
                null));
    }


}
