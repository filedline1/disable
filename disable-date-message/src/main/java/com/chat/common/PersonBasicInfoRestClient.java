package com.chat.common;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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


    public List<Userinfo> getRecommendList(Integer personId) throws Exception{
        PersonBasicInfoDoc personBasicInfoDoc = MatchByPersonId(personId);
        Integer age = personBasicInfoDoc.getAge();
        Integer minAge = age - 3;
        Integer maxAge = age + 3;
        System.out.println(personBasicInfoDoc);
        String location = personBasicInfoDoc.getLocation();
        final String[] split = location.split(", ");
        Double lat = Double.parseDouble(split[0]);
        Double lon = Double.parseDouble(split[1]);
//        System.out.println("lat:" + lat);
//        System.out.println("lon:" + lon);
        // 1.准备request
        SearchRequest request = new SearchRequest("disable-date-basic-info");
        // 2.准备请求参数
        if (location != null){
            request.source().query(QueryBuilders.boolQuery()
                    .must(QueryBuilders.rangeQuery("age").gte(minAge).lte(maxAge))
                    .filter(QueryBuilders.geoDistanceQuery("location").
                            distance("15",DistanceUnit.KILOMETERS).point(lat,lon)));
        }
        // 3.发送请求，得到响应
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        // 4.结果解析
        List<PersonBasicInfoDoc> personBasicInfoDocs = handleResponse(response);
        List<Userinfo> userInfos = new ArrayList<>();
        for (PersonBasicInfoDoc personBasicInfoDoc1 : personBasicInfoDocs){
            if (personBasicInfoDoc1.getPersonId() == personBasicInfoDoc.getPersonId()){
                continue;
            }
            Userinfo userinfo = new Userinfo();
            userinfo.setUserid(personBasicInfoDoc1.getPersonId().toString());
            userinfo.setNickname(personBasicInfoDoc1.getPersonName());
            userinfo.setUsign(personBasicInfoDoc1.getPersonSign());
            userInfos.add(userinfo);
        }
        return userInfos;
    }


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
