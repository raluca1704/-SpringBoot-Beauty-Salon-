package org.salon_frumusete.controller;

import org.salon_frumusete.databasemodell.Receipt;
import org.salon_frumusete.repository.ReceiptRepository;

import java.util.List;

public class ReceiptController {
    private ReceiptRepository receiptRepository;

    public ReceiptController(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    public void addReceipt(Receipt receipt) {
        receiptRepository.addReceipt(receipt);
    }

    public Receipt getReceiptById(int receiptID) {
        return receiptRepository.getReceiptById(receiptID);
    }

    public List<Receipt> getAllReceipts() {
        return receiptRepository.getAllReceipts();
    }

    public void updateReceipt(Receipt updatedReceipt) {
        receiptRepository.updateReceipt(updatedReceipt);
    }

    public void deleteReceipt(int receiptID) {
        receiptRepository.deleteReceipt(receiptID);
    }
}