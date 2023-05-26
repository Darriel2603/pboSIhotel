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
        user.setBounds(70, 90, 100, 30);
        add(user);

        JTextField username = new JTextField();
        username.setBounds(160, 90, 150, 30);
        add(username);

        JLabel pass = new JLabel("Password");
        pass.setBounds(70, 140, 100, 30);
        add(pass);

        JTextField password = new JTextField();
        password.setBounds(160, 140, 150, 30);
        add(password);

        JButton login = new JButton("Login");
        login.setBounds(70, 200, 120, 35);
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
        cancel.setBounds(190, 200, 120, 35);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);

        setBounds(500, 200, 400, 400);
        setResizable(false);
        setVisible(true);
    }
}
