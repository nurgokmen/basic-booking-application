package basic;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Nurberat Gökmen
 * @version 1.1
 */
public class Host extends User {

    private double taxNumber;
    private List<Property> properties;

    /**
     *
     * @param properties
     */
    public Host(List<Property> properties) {
        this.properties = properties;
    }

    /**
     * initializes the list of poperties
     * @param property
     */
    public void addProperty(Property property) {
        if (this.properties == null) {
            this.properties = new ArrayList<>();
        }
        this.properties.add(property);
    }

    /**
     *
     * @param userID
     * @param dateofBirth
     * @param firstName
     * @param lastName
     * @param registrationDate
     * @param taxNumber
     * @param properties
     */
    public Host(int userID, Date dateofBirth, String firstName, String lastName, Date registrationDate, double taxNumber, List<Property> properties) {
        super(userID, dateofBirth, firstName, lastName, registrationDate);
        this.taxNumber = taxNumber;
        this.properties = new ArrayList<>();
    }

    /**
     *
     * @param userID
     * @param dateofBirth
     * @param firstName
     * @param lastName
     * @param registrationDate
     * @param properties
     */

    public Host(int userID, Date dateofBirth, String firstName, String lastName, Date registrationDate, List<Property> properties) {
        super(userID, dateofBirth, firstName, lastName, registrationDate);
        this.properties = new ArrayList<>();
    }

    /**
     *
     * @param userID
     * @param dob
     * @param fname
     * @param lname
     * @param regdate
     * @param properties
     */

    public Host(int userID, String dob, String fname, String lname, String regdate, List<Property> properties) {
        super(userID, dob, fname, lname, regdate);
        this.properties = properties;
    }

    /**
     *
     * @param userID
     * @param dateofBirth
     * @param firstName
     * @param lastName
     * @param registrationDate
     * @param taxNumber
     */

    public Host(int userID, Date dateofBirth, String firstName, String lastName, Date registrationDate, double taxNumber) {
        super(userID, dateofBirth, firstName, lastName, registrationDate);
        this.taxNumber = taxNumber;
    }

    /**
     * takes the most of the parameters form its upper class and initializes the tax number
     * @param userID
     * @param dob
     * @param fname
     * @param lname
     * @param regdate
     * @param taxNumber
     */

    public Host(int userID, String dob, String fname, String lname, String regdate, double taxNumber) {
        super(userID, dob, fname, lname, regdate);
        this.taxNumber = taxNumber;
    }

    /**
     *
     * @return taxNumber
     */

    public double getTaxNumber() {
        return taxNumber;
    }

    /**
     * sets the tax number to a given value
     * @param taxNumber
     */

    public void setTaxNumber(double taxNumber) {
        this.taxNumber = taxNumber;
    }

    /**
     *
     * @return
     */

    @Override
    public String toString() {
        return super.toString();
    }
}
