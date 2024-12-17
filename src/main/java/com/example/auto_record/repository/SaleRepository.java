package com.example.auto_record.repository;

import com.example.auto_record.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

    // 登録時間で1件検索
    public Sale findBySaleAt(LocalDateTime searchTime);
    // saleId で1件検索
    public Sale findBySaleId(Integer saleId);
}
