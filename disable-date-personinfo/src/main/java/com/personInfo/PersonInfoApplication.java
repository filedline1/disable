package com.personInfo;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/


import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PersonInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonInfoApplication.class, args);
    }

    @Bean
    public RestHighLevelClient client(){
        return new RestHighLevelClient(RestClient.builder(
                HttpHost.create("http://120.26.7.136:9200")
        ));
    }

}
