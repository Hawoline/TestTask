package ru.hawoline.testtask.ui.pasta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import ru.hawoline.testtask.R;

public class PastaFragment extends Fragment {

    private PastaViewModel mPastaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mPastaViewModel =
                ViewModelProviders.of(this).get(PastaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_pasta, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        mPastaViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}