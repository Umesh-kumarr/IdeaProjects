package GymManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class GymDBConnection {
        static Connection conn;

    GymDBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Gym", "root", "Umesh@1906");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("defedsf");
    }

}
