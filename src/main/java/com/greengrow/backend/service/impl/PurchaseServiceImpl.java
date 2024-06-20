package com.greengrow.backend.service.impl;

import com.greengrow.backend.exception.ResourceNotFoundException;
import com.greengrow.backend.model.Purchase;
import com.greengrow.backend.repository.CourseRepository;
import com.greengrow.backend.repository.PurchaseRepository;
import com.greengrow.backend.repository.UserRepository;
import com.greengrow.backend.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;


    @Override
    public Purchase createPurchase(Purchase purchase) {
        if(purchase.getUserId() == null || !userRepository.existsById(purchase.getUserId())) {
            throw new ResourceNotFoundException("User not found");
        }
        if(purchase.getCourseId() == null || !courseRepository.existsById(purchase.getCourseId())) {
            throw new ResourceNotFoundException("Course not found");
        }
        return purchaseRepository.save(purchase);
    }

    @Override
    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }


    @Override
    public Purchase getPurchaseById(Long id) {
        return purchaseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Purchase not found with id " + id));
    }


    @Override
    public List<Purchase> getPurchasesByUserId(Long userId) {
        return purchaseRepository.findByUserId(userId);
    }


    @Override
    public List<Purchase> getPurchasesByCourseId(Long courseId) {
        return purchaseRepository.findByCourseId(courseId);
    }


    @Override
    public List<Purchase> getPurchasesByStatus(String status) {
        return purchaseRepository.findByStatus(status);
    }


    @Override
    public Purchase updatePurchaseStatus(Long id, String status) {
        Purchase purchase = purchaseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Purchase not found with id " + id));
        purchase.setStatus(status);
        return purchaseRepository.save(purchase);
    }

    @Override
    public void deletePurchaseById(Long id) {
        Purchase purchase = purchaseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Purchase not found with id " + id));
        purchaseRepository.delete(purchase);
    }
}
