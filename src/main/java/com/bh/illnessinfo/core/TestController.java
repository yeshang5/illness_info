package com.bh.illnessinfo.core;

import com.bh.illnessinfo.entity.IllnessInfo;
import com.bh.illnessinfo.service.IllnessInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private IllnessInfoService illnessInfoService;

    @GetMapping("test")
    public IllnessInfo test(HttpServletRequest request)
    {
        IllnessInfo illnessInfo=new IllnessInfo();
        try {

            illnessInfo=illnessInfoService.getLatestOne();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return illnessInfo;
    }
}
