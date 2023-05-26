package hotel.management.system;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    Dashboard() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(new GridLayout(1, 2, 10, 10));

        JButton btnResepsionis = new JButton("Resepsionis");
        add(btnResepsionis);

        JButton btnAdmin = new JButton("Admin");
        add(btnAdmin);

        setBounds(500, 200, 600, 300);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
