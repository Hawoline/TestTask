package ru.hawoline.testtask.ui.drinks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import ru.hawoline.testtask.R;
import ru.hawoline.testtask.ui.pasta.PastaViewModel;

public class DrinksFragment extends Fragment {

    private DrinksViewModel mDrinksViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mDrinksViewModel =
                ViewModelProviders.of(this).get(DrinksViewModel.class);
        View root = inflater.inflate(R.layout.fragment_pasta, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        mDrinksViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
