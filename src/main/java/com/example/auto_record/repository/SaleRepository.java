package com.example.auto_record.repository;

import com.example.auto_record.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

    // 登録時間で1件検索
    Sale findBySaleAt(String searchTime);
    // saleId で1件検索
    Sale findBySaleId(Integer saleId);
    // groupId で合致するものを全件取得
    List<Sale> findByGroupId(Integer groupId);
    // saleId で合致するものを削除
    @Transactional
    void deleteBySaleId(Integer saleId);
}
