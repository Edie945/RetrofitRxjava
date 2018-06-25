package com.example.myretrofitrxjava;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    private static RetrofitUtils INSTENCE;
    private Retrofit retrofit;
    private RetrofitUtils(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)//接口
                .addConverterFactory(GsonConverterFactory.create())//默认Gson解析
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//使用RxJava2的适配器
                .build();
    }
    public static RetrofitUtils getInstance(){//单例
        if (INSTENCE == null){
            synchronized (RetrofitUtils.class){
                if (INSTENCE == null){
                    INSTENCE = new RetrofitUtils();
                }
            }
        }
        return INSTENCE;
    }

    //创建方法   方便调用
    public RetrofitApi getservice(){
        return retrofit.create(RetrofitApi.class);
    }
}

