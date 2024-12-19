package com.example.auto_record.controller.product;

import com.example.auto_record.model.GroupPrincipal;
import com.example.auto_record.model.Product;
import com.example.auto_record.service.product.ProductEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
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

        List<Product> productList;

        // ログイングループの groupId に合致する商品を全件取得
        productList = productEditService.searchProducts(groupPrincipal.getGroupId());

        model.addAttribute("productList", productList);
        return "productList";
    }

    // 商品の編集画面を表示
    @PostMapping("/main/productList/viewEditProduct")
    public String postViewEditProduct(@RequestParam("id") Integer editId, Model model) {

        Product editProduct;

        // 1件取得を実行
        editProduct = productEditService.searchOne(editId);

        model.addAttribute("editProduct", editProduct);
        return "productEdit";

    }

    // products テーブルの更新
    @PostMapping("/main/productList/editProduct")
    public String postEditProduct(@AuthenticationPrincipal GroupPrincipal groupPrincipal, @ModelAttribute Product editProduct, Model model) {

        List<Product> productList;

        // 商品データの更新
        productEditService.updateOne(editProduct);
        // ログイングループの groupId に合致する商品を全件取得
        productList = productEditService.searchProducts(groupPrincipal.getGroupId());
        productList.sort(Comparator.comparing(Product::getProductId));

        model.addAttribute("productList", productList);
        return "productList";

    }

    // product テーブルのカラム削除
    @PostMapping("/main/productList/deleteProduct")
    public String postDeleteProduct(@AuthenticationPrincipal GroupPrincipal groupPrincipal, @RequestParam("id") Integer deleteId, Model model) {

        List<Product> productList;

        // 商品データの削除
        productEditService.deleteOne(deleteId);
        // ログイングループの groupId に合致する商品を全件取得
        productList = productEditService.searchProducts(groupPrincipal.getGroupId());
        productList.sort(Comparator.comparing(Product::getProductId));

        model.addAttribute("productList", productList);
        return "productList";

    }

    // 商品名で昇順並び替え
    @GetMapping("/main/productList/sortName")
    public String sortName(@AuthenticationPrincipal GroupPrincipal groupPrincipal, Model model) {

        List<Product> productList;

        // 商品データの取得
        productList = productEditService.searchProducts(groupPrincipal.getGroupId());
        productList.sort(Comparator.comparing(Product::getProductName));

        model.addAttribute("productList", productList);
        return "productList";
    }

    // 商品名で降順並び替え
    @GetMapping("/main/productList/sortNameInv")
    public String sortNameInv(@AuthenticationPrincipal GroupPrincipal groupPrincipal, Model model) {

        List<Product> productList;

        // 商品データの取得
        productList = productEditService.searchProducts(groupPrincipal.getGroupId());
        productList.sort(Comparator.comparing(Product::getProductValue).reversed());

        model.addAttribute("productList", productList);
        return "productList";
    }

    // 商品価格で昇順並び替え
    @GetMapping("/main/productList/sortValue")
    public String sortValue(@AuthenticationPrincipal GroupPrincipal groupPrincipal, Model model) {

        List<Product> productList;

        // 商品データの取得
        productList = productEditService.searchProducts(groupPrincipal.getGroupId());
        productList.sort(Comparator.comparing(Product::getProductValue));

        model.addAttribute("productList", productList);
        return "productList";
    }

    // 商品価格で降順並び替え
    @GetMapping("/main/productList/sortValueInv")
    public String sortValueInv(@AuthenticationPrincipal GroupPrincipal groupPrincipal, Model model) {

        List<Product> productList;

        // 商品データの取得
        productList = productEditService.searchProducts(groupPrincipal.getGroupId());
        productList.sort(Comparator.comparing(Product::getProductValue).reversed());

        model.addAttribute("productList", productList);
        return "productList";
    }

    // 作成更新で昇順並び替え
    @GetMapping("/main/productList/sortAt")
    public String sortAt(@AuthenticationPrincipal GroupPrincipal groupPrincipal, Model model) {

        List<Product> productList;

        // 商品データの取得
        productList = productEditService.searchProducts(groupPrincipal.getGroupId());
        productList.sort(Comparator.comparing(Product::getCreatedAt));

        model.addAttribute("productList", productList);
        return "productList";
    }

    // 作成更新日時で降順並び替え
    @GetMapping("/main/productList/sortAtInv")
    public String sortAtInv(@AuthenticationPrincipal GroupPrincipal groupPrincipal, Model model) {

        List<Product> productList;

        // 商品データの取得
        productList = productEditService.searchProducts(groupPrincipal.getGroupId());
        productList.sort(Comparator.comparing(Product::getCreatedAt).reversed());

        model.addAttribute("productList", productList);
        return "productList";
    }

}
