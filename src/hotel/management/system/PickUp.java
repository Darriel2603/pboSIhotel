package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PickUp extends JFrame {
    private JPanel contentPane;
    private JTable table;
    private Choice carType;

    PickUp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 200, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel heading = new JLabel("Pick Up Service");
        heading.setFont(new Font("Inter", Font.PLAIN, 20));
        heading.setBounds(90, 11, 158, 25);
        contentPane.add(heading);

        JLabel cartypeLabel = new JLabel("Type of Car");
        cartypeLabel.setBounds(32, 97, 89, 14);
        contentPane.add(cartypeLabel);

        carType = new Choice();
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from driver");
            while(rs.next()) {
                carType.add(rs.getString("brand"));
            }
        } catch (Exception e) {}
        carType.setBounds(123, 94, 150, 25);
        contentPane.add(carType);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(24, 208, 46, 14);
        contentPane.add(nameLabel);

        JButton displayBtn = new JButton("Display");
        displayBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from driver where brand = '" +carType.getSelectedItem()+ "'");
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (SQLException ss){
                    ss.printStackTrace();
                }
            }
        });
        displayBtn.setBounds(200, 500, 120, 30);
        displayBtn.setBackground(Color.BLACK);
        displayBtn.setForeground(Color.WHITE);
        contentPane.add(displayBtn);

        table = new JTable();
        table.setBounds(0, 233, 800, 250);
        contentPane.add(table);

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        backBtn.setBounds(420, 500, 120, 30);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        contentPane.add(backBtn);

        JLabel ageLabel = new JLabel("Age");
        ageLabel.setBounds(165, 208, 46, 14);
        contentPane.add(ageLabel);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(264, 208, 46, 14);
        contentPane.add(genderLabel);

        JLabel companyLabel = new JLabel("Company");
        companyLabel.setBounds(366, 208, 80, 14);
        contentPane.add(companyLabel);

        JLabel brandLabel = new JLabel("Brand");
        brandLabel.setBounds(486, 208, 105, 14);
        contentPane.add(brandLabel);

        JLabel availableLabel = new JLabel("Available");
        availableLabel.setBounds(600, 208, 86, 14);
        contentPane.add(availableLabel);

        JLabel locationLabel = new JLabel("Location");
        locationLabel.setBounds(700, 208, 73, 14);
        contentPane.add(locationLabel);


        setResizable(false);
        setVisible(true);
        }




    public static void main(String[] args) {
        new PickUp();
    }
}
