package com.joans.miniproject.service.impl;

import com.joans.miniproject.dao.AreaDao;
import com.joans.miniproject.entity.Area;
import com.joans.miniproject.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Desc：
 * Author Jonas
 * 2018/10/16 16:52
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> queryArea() {
        return areaDao.queryArea();
    }

    @Override
    public Area queryAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Transactional
    @Override
    public boolean insertArea(Area area) {
        if(area.getAreaName() != null && !"".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int effectedNum = areaDao.insertArea(area);
                if (effectedNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("插入区域信息失败!");
                }
            }catch (Exception e){
                throw new RuntimeException("插入区域信息失败：" + e.getMessage());
            }
        }else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean updateArea(Area area) {
        //空值判断，主要是areaId不为空
        if(area.getAreaId() != null && !"".equals(area.getAreaId())){
            //设置默认值
            area.setLastEditTime(new Date());
            try {
                //更新区域信息
                int effectedNum = areaDao.updateArea(area);
                if(effectedNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("更新区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("更新区域信息失败：" + e.toString());
            }
        }else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if(areaId > 0){
            try {
                //删除区域信息
                int effectedNum = areaDao.deleteArea(areaId);
                if(effectedNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("删除区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("删除区域信息失败：" + e.toString());
            }
        }else {
            throw new RuntimeException("区域ID必须大于0！");
        }
    }
}