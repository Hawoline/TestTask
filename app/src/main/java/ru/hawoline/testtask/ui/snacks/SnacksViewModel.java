package ru.hawoline.testtask.ui.snacks;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SnacksViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SnacksViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is share fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}