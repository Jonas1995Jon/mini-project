package com.joans.miniproject.web;

import com.joans.miniproject.entity.Area;
import com.joans.miniproject.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Desc：
 * Author Jonas
 * 2018/10/16 17:14
 */
@RestController
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listarea", method = RequestMethod.GET)
    private Map<String, Object> listArea(){
        Map<String, Object> modeMap = new HashMap<>();
        List<Area> areaList = areaService.queryArea();
        modeMap.put("areaList", areaList);
        return modeMap;
    }

    @RequestMapping(value = "/getareabyid", method = RequestMethod.GET)
    private Map<String, Object> getAreaById(Integer areaId){
        Map<String, Object> modeMap = new HashMap<>();
        Area area = areaService.queryAreaById(areaId);
        modeMap.put("area", area);
        return modeMap;
    }

    @RequestMapping(value = "/addarea", method = RequestMethod.POST)
    private Map<String, Object> addArea(@RequestBody Area area){
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", areaService.insertArea(area));
        return modelMap;
    }

    @RequestMapping(value = "/modifyarea", method = RequestMethod.POST)
    private Map<String, Object> modifyArea(@RequestBody Area area) {
        HashMap<String, Object> modeMap = new HashMap<>();
        //修改区域信息
        modeMap.put("success", areaService.updateArea(area));
        return modeMap;
    }

    @RequestMapping(value = "/removearea", method = RequestMethod.GET)
    private Map<String, Object> removeArea(Integer areaId) {
        Map<String, Object> modeMap = new HashMap<>();
        modeMap.put("success", areaService.deleteArea(areaId));
        return modeMap;
    }

}
