package com.example.myretrofitrxjava;

import java.util.List;

public interface IMainView extends IBaseView{
    void onSuccess(List<Beans.DataBean> list);
}
