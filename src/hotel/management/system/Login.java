package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField username;
    JPasswordField password;
    JButton login, cancel;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel user = new JLabel("Username");
        user.setBounds(70, 90, 100, 30);
        add(user);

        username = new JTextField();
        username.setBounds(160, 90, 150, 30);
        add(username);

        JLabel pass = new JLabel("Password");
        pass.setBounds(70, 140, 100, 30);
        add(pass);

        password = new JPasswordField();
        password.setBounds(160, 140, 150, 30);
        add(password);

        login = new JButton("Login");
        login.setBounds(70, 200, 120, 35);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(190, 200, 120, 35);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setBounds(760, 340, 400, 400);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String user = username.getText();
            String pass = password.getText();

            try {
                Conn c = new Conn();

                String query = "select * from login where username = '" + user + "' and password = '" + pass + "'";

                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Dashboard();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }


}
