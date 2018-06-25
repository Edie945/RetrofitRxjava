package com.example.myretrofitrxjava;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BasePresenter<IMainView>{

    private final RetrofitUtils retrofitUtils;

    public MainPresenter(){
        retrofitUtils = RetrofitUtils.getInstance();
    }
    public void SuDoKu(){
        Observable<Beans> data = retrofitUtils.getservice().Sudoku();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Beans>() {
                    //onSubscribe:订阅者
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    //下一个
                    @Override
                    public void onNext(Beans bean) {
                        List<Beans.DataBean> data = bean.getData();
                        getView().onSuccess(data);
                    }

                    //异常
                    @Override
                    public void onError(Throwable e) {

                    }

                    //成功
                    @Override
                    public void onComplete() {

                    }
                });
    }
}
