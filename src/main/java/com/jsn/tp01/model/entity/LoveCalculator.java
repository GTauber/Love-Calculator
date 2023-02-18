package com.jsn.tp01.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fname",
    "sname",
    "percentage",
    "result"
})
@Data
@Builder
public class LoveCalculator {

    @JsonProperty("fname")
    public String fname;
    @JsonProperty("sname")
    public String sname;
    @JsonProperty("percentage")
    public Long percentage;
    @JsonProperty("result")
    public String result;

}