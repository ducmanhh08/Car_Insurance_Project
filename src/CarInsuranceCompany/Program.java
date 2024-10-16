package CarInsuranceCompany;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.lang.String;

public class Program {

    private static final int flatRate = 100;
    private static java.lang.String String;

    public static boolean isNumber(String s){
        for(int i=0; i<s.length(); i++){
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) throws PolicyException, PolicyHolderNameException, IOException, ClassNotFoundException, CloneNotSupportedException {

//        create company:

        InsuranceCompany insuranceCompany = new InsuranceCompany("Insurance Company", "uow", "2023");

        User myUser = new User("Matthew Nguyen 123", 1, new Address(7, "New Dapto Road", "2500", "Wollongong"), "manh", "manh");
        User myUser2 = new User("Chang Ham", 2, new Address(167, "Tay Son", "Dong Da", "Hanoi"), "manh", "manh");

        Car carLUX = new Car(Car.CarType.LUX, "Audi Q8", 2021, 56000.00);
        Car carSPORTS = new Car(Car.CarType.SPORTS, "Porsche Taycan", 2023, 32000.00);
        Car carSUV = new Car(Car.CarType.SUV, "Mazda CX-5", 2020, 35000.00);

        ThirdPartyPolicy thirdPartyPolicy1 = new ThirdPartyPolicy("Matthew Nguyen", 1, carLUX, 1, new MyDate(8, 11, 2020), "Repairing accessories");
        ThirdPartyPolicy thirdPartyPolicy2 = new ThirdPartyPolicy("Jayla Tiger", 2, carSPORTS, 4, new MyDate(30, 12, 2022), "Returning products");
        ComprehensivePolicy comprehensivePolicy1 = new ComprehensivePolicy("Blaze Charlie", 3, carSPORTS, 2, new MyDate(2, 5, 2024), 22, 2);

        ThirdPartyPolicy thirdPartyPolicy3 = new ThirdPartyPolicy("Kudo Sinichi", 1, carSUV, 3, new MyDate(21, 10, 2018), "Returning products");
        ComprehensivePolicy comprehensivePolicy2 = new ComprehensivePolicy("Hai Yen Dao", 2, carLUX, 5, new MyDate(2, 5, 2002), 26, 4);


        insuranceCompany.addUser(myUser);
        insuranceCompany.addUser(myUser2);

        myUser.addPolicy(myUser.getUserUsername(), myUser.getUserPassword(), thirdPartyPolicy1);
        myUser.addPolicy(myUser.getUserUsername(), myUser2.getUserPassword(), thirdPartyPolicy2);
        myUser.addPolicy(myUser.getUserUsername(), myUser2.getUserPassword(), comprehensivePolicy1);

        myUser2.addPolicy(thirdPartyPolicy3);
        myUser2.addPolicy(comprehensivePolicy2);

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // clear screen


        Scanner enter = new Scanner(System.in);

//        PROGRAM:

        int select = 0;
        while (select != 3) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // clear screen

            System.out.println("Main Menu");
            System.out.println("--------------------");
            System.out.println("\n\n\n");
            System.out.println("1) Admin Login");
            System.out.println("2) User Login");
            System.out.println("3) Exit");
            try {
                System.out.print("\n\nPlease select an option: ");

                select = enter.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong input. Please try again");
//                select = 3;

                System.out.println("\n");
                System.out.println("Press enter to continue");
                System.out.println("\n");


                enter.nextLine();
                enter.nextLine();


            }

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // clear screen

            switch (select) {
                case 1:
                    try {
                        login(insuranceCompany);
                    } catch (Exception e) {
                        System.out.println("Sorry. Please try ");
                    }

                    mainMenu(insuranceCompany);


                    break;

                case 2:
                    try {
                        userMenu(insuranceCompany);
                    } catch (IOException e){
                        System.out.println(e);
                    } catch (CloneNotSupportedException e) {
                        System.out.println(e);
                    } catch (ClassNotFoundException e) {
                        System.out.println(e);
                    }
                    break;

                case 3:
                    return;

//                default:
//                    System.out.println("Wrong option. Please try again.");
//
//                    System.out.println("\n");
//                    System.out.println("Press enter to continue");
//                    System.out.println("\n");
//
//                    enter.nextLine();
//                    enter.nextLine();
//
//                    break;

            }
        }
    }

    private static void login(InsuranceCompany insuranceCompany) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // clear screen

        Scanner input = new Scanner(System.in);

        System.out.print("Username: ");
        String username = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();

        if (!insuranceCompany.validateAdmin(username, password)) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // clear screen
            System.out.println("Wrong. Please log in again (Hint: Try username: uow & password: 2023)");
            System.out.println("Press enter to continue");
            input.nextLine();

            System.out.println("(Hint) username: uow & password: 2023");
            login(insuranceCompany);
        }

    }

    private static void loginUser(InsuranceCompany insuranceCompany, int userID) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // clear screen

        Scanner input = new Scanner(System.in);

        System.out.print("Username: ");
        String username = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();

        if (!insuranceCompany.validateAdmin(username, password)) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // clear screen
            System.out.println("Wrong. Please log in again (Hint: Try username: uow & password: 2023)");
            System.out.println("Press enter to continue");
            input.nextLine();

            System.out.println("(Hint) username: uow & password: 2023");
            login(insuranceCompany);
        }

    }

    public static void mainMenu(InsuranceCompany insuranceCompany) throws PolicyException, CloneNotSupportedException, IOException, PolicyHolderNameException, ClassNotFoundException {

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // clear screen


        Scanner input = new Scanner(System.in);
        int option = 0;
        while (option != 30) {

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // clear screen

            System.out.println("Admin Menu");
            System.out.println("--------------------");
            System.out.println("1) Test Code");
            System.out.println("2) Create User");
            System.out.println("3) Create ThirdParty Policy");
            System.out.println("4) Create Comprehensive Policy");
            System.out.println("5) Print User Information");
            System.out.println("6) Filter By Car Model");
            System.out.println("7) Filter By Expiry Date");
            System.out.println("8) Update Address");
            System.out.println("9) Report Payment Per Car Model");
            System.out.println("10) Report Payment Per City (All Users");
            System.out.println("11) Report Payment Per Car Model (All Users)");
            System.out.println("12) Remove An User");
            System.out.println("13) Remove A Policy");
            System.out.println("14) Change Password");
            System.out.println("15) Print All Users");
            System.out.println("16) Shallow Copy a List of users");
            System.out.println("17) Deep Copy a List of users");
            System.out.println("18) Shallow Copy a List of policies by user");
            System.out.println("19) Deep Copy a List of policies by user");
            System.out.println("20) Sort List of users");
            System.out.println("21) Sort List of users by Total Premium Payments");
            System.out.println("22) Sort List of policies of an user by Expiry date");
            System.out.println("23) Filter List of policies by Expiry date");
            System.out.println("24) Load and save a binary file of Insurance Company");
            System.out.println("25) Load and save a binary file of List of users");
            System.out.println("26) Load and save a binary file of List of policies");
            System.out.println("27) Load and save a text file of Insurance Company");
            System.out.println("28) Load and save a text file of List of users");
            System.out.println("29) Load and save a text file of List of policies");
            System.out.println("30) Log Out");
            System.out.print("\n\nPlease enter an option: ");

            try {
                option = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong input. Please try again");
            }

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // clear screen


            Scanner scan = new Scanner(System.in);
            int countUser = 2;

            switch (option) {
                case 1:

                    try {
                        TestCode.run();
                    } catch (Exception e){
                        System.out.println("Something wrong. Please try again");
                    }

                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 2:

                    String name = "";

                    String streetNum = "";
                    String street = "";
                    String suburb = "";
                    String city = "";

                    String username = "";
                    String password = "";

                    try {

                        boolean check = false;
                        boolean check1 = false;

                        while (!check) {
                            System.out.print("Please enter user name: ");
                            name = scan.nextLine();
                            if (!name.matches("^[a-zA-Z\\s]+$")) {
                                System.out.println();
                                System.out.println("Please try again with different user name");
                            } else {
                                if (name.equals("exit")) {
                                    return;
                                }
                                System.out.println();
                                check = true;
                            }
                        }

                        System.out.println("Please enter user address");

                        while (!check1) {
                            System.out.print("Street number: ");
                            streetNum = scan.next();

                            if (!(streetNum.matches("^\\d+(\\.\\d+)?"))) {
                                System.out.println();
                                System.out.println("Please try again with another street number");
                            } else if (streetNum.equals("exit")) {
                                break;
                            } else {
                                check1 = true;
                            }
                        }

                        while (check1) {
                            System.out.print("Street: ");
                            street = scan.next();

                            if (!street.matches("^[a-zA-Z\\s]+$")) {
                                System.out.println();
                                System.out.println("Please try again with another street number");
                            } else {
                                check1 = false;
                            }
                        }

                        while (!check1) {
                            System.out.print("Suburb: ");
                            suburb = scan.next();

                            if (!suburb.matches("^[a-zA-Z\\s]+$")) {
                                System.out.println();
                                System.out.println("Please try again with another suburb");
                            } else {
                                check1 = true;
                            }
                        }

                        while (check1) {
                            System.out.print("City: ");
                            city = scan.next();

                            if (!city.matches("^[a-zA-Z\\s]+$")) {
                                System.out.println();
                                System.out.println("Please try again with another city");
                            } else {
                                check1 = false;
                            }
                        }

                        Address address = new Address(Integer.parseInt(streetNum), street, suburb, city);

                        while (!check1) {
                            System.out.print("Username: ");
                            username = scan.next();

                            if (!city.matches("^[a-zA-Z\\s]+$")) {
                                System.out.println();
                                System.out.println("Please try again with another user name");
                            } else {
                                check1 = true;
                            }
                        }

                        while (check1) {
                            System.out.print("Password: ");
                            password = scan.next();

                            if (!city.matches("^[a-zA-Z\\s]+$")) {
                                System.out.println();
                                System.out.println("Please try again with another password");
                            } else {
                                check1 = false;
                            }
                        }

                        User newUser = new User(name, countUser, address, username, password);

                        countUser++;

                        insuranceCompany.addUser(newUser);

                        System.out.println("New user is created. Choose option 15 in the menu for checking.");


                    } catch (InputMismatchException e){
                        System.out.println();
                    }

                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 3:
//                    try {
                        createThirdPartyPolicy(insuranceCompany);
//                    } catch (InputMismatchException e) {
//                        System.out.println("\n");
//                        System.out.println("Press enter to continue");
//                        System.out.println("\n");
//
//                        scan.nextLine();
//                        scan.nextLine();
//
//                        break;

//                    }

                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 4:

                    try {
                        createComprehensivePolicy(insuranceCompany);
                    } catch (Exception e) {
                        System.out.println("Something wrong. Error: " + e + "\nPlease try again.");

                    }


                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 5:
                    System.out.print("Please enter an user ID: ");
                    int userID = scan.nextInt();
                    try {
                        insuranceCompany.findUser(userID).print();
                    } catch (Exception e) {
                        System.out.println("Sorry, user ID is invalid or not existed. Please try again.");
                    }

                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 6:
                    System.out.print("Please enter a car model: ");
                    String carModel = scan.nextLine();
                    System.out.println();

                    ArrayList<InsurancePolicies> filterByCarModel = insuranceCompany.filterByCarModel(carModel);
                    if (filterByCarModel.size() == 0) {
                        System.out.println("No car model as input.");
                    } else {
                        InsurancePolicies.printPolicies(filterByCarModel);
                        System.out.println();
                        System.out.println("Total payment by car model: " + InsurancePolicies.calcTotalPayments(filterByCarModel, flatRate));
                    }
                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 7:
                    System.out.print("Please enter an user ID: ");
                    int userIdExpiryDate = scan.nextInt();
                    System.out.print("Please enter a date: ");
                    int day = scan.nextInt();
                    int month = scan.nextInt();
                    int year = scan.nextInt();
                    MyDate date = new MyDate(day, month, year);

                    ArrayList<InsurancePolicies> filterByExpiryDate = insuranceCompany.filterByExpiryDate(userIdExpiryDate, date);


                    if (filterByExpiryDate.size() > 0) {
                        System.out.println("The policies are expired by " + date);
                        InsurancePolicies.printPolicies(filterByExpiryDate);
                    } else {
                        System.out.println("No car is expired by " + date);
                    }

                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 8:

                    System.out.print("Please enter an user ID: ");
                    int userIdAddress = scan.nextInt();
                    User userAddress = insuranceCompany.findUser(userIdAddress);

                    streetNum = "";
                    street = "";
                    suburb = "";
                    city = "";

                    if (userAddress != null) {
                        try {

                            boolean check = false;
                            boolean check1 = false;

                            System.out.println("Please enter new address");

                            while (!check1) {
                                System.out.print("Street number: ");
                                streetNum = scan.next();

                                if (!(streetNum.matches("^\\d+(\\.\\d+)?"))) {
                                    System.out.println();
                                    System.out.println("Please try again with another street number");
                                } else if (streetNum.equals("exit")) {
                                    break;
                                } else {
                                    check1 = true;
                                }
                            }

                            while (check1) {
                                System.out.print("Street: ");
                                street = scan.next();

                                if (!street.matches("^[a-zA-Z\\s]+$")) {
                                    System.out.println();
                                    System.out.println("Please try again with another street number");
                                } else {
                                    check1 = false;
                                }
                            }

                            while (!check1) {
                                System.out.print("Suburb: ");
                                suburb = scan.next();

                                if (!suburb.matches("^[a-zA-Z\\s]+$")) {
                                    System.out.println();
                                    System.out.println("Please try again with another suburb");
                                } else {
                                    check1 = true;
                                }
                            }

                            while (check1) {
                                System.out.print("City: ");
                                city = scan.next();

                                if (!city.matches("^[a-zA-Z\\s]+$")) {
                                    System.out.println();
                                    System.out.println("Please try again with another city");
                                } else {
                                    check1 = false;
                                }
                            }

                            userAddress.getAddress().setStreetNum(Integer.parseInt(streetNum));
                            userAddress.getAddress().setStreet(street);
                            userAddress.getAddress().setSuburb(suburb);
                            userAddress.getAddress().setCity(city);

                            System.out.println("\nAddress is successfully updated!\n");

                        } catch (Exception e) {
                            System.out.println("Something wrong. Error: ");
                            System.out.println();
                            System.out.println("Please try again.");
                        }
                    }

                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 9:
                    try {

                        boolean check = false;

                        String userId = "";

                        while (!check){
                            System.out.print("Please enter an user ID: ");
                            userId = scan.next();

                            if(!userId.matches("^\\d+(\\.\\d+)?")){
                                System.out.println();
                                System.out.println("Please enter a valid user ID");
                            } else {
                                check = true;
                            }
                        }

                        userID = Integer.parseInt(userId);

                        System.out.println("Total payment per car model: ");
                        User user = insuranceCompany.findUser(userID);
                        user.reportTotalPremiumPerCarModel(user.getTotalCountPerCarModel(), user.getTotalPremiumPerCarModel());

                    } catch (Exception e) {
                        System.out.println("Something wrong. Error: " + e);
                    }

                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 10:
                    try {
                        System.out.println("Total payments per city: ");
                        insuranceCompany.reportTotalPremiumPerCity(insuranceCompany.getTotalPremiumPerCity());
                    } catch (Exception e) {
                        System.out.println("Something wrong. Error: " + e);
                    }

                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 11:

                    try {
                        System.out.println("Total payments per car model: ");
                        insuranceCompany.reportTotalPremiumPerCarModel(insuranceCompany.getTotalCountPerCarModel(), insuranceCompany.getTotalPremiumPerCarModel());
                    } catch (Exception e) {
                        System.out.println("Something wrong. Error: " + e);
                    }

                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 12:
                    try {
                        removeUser(insuranceCompany);
                    } catch (Exception e) {
                        System.out.println("Something wrong. Please try again.");
                    }

                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 13:

                    try {
                        removePolicy(insuranceCompany);
                    } catch (Exception e) {
                        System.out.println("Something wrong. Please try again.");
                    }

                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 14:

                    try {
                        changePassword(insuranceCompany);
                    } catch (Exception e) {
                        System.out.println("Something wrong. Please try again.");

                    }

                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 15:
                    User.printUsers(insuranceCompany.getUsers());

                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 16:
                    HashMap<Integer, User> shallowCopyUsers = insuranceCompany.shallowCopyUsersHashMap();
                    User.printUsers(shallowCopyUsers);

                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 17:
                    HashMap<Integer, User> deepCopyUsers = insuranceCompany.deepCopyUsersHashMap();
                    User.printUsers(deepCopyUsers);

                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 18:
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Please enter an user ID: ");
                    int userId = scanner.nextInt();

                    System.out.println();

                    HashMap<Integer, InsurancePolicies> shallowCopyPolicies = insuranceCompany.findUser(userId).shallowCopyPoliciesHashMap();
                    User.printPolicies(shallowCopyPolicies);

                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 19:
                    scanner = new Scanner(System.in);
                    System.out.print("Please enter an user ID: ");
                    userId = scanner.nextInt();

                    System.out.println();

                    HashMap<Integer, InsurancePolicies> deepCopyPolicies = insuranceCompany.findUser(userId).deepCopyPoliciesHashMap();
                    User.printPolicies(deepCopyPolicies);

                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 20:

                    System.out.println("List of users before sorted: \n");
                    User.printUsers(insuranceCompany.getUsers());

                    System.out.println();

                    System.out.println("List of users after sorted: \n");
                    ArrayList<User> sortedUsers = insuranceCompany.sortUsers();
                    User.printUsers(sortedUsers);


                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 21:

                    System.out.println("List of users before sorted: \n");
                    User.printUsers(insuranceCompany.getUsers());

                    System.out.println();

                    System.out.println("List of users after sorted by total premium payments: \n");
                    ArrayList<User> sortedUsersByPayment = insuranceCompany.sortUsersByPremium();
                    User.printUsers(sortedUsersByPayment);

                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 22:
                    scanner = new Scanner(System.in);
                    System.out.print("Please enter an user ID: ");
                    userId = scanner.nextInt();

                    User user = insuranceCompany.findUser(userId);
                    ArrayList<InsurancePolicies> sortedPoliciesByDate = user.sortPoliciesByDate();
                    User.printPolicies(sortedPoliciesByDate);

                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 23:
                    scanner = new Scanner(System.in);
                    System.out.print("Please enter an expiry date: ");
                    day = scanner.nextInt();
                    month = scanner.nextInt();
                    year = scanner.nextInt();
                    MyDate expiryDate = new MyDate(day, month, year);

                    System.out.println();

                    HashMap<String, ArrayList<InsurancePolicies>> filteredPolicies = insuranceCompany.filterPoliciesByExpiryDate(expiryDate);
                    System.out.println("User names and polices expired by " + expiryDate + "\n\n");
                    for(String userName: filteredPolicies.keySet()){
                        System.out.println(userName);
                        User.printPolicies(filteredPolicies.get(userName));
                        System.out.println();
                    }

                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 24:
                    scanner = new Scanner(System.in);
                    System.out.println("1) Load \n2) Save \n3) Back");
                    System.out.print("Choose your option: ");
                    int opt = scanner.nextInt();

                    InsuranceCompany insuranceCompany1 = new InsuranceCompany();

                    switch (opt){
                        case 1:
                            System.out.println("Loading binary file from company.ser: \n");
                            insuranceCompany1.load("company.ser");
                            insuranceCompany.print();

                            break;

                        case 2:
                            insuranceCompany.save("company.ser");
                            System.out.println("Saving text file to company.ser");

                            break;

                        case 3:
                            break;
                    }

                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 25:

                    scanner = new Scanner(System.in);
                    System.out.println("1) Load \n2) Save \n3) Back");
                    System.out.print("Choose your option: ");
                    opt = scanner.nextInt();


                    switch (opt){
                        case 1:
                            System.out.println("Loading binary file from users.ser: \n");
                            HashMap<Integer,User> users=User.load("users.ser");
                            User.printUsers(users);

                            break;

                        case 2:
                            User.save(insuranceCompany.getUsers(),"users.ser");
                            System.out.println("Saving text file to users.ser");
                            break;

                        case 3:
                            break;
                    }

                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 26:

                    scanner = new Scanner(System.in);
                    System.out.println("1) Load \n2) Save \n3) Back");
                    System.out.print("Choose your option: ");
                    opt = scanner.nextInt();
                    user = insuranceCompany.findUser(1);


                    switch (opt){
                        case 1:
                            System.out.println("Loading binary file from policies.ser: \n");
//                            HashMap<Integer,InsurancePolicies> policies=InsurancePolicies.load("policies.ser");
                            InsurancePolicies.printPolicies(user.getPolicies());

                            break;

                        case 2:
                            InsurancePolicies.save(user.getPolicies(),"policies.ser");
                            User.save(insuranceCompany.getUsers(),"policies.ser");
                            System.out.println("Saving text file to policies.ser");

                            break;

                        case 3:
                            break;
                    }

                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 27:
                    scanner = new Scanner(System.in);
                    System.out.println("1) Load \n2) Save \n3) Back");
                    System.out.print("Choose your option: ");
                    opt = scanner.nextInt();

                    insuranceCompany1 = new InsuranceCompany();

                    switch (opt){
                        case 1:
                            System.out.println("Loading text file from companyText.txt: \n");
                            insuranceCompany1.loadTextFile("companyText.txt");
                            System.out.println(insuranceCompany1);

                            break;

                        case 2:
                            insuranceCompany.saveTextFile("companyText.txt");
                            System.out.println("Saving text file to companyText.txt.");

                            break;

                        case 3:
                            break;
                    }

                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;

                case 28:
                    scanner = new Scanner(System.in);
                    System.out.println("1) Load \n2) Save \n3) Back");
                    System.out.print("Choose your option: ");
                    opt = scanner.nextInt();


                    switch (opt){
                        case 1:
                            System.out.println("Loading text file from usersText.txt: \n");
                            HashMap<Integer,User> users=User.loadTextFile("users.txt");
                            User.printUsers(users);

                            break;

                        case 2:
                            User.saveTextFile(insuranceCompany.getUsers(),"usersText.txt");
                            System.out.println("Saving text file to usersText.txt.");

                            break;
                        case 3:
                            break;
                    }

                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;


                case 29:

                    scanner = new Scanner(System.in);
                    System.out.println("1) Load \n2) Save \n3) Back");
                    System.out.print("Choose your option: ");
                    opt = scanner.nextInt();
                    user = insuranceCompany.findUser(1);


                    switch (opt){
                        case 1:
                            System.out.println("Loading text file from policiesText.txt: \n");
                            HashMap<Integer,InsurancePolicies> policies=InsurancePolicies.loadTextFile("policiesText.txt");
                            InsurancePolicies.printPolicies(policies);

                            break;

                        case 2:
                            InsurancePolicies.saveTextFile(user.getPolicies(),"policiesText.txt");
//                            User.saveTextFile(insuranceCompany.getUsers(),"policiesText.txt");
                            System.out.println("Saving text file to policiesText.txt.");

                            break;

                        case 3:
                            break;
                    }

                    System.out.println("\n");
                    System.out.println("Press enter to continue");
                    System.out.println("\n");

                    scan.nextLine();
                    scan.nextLine();

                    break;


                case 30:
                    return;

                default:
                    System.out.println("Wrong option. Try again");
                    break;
            }

        }
    }

    public static void userMenu(InsuranceCompany insuranceCompany) throws IOException, PolicyException, PolicyHolderNameException, CloneNotSupportedException, ClassNotFoundException {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // clear screen

        Scanner input = new Scanner(System.in);
        boolean checkUser = false;

        System.out.print("Please enter an User ID: ");
        int userID = input.nextInt();
        User user = insuranceCompany.findUser(userID);
        String username = user.getUserUsername();
        String password = user.getUserPassword();

        while (!checkUser){
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter username && password ");
            System.out.print("Username: ");
            String inputUsername = scan.nextLine();
            System.out.print("Password: ");
            String inputPassword = scan.nextLine();

            if(user.validateUser(inputUsername, inputPassword)){
                checkUser = true;
            }

            if(inputUsername.equals("exit") || inputPassword.equals("exit")){
                checkUser = true;
                break;
            }
        }

        if (user != null) {


            int option = 0;

            while (option != 16) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // clear screen

                System.out.println("User Menu");
                System.out.println("--------------------");
                System.out.println("1) Print User Information");
                System.out.println("2) Calculate Total Premium Payment");
                System.out.println("3) Rise All Car Prices");
                System.out.println("4) Create ThirdParty Policy");
                System.out.println("5) Create Comprehensive Policy");
                System.out.println("6) Filter By Car Model");
                System.out.println("7) Filter By Expiry Date");
                System.out.println("8) Update Address");
                System.out.println("9) Report Payment By Car Model");
                System.out.println("10) Remove A Policy");
                System.out.println("11) Shallow Copy a List of policies");
                System.out.println("12) Deep Copy a List of policies");
                System.out.println("13) Sort List of policies by Expiry date");
                System.out.println("14) Load and save a binary file of List of policies");
                System.out.println("15) Load and save a text file of List of policies");
                System.out.println("16) Log Out");
                System.out.print("\n\nPlease enter an option: ");

                option = input.nextInt();

                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                Scanner scan = new Scanner(System.in);

                switch (option) {
                    case 1:
                        user.print();

                        System.out.println("\n");
                        System.out.println("Press enter to continue");
                        System.out.println("\n");
                        scan.nextLine();

                        break;

                    case 2:
                        try {
                            user.printPolicies(flatRate);
                            System.out.println();
                            System.out.println("Total premium payment: " + user.calcTotalPremiums(flatRate));
                        } catch (Exception e) {
                            System.out.println("Sorry your ID is invalid");
                        }

                        System.out.println("\n");
                        System.out.println("Press enter to continue");
                        System.out.println("\n");
                        scan.nextLine();

                        break;

                    case 3:
                        System.out.print("Please enter a rise percent: ");
                        double percent = scan.nextInt();
                        user.carPriceRiseAll(percent / 100);
                        user.printPolicies(flatRate);

                        System.out.println("\n");
                        System.out.println("Press enter to continue");
                        System.out.println("\n");

                        scan.nextLine();
                        scan.nextLine();

                        break;

                    case 4:
                        try {
                            createThirdPartyPolicy(insuranceCompany);
                        } catch (Exception e) {
                            System.out.println("Something wrong. Error: " + e + "\nPlease try again.");
                        }

                        System.out.println("\n");
                        System.out.println("Press enter to continue");
                        System.out.println("\n");
                        scan.nextLine();

                        break;

                    case 5:

                        try {
                            createComprehensivePolicy(insuranceCompany);
                        } catch (Exception e) {
                            System.out.println("Something wrong. Error: " + e + "\nPlease try again.");
                        }

                        System.out.println("\n");
                        System.out.println("Press enter to continue");
                        System.out.println("\n");
                        scan.nextLine();
                        scan.nextLine();

                        break;

                    case 6:

                        System.out.print("Please enter a car model: ");
                        String carModel = scan.nextLine();


                        ArrayList<InsurancePolicies> filterByCarModel = user.filterByCarModel(carModel);

                        if (filterByCarModel.size() == 0) {
                            System.out.println("No car model as input.");
                        } else {

                            InsurancePolicies.printPolicies(filterByCarModel);
                            System.out.println();
                            System.out.println("Total payment by car model: " + InsurancePolicies.calcTotalPayments(filterByCarModel, flatRate));
                        }

                        System.out.println("\n");
                        System.out.println("Press enter to continue");
                        System.out.println("\n");
                        scan.nextLine();

                        break;

                    case 7:

                        System.out.print("Please enter a date: ");
                        int day = scan.nextInt();
                        int month = scan.nextInt();
                        int year = scan.nextInt();
                        MyDate date = new MyDate(day, month, year);

                        ArrayList<InsurancePolicies> filterByExpiryDate = user.filterByExpiryDate(date);

                        if (filterByExpiryDate.size() > 0) {
                            System.out.println("The policies are expired by " + date);
                            InsurancePolicies.printPolicies(filterByExpiryDate);
                        } else {
                            System.out.println("No car is expired by " + date);
                        }

                        System.out.println("\n");
                        System.out.println("Press enter to continue");
                        System.out.println("\n");
                        scan.nextLine();
                        scan.nextLine();

                        break;

                    case 8:
                        try {
                            System.out.print("Please enter new address: ");
                            user.getAddress().setStreetNum(scan.nextInt());
                            user.getAddress().setStreet(scan.next());
                            user.getAddress().setSuburb(scan.next());
                            user.getAddress().setCity(scan.next());

                            System.out.println("\nAddress is successfully updated!\n");

                        } catch (Exception e) {
                            System.out.println("Something wrong. Error: ");
                            System.out.println();
                            System.out.println("Please try again.");
                        }

                        System.out.println("\n");
                        System.out.println("Press enter to continue");
                        System.out.println("\n");
                        scan.nextLine();
                        scan.nextLine();

                        break;

                    case 9:
                        try {
                            System.out.println("Total payments per car model: ");
                            reportPaymentPerCarModels(insuranceCompany);
                        } catch (Exception e) {
                            System.out.println("Something wrong. Error: " + e);
                        }

                        System.out.println("\n");
                        System.out.println("Press enter to continue");
                        System.out.println("\n");

                        scan.nextLine();
                        scan.nextLine();

                        break;
                    case 10:

                        try {

                            removePolicy(insuranceCompany);

                        } catch (Exception e) {
                            System.out.println("Something wrong. Please try again");
                        }

                        System.out.println("\n");
                        System.out.println("Press enter to continue");
                        System.out.println("\n");

                        scan.nextLine();
                        scan.nextLine();

                        break;

                    case 11:

                        HashMap<Integer, InsurancePolicies> shallowCopyPolicies = user.shallowCopyPoliciesHashMap();
                        User.printPolicies(shallowCopyPolicies);

                        System.out.println("\n");
                        System.out.println("Press enter to continue");
                        System.out.println("\n");

                        scan.nextLine();
                        scan.nextLine();

                        break;

                    case 12:
                        HashMap<Integer, InsurancePolicies> deepCopyPolicies = user.deepCopyPoliciesHashMap();
                        User.printPolicies(deepCopyPolicies);

                        System.out.println("\n");
                        System.out.println("Press enter to continue");
                        System.out.println("\n");

                        scan.nextLine();
                        scan.nextLine();

                        break;

                    case 13:
                        ArrayList<InsurancePolicies> userPolicies = user.deepCopyPolicies();
                        System.out.println("List of policies before being sorted:");
                        InsurancePolicies.printPolicies(userPolicies);

                        System.out.println();


                        Collections.sort(userPolicies);
                        System.out.println("List of policies after being sorted:");
                        InsurancePolicies.printPolicies(userPolicies);


                        System.out.println("\n");
                        System.out.println("Press enter to continue");
                        System.out.println("\n");

                        scan.nextLine();
                        scan.nextLine();

                        break;

                    case 14:

                        Scanner scanner = new Scanner(System.in);
                        System.out.println("1) Load \n2) Save \n3) Back");
                        System.out.print("Choose your option: ");
                        int opt = scanner.nextInt();



                        switch (opt){
                            case 1:
                                System.out.println("Loading binary file from policies.ser: \n");
//                                HashMap<Integer,InsurancePolicies> policies=InsurancePolicies.load("policies.ser");
                                InsurancePolicies.printPolicies(user.getPolicies());

                                break;

                            case 2:
                                InsurancePolicies.save(user.getPolicies(),"policies.ser");
                                User.save(insuranceCompany.getUsers(),"policies.ser");
                                System.out.println("Saving text file to policies.ser");

                                break;

                            case 3:
                                break;
                        }

                        System.out.println("\n");
                        System.out.println("Press enter to continue");
                        System.out.println("\n");

                        scan.nextLine();
                        scan.nextLine();

                        break;

                    case 15:
                        scanner = new Scanner(System.in);
                        System.out.println("1) Load \n2) Save \n3) Back");
                        System.out.print("Choose your option: ");
                        opt = scanner.nextInt();



                        switch (opt){
                            case 1:
                                System.out.println("Loading text file from policies.txt: \n");
                                HashMap<Integer,InsurancePolicies> policies=InsurancePolicies.loadTextFile("policies.txt");
                                InsurancePolicies.printPolicies(policies);

                                break;

                            case 2:
                                InsurancePolicies.saveTextFile(user.getPolicies(),"policies.txt");
//                                User.saveTextFile(insuranceCompany.getUsers(),"policies.txt");
                                System.out.println("Saving text file to policiesText.txt.");

                                break;

                            case 3:
                                break;
                        }

                        System.out.println("\n");
                        System.out.println("Press enter to continue");
                        System.out.println("\n");

                        scan.nextLine();
                        scan.nextLine();

                        break;

                    case 16:
                        return;
                }
            }
        } else {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // clear screen
            System.out.println("Your user ID is not existed. Please try again.");
            System.out.println("Press enter to continue");
            input.nextLine();
            input.nextLine();
        }
    }

    public static void createThirdPartyPolicy(InsuranceCompany insuranceCompany) throws PolicyException {

        Scanner scan = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

        String userId = "";
        String policyHolderName = "";
        String policyID = "";
        String manufacturingYear = "";
        String price = "";
        Car.CarType type = null;

        try {

            boolean check = false;
            boolean check1 = false;

            while (!check) {

                System.out.print("Please enter user ID: ");
                userId = scan.next();


                if (!userId.matches("^\\d+(\\.\\d+)?")) {
                    System.out.println();
                    System.out.println("Please try again with another user ID");
                } else {
                    check = true;
                }
            }

            int userID = Integer.parseInt(userId);
            System.out.println();


            if (insuranceCompany.findUser(userID) != null) {

                while (!check1) {
                    System.out.print("Please enter policy holder name: ");
                    policyHolderName = input.nextLine();

                    if (!policyHolderName.matches("^[a-zA-Z\\s]+$")) {
                        System.out.println();
                        System.out.println("Please enter a valid policy holder name");
                    } else {
                        check1 = true;
                    }
                }

                while (check1) {
                    System.out.print("Please enter policy ID: ");
                    policyID = scan.next();

                    if (!policyID.matches("^\\d+(\\.\\d+)?")) {
                        System.out.println();
                        System.out.println("Please enter a valid policy ID");
                    } else {

                        check1 = false;
                    }
                }

                System.out.println("Please enter information of car: type (SUV, SED, LUX, HATCH, SPORTS) ; model ; manufacturing year ; price");

                while (!check1) {
                    System.out.print("Type: ");
                    type = Car.CarType.valueOf(scan.next());

                    if (!(type instanceof Car.CarType)) {
                        System.out.println();
                        System.out.println("Please enter a valid Car type");
                    } else {
                        check1 = true;
                    }
                }

                System.out.print("Model: ");
                String model = scan.next();

                while (check1) {
                    System.out.print("Manufacturing year: ");
                    manufacturingYear = scan.next();

                    if (!manufacturingYear.matches("^\\d+(\\.\\d+)?")) {
                        System.out.println();
                        System.out.println("Please enter a valid manufacturing year");
                    } else {
                        check1 = false;
                    }
                }

                while (!check1) {
                    System.out.print("Price: $");
                    price = scan.next();

                    if (!price.matches("^\\d+(\\.\\d+)?")) {
                        System.out.println();
                        System.out.println("Please enter a valid price");
                    } else {
                        check1 = true;
                    }
                }

                Car car = new Car(type, model, Integer.parseInt(manufacturingYear), Double.parseDouble(price));

                System.out.print("Please enter number of claims: ");
                int numberOfClaims = scan.nextInt();
                System.out.print("Please enter expiry date (day ; month ; year): ");
                int day = scan.nextInt();
                int month = scan.nextInt();
                int year = scan.nextInt();
                MyDate date = new MyDate(day, month, year);

                System.out.print("Please enter comment: ");
                String comment = scan.next();



                try {
//                    boolean checkPolicy = insuranceCompany.createThirdPartyPolicy(userID, policyHolderName, Integer.parseInt(policyID), car, numberOfClaims, date, comment);
                    ThirdPartyPolicy thirdPartyPolicy = new ThirdPartyPolicy(policyHolderName, Integer.parseInt(policyID), car, numberOfClaims, date, comment);
                    System.out.println();

//                    if (checkPolicy) {
//                        System.out.println("Create done. Choose option to check the policies of user");
//
//                    }

                    insuranceCompany.addPolicy(userID, thirdPartyPolicy);
                }  catch (PolicyException pe){
                    System.out.println(pe);
                }  catch (PolicyHolderNameException phe){
                    System.out.println(phe);
                }

            } else {
                System.out.println("User ID has not existed. Please try again.");
            }

        } catch (InputMismatchException e){
            System.out.println("Sorry, your input is wrong. Please try again");
        }
    }

    public static void createComprehensivePolicy(InsuranceCompany insuranceCompany) {

        Scanner scan = new Scanner(System.in);

        String userId = "";
        String policyHolderName = "";
        String policyID = "";
        String manufacturingYear = "";
        String price = "";
        Car.CarType type = null;


        try {

            boolean check = false;
            boolean check1 = false;

            while (!check) {
                System.out.print("Please enter user ID: ");
                userId = scan.next();

                if (!userId.matches("^\\d+(\\.\\d+)?")) {
                    System.out.println();
                    System.out.println("Please try again with another user ID");
                } else {
                    check = true;
                }
            }

            int userID = Integer.parseInt(userId);
            System.out.println();


            if (insuranceCompany.findUser(userID) != null) {
                while (!check1) {
                    System.out.print("Please enter policy holder name: ");
                    policyHolderName = scan.nextLine();

                    if (!policyHolderName.matches("^[a-zA-Z\\s]+$")) {
                        System.out.println();
                        System.out.println("Please enter a valid policy holder name");
                    } else {
                        check1 = true;
                    }
                }

                while (check1) {
                    System.out.print("Please enter policy ID: ");
                    policyID = scan.next();

                    if (!policyID.matches("^\\d+(\\.\\d+)?")) {
                        System.out.println();
                        System.out.println("Please enter a valid policy ID");
                    } else {
                        check1 = false;
                    }
                }


                System.out.println("Please enter information of car: type (SUV, SED, LUX, HATCH, SPORTS) ; model ; manufacturing year ; price");

                while (!check1) {
                    System.out.print("Type: ");
                    type = Car.CarType.valueOf(scan.next());

                    if (!(type instanceof Car.CarType)) {
                        System.out.println();
                        System.out.println("Please enter a valid Car type");
                    } else {
                        check1 = true;
                    }
                }

                System.out.print("Model: ");
                String model = scan.next();

                while (check1) {
                    System.out.print("Manufacturing year: ");
                    manufacturingYear = scan.next();

                    if (!manufacturingYear.matches("^\\d+(\\.\\d+)?")) {
                        System.out.println();
                        System.out.println("Please enter a valid manufacturing year");
                    } else {
                        check1 = false;
                    }
                }

                while (!check1) {
                    System.out.print("Price: $");
                    price = scan.next();

                    if (!price.matches("^\\d+(\\.\\d+)?")) {
                        System.out.println();
                        System.out.println("Please enter a valid price");
                    } else {
                        check1 = true;
                    }
                }

                Car car = new Car(type, model, Integer.parseInt(manufacturingYear), Double.parseDouble(price));

                System.out.print("Please enter number of claims: ");
                int numberOfClaims = scan.nextInt();
                System.out.print("Please enter expiry date (day ; month ; year): ");
                int day = scan.nextInt();
                int month = scan.nextInt();
                int year = scan.nextInt();
                MyDate date = new MyDate(day, month, year);

                System.out.print("Please enter drive age and level: ");
                int driverAge = scan.nextInt();
                int level = scan.nextInt();

                try {

                    ComprehensivePolicy comprehensivePolicy = new ComprehensivePolicy(policyHolderName, Integer.parseInt(policyID), car, numberOfClaims, date, driverAge, level);
                    System.out.println();

                    insuranceCompany.addPolicy(userID, comprehensivePolicy);
                }  catch (PolicyException pe){
                    System.out.println(pe);
                }  catch (PolicyHolderNameException phe){
                    System.out.println(phe);
                }

//                boolean checkPolicy = insuranceCompany.createComprehensivePolicy(userID, policyHolderName, Integer.parseInt(policyID), car, numberOfClaims, date, driverAge, level);
//                ComprehensivePolicy comprehensivePolicy = new ComprehensivePolicy(policyHolderName, Integer.parseInt(policyID), car, numberOfClaims, date, driverAge, level);
//
//                insuranceCompany.addPolicy(userID, comprehensivePolicy);
//
//                System.out.println();
//
//
//                if (checkPolicy) {
//                    System.out.println("Create done. Choose option to check the policies of user");
//                }

            } else {
                System.out.println("User ID has not existed. Please try again.");
            }

        } catch (Exception e) {
            System.out.println("\n");
            System.out.println("Sorry. Error: " + e);
            System.out.println("Please try again.");
        }
    }

    public static void removePolicy(InsuranceCompany insuranceCompany) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter an user ID: ");
        int userIdRemove = scan.nextInt();
        User user = insuranceCompany.findUser(userIdRemove);
        System.out.println();

        if (user != null) {
            user.print();
            System.out.print("\nWhich policy do you want to remove (ID): ");
            int policyID = scan.nextInt();
            InsurancePolicies policy = user.findPolicy(policyID);
            if (policy == null) {
                System.out.println("Policy ID is not existed. Please try again.");
            } else {
                insuranceCompany.removePolicy(user.getUserID(), policy);
                System.out.println();
                System.out.println("Remove done. Please check the policy again.");
            }

        } else {
            System.out.println("User ID is not existed. Please try again.");
        }
    }

    public static void removeUser(InsuranceCompany insuranceCompany) {
        Scanner scan = new Scanner(System.in);

        for (User user : insuranceCompany.getUsers().values()) {
            user.print();
        }

        System.out.println();

        System.out.print("\nWhich user do you want to remove (ID): ");
        int userIdRemove = scan.nextInt();
        User user = insuranceCompany.findUser(userIdRemove);
        System.out.println();

        if (user != null) {
            insuranceCompany.removeUser(user);

            System.out.println("Remove done. Please check the policy again.");

        } else {
            System.out.println("User ID is not existed. Please try again.");
        }
    }

    public static void reportPaymentPerCity(InsuranceCompany insuranceCompany) {
        ArrayList<String> cities = insuranceCompany.populateDistinctCityNames();
        ArrayList<Double> payments = insuranceCompany.getTotalPaymentPerCity(cities);
        insuranceCompany.reportPaymentPerCity(cities, payments);
    }

    public static void reportPaymentPerCarModels(InsuranceCompany insuranceCompany) {
        ArrayList<String> carModels = insuranceCompany.populateDistinctCarModels();
        ArrayList<Integer> counts = insuranceCompany.getTotalCountPerCarModel(carModels);
        ArrayList<Double> premiumPayments = insuranceCompany.getTotalPaymentPerCarModel(carModels);

        insuranceCompany.reportPaymentsPerCarModel(carModels, counts, premiumPayments);
    }

    private static void changePassword(InsuranceCompany insuranceCompany) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please confirm your recent password: ");
        String password = input.next();
        if (password.equals(insuranceCompany.getAdminPassword())) {
            System.out.print("Please enter your new password:");
            String newPassword = input.next();
            if (newPassword.equals(password)) {
                System.out.println("Please try again with a different password");

            } else {
                insuranceCompany.setAdminPassword(newPassword);
                System.out.println("Done! Your new password is created");
            }
        } else {
            System.out.println("Your password is incorrect. Please try again");
        }
    }

}


