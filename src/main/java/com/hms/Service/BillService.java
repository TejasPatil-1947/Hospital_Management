package com.hms.Service;

import com.hms.models.Bill;

import java.util.List;

public interface BillService {


    Bill getBillById(Long id);

    Bill saveBill(Bill bill);

    List<Bill> getAllBills();

    Bill updateBill(Long id,Bill bill);

    void deleteBill(Long id);
}
