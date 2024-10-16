package za.ac.cput.librarysystem.gui;

import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author lamot
 */
public class RunLibrarySystem {

    public static Login gui;
    public static SignUp guiObj;
    public static HomeBeforeLogin hm;
    public static Book book;
    public static BorrowBook bb;
    public static Reservation g;
    public static BorrowBook AvelaBorrowBookClass;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        loginGui();
    }

    public static Login loginGui() {

        gui = new Login();
        gui.pack();
        gui.setVisible(true);
        gui.setSize(500, 350);
        gui.setResizable(false);
        gui.setLocationRelativeTo(null);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gui.setLoginGui();
        return gui;
  }

    public static SignUp signupGui() {

        guiObj = new SignUp();
        guiObj.pack();
        guiObj.setSize(1200, 800);
        guiObj.setVisible(true);
        guiObj.setDefaultCloseOperation(EXIT_ON_CLOSE);
        guiObj.setSignUp();
        return guiObj;
    }

    public static Book bookGui() {
        book = new Book();
        book.pack();
        book.setVisible(true);
        book.setSize(1200, 800);
        book.setDefaultCloseOperation(EXIT_ON_CLOSE);
        book.setGui();
        return book;
    }

//    public static BorrowBook borrowbookGui(){
//    
//    }
    public static Reservation reserveGui() {

        g = new Reservation();
        g.setTitle("");
        g.setGui();
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.setVisible(true);
        g.setSize(1200, 800);
        return g;
    }

    public static HomeBeforeLogin HomeGui() {

        hm = new HomeBeforeLogin();
        hm.setTitle("Welcome Page");
        hm.setSize(1200, 800);
        hm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hm.setLocationRelativeTo(null);
        hm.setGui();
        hm.setVisible(true);
        return hm;
    }

    public static BorrowBook borrow() {
        AvelaBorrowBookClass = new BorrowBook();
        AvelaBorrowBookClass.setTitle("");
       // AvelaBorrowBookClass.setGui();
        AvelaBorrowBookClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AvelaBorrowBookClass.setVisible(true);
        AvelaBorrowBookClass.setSize(1200, 800);

        return AvelaBorrowBookClass;
    }
}

////        homePage before login JFrame gui
//          HomeBeforeLogin gui = new HomeBeforeLogin();  
//            gui.setTitle("Welcome Page");
//            gui.setSize(1200, 800);
//            gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            gui.setLocationRelativeTo(null);
//            gui.setGui();
//            gui.setVisible(true);
//          HomePage after login JFrame Gui
//            HomeAfterLogin gui = new HomeAfterLogin();
//            gui.setTitle("Home Page");
//            gui.setSize(1200, 800);
//            gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            gui.setLocationRelativeTo(null);
//            gui.setVisible(true);
//            gui.setGui();
//          SingUpPage before you login in our HomePage before login            
//       public static SignUp setGui{}
//        guiObj = new SignUp();
//       
//        guiObj.pack();
//        guiObj.setSize(800, 400);
//        guiObj.setVisible(true);
//        guiObj.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        guiObj.setSignUp();
//        return guiObj;
//
////        Login page Object
//        Login gui = new Login();
//        gui.pack();
//        gui.setVisible(true);
//        gui.setSize(500, 350);
//        gui.setResizable(false);
//        gui.setLocationRelativeTo(null);
//        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        gui.setLoginGui();
//  The book running Object
//        Book gui = new Book();
//
//        gui.pack();
//        gui.setVisible(true);
//        gui.setSize(900, 600);
//        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        gui.setGui();
//         Reservation g = new Reservation();
////
//        g.setTitle("");
//        g.setGui();
//        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        g.setVisible(true);
//        g.setSize(500, 400);
