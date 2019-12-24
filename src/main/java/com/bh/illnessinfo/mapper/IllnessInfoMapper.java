package com.bh.illnessinfo.mapper;

import com.bh.illnessinfo.entity.IllnessInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface IllnessInfoMapper {

    public void insert(IllnessInfo illnessInfo);

    public void update(IllnessInfo illnessInfo);

    public void delete(String id);

    public List<IllnessInfo> findList(IllnessInfo illnessInfo);

    /**
     * 获取最新一条数据
     * @return
     */
    public IllnessInfo getLatestOne();

}
