package com.kuba.ecommerce.tests;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.kuba.ecommerce.models.*;
import com.kuba.ecommerce.models.Object;
import com.kuba.ecommerce.models.values.DiscreteValue;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static class RecordsList {
        private List<Record> records;

        public List<Record> getList() {
            return records;
        }

        public void setRecords(List<Record> records) {
            this.records = records;
        }
    }

    public static class WorksheetRecord {
        @SerializedName("Nazwa")
        private String name;
        @SerializedName("Przekątna ekranu")
        private double displaySize;
        @SerializedName("Rozdzielczość ekranu")
        private double displayRes;
        @SerializedName("Dysk twardy")
        private double storageSize;
        @SerializedName("Liczba złączy USB 3.0")
        private double usbPorts;
        @SerializedName("Waga")
        private double weight;
        @SerializedName("Pamięc RAM")
        private double memory;
        @SerializedName("Karta graficzna")
        private double graphics;
        @SerializedName("Wbudowana kamera")
        private double camera;
        @SerializedName("Taktowanie zegara")
        private double processor;
        @SerializedName("Liczba rdzeni")
        private double cores;
        @SerializedName("Cena")
        private double price;
        @SerializedName("OCENA")
        private double evaluation;

        public Record toRecord() {
            return new Record(new Object(name.hashCode()),
                    Arrays.asList(
                            new MyPair<>(new Attribute("Przekątna ekranu"), new DiscreteValue(displaySize)),
                            new MyPair<>(new Attribute("Rozdzielczość ekranu"), new DiscreteValue(displayRes)),
                            new MyPair<>(new Attribute("Dysk twardy"), new DiscreteValue(storageSize)),
                            new MyPair<>(new Attribute("Liczba złączy USB 3.0"), new DiscreteValue(usbPorts)),
                            new MyPair<>(new Attribute("Waga"), new DiscreteValue(weight)),
                            new MyPair<>(new Attribute("Pamięc RAM"), new DiscreteValue(memory)),
                            new MyPair<>(new Attribute("Karta graficzna"), new DiscreteValue(graphics)),
                            new MyPair<>(new Attribute("Wbudowana kamera"), new DiscreteValue(camera)),
                            new MyPair<>(new Attribute("Taktowanie zegara"), new DiscreteValue(processor)),
                            new MyPair<>(new Attribute("Liczba rdzeni"), new DiscreteValue(cores)),
                            new MyPair<>(new Attribute("Cena"), new DiscreteValue(price))
                    ),
                    new KeyAttribute(String.valueOf(evaluation), new DiscreteValue(evaluation)));
        }
    }
    public static List<com.kuba.ecommerce.models.Record> getObject() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("/home/jsalamon/ecommerce/ecommerce/ecommerce-services/src/main/java/com/kuba/ecommerce/tests/assets/sample_sheet_json.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(br != null) {


            //List<com.kuba.ecommerce.models.Record> object = new Gson().fromJson(br, new TypeToken<List<com.kuba.ecommerce.models.Record<DiscreteValue>>>(){}.getType());
            List<WorksheetRecord> worksheetRecords = new Gson().fromJson(br, new TypeToken<List<WorksheetRecord>>(){}.getType());
            List<Record> object = new ArrayList<>();

            for(WorksheetRecord worksheetRecord : worksheetRecords) {
                object.add(worksheetRecord.toRecord());
            }
            return object;
        }
        return null;
    }
}