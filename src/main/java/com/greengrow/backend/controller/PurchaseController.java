package com.greengrow.backend.controller;

import com.greengrow.backend.model.Purchase;
import com.greengrow.backend.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<Purchase> createPurchase(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.createPurchase(purchase), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Purchase>> getAllPurchases() {
        return new ResponseEntity<>(purchaseService.getAllPurchases(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Purchase> getPurchaseById(@PathVariable Long id) {
        return new ResponseEntity<>(purchaseService.getPurchaseById(id), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Purchase>> getPurchasesByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(purchaseService.getPurchasesByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Purchase>> getPurchasesByCourseId(@PathVariable Long courseId) {
        return new ResponseEntity<>(purchaseService.getPurchasesByCourseId(courseId), HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Purchase>> getPurchasesByStatus(@PathVariable String status) {
        return new ResponseEntity<>(purchaseService.getPurchasesByStatus(status), HttpStatus.OK);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Purchase> updatePurchaseStatus(@PathVariable Long id, @RequestBody String status) {
        return new ResponseEntity<>(purchaseService.updatePurchaseStatus(id, status), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchase(@PathVariable Long id) {
        purchaseService.deletePurchaseById(id);
        return ResponseEntity.noContent().build();
    }
}
