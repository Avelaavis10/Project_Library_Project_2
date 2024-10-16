package za.ac.cput.librarysystem.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

public class Book extends JFrame implements ActionListener {

    private JPanel header;
    private JPanel panelWest, panelCenter, panelNorth, hamburger, panelSouth, searchPanel;
    private JLabel lblTitle, lblAuthor, lblRating, lblDescription1, lblDescription2, lblGenre, lblDate, lblImage;
    private JButton btnBorrow, searchButton, openBtn, closeBtn, homeLink, aboutUsLink;
    private ImageIcon bookImage;
    private JTextField searchInput;

    public Book() {
        super("Library System");

        panelNorth = new JPanel();
        panelWest = new JPanel();
        panelCenter = new JPanel();
        hamburger = new JPanel();

        searchInput = new JTextField(20);
        searchButton = new JButton("Search");
        openBtn = new JButton("☰");
        closeBtn = new JButton("X");
        homeLink = new JButton("Home");
        aboutUsLink = new JButton("About Us");

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        lblTitle = new JLabel("<html>TROUBLED DAUGHTERS, TWISTED WIVES: STORIES FROM THE TRAILBLAZERS OF DOMESTIC SUSPENSE</html>");
        lblTitle.setBorder(border);
        lblAuthor = new JLabel("BY SARHA WEINMAN");
        //lblAuthor.setBorder(border);
        lblAuthor.setBackground(Color.RED);
        lblRating = new JLabel("★★★★☆ 3.38  732 ratings. 132 reviews");
        //lblRating.setBorder(border);
        lblDescription1 = new JLabel("<html>Fourteen chilling tales from the pioneering women who created the domestic suspense genre</html>");
        //lblDescription1.setBorder(border);
        lblDescription2 = new JLabel("<html>Weinman compiles fourteen chilling stories from women who between the 1940s and the mid-1970s, took a scalpel to modern society and sliced away its dark core in Troubled Daughters, Twisted Wives. This wickedly dark homage to a largely forgotten generation of women writers will be appreciated by fans of thrillers from any era.</html>");
        lblDescription2.setBorder(border);
        lblGenre = new JLabel("Genres: Short Stories, Mystery, Fiction, Crime, Suspense, Thriller, Horror, Mystery Thriller.");
        lblGenre.setBorder(border);
        lblDate = new JLabel("published August 27, 2013");
        lblDate.setBorder(border);

        bookImage = new ImageIcon("C:\\Users\\alung\\OneDrive\\Documents\\book covers\\pic.jpeg");
        lblImage = new JLabel(bookImage);

        btnBorrow = new JButton("Borrow");
    }

    public void setGui() {

        setLayout(new BorderLayout());

        panelNorth.setLayout(new BorderLayout());
        panelNorth.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panelNorth.setBackground(Color.WHITE);

        ImageIcon headerImageIcon = new ImageIcon("C:\\Users\\alung\\OneDrive\\Documents\\book covers\\logo.jpg");
        Image image = headerImageIcon.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH);

        JLabel headerImageLabel = new JLabel(new ImageIcon(image));

        panelNorth.add(headerImageLabel, BorderLayout.WEST);

        searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        searchInput.setPreferredSize(new Dimension(200, 30));
        searchButton.addActionListener(e -> {
        });
        searchPanel.add(searchInput);
        searchPanel.add(searchButton);
        panelNorth.add(searchPanel, BorderLayout.CENTER);

        openBtn.setPreferredSize(new Dimension(60, 55));
        openBtn.addActionListener(e -> toggleHamburger());
        panelNorth.add(openBtn, BorderLayout.EAST);

        hamburger.setLayout(new BoxLayout(hamburger, BoxLayout.Y_AXIS));
        hamburger.setBackground(Color.LIGHT_GRAY);
        hamburger.setPreferredSize(new Dimension(250, getHeight()));
        hamburger.setVisible(false);

        add(hamburger, BorderLayout.EAST);
        add(panelNorth, BorderLayout.NORTH);

        panelWest.setLayout(new GridLayout(2, 1));
        panelCenter.setLayout(new GridLayout(8, 1));

        panelWest.add(lblImage);
        panelWest.add(btnBorrow);
        btnBorrow.setPreferredSize(new Dimension(100, 30));
        btnBorrow.addActionListener(this);

        panelWest.setLayout(new BorderLayout());
        panelWest.setPreferredSize(new Dimension(250, 0));
        panelWest.add(lblImage, BorderLayout.CENTER);
        panelWest.add(btnBorrow, BorderLayout.SOUTH);

        panelCenter.add(lblTitle);
        panelCenter.add(lblAuthor);
        panelCenter.add(lblRating);
        panelCenter.add(lblDescription1);
        panelCenter.add(lblDescription2);
        panelCenter.add(lblGenre);
        panelCenter.add(lblDate);

        add(panelWest, BorderLayout.WEST);
        add(panelCenter, BorderLayout.CENTER);
        panelCenter.setBackground(Color.LIGHT_GRAY);
        panelWest.setBackground(Color.LIGHT_GRAY);
    }

    private void toggleHamburger() {
        hamburger.setVisible(!hamburger.isVisible());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == btnBorrow) {
            setVisibleFrame(false);
            RunLibrarySystem.borrow();

        
    }
}

    private void setVisibleFrame(boolean b) {
        this.setVisible(b);
    }
}