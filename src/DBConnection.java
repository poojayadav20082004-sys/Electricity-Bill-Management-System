import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {
        	//Load driver(path of driver class inside mysql connector)
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Create connection
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/electricity_db",
                "root",
                "root123"
            );

            System.out.println("Database Connected Successfully");

        } catch (Exception e) {
            System.out.println("Database Connection Failed");
            e.printStackTrace();
        }

        return con;
    }
}
