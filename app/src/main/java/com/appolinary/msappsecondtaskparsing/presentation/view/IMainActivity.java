package com.appolinary.msappsecondtaskparsing.presentation.view;

import com.appolinary.msappsecondtaskparsing.data.BaseModel;

import java.util.List;

public interface IMainActivity {
    void showProgress();
    void hideProgressAndShowRV(List<BaseModel> totalList);
}
