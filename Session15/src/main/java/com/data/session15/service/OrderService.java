package com.data.session15.service;

import com.data.session15.model.Order;
import com.data.session15.model.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final List<Order> orderDatabase = new ArrayList<>();
    private final List<OrderDetail> orderDetailDatabase = new ArrayList<>();

    public int saveOrder(Order order) {
        order.setOrderId(orderDatabase.size() + 1);
        orderDatabase.add(order);
        return order.getOrderId();
    }

    public void saveOrderDetail(OrderDetail orderDetail) {
        orderDetail.setId(orderDetailDatabase.size() + 1);
        orderDetailDatabase.add(orderDetail);
    }
}
