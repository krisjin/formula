package org.masksalt.lambda.domain;


import lombok.Getter;
import lombok.Setter;

/**
 * User:shijingui
 * Date:2018/12/30
 *  
 */
@Getter
@Setter
public class OrderDomain {

    private String orderId;
    private String address;
    private String account;
    private double amount;
}
