package com.personInfo.common;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static com.personInfo.constants.IndexLibaryConstants.*;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/
public class RestClientLibrary {

    @Autowired
    private RestHighLevelClient client;

    /**
     * 创建择偶要求索引库
     * @throws IOException
     */
    public void CreateRequirementsIndex() throws IOException {
        //1.创建Request对象
        CreateIndexRequest request = new CreateIndexRequest("disable-date-requirements");
        //2.准备请求的参数：DSL语句
        request.source(REQUIREMENTS_MAPPING_TEMPLATE, XContentType.JSON);
        //3.发送请求
        client.indices().create(request, RequestOptions.DEFAULT);
    }

    /**
     * 创建个人基本信息索引库
     * @throws IOException
     */
    public void CreateBasicInfoIndex() throws IOException {
        //1.创建Request对象
        CreateIndexRequest request = new CreateIndexRequest("disable-date-basic-info");
        //2.准备请求的参数：DSL语句
        request.source(BASCI_INFO_MAPPING_TEMPLATE, XContentType.JSON);
        //3.发送请求
        client.indices().create(request, RequestOptions.DEFAULT);
    }

    /**
     * 创建个人详细信息索引库
     * @throws IOException
     */
    public void CreateDetailInfoIndex() throws IOException {
        //1.创建Request对象
        CreateIndexRequest request = new CreateIndexRequest("disable-date-basic-info");
        //2.准备请求的参数：DSL语句
        request.source(DETAIL_MAPPING_TEMPLATE, XContentType.JSON);
        //3.发送请求
        client.indices().create(request, RequestOptions.DEFAULT);
    }

    /**
     * 创建用户登录信息索引库
     * @throws IOException
     */
    public void CreateUserIndex() throws IOException {
        //1.创建Request对象
        CreateIndexRequest request = new CreateIndexRequest("disable-date-basic-info");
        //2.准备请求的参数：DSL语句
        request.source(USER_MAPPING_TEMPLATE, XContentType.JSON);
        //3.发送请求
        client.indices().create(request, RequestOptions.DEFAULT);
    }

    /**
     * 创建粉丝信息索引库
     * @throws IOException
     */
    public void CreateFanIndex() throws IOException {
        //1.创建Request对象
        CreateIndexRequest request = new CreateIndexRequest("disable-date-basic-info");
        //2.准备请求的参数：DSL语句
        request.source(FANS_MAPPING_TEMPLATE, XContentType.JSON);
        //3.发送请求
        client.indices().create(request, RequestOptions.DEFAULT);
    }

    /**
     * 创建关注信息索引库
     * @throws IOException
     */
    public void CreateFollowIndex() throws IOException {
        //1.创建Request对象
        CreateIndexRequest request = new CreateIndexRequest("disable-date-basic-info");
        //2.准备请求的参数：DSL语句
        request.source(FOLLOW_MAPPING_TEMPLATE, XContentType.JSON);
        //3.发送请求
        client.indices().create(request, RequestOptions.DEFAULT);
    }

}
