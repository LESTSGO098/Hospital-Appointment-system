package USER_INTERFACE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnClear;
    private JLabel lblMessage;

    public LoginPage() {
        initializeUI();
    }

    private void initializeUI() {

        setTitle("System Login");
        setSize(400, 280);
        setLocationRelativeTo(null); // center screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Main panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        // ===== Title =====
        JLabel title = new JLabel("LOGIN", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        panel.add(title, BorderLayout.NORTH);

        // ===== Form Panel =====
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Username
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
        txtUsername = new JTextField(15);
        formPanel.add(txtUsername, gbc);

        // Password
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        txtPassword = new JPasswordField(15);
        formPanel.add(txtPassword, gbc);

        // Message label
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        lblMessage = new JLabel(" ");
        lblMessage.setForeground(Color.RED);
        lblMessage.setHorizontalAlignment(JLabel.CENTER);
        formPanel.add(lblMessage, gbc);

        panel.add(formPanel, BorderLayout.CENTER);

        // ===== Buttons =====
        JPanel buttonPanel = new JPanel();

        btnLogin = new JButton("Login");
        btnClear = new JButton("Clear");

        buttonPanel.add(btnLogin);
        buttonPanel.add(btnClear);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);

        // ===== Actions =====
        btnLogin.addActionListener(e -> login());
        btnClear.addActionListener(e -> clearFields());

        // Enter key triggers login
        getRootPane().setDefaultButton(btnLogin);
    }

    private void login() {

        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            lblMessage.setText("Please fill all fields");
            return;
        }

        // ===== TEMP authentication =====
        // Replace later with database check
        if (username.equals("admin") && password.equals("1234")) {

            JOptionPane.showMessageDialog(this, "Login Successful!");

            new Dashboard (); // open next screen
            dispose(); // close login window
        }
        else {
            lblMessage.setText("Invalid username or password");
        }
    }

    private void clearFields() {
        txtUsername.setText("");
        txtPassword.setText("");
        lblMessage.setText(" ");
    }

    // ===== Main method =====
    public static void main(String[] args) {

        // System look & feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> new LoginPage().setVisible(true));
    }
}
