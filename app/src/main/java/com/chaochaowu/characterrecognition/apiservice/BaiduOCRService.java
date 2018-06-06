package com.chaochaowu.characterrecognition.apiservice;

import com.chaochaowu.characterrecognition.bean.AccessTokenBean;
import com.chaochaowu.characterrecognition.bean.RecognitionResultBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author chaochaowu
 * @Description : retrofit定义网络请求部分
 * @class : BaiduOCRService
 * @time Create at 6/4/2018 4:24 PM
 */


public interface BaiduOCRService {

    /**
     * 获取百度api的 access token
     * @param grantType 固定参数为client_credentials
     * @param clientId 应用的API Key
     * @param clientSecret 应用的Secret Key
     * @return observable对象用于rxjava,从AccessTokenBean中可以获得服务器返回的access token
     */
    @POST("oauth/2.0/token")
    Observable<AccessTokenBean> getAccessToken(@Query("grant_type") String grantType, @Query("client_id") String clientId, @Query("client_secret") String clientSecret);

    /**
     * 通过图片URL的形式，获取图片内的文字信息
     * @param accessToken 通过API Key和Secret Key获取的access_token
     * @param url 图片的url
     * @return observable对象用于rxjava,从RecognitionResultBean中可以获得图片文字识别的信息
     */
    @POST("rest/2.0/ocr/v1/general_basic")
    @FormUrlEncoded
    Observable<RecognitionResultBean> getRecognitionResultByUrl(@Field("access_token") String accessToken, @Field("url") String url);

    /**
     * 通过图片，获取图片内的文字信息
     * @param accessToken 通过API Key和Secret Key获取的access_token
     * @param image 图像数据base64编码后进行urlencode后的String
     * @return  observable对象用于rxjava,从RecognitionResultBean中可以获得图片文字识别的信息
     */
    @POST("rest/2.0/ocr/v1/general_basic")
    @FormUrlEncoded
    Observable<RecognitionResultBean> getRecognitionResultByImage(@Field("access_token") String accessToken, @Field("image") String image);

}
