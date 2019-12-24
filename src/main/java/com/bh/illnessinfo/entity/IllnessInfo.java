package com.bh.illnessinfo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class IllnessInfo {
    private String id;              //id
    private Integer illId;          //病情记录id号，用于爬取网站病情信息
    private Integer age;            //病人年龄
    private String sex;              //病人性别
    private String title;          //标题
    private String illDetail;       //病人描述病情
    private String doctorAnswer;    //医生回答
    private Date time;

    private Date beginTime;
    private Date endTime;

}
