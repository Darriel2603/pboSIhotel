package hotel.management.system;

import javax.swing.*;

public class Dashboard extends JFrame {

    private JLabel backgroundLabel;
    Dashboard() {
        setSize(1550, 1000);

        ImageIcon backgroundImage = new ImageIcon("aseets/background dashboard.jpg");
        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 1550, 1000);
        add(backgroundLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
