package com.data.session11.controller;


import com.data.session11.dto.ProductReviewDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ProductReviewController {

    @GetMapping("/review")
    public String showReviewForm(Model model) {
        model.addAttribute("productReviewDTO", new ProductReviewDTO());
        return "reviewForm";
    }

    @PostMapping("/review")
    public String processReview(@Valid @ModelAttribute("productReviewDTO") ProductReviewDTO productReviewDTO,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "reviewForm";
        }
        model.addAttribute("message", "Cảm ơn bạn đã đánh giá sản phẩm!");
        return "reviewSuccess";
    }
}
