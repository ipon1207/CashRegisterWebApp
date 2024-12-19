package com.example.auto_record.service.sale;

import com.example.auto_record.model.Product;
import com.example.auto_record.model.Sale;
import com.example.auto_record.model.SaleDetail;
import com.example.auto_record.repository.ProductRepository;
import com.example.auto_record.repository.SaleDetailRepository;
import com.example.auto_record.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleEditService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    SaleDetailRepository saleDetailRepository;

    // groupId に合致するものを全件取得
    public List<Sale> searchSale(Integer groupId) {

        List<Sale> result;

        result = saleRepository.findByGroupId(groupId);

        return  result;

    }

    // sale_details から saleId に合致するものを全件取得
    public List<SaleDetail> searchSaleDetail(Integer saleId) {

        List<SaleDetail> result;

        result = saleDetailRepository.findBySaleId(saleId);

        return result;
    }

    // products から productId に合致するものを1件取得
    public Product searchProduct(Integer productId) {

        Product result;

        result = productRepository.findByProductId(productId);

        return  result;

    }

    // sale と sale_details から saleId に合致するものを削除
    public void deleteSale(Integer saleId) {

        saleRepository.deleteBySaleId(saleId);
        saleDetailRepository.deleteBySaleId(saleId);

    }
}
