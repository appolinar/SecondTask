package com.appolinary.msappsecondtaskparsing.presentation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.appolinary.msappsecondtaskparsing.R;
import com.appolinary.msappsecondtaskparsing.business.IPostInteractor;
import com.appolinary.msappsecondtaskparsing.business.PostInteractor;
import com.appolinary.msappsecondtaskparsing.presentation.presenter.IPostPresenter;
import com.appolinary.msappsecondtaskparsing.presentation.presenter.PostPresenter;

public class MainActivity extends AppCompatActivity implements IMainActivity{
    ProgressBar progressBar;
    RecyclerView recyclerView;
    IPostPresenter presenter;



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
    public void hideProgressAndShowRV() {
        progressBar.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.VISIBLE);

    }
}
