package com.example.myretrofitrxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainView{

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        MainPresenter presenter = new MainPresenter();
        presenter.attachView(this);
        presenter.SuDoKu();
    }

    @Override
    public void onSuccess(List<Beans.DataBean> list) {
        Log.e("TAGsss", "onSuccess: "+list );
        MyAdapter adapter = new MyAdapter(list,MainActivity.this);
        rv.setLayoutManager(new GridLayoutManager(MainActivity.this,2,LinearLayoutManager.HORIZONTAL,false));
        rv.setAdapter(adapter);
    }
}
