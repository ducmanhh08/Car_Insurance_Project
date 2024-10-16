package CarInsuranceCompany;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class InsuranceCompany implements Cloneable, Serializable {

//    attributes:
    public String name;
    private HashMap<Integer, User> users = new HashMap<>();
    private String adminUsername;
    private String adminPassword;
    private int flatRate = 100;


//    constructors:
    public InsuranceCompany(String name, String adminUsername, String adminPassword){
        this.name = name;
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
        users = new HashMap<>();
    }

    public InsuranceCompany(InsuranceCompany insuranceCompany){
        this.name = insuranceCompany.name;
        this.adminUsername = insuranceCompany.adminUsername;
        this.adminPassword = insuranceCompany.adminPassword;
        this.users = insuranceCompany.users;
    }

    public InsuranceCompany() {}

    //    get-set methods:
    public String getAdminUsername(){
        return adminUsername;
    }
    public void setAdminUsername(String adminUsername){
        this.adminUsername = adminUsername;
    }
    public String getAdminPassword(){
        return adminPassword;
    }
    public void setAdminPassword(String adminPassword){
        this.adminPassword = adminPassword;
    }

    public HashMap<Integer, User> getUsers(){
        return users;
    }


//    shallow and deep copy methods (ArrayList & HashMap):
    @Override
    public InsuranceCompany clone() throws CloneNotSupportedException{
        InsuranceCompany insuranceCompanyClone = (InsuranceCompany) super.clone();
        insuranceCompanyClone.adminUsername = this.adminUsername;
        insuranceCompanyClone.adminPassword = this.adminPassword;
        return insuranceCompanyClone;
    }

    public ArrayList<User> shallowCopyUsers(){
        return (ArrayList<User>) users.clone();
    }

    public ArrayList<User> deepCopyUsers() throws CloneNotSupportedException {
        ArrayList<User> userDeepClone = new ArrayList<>();
        for(User user: users.values()){
            User userClone = user.clone();
            userDeepClone.add(userClone);
        }
        return userDeepClone;
    }

    public HashMap<Integer, User> shallowCopyUsersHashMap(){
        return (HashMap<Integer, User>) users.clone();
    }

    public HashMap<Integer, User> deepCopyUsersHashMap() throws CloneNotSupportedException{
        HashMap<Integer, User> userDeepClone = new HashMap<>();
        for(User user: users.values()){
            User userClone = user.clone();
            userDeepClone.put(userDeepClone.size() + 1, userClone);
        }
        return userDeepClone;
    }

//    methods:

    public boolean validateAdmin(String username, String password){
        return username.equals(adminUsername) && password.equals(adminPassword);
    }

    public User validateUser(String username, String password) {
        for (User user : this.users.values()) {
            if (user.validateUser(username, password))
                return user;
        }
        return null;
    }

//    find, add, remove methods (ArrayList & HashMap):

//    public User findUser(int userID){
//        for(User user: users){
//            if(user.getUserID() == userID){
//                return user;
//            }
//        }
//        return null;
//    }
//
//    public boolean addUser(User user){
//        if(findUser(user.getUserID())==null){
//            users.add(user);
//            return true;
//        }
//        return false;
//    }
//
//    public boolean removeUser(User user){
//        if(findUser(user.getUserID())!=null){
//            users.add(user);
//            return true;
//        }
//        return false;
//    }

    public User findUser(int userID){
        for(User user: users.values()){
            if(user.getUserID() == userID){
                return user;
            }
        }
        return null;
    }

//    public boolean addUser(User user){
//        int userID = user.getUserID();
//
//        if(users.containsKey(userID)){
//            return false;
//        }
//
//        users.put(userID, user);
//        return true;
//    }

    public boolean addUser(User user) {

        if (findUser(user.getUserID()) == null) {
            this.users.put(user.getUserID(), user);
            return true;
        }
        return false;
    }

    public boolean removeUser(User user){
        if(findUser(user.getUserID())!=null){
            users.remove(user);
            return true;
        }
        return false;
    }

    public boolean addPolicy(String adminUsername, String adminPassword, int userID, InsurancePolicies policy) throws PolicyException, PolicyHolderNameException{
        if(adminUsername.equals(this.adminUsername) && adminPassword.equals(this.adminPassword)) {
            if (findUser(userID) != null && findPolicy(userID, policy.getId()) == null) {
                User user = findUser(userID);
                String username = user.getUserUsername();
                String password = user.getUserPassword();
                user.addPolicy(username, password, policy);
                return true;
            }
        }
        return false;
    }

    public boolean addPolicy(int userID, InsurancePolicies policy) throws PolicyException, PolicyHolderNameException{

//        if (findUser(userID) != null && findPolicy(userID, policy.getId()) == null) {
//            User user = findUser(userID);
//            user.addPolicy(policy);
//            return true;
//        }

        User user = findUser(userID);
        if (user != null)
            return user.addPolicy(policy);
        return false;

    }

    public boolean removePolicy(int userID, InsurancePolicies policy){
        if(findUser(userID) != null && findPolicy(userID, policy.getId()) != null){
            findUser(userID).removePolicy(policy);
            return true;
        }
        return false;
    }

    public InsurancePolicies findPolicy(int userID, int policyID){
        if(findUser(userID) != null){
            User user = findUser(userID);
//            if(user.findPolicy(policyID) != null){
//                return user.findPolicy(policyID);
//            }
            return user.findPolicy(policyID);

        }
        return null;
    }

    public void printPolicies(int userID){
        User user = findUser(userID);
        user.print();
    }

    public void print(){
        for(User user: users.values()){
            System.out.println(user);
            user.printPolicies(flatRate);
            System.out.println();
        }
    }

    public String toString(){
        String userToString = "";
        for(User user: users.values()){
            userToString += user.toString();
        }
        return userToString;
    }

    public boolean createThirdPartyPolicy(int userID, String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, String comments) throws PolicyException, PolicyHolderNameException {
        User user = findUser(userID);
        if(findUser(userID) != null){
            String username = findUser(userID).getUserUsername();
            String password = findUser(userID).getUserPassword();
            return user.createThirdPartyPolicy(username, password, policyHolderName, id, car, numberOfClaims, expiryDate, comments);
        }
        return false;
    }

    public boolean createComprehensivePolicy(int userID, String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driveAge, int level) throws PolicyException, PolicyHolderNameException {
        User user = findUser(userID);
        if(findUser(userID) != null){
            String username = findUser(userID).getUserUsername();
            String password = findUser(userID).getUserPassword();
            return user.createComprehensivePolicy(username, password, policyHolderName, id, car, numberOfClaims, expiryDate, driveAge, level);
        }
        return false;
    }

    public double calcTotalPayments(String username, String password, int userID){
        if(username.equals(adminUsername) && password.equals(adminPassword)) {
            double totalPayment = findUser(userID).calcTotalPremiums(flatRate);
            return totalPayment;
        } else {
            return 0;
        }
    }

    public double calcTotalPayments(){
        double totalPayment = 0;
        for(User user: users.values()){
            totalPayment += InsurancePolicies.calcTotalPayments(user.getPolicies(), flatRate);
        }
        return totalPayment;
    }

    public boolean carPriceRise(int userID, double risePercent){
        if(findUser(userID) != null){
            findUser(userID).carPriceRiseAll(risePercent);
        }
        return false;
    }

    public void carPriceRise(double risePercent){
        for(User user: users.values()){
            InsurancePolicies.carPriceRiseAll(user.getPolicies(), risePercent);
        }
    }

    public HashMap<Integer, InsurancePolicies> allPolicies(){
        HashMap<Integer, InsurancePolicies> allPolicies = new HashMap<>();
        for(User user: users.values()){
            for(InsurancePolicies policy: user.getPolicies().values()){
                allPolicies.put(policy.getId(), policy);
            }
        }
        return allPolicies;
    }

    public ArrayList<InsurancePolicies> filterByCarModel(int userID, String carModel){
        return findUser(userID).filterByCarModel(carModel);
    }



    public ArrayList<InsurancePolicies> filterByCarModel(String carModel){
        ArrayList<InsurancePolicies> filterByCarModel = new ArrayList<>();
        for(User user: users.values()){
            filterByCarModel.addAll(user.filterByCarModel(carModel));
        }
        return filterByCarModel;
    }

    public ArrayList<InsurancePolicies> filterByExpiryDate(int userID, MyDate date){
        return findUser(userID).filterByExpiryDate(date);
    }

    public ArrayList<InsurancePolicies> filterByExpiryDate(MyDate date) {
        ArrayList<InsurancePolicies> filterByExpiryDate = new ArrayList<>();
        for (User user : users.values()) {
            filterByExpiryDate.addAll(user.filterByExpiryDate(date));
        }
        return filterByExpiryDate;
    }



    public ArrayList<String> populateDistinctCityNames(){
        ArrayList<String> cities = new ArrayList<>();
        for(User user: users.values()){
            String city = user.getAddress().getCity();
            if(!cities.contains(city)){
                cities.add(city);
            }
        }
        return cities;
    }

    public double getTotalPaymentForCity(String city){
        double totalPaymentForCity = 0;
        for(User user: users.values()){
            if(user.getAddress().getCity() == city){
                totalPaymentForCity += user.calcTotalPremiums(flatRate);
            }
        }
        return totalPaymentForCity;
    }

    public ArrayList<Double> getTotalPaymentPerCity(ArrayList<String> cities){
        ArrayList<Double> payments = new ArrayList<>();
        for(int i=0; i < cities.size(); i++){
            payments.add(getTotalPaymentForCity(cities.get(i)));
        }
        return payments;
    }

    public void reportPaymentPerCity(ArrayList<String> cities, ArrayList<Double> payments){
        System.out.printf("%15s%40s", "City Name", "Total Premium Payment");
        System.out.println();
        for(int i=0; i < cities.size(); i++){
            System.out.printf("%15s%34s", cities.get(i), "$" + payments.get(i));
            System.out.println();
        }
    }

    public ArrayList<String> populateDistinctCarModels(){
        ArrayList<String> carModels = new ArrayList<>();
        for(User user: users.values()) {
            carModels = user.populateDistinctCarModels();
        }
        return carModels;
    }

    public ArrayList<Integer> getTotalCountPerCarModel(ArrayList<String> carModels){
        ArrayList<Integer> totalCountPerCarModel = new ArrayList<>();
        for(User user: users.values()){
            totalCountPerCarModel = user.getTotalCountPerCarModel(carModels);
        }
        return totalCountPerCarModel;
    }

    public ArrayList<Double> getTotalPaymentPerCarModel(ArrayList<String> carModels){
        ArrayList<Double> totalPayment = new ArrayList<>();
        for(User user: users.values()){
            totalPayment = user.getTotalPaymentPerCarModel(carModels);
        }
        return totalPayment;
    }

    public void reportPaymentsPerCarModel(ArrayList<String> carModels, ArrayList<Integer> counts, ArrayList<Double> premiumPayments){
        System.out.printf("%s%30s%50s%45s", "User ID", "Car Model", "Total Premium Payment", "Average Premium Payment");
        System.out.println();
        for(int i=0; i<users.size(); i++){
            System.out.printf("%4d", users.get(i).getUserID());
            System.out.println();
            for(int j=0; j<carModels.size(); j++) {
                System.out.printf("%50s         ", carModels.get(j));
                System.out.printf("%20.2s\t", "$" + premiumPayments.get(j));
                System.out.printf("%40s%.2f", "$", premiumPayments.get(j) / counts.get(j));
                System.out.println();
            }
        }
    }

//    LAB 4:

//    sort users:

    public ArrayList<User> sortUsers() throws CloneNotSupportedException{
        ArrayList<User> usersShallowCopy = deepCopyUsers();
        Collections.sort(usersShallowCopy);
        return usersShallowCopy;
    }

//    LAB 5:

    public HashMap<String, Double> getTotalPremiumPerCity(){
        HashMap<String, Double> totalPremiumPerCity = new HashMap<>();
        for(User user: users.values()){
            String city = user.getAddress().getCity();
            if(totalPremiumPerCity.get(city) == null){
                totalPremiumPerCity.put(city, user.calcTotalPremiums(flatRate));
            } else {
                Double newTotalPremium = totalPremiumPerCity.get(city) + user.calcTotalPremiums(flatRate);
                totalPremiumPerCity.remove(city);
                totalPremiumPerCity.put(city, newTotalPremium);
            }
        }
        return totalPremiumPerCity;
    }


    public HashMap<String, Integer> getTotalCountPerCarModel(){
        HashMap<String, Integer> totalCountPerCarModel = new HashMap<>();
        for(User user: users.values()){
            HashMap<String, Integer> totalCount = user.getTotalCountPerCarModel();
            for(InsurancePolicies policy: user.getPolicies().values()){
                String carModel = policy.car.getModel();
                if(totalCountPerCarModel.get(carModel) == null){
                    Integer count = totalCount.get(carModel);
                    totalCountPerCarModel.put(carModel, count);
                } else {
                    Integer newCount = totalCount.get(carModel) + totalCountPerCarModel.get(carModel);
                    totalCountPerCarModel.remove(carModel);
                    totalCountPerCarModel.put(carModel, newCount);
                }
            }
        }
        return totalCountPerCarModel;
    }

    public HashMap<String, Double> getTotalPremiumPerCarModel(){
        HashMap<String, Double> totalPremiumPerCarModel = new HashMap<>();
        for(User user: users.values()){
            HashMap<String, Double> totalCount = user.getTotalPremiumPerCarModel();
            for(InsurancePolicies policy: user.getPolicies().values()){
                String carModel = policy.car.getModel();
                if(totalPremiumPerCarModel.get(carModel) == null){
                    Double totalPremium = totalCount.get(carModel);
                    totalPremiumPerCarModel.put(carModel, totalPremium);
                } else {
                    Double newTotalPremium = totalCount.get(carModel) + totalPremiumPerCarModel.get(carModel);
                    totalPremiumPerCarModel.remove(carModel);
                    totalPremiumPerCarModel.put(carModel, newTotalPremium);
                }
            }
        }
        return totalPremiumPerCarModel;
    }

    public void reportTotalPremiumPerCity(HashMap<String, Double> totalPremiumPerCity){
        System.out.printf("%s%50s", "City Name", "Total Premium Payments");
        System.out.println();
        for(String city: totalPremiumPerCity.keySet()){
            System.out.printf("%s%40s", city, totalPremiumPerCity.get(city));
            System.out.println();
        }
    }

    public void reportTotalPremiumPerCarModel(HashMap<String, Integer> totalCount, HashMap<String, Double> totalPremium){
        System.out.printf("%s%40s%30s", "Car Model", "Total Premium Payment", "Average Premium Payment");
        System.out.println();
        for(String carModel: totalCount.keySet()){
            System.out.printf("%s%32s", carModel, totalPremium.get(carModel));
            System.out.printf("%32.2f", totalPremium.get(carModel)/totalCount.get(carModel));
            System.out.println();
        }
    }


//    LAB 6:

    public String toDelimitedString(){
        String delimitedString = name + ", \n";
        for(User user: users.values()){
            delimitedString += user.toDelimitedString() + "\n";
            for(InsurancePolicies policy: user.getPolicies().values()){
                delimitedString += policy.toDelimitedString() + "\n";
            }
        }
        return delimitedString;
    }

//    load & save methods:

    public InsuranceCompany load(String fileName) throws IOException, ClassNotFoundException {

        ObjectInputStream inputStream = null;
        InsuranceCompany insuranceCompany1 = new InsuranceCompany();
//        int count = 1;

//        try {
//            try {
                inputStream = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)));
//            } catch (IOException ex) {
//                System.err.println("Error in create or open file.");
//                System.exit(1);
//            }



            try {
                while (true) {
                    insuranceCompany1 = (InsuranceCompany) inputStream.readObject();
//                    insuranceCompany1.users.put(count, user);
//                    count++;
//                    InsurancePolicies policy = (InsurancePolicies) inputStream.readObject();
//                    user.getPolicies().put(policy.getId(), policy);

                }
            } catch (EOFException ex) {
                System.out.println("No more record.");
            } catch (ClassNotFoundException ex) {
                System.err.println("Error of wrong class in the file.");
            } catch (IOException ex) {
                System.err.println("Error in adding objects to the file.");
                System.exit(1);
            }

//            try {
//                if (inputStream != null) {
                    inputStream.close();
//                }
//            } catch (IOException ex) {
//                System.err.println("Error in closing the file.");
//                System.exit(1);
//            }
//        } catch (Exception e){
//            return false;
//        }

        return insuranceCompany1;
    }

    public Boolean save(String fileName) throws IOException {
        ObjectOutputStream outputStream = null;

//        try {
//            try {
                outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));
//            } catch (IOException ex) {
//                System.err.println("Error in create or open the file.");
//                System.exit(1);
//            }

//            try {
                for (User user: users.values()) {
                    for (InsurancePolicies policy : user.getPolicies().values()) {
                        outputStream.writeObject(policy);
                    }
                }
//            } catch (IOException ex) {
//                System.err.println("Error in adding objects to the file.");
//                System.exit(1);
//            }

//            try {
//                if (outputStream != null) {
                    outputStream.close();
//                }
//            } catch (IOException ex) {
//                System.err.println("Error in adding object to the file.");
//                System.exit(1);
//            }
//        } catch (Exception e) {
//            return false;
//        }

        return true;

    }

    public Boolean loadTextFile(String fileName) throws IOException {

        InsuranceCompany insuranceCompany = new InsuranceCompany();
        int count = 1;

        BufferedReader input = new BufferedReader(new FileReader(fileName));
        String line = input.readLine();

        try {

            line = line.trim();
            String[] field = line.split(",");

            String name = field[0];

            while (line != null) {

                line = line.trim();
                field = line.split(",");

                int id = Integer.parseInt(field[1]);
                String userName = field[2];

                int streetNum = Integer.parseInt(field[3]);
                String street = field[4];
                String city = field[5];
                String suburb = field[6];

                Address address = new Address(streetNum, street, city, suburb);
                User user = new User(userName, id, address,"user", "user");

                users.put(count, user);
                count++;
                line = input.readLine();


                switch (field[0]) {

                    case "C":
                        int policyId = Integer.parseInt(field[1]);
                        String policyHolderName = field[2];

                        Car.CarType type = Car.CarType.valueOf(field[3]);
                        String model = field[4];
                        int manufacturingYear = Integer.parseInt(field[5]);
                        double price = Double.parseDouble(field[6]);

                        Car car = new Car(type, model, manufacturingYear, price);
                        int numberOfClaims = Integer.parseInt(field[7]);
                        int driveAge = Integer.parseInt(field[8]);
                        int level = Integer.parseInt(field[9]);

                        int day = Integer.parseInt(field[10]);
                        int month = Integer.parseInt(field[11]);
                        int year = Integer.parseInt(field[12]);

                        MyDate expiryDate = new MyDate(day, month, year);

                        user.addPolicy(user.getUserUsername(), user.getUserPassword(), new ComprehensivePolicy(policyHolderName, id, car, numberOfClaims, expiryDate, driveAge, level));

                        break;


                    case "T":

                        id = Integer.parseInt(field[1]);
                        policyHolderName = field[2];

                        type = Car.CarType.valueOf(field[3]);
                        model = field[4];
                        manufacturingYear = Integer.parseInt(field[5]);
                        price = Double.parseDouble(field[6]);

                        car = new Car(type, model, manufacturingYear, price);
                        numberOfClaims = Integer.parseInt(field[7]);
                        String comment = field[8];

                        day = Integer.parseInt(field[9]);
                        month = Integer.parseInt(field[10]);
                        year = Integer.parseInt(field[11]);

                        expiryDate = new MyDate(day, month, year);

                        user.addPolicy(user.getUserUsername(), user.getUserPassword(), new ThirdPartyPolicy(policyHolderName, id, car, numberOfClaims, expiryDate, comment));

                        break;
                }



                line = input.readLine();
            }

            input.close();
        } catch (Exception e){
            return false;
        }

        return true;
    }


    public Boolean saveTextFile(String fileName) throws IOException {

        BufferedWriter out = new BufferedWriter(new FileWriter(fileName));

        try {
//            out.write(name + "\n");
            for (User user: users.values()) {
                out.write(user.toDelimitedString() + "\n");
                for (InsurancePolicies policy: user.getPolicies().values()){
                    out.write(policy.toDelimitedString() + "\n");
                }
            }
        } catch (Exception e){
            return false;
        }

        out.close();
        return true;
    }

    //  Assignment 2:

    public ArrayList<User> sortUsersByPremium() throws CloneNotSupportedException {
        ArrayList<User> sortedUsers = deepCopyUsers();
        TotalPremiumPaymentComparator userComparator = new TotalPremiumPaymentComparator();
        Collections.sort(sortedUsers, userComparator);
        return sortedUsers;
    }

    public HashMap<String, ArrayList<User>> getUsersPerCity(){
        HashMap<String, ArrayList<User>> usersPerCity = new HashMap<>();
        ArrayList<String> cities = populateDistinctCityNames();

        for(String city: cities){
            ArrayList<User> totalUsersPerCity = new ArrayList<>();
            for(User user: users.values()){
                if(user.getAddress().getCity().equals(city)){
                    totalUsersPerCity.add(user);
                }
            }
            usersPerCity.put(city, totalUsersPerCity);
        }

        return usersPerCity;

    }

    public HashMap<String, ArrayList<InsurancePolicies>> filterPoliciesByExpiryDate(MyDate expiryDate){
        HashMap<String, ArrayList<InsurancePolicies>> totalPolicies = new HashMap<>();

        for(User user: users.values()){
            ArrayList<InsurancePolicies> policiesByExpiryDate = new ArrayList<>();
            for(InsurancePolicies policy: user.getPolicies().values()){
                if(policy.getExpiryDate().isExpired(expiryDate)){
                    policiesByExpiryDate.add(policy);
                }
            }

            totalPolicies.put(user.getName(), policiesByExpiryDate);
        }

        return totalPolicies;
    }

    public int[] policyCount(String adminUsername, String adminPassword, int[] ranges){
        int[] policyCount = new int[ranges.length];
        if(validateAdmin(adminUsername, adminPassword)){
            for (InsurancePolicies policy : allPolicies().values()) {
                double payment = policy.calcPayment(flatRate);
                for (int i = 0; i < ranges.length; i++) {
                    int count = policyCount[i];
                    if (payment <= ranges[i]) {
                        count++;
                        break;
                    }
                }
            }
        }
        return policyCount;
    }

    public HashMap<String, Integer[]> policyCityCount(String adminUsername, String adminPassword, int[] ranges){
        HashMap<String, Integer[]> policyCityCount = new HashMap<>();

        if(validateAdmin(adminUsername, adminPassword)){
            for(String city: populateDistinctCityNames()){
                Integer[] policyCount = new Integer[ranges.length];
                for(User user: users.values()){
                    if(user.getAddress().getCity().equals(city)){
                        for(InsurancePolicies policy: user.getPolicies().values()){
                            double payment = policy.calcPayment(flatRate);
                            for(int i=0; i<ranges.length; i++){
                                int count = policyCount[i];
                                if (payment <= ranges[i]){
                                    count++;
                                    break;
                                }
                            }
                        }
                    }
                }
                policyCityCount.put(city, policyCount);
            }
        }

        return policyCityCount;
    }

    public int[] userCount(String adminUsername, String adminPassword, int[] ranges){
        int[] userCount = new int[ranges.length];

        if(validateAdmin(adminUsername, adminPassword)){
            for (User user: users.values()){
                for (InsurancePolicies policy: user.getPolicies().values()){
                    double payment = policy.calcPayment(flatRate);

                    for (int i=0; i<ranges.length; i++){
                        int count = userCount[i];
                        if(payment <= ranges[i]){
                            count++;
                            break;
                        }
                    }
                }
            }
        }

        return userCount;
    }

    public HashMap<String, Integer[]> userCarModelCount(String adminUsername, String adminPassword, int[] ranges){
        HashMap<String, Integer[]> userCarModelCount = new HashMap<>();

        if(validateAdmin(adminUsername, adminPassword)){
            for(String carModel: populateDistinctCarModels()){
                Integer[] policyCount = new Integer[ranges.length];
                for(User user: users.values()){
                    for(InsurancePolicies policy: user.getPolicies().values()){
                        if(policy.getCar().model.equals(carModel)){
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
                }
                userCarModelCount.put(carModel, policyCount);
            }
        }

        return userCarModelCount;
    }


}

class TotalPremiumPaymentComparator implements Comparator<User> {

    private int flatRate = 100;

    @Override
    public int compare(User user1, User user2) {
        return Double.compare(user1.calcTotalPremiums(flatRate), user2.calcTotalPremiums(flatRate));
    }
}
