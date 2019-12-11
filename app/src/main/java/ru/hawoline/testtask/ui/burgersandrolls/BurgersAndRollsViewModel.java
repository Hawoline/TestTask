package ru.hawoline.testtask.ui.burgersandrolls;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BurgersAndRollsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BurgersAndRollsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is tools fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}