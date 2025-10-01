package com.hms.controllers;

import com.hms.Dtos.BillDTO;
import com.hms.Dtos.DtoMapper;
import com.hms.Service.BillService;
import com.hms.models.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping
    public ResponseEntity<List<BillDTO>> getAllBills(){
        List<Bill> allBills = billService.getAllBills();
        List<BillDTO> list = allBills.stream().map(DtoMapper::toBillDTO).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BillDTO> updateBill(@PathVariable Long id,@RequestBody Bill bill){
//        System.out.println(id);
        Bill updatedBill = billService.updateBill(id, bill);
        return new ResponseEntity<>(DtoMapper.toBillDTO(updatedBill),HttpStatus.OK);
    }


}
