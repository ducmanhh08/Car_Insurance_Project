package CarInsuranceCompany;

import java.io.IOException;
import java.util.HashMap;
public class SerializableTestCode {

    public static void main(String[] args) throws IOException, PolicyException, PolicyHolderNameException {
        new SerializableTestCode().run();
    }

    private void run() throws IOException, PolicyException, PolicyHolderNameException {

        Car carLUX = new Car(Car.CarType.LUX, "Audi Q8", 2021, 56000.00);
        Car carSPORTS = new Car(Car.CarType.SPORTS, "Porsche Taycan", 2023, 32000.00);
        Car carSUV = new Car(Car.CarType.SUV, "Mazda CX-5", 2020, 35000.00);

        HashMap<Integer,InsurancePolicies> policies= new HashMap<>();
        HashMap<Integer, User> users = new HashMap<>();
        InsuranceCompany insuranceCompany = new InsuranceCompany("Insurance Company", "uow", "2023");
        String adminUsername = insuranceCompany.getAdminUsername();
        String adminPassword = insuranceCompany.getAdminPassword();
        User myUser = new User("Matthew Nguyen", 1, new Address(7, "New Dapto Road", "2500", "Wollongong"), "manh" , "manh");

//        insuranceCompany.addUser(myUser);

        // testing binary file and list of policies

        System.out.println("1. Testing binary file and list of policies");
        System.out.println();
        try{

            policies.put( 12, new ThirdPartyPolicy("Matthew Nguyen", 333333, carLUX, 1, new MyDate(8, 11, 2020), "Repairing accessories"));
            InsurancePolicies.save(policies,"policies.ser");
            policies.clear();

            policies =InsurancePolicies.load("policies.ser");

            System.out.println();

            InsurancePolicies.printPolicies(policies);
        } catch (IOException e) {
            System.out.println("IO error: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        System.out.println("\n ----------------------------------------");

//        testing binary file and list of users

        System.out.println("2. Testing binary file and list of users");
        System.out.println();

        try {

            User userr=new User("Matthew Nguyen", 1, new Address(7, "New Dapto Road", "2500", "Wollongong"),"manh", "manh");
            userr.addPolicy(new ThirdPartyPolicy("Matthew Nguyen", 333333, carLUX, 1, new MyDate(8, 11, 2020), "Repairing accessories"));
            users.put(120,userr);


            User.save(users,"users.ser");
            users.clear();

            users=User.load("users.ser");

            System.out.println();

            User.printUsers(users);
        } catch (IOException e) {
            System.out.println("IO error: " + e);
        }

        System.out.println("\n ----------------------------------------");

        //InsuranceCompany and binary file

        System.out.println("3. InsuranceCompany and binary file");
        System.out.println();

        try {
            InsuranceCompany insuranceCompany1 = new InsuranceCompany();//using default constructor

            User newUser = new User("Chang Ham", 2, new Address(167, "Tay Son", "Dong Da", "Hanoi"), "manh", "manh");
            insuranceCompany1.addUser(newUser);
            newUser.getPolicies().put(2, new ComprehensivePolicy("Hai Yen", 345678, carLUX, 5, new MyDate(2, 5, 2002), 26, 4));

            insuranceCompany1.save("company.ser");
            InsuranceCompany insuranceCompany2 = new InsuranceCompany();

            insuranceCompany2.load("company.ser");
            System.out.println(insuranceCompany1);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("IO error: " + e);
        }

//        try {
//            HashMap<Integer,User> users= new HashMap<>();
//            User.printUsers(users);
//
//            User user = new User("Matthew Nguyen", 1, new Address(7, "New Dapto Road", "2500", "Wollongong"));
//            user.addPolicy(new ThirdPartyPolicy("Jayla Tiger", 2, new Car(Car.CarType.SPORTS, "Porsche Taycan", 2023, 32000.00), 4, new MyDate(30, 12, 2022), "abcd"));
//            users.put(120,user);
//            User.save(users,"users.txt");
//            users.clear();
//
//            users=User.load("users.txt");
//            User.printUsers(users);
//        } catch (Exception e){
//            System.out.println("IO error: " + e);
//        }

        System.out.println("\n ----------------------------------------");

        //testing text file and list of policies with toDelimitedString:
        System.out.println("4. Testing text file and list of policies");
        System.out.println();

        try{

            InsurancePolicies.printPolicies(policies);

            policies.put( 15,new ThirdPartyPolicy("Matthew Nguyen", 333444, carLUX, 1, new MyDate(8, 11, 2020), "Repairing accessories"));
            InsurancePolicies.saveTextFile(policies,"policiesText.txt");
            System.out.println ("Save and load finished");
            policies.clear();

            policies=InsurancePolicies.loadTextFile("policiesText.txt");
            InsurancePolicies.printPolicies(policies);
        } catch (IOException e){
            System.out.println("IO error: " + e);
        }

        System.out.println("\n ----------------------------------------");

        //testing text file and list of users with toDelimitedString
        System.out.println("5. Testing text file and list of users");
        System.out.println();

        try {

            User.printUsers(users);

            User user = new User("Chang Ham", 2, new Address(167, "Tay Son", "Dong Da", "Hanoi"),"manh", "manh");
            user.addPolicy(new ThirdPartyPolicy("Kudo Sinichi", 321654, carSUV, 3, new MyDate(21, 10, 2018), "Returning products"));
            users.put(122, user);
            User.saveTextFile(users, "usersText.txt");
            System.out.println ("Save and load finished");
            users.clear();

            users = User.loadTextFile("usersText.txt");
            User.printUsers(users);
        } catch (IOException e) {
            System.out.println("IO error: " + e);
        }

        System.out.println("\n ----------------------------------------");

        //InsuranceCompany and text file
        System.out.println("6. Testing text file and insurance company");
        System.out.println();

        try {

            insuranceCompany.addUser(new User("Chang Ham", 2, new Address(167, "Tay Son", "Dong Da", "Hanoi"), "manh", "manh"));
            insuranceCompany.addPolicy(2,new ComprehensivePolicy("Blaze Charlie", 303030, carSPORTS, 2, new MyDate(2, 5, 2024), 22, 2));

            insuranceCompany.saveTextFile("companyText.txt");
            InsuranceCompany insuranceCompany2=new InsuranceCompany();

            insuranceCompany2.loadTextFile("companyText.txt");
            System.out.println(insuranceCompany2);
        } catch (IOException e) {
            System.out.println("IO error: " + e);
        }
    }
}
