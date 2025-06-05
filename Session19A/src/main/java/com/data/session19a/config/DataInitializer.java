package com.data.session19a.config;

import com.data.session19a.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataInitializer {

    private final SessionFactory sessionFactory;

    public DataInitializer(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Bean
    public void initializeData() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            User user1 = new User();
            user1.setUsername("user1");
            user1.setPassword("password1");
            user1.setEmail("user1@example.com");
            user1.setPhoneNumber("1234567890");
            user1.setIsActive(true);

            User user2 = new User();
            user2.setUsername("user2");
            user2.setPassword("password2");
            user2.setEmail("user2@example.com");
            user2.setPhoneNumber("0987654321");
            user2.setIsActive(false);

            User user3 = new User();
            user3.setUsername("user3");
            user3.setPassword("password3");
            user3.setEmail("user3@example.com");
            user3.setPhoneNumber("0987654322");
            user3.setIsActive(true);

            User user4 = new User();
            user4.setUsername("user4");
            user4.setPassword("password4");
            user4.setEmail("user4@example.com");
            user4.setPhoneNumber("0987654323");
            user4.setIsActive(true);

            User user5 = new User();
            user5.setUsername("user5");
            user5.setPassword("password5");
            user5.setEmail("user5@example.com");
            user5.setPhoneNumber("0987654324");
            user5.setIsActive(false);

            User user6 = new User();
            user6.setUsername("user6");
            user6.setPassword("password6");
            user6.setEmail("user6@example.com");
            user6.setPhoneNumber("0987654325");
            user6.setIsActive(true);

            User user7 = new User();
            user7.setUsername("user7");
            user7.setPassword("password7");
            user7.setEmail("user7@example.com");
            user7.setPhoneNumber("0987654326");
            user7.setIsActive(false);

            User user8 = new User();
            user8.setUsername("user8");
            user8.setPassword("password8");
            user8.setEmail("user8@example.com");
            user8.setPhoneNumber("0987654327");
            user8.setIsActive(true);

            User user9 = new User();
            user9.setUsername("user9");
            user9.setPassword("password9");
            user9.setEmail("user9@example.com");
            user9.setPhoneNumber("0987654328");
            user9.setIsActive(true);

            User user10 = new User();
            user10.setUsername("user10");
            user10.setPassword("password10");
            user10.setEmail("user10@example.com");
            user10.setPhoneNumber("0987654329");
            user10.setIsActive(false);

            session.save(user1);
            session.save(user2);
            session.save(user3);
            session.save(user4);
            session.save(user5);
            session.save(user6);
            session.save(user7);
            session.save(user8);
            session.save(user9);
            session.save(user10);

            session.getTransaction().commit();
            session.close();
        }
    }
}