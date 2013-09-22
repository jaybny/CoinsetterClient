package com.coinsetter.client.api.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: Jay Berg
 * Date: 7/8/13
 * Time: 2:25 AM
 */
public class Account {
    public String accountUuid;
    public String customerUuid;
    public String accountNumber;
    public String denomination;
    public String name;
    public String description;
    public String accountBalance;
    public String accountClass;
    public String activeStatus;
    public BigDecimal approvedMarginRatio;
    public String createDate;
    public BigDecimal marginBalance;
    public BigDecimal marginUsed;
    public BigDecimal mtm;
    public BigDecimal mtmPl;
    public boolean sellShortPermitted;

    public Account(
            @JsonProperty("accountUuid") String accountUuid,
            @JsonProperty("customerUuid") String customerUuid,
            @JsonProperty("accountNumber") String accountNumber,
            @JsonProperty("denomination") String denomination,
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("accountBalance") String accountBalance,
            @JsonProperty("accountClass") String accountClass,
            @JsonProperty("approvedMarginRatio") BigDecimal approvedMarginRatio,
            @JsonProperty("createDate") String createDate,
            @JsonProperty("marginBalance") BigDecimal marginBalance,
            @JsonProperty("marginUsed") BigDecimal marginUsed,
            @JsonProperty("mtm") BigDecimal mtm,
            @JsonProperty("mtmPl") BigDecimal mtmPl,
            @JsonProperty("sellShortPermitted") boolean sellShortPermitted) {

        this.customerUuid = customerUuid;
        this.accountUuid = accountUuid;
        this.accountNumber = accountNumber;
        this.denomination = denomination;
        this.name = name;
        this.description = description;
        this.accountBalance = accountBalance;
        this.accountClass = accountClass;
        this.approvedMarginRatio = approvedMarginRatio;
        this.createDate = createDate;
        this.marginBalance = marginBalance;
        this.marginUsed = marginUsed;
        this.mtm = mtm;
        this.mtmPl = mtmPl;
        this.sellShortPermitted = sellShortPermitted;
    }

    @Override
    public String toString() {
        return "\n\tAccount:"
                + "\n\t\tcustomerUuid=" + customerUuid
                + "\n\t\taccountUuid=" + accountUuid
                + "\n\t\taccountNumber=" + accountNumber
                + "\n\t\tdenomination=" + denomination
                + "\n\t\tname=" + name
                + "\n\t\tdescription=" + description
                + "\n\t\taccountBalance=" + accountBalance
                + "\n\t\taccountClass=" + accountClass
                + "\n\t\tapprovedMarginRatio=" + approvedMarginRatio
                + "\n\t\tcreateDate=" + createDate
                + "\n\t\tmarginBalance=" + marginBalance
                + "\n\t\tmarginUsed=" + marginUsed
                + "\n\t\tmtm=" + mtm
                + "\n\t\tmtmPl=" + mtmPl
                + "\n\t\tsellShortPermitted=" + sellShortPermitted
                + "\n";
    }
}

