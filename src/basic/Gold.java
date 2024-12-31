package basic;

import java.util.Date;
import java.util.List;

/**
 * @author Nurberat Gökmen
 * @version 1.1
 */

public class Gold extends Customer{

    private int goldLevel;

    /**
     *
     * @param userID
     * @param dateofBirth
     * @param firstName
     * @param lastName
     * @param registrationDate
     * @param preferredPaymentMethod
     * @param bookingList
     * @param goldLevel
     */
    public Gold(int userID, Date dateofBirth, String firstName, String lastName, Date registrationDate, String preferredPaymentMethod, List<Booking> bookingList, int goldLevel) {
        super(userID, dateofBirth, firstName, lastName, registrationDate, preferredPaymentMethod, bookingList);
        this.goldLevel = goldLevel;
    }

    public Gold() {

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
     * @param goldLevel
     */

    public Gold(int userID, String dob, String fname, String lname, String regdate, String preferredPaymentMethod, List<Booking> bookingList, int goldLevel) {
        super(userID, dob, fname, lname, regdate, preferredPaymentMethod, bookingList);
        this.goldLevel = goldLevel;
    }

    /**
     *
     * @param userID
     * @param dob
     * @param fname
     * @param lname
     * @param regdate
     * @param preferredPaymentMethod
     * @param goldLevel
     */

    public Gold(int userID, String dob, String fname, String lname, String regdate, String preferredPaymentMethod, int goldLevel) {
        super(userID, dob, fname, lname, regdate, preferredPaymentMethod);
        this.goldLevel = goldLevel;
    }

    /**
     *
     * @return
     */

    public int getGoldLevel() {
        return goldLevel;
    }

    /**
     *
     * @param goldLevel
     */
    public void setGoldLevel(int goldLevel) {
        this.goldLevel = goldLevel;
    }

    @Override
    public String toString() {
        return super.toString() + ", goldLevel=" + goldLevel;
    }

    /**
     *
     * @return the discount percentage based on the gold level
     */
    public double getDiscountForUser() {
        switch (getGoldLevel()) {
            case 1:
                return 0.01; // 1% discount
            case 2:
                return 0.02; // 2% discount
            case 3:
                return 0.03; // 3% discount
            default:
                return 0; // No discount
        }
    }

    @Override
    public double discountPercentage() {
        return goldLevel * 0.01;
    }
}

