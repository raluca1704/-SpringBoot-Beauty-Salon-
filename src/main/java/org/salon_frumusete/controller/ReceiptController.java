package org.salon_frumusete.controller;

import org.salon_frumusete.databasemodell.PricingStrategy;
import org.salon_frumusete.databasemodell.Product;
import org.salon_frumusete.databasemodell.Receipt;
import org.salon_frumusete.databasemodell.ReceiptGenerator;
import org.salon_frumusete.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receipts")
public class ReceiptController {

    @Autowired
    private ReceiptRepository receiptRepository;

    @PostMapping
    public ResponseEntity<Receipt> addReceipt(@RequestBody Receipt receipt) {
        Receipt savedReceipt = receiptRepository.save(receipt);

        return ResponseEntity.ok(savedReceipt);

    }

    @GetMapping("/{receiptId}")
    public ResponseEntity<Receipt> getReceiptById(@PathVariable int receiptId) {
        return receiptRepository.findById(receiptId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Receipt>> getAllReceipts() {
        return ResponseEntity.ok(receiptRepository.findAll());
    }

    @PutMapping("/{receiptId}")
    public ResponseEntity<Receipt> updateReceipt(@PathVariable int receiptId, @RequestBody Receipt receiptDetails) {
        return receiptRepository.findById(receiptId)
                .map(receipt -> {
                    receipt.setClientID(receiptDetails.getClientID());
                    receipt.setAppointmentID(receiptDetails.getAppointmentID());
                    receipt.setPaymentDateTime(receiptDetails.getPaymentDateTime());
                    receipt.setAmountPaid(receiptDetails.getAmountPaid());
                    return ResponseEntity.ok(receiptRepository.save(receipt));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{receiptId}")
    public ResponseEntity<Void> deleteReceipt(@PathVariable int receiptId) {
        return receiptRepository.findById(receiptId)
                .map(receipt -> {
                    receiptRepository.delete(receipt);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
