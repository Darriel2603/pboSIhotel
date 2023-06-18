package hotel.management.system.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface AddEmployeeInterface extends ActionListener {
    void actionPerformed(ActionEvent ae);
    boolean isValidAge(String age);
    boolean isValidPhoneNumber(String phoneNumber);
    boolean isValidEmail(String email);
}
