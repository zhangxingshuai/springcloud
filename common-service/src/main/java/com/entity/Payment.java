package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private Long id;
    private Long orderId;
    private Double price;
    private Integer paymentStatus;
    private String createUser;
    private Date createTime;


}
