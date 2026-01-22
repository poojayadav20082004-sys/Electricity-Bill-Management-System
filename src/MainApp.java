import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ElectricityBillService service = new ElectricityBillService();

        while (true) {
            System.out.println("\n============================");
            System.out.println(" ELECTRICITY BILL SYSTEM ");
            System.out.println("============================");
            System.out.println("1. Add Bill");
            System.out.println("2. Search Bill");
            System.out.println("3. View All Bills");
            System.out.println("4. Update Bill");
            System.out.println("5. Delete Bill");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (ch) {
                //Add bill
                case 1:
                    System.out.print("Consumer Name: ");
                    String name = sc.nextLine();

                    System.out.print("Meter Number: ");
                    String meter = sc.nextLine();

                    System.out.print("Units: ");
                    int units = sc.nextInt();
                    sc.nextLine();
                    //send the data to dto class so object is created
                    ElectricityBillDTO bill =
                            new ElectricityBillDTO(0, name, meter, units, 0);

                    //Calls service to calculate and store bill
                    service.addBill(bill);
                    System.out.println("Bill Added Successfully");
                    break;
                    
                //Search bill
                case 2:
                    System.out.print("Enter Meter Number: ");
                    String searchMeter = sc.nextLine();

                    ElectricityBillDTO b = service.getBill(searchMeter);

                    if (b != null) {
                        System.out.println("ID     : " + b.getBillId());
                        System.out.println("Name   : " + b.getConsumerName());
                        System.out.println("Meter  : " + b.getMeterNo());
                        System.out.println("Units  : " + b.getUnits());
                        System.out.println("Amount : " + b.getAmount());
                    } else {
                        System.out.println("Bill Not Found");
                    }
                    break;
                    
                // View all bill
                case 3:
                    List<ElectricityBillDTO> list = service.getAllBills();

                    System.out.println("\nID  NAME      METER     UNITS  AMOUNT");
                    System.out.println("---------------------------------------");

                    //Iterates through each bill
                    for (ElectricityBillDTO x : list) {
                    	//Displays bills in tabular format
                        System.out.printf("%-3d %-9s %-9s %-6d %.2f\n",
                                x.getBillId(),
                                x.getConsumerName(),
                                x.getMeterNo(),
                                x.getUnits(),
                                x.getAmount());
                    }
                    break;
                    
                //Update bill
                case 4:
                    System.out.print("Enter Meter Number: ");
                    String um = sc.nextLine();

                    System.out.print("Enter New Units: ");
                    int newUnits = sc.nextInt();
                    sc.nextLine();

                    service.updateBill(um, newUnits);
                    System.out.println("Bill Updated");
                    break;
                    
                //Delete bill
                case 5:
                    System.out.print("Enter Meter Number: ");
                    String dm = sc.nextLine();

                    service.deleteBill(dm);
                    System.out.println("Bill Deleted");
                    break;
                    
                //Exit from bill
                case 6:
                    System.out.println("Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
