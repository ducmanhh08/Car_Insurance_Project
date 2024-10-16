package CarInsuranceCompany;

import java.io.Serializable;

public class Car implements Cloneable, Serializable {

//    Attributes:
    public static Car.CarType CarType;
    public enum CarType {SUV, SED, LUX, HATCH, SPORTS};

    protected String model;
    protected CarType type;
    protected int manufacturingYear;
    protected double price;


//    Constructors:
    public Car(CarType type, String model, int manufacturingYear, double price){
        this.model = model;
        this.type = type;
        this.manufacturingYear = manufacturingYear;
        this.price = price;
    }

    public Car(Car car){
        this(car.type, car.model, car.manufacturingYear, car.price);
    }

    public Car(){}

//    Get-set methods:

    public String getModel(){
        return model;
    }
    public void setModel(String newModel){
        this.model = newModel;
    }

    public CarType getType(){
        return type;
    }
    public void setType(CarType newType){
        this.type = newType;
    }

    public int getManufacturingYear(){
        return manufacturingYear;
    }
    public void setManufacturingYear(int newManufacturingYear){
        this.manufacturingYear = newManufacturingYear;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(double newPrice){
        this.price = newPrice;
    }

    public Car clone() throws CloneNotSupportedException{
        return (Car) super.clone();
    }


    public double priceRise(double rise){
        price += price * rise;
        return price;
    }



    @Override
    public String toString(){
        return manufacturingYear+" "+model+" "+type+" "+"Price: $"+price;
    }

//    LAB 6:

    public String toDelimitedString() {
        return manufacturingYear+", "+model+","+type+"," +price;
    }

}