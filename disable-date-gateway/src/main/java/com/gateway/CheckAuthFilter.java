package com.gateway;

import com.gateway.bean.User;
import com.gateway.service.UserService;
import com.gateway.util.GetUserFromRedisUtil;
import com.gateway.util.JsonUtil;
import com.gateway.util.ResultGenerator;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.PathContainer;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Mr.Jiang
 * @version 1.0
 **/

@Slf4j
@Component
public class CheckAuthFilter implements GlobalFilter {


    @Autowired
    UserService userService;

    @Autowired
    private GetUserFromRedisUtil userUtil;

    private static final List<String> NO_FILTER_PATHS = new ArrayList<>();
    static {
        NO_FILTER_PATHS.add("/user/login");    //用户登录
    }

    @SneakyThrows
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //校验请求头中的token
        List<String> authorization = exchange.getRequest().getHeaders().get("Authorization");
        String token = authorization != null ? authorization.get(0) : "";

        //获取请求地址
        PathContainer pathContainer = exchange.getRequest().getPath().pathWithinApplication();
        String path = pathContainer.toString();
        if (NO_FILTER_PATHS.contains(path)){
            // 无需限制的地址,继续执行
            return chain.filter(exchange);
        }

        log.info(exchange.getRequest().getPath().value());
        log.info("token:" + token);
        User userFromRedis = new User();
        try {
            userFromRedis = userUtil.getUserFromRedis(token);
            //System.out.println("userFromRedis:" + userFromRedis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer userId = userFromRedis.getUserId();
        User userCheck = userService.selectByPrimaryKey(userId);
        //System.out.println("userCheck:" + userCheck);
        if (userCheck.equals(userFromRedis)){
            return chain.filter(exchange);
        } else {
            return exchange.getResponse().writeWith(Flux.just(exchange.getResponse().
                    bufferFactory().wrap(JsonUtil.objToJson(ResultGenerator.genErrorResult(500,"抱歉，请登录后再使用功能！")).getBytes())));
        }
//        if (token.equals("13212313")){
//            return chain.filter(exchange);
//        } else {
//            return null;
//        }
    }
}
