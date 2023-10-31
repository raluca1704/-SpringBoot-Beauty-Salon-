package repository;

import databasemodell.Receipt;

import java.util.ArrayList;
import java.util.List;

public class ReceiptRepository {
    private List<Receipt> receipts;

    public ReceiptRepository() {
        this.receipts = new ArrayList<>();
    }

    public void addReceipt(Receipt receipt) {
        receipts.add(receipt);
    }

    public Receipt getReceiptById(int receiptID) {
        for (Receipt receipt : receipts) {
            if (receipt.getReceiptID() == receiptID) {
                return receipt;
            }
        }
        return null; // Receipt not found
    }

    public List<Receipt> getAllReceipts() {
        return new ArrayList<>(receipts); // Return a copy to avoid modifying the internal list
    }

    public void updateReceipt(Receipt updatedReceipt) {
        for (int i = 0; i < receipts.size(); i++) {
            if (receipts.get(i).getReceiptID() == updatedReceipt.getReceiptID()) {
                receipts.set(i, updatedReceipt);
                return;
            }
        }
    }

    public void deleteReceipt(int receiptID) {
        receipts.removeIf(receipt -> receipt.getReceiptID() == receiptID);
    }
}