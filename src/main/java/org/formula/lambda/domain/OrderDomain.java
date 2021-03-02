package org.formula.lambda.domain;


import lombok.Data;

/**
 * User:krisin
 * Date:2018/12/30
 */
@Data
public class OrderDomain {

    private String orderId;
    private String address;
    private String account;
    private double amount;


}
