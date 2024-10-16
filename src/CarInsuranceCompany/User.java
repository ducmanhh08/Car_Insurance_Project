package CarInsuranceCompany;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class User implements Cloneable, Comparable<User>, Serializable {

//    create variables:
    private String name;
    private int userID;
    private Address address;

    private String userUsername;
    private String userPassword;

//    ArrayList policies:
//    protected static ArrayList<InsurancePolicies> policies;

    private static HashMap<Integer, InsurancePolicies> policies;

    private final int flatRate = 100;


//    create constructors:

    public User(String name, int userID, Address address, String userUsername, String userPassword){
        this.name = name;
        this.userID = userID;
        this.address = address;
//        User.policies = new HashMap<>();
        policies = new HashMap<>();
        this.userUsername = userUsername;
        this.userPassword = userPassword;
    }

    public User(User user){
        this(user.name, user.userID, user.address, user.userUsername, user.userPassword);
    }

//    validate user:

    public boolean validateUser(String username, String password){
        if(userUsername.equals(username) && userPassword.equals(password)){
            return true;
        }
        else{
            return false;
        }
    }

//    shallow and deep copy (ArrayList & HashMap):

    @Override
    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }

    public static ArrayList<User> shallowCopy(ArrayList<User> users){
        return (ArrayList<User>) users.clone();
    }
//
    public static ArrayList<User> deepCopy(ArrayList<User> users){
        ArrayList<User> deepClone = (ArrayList<User>) users.clone();
        return deepClone;
    }

    public static ArrayList<User> shallowCopy(HashMap<Integer, User> users){
        return (ArrayList<User>) users.clone();
    }

    public static ArrayList<User> deepCopy(HashMap<Integer, User> users){
        ArrayList<User> deepClone = (ArrayList<User>) users.clone();
        return deepClone;
    }

    public static HashMap<Integer, User> shallowCopyHashMap(HashMap<Integer, User> users){
        return (HashMap<Integer, User>) users.clone();
    }

    public static HashMap<Integer, User> deepCopyHashMap(HashMap<Integer, User> users){
        HashMap<Integer, User> deepCloneHashMap = (HashMap<Integer, User>) users.clone();
        return deepCloneHashMap;
    }

    public ArrayList<InsurancePolicies> shallowCopyPolicies(){
        return (ArrayList<InsurancePolicies>) policies.clone();
    }

    public ArrayList<InsurancePolicies> deepCopyPolicies() throws CloneNotSupportedException{

        ArrayList<InsurancePolicies> deepClonePolicies = new ArrayList<>();
        for(InsurancePolicies policy: policies.values()){
            InsurancePolicies policyClone = policy.clone();
            deepClonePolicies.add(policyClone);
        }

        return deepClonePolicies;
    }

    public HashMap<Integer, InsurancePolicies> shallowCopyPoliciesHashMap() {
        return (HashMap<Integer, InsurancePolicies>) policies.clone();
    }

    public HashMap<Integer, InsurancePolicies> deepCopyPoliciesHashMap() throws CloneNotSupportedException {
        HashMap<Integer, InsurancePolicies> deepCloneHashMap = (HashMap<Integer, InsurancePolicies>) policies.clone();
        for(InsurancePolicies policy: policies.values()){
            InsurancePolicies policyClone = policy.clone();
            deepCloneHashMap.put(policyClone.id, policyClone);
        }
        return deepCloneHashMap;
    }



//    create get-set methods:

    public String getUserUsername(){return userUsername;}
    public String getUserPassword(){return userPassword;}
    public void setUserPassword(String newPassword) {
        this.userPassword = newPassword;
    }

    public String getName(){
        return name;
    }
    public void setName(String newName){this.name=newName;}
    public int getUserID(){
        return userID;
    }
    public void setUserID(int newUserID){
        this.userID = newUserID;
    }
    public Address getAddress(){
        return address;
    }
    public void setAddress(Address newAddress){
        this.address = newAddress;
    }
//    public ArrayList<InsurancePolicies> getPolicies(){
//        return policies;
//    }

    public HashMap<Integer, InsurancePolicies> getPolicies(){
        return policies;
    }


//    find policy and add policy method (ArrayList):

//    public InsurancePolicies findPolicy(int policyID){
//        for(InsurancePolicies policy: policies){
//            if(policy.getId() == policyID){
//                return policy;
//            }
//        }
//        return null;
//    }
//
    public boolean addPolicy(InsurancePolicies policy){
        if(findPolicy(policy.getId())==null){
            this.policies.put(policy.getId(), policy);
            return true;
        }
        return false;
    }
//
//    public boolean removePolicy(InsurancePolicies policy){
//        if(findPolicy(policy.getId())!=null){
//            policies.remove(policy);
//            return true;
//        }
//        else{
//            return false;
//        }
//    }

//    find policy and add policy method (HashMap):

    public InsurancePolicies findPolicy(int policyId){
//        for(Integer policyID : policies.keySet())
////        for(Map.Entry<Integer, InsurancePolicies> policyID : policies.entrySet())
//        {
////
//            if(policyID!=policyId){
//                return policies.get(policyId);
//            }
//        }
        return policies.get(policyId);
    }

    public boolean addPolicy(String username, String password, InsurancePolicies policy){
        if(validateUser(username, password)) {
            if (!policies.containsKey(policy.getId())) {
                policies.put(this.userID, policy);
//                System.out.println(this.userID);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

//    public boolean addPolicy(InsurancePolicies policy) {
//
//        if (!policies.containsKey(policy.getId())) {
//            policies.put(policy.getId(), policy);
//            return true;
//        } else {
//            return false;
//        }
//
//    }

//    public boolean addPolicy(InsurancePolicies policy) {
//        if (findPolicy(policy.getId())!=null) {
//            return false;
//        } else {
//            policies.put(policy.getId(), policy);
//            return true;
//        }
//    }

    public boolean removePolicy(InsurancePolicies policy){
        if(findPolicy(policy.getId())!=null){
            policies.remove(policy.getId());
            return true;
        }
        else{
            return false;
        }
    }

//    print and toString method (ArrayList & HashMap):



    //    compare method (ArrayList & HashMap):

    @Override
    public int compareTo(User user) {
        return address.compareTo(user.address);
    }

//    public int compareTo1(User user1, User user2) {
//        return Double.compare(user1.calcTotalPremiums(flatRate), user2.calcTotalPremiums(flatRate));
//    }

    @Override
    public String toString(){
        return "ID: " + userID + " Name: " + name + " Address: " + address + "\n";
    }

    public void print(){
        System.out.println("User ID: " + userID + " Name: " + name + " Address: " + address);
        System.out.println();
        for (InsurancePolicies policy : policies.values()) {
            policy.print();
        }
        System.out.println();
    }

    public static void printPolicies(int flatRate){
        for(InsurancePolicies policy: policies.values()){
            policy.print();
//            System.out.println("Payment: " + policy.calcPayment(flatRate));
        }
    }

    public static void printPolicies(ArrayList<InsurancePolicies> policies){
        for(InsurancePolicies policy: policies){
            policy.print();
//            System.out.println("Payment: " + policy.calcPayment(flatRate));
        }
    }

    public static void printPolicies(HashMap<Integer, InsurancePolicies> policies){
        for(InsurancePolicies policy: policies.values()){
            policy.print();
//            System.out.println("Payment: " + policy.calcPayment(flatRate));
        }
    }

    public static void printUsers(HashMap<Integer, User> users){
        for(User user: users.values()){
            System.out.println(user);
        }
    }

    public static void printUsers(ArrayList<User> users){
        for(User user: users){
            System.out.println(user);
        }
    }

//    calculating total payment and price rise methods:

    public double calcTotalPremiums(int flatRate){
        return InsurancePolicies.calcTotalPayments(policies, flatRate);
    }

    public double calcTotalPremiums(String username, String password, int flatRate){
        if(username.equals(userUsername) && password.equals(userPassword)) {
            return InsurancePolicies.calcTotalPayments(policies, flatRate);
        } else {
            return 0;
        }
    }

    public void carPriceRiseAll(double risePercent){
        InsurancePolicies.carPriceRiseAll(policies, risePercent);
    }

//    filter method (ArrayList & HashMap):

    public ArrayList<InsurancePolicies> filterByCarModel(String carModel){
        return InsurancePolicies.filterByCarModel(policies, carModel);
    }

    public ArrayList<InsurancePolicies> filterByExpiryDate(MyDate myDate){
        return InsurancePolicies.filterByExpiryDate(policies, myDate);
    }


//    create policies methods:
    public boolean createThirdPartyPolicy(String username, String password, String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, String comments) throws PolicyException, PolicyHolderNameException {
        for(InsurancePolicies policy: policies.values()){
            if(policy.getId() == id){
                return false;
            }
            else{
                ThirdPartyPolicy thirdPartyPolicy = new ThirdPartyPolicy(policyHolderName, id, car, numberOfClaims, expiryDate, comments);
                return addPolicy(username, password, policy);
            }
        }
        return true;
    }

    public boolean createComprehensivePolicy(String username, String password, String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level) throws PolicyException, PolicyHolderNameException {
        for(InsurancePolicies policy: policies.values()){
            if(policy.getId() == id){
                return false;
            }
            else{
                ComprehensivePolicy comprehensivePolicy = new ComprehensivePolicy(policyHolderName, id, car, numberOfClaims, expiryDate, driverAge, level);
                addPolicy(username, password, policy);
            }
        }
        return true;
    }

    public ArrayList<String> populateDistinctCarModels(){
        ArrayList<String> carModels = new ArrayList<>();
        for(InsurancePolicies policy: policies.values()){
            String carModel = String.valueOf(policy.getCar());
            if(!carModels.contains(carModel)){
                carModels.add(carModel);
            }
        }
        return carModels;
    }

    public int getTotalCountForCarModel(String carModel){
        int count = 0;
        for(InsurancePolicies policy: policies.values()){
            if(String.valueOf(policy.getCar()).equals(carModel)){
                count++;
            }
        }
        return count;
    }

    public double getTotalPaymentForCarModel(String carModel){
        double totalPayment = 0;
        for(InsurancePolicies policy: policies.values()){
            if(String.valueOf(policy.getCar()).equals(carModel)){
                totalPayment += policy.calcPayment(flatRate);
            }
        }
        return totalPayment;
    }

    public ArrayList<Integer> getTotalCountPerCarModel(ArrayList<String> carModels){
        ArrayList<Integer> totalCount = new ArrayList<>();
        for(String carModel: carModels){
            totalCount.add(getTotalCountForCarModel(carModel));
        }
        return totalCount;
    }

    public ArrayList<Double> getTotalPaymentPerCarModel(ArrayList<String> carModels){
        ArrayList<Double> totalPayments = new ArrayList<>();
        for(String carModel: carModels){
            totalPayments.add(getTotalPaymentForCarModel(carModel));
        }
        return totalPayments;
    }

    public void reportPaymentPerCarModel(ArrayList<String> carModels, ArrayList<Integer> counts, ArrayList<Double> premiumPayments){
        System.out.printf("%s%30s%60s", "Car Model", "Total Premium Payment", "Average Premium Payment");
        System.out.println();
        for(int i=0; i < carModels.size(); i++){
            System.out.printf("%s%40s", carModels.get(i), premiumPayments.get(i));
            System.out.printf("%20.2f", premiumPayments.get(i)/counts.get(i));
        }
    }

//    public ArrayList<InsurancePolicies> sortPoliciesByDate(){
//        Collections.sort(policies);
//        return policies;
//    }

//    LAB 4:

//    sort policies by date:

    public ArrayList<InsurancePolicies> sortPoliciesByDate() throws CloneNotSupportedException{
        ArrayList<InsurancePolicies> policiesShallowCopy = deepCopyPolicies();
        Collections.sort(policiesShallowCopy);
        return policiesShallowCopy;
    }

//    public int compareTo1(InsurancePolicies policy){
//    }



//    LAB 5:

    public HashMap<String, Integer> getTotalCountPerCarModel(){
        HashMap<String, Integer> totalCountPerCarModel = new HashMap<>();
        for(InsurancePolicies policy: policies.values()){
            String carModel = policy.car.getModel();
            if(totalCountPerCarModel.get(carModel) == null){
                totalCountPerCarModel.put(carModel, 1);
            } else {
                Integer newNum = totalCountPerCarModel.get(carModel) + 1;
                totalCountPerCarModel.remove(carModel);
                totalCountPerCarModel.put(carModel, newNum);
            }
        }
        return totalCountPerCarModel;
    }

    public HashMap<String, Double> getTotalPremiumPerCarModel(){
        HashMap<String, Double> totalPremiumPerCarModel = new HashMap<>();
        HashMap<String, Integer> totalCountPerCarModel = getTotalCountPerCarModel();

        double totalPremiumPerCar = 0;

        for(String carModel: totalCountPerCarModel.keySet()){
            for(InsurancePolicies policy: policies.values()){
                if(policy.car.getModel().equals(carModel)){
                    totalPremiumPerCar += policy.calcPayment(flatRate);
                }
            }
            totalPremiumPerCarModel.put(carModel, totalPremiumPerCar);
            totalPremiumPerCar = 0;
        }

        return totalPremiumPerCarModel;
    }

    public void reportTotalPremiumPerCarModel(HashMap<String, Integer> totalCount, HashMap<String, Double> totalPremium){
        System.out.printf("%s%40s%30s", "Car Model", "Total Premium Payment", "Average Premium Payment");
        System.out.println();
        for(String carModel: totalCount.keySet()){
            System.out.printf("%s%32s", carModel, totalPremium.get(carModel));
            System.out.printf("%30.2f", totalPremium.get(carModel)/totalCount.get(carModel));
            System.out.println();
        }
    }


//    LAB 6:

    public static HashMap<Integer, User> load(String fileName) throws IOException {

        ObjectInputStream inputStream = null;
        HashMap<Integer, User> users = new HashMap<>();
        int count = 1;

        try{
            inputStream = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)));
        } catch (IOException ex){
            System.err.println("Error in create or open file.");
            System.exit(1);
        }

        try{
            while (true){
                User user = (User) inputStream.readObject();
                users.put(count, user);
                count++;
            }
        } catch (EOFException ex){
            System.out.println("No more record.");
        } catch (ClassNotFoundException ex) {
            System.err.println("Error of wrong class in the file.");
        } catch (IOException ex){
            System.err.println("Error in adding objects to the file.");
            System.exit(1);
        }

        try{
            if(inputStream != null){
                inputStream.close();
            }
        } catch (IOException ex){
            System.err.println("Error in closing the file.");
            System.exit(1);
        }

        return users;
    }

    public static Boolean save(HashMap<Integer, User> users, String fileName) throws IOException{
        ObjectOutputStream outputStream = null;


//        try {
            try {
                outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));
            } catch (IOException ex) {
                System.err.println("Error in create or open the file.");
                System.exit(1);
            }

            try {
                for (User user: users.values()) {
                    outputStream.writeObject(user);
//                    for (InsurancePolicies policy: user.getPolicies().values()){
//                        outputStream.writeObject(policy);
//                    }
                }
            } catch (IOException ex) {
                System.err.println("Error in adding to the file.");
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
//        } catch (Exception e){
//            return false;
//        }

        return true;
    }


    public String toDelimitedString(){
        return "U," + "" + userID + ", " + name + "," + address.toDelimitedString();
    }

    public static HashMap<Integer, User> loadTextFile(String fileName) throws IOException {

        HashMap<Integer, User> users = new HashMap<>();
        int count = 1;

        BufferedReader input = new BufferedReader(new FileReader(fileName));
        String line = input.readLine();

        while (line != null) {

            line = line.trim();
            String[] field = line.split(",");


            String id = field[1];
            String name = field[2];

            int streetNum = Integer.parseInt(field[3]);
            String street = field[4];
            String city = field[5];
            String suburb = field[6];

            Address address = new Address(streetNum, street, city, suburb);


            users.put(count, new User(name, Integer.parseInt(id), address, "user", "user"));


            count++;
            line = input.readLine();

        }

        input.close();
        return users;
    }

    public static Boolean saveTextFile(HashMap<Integer, User> users, String fileName) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName));

        try {
            for (User user: users.values()) {
                out.write(user.toDelimitedString() + "\n");
            }
        } catch (Exception e){
            return false;
        }

        out.close();
        return true;
    }


//    ASSIGNMENT 2:

    public int[] policyCount(String username, String password, int[] ranges){
        int[] policyCount = new int[ranges.length];
        if(validateUser(username, password)) {
            for (InsurancePolicies policy : policies.values()) {
                double payment = policy.calcPayment(flatRate);
                for (int i = 0; i < ranges.length; i++) {
                    int count = policyCount[i];
                    if (payment <= ranges[i]) {
                        policyCount[i]++;
                        break;
                    }
                }
            }
        }
        return policyCount;
    }

    public HashMap<String, Integer[]> policyCarModelCount(String username, String password, int[] ranges){
        HashMap<String, Integer[]> policyCarModelCount = new HashMap<>();

        if(validateUser(username, password)){
            for (String carModel: populateDistinctCarModels()){
                Integer[] policyCount = new Integer[ranges.length];
                for (InsurancePolicies policy: policies.values()){
                    if(policy.car.model.equals(carModel)){
                        double payment = policy.calcPayment(flatRate);
                        for(int i=0; i<ranges.length; i++){
                            int count = policyCount[i];
                            if(payment <= ranges[i]){
                                count++;
                                break;
                            }
                        }
                    }
                }
                policyCarModelCount.put(carModel, policyCount);
            }
        }

        return policyCarModelCount;
    }











}
