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

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout(10, 10));

        JButton btnResepsionis = new JButton("Resepsionis");
        btnResepsionis.setFont(new Font("Inter", Font.BOLD, 16));
        panel.add(btnResepsionis, BorderLayout.CENTER);

        btnResepsionis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Reception();
            }
        });

        add(panel);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.WHITE);
        panel2.setLayout(new BorderLayout(10, 10));

        JButton btnAdmin = new JButton("Admin");
        btnAdmin.setFont(new Font("Inter", Font.BOLD, 16));
        panel2.add(btnAdmin, BorderLayout.CENTER);

        btnAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminPage();
            }
        });

        add(panel2);

        setBounds(660, 440, 600, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
