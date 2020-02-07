package com.zhuguang.jack.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhuguang.jack.bean.ConsultConfigArea;
import com.zhuguang.jack.service.AreaService;

@Controller
public class JackController {
    
    private static final Logger logger = LoggerFactory.getLogger(JackController.class);
    
    @Autowired
    AreaService areaService;
    
    @Value("${application.field:default value jack}")
    private String zhuguangField = "";
    
    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("time", new Date());
        mv.addObject("message", zhuguangField);
        return mv;
    }
    
    @RequestMapping("/freemarker")
    public String freemarker(Map<String, Object> map) {
        
        map.put("name", "zhuguang jack");
        map.put("gender", 0);
        
        List<Map<String, Object>> friends = new ArrayList<Map<String, Object>>();
        Map<String, Object> friend = new HashMap<String, Object>();
        friend.put("name", "roy");
        friend.put("age", 32);
        friends.add(friend);
        friend = new HashMap<String, Object>();
        friend.put("name", "walker");
        friend.put("age", 34);
        friends.add(friend);
        map.put("friends", friends);
        return "freemarker";
    }
    
    @RequestMapping("/queryArea")
    public @ResponseBody String queryArea(String param) {
        List<ConsultConfigArea> areas = areaService.qryArea(new HashMap());
        for (ConsultConfigArea area : areas) {
            logger.info(area.getAreaCode() + "   " + area.getAreaName() + "   "
                    + area.getState());
        }
        return "OK";
    }
}
