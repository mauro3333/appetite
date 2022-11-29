package com.appetite.appetite.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.appetite.appetite.entity.OrderDetail;


public interface iOrderDetailRepository  extends JpaRepository<OrderDetail, Long> {
    
    @Override
    public List<OrderDetail> findAll();
}
