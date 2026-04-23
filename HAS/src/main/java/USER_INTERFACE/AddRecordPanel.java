package USER_INTERFACE;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author joelm
 */
public class AddRecordPanel extends JPanel {

    // temporary memory storage (replace with DB later)
    public static ArrayList<String[]> records = new ArrayList<>();

    private JTextField txtName, txtPhone, txtEmail;

    public AddRecordPanel() {

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel form = new JPanel(new GridLayout(4,2,10,10));
        form.setBorder(BorderFactory.createTitledBorder("Add New Record"));

        txtName = new JTextField();
        txtPhone = new JTextField();
        txtEmail = new JTextField();
        JButton btnSave = new JButton("Save");

        form.add(new JLabel("Name:"));
        form.add(txtName);

        form.add(new JLabel("Phone:"));
        form.add(txtPhone);

        form.add(new JLabel("Email:"));
        form.add(txtEmail);

        form.add(new JLabel(""));
        form.add(btnSave);

        add(form, gbc);

        btnSave.addActionListener(e -> saveRecord());
    }

    private void saveRecord() {

        String name = txtName.getText();
        String phone = txtPhone.getText();
        String email = txtEmail.getText();

        if(name.isEmpty() || phone.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fill all fields!");
            return;
        }

        records.add(new String[]{name, phone, email});

        JOptionPane.showMessageDialog(this, "Record saved!");

        txtName.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
    }
}
