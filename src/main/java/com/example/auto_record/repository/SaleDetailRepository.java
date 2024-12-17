package com.example.auto_record.repository;

import com.example.auto_record.model.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleDetailRepository extends JpaRepository<SaleDetail, Integer> {

    // saleId に合致するものを全件削除
    public void deleteBySaleId(Integer saleId);

}
