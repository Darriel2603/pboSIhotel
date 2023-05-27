package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee extends JFrame {
    private JPanel contentPane;
    private JTable table;
    private JLabel nameLabel, ageLabel, genderLabel, jobLabel, salaryLabel, phoneLabel, nikLabel, mailLabel;

    Employee() {
        setBounds(460, 240, 1000, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        table = new JTable();
        table.setBounds(0, 34, 1000, 450);
        contentPane.add(table);

        JButton loadDataBtn = new JButton("Load Data");
        loadDataBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn conn = new Conn();
                    ResultSet rs = conn.s.executeQuery("select * from employee");
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        loadDataBtn.setBounds(350, 500, 120, 30);
        loadDataBtn.setBackground(Color.BLACK);
        loadDataBtn.setForeground(Color.WHITE);
        contentPane.add(loadDataBtn);

        JButton exitBtn = new JButton("Back");
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        exitBtn.setBounds(510, 500, 120, 30);
        exitBtn.setBackground(Color.WHITE);
        exitBtn.setForeground(Color.BLACK);
        contentPane.add(exitBtn);

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(41, 11, 46, 14);
        contentPane.add(nameLabel);

        ageLabel = new JLabel("Age");
        ageLabel.setBounds(159, 11, 46, 14);
        contentPane.add(ageLabel);

        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(273, 11, 46, 14);
        contentPane.add(genderLabel);

        jobLabel = new JLabel("Position");
        jobLabel.setBounds(416, 11, 46, 14);
        contentPane.add(jobLabel);

        salaryLabel = new JLabel("Salary");
        salaryLabel.setBounds(536, 11, 86, 14);
        contentPane.add(salaryLabel);

        phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(656, 11, 86, 14);
        contentPane.add(phoneLabel);

        nikLabel = new JLabel("NIK");
        nikLabel.setBounds(786, 11, 86, 14);
        contentPane.add(nikLabel);

        mailLabel = new JLabel("Mail");
        mailLabel.setBounds(896, 11, 86,14);
        contentPane.add(mailLabel);



        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Employee();
    }
}
