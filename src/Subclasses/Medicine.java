package Subclasses;

import InterfaceClasses.SupplyCheck;
import java.util.HashMap;
import java.util.Map;

public class Medicine implements SupplyCheck {
    private String medicineID;
    private String receiptDate;
    private String expiryDate;
    private int supply;

    private static Map<String, Medicine> inventory = new HashMap<>();

    public Medicine(String medicineID, String receiptDate, String expiryDate, int supply) {
        this.medicineID = medicineID;
        this.receiptDate = receiptDate;
        this.expiryDate = expiryDate;
        this.supply = supply;
        Medicine put = inventory.put(medicineID, this);
    }

    @Override
    public int checkSupply() {
        if (this.supply <= 0) {
            throw new ArithmeticException (medicineID + "is out of stock.");
        }
        System.out.println("Medicine " + medicineID + " supply: " + supply);
        return supply;
    }

    public String getMedicineID() { return medicineID; }
    public String getReceiptDate() { return receiptDate; }
    public String getExpiryDate() { return expiryDate; }
    public int getSupply() { return supply; }
}