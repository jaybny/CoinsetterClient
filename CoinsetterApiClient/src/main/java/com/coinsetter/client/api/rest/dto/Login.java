package com.coinsetter.client.api.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created with IntelliJ IDEA.
 * User: Jay Berg
 * Date: 7/8/13
 * Time: 12:59 PM
 */
public class Login {
    public String username;						//  Client session UUID
    public String password;						//  Message
    public String ipAddress;                    //  Ip address

    public Login(
            @JsonProperty("username") String username,
            @JsonProperty("password") String password,
            @JsonProperty("ipAddress") String ipAddress) {

        this.username = username;
        this.password = password;
        this.ipAddress = ipAddress;
    }
}
