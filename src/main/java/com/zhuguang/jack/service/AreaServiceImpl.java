package com.zhuguang.jack.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhuguang.jack.bean.ConsultConfigArea;
import com.zhuguang.jack.dao.CommonMapper;
import com.zhuguang.jack.dynamicDataSource.TargetDataSource;

@Service
public class AreaServiceImpl implements AreaService {
    
    @Autowired
    CommonMapper mapper;
    
    public List<ConsultConfigArea> qryAreaFromBase(Map param) {
        // TODO Auto-generated method stub
        return mapper.qryArea(param);
    }
    
    /** 
     *  往期视频加瑶瑶老师QQ：2483034688
     *  Jack老师QQ： 2943489129
     *  时间   ：     2018年6月14日 下午8:49:15 
     *  作者   ：   烛光学院【Jack老师】
     *  
     *  这个方法需要去查询db1
     */
    //    @TargetDataSource(name = "ds2")
    public List<ConsultConfigArea> qryArea(Map param) {
        return mapper.qryArea(param);
    }
    
    @Transactional
    @TargetDataSource(name = "ds1")
    public int saveArea(ConsultConfigArea area) {
        int count = mapper.saveArea(area);
        return count;
    }
    
    @Transactional
    public int saveAreaToBase(ConsultConfigArea area) {
        // TODO Auto-generated method stub
        return mapper.saveArea(area);
    }
    
}
