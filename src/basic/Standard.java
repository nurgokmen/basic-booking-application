package basic;

import java.util.Date;
import java.util.List;
import java.util.Calendar;

/**
 * @author Nurberat Gökmen
 * @version 1.1
 */

public class Standard extends Customer{
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
    public Standard(int userID, Date dateofBirth, String firstName, String lastName, Date registrationDate, String preferredPaymentMethod, List<Booking> bookingList) {
        super(userID, dateofBirth, firstName, lastName, registrationDate, preferredPaymentMethod, bookingList);
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

    public Standard(int userID, String dob, String fname, String lname, String regdate, String preferredPaymentMethod) {
        super(userID, dob, fname, lname, regdate, preferredPaymentMethod);
    }

    /**
     *
     * @return preffered payment method
     */

    @Override
    public String getPreferredPaymentMethod() {
        return super.getPreferredPaymentMethod();
    }

    /**
     *
     * @param preferredPaymentMethod
     */

    @Override
    public void setPreferredPaymentMethod(String preferredPaymentMethod) {
        super.setPreferredPaymentMethod(preferredPaymentMethod);
    }

    /**
     *
     * @return
     */

    @Override
    public String toString() {
        return super.toString(); // there are no additional fields
    }

    /**
     *
     * @param registrationDate
     * @return
     */

    private int getYears(Date registrationDate) {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(registrationDate);
        Calendar currentCalendar = Calendar.getInstance();
        int yearsBetween = currentCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        if (startCalendar.get(Calendar.DAY_OF_YEAR) > currentCalendar.get(Calendar.DAY_OF_YEAR)) {
            yearsBetween--;
        }
        return yearsBetween;
    }

    /**
     *
     * @return discount percentage
     */

    @Override
    public double discountPercentage() {
        int years = getYears(getRegistrationDate());
        if (years >= 10) {
            return 0.02; // 2% discount for registration of 10 or more years
        }
        return 0; // No discount for less than 10 years
    }
}

