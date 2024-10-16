package za.ac.cput.librarysystem.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author lamot
 */
public class HomeBeforeLogin extends JFrame implements ActionListener {
 
    private final JButton cmbCombo0, cmbCombo1, cmbCombo2, cmbCombo3, cmbCombo4, cmbCombo5, cmbCombo6, cmbCombo7, cmbCombo8, cmbCombo9, cmbCombo10, cmbCombo11, cmbCombo12, cmbCombo13, cmbCombo14;
    private final JLabel titleLbl1, titleLbl2, titleLbl3, lblImage0, lblImage1, lblImage2, lblImage3, lblImage4, lblImage5, lblImage6, lblImage7, lblImage8, lblImage9, lblImage10, lblImage11, lblImage12, lblImage13, lblImage14;
    private JLabel libraryName, homeLink, profileLink, categoriesLink, resourcesLink, logoutLink, fictionLink, nonFictionLink, literatureLink, artsLink, helpLink;
    private final ImageIcon  bookImage0, bookImage1, bookImage2, bookImage3, bookImage4, bookImage5, bookImage6, bookImage7, bookImage8, bookImage9, bookImage10, bookImage11, bookImage12, bookImage13, bookImage14;  
    private final JPanel panelNorth, hamburger, panelCenter; 
    private JPanel searchPanel, LoginAndSignPanel;
    private final JTextField searchInput;
    private final JButton searchButton, openBtn;
    
    public HomeBeforeLogin(){
        
        panelNorth = new JPanel();
        hamburger = new JPanel();
        panelCenter = new JPanel();

        searchInput = new JTextField(20);
        searchButton = new JButton("Search");
        openBtn = new JButton("☰");
        
        titleLbl1 = new JLabel("THRILLER");
        titleLbl2 = new JLabel("ROMANCE");
        titleLbl3 = new JLabel("HORROR");
        
        bookImage0 = new ImageIcon("C:\\Users\\School\\Music\\Book covers\\book1.jpg");
        lblImage0 = new JLabel(new ImageIcon(bookImage0.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH)));
        cmbCombo0 = new JButton("Preview");
        
        bookImage1 = new ImageIcon("C:\\Users\\School\\Music\\Book covers\\book2.jpg");
        lblImage1 = new JLabel(new ImageIcon(bookImage1.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH)));
        cmbCombo1 = new JButton("Preview");
        
        bookImage2 = new ImageIcon("C:\\Users\\School\\Music\\Book covers\\book3.jpg");
        lblImage2 = new JLabel(new ImageIcon(bookImage2.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH)));
        cmbCombo2 = new JButton("Preview");
        
        bookImage3 = new ImageIcon("C:\\Users\\School\\Music\\Book covers\\book4.jpg");
        lblImage3 = new JLabel(new ImageIcon(bookImage3.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH)));
        cmbCombo3 = new JButton("Preview");
        
        bookImage4 = new ImageIcon("C:\\Users\\School\\Music\\Book covers\\book5.jpg");
        lblImage4 = new JLabel(new ImageIcon(bookImage4.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH)));
        cmbCombo4 = new JButton("Preview");
        
        bookImage5 = new ImageIcon("C:\\Users\\School\\Music\\Book covers\\book6.jpg");
        lblImage5 = new JLabel(new ImageIcon(bookImage5.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH)));
        cmbCombo5 = new JButton("Preview");
        
        bookImage6 = new ImageIcon("C:\\Users\\School\\Music\\Book covers\\book7.jpg");
        lblImage6 = new JLabel(new ImageIcon(bookImage6.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH)));
        cmbCombo6 = new JButton("Preview");
        
        bookImage7 = new ImageIcon("C:\\Users\\School\\Music\\Book covers\\book8.jpg");
        lblImage7 = new JLabel(new ImageIcon(bookImage7.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH)));
        cmbCombo7 = new JButton("Preview");
        
        bookImage8 = new ImageIcon("C:\\Users\\School\\Music\\Book covers\\book9.jpg");
        lblImage8 = new JLabel(new ImageIcon(bookImage8.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH)));
        cmbCombo8 = new JButton("Preview");
        
        bookImage9 = new ImageIcon("C:\\Users\\School\\Music\\Book covers\\book10.jpg");
        lblImage9 = new JLabel(new ImageIcon(bookImage9.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH)));
        cmbCombo9 = new JButton("Preview");
        
        bookImage10 = new ImageIcon("C:\\Users\\School\\Music\\Book covers\\book11.jpg");
        lblImage10 = new JLabel(new ImageIcon(bookImage10.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH)));
        cmbCombo10 = new JButton("Preview");
        
        bookImage11 = new ImageIcon("C:\\Users\\School\\Music\\Book covers\\book12.jpg");
        lblImage11 = new JLabel(new ImageIcon(bookImage11.getImage().getScaledInstance(100, 200, Image.SCALE_SMOOTH)));
        cmbCombo11 = new JButton("Preview");
        
        bookImage12 = new ImageIcon("C:\\Users\\School\\Music\\Book covers\\book13.jpg");
        lblImage12 = new JLabel(new ImageIcon(bookImage12.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH)));
        cmbCombo12 = new JButton("Preview");
        
        bookImage13 = new ImageIcon("C:\\Users\\School\\Music\\Book covers\\book14.jpg");
        lblImage13 = new JLabel(new ImageIcon(bookImage13.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH)));
        cmbCombo13 = new JButton("Preview");
        
        bookImage14 = new ImageIcon("C:\\Users\\School\\Music\\Book covers\\book15.jpg");
        lblImage14 = new JLabel(new ImageIcon(bookImage14.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH)));
        cmbCombo14 = new JButton("Preview");
        
    }
    
    public void setGui() {
        setLayout(new BorderLayout());
        
        panelNorth.setLayout(new BorderLayout());
        panelNorth.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panelNorth.setBackground(Color.WHITE);
        
 
        ImageIcon headerImageIcon = new ImageIcon("C:\\Users\\School\\Music\\Book covers\\logo.png");
        Image image = headerImageIcon.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH);
        JLabel headerImageLabel = new JLabel(new ImageIcon(image));


        searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        searchInput.setPreferredSize(new Dimension(200, 30));
        searchPanel.add(searchInput);
        searchPanel.add(searchButton);
        panelNorth.add(searchPanel, BorderLayout.CENTER);

        openBtn.setPreferredSize(new Dimension(60, 55));
        panelNorth.add(openBtn, BorderLayout.EAST);
              
        hamburger.setLayout(new BoxLayout(hamburger, BoxLayout.Y_AXIS));
        hamburger.setBackground(Color.LIGHT_GRAY);
        hamburger.setPreferredSize(new Dimension(250, getHeight()));
        hamburger.setVisible(false);
        
        
        libraryName = new JLabel("<html><span style='font-size: 24px; font-weight: bold;'>VAASEL</span></html>");

        homeLink = new JLabel("<html><span style='font-size: 20px; font-weight: bold; text-decoration: underline;'>BACK TO HOME</span></html>");
        profileLink = new JLabel("<html><span style='font-size: 20px; font-weight: bold; text-decoration: underline;'>PROFILE</span></html>");
        categoriesLink = new JLabel("<html><span style='font-size: 20px; font-weight: bold; text-decoration: underline;'>CATEGORIES</span></html>");
        resourcesLink = new JLabel("<html><span style='font-size: 20px; font-weight: bold; text-decoration: underline;'>RESOURCES</span></html>");
        logoutLink = new JLabel("<html><span style='font-size: 20px; font-weight: bold; text-decoration: underline;'>LOGOUT</span></html>");

        fictionLink = new JLabel("<html><span style='font-size: 16px;'>Fiction</span></html>");
        nonFictionLink = new JLabel("<html><span style='font-size: 16px;'>Non-Fiction</span></html>");
        literatureLink = new JLabel("<html><span style='font-size: 16px;'>Literature</span></html>");
        artsLink = new JLabel("<html><span style='font-size: 16px;'>Arts and Entertainment</span></html>");
        helpLink = new JLabel("<html><span style='font-size: 16px;'>Help and Support</span></html>");

        hamburger.add(Box.createRigidArea(new Dimension(0, 10)));
        hamburger.add(libraryName);
        hamburger.add(Box.createRigidArea(new Dimension(0, 20)));
        hamburger.add(homeLink);
        hamburger.add(Box.createRigidArea(new Dimension(0, 10)));
        hamburger.add(profileLink);
        hamburger.add(Box.createRigidArea(new Dimension(0, 10)));
        hamburger.add(categoriesLink);
        hamburger.add(fictionLink);
        hamburger.add(nonFictionLink);
        hamburger.add(literatureLink);
        hamburger.add(artsLink);
        hamburger.add(Box.createRigidArea(new Dimension(0, 10)));
        hamburger.add(resourcesLink);
        hamburger.add(helpLink);
        hamburger.add(Box.createRigidArea(new Dimension(0, 10)));
        hamburger.add(logoutLink);

   
        titleLbl1.setFont(new Font("Arial", Font.BOLD, 16));
        titleLbl2.setFont(new Font("Arial", Font.BOLD, 16));
        titleLbl3.setFont(new Font("Arial", Font.BOLD, 16));
        
        
        panelCenter.setLayout(new GridLayout(3, 6, 10, 10));
        
        panelNorth.add(headerImageLabel, BorderLayout.WEST);
        
        panelCenter.add(titleLbl1);
        panelCenter.add(createImagePanel(lblImage0, cmbCombo0));
        panelCenter.add(createImagePanel(lblImage1, cmbCombo1));
        panelCenter.add(createImagePanel(lblImage2, cmbCombo2));
        panelCenter.add(createImagePanel(lblImage3, cmbCombo3));
        panelCenter.add(createImagePanel(lblImage4, cmbCombo4));

        panelCenter.add(titleLbl2);
        panelCenter.add(createImagePanel(lblImage5, cmbCombo5));
        panelCenter.add(createImagePanel(lblImage6, cmbCombo6));
        panelCenter.add(createImagePanel(lblImage7, cmbCombo7));
        panelCenter.add(createImagePanel(lblImage8, cmbCombo8));
        panelCenter.add(createImagePanel(lblImage9, cmbCombo9));

        panelCenter.add(titleLbl3);  
        panelCenter.add(createImagePanel(lblImage10, cmbCombo10));
        panelCenter.add(createImagePanel(lblImage11, cmbCombo11));
        panelCenter.add(createImagePanel(lblImage12, cmbCombo12));
        panelCenter.add(createImagePanel(lblImage13, cmbCombo13));
        panelCenter.add(createImagePanel(lblImage14, cmbCombo14));
        
        add(hamburger, BorderLayout.EAST);
        add(panelCenter, BorderLayout.CENTER);
        add(panelNorth, BorderLayout.NORTH);
        
        searchButton.addActionListener(this);
        openBtn.addActionListener(this);
        
        cmbCombo0.addActionListener(this);
        cmbCombo1.addActionListener(this);
        cmbCombo2.addActionListener(this);
        cmbCombo3.addActionListener(this);
        cmbCombo4.addActionListener(this);
        cmbCombo5.addActionListener(this);
        cmbCombo6.addActionListener(this);
        cmbCombo7.addActionListener(this);
        cmbCombo8.addActionListener(this);
        cmbCombo9.addActionListener(this);
        cmbCombo10.addActionListener(this);
        cmbCombo11.addActionListener(this);
        cmbCombo12.addActionListener(this);
        cmbCombo13.addActionListener(this);
        cmbCombo14.addActionListener(this);
           
    }

    private JPanel createImagePanel(JLabel lblImage, JButton comboBox) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(lblImage, BorderLayout.CENTER);
        panel.add(comboBox, BorderLayout.SOUTH);
        return panel;
    }
    
    private void toggleHamburger() {
        hamburger.setVisible(!hamburger.isVisible());
    }
    
    @Override
     public void actionPerformed(ActionEvent e) {
     
         
          
        if (e.getSource() == openBtn) {
            toggleHamburger();   
        } 
        else if (e.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) e.getSource();
            if (clickedButton.getText().equals("Preview")) {
            setVisibleFrame(false);
            RunLibrarySystem.bookGui();
            
            }
        }
        
    }

    private void setVisibleFrame(boolean X) {
        this.setVisible(X);
    }
}

