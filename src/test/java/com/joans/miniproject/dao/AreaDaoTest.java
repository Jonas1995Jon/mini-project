package com.joans.miniproject.dao;

import com.joans.miniproject.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.codec.EncodingException;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Desc：
 * Author Jonas
 * 2018/10/16 15:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    public void queryArea() {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(2, areaList.size());
    }

    @Test
    public void queryAreaById() {
        Area area = areaDao.queryAreaById(1);
        assertEquals("东苑", area.getAreaName());
    }

    @Test
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("南苑");
        area.setPriority(1);
        int i = areaDao.insertArea(area);
        assertEquals(1, i);
    }

    @Test
    public void updateArea() {
        Area area = new Area();
        try {
            area.setAreaName("西苑");
            area.setAreaId(1);
            area.setLastEditTime(new Date());
            int i = areaDao.updateArea(area);
            assertEquals(1, i);
        } catch (EncodingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteArea() {
        int i = areaDao.deleteArea(3);
        assertEquals(1, i);
    }
}