package za.ac.cput.librarysystem.gui;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author lamot
 */
public class BorrowBook extends JFrame {

    // Step 1 - component declarations
    private JPanel pnlCenter, pnlCenterLeft, pnlCenterRight;
    private JLabel lblName, lblBooksInStockText, lblBooksInStockValue, lblIssueDate, lblReturnDate, lblBookCover, lblProfilePic;
    private JTextField txtIssueDate, txtReturnDate;
    private JButton btnBorrow, btnReservation;
    private JPanel panelNorth, hamburger;
    private JPanel header;
    private JTextField searchInput;
    private JButton searchButton, openBtn, closeBtn, homeLink, aboutUsLink;
    private ImageIcon bookImage1;

    public BorrowBook() {
        // Set custom icon for the JFrame
        panelNorth = new JPanel();
        hamburger = new JPanel();
        header = new JPanel();

        searchInput = new JTextField(20);
        searchButton = new JButton("Search");
        openBtn = new JButton("☰");
        closeBtn = new JButton("X");
        homeLink = new JButton("Home");
        aboutUsLink = new JButton("About Us");

        String iconPath = "C:\\Users\\LIPHE\\Documents\\NetBeansProjects\\BorrowBookGui\\Vassel.jpeg";
        ImageIcon icon = createImageIcon(iconPath);

        if (icon != null) {
            setIconImage(icon.getImage());
        } else {
            System.err.println("Icon image not found or cannot be loaded.");
        }

        // Step 3 initialize panels
        pnlCenter = new JPanel(new GridLayout(1, 2, 10, 0)); // Center panel with GridLayout and horizontal gap
        pnlCenterLeft = new JPanel();
        pnlCenterRight = new JPanel(new FlowLayout());

        // Initialize labels
        lblName = new JLabel("Ahluma Nkqayi");
        lblBooksInStockText = new JLabel("<html><u>No. of Books available in stock:</u></html>");
        lblBooksInStockValue = new JLabel("7/10"); // This will be dynamically updated
        lblIssueDate = new JLabel("Issue Date:");
        lblReturnDate = new JLabel("Return Date:");

        bookImage1 = new ImageIcon("C:\\Users\\LIPHE\\Documents\\NetBeansProjects\\BorrowBookGui\\Book.jpg");
        lblBookCover = new JLabel(new ImageIcon(bookImage1.getImage().getScaledInstance(200, 400, Image.SCALE_SMOOTH)));

        // Initialize text fields
        txtIssueDate = new JTextField(8);
        txtReturnDate = new JTextField(8);

        // Set default dates in the text fields
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        txtIssueDate.setText(sdf.format(new Date()));
        txtReturnDate.setText(sdf.format(new Date()));

        // Initialize buttons
        btnBorrow = new JButton("Confirm Borrow");
        btnReservation = new JButton("Reservation");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(true);

        setBorrowBook();

        // Add pnlCenter to the JFrame
        add(pnlCenter, BorderLayout.CENTER);

        setVisible(true);
    }

    private ImageIcon createImageIcon(String path) {
        return new ImageIcon(path);
    }

    public void setBorrowBook() {
        setLayout(new BorderLayout());

        panelNorth.setBackground(Color.WHITE);
        panelNorth.setLayout(new BorderLayout());

        header.setLayout(new BorderLayout());
        header.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        header.setBackground(Color.WHITE);

        // Add picture to the left of the header
        ImageIcon headerImageIcon = new ImageIcon("C:\\Users\\LIPHE\\Documents\\NetBeansProjects\\BorrowBookGui\\Vassel.jpeg");
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

        // Set layout for panels
        pnlCenter.setLayout(new GridLayout(1, 2, 10, 0)); // Center panel with GridLayout and horizontal gap
        pnlCenterLeft.setLayout(new BoxLayout(pnlCenterLeft, BoxLayout.Y_AXIS)); // Left center panel with BoxLayout for vertical arrangement
        pnlCenterRight.setLayout(new BorderLayout()); // Right center panel with BorderLayout

        // Set background colors
        Color lightGrey = new Color(211, 211, 211); // Light grey color
        pnlCenter.setBackground(lightGrey);
        pnlCenterLeft.setBackground(lightGrey);
        pnlCenterRight.setBackground(lightGrey);

        // Add a dark grey border to the right of pnlCenterLeft
        pnlCenterLeft.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.DARK_GRAY));

        // Increase font size for lblName
        Font originalFont = lblName.getFont();
        lblName.setFont(new Font(originalFont.getName(), originalFont.getStyle(), originalFont.getSize() * 3 / 2));
        lblName.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create profile panel with vertical BoxLayout
        JPanel profilePanel = new JPanel();
        profilePanel.setLayout(new BoxLayout(profilePanel, BoxLayout.Y_AXIS));
        profilePanel.setBackground(lightGrey);

        // Profile picture
        ImageIcon profileImageIcon = new ImageIcon("C:\\Users\\LIPHE\\Documents\\NetBeansProjects\\BorrowBookGui\\Icon.jpg");
        JLabel lblProfilePic = new JLabel(new ImageIcon(profileImageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        lblProfilePic.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add components to the profile panel
        profilePanel.add(lblProfilePic);
        profilePanel.add(lblName);

        // Add profile panel to the left center panel
        pnlCenterLeft.add(profilePanel);
        pnlCenterLeft.add(Box.createVerticalStrut(20)); // Add some space between profile panel and other components

        // Create a panel for books in stock
        JPanel booksInStockPanel = new JPanel();
        booksInStockPanel.setLayout(new BoxLayout(booksInStockPanel, BoxLayout.X_AXIS));
        booksInStockPanel.setBackground(lightGrey);

        // Set text for lblBooksInStockText with HTML underline
        lblBooksInStockText.setText("<html><u>No. of Books available in stock:</u></html>");
        lblBooksInStockText.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblBooksInStockValue.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblBooksInStockValue.setPreferredSize(new Dimension(50, lblBooksInStockValue.getPreferredSize().height)); // Adjust size for visibility

        // Add lblBooksInStockText and lblBooksInStockValue to the panel with minimal space
        booksInStockPanel.add(lblBooksInStockText);
        booksInStockPanel.add(Box.createHorizontalStrut(5)); // Minimal space
        booksInStockPanel.add(lblBooksInStockValue);

        // Add booksInStockPanel to the left center panel
        pnlCenterLeft.add(booksInStockPanel);
        pnlCenterLeft.add(Box.createVerticalStrut(20)); // Add some space between booksInStockPanel and other components

        // Create a panel for issue date
        JPanel issueDatePanel = new JPanel();
        issueDatePanel.setLayout(new BoxLayout(issueDatePanel, BoxLayout.X_AXIS));
        issueDatePanel.setBackground(lightGrey);
        lblIssueDate.setAlignmentX(Component.LEFT_ALIGNMENT);
        txtIssueDate.setAlignmentX(Component.LEFT_ALIGNMENT);
        txtIssueDate.setPreferredSize(new Dimension(120, btnBorrow.getPreferredSize().height)); // Match button height
        issueDatePanel.add(lblIssueDate);
        issueDatePanel.add(Box.createHorizontalStrut(5)); // Add space between the label and text field
        issueDatePanel.add(txtIssueDate);

        // Add components to the left center panel
        pnlCenterLeft.add(issueDatePanel);
        pnlCenterLeft.add(Box.createVerticalStrut(20)); // Add space between components

        // Create a panel for return date
        JPanel returnDatePanel = new JPanel();
        returnDatePanel.setLayout(new BoxLayout(returnDatePanel, BoxLayout.X_AXIS));
        returnDatePanel.setBackground(lightGrey);
        lblReturnDate.setAlignmentX(Component.LEFT_ALIGNMENT);
        txtReturnDate.setAlignmentX(Component.LEFT_ALIGNMENT);
        txtReturnDate.setPreferredSize(new Dimension(120, btnBorrow.getPreferredSize().height)); // Match button height
        returnDatePanel.add(lblReturnDate);
        returnDatePanel.add(Box.createHorizontalStrut(5)); // Add space between the label and text field
        returnDatePanel.add(txtReturnDate);

        // Add components to the left center panel
        pnlCenterLeft.add(returnDatePanel);
        pnlCenterLeft.add(Box.createVerticalStrut(20)); // Add space between components

        // Add book cover to the right center panel
        pnlCenterRight.add(lblBookCover, BorderLayout.CENTER);

        JPanel pnlButtons = new JPanel(); // Panel to hold buttons
        pnlButtons.setLayout(new FlowLayout());
        pnlButtons.setBackground(lightGrey);
        pnlButtons.add(btnBorrow);
        pnlButtons.add(btnReservation);

        pnlCenterRight.add(pnlButtons, BorderLayout.SOUTH);

        // Add sub-panels to the center panel
        pnlCenter.add(pnlCenterLeft);
        pnlCenter.add(pnlCenterRight);

        add(pnlCenter, BorderLayout.CENTER); // Add pnlCenter to the JFrame

        // Add ActionListener to btnBorrow
        btnBorrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show the JOptionPane when the button is clicked
                JOptionPane.showMessageDialog(null, "Book Borrowed Successfully !!!");
            }
        });

        btnReservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisibleFrame(false);
                RunLibrarySystem.reserveGui();

            }
        });

    }

    private void toggleHamburger() {
        hamburger.setVisible(!hamburger.isVisible());
    }

    private void setVisibleFrame(boolean b) {

        this.setVisible(b);
    }
}
