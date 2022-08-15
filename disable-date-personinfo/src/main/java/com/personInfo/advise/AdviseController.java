package com.personInfo.advise;

import com.personInfo.common.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

/**
 * todo catch controller 异常
 *
 * @author Chunming Liu In 2022/07/28
 */
@RestControllerAdvice
public class AdviseController {

    @ExceptionHandler(value = IllegalStateException.class)
    public JsonResult<String> handleIllegalStateException(IllegalStateException e) {
        return JsonResult.error ( e.getMessage () );
    }

    @ExceptionHandler(value = RestClientException.class)
    public JsonResult<String> handleRestClientException(RestClientException e) {
        return JsonResult.error ( e.getMessage () );
    }
}
