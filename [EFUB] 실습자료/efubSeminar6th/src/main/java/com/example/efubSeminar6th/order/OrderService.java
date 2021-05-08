package com.example.efubSeminar6th.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);

}