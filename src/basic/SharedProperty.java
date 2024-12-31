package basic;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author Nurberat Gökmen
 * @version 1.1
 */

public class SharedProperty extends Property implements PropertyPrice,java.lang.Comparable<Property> {

    /**
     *
     * @param host
     */
    public SharedProperty(Host host) {
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
     * @param host
     */

    public SharedProperty(int propertyid, int noBedRooms, int noRooms, String city, double pricePerDay, HashMap<Date, String> inspection, List<Booking> bookingList, Host host) {
        super(propertyid, noBedRooms, noRooms, city, pricePerDay, inspection, bookingList, host);

    }

    /**
     *
     * @param propertyid
     * @param noBedRooms
     * @param noRooms
     * @param city
     * @param pricePerDay
     * @param host
     */
    //addprop için kullandığım constructor
    public SharedProperty(int propertyid, int noBedRooms, int noRooms, String city, double pricePerDay, Host host) {
        super(propertyid, noBedRooms, noRooms, city, pricePerDay, host);

    }

    /**
     *
     * @param propertyid
     * @param noBedRooms
     * @param noRooms
     */


    public SharedProperty(int propertyid, int noBedRooms, int noRooms) {
        super(propertyid, noBedRooms, noRooms);
    }

    /**
     *
     * @param city
     * @param pricePerDay
     */

    public SharedProperty(String city, double pricePerDay) {
        super(city, pricePerDay);
    }

    /**
     *
     */

    public SharedProperty() {

    }

    /**
     *
     * @return price per day
     */

    @Override
    public double calculatePricePerDay() {
        return this.getPricePerDay() / this.getNoBedRooms();
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
        return super.toString();
    }


}

