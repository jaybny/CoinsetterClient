package com.coinsetter.client.api.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created with IntelliJ IDEA.
 * User: Jay Berg
 * Date: 7/8/13
 * Time: 2:25 AM
 */

public class OrderResponse {
    public String uuid;						//  Client session UUID
    public String message;						//  Message
    public String requestStatus;				//  Request status
    public String orderNumber;				//  Request status

    public OrderResponse(
            @JsonProperty("uuid") String uuid,
            @JsonProperty("message") String message,
            @JsonProperty("requestStatus") String requestStatus,
            @JsonProperty("orderNumber") String orderNumber
    ) {

        this.uuid = uuid;
        this.message = message;
        this.orderNumber = orderNumber;
        this.requestStatus = requestStatus;
    }

    @Override
    public String toString() {

        return "\nOrderResponse: "
                + "\n\trequestStatus=" + requestStatus
                + "\n\tmessage=" + message
                + "\n\torderNumber" + orderNumber
                + "\n\tuuid=" + uuid
                + "\n";
    }
}

