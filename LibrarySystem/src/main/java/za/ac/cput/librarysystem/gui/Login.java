package za.ac.cput.librarysystem.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import za.ac.cput.librarysystem.dao.UserDAO;
import za.ac.cput.librarysystem.domain.User;

public class Login extends JFrame {

    private JPanel panelWest, panelCenter;// panelEast;
    private JLabel lblUsername, lblPassword, lblNotMember, lblRole, lblImage, lblUsernameError, lblPasswordError;
    private JTextField txtUsername, txtPassword;
    private JButton btnLogin, btnSignUp;
    private JComboBox cmbRole;
    private ImageIcon loginImage;
    private UserDAO dao;
    private ArrayList<User> userList;

    public Login() {
        //panelEast = new JPanel();
        panelWest = new JPanel();
        panelCenter = new JPanel();

        ImageIcon originalImage = new ImageIcon("C:\\Users\\Ahlumakwakho Nkqayi\\Pictures\\icon.png");
        Image scaledImage = originalImage.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        loginImage = new ImageIcon(scaledImage);
        lblImage = new JLabel(loginImage);

        lblUsername = new JLabel("Email:");
        lblPassword = new JLabel("Password:");
        lblNotMember = new JLabel("Not a member? Click here to sign up!");
        lblRole = new JLabel("Role");
        lblUsernameError = new JLabel("");
        lblPasswordError = new JLabel("");

        txtUsername = new JTextField(20);
        txtPassword = new JTextField(20);

        btnLogin = new JButton("LOGIN");
        btnSignUp = new JButton("SIGNUP");

        cmbRole = new JComboBox(new String[]{"--Select--", "Admin", "Student"});

        dao = new UserDAO();
        lblUsernameError.setForeground(Color.red);
        lblPasswordError.setForeground(Color.red);

//        lblUsername.setBorder(new EmptyBorder(0,0,0, 10));
//        lblPassword.setBorder(new EmptyBorder(0,0,0,10));
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblUsernameError.setText("");
                lblPasswordError.setText("");

                String username = txtUsername.getText().trim();
                String password = txtPassword.getText().trim();
               // String role = cmbRole.getSelectedItem().toString();

                boolean valid = true;

                // Check if username and password fields are empty
                if (username.isEmpty()) {
                    lblUsernameError.setText("This field is required");
                    valid = false;
                }
                if (password.isEmpty()) {
                    lblPasswordError.setText("This field is required");
                    valid = false;
                }

                if (valid) {
                    userList = dao.retrieValues(); // Retrieve the list of users from the DAO
                    boolean loginSuccess = false;

                    // Check if the entered credentials match any user in the list
                    for (User user : userList) {
                        if (user.getEmail().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                            loginSuccess = true;
                            break;
                        }
                    }

                    if (loginSuccess) {
                        // Transition to the home GUI only if login is successful
                        JOptionPane.showMessageDialog(null, "You have successfully logged in");
                        setVisibleFrame(false);
                        RunLibrarySystem.HomeGui();
                    } else {
                        // Display error if login credentials are incorrect
                        JOptionPane.showMessageDialog(null, "Invalid username or password");
                    }
                }
            }
        });

        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisibleFrame(false);
                RunLibrarySystem.signupGui();
            }
        });
    }

    public void setLoginGui() {
//        panelEast.setLayout(new GridLayout(7, 1));
        panelWest.setLayout(new GridLayout(7, 1));
        panelCenter.setLayout(new GridLayout(9, 1));

//        panelEast.add(new JLabel(""));
//        panelEast.add(new JLabel(""));
//        panelEast.add(new JLabel(""));
//        panelEast.add(new JLabel(""));
//        panelEast.add(new JLabel(""));
//        panelEast.add(new JLabel(""));
//        panelEast.add(new JLabel(""));
//        this.add(panelEast, BorderLayout.EAST);
        panelCenter.add(createPanelWithComponent(lblImage));
        panelCenter.add(createPanelWithComponent(txtUsername));
        panelCenter.add(createPanelWithComponent(lblUsernameError));
        panelCenter.add(createPanelWithComponent(txtPassword));
        panelCenter.add(createPanelWithComponent(lblPasswordError));
        panelCenter.add(createPanelWithComponent(cmbRole));
        panelCenter.add(createPanelWithComponent(btnLogin));
        panelCenter.add(createPanelWithComponent(lblNotMember));
        panelCenter.add(createPanelWithComponent(btnSignUp));
        this.add(panelCenter, BorderLayout.CENTER);
        panelWest.add(new JLabel(""));
        panelWest.add(lblUsername);
        panelWest.add(lblPassword);
        panelWest.add(lblRole);
        panelWest.add(new JLabel(""));
        panelWest.add(new JLabel(""));
        panelWest.add(new JLabel(""));
        this.add(panelWest, BorderLayout.WEST);
    }

    private JPanel createPanelWithComponent(JComponent component) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(component);
        return panel;

    }

    private JPanel createVerticalStack(JComponent topComponent, JComponent bottomComponent) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(topComponent);
        panel.add(bottomComponent);
        return panel;
    }

    public void setVisibleFrame(Boolean x) {
        this.setVisible(x);
    }

}
//
// //lblUsernameError.setText("");
//                //lblPasswordError.setText("");
//                String username = txtUsername.getText().trim();
//                String password = new String(txtPassword.getText().trim());
//                boolean valid = true;
//                
//                userList = dao.retrieValues();
//                User userTemp = new User(txtUsername.getText(), txtPassword.getText());
//
//                for (User user : userList) {
//                    if (user.getEmail().equalsIgnoreCase(userTemp.getEmail()) && user.getPassword().equalsIgnoreCase(userTemp.getPassword())) {
//
//                        JOptionPane.showMessageDialog(null, "SUCCESS!");
//                    } else if (user.getEmail().isEmpty()) {
//                        lblUsernameError.setText("This field is required");
//                        valid = false;
//                    } else if (user.getPassword().isEmpty());
//                        lblPasswordError.setText("This field is required");
//                        valid = false;
//                    
//                }
//
//                //System.out.println(user.);
//                //dao.retrieValues();
//                JOptionPane.showMessageDialog(null, "You have successfully logged in");
//                setVisibleFrame(false);
//                JOptionPane.showMessageDialog(null, "Danko");
//                RunLibrarySystem.HomeGui();
//
//            }
//
//        });
