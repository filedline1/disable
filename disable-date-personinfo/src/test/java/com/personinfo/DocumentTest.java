package com.personinfo;

import com.alibaba.fastjson.JSON;
import com.personInfo.bean.Requirement;
import com.personInfo.service.RequirementService;
import com.personInfo.util.PageQueryUtil;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class DocumentTest {

    private RestHighLevelClient client;

    @Autowired
    private RequirementService requirementService;

    @Test
    void testAddDocument() throws IOException {
        // 1.查询数据库hotel数据
        Requirement requirement = requirementService.selectByPrimaryKey(1);
        requirement.setAgeRange("18~25");
        // 3.转JSON
        String json = JSON.toJSONString(requirement);

        // 1.准备Request
        IndexRequest request = new IndexRequest("disable-date-requirements").id(requirement.getPersonId().toString());
        // 2.准备请求参数DSL，其实就是文档的JSON字符串
        request.source(json, XContentType.JSON);
        // 3.发送请求
        client.index(request, RequestOptions.DEFAULT);
    }

    @Test
    void testGetDocumentById() throws IOException {
        // 1.准备Request      // GET /disable-date-requirements/_doc/{id}
        GetRequest request = new GetRequest("disable-date-requirements", "8");
        // 2.发送请求
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        // 3.解析响应结果
        String json = response.getSourceAsString();

        Requirement requirement = JSON.parseObject(json, Requirement.class);
        System.out.println("requirement = " + requirement);
    }
//
    @Test
    void testDeleteDocumentById() throws IOException {
        // 1.准备Request      // DELETE /disable-date-requirements/_doc/{id}
        DeleteRequest request = new DeleteRequest("disable-date-requirements", "1");
        // 2.发送请求
        client.delete(request, RequestOptions.DEFAULT);
    }
//
    @Test
    void testUpdateById() throws IOException {
        // 1.准备Request
        UpdateRequest request = new UpdateRequest("disable-date-requirements", "1");
        // 2.准备参数
        request.doc(
                "age_range", "18~25"
        );
        // 3.发送请求
        client.update(request, RequestOptions.DEFAULT);
    }
//
    @Test
    void testBulkRequest() throws IOException {
        PageQueryUtil pageQueryUtil = new PageQueryUtil(1,10);
        // 查询所有的酒店数据
        List<Requirement> list = requirementService.findRecordList(pageQueryUtil);

        // 1.准备Request
        BulkRequest request = new BulkRequest();
        // 2.准备参数
        for (Requirement requirement : list) {
            // 2.1.转为RequirementDoc
            // 2.2.转json
            String json = JSON.toJSONString(requirement);
            // 2.3.添加请求
            request.add(new IndexRequest("disable-date-requirements").id(requirement.getPersonId().toString()).source(json, XContentType.JSON));
        }

        // 3.发送请求
        client.bulk(request, RequestOptions.DEFAULT);
    }

    @BeforeEach
    void setUp() {
        client = new RestHighLevelClient(RestClient.builder(
                HttpHost.create("http://120.26.7.136:9200")
        ));
    }

    @AfterEach
    void tearDown() throws IOException {
        client.close();
    }



}
