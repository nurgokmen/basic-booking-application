package basic;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author Nurberat Gökmen
 * @version 1.1
 */

public abstract class User {

    private int userID;
    private LocalDate dateofBirth;
    private String firstName;
    private String lastName;
    private Date registrationDate;
    static Scanner input = new Scanner(System.in);
    private List<Booking> bookingList;

    /**
     * default
     */
    public User() {

    }

    /**
     * initialize the booking list
     * @param bookingList
     */

    public User(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    /**
     * @return dateofbirth of the user as a date format
     */

    public LocalDate getDateofBirth() {
     return dateofBirth;
    }

    /**
     *
     * @param regdate
     * converts the date from string to date format
     */

    public void setRegistrationDate(String regdate)
    {
        try
        {
            registrationDate = new SimpleDateFormat("dd/MM/yyyy").parse(regdate);
        }

        catch (Exception e)
        {
            System.out.println("wrong date format");
        }

    }

    /*/**
     * converts the date from string to date format
     * @param dob
     */
   /* public void setDateofBirth(String dob) {

        try
        {
            dateofBirth = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
        }

        catch (Exception e)
        {
            System.out.println("wrong date format");
        }
    }*/

    public void setDateOfBirth(LocalDate dateOfBirth){
        this.dateofBirth = dateOfBirth;
    }

    /**
     *
     * @param userID
     * @param dateofBirth
     * @param firstName
     * @param lastName
     * @param registrationDate
     */
    public User(int userID, Date dateofBirth, String firstName, String lastName, Date registrationDate) {
        this.userID = userID;
       // this.dateofBirth = dateofBirth;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registrationDate = registrationDate;
    }

    /**
     *
     * @param userID
     * @param dob
     * @param fname
     * @param lname
     * @param regdate
     */
    public User(int userID, String dob, String fname, String lname, String regdate){
        this.userID= userID;
        this.firstName = fname;
        this.lastName = lname;
        //setDateofBirth(dob);
        setRegistrationDate(regdate);


    }

    /**
     *
     * @return userID
     */

    public int getUserID() {
        return userID;
    }

    /**
     *
     * @param userID
     */

    public void setUserID(int userID) {
        this.userID = userID;
    }


    /**
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * sets the first name to the given name
     * @param firstName
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return last name
     */

    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return reg date in date format
     */

    public Date getRegistrationDate() {
        return registrationDate;
    }

    /**
     *
     * @param dateofBirth
     */

    //public void setDateofBirth(Date dateofBirth) {
      //  this.dateofBirth = dateofBirth;
    //}

    /**
     *
     * @param registrationDate
     */

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     *
     * @return
     */

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "User{" +
                "userID=" + userID +
                ", dateofBirth=" + (dateofBirth != null ? sdf.format(dateofBirth) : "null") +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }

    /**
     *
     * @param userid
     */

    public void addBooking(int userid)
    {
        int option;
        option = 1;

        String startd;
        String endd;
        boolean ispaid;

        System.out.print("Enter the start date of the booking:");
        startd = input.nextLine();
        System.out.print("Enter the end date of the booking:");
        endd = input.nextLine();
        System.out.print("Is the booking paid:");
        ispaid = input.nextBoolean();

        Booking booking_n = new Booking(startd, endd, ispaid);
        bookingList.add(booking_n);


    }

    public void setDateofBirth(LocalDate localDate) {

    }
}
