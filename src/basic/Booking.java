package basic;

import java.time.LocalDate;
import java.util.Date;
import java.util.*;
import java.text.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author Nurberat Gökmen
 * @version 1.1
 */
public class Booking {

    static Scanner input = new Scanner(System.in);
    static DateTimeFormatter type = DateTimeFormatter.ofPattern("d/MM/yyyy");
    private Date startDate;
    private Date endDate;
    private boolean isPaid;
    private int customerId;
    private int propertyId;
    private Property property;
    private User user;

    /**
     *
     * @param customerId
     * @param propertyId
     * @param startDate
     * @param endDate
     */
    public Booking(int customerId, int propertyId, String startDate, String endDate) {
        this.customerId = customerId;
        this.propertyId = propertyId;
        setStartDate(startDate);
        setEndDate(endDate);
    }


    public Booking(int userID, int propertyid, Date sdate, Date edate){
        this.startDate = sdate;
        this.endDate = edate;
    }

    /**
     *
     * @param startdate
     */

    public void setStartDate(String startdate)
    {
        try
        {
            startDate = new SimpleDateFormat("dd/mm/yyyy").parse(startdate);
        }

        catch (Exception e)
        {
            System.out.println("wrong date format");
        }
    }

    /**
     *
     * @param enddate
     */
    public void setEndDate(String enddate){

        try
        {
            endDate = new SimpleDateFormat("dd/mm/yyyy").parse(enddate);
        }

        catch (Exception e)
        {
            System.out.println("wrong date format");
        }

    }
    //default constructor
    public Booking(){

        setStartDate("01/01/2000");
        setEndDate("01/01/2001");
        isPaid = false;


    }

    // parametrized constructor, partial
    public Booking(String ssdate, String eedate){


        setEndDate(eedate);
        setStartDate(ssdate);


    }

    /**
     *
     * @param ssdate
     * @param eedate
     * @param isPaid
     */
    // parametrized constructor full
    public Booking(String ssdate, String eedate, boolean isPaid) {
        setStartDate(ssdate);
        setEndDate(eedate);
        this.isPaid = isPaid;
    }

    /**
     *
     * @return
     */

    public Date getStartDate() {
        return startDate;
    }

    /**
     *
     * @param startDate
     */

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     *
     * @return
     */

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     *
     * @return
     */

    public boolean getisPaid() {

        System.out.println("Is it paid?");
        String yes = input.nextLine();
        if(yes.toLowerCase() == "yes"){
            return true;}
        else{
            return false;

        }
    }





    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    /**
     *
     * @return
     */

    public long getTotalNumberOfDays() {
        long diffInMilliseconds = endDate.getTime() - startDate.getTime();
        return TimeUnit.DAYS.convert(diffInMilliseconds, TimeUnit.MILLISECONDS);
    }

    /**
     *
     * @return
     */
    //float totalCoast()
    public Property getProperty() {
        return property;
    }

    /**
     *
     * @param property
     */

    public void setProperty(Property property) {
        this.property = property;
    }

    /**
     *
     * @return
     */


    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     */

    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     * @return
     */

    public boolean isPaid() {
        return isPaid;
    }

    /**
     *
     * @return
     */

    public int getCustomerId() {
        return customerId;
    }

    /**
     *
     * @param customerId
     */

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     *
     * @return
     */

    public int getPropertyId() {
        return propertyId;
    }

    /**
     *
     * @param propertyId
     */

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public double totalCost() {
        // Check if property is not null and has a price per night
        if (property != null && property.calculatePricePerDay() > 0) {
            long numberOfDays = getTotalNumberOfDays();
            return numberOfDays * property.calculatePricePerDay();
        } else {
            // Handle the case where property is null or price per night is not set
            System.out.println("Property not set or price per night is invalid.");
            return 0;
        }
    }

}
