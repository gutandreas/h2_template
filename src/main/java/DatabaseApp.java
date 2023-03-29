import java.sql.*;

public class DatabaseApp {

    public static void main(String[] args) {
        try {
            Class.forName("org.h2.Driver");
            Connection connection = DriverManager.getConnection("jdbc:h2:~/ma_database", "test", "test");
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS kunden");
            statement.execute("CREATE TABLE IF NOT EXISTS kunden (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, vorname VARCHAR(30), nachname VARCHAR(30))" );
            statement.execute("INSERT INTO kunden (vorname, nachname) VALUES ('Peter', 'Müller')");
            statement.execute("INSERT INTO kunden (vorname, nachname) VALUES ('Karl', 'Meier')");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM kunden");

            while (resultSet.next()){
                System.out.println(resultSet.getString("vorname") + ", " + resultSet.getString("nachname"));
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
