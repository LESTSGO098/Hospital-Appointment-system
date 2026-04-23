package USER_INTERFACE;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    // Layout for switching pages
    private CardLayout cardLayout;
    private JPanel contentPanel;

    public Dashboard() {
        initializeUI();
    }

    private void initializeUI() {

        setTitle("Management System - Dashboard");
        setSize(900, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // ======================
        // HEADER
        // ======================
        JLabel header = new JLabel("Dashboard", JLabel.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 22));
        header.setOpaque(true);
        header.setBackground(new Color(45, 45, 45));
        header.setForeground(Color.WHITE);
        header.setPreferredSize(new Dimension(0, 60));

        add(header, BorderLayout.NORTH);

        // ======================
        // SIDEBAR
        // ======================
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new GridLayout(6, 1, 5, 5));
        sidebar.setPreferredSize(new Dimension(180, 0));
        sidebar.setBackground(new Color(60, 63, 65));

        JButton btnHome = createButton("Home");
        JButton btnAdd = createButton("Add Record");
        JButton btnView = createButton("View Records");
        JButton btnReports = createButton("Reports");
        JButton btnLogout = createButton("Logout");

        sidebar.add(btnHome);
        sidebar.add(btnAdd);
        sidebar.add(btnView);
        sidebar.add(btnReports);
        sidebar.add(new JLabel()); // spacer
        sidebar.add(btnLogout);

        add(sidebar, BorderLayout.WEST);

        // ======================
        // CONTENT AREA (CardLayout)
        // ======================
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        contentPanel.add(homePanel(), "HOME");
        contentPanel.add(addPanel(), "ADD");
        contentPanel.add(viewPanel(), "VIEW");
        contentPanel.add(reportPanel(), "REPORT");

        add(contentPanel, BorderLayout.CENTER);

        // ======================
        // BUTTON ACTIONS
        // ======================
        btnHome.addActionListener(e -> cardLayout.show(contentPanel, "HOME"));
        btnAdd.addActionListener(e -> cardLayout.show(contentPanel, "ADD"));
        btnView.addActionListener(e -> cardLayout.show(contentPanel, "VIEW"));
        btnReports.addActionListener(e -> cardLayout.show(contentPanel, "REPORT"));

        btnLogout.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Logout now?",
                    "Confirm",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                new LoginPage().setVisible(true);
                dispose();
            }
        });

        setVisible(true);
    }

    // ======================
    // Sidebar button style
    // ======================
    private JButton createButton(String text) {

        JButton btn = new JButton(text);
        btn.setFocusPainted(false);
        btn.setBackground(new Color(77, 77, 77));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.PLAIN, 14));

        return btn;
    }

    // ======================
    // Pages
    // ======================

    private JPanel homePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("Welcome to the System", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));

        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    private JPanel addPanel() {
        JPanel panel = new JPanel(new GridBagLayout());

        JPanel form = new JPanel(new GridLayout(4, 2, 10, 10));
        form.setBorder(BorderFactory.createTitledBorder("Add Record"));

        JTextField name = new JTextField();
        JTextField phone = new JTextField();
        JTextField email = new JTextField();
        JButton save = new JButton("Save");

        form.add(new JLabel("Name:"));
        form.add(name);

        form.add(new JLabel("Phone:"));
        form.add(phone);

        form.add(new JLabel("Email:"));
        form.add(email);

        form.add(new JLabel(""));
        form.add(save);

        save.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Saved (demo only)")
        );

        panel.add(form);
        return panel;
    }

    private JPanel viewPanel() {

        JPanel panel = new JPanel(new BorderLayout());

        String[] columns = {"ID", "Name", "Phone", "Email"};

        Object[][] data = {
                {"1", "John", "876-1234", "john@email.com"},
                {"2", "Mary", "876-5555", "mary@email.com"}
        };

        JTable table = new JTable(data, columns);

        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        return panel;
    }

    private JPanel reportPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("Reports Coming Soon...", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));

        panel.add(label, BorderLayout.CENTER);
        return panel;
    }
}
