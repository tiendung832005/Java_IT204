package com.data.session03;
import java.util.List;

public class OrderCalculator {

    public static double calculateTotal(List<String> quantities, List<String> prices) {
        double total = 0.0;

        for (int i = 0; i < quantities.size(); i++) {
            try {
                int qty = Integer.parseInt(quantities.get(i));
                double price = Double.parseDouble(prices.get(i));
                total += qty * price;
            } catch (NumberFormatException e) {
                // Nếu nhập sai thì bỏ qua dòng đó
                continue;
            }
        }

        return total;
    }
}

