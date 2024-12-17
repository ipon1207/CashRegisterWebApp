package com.example.auto_record.repository;

import com.example.auto_record.model.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleDetailRepository extends JpaRepository<SaleDetail, Integer> {

    // saleId に合致するものを全件取得
    List<SaleDetail> findBySaleId(Integer saleId);
    // saleId に合致するものを全件削除
    void deleteBySaleId(Integer saleId);

}
