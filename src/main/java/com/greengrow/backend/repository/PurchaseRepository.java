package com.greengrow.backend.repository;

import com.greengrow.backend.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>{
    List<Purchase> findByUserId(Long userId);

    List<Purchase> findByCourseId(Long courseId);

    List<Purchase> findByStatus(String status);
}
