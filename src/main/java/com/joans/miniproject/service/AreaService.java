package com.joans.miniproject.service;

import com.joans.miniproject.entity.Area;

import java.util.List;

/**
 * Desc：
 * Author Jonas
 * 2018/10/16 16:51
 */
public interface AreaService {

    /**
     * 列出区域列表
     * @return
     */
    List<Area> queryArea();

    /**
     * 根据Id列出具体区域
     * @param areaId
     * @return
     */
    Area queryAreaById(int areaId);

    /**
     * 插入区域信息
     * @param area
     * @return
     */
    boolean insertArea(Area area);

    /**
     * 更新区域信息
     * @param area
     * @return
     */
    boolean updateArea(Area area);

    /**
     * 删除区域信息
     * @param areaId
     * @return
     */
    boolean deleteArea(int areaId);

}
