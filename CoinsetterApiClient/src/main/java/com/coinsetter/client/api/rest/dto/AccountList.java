package com.coinsetter.client.api.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: jay
 * Date: 7/10/13
 * Time: 12:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class AccountList {
    public Account[] accountList;

    public AccountList( @JsonProperty("accountList") Account[] accountList) {
        this.accountList = accountList;

    }

    @Override
    public String toString() {

        return "\nAccountList:"
                + "\n\taccountList=" + Arrays.toString(accountList)
                + "\n";
    }
}
