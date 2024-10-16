package za.ac.cput.librarysystem.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import za.ac.cput.librarysystem.connection.Dbconnection;
import za.ac.cput.librarysystem.domain.User;

/**
 *
 * @author lamot
 */
public class UserDAO {

    private Dbconnection con = new Dbconnection();
    private Statement s;
    private PreparedStatement ps;
    private ResultSet rs;

    public void createTable() {

        String create_Table_stmt = "create table UserTable (Name VARCHAR(30),Surname VARCHAR(30), Gender VARCHAR(30), dateofbirth VARCHAR(30), address VARCHAR(30), phone VARCHAR(30), email VARCHAR(30),password VARCHAR(30))";

        try {
            System.out.println("About to create statement...");

            s = con.derbyConnection().createStatement();
            System.out.println("Statement Created Successfully...");
            s.executeUpdate(create_Table_stmt);
            JOptionPane.showMessageDialog(null, "Table created successfully...");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR!!!!!");
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertValues(User user) {

        String insertValuesStmt = "insert into UserTable values ('" + user.getName() + "','" + user.getSurname() + "','" + user.getGender() + "','" + user.getDateofbirth() + "','" + user.getAddress() + "','" + user.getPhone() + "','" + user.getEmail() + "','" + user.getPassword() + "')";

        try {
            s = con.derbyConnection().createStatement();
            s.executeUpdate(insertValuesStmt);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error!!!!!");
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<User> retrieValues() {
        String retrieveValueQry = "SELECT * FROM UserTable";
        int row = 0;

        ArrayList<User> userList = new ArrayList<>();

        try {
            s = con.derbyConnection().createStatement();
            rs = s.executeQuery(retrieveValueQry);

            if (rs != null) {
                while (rs.next()) {
                    row++;
                    User userObj = new User(rs.getString(7), rs.getString(8));
                    userList.add(userObj);
                    System.out.println("Data from row: " + row + ": " + rs.getString(7) + " " + rs.getString(8));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userList;

    }

}


