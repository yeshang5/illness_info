package com.bh.illnessinfo.service;

import com.bh.illnessinfo.entity.IllnessInfo;
import com.bh.illnessinfo.mapper.IllnessInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IllnessInfoService {

    @Autowired
    private IllnessInfoMapper illnessInfoMapper;

    public void save(IllnessInfo illnessInfo)
    {
        illnessInfoMapper.insert(illnessInfo);
    }

    public void delete(String id)
    {
        illnessInfoMapper.delete(id);
    }

    public List<IllnessInfo> findList(IllnessInfo illnessInfo)
    {
        return illnessInfoMapper.findList(illnessInfo);
    }
}
