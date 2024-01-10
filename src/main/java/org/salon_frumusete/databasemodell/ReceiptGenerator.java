package org.salon_frumusete.databasemodell;

import org.salon_frumusete.databasemodell.Appointment;
import org.salon_frumusete.databasemodell.Receipt;

public class ReceiptGenerator {

    private static final ReceiptGenerator instance = new ReceiptGenerator();

    private ReceiptGenerator() {
        // Private constructor to prevent instantiation.
    }

    public static ReceiptGenerator getInstance() {
        return instance;
    }

    public Receipt generateReceipt(Appointment appointment) {

        Receipt receipt = new Receipt();

        receipt.setClientID(appointment.getClient().getClientID());
        receipt.setAppointmentID(appointment.getAppointmentID());
        return receipt;
    }
}
