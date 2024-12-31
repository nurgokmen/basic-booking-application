package basic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Nurberat Gökmen
 * @version 1.1
 */

public abstract class Customer extends User {

    private String preferredPaymentMethod;
    private List<Booking> bookingList;


    /**
     *
     * @param userID
     * @param dateofBirth
     * @param firstName
     * @param lastName
     * @param registrationDate
     * @param preferredPaymentMethod
     * @param bookingList
     */

    public Customer(int userID, Date dateofBirth, String firstName, String lastName, Date registrationDate, String preferredPaymentMethod, List<Booking> bookingList) {
        super(userID, dateofBirth, firstName, lastName, registrationDate);
        this.preferredPaymentMethod = preferredPaymentMethod;
        this.bookingList = new ArrayList<>();
    }

    /**
     *
     * @param userID
     * @param dob
     * @param fname
     * @param lname
     * @param regdate
     * @param preferredPaymentMethod
     * @param bookingList
     */

    public Customer(int userID, String dob, String fname, String lname, String regdate, String preferredPaymentMethod, List<Booking> bookingList) {
        super(userID, dob, fname, lname, regdate);
        this.preferredPaymentMethod = preferredPaymentMethod;
        this.bookingList = bookingList != null ? bookingList : new ArrayList<>();
    }

    /**
     *
     * @param userID
     * @param dob
     * @param fname
     * @param lname
     * @param regdate
     * @param preferredPaymentMethod
     */

    public Customer(int userID, String dob, String fname, String lname, String regdate, String preferredPaymentMethod) {
        super(userID, dob, fname,lname,regdate);
        this.preferredPaymentMethod = preferredPaymentMethod;
        this.bookingList = new ArrayList<>();;
    }

   /* public Customer() {
        preferredPaymentMethod = "cash";
    }*/

    /**
     * initializes the list
     */
    public Customer() {
        super();
        this.bookingList = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public List<Booking> getBookingList() {
        return bookingList;
    }

   /* public Customer(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }*/

   /* public Customer(String preferredPaymentMethod, List<Booking> bookingList) {
        this.preferredPaymentMethod = preferredPaymentMethod;
        this.bookingList = bookingList;
    }*/

    /**
     *
     * @param bookingList
     */

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    /*public Customer(String preferredPaymentMethod) {
        this.preferredPaymentMethod = preferredPaymentMethod;

    }*/

    /**
     *
     * @return
     */

    public String getPreferredPaymentMethod() {
        return preferredPaymentMethod;
    }

    /**
     *
     * @param preferredPaymentMethod
     */

    public void setPreferredPaymentMethod(String preferredPaymentMethod) {
        this.preferredPaymentMethod = preferredPaymentMethod;
    }

    @Override
    public String toString() {
        return "Customer{" + super.toString() +
                "preferredPaymentMethod='" + preferredPaymentMethod + '\'' +
                ", bookingList=" + bookingList +
                '}';
    }

    /**
     *
     * @param booking
     */

    public void addBooking(Booking booking) {
        this.bookingList.add(booking);
    }

    /**
     *
     * @return
     */

    public abstract double discountPercentage();


}
