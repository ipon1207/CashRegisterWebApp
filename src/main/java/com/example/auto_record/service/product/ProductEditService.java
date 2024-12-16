package com.example.auto_record.service.product;

import com.example.auto_record.model.product.Product;
import com.example.auto_record.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductEditService {

    @Autowired
    ProductRepository productRepository;

    // products から全件取得
    public List<Product> searchAll(Integer groupId) {

        List<Product> result;

        // 全件取得の実行
        result = productRepository.findByGroupId(groupId);
        // 実行結果の検証
        if (result.isEmpty()) {
            System.out.println("Products are not found");
            throw new IllegalArgumentException("Products are not found");
        }

        return result;

    }

}
