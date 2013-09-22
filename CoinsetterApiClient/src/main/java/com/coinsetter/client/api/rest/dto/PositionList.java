package com.coinsetter.client.api.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Jay Berg
 * Date: 7/10/13
 * Time: 12:19 PM
 */
public class PositionList {
    public Position[] positionList;

    public PositionList( @JsonProperty("positionList") Position[] positionList) {
        this.positionList = positionList;
     }

    @Override
    public String toString() {

        return "\nPositionList:"
                + "\n\tpositionList=" + Arrays.toString(positionList)
                + "\n";
    }
}
