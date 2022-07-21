package com.chat.util.exception;// ...
import com.chat.util.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

/**
 * 统一异常处理器
 * */

@ControllerAdvice
public class GlobalExceptionHandler {

    /**-------- 通用异常处理方法 --------**/
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.error();    // 通用异常结果
    }

    /**-------- 指定异常处理方法 --------**/
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Result error(NullPointerException e) {
        e.printStackTrace();
        return Result.setResult(ResultCodeEnum.NULL_POINT);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseBody
    public Result error(IndexOutOfBoundsException e) {
        e.printStackTrace();
        return Result.setResult(ResultCodeEnum.HTTP_CLIENT_ERROR);
    }

    /**-------- 自定义定异常处理方法 --------**/
    @ExceptionHandler(CMSException.class)
    @ResponseBody
    public Result error(CMSException e) {
        e.printStackTrace();
        return Result.error().message(e.getMessage()).code(e.getCode());
    }
}