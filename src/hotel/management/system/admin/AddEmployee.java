package hotel.management.system.admin;

import hotel.management.system.Conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class AddEmployee extends JFrame implements ActionListener {
    JLabel nameLabel, ageLabel, genderLabel, jobLabel, salaryLabel, phoneLabel, emailLabel, image, nikLabel;
    JTextField nameField, ageField, salaryField, phoneField, emailField, nikField;
    JRadioButton rbMale, rbFemale;
    JComboBox<String> cbJob;
    JButton submit, cancel;

    AddEmployee() {
        setLayout(null);

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(60, 30, 120, 30);
        nameLabel.setFont(new Font("Inter", Font.PLAIN, 17));
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(200, 30, 150, 30);
        add(nameField);

        ageLabel = new JLabel("Age");
        ageLabel.setBounds(60, 80, 120, 30);
        ageLabel.setFont(new Font("Inter", Font.PLAIN, 17));
        add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(200, 80, 150, 30);
        add(ageField);

        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(60, 130, 120, 30);
        genderLabel.setFont(new Font("Inter", Font.PLAIN, 17));
        add(genderLabel);

        rbMale = new JRadioButton("Male");
        rbMale.setBounds(200, 130, 100, 30);
        rbMale.setFont(new Font("Inter", Font.PLAIN, 14));
        rbMale.setBackground(Color.WHITE);
        add(rbMale);

        rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(300, 130, 120, 30);
        rbFemale.setFont(new Font("Inter", Font.PLAIN, 14));
        rbFemale.setOpaque(false);
        add(rbFemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);

        jobLabel = new JLabel("Job");
        jobLabel.setBounds(60, 180, 120, 30);
        jobLabel.setFont(new Font("Inter", Font.PLAIN, 17));
        add(jobLabel);

        String[] jobOptions = {"Receptionist", "Waiter/Waitress", "Housekeeping", "Kitchen Staff", "Room Service", "Chef", "Waiter/Waitress", "Manager", "Accountant"};
        cbJob = new JComboBox<>(jobOptions);
        cbJob.setBounds(200, 180, 150, 30);
        cbJob.setBackground(Color.WHITE);
        add(cbJob);

        salaryLabel = new JLabel("Salary");
        salaryLabel.setBounds(60, 230, 120, 30);
        salaryLabel.setFont(new Font("Inter", Font.PLAIN, 17));
        add(salaryLabel);

        salaryField = new JTextField();
        salaryField.setBounds(200, 230, 150, 30);
        add(salaryField);

        phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(60, 280, 120, 30);
        phoneLabel.setFont(new Font("Inter", Font.PLAIN, 17));
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(200, 280, 150, 30);
        add(phoneField);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(60, 330, 120, 30);
        emailLabel.setFont(new Font("Inter", Font.PLAIN, 17));
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(200, 330, 150, 30);
        add(emailField);

        nikLabel = new JLabel("NIK");
        nikLabel.setBounds(60, 380, 120, 30);
        nikLabel.setFont(new Font("Inter", Font.PLAIN, 17));
        add(nikLabel);

        nikField = new JTextField();
        nikField.setBounds(200, 380, 150, 30);
        add(nikField);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.BLACK);
        cancel.setBounds(60, 430, 120, 30);
        cancel.addActionListener(this);
        add(cancel);

        submit = new JButton("Add");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200, 430, 120, 30);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1 = new ImageIcon("src/hotel/management/system/assets/employee.jpg");
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(380, 30, 450, 450);
        add(image);

        getContentPane().setBackground(Color.WHITE);
        setBounds(535, 270, 850, 540);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String name = nameField.getText();
            String age = ageField.getText();
            String salary = salaryField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String nik = nikField.getText();

            String gender = null;
            if (rbMale.isSelected()) {
                gender = "Male";
            } else if (rbFemale.isSelected()) {
                gender = "Female";
            }

            String job = (String) cbJob.getSelectedItem();

            if (name.isEmpty() || age.isEmpty() || salary.isEmpty() || phone.isEmpty() || email.isEmpty() || nik.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!isValidAge(age)) {
                JOptionPane.showMessageDialog(this, "Age must be a positive number", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!isValidPhoneNumber(phone)) {
                JOptionPane.showMessageDialog(this, "Invalid phone number", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(this, "Invalid email", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    Conn c = new Conn();

                    String query = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

                    PreparedStatement ps = c.connection.prepareStatement(query);
                    ps.setString(1, name);
                    ps.setInt(2, Integer.parseInt(age));
                    ps.setString(3, gender);
                    ps.setString(4, job);
                    ps.setDouble(5, Double.parseDouble(salary));
                    ps.setString(6, phone);
                    ps.setString(7, email);
                    ps.setString(8, nik);

                    int rowsAffected = ps.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Employee added successfully");
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to add employee", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    ps.close();
                    c.connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new AdminPage().setVisible(true);
        }
    }

    private boolean isValidAge(String age) {
        try {
            int ageValue = Integer.parseInt(age);
            return ageValue > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "\\d{10,12}"; // Phone number format: 10 to 12 digit numbers
        return Pattern.matches(regex, phoneNumber);
    }

    private boolean isValidEmail(String email) {
        String regex = "^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$"; // Valid email format
        return Pattern.matches(regex, email);
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
