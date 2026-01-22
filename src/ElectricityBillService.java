import java.util.List;

public class ElectricityBillService {

    ElectricityBillDAO dao = new ElectricityBillDAOImpl();

    //Calculates electricity bill based on units consumed and Returns total amount
    public double calculateBill(int units) {
    	//If units are 100 or less then Charge ₹1.5 per unit
        if (units <= 100)
            return units * 1.5;
      
        else if (units <= 300)
            return 100 * 1.5 + (units - 100) * 2.5;
        else
            return 100 * 1.5 + 200 * 2.5 + (units - 300) * 4.0;
    }
//ADD bill by calling implementation class 
    public void addBill(ElectricityBillDTO bill) {
    	//Calculates bill amount, Sets the amount inside DTO object
        bill.setAmount(calculateBill(bill.getUnits()));
        //Calls DAO method to store data in database
        dao.addBill(bill);
    }
    
//SEARCH bill by meterNo
    public ElectricityBillDTO getBill(String meterNo) {
        return dao.getBillByMeter(meterNo);
    }
    
//VIEW ALL bill
    public List<ElectricityBillDTO> getAllBills() {
    	//DAO returns list of DTO objects, Service just forwards it
        return dao.getAllBills();
    }
    
//UPDATE bill by meterNo,units
    public void updateBill(String meterNo, int units) {
        //Recalculates bill amount
        double amount = calculateBill(units);
        //Creates a new DTO object
        ElectricityBillDTO bill =
            new ElectricityBillDTO(0, null, meterNo, units, amount);

        dao.updateBill(bill);   // ⭐ MATCHES DAO
    }

//DELETE bill
    public void deleteBill(String meterNo) {
        dao.deleteBill(meterNo);
    }
}
