package com.data.session10.controller;


import com.data.session10.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @PostMapping("/submitForm")
    public String submitForm(@RequestParam("name") String name,
                             @RequestParam("age") int age,
                             @RequestParam("address") String address,
                             Model model) {
        // Tạo đối tượng User từ dữ liệu form
        User user = new User(name, age, address);

        // Thêm đối tượng User vào model để hiển thị trên trang kết quả
        model.addAttribute("user", user);

        return "result";
    }
}
