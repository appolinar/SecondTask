package com.appolinary.msappsecondtaskparsing.presentation.presenter;

import com.appolinary.msappsecondtaskparsing.business.IPostInteractor;
import com.appolinary.msappsecondtaskparsing.presentation.view.IMainActivity;

public class PostPresenter implements IPostPresenter {
    IMainActivity mainActivity;
    IPostInteractor interactor;

    public PostPresenter(IMainActivity mainActivity, IPostInteractor interactor) {
        this.mainActivity = mainActivity;
        this.interactor = interactor;
    }

    @Override
    public void loadData() {
        mainActivity.showProgress();
        interactor.loadLinkData();

    }
}
