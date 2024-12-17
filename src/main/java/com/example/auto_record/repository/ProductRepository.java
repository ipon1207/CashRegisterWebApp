package com.example.auto_record.repository;

import com.example.auto_record.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // groupId で合致するものをすべて取得
    List<Product> findByGroupIdAndIsDeletedFalse(Integer groupId);
    // productId で合致するものを1件取得(論理削除されていないもの)
    Product findByProductIdAndIsDeletedFalse(Integer productId);
    // productId で合致するものを1件取得(論理削除関係なし)
    Product findByProductId(Integer productId);
    // productId で合致するものを1件削除
    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.isDeleted = true WHERE p.productId = :productId")
    void logicallyDeleteByProductId(Integer productId);

}
