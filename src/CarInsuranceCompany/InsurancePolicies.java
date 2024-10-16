package CarInsuranceCompany;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.regex.*;

public abstract class InsurancePolicies implements Cloneable, Comparable<InsurancePolicies>, Serializable {

    // create variables:
    protected String policyHolderName;
    protected int id;
    protected Car car;
    protected int numberOfClaims;
    protected MyDate expiryDate;

    // create constructors:
    public InsurancePolicies(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate) throws PolicyException, PolicyHolderNameException {
        try {
            if (id < 300000 || id > 399999) {
                int rand = (int) Math.floor(Math.random() * 99999);
                this.id = 300000 + rand;
                throw new PolicyException(id);
            } else {
                this.id = id;
            }
        } catch (PolicyException pe){
            System.err.println(pe);
        }

        try {
            if (!isValidated(policyHolderName)) {
                this.policyHolderName = null;
                throw new PolicyHolderNameException(policyHolderName);
            } else {
                this.policyHolderName = policyHolderName;
            }
        } catch (PolicyHolderNameException phe){
            System.err.println(phe);
        }

        this.car = car;
        this.numberOfClaims = numberOfClaims;
        this.expiryDate = expiryDate;

    }

    public InsurancePolicies(InsurancePolicies insurancePolicies){
        this.policyHolderName = insurancePolicies.policyHolderName;
        this.id = insurancePolicies.id;
        this.car = insurancePolicies.car;
        this.numberOfClaims = insurancePolicies.numberOfClaims;
        this.expiryDate = insurancePolicies.expiryDate;
    }

    public boolean isValidated(String policyHolderName){
        String regex = "^[A-Z][a-zA-Z]{1,}[\\s][A-Z][a-zA-Z]{1,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(policyHolderName);
        return match.matches();
    }
//    create get-set methods:

    public String getPolicyHolderName(){
        return policyHolderName;
    }
    public void setPolicyHolderName(String newPolicyHolderName){
        this.policyHolderName = newPolicyHolderName;
    }


    public int getId(){
        return id;
    }
    public void setId(int newId){
        this.id = newId;
    }

    public Car getCar(){
        return car;
    }
    public void setCar(Car newCar){
        this.car = newCar;
    }

    public int getNumberOfClaims(){
        return numberOfClaims;
    }
    public void setNumberOfClaims(int newNumberOfClaims){
        this.numberOfClaims = newNumberOfClaims;
    }

    public MyDate getExpiryDate(){
        return expiryDate;
    }


    // format print() method:

    public void print(){
        System.out.print("Policy ID: " + id + " Policy Holder Name: " + policyHolderName + " Car: " + car + " Number of Claims: " + numberOfClaims + " Expiry Date: " + expiryDate);
    }

    // format toString() method:

    public String toString(){
        return "Policy ID: " + id + " Policy Holder Name: " + policyHolderName + " Car: " + car + " Number of Claims: " + numberOfClaims;
    }

//    compare method:

    @Override
    public int compareTo(InsurancePolicies policy){
        return expiryDate.compareTo(policy.expiryDate);
    }


//    shallow and deep copy (ArrayList & HashMap):

    @Override
    public InsurancePolicies clone() throws CloneNotSupportedException{
        return (InsurancePolicies) super.clone();
    }

    public static ArrayList<InsurancePolicies> shallowCopy(ArrayList<InsurancePolicies> policies){
        return (ArrayList<InsurancePolicies>) policies.clone();
    }

    public static ArrayList<InsurancePolicies> deepCopy(ArrayList<InsurancePolicies> policies){
        ArrayList<InsurancePolicies> deepClonePolicies = (ArrayList<InsurancePolicies>) policies.clone();
        return deepClonePolicies;
    }

    public static ArrayList<InsurancePolicies> shallowCopy(HashMap<Integer, InsurancePolicies> policies){
        return (ArrayList<InsurancePolicies>) policies.clone();
    }

    public static ArrayList<InsurancePolicies> deepCopy(HashMap<Integer, InsurancePolicies> policies){
        ArrayList<InsurancePolicies> deepClonePolicies = (ArrayList<InsurancePolicies>) policies.clone();
        return deepClonePolicies;
    }

    public static HashMap< Integer, InsurancePolicies> shallowCopyHashMap (HashMap< Integer, InsurancePolicies> policies){
        return (HashMap<Integer, InsurancePolicies>) policies.clone();
    }

    public static HashMap< Integer, InsurancePolicies> deepCopyHashMap (HashMap< Integer, InsurancePolicies> policies){
        HashMap<Integer, InsurancePolicies> deepCloneHashMap = (HashMap<Integer, InsurancePolicies>) policies.clone();
        return deepCloneHashMap;
    }

    // create calcPayment() method with flatRate as a parameter:
    public abstract double calcPayment(double flatRate);



//    print policies' method (ArrayList & HashMap):
    public static void printPolicies(ArrayList<InsurancePolicies> policies){
        for(InsurancePolicies policy: policies){
            policy.print();
        }
    }

    public static void printPolicies(HashMap<Integer, InsurancePolicies> policies){
        for(InsurancePolicies policy: policies.values()){
            policy.print();
        }
    }

//    calculating total price and price rise methods (ArrayList & HashMap):

    public static double calcTotalPayments(ArrayList<InsurancePolicies> policies, int flatRate){
        double totalPayment = 0;
        for(InsurancePolicies policy : policies){
            totalPayment += policy.calcPayment(flatRate);
        }
        return totalPayment;
    }

    public static double calcTotalPayments(HashMap<Integer, InsurancePolicies> policies, int flatRate){
        double totalPayment = 0;
        for(InsurancePolicies policy : policies.values()){
            totalPayment += policy.calcPayment(flatRate);
        }
        return totalPayment;
    }

    public void carPriceRise(double risePercent){
        car.priceRise(risePercent);
    }

    public static void carPriceRiseAll(ArrayList<InsurancePolicies> policies, double risePercent){
        for(InsurancePolicies policy: policies){
            policy.carPriceRise(risePercent);
        }
    }

    public static void carPriceRiseAll(HashMap<Integer, InsurancePolicies> policies, double risePercent){
        for(InsurancePolicies policy: policies.values()){
            policy.carPriceRise(risePercent);
        }
    }

//    filter methods:

    public static ArrayList<InsurancePolicies> filterByCarModel(ArrayList<InsurancePolicies> policies, String carModel){
        ArrayList<InsurancePolicies> filteredCarModels = new ArrayList<InsurancePolicies>();
        for(InsurancePolicies policy: policies){
            if(policy.car.model.contains(carModel)){
                filteredCarModels.add(policy);
            }
        }
        return filteredCarModels;
    }

    public static ArrayList<InsurancePolicies> filterByCarModel(HashMap<Integer, InsurancePolicies> policies, String carModel){
        ArrayList<InsurancePolicies> filteredCarModels = new ArrayList<InsurancePolicies>();
        for(InsurancePolicies policy: policies.values()){
            if(policy.car.model.contains(carModel)){
                filteredCarModels.add(policy);
            }
        }
        return filteredCarModels;
    }

    public static ArrayList<InsurancePolicies> filterByExpiryDate(ArrayList<InsurancePolicies> policies, MyDate date){
        ArrayList<InsurancePolicies> filterByExpiryDate = new ArrayList<>();
        for(InsurancePolicies policy: policies){
            if(date.isExpired(policy.getExpiryDate())){
                filterByExpiryDate.add(policy);
            }
        }
        return filterByExpiryDate;
    }

    public static ArrayList<InsurancePolicies> filterByExpiryDate(HashMap<Integer, InsurancePolicies> policies, MyDate date){
        ArrayList<InsurancePolicies> filterByExpiryDate = new ArrayList<>();
        for(InsurancePolicies policy: policies.values()){
            if(date.isExpired(policy.getExpiryDate())){
                filterByExpiryDate.add(policy);
            }
        }
        return filterByExpiryDate;
    }



//    LAB 6:

    public abstract String toDelimitedString();

//    load & save methods:

    public static HashMap<Integer, InsurancePolicies> load(String fileName) throws IOException, ClassNotFoundException {

        ObjectInputStream inputStream = null;
        HashMap<Integer, InsurancePolicies> policies = new HashMap<>();
        int count = 1;

        try{
            inputStream = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)));
//        } catch (IOException ex){
//            System.err.println("Error in create / open file.");
//            System.exit(1);
//        }

//        try{
            while (true){
                InsurancePolicies policy = (InsurancePolicies) inputStream.readObject();
                User user = (User) inputStream.readObject();
                policies.put(count, policy);
                count++;



            }
        } catch (EOFException ex){
            System.out.println("No more record.");
//        } catch (ClassNotFoundException ex) {
//            System.err.println("Error of wrong class in the file.");
//        } catch (IOException ex){
//            System.err.println("Error in adding objects to the file.");
//            System.exit(1);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    System.err.println("Error in closing the file: " + ex.getMessage());
                }
            }
        }

//        try{
//            if(inputStream != null) {
//                inputStream.close();
//            }
//        } catch (IOException ex){
//            System.err.println("Error in closing the file.");
//            System.exit(1);
//        }
////            }

        return policies;

    }

    public static Boolean save(HashMap<Integer, InsurancePolicies> policies, String fileName) throws IOException{
        ObjectOutputStream outputStream = null;

        try {
            try {
                outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));
            } catch (IOException ex) {
                System.err.println("Error in create/open the file.");
                System.exit(1);
            }

            try {
                for (InsurancePolicies policy : policies.values()) {
                    outputStream.writeObject(policy);
                }
            } catch (IOException ex) {
                System.err.println("Error in adding objects to the file.");
                System.exit(1);
            }

            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException ex) {
                System.err.println("Error in adding object to the file.");
                System.exit(1);
            }
        } catch (Exception e){
            return false;
        }

        return true;
    }

    public static HashMap<Integer, InsurancePolicies> loadTextFile(String fileName) throws IOException, PolicyException, PolicyHolderNameException {

        HashMap<Integer, InsurancePolicies> policies = new HashMap<>();
        int count = 1;

        BufferedReader input = new BufferedReader(new FileReader(fileName));
        String line = input.readLine();

        while (line != null){

            line = line.trim();
            String[] field = line.split(",");

            switch (field[0]){

                case "C":
                    String id = field[1];
                    String policyHolderName = field[2];

                    int manufacturingYear = Integer.parseInt(field[3]);
                    String model = field[4];
                    Car.CarType type = Car.CarType.valueOf(field[5]);
                    double price = Double.parseDouble(field[6]);

                    Car car = new Car(type, model, manufacturingYear, price);
                    int numberOfClaims = Integer.parseInt(field[7]);
                    int driveAge = Integer.parseInt(field[8]);
                    int level = Integer.parseInt(field[9]);

                    int day = Integer.parseInt(field[10]);
                    int month = Integer.parseInt(field[11]);
                    int year = Integer.parseInt(field[12]);

                    MyDate expiryDate = new MyDate(day, month, year);

                    policies.put(count, new ComprehensivePolicy(policyHolderName, Integer.parseInt(id), car, numberOfClaims, expiryDate, driveAge, level));

                    break;


                case "T":

                    id = field[1];
                    policyHolderName = field[2];

                    manufacturingYear = Integer.parseInt(field[3]);
                    model = field[4];
                    type = Car.CarType.valueOf(field[5]);
                    price = Double.parseDouble(field[6]);

                    car = new Car(type, model, manufacturingYear, price);
                    numberOfClaims = Integer.parseInt(field[7]);
                    String comment = field[8];

                    day = Integer.parseInt(field[9]);
                    month = Integer.parseInt(field[10]);
                    year = Integer.parseInt(field[11]);

                    expiryDate = new MyDate(day, month, year);

                    policies.put(count, new ThirdPartyPolicy(policyHolderName, Integer.parseInt(id), car, numberOfClaims, expiryDate, comment));

                    break;

                case "U":
                    System.out.println("aloalao");
            }

            count++;
            line = input.readLine();

        }

        input.close();
        return policies;
    }

    public static Boolean saveTextFile(HashMap<Integer, InsurancePolicies> policies, String fileName) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName));

        try {
            for (InsurancePolicies policy : policies.values()) {
                out.write(policy.toDelimitedString() + "\n");
            }
        } catch (Exception e){
            return false;
        }

        out.close();
        return true;
    }
}
