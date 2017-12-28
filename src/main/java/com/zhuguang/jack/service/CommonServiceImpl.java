package com.zhuguang.jack.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhuguang.jack.bean.ConsultContent;
import com.zhuguang.jack.dao.CommonMapper;

@Service
public class CommonServiceImpl implements CommonService {
    
    @Autowired
    CommonMapper mapper;
    
    public List<ConsultContent> queryContent() {
        return mapper.queryContent(new HashMap());
    }
    
}
