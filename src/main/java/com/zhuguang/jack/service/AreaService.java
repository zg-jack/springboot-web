package com.zhuguang.jack.service;

import java.util.List;
import java.util.Map;

import com.zhuguang.jack.bean.ConsultConfigArea;

public interface AreaService {
    public List<ConsultConfigArea> qryAreaFromBase(Map param);
    
    public List<ConsultConfigArea> qryArea(Map param);
    
    public int saveArea(ConsultConfigArea area);
    
    public int saveAreaToBase(ConsultConfigArea area);
}
