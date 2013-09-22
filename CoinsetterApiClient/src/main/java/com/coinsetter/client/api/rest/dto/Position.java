package com.coinsetter.client.api.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: Jay Berg
 * Date: 7/8/13
 * Time: 2:25 AM
 */

public class Position {

    public String customerUuid;				//  Customer UUID
    public String accountUuid;				//  Account UUID
    public BigDecimal mtm;                  //  Marked to Market
    public BigDecimal mtmPl;                //  Marked to Marked PnL
    public String side;						//  Side
    public String symbol;					//  Symbol
    public BigDecimal quantity;				//  Commission paid
    public BigDecimal vwap;				    //  Cost basis

    public Position(
            @JsonProperty("symbol") String symbol,
            @JsonProperty("customerUuid") String customerUuid,
            @JsonProperty("accountUuid") String accountUuid,
            @JsonProperty("quantity") BigDecimal quantity,
            @JsonProperty("side") String side,
            @JsonProperty("vwap") BigDecimal vwap,
            @JsonProperty("mtm") BigDecimal mtm,
            @JsonProperty("mtmPl") BigDecimal mtmPl
    ) {

        this.symbol = symbol;
        this.accountUuid = accountUuid;
        this.customerUuid = customerUuid;
        this.quantity = quantity;
        this.side = side;
        this.vwap = vwap;
        this.mtm = mtm;
        this.mtmPl = mtmPl;
    }

    @Override
    public String toString() {
        return "\n\tPosition:"
                + "\n\t\tsymbol=" + symbol
                + "\n\t\tside=" + side
                + "\n\t\tquantity=" + quantity
                + "\n\t\tvwap=" + vwap
                + "\n\t\tmtm=" + mtm
                + "\n\t\tmtmPl=" + mtmPl
                + "\n\t\tcustomerUuid=" + customerUuid
                + "\n\t\taccountUuid=" + accountUuid
                + "\n";
    }
}

