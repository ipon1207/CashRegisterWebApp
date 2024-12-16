package com.example.auto_record.controller.product;

import com.example.auto_record.model.group.GroupPrincipal;
import com.example.auto_record.model.product.Product;
import com.example.auto_record.service.product.ProductRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductRegisterController {

    @Autowired
    ProductRegisterService productRegisterService;

    // 商品の新規登録画面を表示
    @GetMapping("/main/productList/viewRegister")
    public String getViewRegister(Model model) {
        model.addAttribute("productRegister", new Product());
        return "productRegister";
    }

    // 商品の新規登録
    @PostMapping("/main/productList/register")
    public String postRegister(@AuthenticationPrincipal GroupPrincipal groupPrincipal, @ModelAttribute Product registerProduct, Model model) {

        List<Product> productList;

        // 登録を実行
        productRegisterService.insertOne(registerProduct, groupPrincipal.getGroupId(), groupPrincipal.getGroupName());
        // 条件に合致したものを全件取得
        productList = productRegisterService.searchProduct(groupPrincipal.getGroupId());

        model.addAttribute("productList", productList);
        return "productList";
    }

}
