package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel user = new JLabel("Username");
        user.setBounds(150, 50, 100, 30);
        add(user);

        JTextField username = new JTextField();
        username.setBounds(230, 50, 150, 30);
        add(username);

        JLabel pass = new JLabel("Password");
        pass.setBounds(150, 100, 100, 30);
        add(pass);

        JTextField password = new JTextField();
        password.setBounds(230, 100, 150, 30);
        add(password);

        JButton login = new JButton("Login");
        login.setBounds(140, 180, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Dashboard();
            }
        });

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(280, 180, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);

        setBounds(500, 200, 600, 300);
        setResizable(false);
        setVisible(true);
    }
}
