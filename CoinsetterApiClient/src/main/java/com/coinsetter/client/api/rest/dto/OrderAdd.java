package com.coinsetter.client.api.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: jay
 * Date: 7/8/13
 * Time: 12:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class OrderAdd {


    public String customerUuid;
    public String accountUuid;
    public String symbol;
    public String side;
    public String orderType;
    public int requestedQuantity;
    public BigDecimal requestedPrice;
    public int routingMethod;

    public OrderAdd(
            @JsonProperty("customerUuid") String customerUuid,
            @JsonProperty("accountUuid") String accountUuid,
            @JsonProperty("side") String side,
            @JsonProperty("orderType") String orderType,
            @JsonProperty("requestedQuantity") int requestedQuantity,
            //@JsonProperty("routingMethod") int routingMethod,
            @JsonProperty("requestedPrice")  BigDecimal requestedPrice
            ) {

        this.customerUuid = customerUuid;
        this.accountUuid = accountUuid;
        this.symbol = "BTCUSD";
        this.side = side;
        this.orderType = orderType;
        this.requestedQuantity = requestedQuantity;
        this.requestedPrice = requestedPrice;
        this.routingMethod = 2;
    }

    @Override
    public String toString() {

        return "OrderAdd ["

                + "customerUuid=" + customerUuid
                + " accountUuid=" + accountUuid
                + " symbol=" + symbol
                + " side=" + side
                + " orderType=" + orderType
                + " requestedQuantity=" + requestedQuantity
                + " requestedPrice=" + requestedPrice
                + " routingMethod=" + routingMethod
                + "]";
    }

}
