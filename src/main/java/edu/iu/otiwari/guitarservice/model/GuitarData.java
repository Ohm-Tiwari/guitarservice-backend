package edu.iu.otiwari.guitarservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//@Entity
//@Table(schema = "guitars", name="guitars")
public class GuitarData {
    private String serialNumber;
    private double price;
    private String builder;
    private String model;
    private String type;
    private String backWood;
    private String topWood;

    public GuitarData(){
    }

    public GuitarData(String serialNumber, double price, String builder, String model, String type, String backWood, String topWood) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBuilder() {
        return builder;
    }

    public void setBuilder(String builder) {
        this.builder = builder;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBackWood() {
        return backWood;
    }

    public void setBackWood(String backWood) {
        this.backWood = backWood;
    }

    public String getTopWood() {
        return topWood;
    }

    public void setTopWood(String topWood) {
        this.topWood = topWood;
    }

    public String toString() {
        return "GuitarData{" +
                "serialNumber='" + serialNumber + '\'' +
                ", price=" + price +
                ", builder='" + builder + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", backWood='" + backWood + '\'' +
                ", topWood='" + topWood + '\'' +
                '}';
    }

    public String toLine() {
        return String.format("%1$s,%2$s,%3$s,%4$s,%5$s,%6$s,%7$s", serialNumber , price, builder, model, type, backWood, topWood);
    }
    public static GuitarData fromLine(String line) {
        String[] tokens = line.split(",");
        return new GuitarData(tokens[0], Double.parseDouble(tokens[1]), tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]);
    }




}