package com.example.auto_record.service.sale;

import com.example.auto_record.model.Sale;
import com.example.auto_record.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleEditService {

    @Autowired
    SaleRepository saleRepository;

    // groupId に合致するものを全件取得
    public List<Sale> searchSale(Integer groupId) {

        List<Sale> result;

        result = saleRepository.findByGroupId(groupId);

        return  result;

    }

}
