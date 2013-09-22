package com.coinsetter.client.api.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created with IntelliJ IDEA.
 * User: jay Berg
 * Date: 7/8/13
 * Time: 2:25 AM
 */
 public class Customer {
    public String uuid;
    public String username;
    public String activeStatus;
    public String createDate;
    public String customerAgreement;
    public String dob;
    public String email;
    public String firstName;
    public String middleName;
    public String lastName;
    public String marginAgreement;
    public boolean sellShortPermitted;
    public String lastModifiedDate;

    public Customer(
            @JsonProperty("uuid") String uuid,
            @JsonProperty("username") String username,
            @JsonProperty("activeStatus") String activestatus,
            @JsonProperty("createDate") String createDate,
            @JsonProperty("customerAgreement") String customerAgreement,
            @JsonProperty("dob") String dob,
            @JsonProperty("email") String email,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("middleName") String middleName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("marginAgreement") String marginAgreement,
            @JsonProperty("sellShortPermitted") boolean sellShortPermitted,
            @JsonProperty("lastModifiedDate") String lastModifiedDate) {

        this.uuid = uuid;
        this.username = username;
        this.activeStatus = activestatus;
        this.createDate = createDate;
        this.customerAgreement = customerAgreement;
        this.dob = dob;
        this.email = email;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.marginAgreement = marginAgreement;
        this.sellShortPermitted = sellShortPermitted;
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public String toString() {
        return "\nCustomer:"
                + "\n\tuuid=" + uuid
                + "\n\tusername=" + username
                + "\n\tactiveStatus=" + activeStatus
                + "\n\tcreateDate=" + createDate
                + "\n\tcustomerAgreement=" + customerAgreement
                + "\n\tdob=" + dob
                + "\n\temail=" + email
                + "\n\tfirstName=" + firstName
                + "\n\tmiddleName=" + middleName
                + "\n\tlastName=" + lastName
                + "\n\tmarginAgreement=" + marginAgreement
                + "\n\tsellShortPermitted=" + sellShortPermitted
                + "\n\tlastModifiedDate=" + lastModifiedDate
                + "\n";
    }
}

