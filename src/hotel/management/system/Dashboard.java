package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hotel.management.system.admin.*;

public class Dashboard extends JFrame {

    Dashboard() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(new GridLayout(1, 2, 10, 10));

        JButton btnResepsionis = new JButton("Resepsionis");
        btnResepsionis.setFont(new Font("Inter", Font.BOLD, 16));
        add(btnResepsionis);

        btnResepsionis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Reception();
            }
        });

        JButton btnAdmin = new JButton("Admin");
        btnAdmin.setFont(new Font("Inter", Font.BOLD, 16));
        add(btnAdmin);

        btnAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminPage();
            }
        });

        setBounds(660, 440, 600, 200);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
