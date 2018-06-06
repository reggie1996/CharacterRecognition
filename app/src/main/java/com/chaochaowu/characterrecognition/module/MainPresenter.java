package com.chaochaowu.characterrecognition.module;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Base64;
import android.util.Log;

import com.chaochaowu.characterrecognition.apiservice.BaiduOCRService;
import com.chaochaowu.characterrecognition.bean.AccessTokenBean;
import com.chaochaowu.characterrecognition.bean.RecognitionResultBean;

import java.io.ByteArrayOutputStream;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author chaochaowu
 * @Description : MainPresenter
 * @class : MainPresenter
 * @time Create at 6/4/2018 4:21 PM
 */


public class MainPresenter implements MainContract.Presenter{

    private MainContract.View mView;
    private BaiduOCRService baiduOCRService;

    private static final String CLIENT_CREDENTIALS = "client_credentials";
    private static final String API_KEY = "G18Mcczi替换自己的API_KEY_CPIjHXZ";
    private static final String SECRET_KEY = "XeMNck替换自己的SECRET_KEY_YAX7rSYSux";
    private static final String ACCESS_TOKEN = "24.d22914a替换自己的ACCESS_TOKENec69126bd2de86.2592000.1530693758.282335-11347860";

    public MainPresenter(MainContract.View mView) {

        this.mView = mView;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://aip.baidubce.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        baiduOCRService = retrofit.create(BaiduOCRService.class);

    }


    @Override
    public void getAccessToken() {

        baiduOCRService.getAccessToken(CLIENT_CREDENTIALS,API_KEY,SECRET_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AccessTokenBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AccessTokenBean accessTokenBean) {
                        Log.e("Access token",accessTokenBean.getAccess_token());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Access token","error");
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void getRecognitionResultByUrl(String url) {

        baiduOCRService.getRecognitionResultByUrl(ACCESS_TOKEN,url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RecognitionResultBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RecognitionResultBean recognitionResultBean) {
                        Log.e("onnext",recognitionResultBean.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("onerror",e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }



    @Override
    public void getRecognitionResultByImage(Bitmap bitmap) {

        String encodeResult = bitmapToString(bitmap);

        baiduOCRService.getRecognitionResultByImage(ACCESS_TOKEN,encodeResult)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RecognitionResultBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RecognitionResultBean recognitionResultBean) {
                        Log.e("onnext",recognitionResultBean.toString());
                        StringBuilder s = new StringBuilder();
                        List<RecognitionResultBean.WordsResultBean> wordsResult = recognitionResultBean.getWords_result();
                        for (RecognitionResultBean.WordsResultBean words:wordsResult) {
                            s.append(words.getWords());
                        }

                        mView.updateUI(s.toString());

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("onerror",e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }



    private String bitmapToString(Bitmap bitmap){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] bytes = baos.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }


}
