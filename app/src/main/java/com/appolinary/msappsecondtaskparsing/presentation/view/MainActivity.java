package com.appolinary.msappsecondtaskparsing.presentation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.appolinary.msappsecondtaskparsing.PostAdapter2;
import com.appolinary.msappsecondtaskparsing.R;
import com.appolinary.msappsecondtaskparsing.business.IPostInteractor;
import com.appolinary.msappsecondtaskparsing.business.PostInteractor;
import com.appolinary.msappsecondtaskparsing.data.BaseModel;
import com.appolinary.msappsecondtaskparsing.presentation.presenter.IPostPresenter;
import com.appolinary.msappsecondtaskparsing.presentation.presenter.PostPresenter;

import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainActivity{
    ProgressBar progressBar;
    RecyclerView recyclerView;
    IPostPresenter presenter;
    PostAdapter2 adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progress);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        IPostInteractor interactor = new PostInteractor();
        presenter = new PostPresenter(this, interactor);
        presenter.loadData();








    }

    @Override
    public void showProgress() {
        recyclerView.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressAndShowRV(List<BaseModel> totalList) {
        progressBar.setVisibility(View.INVISIBLE);
        adapter = new PostAdapter2(totalList, getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setVisibility(View.VISIBLE);
    }

    //TODO TUT нужно будет отрегулировать красоту в item_layout а то поначалу набросал, а это важный пункт
    //TODO TUT указать в readme что для видео - только кнопка кликабельна, для webview - весь item
}
