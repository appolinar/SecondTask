package com.appolinary.msappsecondtaskparsing.presentation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import com.appolinary.msappsecondtaskparsing.PostAdapter2;
import com.appolinary.msappsecondtaskparsing.R;
import com.appolinary.msappsecondtaskparsing.business.IPostInteractor;
import com.appolinary.msappsecondtaskparsing.business.PostInteractor;
import com.appolinary.msappsecondtaskparsing.data.BaseModel;
import com.appolinary.msappsecondtaskparsing.presentation.presenter.IPostPresenter;
import com.appolinary.msappsecondtaskparsing.presentation.presenter.PostPresenter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainActivity, SearchView.OnQueryTextListener {
    ProgressBar progressBar;
    RecyclerView recyclerView;
    IPostPresenter presenter;
    PostAdapter2 adapter;
    List<BaseModel> baseModels = new ArrayList<>();

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
        totalList.sort(new Comparator<BaseModel>() {
            @Override
            public int compare(BaseModel o1, BaseModel o2) {//sorting by year
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        baseModels = totalList;
        adapter = new PostAdapter2(totalList, getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String userInput = newText.toLowerCase();
        List<BaseModel> newList = new ArrayList<>();

        for(BaseModel baseModel : baseModels){
            if(baseModel.getTitle().toLowerCase().contains(userInput)){
                newList.add(baseModel);
            }
        }
        adapter.updateList(newList);
        return true;
    }

    //TODO TUT указать в readme что для видео - только кнопка кликабельна, для webview - весь item
    //TODO TUT - указать что поворот экрана не ставился целью поддерживаться, но он и не зафиксирован в только вертикальном положении
}
