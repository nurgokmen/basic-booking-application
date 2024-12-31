package basic;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class BasicGUI extends JFrame {


    private JPanel content;
    private JTextField text_user_id;
    private JTextField text_property_id;
    private JTextField text_preffered_payment;

    private JTextField text_addBooking_date;

    private int option;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;

    public Basic new_basic;

    public ArrayList<Booking> bookingArrayList;

    private JTable t;
    private JTable t1;



    public static void main(String[] args){

        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {

                    BasicGUI frame = new BasicGUI();
                    frame.setVisible(true);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        });


    }

    private void JTextField_Typed_Key(java.awt.event.KeyEvent evnt)
    {
        char c = evnt.getKeyChar();
        if(!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
            evnt.consume();
        }

    }


    public BasicGUI() throws IOException {

        new_basic = new Basic();
        new_basic = new_basic.readData();

        setFont(new Font("Ariel", Font.PLAIN, 18));
        setResizable(false);
        setTitle("Bed And Breakfast In Cyprus");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150,150,1024, 1024);
        content = new JPanel();


    }


}
