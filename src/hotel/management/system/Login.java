package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField username;
    JPasswordField password;
    JButton login, cancel;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(70, 90, 100, 30);
        add(userLabel);

        username = new JTextField();
        username.setBounds(160, 90, 150, 30);
        add(username);

        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(70, 140, 100, 30);
        add(passLabel);

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
        cancel.setBounds(210, 200, 100, 35);
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);

        setBounds(760, 340, 400, 320);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String user = username.getText();
            String pass = new String(password.getPassword());

            try {
                Conn c = new Conn();
                Connection conn = c.connection;

                String query = "SELECT * FROM login WHERE username = ? AND password = ?";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, user);
                pstmt.setString(2, pass);

                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    setVisible(false);
                    new Dashboard();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }

                pstmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}

