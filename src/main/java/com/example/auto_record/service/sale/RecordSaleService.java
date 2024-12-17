package com.example.auto_record.service.sale;

import com.example.auto_record.model.Product;
import com.example.auto_record.model.Sale;
import com.example.auto_record.model.SaleDetail;
import com.example.auto_record.repository.ProductRepository;
import com.example.auto_record.repository.SaleDetailRepository;
import com.example.auto_record.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecordSaleService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    SaleDetailRepository saleDetailRepository;

    // グループの商品を全件取得
    public List<Product> searchProduct(Integer groupId) {

        List<Product> result;

        result = productRepository.findByGroupId(groupId);

        return result;

    }

    // sales テーブルに売り上げを登録し、その saleId を取得
    public Integer insertSale(Integer groupId, Integer totalPrice, Integer receivedPrice, Integer changePrice) {

        Sale registerSale = new Sale();
        LocalDateTime searchTime = LocalDateTime.now();
        Sale result;
        Integer saleId;

        registerSale.setGroupId(groupId);
        registerSale.setTotalPrice(totalPrice);
        registerSale.setReceivedPrice(receivedPrice);
        registerSale.setChangePrice(changePrice);
        registerSale.setSaleAt(searchTime);

        saleRepository.save(registerSale);
        result = saleRepository.findBySaleAt(searchTime);
        saleId = result.getSaleId();

        return saleId;

    }

    // sales details テーブルに売り上げを登録
    public void insertSaleDetail(Integer saleId, Integer productId, Integer quantity) {

        SaleDetail registerSaleDetail = new SaleDetail();

        registerSaleDetail.setSaleId(saleId);
        registerSaleDetail.setProductId(productId);
        registerSaleDetail.setQuantity(quantity);

        saleDetailRepository.save(registerSaleDetail);

    }

    // saleId で1件検索
    public Sale searchOne(Integer saleId) {

        Sale result;

        result =  saleRepository.findBySaleId(saleId);

        return result;

    }

}
