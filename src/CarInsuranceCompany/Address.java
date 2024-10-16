package CarInsuranceCompany;

import java.io.Serializable;

public class Address implements Cloneable, Comparable<Address>, Serializable {

//    Attributes:
    private int streetNum;
    private String street;
    private String suburb;
    private String city;

//    Constructors
    public Address(int streetNum, String street, String suburb, String city){
        this.streetNum = streetNum;
        this.street = street;
        this.suburb = suburb;
        this.city = city;
    }

    public Address(Address address){
        this(address.streetNum, address.street, address.suburb, address.city);
    }

    public String toString(){
        return streetNum + " " + street + " " + suburb + " " + city;
    }
    public String toDelimitedString() { return streetNum + ", " + street + ", " + suburb + ", " + city;}

//    Get-set methods:

    public int getStreetNum(){
        return streetNum;
    }
    public void setStreetNum(int newStreetNum){
        this.streetNum = newStreetNum;
    }

    public String getStreet(){
        return street;
    }
    public void setStreet(String newStreet){
        this.street = newStreet;
    }

    public String getSuburb(){
        return suburb;
    }
    public void setSuburb(String newSuburb) {
        this.suburb = newSuburb;
    }

    public String getCity(){
        return city;
    }
    public void setCity(String newCity) {
        this.city = newCity;
    }

    @Override
    public Address clone() throws CloneNotSupportedException{
        return (Address) super.clone();
    }

    @Override
    public int compareTo(Address address) {
        if(city.equals(address.city)){
            return 0;
        } else {
            return -1;
        }

    }
}
