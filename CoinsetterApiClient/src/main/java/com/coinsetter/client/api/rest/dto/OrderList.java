package com.coinsetter.client.api.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Jay Berg
 * Date: 7/10/13
 * Time: 12:19 PM
 */
public class OrderList {
    public Order[] OrderList;

    public OrderList( @JsonProperty("orderList") Order[] OrderList) {
        this.OrderList = OrderList;
    }

    @Override
    public String toString() {
        return "\nOrderList:"
                + "\torderList=" + Arrays.toString(OrderList)
                + "\n";
    }
}
