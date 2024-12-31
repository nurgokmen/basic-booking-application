package basic;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import java.util.Scanner;

/**
 *
 * @author Nurberat Gökmen
 * @version 1.1
 */

class Basic {

    static Scanner input = new Scanner(System.in);
    public static List<User> users;
    public List<Property> properties;


    /**
     * default constructor to initalize the lists of users and properties
     */
    public Basic() {
        this.users = new ArrayList<User>();
        this.properties = new ArrayList<Property>();
    }

    /**
     *
     * @param users
     * @param properties
     * constructor for initalizing the lists
     */

    public Basic(List<User> users, List<Property> properties) {
        this.users = users;
        this.properties = properties;
    }

    /**
     *
     * @return users list
     */

    public List<User> getUsers() {
        return users;
    }

    /**
     *
     * @param users
     * @return users
     */

    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     *
     * @return properties
     */

    public List<Property> getProperties() {
        return properties;
    }

    /**
     *
     * @param properties
     * @return properties
     */

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    /**
     * @return void
     * prints the menu that user will select the option from
     */

    public static void menu() {

        System.out.println("Welcome to the BASIC Cyprus!");
        System.out.println("----------- MENU -----------");
        System.out.println("1- Add User");
        System.out.println("2- Delete User");
        System.out.println("3- Get User Details");
        System.out.println("4- Add Property");
        System.out.println("5- Delete Property");
        System.out.println("6- Get property Details");
        System.out.println("7- Add Booking");
        System.out.println("8- Get User's Booking");
        System.out.println("9- Get Booking Cost");
        System.out.println("10- List Users");
        System.out.println("11- List Properties");
        System.out.println("12- Get Discount For Specific User");
        System.out.println("13- Add Inspection To a Specific Property");
        System.out.println("14- Compare two Properties");
        System.out.println("15- Exit");

    }

    /**
     *
     * @return a unique user ID
     */

    public static int uniqueUserID() {

        if (users == null || users.isEmpty()) {
            return 1;
        } else {

            return users.get(users.size() - 1).getUserID() + 1;

        }
    }

    /**
     * adds a user to the list based on its category(standard,gold)
     */

    public static void addUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();
        System.out.println(firstName);

        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();
        System.out.println(lastName);

        System.out.println("Enter date of birth (dd/MM/yyyy):");
        String dob = scanner.nextLine();

        System.out.println("Enter registration date (dd/MM/yyyy):");
        String regDate = scanner.nextLine();


        System.out.println("Enter user type (host/standard/gold):");
        String userType = scanner.nextLine();
        System.out.println(userType);


        User newUser = null;
        int userid = uniqueUserID();
        System.out.println(userid);
        switch (userType.toLowerCase()) {

            case "host":
                System.out.println("slm");
                double tax;
                System.out.println("Please enter tax number:");
                tax = scanner.nextDouble();
                scanner.nextLine();
                System.out.println(tax);
                newUser = new Host(userid, dob, firstName, lastName, regDate, tax);
                System.out.println("slm");
                break;
            case "standard":
                System.out.println("Enter payment method:(cash/credit card:");
                String paymentmethod = scanner.nextLine();

                newUser = new Standard(userid, dob, firstName, lastName, regDate, paymentmethod);
                break;
            case "gold":
                System.out.println("Enter gold level (1-3):");
                int goldLevel = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter payment method:(cash/credit card:");
                String paymethod = scanner.nextLine();
                if (goldLevel >= 1 && goldLevel <= 3) {
                    newUser = new Gold(uniqueUserID(), dob, firstName, lastName, regDate, paymethod, goldLevel);
                } else {
                    System.out.println("Invalid gold level. Must be 1, 2, or 3.");
                    return;
                }
                break;
            default:
                System.out.println("Invalid user type.");
                return;
        }

        if (newUser != null) {
            users.add(newUser);
            System.out.println("User added successfully: " + newUser);
        }
    }

    /**
     *
     * @param userID
     * deletes the user with the provided ID
     */

    public static void deleteUser(int userID) {
        if (users == null || users.isEmpty()) {

            System.out.println("There are no users");
        } else {
            int i;
            int j;
            j = 0;

            for (i = 0; i < users.size(); i++) {
                if (users.get(i).getUserID() == userID) {
                    users.remove(i);
                    j = 1;
                    System.out.println("The user is deleted from the BASIC system");

                }
            }
            if (j == 0) {
                System.out.println("No user with the ID number");
            }
        }

    }

    /**
     *
     * @param userid
     * prints the details of the user with the provided ID
     */

    public void getUserDetails(int userid) {
        boolean userFound = false;

        if (users == null || users.isEmpty()) {
            System.out.println("There are no users registered in the BASIC system");
        } else {
            for (User user : users) {
                if (user.getUserID() == userid) {
                    System.out.println("User ID: " + user.getUserID());
                    System.out.println("Date of birth: " + user.getDateofBirth());
                    System.out.println("First name: " + user.getFirstName());
                    System.out.println("Last name : " + user.getLastName());
                    System.out.println("User Type:" + user); // This will call the user's toString method

                    userFound = true;
                    break; // Break out of the loop as we found the user
                }
            }
            if (!userFound) {
                System.out.println("There are no users with this ID registered to the BASIC system");
            }
        }
    }

    /**
     *
     * @param userId
     * @return Host
     * finds the host by looking through its ID
     */

    private Host getHostById(int userId) {
        for (User user : users) {
            if (user instanceof Host && user.getUserID() == userId) {
                return (Host) user;
            }
        }
        return null; // Return null if no host with the given user ID is found
    }

    /**
     *
     * @return a unique ID for each property
     */

    public int uniquepropertyID() {

        if (properties == null || properties.isEmpty()) {
            return 1;
        } else {
            return properties.get(properties.size() - 1).getPropertyid() + 1;
        }
    }

    /**
     * adds a property to the property list
     */

    public void addProperty() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter property type (shared/full):");
        String propertyType = scanner.nextLine().toLowerCase();

        System.out.println("Enter the host's userID:");
        int hostUserId = scanner.nextInt(); // You might need to consume the leftover newline character after this
        scanner.nextLine(); // Consume the leftover newline

        // Find the host with the given userID
        Host host = getHostById(hostUserId);
        if (host == null) {
            System.out.println("No host found with userID: " + hostUserId);
            return; // Exit the method if the host does not exist
        }

        System.out.println("Enter the number of bedrooms:");
        int noBedRooms = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline

        System.out.println("Enter the number of rooms:");
        int noRooms = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline

        System.out.println("Enter the city:");
        String city = scanner.nextLine();

        System.out.println("Enter the price per day:");
        double pricePerDay = scanner.nextDouble();
        scanner.nextLine(); // Consume the leftover newline

        Property property;
        int propid = uniquepropertyID();
        if ("full".equals(propertyType)) {
            System.out.println("Enter the size of the house (in square meters):");
            double size = scanner.nextDouble();
            scanner.nextLine(); // Consume the leftover newline
            property = new FullProperty(propid, noBedRooms, noRooms, city, pricePerDay, size, host);
        } else if ("shared".equals(propertyType)) {
            property = new SharedProperty(propid, noBedRooms, noRooms, city, pricePerDay, host);
        } else {
            System.out.println("Invalid property type.");
            return;
        }

        // Assuming you have a list named properties to hold all properties
        properties.add(property);
        System.out.println("Property added successfully: " + property);
    }

    /**
     *
     * @param propertyid
     * deletes the property specified with the unique property ID
     */

    public void deleteproperty(int propertyid) {

        if (properties == null || properties.isEmpty()) {

            System.out.println("There are no properties");
        } else {
            int i;
            int j;
            j = 0;

            for (i = 1; i < properties.size() + 1; i++) {
                if (users.get(i-1).getUserID() == propertyid) {
                    users.remove(i-1);
                    //j = 1;
                    System.out.println("The property is deleted from the BASIC system");

                }
            }
            if (j == 0) {
                System.out.println("No property with the provided ID number");
            }
        }
    }

    /**
     *
     * @param propid
     * prints the details of the property which is ID was given
     */

    public void getPropertyDetails(int propid) {
        boolean propFound = false;

        if (properties == null || properties.isEmpty()) {
            System.out.println("There are no properties registered in the BASIC system");
        } else {
            for (Property prop : properties) {
                if (prop.getPropertyid() == propid) {
                    System.out.println("Property ID: " + prop.getPropertyid());
                    System.out.println("No of Bed Rooms: " + prop.getNoBedRooms());
                    System.out.println("No of rooms: " + prop.getNoRooms());
                    System.out.println("City name : " + prop.getCity());
                    System.out.println("Price Per Day : " + prop.getPricePerDay());
                    System.out.println("Property Type:" + prop); // This will call the user's toString method

                    propFound = true;
                    break; // Break out of the loop as we found the user
                }
            }
            if (!propFound) {
                System.out.println("There are no properties with this ID registered to the BASIC system");
            }
        }
    }

    /**
     *
     * @param userId
     * @return user, customer based on its ID
     */

    private User findCustomerById(int userId) {
        for (User customer : users) {
            if (customer.getUserID() == userId) {
                return customer;
            }
        }
        return null;
    }



    public static LocalDate dateConverter(String dateInput){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(dateInput,formatter);
        return date;
    }

    /**
     *
     * @param userId
     * @return User based on its ID
     */
    public User getUserById(int userId) {
        for (User user : users) {
            if (user.getUserID() == userId) {
                return user;
            }
        }
        return null;
    }

    /**
     *
     * @param propertyId
     * @return property or null
     */

    private Property getPropertyById(int propertyId) {
        for (Property property : properties) {
            if (property.getPropertyid() == propertyId) {
                return property;
            }
        }
        return null;
    }


    public Basic readData() throws IOException
    {
        return GetData.readData();
    }

    public void writeData(Basic new_basic) throws IOException
    {
        GetData.writeData(new_basic);
    }

    /**
     *
     * @param userId
     * @param propertyId
     * adds a booking to the given user and property
     */

    public void addBooking(int userId, int propertyId) {
        User user = getUserById(userId);
        Property property = getPropertyById(propertyId);

        if (user == null || property == null) {
            System.out.println("User or Property not found.");
            return;
        }

        if (!(user instanceof Customer)) {
            System.out.println("The user is not a customer.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter start date (YYYY-MM-DD):");
        String startDate = scanner.nextLine();
        System.out.println("Enter end date (YYYY-MM-DD):");
        String endDate = scanner.nextLine();

        // Create a Booking instance
        Booking newBooking = new Booking(userId, propertyId, startDate, endDate);

        // Assuming Customer class has a method to set a booking
        Customer customer = (Customer) user;
        customer.addBooking(newBooking);

        System.out.println("Booking successfully added.");

    }

    /**
     *
     * @param user_id
     * gets the information of the booking for the provided user ID
     */
    public void getUserBooking(int user_id) {
        if (users.isEmpty()) {
            System.out.println("There are no registered users.");
            return;
        }



        for (User user : users) {

                // Check if the user is a customer before proceeding
                if (!(user instanceof Customer)) {
                    System.out.println("The user with ID " + user_id + " is not a customer.");
                    return; }

                List<Booking> userBookings = ((Customer) user).getBookingList();
                if (!userBookings.isEmpty()) {
                    for (Booking booking : userBookings) {
                        System.out.println("Start Date: " + booking.getStartDate());
                        System.out.println("End Date: " + booking.getEndDate());
                        System.out.println("Payment Status: " + booking.getisPaid());
                    }
                } else {
                    System.out.println("No bookings found for user with ID: " + user_id);
                }
                return;
            }


        System.out.println("User with ID " + user_id + " not found.");
    }

    /**
     *
     * @param userId
     * @param propertyId
     * calculates and prints the total cost of the booking
     */

    public void getBookingCost(int userId, int propertyId) {
        User user = getUserById(userId);
        Property property = getPropertyById(propertyId);

        if (user == null || property == null) {
            System.out.println("User or Property not found.");
            return;
        }

        if (!(user instanceof Customer)) {
            System.out.println("The user is not a customer.");
            return;
        }

        Customer customer = (Customer) user;
        List<Booking> userBookings = customer.getBookingList();

        for (Booking booking : userBookings) {
            if (booking.getPropertyId() == propertyId) {
                long totalDays = booking.getTotalNumberOfDays(); // You need to implement this method in Booking
                double pricePerDay = property.calculatePricePerDay(); // This method should be implemented in Property and its subclasses
                double totalCost = totalDays * pricePerDay;

                // If the user has a discount, apply it
                if (customer instanceof Gold) {
                    Gold goldCustomer = (Gold) customer;
                    totalCost -= totalCost * goldCustomer.getDiscountForUser(); // Assuming getDiscountForUser returns a percentage value between 0 and 1
                }

                System.out.printf("Booking from %s to %s costs: %.2f%n",
                        booking.getStartDate(),
                        booking.getEndDate(),
                        totalCost);
            }
        }
    }

    /**
     * lists all users registered to the BASIC system
     */

    public void listUsers() {
        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }

        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * lists all properties registered to the BASIC system
     */
    public void listProperties() {
        if (properties.isEmpty()) {
            System.out.println("No properties found.");
            return;
        }

        for (Property property : properties) {
            System.out.println(property);
        }
    }

    /**
     *
     * @param userId
     * calculates the discount percantage of the user, based on its customer type
     */

    public void getDiscountForUser(int userId) {
        for (User user : users) {
            if (user.getUserID() == userId && user instanceof Customer) {
                System.out.println(((Customer) user).discountPercentage()); // Polymorphic call to the method
            }
        }
        // If user not found, return 0 or handle the case as needed
    }

    /**
     *
     * @param propertyId
     * @param inspectionReport
     * gets the property ID and adds an inspection the that property
     */

    public void addInspectionToProperty(int propertyId, String inspectionReport) {
        Property property = getPropertyById(propertyId);
        if (property != null) {
            property.addInspectionReport(inspectionReport);
            System.out.println("Inspection added to property " + propertyId);
        } else {
            System.out.println("Property not found with ID: " + propertyId);
        }
    }

    /**
     * compares the prices of two properties based on their IDs.
     * @param propertyId1
     * @param propertyId2
     */
    public void comparePropertyPricesPerDay(int propertyId1, int propertyId2) {
        Property property1 = getPropertyById(propertyId1);
        Property property2 = getPropertyById(propertyId2);

        if (property1 == null || property2 == null) {
            System.out.println("One or both property IDs are invalid.");
            return;
        }

        int comparisonResult = property1.compareTo(property2);
        if (comparisonResult < 0) {
            System.out.println("Property ID " + propertyId1 + " is cheaper.");
        } else if (comparisonResult > 0) {
            System.out.println("Property ID " + propertyId2 + " is cheaper.");
        } else {
            System.out.println("Both properties have the same price!");
        }
    }

    /**
     * created for populateData class
     * @param user
     */

    public void addUserDirectly(User user) {
        this.users.add(user);
    }

    /**
     * created for populateData class
     * @param property
     */

    public void addPropertyDirectly(Property property) {
        this.properties.add(property);
    }


    /**
     * main method which controls the beginning and the termination of the program
     * @param args
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int option;

        int user_id;
        int property_id;
        int property_id1, property_id2;
        int no_of_bedrooms;
        int no_rooms;
        String p_city;

        Basic basic1 = new Basic();
        PopulateData.populateInitialdata(basic1);



        System.out.println("Welcome to the BASIC (Bed and Breakfast in Cyprus) System!");

        do {

            //  System.out.println("slm");
            menu();
            System.out.println("Please enter your preference from the menu:");
            option = input.nextInt();


            switch (option) {
                case 1:
                    basic1.addUser();
                    break;
                case 2:
                    System.out.println("Enter the ID of the user you want to delete:");
                    user_id = scanner.nextInt();
                    scanner.nextLine();
                    basic1.deleteUser(user_id);
                    break;
                case 3:
                    System.out.println("Enter the ID number of the User you want to view the details:");
                    user_id = input.nextInt();
                    basic1.getUserDetails(user_id);
                    break;
                case 4:
                    basic1.addProperty();
                    break;
                case 5:
                    System.out.println("Enter the ID number of the property you want to delete:");
                    property_id = input.nextInt();
                    basic1.deleteproperty(property_id);
                    System.out.println("Property deleted!");
                    break;
                case 6:
                    System.out.println("Enter the ID number of the property you want to view the details:");
                    property_id = input.nextInt();
                    basic1.getPropertyDetails(property_id);
                    break;
                case 7:
                    System.out.println("Enter the ID number of the User you want to do the booking for:");
                    user_id = input.nextInt();
                    System.out.println("Enter the ID number of the property you want to book:");
                    property_id = input.nextInt();
                    basic1.addBooking(user_id,property_id);
                    break;
                case 8:
                    System.out.print("Please Enter the ID number of the user: ");
                    user_id = input.nextInt();
                    basic1.getUserBooking(user_id);
                    break;
                case 9:
                    System.out.print("Please Enter the ID number of the user: ");
                    user_id = input.nextInt();
                    System.out.print("Please Enter the ID of the property: ");
                    property_id = input.nextInt();
                    basic1.getBookingCost(user_id, property_id);

                    break;
                case 10:
                    basic1.listUsers();
                    break;
                case 11:
                    basic1.listProperties();
                    break;
                case 12:
                    System.out.print("Please Enter the ID number of the user you want to get the discount percentage: ");
                    user_id = input.nextInt();
                    basic1.getDiscountForUser(user_id);
                    break;
                case 13:
                    System.out.println("Please enter the property ID of the property you want to add the inspection report:");
                    property_id =  input.nextInt();
                    input.nextLine();
                    System.out.println("Add your inspection:");
                    String inspectionReport = input.nextLine();
                    basic1.addInspectionToProperty(property_id,inspectionReport);
                    break;
                case 14:
                    System.out.println("Please enter the first property's ID of the property you want to compare:");
                    property_id1 = input.nextInt();
                    scanner.nextLine();
                    System.out.println("Please enter the first property's ID of the property you want to compare:");
                    property_id2 = input.nextInt();
                    scanner.nextLine();
                    basic1.comparePropertyPricesPerDay(property_id1,property_id2);
                    break;
                case 15:
                    System.out.println("----------Goodbye----------");
                    break;




            }
        }while (option != 15);
    }
}

