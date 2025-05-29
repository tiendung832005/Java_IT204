package com.data.session14.controller;


import com.data.session14.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class FinanceController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/finance")
    public String showFinancePage(HttpSession session, HttpServletRequest request, Model model) {
        Locale locale = (Locale) session.getAttribute("locale");
        if (locale == null) {
            locale = Locale.ENGLISH;
            session.setAttribute("locale", locale);
        }

        List<Transaction> transactions = (List<Transaction>) session.getAttribute("transactions");
        if (transactions == null) {
            transactions = new ArrayList<>();
        }

        model.addAttribute("transactions", transactions);
        model.addAttribute("locale", locale);
        return "finance";
    }

    @PostMapping("/finance/add")
    public String addTransaction(@RequestParam String description, @RequestParam double amount,
                                 @RequestParam String type, HttpSession session, HttpServletResponse response, Model model) {
        List<Transaction> transactions = (List<Transaction>) session.getAttribute("transactions");
        if (transactions == null) {
            transactions = new ArrayList<>();
        }
        transactions.add(new Transaction(description, amount, type));
        session.setAttribute("transactions", transactions);

        Cookie cookie = new Cookie("transaction_" + description, description + ":" + amount + ":" + type);
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);

        Locale locale = (Locale) session.getAttribute("locale");
        model.addAttribute("message", messageSource.getMessage("success.transaction.added", null, locale));
        return "redirect:/finance";
    }

    @GetMapping("/finance/delete")
    public String deleteTransaction(@RequestParam String description, HttpSession session) {
        List<Transaction> transactions = (List<Transaction>) session.getAttribute("transactions");
        if (transactions != null) {
            transactions.removeIf(transaction -> transaction.getDescription().equals(description));
            session.setAttribute("transactions", transactions);
        }
        return "redirect:/finance";
    }

    @GetMapping("/change-language")
    public String changeLanguage(@RequestParam String lang, HttpSession session) {
        Locale locale = "vi".equals(lang) ? new Locale("vi") : Locale.ENGLISH;
        session.setAttribute("locale", locale);
        return "redirect:/finance";
    }
}
