package com.example.myretrofitrxjava;

public class BasePresenter<V extends IBaseView> {
    private V ibaseView;
    public void attachView(V ibaseView){
        this.ibaseView = ibaseView;
    }
    public V getView(){
        return ibaseView;
    }
    public void detachView(){
        ibaseView = null;
    }
}


