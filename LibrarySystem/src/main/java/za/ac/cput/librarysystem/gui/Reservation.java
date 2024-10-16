package za.ac.cput.librarysystem.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 *
 * @author lamot
 */
public class Reservation extends JFrame implements ActionListener {

    private JPanel pnlSouth, pnlCenter, pnlWest, pnlEast, panelNorth, hamburger;
    private JPanel header;
    private JButton btnCancel, btnSubmit, btnSearch, btnburger, searchButton, openBtn, closeBtn, homeLink, aboutUsLink;
    private JLabel lblName, lbluserID, lblIDNum, lblBookrs, lblbookName, lblstock, lblRes, lblDate;
    private JLabel lblVaasel;
    private JTextField txtDate, txtSearch, searchInput;

    public Reservation() {

        panelNorth = new JPanel();
        hamburger = new JPanel();

        header = new JPanel();

        searchInput = new JTextField(20);
        searchButton = new JButton("Search");
        openBtn = new JButton("☰");
        closeBtn = new JButton("X");
        homeLink = new JButton("Home");
        aboutUsLink = new JButton("About Us");

        //super("Reservation");
        //pnlNorth = new JPanel();
        pnlSouth = new JPanel();
        pnlCenter = new JPanel();
        pnlWest = new JPanel();
        pnlEast = new JPanel();

        btnCancel = new JButton("Cancel");
        btnSubmit = new JButton("Submit");

        lblName = new JLabel("Name");
        lbluserID = new JLabel("user ID:");
        lblIDNum = new JLabel("222454");
        lblBookrs = new JLabel("Book Reserved:");
        lblbookName = new JLabel("Troubled Daughters Twisted Wives");
        lblstock = new JLabel("in Stock Availability Date:");
        lblDate = new JLabel("20/25/23");
        lblRes = new JLabel("Reservation Date:");
        txtDate = new JTextField(20);

    }

    public void setGui() {

        setLayout(new BorderLayout());

        panelNorth.setBackground(Color.WHITE);
        panelNorth.setLayout(new BorderLayout());

        header.setLayout(new BorderLayout());
        header.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        header.setBackground(Color.WHITE);

        // Add picture to the left of the header
        ImageIcon headerImageIcon = new ImageIcon("C:\\Users\\lamot\\OneDrive\\Pictures\\Screenshots\\logo.jpg");
        Image image = headerImageIcon.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(image);
        JLabel headerImageLabel = new JLabel(resizedImageIcon);

        JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        imagePanel.add(headerImageLabel);
        header.add(imagePanel, BorderLayout.WEST);

        // Create panel to center search input and button
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        searchInput.setPreferredSize(new Dimension(200, 30));
        searchButton.setBackground(Color.LIGHT_GRAY);
        searchButton.setForeground(Color.BLACK);
        searchButton.setFocusPainted(false);
        searchButton.setBorder(BorderFactory.createEmptyBorder());
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add search functionality here
            }
        });

        searchPanel.add(searchInput);
        searchPanel.add(searchButton);

        header.add(searchPanel, BorderLayout.CENTER);

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

        pnlSouth.setLayout(new GridLayout(1, 2));
        pnlWest.setLayout(new GridLayout(9, 1));

        pnlWest.add(lblName);
        pnlWest.add(lbluserID);
        pnlWest.add(lblIDNum);
        pnlWest.add(lblBookrs);
        pnlWest.add(lblbookName);
        pnlWest.add(lblstock);
        pnlWest.add(lblDate);
        pnlWest.add(lblRes);
        pnlWest.add(txtDate);

        //txtDate.setPreferredSize(50,20);
        pnlSouth.add(btnCancel);
        pnlSouth.add(btnSubmit);
        pnlWest.setBackground(Color.LIGHT_GRAY);

        btnSubmit.addActionListener(this);
        btnCancel.addActionListener(this);

        this.add(pnlSouth, BorderLayout.SOUTH);
        this.add(pnlWest, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCancel) {
            JOptionPane.showMessageDialog(this, "Reservation Cancelled");
            System.exit(0);
        } else if (e.getSource() == btnSubmit) {
            JOptionPane.showMessageDialog(this, "Reservation Submitted");
            setVisibleFrame(false);
            RunLibrarySystem.HomeGui();
        }
    }

    private void toggleHamburger() {
        hamburger.setVisible(!hamburger.isVisible());
    }

    private void setVisibleFrame(boolean b) {
    
        this.setVisible(b);
    }

}
