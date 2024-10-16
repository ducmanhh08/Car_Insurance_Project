package CarInsuranceCompany;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TestCode {

    public static void main(String[] args) throws PolicyException, PolicyHolderNameException, CloneNotSupportedException {
        TestCode.run();
    }
    public static void run() throws CloneNotSupportedException, PolicyException, PolicyHolderNameException {
        final int flatRate = 100;
//        create car models:

        Car carSUV = new Car(Car.CarType.SUV, "Mazda CX-5", 2020, 35000.00);
        Car carLUX = new Car(Car.CarType.LUX, "Audi Q8", 2021, 56000.00);
        Car carSPORTS = new Car(Car.CarType.SPORTS, "Porsche Taycan", 2023, 32000.00);
        Car carSED = new Car(Car.CarType.SED, "Honda Civic", 2019, 44000.00);
        Car carHATCH = new Car(Car.CarType.HATCH, "Volkswagen Golf", 2016, 15000.00);

//        create users:

        Address address1 = new Address(7, "New Dapto Road", "2500", "Wollongong");
        User user1 = new User("Matthew Nguyen", 1, address1, "manh", "manh");
        Address address2 = new Address(178, "Quan Nhan", "Thanh Xuan", "Hanoi");
        User user2 = new User("Mia Nguyen", 2, address2, "manh", "manh");
        Address address3 = new Address(89, "Hughes", "2000", "Sydney");
        User user3 = new User("Hannah Aji", 3, address3, "manh", "manh");

//        create policies:

        ThirdPartyPolicy thirdPartyPolicy1 = new ThirdPartyPolicy("Matthew Nguyen", 345678, carLUX, 1, new MyDate(8, 11, 2020), "Reparing accessories");
        ThirdPartyPolicy thirdPartyPolicy2 = new ThirdPartyPolicy("Jayla Tiger", 387654, carSPORTS, 4, new MyDate(30, 12, 2021), "Returning products");
        ComprehensivePolicy comprehensivePolicy1 = new ComprehensivePolicy("Blaze Charlie", 300000, carSUV, 2, new MyDate(2, 5, 2022), 22, 2);
        ThirdPartyPolicy thirdPartyPolicy3 = new ThirdPartyPolicy("Janette Kori", 333333, carSED, 4, new MyDate(21, 10, 2023), "Reparing accessories");
        ComprehensivePolicy comprehensivePolicy2 = new ComprehensivePolicy("Dora Elfieda", 351792, carHATCH, 5, new MyDate(22, 12, 2024), 27, 1);

//        create Insurance Company:

        InsuranceCompany insuranceCompany = new InsuranceCompany("CHANG Cooperation", "abcde", "12345");
        String adminUsername = insuranceCompany.getAdminUsername();
        String adminPassword = insuranceCompany.getAdminPassword();

//        login:

        System.out.println("Logging session: (Username: abcde ; Password: 12345)");
        System.out.println("\n\n");
//
        boolean test1 = insuranceCompany.validateAdmin("abcdefgh", "123456");
        boolean test2 = insuranceCompany.validateAdmin("abcde", "12345");

        System.out.println("Logging in with username: abcdefgh");
        if (test1) {
            System.out.println("Congrats!! You are logged in.");
        } else {
            System.out.println("The username or password is incorrect.");
        }
        System.out.println("Logging in with username: abcde");
        if (test2) {
            System.out.println("Congrats!! You are logged in.");
        } else {
            System.out.println("The username or password is incorrect.");
        }

        System.out.println("___________________________________");


//        add users:

        System.out.println("Adding users session: \n\n");

        System.out.println("Adding User 1 to the Insurance Company...");
        insuranceCompany.addUser(user1);
        System.out.println("Adding User 2 to the Insurance Company...");
        insuranceCompany.addUser(user2);
        System.out.println("Adding User 3 to the Insurance Company...");
        insuranceCompany.addUser(user3);
        System.out.println("Users are added successfully!");

        System.out.println("___________________________________");
//
//        add policies:

        System.out.println("Adding policies session: \n\n");

        System.out.println("Adding Third Party Policy 1 to the User 1...");
        insuranceCompany.addPolicy(user1.getUserID(), thirdPartyPolicy1);
        System.out.println("Adding Third Party Policy 2 to the User 2...");
        insuranceCompany.addPolicy(user2.getUserID(), thirdPartyPolicy2);
        System.out.println("Adding Comprehensive Policy 1 to the User 3...");
        insuranceCompany.addPolicy(user3.getUserID(), comprehensivePolicy1);
        System.out.println("Adding Comprehensive Policy 2 to the User 1...");
        insuranceCompany.addPolicy(user1.getUserID(), comprehensivePolicy2);
        System.out.println("Adding Third Party Policy 3 to the User 3...");
        insuranceCompany.addPolicy(user3.getUserID(), thirdPartyPolicy3);

        System.out.println();

        System.out.println("Adding Third Party Policy 2 to the User 4...");
        if (!insuranceCompany.addPolicy(4, thirdPartyPolicy2)) {
            System.out.println("Wrong ID!!");
        }

        System.out.println("Adding Third Party Policy 1 to the User 1...");
        if (!insuranceCompany.addPolicy(user1.getUserID(), thirdPartyPolicy1)) {
            System.out.println("Policy has already been added!");
        }

        System.out.println("___________________________________");


//        add more third party & comprehensive policies:

        System.out.println("Adding more third party and comprehensive policies: \n\n");

        System.out.println("Adding a new Third Party Policy to User 1...");
//        insuranceCompany.createThirdPartyPolicy(user1.getUserID(), "Hale Mica", 333333, carSUV, 3, new MyDate(8, 11, 2025), "Damaged property");
        user1.addPolicy(user1.getUserUsername(), user1.getUserPassword(), new ThirdPartyPolicy("Hale Mica", 333333, carSUV, 3, new MyDate(8, 11, 2025), "Damaged property"));
        System.out.println("Adding a new Comprehensive Policy to User 2...");
//        insuranceCompany.createComprehensivePolicy(user2.getUserID(), "Cindra Ilean", 333336, carSPORTS, 2, new MyDate(30, 12, 2021), 31, 4);
        user2.addPolicy(user2.getUserUsername(), user2.getUserPassword(), new ComprehensivePolicy("Cindra Ilean", 333336, carSPORTS, 2, new MyDate(30, 12, 2021), 31, 4));
        System.out.println();

        System.out.println("Adding a new Comprehensive Policy to User 4...");
        if (!insuranceCompany.createComprehensivePolicy(4, "Sharise Mary Anne", 4, carHATCH, 3, new MyDate(11, 12, 2022), 40, 1)) {
            System.out.println("Wrong ID!! The adding is cancelled.");
        }


        insuranceCompany.createThirdPartyPolicy(user1.getUserID(), "Janette Kori", 1, carSED, 4, new MyDate(2, 5, 1972), "Reparing accessories");
        System.out.println();
        System.out.println("Adding a new Third Party Policy ID 1 to User 1...");
        if (insuranceCompany.findUser(user1.getUserID()).findPolicy(1) != null) {
            System.out.println("Already has policy!");
        }
//        }

        System.out.println("___________________________________");


//        print by userID:

        System.out.println("Print by userID session: \n\n");
        int userID = 1;
        System.out.print(insuranceCompany.findUser(userID));
        System.out.println();

        System.out.println("___________________________________");


//        print the policy of an userID:

        System.out.println("Print a policy of an user ID session: \n");

        System.out.println("User ID: 1");
        System.out.println("Policy ID: 1");

        System.out.println();
        System.out.println();

        int policyID = 1;
//        insuranceCompany.findPolicy(userID, policyID).print();

        System.out.println("___________________________________");


//        print all users inside insurance company:

        System.out.println("Print all users in insurance company: \n\n");

        for (User user : insuranceCompany.getUsers().values()) {
            user.print();
        }

        System.out.println("___________________________________");


//        print the users after raise the price of cars:

        System.out.println("Print all users again after raising car prices: \n\n");

        insuranceCompany.carPriceRise(0.1);
        for (User user : insuranceCompany.getUsers().values()) {
            user.print();
        }

        System.out.println("___________________________________");


//        print the total premium payments by user ID:

        System.out.println("Print total premium payments by user ID session: \n\n");

        System.out.println("The total premium payment for User ID " + userID + ": " + insuranceCompany.calcTotalPayments(adminUsername,adminPassword, userID));

        System.out.println("___________________________________");


//        print the total premium payments for all users:

        System.out.println("The total premium payment for all users in the company: " + insuranceCompany.calcTotalPayments());

        System.out.println("___________________________________");


//        print all policies:

        System.out.println("All the policies in the company: ");
        HashMap<Integer, InsurancePolicies> allPolicies = insuranceCompany.allPolicies();
        InsurancePolicies.printPolicies(allPolicies);

        System.out.println("___________________________________");


//        print the filtered list by user ID and expiry date:

        System.out.println("Print filtered list by expiry date of an user: \n\n");

        LocalDate now = LocalDate.now();

        MyDate expiryDateUser = new MyDate(now.getDayOfMonth(), now.getMonthValue(), now.getYear());
        ArrayList<InsurancePolicies> filterByExpiryDateUser = insuranceCompany.filterByExpiryDate(userID, expiryDateUser);

        System.out.println("The policies are expired by now " + expiryDateUser + ":");
        InsurancePolicies.printPolicies(filterByExpiryDateUser);

        System.out.println("___________________________________");

//        print the filtered list by car models:

        System.out.println("Print filtered list by car model of an user: \n\n");

        System.out.println("Car Model: Porsche Taycan\n");
        String carModel = "Porsche Taycan";
        ArrayList<InsurancePolicies> filterByCarModel = insuranceCompany.filterByCarModel(carModel);
        InsurancePolicies.printPolicies(filterByCarModel);

        System.out.println("___________________________________");


//        print the filtered list by expiry date:

        System.out.println("Print filtered list by expiry date of an user: \n\n");

        MyDate expiryDate = new MyDate(now.getDayOfMonth(), now.getMonthValue(), now.getYear());
        ArrayList<InsurancePolicies> filterByExpiryDate = insuranceCompany.filterByExpiryDate(expiryDate);

        System.out.println("The policies are expired by now " + expiryDate + ":");

        InsurancePolicies.printPolicies(filterByExpiryDate);

        System.out.println("___________________________________");

//        change address of a user:

        System.out.println("Change address session: \n\n");
        System.out.print("User ID: " + userID);
        User userAddress = insuranceCompany.findUser(userID).clone();

        user1.print();

        System.out.println();
        System.out.println("New address: 178 Quan Nhan, Thanh Xuan, Hanoi \n\n");
        userAddress.getAddress().setStreetNum(178);
        userAddress.getAddress().setStreet("Quan Nhan");
        userAddress.getAddress().setSuburb("Thanh Xuan");
        userAddress.getAddress().setCity("Hanoi");

        System.out.println();

//        user1.print();

        System.out.println("___________________________________");

//        shallow & deep copy of policies

        System.out.println("Shallow & Deep Copy of policies: \n\n");

        HashMap<Integer, InsurancePolicies> shallowCopyAllPolicies = InsurancePolicies.shallowCopyHashMap(allPolicies);
        HashMap<Integer, InsurancePolicies> deepCopyAllPolicies = InsurancePolicies.deepCopyHashMap(allPolicies);

        System.out.println("Shallow copy of all policies:");
        InsurancePolicies.printPolicies(shallowCopyAllPolicies);

        System.out.println();

        System.out.println("Deep copy of all policies:");
        InsurancePolicies.printPolicies(deepCopyAllPolicies);

        System.out.println("___________________________________");

//        shallow & deep copy of users

        System.out.println("Shallow & Deep Copy of users: \n\n");

        HashMap<Integer, User> allUsers = insuranceCompany.getUsers();
        HashMap<Integer, User> shallowCopyAllUsers = User.shallowCopyHashMap(allUsers);
        HashMap<Integer, User> deepCopyAllUsers = User.deepCopyHashMap(allUsers);

        System.out.println("Shallow copy of all users:");
        User.printUsers(shallowCopyAllUsers);

        System.out.println();

        System.out.println("Deep copy of all users:");
        User.printUsers(deepCopyAllUsers);

        System.out.println("___________________________________");

//        sorting policies by Comparable:

        System.out.println("Sorting policies: \n\n");

        System.out.println("Policies before sorted:");
        InsurancePolicies.printPolicies(allPolicies);

        ArrayList<InsurancePolicies> shallowCopy = new ArrayList<>();
        for(InsurancePolicies policy: allPolicies.values()){
            shallowCopy.add(policy);
        }
        Collections.sort(shallowCopy);
        System.out.println();
        System.out.println("Policies after sorted by expiry date:");
        InsurancePolicies.printPolicies(shallowCopy);

        System.out.println("___________________________________");

//        sorting users by Comparator:

        System.out.println("Sorting users: \n\n");

        System.out.println("Users before sorted:");
        User.printUsers(allUsers);

        ArrayList<User> shallowCopyUsers = new ArrayList<>();
        for(User user: allUsers.values()){
            shallowCopyUsers.add(user);
        }
        TotalPremiumPaymentComparator totalPremiumPaymentComparator = new TotalPremiumPaymentComparator();
        Collections.sort(shallowCopyUsers, totalPremiumPaymentComparator);


        System.out.println("Users after sorted by total premium payment:");
        User.printUsers(shallowCopyUsers);




//        ASSIGNMENT 2:


        System.out.println("___________________________________");

// testing the save and load policies in/from BINARY FILE

        System.out.println("testing the save and load policies in/from BINARY FILE: \n\n");

        try {
            InsurancePolicies.save(insuranceCompany.allPolicies(), "policies.ser");
            HashMap<Integer, InsurancePolicies> policies = InsurancePolicies.load("policies.ser");
            System.out.println("Printing a list of policies loaded from binary file");
            InsurancePolicies.printPolicies(policies);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e);
        }


        System.out.println("___________________________________");

//        testing the save and load policies in/from TEXT FILE

        System.out.println("testing the save and load policies in/from TEXT FILE: \n\n");

        try {
            InsurancePolicies.saveTextFile(insuranceCompany.allPolicies(), "policies.txt");
            HashMap<Integer, InsurancePolicies> policies = InsurancePolicies.loadTextFile("policies.txt");
            System.out.println("Printing a list of policies loaded from Text file");
            InsurancePolicies.printPolicies(policies);
        } catch (IOException e) {
            System.err.println(e);
        }


        System.out.println("___________________________________");

//        testing the save and load users in/from BINARY FILE

        System.out.println("testing the save and load users in/from BINARY FILE: \n\n");

        try
        {
            User.save(insuranceCompany.getUsers(),"users.ser");
            HashMap<Integer,User> users=User.load("users.ser");
            System.out.println("Printing a list of users loaded from binary file");
            User.printUsers(users);
        }
        catch (IOException e)
        {
            System.err.println(e);
        }

        System.out.println("___________________________________");

//        testing the save and load users in/from TEXT FILE

        System.out.println("testing the save and load users in/from TEXT FILE: \n\n");

        try
        {
            User.saveTextFile(insuranceCompany.getUsers(),"users.txt");
            HashMap<Integer,User> users=User.loadTextFile("users.txt");
            System.out.println("Printing a list of users loaded from Text file");
            User.printUsers(users);
        }
        catch (IOException e)
        {
            System.err.println(e);
        }

        System.out.println("___________________________________");

//        testing the save and load InsuranceCompany in/from BINARY FILE

        System.out.println("testing the save and load InsuranceCompany in/from BINARY FILE: \n\n");

        try
        {
            insuranceCompany.save("company.ser");
            InsuranceCompany insuranceCompany2=new InsuranceCompany(); // use default constructor
            insuranceCompany2.load("company.ser");
            System.out.println("Printing the insurance company loaded from binary file");
            System.out.println(insuranceCompany2);
        } catch (IOException | ClassNotFoundException e)
        {
            System.err.println(e);
        }

        System.out.println("___________________________________");

//        testing the save and load InsuranceCompany in/from Text FILE

        System.out.println("testing the save and load InsuranceCompany in/from Text FILE: \n\n");

        try
        {
            insuranceCompany.saveTextFile("company.txt");
            InsuranceCompany insuranceCompany2=new InsuranceCompany();
            insuranceCompany2.loadTextFile("company.txt");
            System.out.println("Printing the insurance company loaded from text file");
            System.out.println(insuranceCompany2.getUsers());
        }
        catch (IOException e)
        {
            System.err.println(e);
        }
    }

}
