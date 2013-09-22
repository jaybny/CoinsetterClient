package com.coinsetter.client.api.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created with IntelliJ IDEA.
 * User: Jay Berg
 * Date: 7/8/13
 * Time: 2:25 AM
 */
public class ClientSession {
    public String uuid;						//  Client session UUID
    public String customerStatus;			//  CustomerStatus
    public String customerUuid;				//  Customer UUID
    public String message;					//  Message
    public String requestStatus;			//  Request status
    public String userName;					//  User name


    public ClientSession(
            @JsonProperty("uuid") String uuid,
            @JsonProperty("customerStatus") String customerStatus,
            @JsonProperty("customerUuid") String customerUuid,
            @JsonProperty("message") String message,
            @JsonProperty("requestStatus") String requestStatus,
            @JsonProperty("userName") String userName) {

        this.uuid = uuid;
        this.customerStatus = customerStatus;
        this.customerUuid = customerUuid;
        this.message = message;
        this.requestStatus = requestStatus;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "\nClientSession:"
                + "\n\tuuid=" + uuid
                + "\n\tcustomerStatus=" + customerStatus
                + "\n\tcustomerUuid=" + customerUuid
                + "\n\tmessage=" + message
                + "\n\trequestStatus=" + requestStatus
                + "\n\tuserName=" + userName
                + "\n";
    }
}

