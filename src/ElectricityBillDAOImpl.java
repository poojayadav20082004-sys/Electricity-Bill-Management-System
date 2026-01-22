import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ElectricityBillDAOImpl implements ElectricityBillDAO {

	//INSERT DATA
    @Override
    public void addBill(ElectricityBillDTO bill) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO bills (consumer_name, meter_no, units, amount) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            //Assigns values from DTO object to SQL query placeholders
            ps.setString(1, bill.getConsumerName());
            ps.setString(2, bill.getMeterNo());
            ps.setInt(3, bill.getUnits());
            ps.setDouble(4, bill.getAmount());

            //executes an SQL query that changes data in the database,execute the INSERT query and store in database(insert,update,delete)
            ps.executeUpdate();

            //Handles any database or runtime exceptions
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //search bY meter_no
    @Override
    public ElectricityBillDTO getBillByMeter(String meterNo) {
        ElectricityBillDTO bill = null;

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM bills WHERE meter_no=?";
            PreparedStatement ps = con.prepareStatement(sql);
            //set the searching value
            ps.setString(1, meterNo);

            //Executes SELECT query and Stores result in ResultSet
            ResultSet rs = ps.executeQuery();

            //check if record exists,if exist Reads database values and Stores them in a DTO object
            if (rs.next()) {
                bill = new ElectricityBillDTO(
                        rs.getInt("bill_id"),
                        rs.getString("consumer_name"),
                        rs.getString("meter_no"),
                        rs.getInt("units"),
                        rs.getDouble("amount")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bill;
    }

    //view all data
    @Override
    public List<ElectricityBillDTO> getAllBills() {
        List<ElectricityBillDTO> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            //prepares Java to send an SQL query to the database.
            Statement st = con.createStatement();
            //executes a SELECT SQL query and The result is stored in a ResultSet object
            ResultSet rs = st.executeQuery("SELECT * FROM bills");

            //Loops through each row of the table
            while (rs.next()) {
            	//Converts each database row into DTO and Adds it to the list
                list.add(new ElectricityBillDTO(
                        rs.getInt("bill_id"),
                        rs.getString("consumer_name"),
                        rs.getString("meter_no"),
                        rs.getInt("units"),
                        rs.getDouble("amount")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Returns list of all bills
        return list;
    }

    //UPDATE BY metr_no
    @Override
    public void updateBill(ElectricityBillDTO bill) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE bills SET units=?, amount=? WHERE meter_no=?";
            PreparedStatement ps = con.prepareStatement(sql);
            //Sets updated values
            ps.setInt(1, bill.getUnits());
            ps.setDouble(2, bill.getAmount());
            ps.setString(3, bill.getMeterNo());
            //Executes UPDATE operation
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deleteBill(String meterNo) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM bills WHERE meter_no=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, meterNo);
            //Executes DELETE operation
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
