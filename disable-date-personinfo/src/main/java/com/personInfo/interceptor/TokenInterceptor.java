package com.personInfo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
*   身份验证，没有验证的被拦截
* */
//@Component
public class TokenInterceptor{ //implements HandlerInterceptor {



    /**
     * @Description 拦截方法，在执行controller之前进行拦截
     * @param request
     * @param response
     * @param handler
     * @return boolean
     **/
//    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

       /* //获取请求头的令牌
        String token = request.getHeader("token");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            JWTUtil.verify(token);
            return true;
        } catch (SignatureVerificationException e) {
         //   response.getWriter().print(ApiResultHandler.buildApiResult(400,"签名验证异常",null));
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        response.getWriter().print("请登录账号！");
        return false;*/
        return true;
    }


}
