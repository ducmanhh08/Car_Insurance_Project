package CarInsuranceCompany;

import java.io.Serializable;

public class MyDate implements Cloneable, Comparable<MyDate>, Serializable {

//    create variables:
    private int year;
    private int month;
    private int day;

//    create constructors:
    public MyDate(int day, int month, int year){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate(MyDate date){
        this.day = date.day;
        this.month = date.month;
        this.year = date.year;
    }

//    create get-set methods:

    public int getYear(){
        return year;
    }
    public void setYear(int newYear){
        this.year = newYear;
    }

    public int getMonth(){
        return month;
    }
    public void setMonth(int newMonth){
        this.month = newMonth;
    }

    public int getDay(){
        return day;
    }
    public void setDay(int newDay){
        this.day = newDay;
    }


    public boolean isExpired(MyDate expiryDate){
        MyDate myDate = new MyDate(this.day, this.month, this.year);
        if(myDate.year < expiryDate.year){
            if(myDate.month < expiryDate.month){
                if(myDate.day < expiryDate.day){
                    return false;
                }
            }
        }
        return true;
    }

    public String toString(){
        return day + "/" + month + "/" + year;
    }
    public String toDelimitedString() { return day + "," + month + "," + year; }

    @Override
    public MyDate clone() throws CloneNotSupportedException{
        return (MyDate) super.clone();
    }

    @Override
    public int compareTo(MyDate date) {
        if(this.year == date.year) {
            if (this.month == date.month) {
                if (this.day == date.day) {
                    return 0;
                } else if (day > date.day) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (month > date.month) {
                return 1;
            } else {
                return -1;
            }
        } else if (year > date.year) {
            return 1;
        }
        else {
            return -1;
        }
    }
}


