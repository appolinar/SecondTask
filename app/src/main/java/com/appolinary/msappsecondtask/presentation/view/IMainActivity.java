package com.appolinary.msappsecondtask.presentation.view;

import com.appolinary.msappsecondtask.data.BaseModel;

import java.util.List;

public interface IMainActivity {
    void showProgress();
    void hideProgressAndShowRV(List<BaseModel> totalList);
}
