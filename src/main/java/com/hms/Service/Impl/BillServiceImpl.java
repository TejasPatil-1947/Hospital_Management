package com.hms.Service.Impl;

import com.hms.Exception.BillNotFoundException;
import com.hms.Service.BillService;
import com.hms.models.Bill;
import com.hms.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {


    @Autowired
    private BillRepository billRepository;

    @Override
    public Bill getBillById(Long id) {
        return billRepository.findById(id).orElseThrow(() -> new BillNotFoundException("Bill not found with id: " + id));
    }

    @Override
    public Bill saveBill(Bill bill) {
        Bill b = new Bill();
        b.setBillingDate(LocalDateTime.now());
        b.setDescription(bill.getDescription());
        b.setPatient(bill.getPatient());
        b.setAppointment(bill.getAppointment());
        b.setStatus(bill.getStatus());
        return billRepository.save(b );
    }

    @Override
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    @Override
    public Bill updateBill(Long id,Bill bill) {
        Bill existingBill = billRepository.findById(id).orElseThrow(() -> new BillNotFoundException("Bill not found with id: " + id));
//        System.out.println(bill.getAppointment().getId());
        existingBill.setAppointment(bill.getAppointment() != null ? bill.getAppointment() : existingBill.getAppointment());
        existingBill.setAmount(bill.getAmount() != null ? bill.getAmount() : existingBill.getAmount());
        existingBill.setBillingDate(bill.getBillingDate() !=null ? bill.getBillingDate() : existingBill.getBillingDate());
        existingBill.setPatient(bill.getPatient() != null ? bill.getPatient() : existingBill.getPatient());
        existingBill.setDescription(bill.getDescription() != null ? bill.getDescription() : existingBill.getDescription());
        existingBill.setStatus(bill.getStatus() != null ? bill.getStatus() : existingBill.getStatus());
        return billRepository.save(existingBill);
    }

    @Override
    public void deleteBill(Long id) {

    }
}
