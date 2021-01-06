package com.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "payment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    private Long id;
    private Long orderId;
    private Double price;
    private Integer paymentStatus;
    private String createUser;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
