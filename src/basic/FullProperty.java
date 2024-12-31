package basic;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author Nurberat Gökmen
 * @version 1.1
 */

public class FullProperty extends Property implements java.lang.Comparable<Property> {

    private double propertySize;


    /**
     *
     * @param propertySize
     */

    public FullProperty(double propertySize) {
        this.propertySize = propertySize;
    }

    /**
     *
     * @param propertyid
     * @param noBedRooms
     * @param noRooms
     * @param city
     * @param pricePerDay
     * @param inspection
     * @param bookingList
     * @param propertySize
     * @param host
     */

    public FullProperty(int propertyid, int noBedRooms, int noRooms, String city, double pricePerDay, HashMap<Date, String> inspection, List<Booking> bookingList, double propertySize, Host host) {
        super(propertyid, noBedRooms, noRooms, city, pricePerDay, inspection, bookingList, host);
        this.propertySize = propertySize;
    }

    /**
     *
     * @param propertyid
     * @param nobedrooms
     * @param norooms
     * @param city
     * @param pricePerDay
     * @param propertySize
     * @param host
     */

    public FullProperty(int propertyid, int nobedrooms, int norooms, String city, double pricePerDay, double propertySize, Host host){

        super(propertyid, nobedrooms, norooms, city, pricePerDay,host);
        this.propertySize = propertySize;

    }

    /**
     *
     * @param propertyid
     * @param noBedRooms
     * @param noRooms
     * @param propertySize
     */

    public FullProperty(int propertyid, int noBedRooms, int noRooms, double propertySize) {
        super(propertyid, noBedRooms, noRooms);
        this.propertySize = propertySize;
    }

    /**
     *
     * @param city
     * @param pricePerDay
     * @param propertySize
     */

    public FullProperty(String city, double pricePerDay, double propertySize) {
        super(city, pricePerDay);
        this.propertySize = propertySize;
    }

    /**
     *
     * @return
     */

    public double getPropertySize() {
        return propertySize;
    }

    /**
     *
     * @param propertySize
     */
    public void setPropertySize(double propertySize) {
        this.propertySize = propertySize;
    }

    /**
     *
     * @return price per day
     */
    @Override
    public double calculatePricePerDay() {
        double taxRate;
        if (propertySize <= 200) {
            taxRate = 0.01;
        } else if (propertySize > 200 && propertySize <= 300) {
            taxRate = 0.03;
        } else {
            taxRate = 0.04;
        }
        double taxAmount = getPricePerDay() * taxRate;
        return getPricePerDay() + taxAmount;
    }

    /**
     *
     * @param o the object to be compared.
     * @return
     */

    @Override
    public int compareTo(Property o) {
        return 0;
    }

    @Override
    public String toString() {
        return "FullProperty{" + super.toString() +
                "propertySize=" + propertySize +
                '}';
    }
}
