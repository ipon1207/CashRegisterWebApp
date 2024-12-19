package com.example.auto_record.service.product;

import com.example.auto_record.model.Product;
import com.example.auto_record.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ProductEditService {

    @Autowired
    ProductRepository productRepository;

    // products から groupId と一致するものを全件取得
    public List<Product> searchProducts(Integer groupId) {

        List<Product> result;

        // 全件取得の実行
        result = productRepository.findByGroupIdAndIsDeletedFalse(groupId);

        return result;

    }

    // products から productId　と一致するものを1件取得
    public Product searchOne(Integer productId) {

        Product result;

        // 1件取得の実行
        result = productRepository.findByProductIdAndIsDeletedFalse(productId);

        return result;
    }

    // products のデータを更新
    public void updateOne(Product product) {

        Product exitingProduct;

        exitingProduct = productRepository.findByProductIdAndIsDeletedFalse(product.getProductId());
        exitingProduct.setProductName(product.getProductName());
        exitingProduct.setProductValue(product.getProductValue());
        // LocalDateTimeをフォーマットしてString型のcreatedAtに設定
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd/HH:mm");
        exitingProduct.setCreatedAt(LocalDateTime.now().format(formatter));
        // データの更新を実行
        productRepository.save(exitingProduct);

    }

    // products のデータを削除
    public void deleteOne(Integer productId) {

        productRepository.logicallyDeleteByProductId(productId);

    }

}
