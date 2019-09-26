package com.appolinary.msappsecondtask.presentation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.appolinary.msappsecondtask.PostAdapter;
import com.appolinary.msappsecondtask.R;
import com.appolinary.msappsecondtask.business.IPostInteractor;
import com.appolinary.msappsecondtask.business.PostInteractor;
import com.appolinary.msappsecondtask.data.BaseModel;
import com.appolinary.msappsecondtask.presentation.presenter.IPostPresenter;
import com.appolinary.msappsecondtask.presentation.presenter.PostPresenter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**App which displays a list of posts coming from a JSON feed.
App loads posts from JSON URL and displays all the results in a list. The list contains 2 different row types - VIDEO and LINK
For VIDEO rows available button PLAY which open a media player to play the item.
LINK rows(fully clickable) display new screen that loads a WebView with the given link.
Sorted by title
For launching app on real device necessary install apk file on device and start it via launch icon.
Screen rotation does not support. As extra option - possible to fix orientation "only vertical"
Filtering - according the task on the top of the list located search box area that filters the posts according to the input text
Posts filtered according to the Title
Filtering executes dynamically with every character that is input by user*/

//TODO - MVP
//TODO - Single activity + fragments
//TODO - tests
//TODO - design main recyclerview - сделай красоту в recyclerview
//TODO - launch icon - need to fix

//main activity with recyclerview and search box area
public class MainActivity extends AppCompatActivity implements IMainActivity, SearchView.OnQueryTextListener {
    ProgressBar progressBar;
    RecyclerView recyclerView;
    IPostPresenter presenter;
    PostAdapter adapter;
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
            public int compare(BaseModel o1, BaseModel o2) {//sorting by title
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        baseModels = totalList;
        adapter = new PostAdapter(totalList, getApplicationContext());
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    //divider for recyclerview
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

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

}
