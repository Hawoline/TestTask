package ru.hawoline.testtask.ui.pizza;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PizzaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PizzaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}