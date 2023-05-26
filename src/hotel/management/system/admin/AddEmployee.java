package hotel.management.system.admin;
import hotel.management.system.Conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hotel.management.system.*;

public class AddEmployee extends JFrame implements ActionListener {
    JLabel nameLabel, ageLabel, genderLabel, jobLabel, salaryLabel, phoneLabel, emailLabel, image, nikLabel;
    JTextField nameField, ageField, salaryField, phoneField, emailField, nikField;
    JRadioButton rbMale, rbFemale;
    JComboBox<String> cbJob;
    JButton submit;

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
        rbMale.setBounds(200, 130, 70, 30);
        rbMale.setFont(new Font("Inter", Font.PLAIN, 14));
        rbMale.setBackground(Color.WHITE);
        add(rbMale);

        rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(280, 130, 100, 30);
        rbFemale.setFont(new Font("Inter", Font.PLAIN, 14));
        rbFemale.setBackground(Color.WHITE);
        add(rbFemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);

        jobLabel = new JLabel("Job");
        jobLabel.setBounds(60, 180, 120, 30);
        jobLabel.setFont(new Font("Inter", Font.PLAIN, 17));
        add(jobLabel);

        String[] str = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Chef", "Waiter/Waitress", "Manager", "Accountant"};
        cbJob = new JComboBox<>(str);
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

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200, 430, 150, 30);
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
        String name = nameField.getText();
        String age = ageField.getText();
        String salary = salaryField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String nik = nikField.getText();

        String gender = null;
        if(rbMale.isSelected()) {
            gender = "Male";
        } else if (rbFemale.isSelected()) {
            gender = "Female";
        }

        String job = (String) cbJob.getSelectedItem();

        if (name.isEmpty() || age.isEmpty() || salary.isEmpty() || phone.isEmpty() || email.isEmpty() || nik.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harap lengkapi semua field", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                Conn c = new Conn();

                String query = "INSERT INTO employee values( '" + name + "', '" + age + "', '" + gender + "', '" + job + "', '" + salary + "','" + phone + "', '" + email + "', '" + nik + "')";

                c.s.executeQuery(query);

                JOptionPane.showMessageDialog(null, "Employee added success");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
    public static void main(String[] args) {
        new AddEmployee();
    }
}
