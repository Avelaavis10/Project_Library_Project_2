package za.ac.cput.librarysystem.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import za.ac.cput.librarysystem.dao.UserDAO;
import za.ac.cput.librarysystem.domain.User;

/**
 *
 * @author lamot
 */

public class SignUp extends JFrame implements ActionListener {

    private JPanel panelCenter, panelNorth, hamburger;
    private JPanel header;
    private JLabel lblName, lblSurname, lblGender, lblDOB, lblAddress, lblPhone, lblEmail, lblPassword, lbl1, lblEmailError,lblPasswordError;
    private JTextField txtName, txtSurname, txtGender, txtDOB, txtAddress, txtPhone, txtEmail, txtPassword, searchInput;
    private JButton btnSign, openBtn, closeBtn, homeLink, aboutUsLink;
    private JComboBox comboGender;
    private UserDAO dao = new UserDAO();

    public SignUp() {
        panelCenter = new JPanel();
        panelNorth = new JPanel();

        panelNorth = new JPanel();
        hamburger = new JPanel();
        panelCenter = new JPanel();

        header = new JPanel();

        openBtn = new JButton("☰");
        closeBtn = new JButton("X");
        homeLink = new JButton("Home");
        aboutUsLink = new JButton("About Us");

        lblName = new JLabel("Name: ");
        lblSurname = new JLabel("Surname: ");
        lblGender = new JLabel("Gender:");
        lblDOB = new JLabel("Date of Birth: ");
        lblAddress = new JLabel("Address: ");
        lblPhone = new JLabel("Phone: ");
        lblEmail = new JLabel("Email:");
        lblPassword = new JLabel("Password: ");
        lbl1 = new JLabel("");
        lblEmailError = new JLabel("This field is required");
        lblPasswordError = new JLabel("This field is required");
        
        

        txtName = new JTextField(15);
        txtSurname = new JTextField(15);
        txtDOB = new JTextField(20);
        txtAddress = new JTextField(20);
        txtPhone = new JTextField(20);
        txtEmail = new JTextField(20);
        txtPassword = new JTextField(20);

        btnSign = new JButton("SIGNUP");
        btnSign.setBackground(Color.BLUE);
        btnSign.setForeground(Color.WHITE);

        comboGender = new JComboBox(new String[]{"Select", "Female", "Male"});

        panelCenter.setBackground(Color.LIGHT_GRAY);
        lblEmailError.setForeground(Color.red);
        lblPasswordError.setForeground(Color.red);

    }

    public void setSignUp() {
        panelCenter.setLayout(new GridLayout(21, 2));

        panelCenter.add(lblName);
        panelCenter.add(txtName);

        panelCenter.add(lblSurname);
        panelCenter.add(txtSurname);

        panelCenter.add(lblGender);
        panelCenter.add(comboGender);

        panelCenter.add(lblDOB);
        panelCenter.add(txtDOB);

        panelCenter.add(lblAddress);
        panelCenter.add(txtAddress);

        panelCenter.add(lblPhone);
        panelCenter.add(txtPhone);

        panelCenter.add(lblEmail);
        panelCenter.add(txtEmail);
        panelCenter.add(lblEmailError);

        panelCenter.add(lblPassword);
        panelCenter.add(txtPassword);
        panelCenter.add(lblPasswordError);
        panelCenter.add(lbl1);
        panelCenter.add(btnSign);

        setLayout(new BorderLayout());

        panelNorth.setBackground(Color.WHITE);
        panelNorth.setLayout(new BorderLayout());

        header.setLayout(new BorderLayout());
        header.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        header.setBackground(Color.WHITE);

        // Add picture to the left of the header
        ImageIcon headerImageIcon = new ImageIcon("C:\\Users\\User\\OneDrive\\Desktop\\logo.jpg");
        Image image = headerImageIcon.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(image);
        JLabel headerImageLabel = new JLabel(resizedImageIcon);

        JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        imagePanel.add(headerImageLabel);
        header.add(imagePanel, BorderLayout.WEST);

        openBtn.setBackground(Color.LIGHT_GRAY);
        openBtn.setForeground(Color.BLACK);
        openBtn.setFocusPainted(false);
        openBtn.setBorder(BorderFactory.createEmptyBorder());
        openBtn.setPreferredSize(new Dimension(60, 55));
        openBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleHamburger();
            }
        });

        panelNorth.add(header, BorderLayout.CENTER);
        panelNorth.add(openBtn, BorderLayout.EAST);

        hamburger.setLayout(new BoxLayout(hamburger, BoxLayout.Y_AXIS));
        hamburger.setBackground(Color.LIGHT_GRAY);
        hamburger.setPreferredSize(new Dimension(250, getHeight()));
        hamburger.setVisible(false);

        closeBtn.setBackground(Color.LIGHT_GRAY);
        closeBtn.setForeground(Color.BLACK);
        closeBtn.setFocusPainted(false);
        closeBtn.setBorder(BorderFactory.createEmptyBorder());
        closeBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hamburger.setVisible(false);
            }
        });

        homeLink.setAlignmentX(Component.CENTER_ALIGNMENT);
        aboutUsLink.setAlignmentX(Component.CENTER_ALIGNMENT);

        hamburger.add(closeBtn);
        hamburger.add(homeLink);
        hamburger.add(aboutUsLink);

        add(panelNorth, BorderLayout.NORTH);
        add(hamburger, BorderLayout.EAST);

        this.add(panelCenter, BorderLayout.CENTER);
        //this.add(btnSign, BorderLayout.SOUTH);

        btnSign.addActionListener(this);
    }

    private void toggleHamburger() {
        hamburger.setVisible(!hamburger.isVisible());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lblEmailError.setText("");
       lblPassword.setText("");
       
       String email = txtEmail.getText().trim();
                String password = txtPassword.getText().trim();
                
                boolean valid = true;
                
                 if (email.isEmpty()) {
                    lblEmailError.setText("This field is required");
                    valid = false;
                }
                if (password.isEmpty()) {
                    lblPasswordError.setText("This field is required");
                    valid = false;
                }
        if (e.getSource() == btnSign) {
            //dao.createTable();
            
            //txtName, txtSurname, txtGender, txtDOB, txtAddress, txtPhone, txtEmail, txtPassword, searchInput;
            User user = new User(txtName.getText(),txtSurname.getText(), comboGender.getSelectedItem().toString(),txtDOB.getText(),txtAddress.getText(),txtPhone.getText(),txtEmail.getText(),txtPassword.getText());
            
            dao.insertValues(user);
            
            JOptionPane.showMessageDialog(this, "Succesfully sign up");
            setVisibleFrame(false);
            RunLibrarySystem.loginGui();
        }
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
 
    private void setVisibleFrame(boolean x) {

        this.setVisible(x);
    }

    private void clearFields() {
        clearFields();
    }
}
