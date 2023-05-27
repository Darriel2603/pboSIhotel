package hotel.management.system;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame {
    private JPanel contentPane;
    private JTextField statusField, roomField, nameField, depositField, paymentField;
    Choice idChoice, c2;

    UpdateCheck() {
        setBounds(485, 290, 500, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel updateCheckStatusLabel = new JLabel("Check-In Details");
        updateCheckStatusLabel.setFont(new Font("Inter", Font.PLAIN, 20));
        updateCheckStatusLabel.setBounds(124, 11, 222, 25);
        contentPane.add(updateCheckStatusLabel);

        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(25, 88, 46, 14);
        contentPane.add(idLabel);

        idChoice = new Choice();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM kustomer");
            while (rs.next()) {
                idChoice.add(rs.getString("id_number"));
            }
        } catch (Exception e) {}
        idChoice.setBounds(248, 85, 140, 20);
        contentPane.add(idChoice);

        JLabel roomNumberLabel = new JLabel("Room Number");
        roomNumberLabel.setBounds(25, 129, 107, 14);
        contentPane.add(roomNumberLabel);

        roomField = new JTextField();
        roomField.setBounds(248, 126, 140, 20);
        contentPane.add(roomField);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(25, 174, 97, 14);
        contentPane.add(nameLabel);

        JLabel checkInLabel = new JLabel("Checked-in");
        checkInLabel.setBounds(25, 216, 107, 14);
        contentPane.add(checkInLabel);

        JLabel amountPaidLabel = new JLabel("Amount Paid");
        amountPaidLabel.setBounds(25, 261, 107, 14);
        contentPane.add(amountPaidLabel);

        JLabel pendingAmountLabel = new JLabel("Pending Amount");
        pendingAmountLabel.setBounds(25, 302, 150, 14);
        contentPane.add(pendingAmountLabel);

        nameField = new JTextField();
        nameField.setBounds(248, 171, 140, 20);
        contentPane.add(nameField);
        nameField.setColumns(10);

        statusField = new JTextField();
        statusField.setBounds(248, 216, 140, 20);
        contentPane.add(statusField);
        statusField.setColumns(10);

        depositField = new JTextField();
        depositField.setBounds(248, 258, 140, 20);
        contentPane.add(depositField);
        depositField.setColumns(10);

        paymentField = new JTextField();
        paymentField.setBounds(248, 299, 140, 20);
        contentPane.add(paymentField);
        paymentField.setColumns(10);

        JButton updateBtn = new JButton("Update");
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn conn = new Conn();

                    String id = idChoice.getSelectedItem();
                    String roomNumber = roomField.getText();
                    String name = nameField.getText();
                    String status = statusField.getText();
                    String deposit = depositField.getText();

                    conn.s.executeUpdate("update kustomer set room = '"+roomNumber+"', name = '"+name+"', CHECKIN_TIME = '"+status+"', deposit = '"+deposit+"' where id_number = '"+id+"'");

                    JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                    setVisible(false);
                } catch (Exception ee) {
                    System.out.println(ee);
                }
            }
        });

        updateBtn.setBounds(168, 378, 89, 23);
        updateBtn.setBackground(Color.BLACK);
        updateBtn.setForeground(Color.white);
        contentPane.add(updateBtn);

        JButton exitBtn = new JButton("Back");
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        exitBtn.setBounds(281, 378, 89, 23);
        exitBtn.setBackground(Color.white);
        exitBtn.setForeground(Color.black);
        contentPane.add(exitBtn);

        JButton checkBtn = new JButton("Check");
        checkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = idChoice.getSelectedItem();
                    Conn c = new Conn();
                    ResultSet rs1 = c.s.executeQuery("select * from kustomer where id_number = '" + id + "'");

                    while (rs1.next()) {
                        roomField.setText(rs1.getString("room"));
                        nameField.setText(rs1.getString("name"));
                        statusField.setText(rs1.getString("CHECKIN_TIME"));
                        depositField.setText(rs1.getString("deposit"));
                    }
                } catch (Exception ee){}
                try {
                    String total = "";
                    Conn c = new Conn();
                    ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '" + roomField.getText() + "'");

                    while (rs2.next()) {
                        total = rs2.getString("price");
                    }
                    String paid = depositField.getText();
                    int pending = Integer.parseInt(total) - Integer.parseInt(paid);
                    paymentField.setText(Integer.toString(pending));
                } catch (Exception ee){}
            }
        });

        checkBtn.setBounds(56, 378, 89, 23);
        checkBtn.setBackground(Color.BLACK);
        checkBtn.setForeground(Color.WHITE);
        contentPane.add(checkBtn);

        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateCheck();
    }
}
