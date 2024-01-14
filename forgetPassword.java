import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class forgetPassword extends JFrame implements ActionListener {

    JButton update, fp;
    JTextField newPassword, meternumber;
    JLabel heading, lblnewPassword, lblmeternumber;

    forgetPassword() {

        setTitle("Forget Password");
        setSize(640, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);

        heading = new JLabel("Update Password");
        heading.setBounds(240, 20, 200, 25);
        heading.setFont(new Font("Tohoma", Font.PLAIN, 18));
        p.add(heading);

        lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setLayout(null);
        lblmeternumber.setBounds(220, 50, 150, 100);
        p.add(lblmeternumber);

        meternumber = new JTextField();
        meternumber.setBounds(370, 90, 150, 20);
        p.add(meternumber);

        lblnewPassword = new JLabel("New Password");
        lblnewPassword.setLayout(null);
        lblnewPassword.setBounds(220, 70, 150, 100);
        p.add(lblnewPassword);

        newPassword = new JTextField();
        newPassword.setBounds(370, 120, 150, 20);
        p.add(newPassword);

        update = new JButton("update");
        update.setLayout(null);
        update.setBounds(295, 150, 100, 20);
        update.addActionListener(this);
        p.add(update);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {

            String lblmeternumber = meternumber.getText();
            String lblnewpassword = newPassword.getText();

            try {
                Conn c = new Conn();
                String query = "update login set password = '" + lblnewpassword + "' where meter_no = '"
                        + lblmeternumber + "'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Password Updated Successfully");
                setVisible(false);

            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }

        else {
            setVisible(false);
        }
    }

    public static void main(String args[]) {
        new forgetPassword();
    }
}