package com.example.auto_record.controller.sale;

import com.example.auto_record.model.GroupPrincipal;
import com.example.auto_record.model.Sale;
import com.example.auto_record.service.sale.SaleEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SaleEditController {

    @Autowired
    SaleEditService saleEditService;

    // 取引履歴を表示
    @GetMapping("/main/viewSaleList")
    public String getViewSaleLog(@AuthenticationPrincipal GroupPrincipal groupPrincipal, Model model) {

        List<Sale> saleList;

        saleList = saleEditService.searchSale(groupPrincipal.getGroupId());

        model.addAttribute("saleList", saleList);
        return "saleList";
    }

}
