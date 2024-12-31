package basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

/**
 * @author Nurberat Gökmen
 * @version 1.1
 */


public abstract class Property implements PropertyPrice, Comparable<Property> {
    private int propertyid;
    private int noBedRooms;
    private int noRooms;
    private String city;
    private double pricePerDay;
    Host host;
    private HashMap<Date, String> inspection = new HashMap<Date, String>();

    private List<Booking> bookingList;

    //en son eklediğim constructor fullproperty için

    /**
     *
     * @param propertyid
     * @param nobedrooms
     * @param norooms
     * @param city
     * @param pricePerDay
     * @param host
     */
    public Property(int propertyid, int nobedrooms, int norooms, String city, double pricePerDay, Host host) {

        this.propertyid = propertyid;
        this.noBedRooms = nobedrooms;
        this.noRooms = norooms;
        this.city = city;
        this.pricePerDay = pricePerDay;
        this.host = host;
    }

    /**
     *
     * @return
     */
    public List<Booking> getBookingList() {
        return bookingList;
    }

    /**
     *
     * @param bookingList
     */
    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    //default constructor

    /**
     *
     */
    public Property(){

        noBedRooms = 0;
        noRooms = 0;
        city = "Kyrenia";
        pricePerDay = 100;
        setInspection(new HashMap<>());

    }
    //full constructor

    /**
     *
     * @param propertyid
     * @param noBedRooms
     * @param noRooms
     * @param city
     * @param pricePerDay
     * @param inspection
     * @param bookingList
     * @param host
     */
    public Property(int propertyid, int noBedRooms, int noRooms, String city, double pricePerDay, HashMap<Date, String> inspection, List<Booking> bookingList, Host host) {
        this.propertyid = propertyid;
        this.noBedRooms = noBedRooms;
        this.noRooms = noRooms;
        this.city = city;
        this.pricePerDay = pricePerDay;
        this.inspection = inspection;
        this.bookingList = bookingList;
        this.host = host;
    }

    /**
     *
     * @param propertyid
     * @param noBedRooms
     * @param noRooms
     */

    public Property(int propertyid, int noBedRooms, int noRooms){


        setPropertyid(propertyid);
        setNoBedRooms(noBedRooms);
        setNoRooms(noRooms);
        setBookingList(new ArrayList<>());
        setInspection(new HashMap<>());

    }

    /**
     *
     * @param city
     * @param pricePerDay
     */
    public Property(String city, double pricePerDay){

        setCity(city);
        setPricePerDay(pricePerDay);
        setBookingList(new ArrayList<>());
        setInspection(new HashMap<>());
    }

    /**
     *
     * @return
     */
    public Host getHost() {
        return host;
    }

    /**
     *
     * @param host
     */
    public void setHost(Host host) {
        this.host = host;
    }

    /**
     *
     * @return
     */

    public int getPropertyid() {
        return propertyid;
    }

    /**
     *
     * @param propertyid
     */

    public void setPropertyid(int propertyid) {
        this.propertyid = propertyid;
    }

    /**
     *
     * @return
     */

    public int getNoBedRooms() {
        return noBedRooms;
    }

    /**
     *
     * @param noBedRooms
     */

    public void setNoBedRooms(int noBedRooms) {
        this.noBedRooms = noBedRooms;
    }

    /**
     *
     * @return
     */

    public int getNoRooms() {
        return noRooms;
    }

    /**
     *
     * @param noRooms
     */

    public void setNoRooms(int noRooms) {
        this.noRooms = noRooms;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */

    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     */

    public double getPricePerDay() {
        return pricePerDay;
    }

    /**
     *
     * @param pricePerDay
     */

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    /**
     *
     * @return
     */

    public HashMap<Date, String> getInspection() {
        return inspection;
    }

    /**
     *
     * @param inspection
     */

    public void setInspection(HashMap<Date, String> inspection) {
        this.inspection = inspection;
    }

    /**
     *
     * @return
     */



    @Override
    public String toString() {
        return "Property{" +
                "propertyid=" + propertyid +
                ", noBedRooms=" + noBedRooms +
                ", noRooms=" + noRooms +
                ", city='" + city + '\'' +
                ", pricePerDay=" + pricePerDay +
                ", inspection=" + inspection +
                ", bookingList=" + bookingList +
                '}';
    }


    @Override
    public abstract double calculatePricePerDay();

    /**
     *
     * @param report
     */
    public void addInspectionReport(String report) {
        Date dateKey = new Date(); // No need to format, use the Date object directly
        inspection.put(dateKey, report);
    }

    /**
     *
     * @param other the object to be compared.
     * @return
     */
    public int compareTo(Property other) {
        return Double.compare(this.calculatePricePerDay(), other.calculatePricePerDay());
    }
}



