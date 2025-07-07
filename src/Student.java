import java.sql.*;

public class Student {

    public void createDatabase() {
    }

    public void createTable() {
        try {
            String url = "jdbc:mysql://localhost:3306/testdb";
            String user = "root";
            String password = "Aditya@123";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement stmt = conn.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS student (sid INT PRIMARY KEY, name VARCHAR(50))";
            stmt.execute(query);

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createData() {
        try {
            String url = "jdbc:mysql://localhost:3306/testdb";
            String user = "root";
            String password = "Aditya@123";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "INSERT INTO student (sid, name) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, 13);
            ps.setString(2, "Aditya");

            ps.executeUpdate();

            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readData() {
        try {
            String url = "jdbc:mysql://localhost:3306/testdb";
            String user = "root";
            String password = "Aditya@123";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "SELECT * FROM student";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("SID: " + rs.getInt("sid") + ", Name: " + rs.getString("name"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateData(int sid, String newName) {
        try {
            String url = "jdbc:mysql://localhost:3306/testdb";
            String user = "root";
            String password = "Aditya@123";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "UPDATE student SET name = ? WHERE sid = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, newName);
            ps.setInt(2, sid);

            ps.executeUpdate();

            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteData(int sid) {
        try {
            String url = "jdbc:mysql://localhost:3306/testdb";
            String user = "root";
            String password = "Aditya@123";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "DELETE FROM student WHERE sid = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, sid);

            ps.executeUpdate();

            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
