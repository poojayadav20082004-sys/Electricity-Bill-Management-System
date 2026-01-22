import java.util.List;

public interface ElectricityBillDAO {
	
   // add bill into database
    void addBill(ElectricityBillDTO bill);
    
   //search bill by meterNo
    ElectricityBillDTO getBillByMeter(String meterNo);
    
   //view all bill
    List<ElectricityBillDTO> getAllBills();
    
   //update bill data
    void updateBill(ElectricityBillDTO bill);
    
    //delete bill by meterNo
    void deleteBill(String meterNo);
}
