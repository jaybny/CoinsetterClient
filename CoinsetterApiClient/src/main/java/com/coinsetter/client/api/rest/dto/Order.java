package com.coinsetter.client.api.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: jay
 * Date: 7/8/13
 * Time: 2:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class Order  {
    public String uuid;					    	//  Order UUID
    public String accountUuid;				    //  Account UUID
    public BigDecimal commission;				//  Commission paid
    public BigDecimal costBasis;				//  Cost basis
    public String customerUuid;				    //  Customer UUID
    public BigDecimal filledQuantity;			//  Filled quantity
    public BigDecimal openQuantity;		    	//  Open quantity (i.e. to be filled/canceled/rejected)
    public String orderNumber;					//  Order #
    public String orderType;					//  Order type
    public String stage;						//  Stage (i.e. new, pending, open, etc.)
    public BigDecimal requestedQuantity;		//  Requested quantity
    public BigDecimal requestedPrice;			//  Requested price
    public int routingMethod;					//  Routing method
    public String side;					    	//  Side
    public String symbol;						//  Symbol
    public long createDate;

    public Order(
            @JsonProperty("uuid") String uuid,
            @JsonProperty("accountUuid") String accountUuid,
            @JsonProperty("commission") BigDecimal commission,
            @JsonProperty("costBasis") BigDecimal costBasis,
            @JsonProperty("customerUuid") String customerUuid,
            @JsonProperty("filledQuantity") BigDecimal filledQuantity,
            @JsonProperty("orderNumber") String orderNumber,
            @JsonProperty("orderType") String orderType,
            @JsonProperty("stage") String stage,
            @JsonProperty("requestedQuantity") BigDecimal requestedQuantity,
            @JsonProperty("requestedPrice") BigDecimal requestedPrice,
            @JsonProperty("routingMethod") int routingMethod,
            @JsonProperty("side") String side,
            @JsonProperty("symbol") String symbol,
            @JsonProperty("openQuantity") BigDecimal openQuantity,
            @JsonProperty("createDate") long createDate) {

        this.uuid = uuid;
        this.accountUuid = accountUuid;
        this.commission = commission;
        this.costBasis = costBasis;
        this.customerUuid = customerUuid;
        this.filledQuantity = filledQuantity;
        this.openQuantity = openQuantity;
        this.orderType = orderType;
        this.stage = stage;
        this.requestedQuantity = requestedQuantity;
        this.requestedPrice = requestedPrice;
        this.routingMethod = routingMethod;
        this.side = side;
        this.symbol = symbol;
        this.createDate = createDate;
        this.orderNumber = orderNumber;
    }

    public enum OrderType {
        MARKET("MARKET"),
        LIMIT("LIMIT")
        ;

        private String orderType;

        private OrderType(String value) {
            orderType = value;
        }

        public String toString() {
            return orderType;
        }

    }

    public enum Side {
        BUY("BUY"),
        SELL("SELL")
        ;

        private String side;

        private Side(String value) {
            side = value;
        }

        public String toString() {
            return side;
        }

    }

    @Override
    public String toString() {
        return "\n\tOrder:"
                + "\n\t\torderNumber=" + orderNumber
                + "\n\t\tstage=" + stage
                + "\n\t\tsymbol=" + symbol
                + "\n\t\tside=" + side
                + "\n\t\trequestedQuantity=" + requestedQuantity
                + "\n\t\trequestedPrice=" + requestedPrice
                + "\n\t\tuuid=" + uuid
                + "\n\t\torderType=" + orderType
                + "\n\t\troutingMethod=" + routingMethod
                + "\n\t\tfilledQuantity=" + filledQuantity
                + "\n\t\topenQuantity=" + openQuantity
                + "\n\t\tcostBasis=" + costBasis
                + "\n\t\tcommission=" + commission
                + "\n\t\tcustomerUuid=" + customerUuid
                + "\n\t\taccountUuid=" + accountUuid
                + "\n\t\tcreateDate=" + createDate
                + "\n";
    }
}

