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

    /**
     * 获取所有数据
     * @param illnessInfo
     * @return
     */
    public List<IllnessInfo> findList(IllnessInfo illnessInfo)
    {
        return illnessInfoMapper.findList(illnessInfo);
    }

    /**
     * 获取最新一条数据
     * @return
     */
    public IllnessInfo getLatestOne()
    {
        return illnessInfoMapper.getLatestOne();
    }
}
