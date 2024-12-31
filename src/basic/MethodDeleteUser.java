package basic;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MethodDeleteUser implements ActionListener {
    private JPanel mainPanel;
    private JTextField textField1;
    private JButton deleteButton;

    Frame Framed;
    MethodMenu m2;

    MethodDeleteUser(MethodMenu menu){
        menu.menuF.setVisible(false);
        deleteButton.addActionListener(this);
        Framed = new Frame();
        Framed.add(mainPanel);
        Framed.setVisible(true);
        m2 = menu;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==deleteButton){
            Basic.deleteUser(Integer.parseInt(textField1.getText()));
            Framed.setVisible(false);
            m2.menuF.setVisible(true);
        }
    }
}
