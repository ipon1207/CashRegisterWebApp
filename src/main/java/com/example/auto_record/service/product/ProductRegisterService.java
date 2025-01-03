package com.example.auto_record.service.product;

import com.example.auto_record.model.Product;
import com.example.auto_record.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ProductRegisterService {

    @Autowired
    ProductRepository productRepository;

    // products テーブルに1件追加
    public void insertOne(Product product, Integer groupId, String groupName) {

        // フォームで登録されないデータをセット
        product.setGroupId(groupId);
        product.setGroupName(groupName);
        // LocalDateTimeをフォーマットしてString型のcreatedAtに設定
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd/HH:mm:ss");
        product.setCreatedAt(LocalDateTime.now().format(formatter));

        // product テーブルを更新
        productRepository.save(product);

    }

    // products から groupId と合致するものを全件取得
    public List<Product> searchProduct(Integer groupId) {

        List<Product> result;

        result = productRepository.findByGroupIdAndIsDeletedFalse(groupId);

        return result;

    }

}
