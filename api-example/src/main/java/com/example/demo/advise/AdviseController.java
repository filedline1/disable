package com.example.demo.advise;

import com.example.demo.common.response.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * todo catch controller 异常
 *
 * @author Chunming Liu In 2022/07/28
 */
@RestControllerAdvice
public class AdviseController {

    @ExceptionHandler(value = IllegalStateException.class)
    public JsonResult<String> handleIllegalStateException(IllegalStateException e) {
        return JsonResult.error(e.getMessage());
    }
}
