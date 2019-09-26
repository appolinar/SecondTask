package com.appolinary.msappsecondtask.presentation.presenter;

import com.appolinary.msappsecondtask.business.IPostInteractor;
import com.appolinary.msappsecondtask.data.LinkModel;
import com.appolinary.msappsecondtask.data.VideoModel;
import com.appolinary.msappsecondtask.presentation.view.IMainActivity;

import java.util.List;

public class PostPresenter implements IPostPresenter,
        IPostInteractor.OnLinkListDownloadFinishedListener,
        IPostInteractor.OnVideoListDownloadFinishedListener {
    private IMainActivity mainActivity;
    private IPostInteractor interactor;
    private boolean anotherDataLoaded = false;

    public PostPresenter(IMainActivity mainActivity, IPostInteractor interactor) {
        this.mainActivity = mainActivity;
        this.interactor = interactor;
    }

    @Override
    public void loadData() {
        mainActivity.showProgress();
        interactor.loadLinkData(this);
        interactor.loadVideoData(this);

    }

    @Override
    public void onLinkListFinished(List<LinkModel> links) {
        if(!anotherDataLoaded) {
            anotherDataLoaded = true;
        }
        else{
            mainActivity.hideProgressAndShowRV(interactor.getTotalList());
        }

    }

    @Override
    public void onVideoListFinished(List<VideoModel> videos) {
        if(!anotherDataLoaded) {
            anotherDataLoaded = true;
        }
        else{
            mainActivity.hideProgressAndShowRV(interactor.getTotalList());
        }
    }

    @Override
    public void onFailure(Throwable t) {

    }
}
