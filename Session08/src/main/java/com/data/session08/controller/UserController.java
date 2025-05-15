package com.data.session08.controller;

import com.data.session08.model.Bai5.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/users")
    public ModelAndView showUserList() {
        List<User> users = new ArrayList<>();

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            User user1 = new User();
            user1.setName("John Doe");
            user1.setAge(30);
            user1.setBirthday(sdf.parse("1993-05-15"));
            user1.setEmail("john.doe@example.com");
            user1.setPhone("1234567890");

            User user2 = new User();
            user2.setName("Jane Smith");
            user2.setAge(25);
            user2.setBirthday(sdf.parse("1998-08-20"));
            user2.setEmail("jane.smith@example.com");
            user2.setPhone("0987654321");

            users.add(user1);
            users.add(user2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ModelAndView modelAndView = new ModelAndView("userList");
        modelAndView.addObject("users", users);
        return modelAndView;
    }
}
