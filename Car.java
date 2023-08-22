package ControlUNIT;

public class Car {
    String name;
    String model;
    String factoryName;
    int kmaj;
    int yearOfFabrication;

    public Car(){};
    public Car(String name, String model, String factoryName, int kmaj, int yearOfFabrication){
        this.name = name;
        this.model = model;
        this.factoryName = factoryName;
        this.kmaj = kmaj;
        this.yearOfFabrication = yearOfFabrication;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public int getKmaj() {
        return kmaj;
    }

    public int getYearOfFabrication() {
        return yearOfFabrication;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public void setKmaj(int kmaj) {
        this.kmaj = kmaj;
    }

    public void setYearOfFabrication(int yearOfFabrication) {
        this.yearOfFabrication = yearOfFabrication;
    }

    public void printData(){
        String printCar = this.getName() + "\n" +
                this.getModel() + "\n" +
                this.getFactoryName() + "\n" +
                this.getKmaj() + "\n" +
                this.getYearOfFabrication() + ".";
        System.out.println(printCar);
    }
}
