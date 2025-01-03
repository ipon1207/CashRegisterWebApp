package com.example.auto_record.controller.sale;

import com.example.auto_record.model.*;
import com.example.auto_record.service.sale.SaleEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class SaleEditController {

    @Autowired
    SaleEditService saleEditService;

    // 取引履歴を表示
    @GetMapping("/main/viewSaleList")
    public String getViewSaleLog(@AuthenticationPrincipal GroupPrincipal groupPrincipal, Model model) {

        List<Sale> saleList;

        // groupId に合致するものを全件取得
        saleList = saleEditService.searchSale(groupPrincipal.getGroupId());
        saleList.sort(Comparator.comparing(Sale::getSaleId));

        model.addAttribute("saleList", saleList);
        return "saleList";

    }

    // 取引の詳細を表示
    @PostMapping("/main/saleList/detail")
    public String postViewDetail(@RequestParam("id") Integer detailId, Model model) {

        List<SaleDetail> saleDetailList;
        List<Product> productList = new ArrayList<>();

        // 詳細を表示
        saleDetailList = saleEditService.searchSaleDetail(detailId);
        // 商品の詳細を取得
        for (SaleDetail saleDetail : saleDetailList) {
            productList.add(saleEditService.searchProduct(saleDetail.getProductId()));
            System.out.println(productList);
        }

        // ProductをMapに変換して高速検索
        Map<Integer, String> productMap = productList.stream()
                .collect(Collectors.toMap(Product::getProductId, Product::getProductName));

        // DTOリストを作成
        List<SaleProductDTO> saleProductList = saleDetailList.stream()
                .map(saleDetail -> new SaleProductDTO(
                        saleDetail.getSaleId(),
                        productMap.get(saleDetail.getProductId()),
                        saleDetail.getQuantity()))
                .collect(Collectors.toList());

        model.addAttribute("saleProductList", saleProductList);
        return "saleDetail";

    }

    // 取引履歴を削除
    @PostMapping("/main/saleList/delete")
    public String postSaleDelete(@AuthenticationPrincipal GroupPrincipal groupPrincipal, @RequestParam("id") Integer deleteId, Model model) {

        List<Sale> saleList;

        // 削除を実行
        saleEditService.deleteSale(deleteId);
        saleList = saleEditService.searchSale(groupPrincipal.getGroupId());
        saleList.sort(Comparator.comparing(Sale::getSaleId));

        model.addAttribute("saleList", saleList);
        return "saleList";
    }

    // 取引IDで昇順並び替え
    @GetMapping("/main/saleList/sortId")
    public String sortId(@AuthenticationPrincipal GroupPrincipal groupPrincipal, Model model) {

        List<Sale> saleList;

        // 商品データの取得
        saleList = saleEditService.searchSale(groupPrincipal.getGroupId());
        saleList.sort(Comparator.comparing(Sale::getSaleId));

        model.addAttribute("saleList", saleList);
        return "saleList";
    }

    // 取引IDで降順並び替え
    @GetMapping("/main/saleList/sortIdInv")
    public String sortIdInv(@AuthenticationPrincipal GroupPrincipal groupPrincipal, Model model) {

        List<Sale> saleList;

        // 商品データの取得
        saleList = saleEditService.searchSale(groupPrincipal.getGroupId());
        saleList.sort(Comparator.comparing(Sale::getSaleId).reversed());

        model.addAttribute("saleList", saleList);
        return "saleList";
    }

    // 合計金額で昇順並び替え
    @GetMapping("/main/saleList/sortTotal")
    public String sortTotal(@AuthenticationPrincipal GroupPrincipal groupPrincipal, Model model) {

        List<Sale> saleList;

        // 商品データの取得
        saleList = saleEditService.searchSale(groupPrincipal.getGroupId());
        saleList.sort(Comparator.comparing(Sale::getTotalPrice));

        model.addAttribute("saleList", saleList);
        return "saleList";
    }

    // 合計金額で降順並び替え
    @GetMapping("/main/saleList/sortTotalInv")
    public String sortTotalInv(@AuthenticationPrincipal GroupPrincipal groupPrincipal, Model model) {

        List<Sale> saleList;

        // 商品データの取得
        saleList = saleEditService.searchSale(groupPrincipal.getGroupId());
        saleList.sort(Comparator.comparing(Sale::getTotalPrice).reversed());

        model.addAttribute("saleList", saleList);
        return "saleList";
    }

    // 受領金額で昇順並び替え
    @GetMapping("/main/saleList/sortReceived")
    public String sortReceived(@AuthenticationPrincipal GroupPrincipal groupPrincipal, Model model) {

        List<Sale> saleList;

        // 商品データの取得
        saleList = saleEditService.searchSale(groupPrincipal.getGroupId());
        saleList.sort(Comparator.comparing(Sale::getReceivedPrice));

        model.addAttribute("saleList", saleList);
        return "saleList";
    }

    // 受領金額で降順並び替え
    @GetMapping("/main/saleList/sortReceivedInv")
    public String sortReceivedInv(@AuthenticationPrincipal GroupPrincipal groupPrincipal, Model model) {

        List<Sale> saleList;

        // 商品データの取得
        saleList = saleEditService.searchSale(groupPrincipal.getGroupId());
        saleList.sort(Comparator.comparing(Sale::getReceivedPrice).reversed());

        model.addAttribute("saleList", saleList);
        return "saleList";
    }

    // お釣りで昇順並び替え
    @GetMapping("/main/saleList/sortChange")
    public String sortChange(@AuthenticationPrincipal GroupPrincipal groupPrincipal, Model model) {

        List<Sale> saleList;

        // 商品データの取得
        saleList = saleEditService.searchSale(groupPrincipal.getGroupId());
        saleList.sort(Comparator.comparing(Sale::getChangePrice));

        model.addAttribute("saleList", saleList);
        return "saleList";
    }

    // お釣りで降順並び替え
    @GetMapping("/main/saleList/sortChangeInv")
    public String sortChangeInv(@AuthenticationPrincipal GroupPrincipal groupPrincipal, Model model) {

        List<Sale> saleList;

        // 商品データの取得
        saleList = saleEditService.searchSale(groupPrincipal.getGroupId());
        saleList.sort(Comparator.comparing(Sale::getChangePrice).reversed());

        model.addAttribute("saleList", saleList);
        return "saleList";
    }

    // 取引時間で昇順並び替え
    @GetMapping("/main/saleList/sortAt")
    public String sortAt(@AuthenticationPrincipal GroupPrincipal groupPrincipal, Model model) {

        List<Sale> saleList;

        // 商品データの取得
        saleList = saleEditService.searchSale(groupPrincipal.getGroupId());
        saleList.sort(Comparator.comparing(Sale::getSaleAt));

        model.addAttribute("saleList", saleList);
        return "saleList";
    }

    // 取引時間で降順並び替え
    @GetMapping("/main/saleList/sortAtInv")
    public String sortAtInv(@AuthenticationPrincipal GroupPrincipal groupPrincipal, Model model) {

        List<Sale> saleList;

        // 商品データの取得
        saleList = saleEditService.searchSale(groupPrincipal.getGroupId());
        saleList.sort(Comparator.comparing(Sale::getSaleAt).reversed());

        model.addAttribute("saleList", saleList);
        return "saleList";
    }

}
