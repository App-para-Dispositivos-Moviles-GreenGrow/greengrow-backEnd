package com.greengrow.backend.service;

import com.greengrow.backend.model.Purchase;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PurchaseService {
    Purchase createPurchase(Purchase purchase);

    List<Purchase> getAllPurchases();

    Purchase getPurchaseById(Long id);

    List<Purchase> getPurchasesByUserId(Long userId);

    List<Purchase> getPurchasesByCourseId(Long courseId);

    List<Purchase> getPurchasesByStatus(String status);

    Purchase updatePurchaseStatus(Long id, String status);

    void deletePurchaseById(Long id);
}
