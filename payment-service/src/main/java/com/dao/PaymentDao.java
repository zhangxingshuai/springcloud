package com.dao;

import com.entity.Payment;
import org.apache.ibatis.annotations.Select;

public interface PaymentDao {
    @Select("select * from payment where id = #{id}")
    Payment selectById(Integer id);
}
