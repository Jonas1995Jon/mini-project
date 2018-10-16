package com.joans.miniproject.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Desc：
 * Author Jonas
 * 2018/10/16 17:58
 */
@ControllerAdvice
public class GlobalExceptionHanler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Map<String, Object> exceptionHandler(HttpServletRequest request, Exception e) {
        Map<String, Object> modeMap = new HashMap<>();
        modeMap.put("success", false);
        modeMap.put("errMsg", e.getMessage());
        return modeMap;
    }

}
