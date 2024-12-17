package com.example.auto_record.controller.sale;

import com.example.auto_record.model.GroupPrincipal;
import com.example.auto_record.model.Product;
import com.example.auto_record.model.Sale;
import com.example.auto_record.service.sale.RecordSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class RecordSaleController {

    @Autowired
    RecordSaleService recordSaleService;

    // 売り上げ登録画面を表示
    @GetMapping("/main/viewRecordSale")
    public String getViewRecordSale(@AuthenticationPrincipal GroupPrincipal groupPrincipal, Model model) {

        List<Product> productKey;

        productKey = recordSaleService.searchProduct(groupPrincipal.getGroupId());

        model.addAttribute("productKey", productKey);
        return "recordSale";

    }

    // 売り上げを登録
    @PostMapping("/main/recordSale")
    public String postRecordSale(@RequestParam("totalAmount") Integer totalPrice,
                                 @RequestParam("receivedAmount") Integer receivedPrice,
                                 @RequestParam("changeAmount") Integer changePrice,
                                 @RequestParam Map<String, String> soldItems,
                                 @AuthenticationPrincipal GroupPrincipal groupPrincipal,
                                 Model model) {
        Integer saleId;
        Sale saleResult;

        // 商品情報の抽出
        Map<Integer, Integer> soldItemData = extractSoldItems(soldItems);

        // 売り上げを保存し、saleId を取得
        saleId = recordSaleService.insertSale(groupPrincipal.getGroupId(), totalPrice, receivedPrice, changePrice);
        // 売り上げの詳細を保存
        for (Map.Entry<Integer, Integer> entry : soldItemData.entrySet()) {
            recordSaleService.insertSaleDetail(saleId, entry.getKey(), entry.getValue());
        }

        saleResult = recordSaleService.searchOne(saleId);

        // 確認画面で表示するためにモデルに追加
        model.addAttribute("saleResult", saleResult);

        // 確認画面を表示
        return "saleResult"; // 確認画面のテンプレート名
    }

    private Map<Integer, Integer> extractSoldItems(Map<String, String> soldItems) {
        return soldItems.entrySet().stream()
                .filter(entry -> entry.getKey().startsWith("soldItems["))
                .collect(Collectors.toMap(
                        entry -> Integer.parseInt(entry.getKey().replaceAll("soldItems\\[|]", "")),
                        entry -> Integer.parseInt(entry.getValue())
                ));
    }

}