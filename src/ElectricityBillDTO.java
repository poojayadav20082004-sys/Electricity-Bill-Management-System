public class ElectricityBillDTO {

    private int billId;
    private String consumerName;
    private String meterNo;
    private int units;
    private double amount;

    public ElectricityBillDTO() {}

    public ElectricityBillDTO(int billId, String consumerName,
                              String meterNo, int units, double amount) {
        this.billId = billId;
        this.consumerName = consumerName;
        this.meterNo = meterNo;
        this.units = units;
        this.amount = amount;
    }

    public int getBillId() {
        return billId;
    }
    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getConsumerName() {
        return consumerName;
    }
    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getMeterNo() {
        return meterNo;
    }
    public void setMeterNo(String meterNo) {
        this.meterNo = meterNo;
    }

    public int getUnits() {
        return units;
    }
    public void setUnits(int units) {
        this.units = units;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}

