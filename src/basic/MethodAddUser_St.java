package basic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MethodAddUser_St implements ActionListener {

    private JPanel mainPanel;
    private JTextField id_text1;

    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField dob_text2;
    private JTextField wname;
    private JTextField exp;
    private JButton AddStdUserB;
    private JLabel title;
    Frame uFrame;
    Gold user_ui;

    MethodMenu menu_t;

    MethodAddUser_St(MethodMenu menu){
        menu.menuF.setVisible(false);
        AddStdUserB.addActionListener(this);
        uFrame = new Frame();
        uFrame.add(mainPanel);
        uFrame.setVisible(true);
        menu_t=menu;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==AddStdUserB){
            Gold gold_ui = new Gold();
            gold_ui.setUserID(Integer.parseInt(id_text1.getText().trim()));
            if(comboBox1.getSelectedItem().toString().equals("Cash")){
                gold_ui.setPreferredPaymentMethod("Cash");
            }
            if(comboBox1.getSelectedItem().toString().equals("Card")){
                gold_ui.setPreferredPaymentMethod("Card");
            }
            gold_ui.setDateofBirth(Basic.dateConverter(dob_text2.getText().trim()));



            if(e.getSource() == AddStdUserB) {
                //Basic.addUser(gold_ui);
                uFrame.setVisible(false);
                menu_t.menuF.setVisible(true);
            }
        }
    }
}
