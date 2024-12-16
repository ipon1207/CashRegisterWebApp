package com.example.auto_record.repository.product;

import com.example.auto_record.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // groupId で合致するものをすべて取得
    public List<Product> findByGroupId(Integer groupId);

}
