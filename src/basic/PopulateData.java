package basic;

import java.awt.print.Book;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Nurberat Gökmen
 * @version 1.1
 */
public class PopulateData {

    private static ArrayList<User> user_list = new ArrayList<>(3);
    private static ArrayList<Property> property_list = new ArrayList<>(3);
    public static ArrayList<Booking> booking_list = new ArrayList<>(3);

    /**
     *
     * @param basic
     * This method initializes users, properties and bookings
     */
    public static void populateInitialdata(Basic basic) {

        // three users, 2 host, 2 gold and 1 standard. 3 users and 2 hosts in total


        Host host1 = new Host(1, "01/01/1980", "Nur", "Gökmen", "28/11/2023", 15);

        Host host2 = new Host(2, "01/01/1990", "Ege", "Çakır", "27/11/2023", 16);

        Gold gold1 = new Gold(3, "02/03/1995", "Ilgın", "Savaş", "04/08/2022", "cash", 2);

        Gold gold2 = new Gold(4, "02/03/1998", "Ali", "Yayla", "04/08/2021", "cash", 3);

        Standard standard1 = new Standard(5, "02/09/1995", "Tuba", "Ezgi", "04/06/2022", "cash");

        //Standard standard2 = new Standard(6, "02/03/1999", "İlayda", "Mengi", "04/08/2012", "cash");


        basic.addUserDirectly(host1);
        basic.addUserDirectly(host2);
        basic.addUserDirectly(gold1);
        basic.addUserDirectly(gold2);
        basic.addUserDirectly(standard1);


        //three properties, 1 shared 2 full

        SharedProperty shared1 = new SharedProperty();

        FullProperty full1 = new FullProperty(500);

        FullProperty full2 = new FullProperty(600);



        //each host has a property
        host1.addProperty(shared1);
        host1.addProperty(full1);
        host2.addProperty(full2);

        basic.addPropertyDirectly(shared1);
        basic.addPropertyDirectly(full1);
        basic.addPropertyDirectly(full2);



        // 3 bookings one per each user



        Booking booking1 = new Booking(3,1,"01/01/2024","05/01/2024");

        Booking booking2 = new Booking(4,2,"03/07/2023","06/07/2023");

        Booking booking3 = new Booking(5,2,"03/09/2023","06/09/2023");

        //each user has one booking
        gold1.addBooking(booking1);
        standard1.addBooking(booking2);
        gold2.addBooking(booking3);



        basic.addBooking(3, 1);
        System.out.println("bncamcnm");
        basic.addBooking(4, 3);
        basic.addBooking(5, 2);

        System.out.println("bncamcnm");



    }
}


