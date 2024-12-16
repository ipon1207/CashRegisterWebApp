package com.example.auto_record.controller.product;

import com.example.auto_record.model.group.GroupPrincipal;
import com.example.auto_record.model.product.Product;
import com.example.auto_record.service.group.GroupDetailsService;
import com.example.auto_record.service.product.ProductEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/* 商品の編集機能 Controller */
@Controller
public class ProductEditController {

    @Autowired
    ProductEditService productEditService;

    // 商品一覧の表示
    @GetMapping("/main/productList")
    // ログイン済みグループの情報を取得
    public String getProductList(@AuthenticationPrincipal GroupPrincipal groupPrincipal, Model model){

        if (groupPrincipal == null) {
            return "Not logged in";
        }

        List<Product> productList;

        // ログイングループの groupId に合致する商品を全件取得
        productList = productEditService.searchAll(groupPrincipal.getGroupId());

        model.addAttribute("productList", productList);
        return "productList";
    }

}
