package com.example.demo.service.impl;

import com.example.demo.dao.PointMapper;
import com.example.demo.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PointServiceImpl implements PointService {

    @Autowired
    private PointMapper pointMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public int insert(Long uid, Long num) {
        pointMapper.insert(uid, num);
        return 0;
    }

}
