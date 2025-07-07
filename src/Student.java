import java.sql.*;

public class Student {

    public void createDatabase() {

    }

    public void createTable() {

    }

    public void createData() {
        try {
            String url = "jdbc:mysql://localhost:3306/testdb"; // DB name
            String user = "root";                              //  MySQL username
            String password = "Aditya@123";                    //  password

            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println(" Connected to MySQL!");

            // Prepare insert statement
            String query = "INSERT INTO student (sid, name) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, 13);            //
            ps.setString(2, "Aditya");

            int rows = ps.executeUpdate();
            System.out.println("✅ Insert successful. Rows affected: " + rows);

            // Show current time
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NOW()");
            while (rs.next()) {
                System.out.println("🕒 Current Time: " + rs.getString(1));
            }

            // Close connections
            rs.close();
            ps.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
