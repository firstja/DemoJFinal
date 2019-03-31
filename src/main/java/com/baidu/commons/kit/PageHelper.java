package com.baidu.commons.kit;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者:shaoQW
 * 创建日期:2019-03-28 22:13
 * 修改日期:
 * description:
 **/
public class PageHelper<T> {
    private Integer code=0;  //默认值  0
    private String msg="";   //提示信息  默认空
    private Integer count;  //总记录数
    private List<T> data = new ArrayList<>();  //查询到的分页数据

    public PageHelper(){}

    public PageHelper(List<T> data,Integer count){
        this.data=data;
        this.count=count;
    }

    public PageHelper(Integer code, String msg, Integer count, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCount() {
        return count;
    }

    public List<T> getData() {
        return data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setData(List<T> data) {
        this.data = data;
    }



}
