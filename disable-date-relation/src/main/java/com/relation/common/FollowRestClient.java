package com.relation.common;

import com.alibaba.fastjson.JSON;
import com.relation.bean.Follow;
import com.relation.service.FanService;
import com.relation.service.FollowService;
import com.relation.utils.PageQueryUtil;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
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
public class FollowRestClient {

    @Autowired
    private RestHighLevelClient client;

    @Autowired
    FanService fanService;

    @Autowired
    FollowService followService;


    /**
     * 根据userId搜索指定用户的关注记录
     * @param userId
     * @return
     * @throws IOException
     */
    public List<Follow> MatchFollowsByPersonId(Integer userId) throws IOException {
        // 1.准备request
        SearchRequest request = new SearchRequest("disable-date-follow");
        // 2.准备请求参数
        request.source().query(QueryBuilders.termQuery("userId", userId.toString()));
        // 3.发送请求，得到响应
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        // 4.结果解析
        List<Follow> follows = handleFollowResponse(response);
        return follows;
    }

    public long getFollowCountByUserId(Integer userId) throws IOException{
        // 1.准备request
        SearchRequest request = new SearchRequest("disable-date-follow");
        // 2.准备请求参数
        request.source().query(QueryBuilders.termQuery("userId", userId.toString()));
        // 3.发送请求，得到响应
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        // 4.结果解析
        long count = handleFollowCount(response);
        return count;
    }

    /**
     * 从索引库中搜索分页记录
     * @param pageUtil
     * @return
     */
    public List<Follow> findRecordListFromIndex(PageQueryUtil pageUtil) {
        try {
            // 1.准备Request
            SearchRequest request = new SearchRequest("disable-date-follow");
            // 2.准备请求参数
            int page = pageUtil.getPage();
            int size = pageUtil.getLimit();
            request.source().from((page - 1) * size).size(size);
            // 3.发送请求
            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
            // 4.解析响应
            return handleFollowResponse(response);
        } catch (IOException e) {
            throw new RuntimeException("搜索数据失败", e);
        }
    }

    /**
     * 根据id将新增的关注记录加入到索引库中
     * @param id
     * @throws IOException
     * @return 返回1 表示成功
     */
    public int InsertFollowToIndexById(Integer id) throws IOException {
        // 1.查询数据库数据
        Follow follow = followService.selectFollowById(id);
        // 3.转JSON
        String json = JSON.toJSONString(follow);
        // 1.准备Request
        IndexRequest request = new IndexRequest("disable-date-follow").id(follow.getId().toString());
        // 2.准备请求参数DSL，其实就是文档的JSON字符串
        request.source(json, XContentType.JSON);
        // 3.发送请求
        client.index(request, RequestOptions.DEFAULT);
        return 1;
    }

    /**
     * 根据id将要删除的关注记录从索引库中删除
     * @param userId
     * @return 返回1 表示成功
     */
    public long deleteByUserId(Integer userId) {
        try {
            //1. 准备Request
            DeleteByQueryRequest request = new DeleteByQueryRequest("disable-date-follow");
            //2. 根据条件生成boolQueryBuilder
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
            boolQueryBuilder.must(QueryBuilders.matchQuery("userId",userId));
            request.setQuery(boolQueryBuilder);
            DeleteRequest deleteRequest = new DeleteRequest("disable-date-follow");
            BulkByScrollResponse bulkResponse = client.deleteByQuery(request,RequestOptions.DEFAULT);
            //发送请求
            return bulkResponse.getDeleted();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private long handleFollowCount(SearchResponse response) {
        SearchHits searchHits = response.getHits();
        long total = searchHits.getTotalHits().value;
        return total;
    }

    private List<Follow> handleFollowResponse(SearchResponse response) {
        SearchHits searchHits = response.getHits();
        // 4.1.总条数
        long total = searchHits.getTotalHits().value;
        // 4.2.获取文档数组
        SearchHit[] hits = searchHits.getHits();
        // 4.3.遍历
        List<Follow> list = new ArrayList<>();
        for (SearchHit hit : hits) {
            try{
                // 4.4.获取source
                String json = hit.getSourceAsString();
                // 4.5.反序列化
                Follow follow = JSON.parseObject(json, Follow.class);
                // 4.6.处理结果
                list.add(follow);
            } catch (Exception e){
                return null;
            }
        }
        return list;
    }

    private Follow handleOneObject(SearchResponse response) {
        SearchHits searchHits = response.getHits();
        // 4.1.获取文档数组
        SearchHit[] hits = searchHits.getHits();
        try {
            // 4.2 获取json结果
            String json = hits[0].getSourceAsString();
            // 4.3 将json结果转换成指定对象返回
            Follow follow = JSON.parseObject(json,Follow.class);
            return follow;
        }  catch (Exception e){
            return null;
        }

    }

}
