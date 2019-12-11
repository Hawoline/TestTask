package ru.hawoline.testtask.ui.pizza;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ru.hawoline.testtask.R;
import ru.hawoline.testtask.tool.Tool;

public class PizzaFragment extends Fragment {

    private PizzaViewModel mPizzaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mPizzaViewModel =
                ViewModelProviders.of(this).get(PizzaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_pizza, container, false);
        ListView productsListView = root.findViewById(R.id.pizza_products_list_view);

        final ArrayList<String> pizzaProducts = new ArrayList<>();

        final ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, pizzaProducts);

        productsListView.setAdapter(adapter);

        try {
            JSONObject jsonObject = new JSONObject(Tool.getAssetJsonData(getActivity()));
            JSONArray groups = jsonObject.getJSONArray("groups");

            JSONObject pizza = groups.getJSONObject(0);
            JSONArray productsArray = pizza.getJSONArray("products");

            for (int i = 0; i < productsArray.length(); i++){
                String name = productsArray.getJSONObject(i).getString("name");

                pizzaProducts.add(name);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return root;
    }
}