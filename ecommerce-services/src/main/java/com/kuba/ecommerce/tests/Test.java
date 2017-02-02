package com.kuba.ecommerce.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kuba.ecommerce.models.KeyAttribute;
import com.kuba.ecommerce.models.Object;
import com.kuba.ecommerce.models.values.DiscreteValue;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test {

    private static List<Record> getTestRecords() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("sample_records_list.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<Record> records = new ArrayList<>();
        if(br != null) {
            RecordsList recordsList = new Gson().fromJson(br, RecordsList.class);
            records = recordsList.getList();
        }
        return records;
    }

    public class Record extends com.kuba.ecommerce.models.Record {

        public Record(Object item, List attributeEvaluations, KeyAttribute o) {
            super(item, attributeEvaluations, o);
        }
    }

    public static class DecisionAttribute extends com.kuba.ecommerce.models.DecisionAttribute {

    }

    public static class RecordsList {
        private List<Record> records;

        public List<Record> getList() {
            return records;
        }

        public void setRecords(List<Record> records) {
            this.records = records;
        }
    }

    public static List<com.kuba.ecommerce.models.Record> getObject() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("/home/jsalamon/IdeaProjects/Praca Inżynierska (implementacja)/src/tests/assets/sample_records2.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(br != null) {


            List<com.kuba.ecommerce.models.Record> object = new Gson().fromJson(br, new TypeToken<List<com.kuba.ecommerce.models.Record<DiscreteValue>>>(){}.getType());
            return object;
        }
        return null;
    }
}