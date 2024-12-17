package com.example.auto_record.repository;

import com.example.auto_record.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

    // 登録時間で1件検索
    public Sale findBySaleAt(LocalDateTime searchTime);
    // saleId で1件検索
    public Sale findBySaleId(Integer saleId);
    // groupId で合致するものを全件取得
    public List<Sale> findByGroupId(Integer groupId);
    // saleId で合致するものを削除
    public void deleteBySaleId(Integer saleId);
}
