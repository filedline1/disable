package com.personInfo.common;

import com.alibaba.fastjson.JSON;
import com.personInfo.bean.PersonBasicInfo;
import com.personInfo.service.PersonBasicInfoService;
import com.personInfo.util.PageQueryUtil;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/
@Service
public class PersonBasicInfoRestClient {

    @Autowired
    private RestHighLevelClient client;

    @Autowired
    PersonBasicInfoService personBasicInfoService;

    public void MatchAll() throws IOException {
        // 1.准备request
        SearchRequest request = new SearchRequest("disable-date-basic-info");
        // 2.准备请求参数
        request.source().query(QueryBuilders.matchAllQuery());
        // 3.发送请求，得到响应
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        // 4.结果解析
        handleResponse(response);
    }

    public List<PersonBasicInfoDoc> selectByPersonIds(List<Integer> personIds) throws Exception{
        //1.准备request
        SearchRequest request = new SearchRequest("disable-date-basic-info");
        // 2.准备请求参数
        request.source().query(QueryBuilders.termsQuery("personId",personIds));
        // 3.发送请求，得到响应
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        // 4.结果解析
        List<PersonBasicInfoDoc> personBasicInfoDocs = handleResponse(response);
        return personBasicInfoDocs;
    }



    /**
     * 根据personId搜索指定用户的择偶要求
     * @param personId
     * @return
     * @throws IOException
     */
    public PersonBasicInfoDoc MatchByPersonId(Integer personId) throws IOException {
        // 1.准备request
        SearchRequest request = new SearchRequest("disable-date-basic-info");
        // 2.准备请求参数
        request.source().query(QueryBuilders.termQuery("personId", personId.toString()));
        // 3.发送请求，得到响应
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        // 4.结果解析
        final PersonBasicInfoDoc personBasicInfo = handleOneObject(response);
        return personBasicInfo;
    }

    /**
     * 从索引库中搜索分页记录
     * @param pageUtil
     * @return
     */
    public List<PersonBasicInfoDoc> findRecordListFromIndex(PageQueryUtil pageUtil) {
        try {
            // 1.准备Request
            SearchRequest request = new SearchRequest("disable-date-basic-info");
            // 2.准备请求参数
            int page = pageUtil.getPage();
            int size = pageUtil.getLimit();
            request.source().from((page - 1) * size).size(size);
            // 3.发送请求
            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
            // 4.解析响应
            return handleResponse(response);
        } catch (IOException e) {
            throw new RuntimeException("搜索数据失败", e);
        }
    }

    /**
     * 根据personId将新增的person加入到索引库中
     * @param personId
     * @throws IOException
     * @return 返回1 表示成功
     */
    public int InsertPersonBasicInfoToIndexByPersonId(Integer personId) throws IOException {
        // 1.查询数据库数据
        PersonBasicInfo personBasicInfo = personBasicInfoService.selectByPrimaryKey(personId);
        // 2.转成Doc类型
        PersonBasicInfoDoc personBasicInfoDoc = new PersonBasicInfoDoc(personBasicInfo);
        // 3.转JSON
        String json = JSON.toJSONString(personBasicInfoDoc);
        // 1.准备Request
        IndexRequest request = new IndexRequest("disable-date-basic-info").id(personBasicInfoDoc.getPersonId().toString());
        // 2.准备请求参数DSL，其实就是文档的JSON字符串
        request.source(json, XContentType.JSON);
        // 3.发送请求
        client.index(request, RequestOptions.DEFAULT);
        return 1;
    }

    /**
     * 根据personId将要删除的Requirement从索引库中删除
     * @param personId
     * @return 返回1 表示成功
     */
    public int deletePersonBasicInfoFromIndexById(Integer personId) {
        try {
            //1. 准备Request
            DeleteRequest request = new DeleteRequest("disable-date-basic-info",personId.toString());
            //发送请求
            client.delete(request,RequestOptions.DEFAULT);
            return 1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<PersonBasicInfoDoc> handleResponse(SearchResponse response) {
        SearchHits searchHits = response.getHits();
        // 4.1.总条数
        long total = searchHits.getTotalHits().value;
        // 4.2.获取文档数组
        SearchHit[] hits = searchHits.getHits();
        // 4.3.遍历
        List<PersonBasicInfoDoc> list = new ArrayList<>();
        for (SearchHit hit : hits) {
            try {
                // 4.4.获取source
                String json = hit.getSourceAsString();
                // 4.5.反序列化，非高亮的
                PersonBasicInfoDoc personBasicInfoDoc = JSON.parseObject(json, PersonBasicInfoDoc.class);
                // 4.6.处理结果
                list.add(personBasicInfoDoc);
            } catch (Exception e){
                return null;
            }
        }
        return list;
    }

    private PersonBasicInfoDoc handleOneObject(SearchResponse response) {
        SearchHits searchHits = response.getHits();
        // 4.1.获取文档数组
        SearchHit[] hits = searchHits.getHits();
        try {
            // 4.2 获取json结果
            String json = hits[0].getSourceAsString();
            // 4.3 将json结果转换成指定对象返回
            PersonBasicInfoDoc personBasicInfoDoc = JSON.parseObject(json,PersonBasicInfoDoc.class);
            return personBasicInfoDoc;
        } catch (Exception e){
            return null;
        }

    }

}
