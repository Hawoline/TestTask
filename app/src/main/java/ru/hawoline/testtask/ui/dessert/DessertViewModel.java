package ru.hawoline.testtask.ui.dessert;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DessertViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DessertViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is send fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}