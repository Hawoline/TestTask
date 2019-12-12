package ru.hawoline.testtask.ui.pizza;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ru.hawoline.testtask.MainActivity;
import ru.hawoline.testtask.R;
import ru.hawoline.testtask.model.Product;
import ru.hawoline.testtask.util.Tool;

public class PizzaFragment extends Fragment {

    private PizzaViewModel mPizzaViewModel;

    ArrayList<Product> pizzaProducts = new ArrayList<>();
    RequestQueue requestQueue;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mPizzaViewModel =
                ViewModelProviders.of(this).get(PizzaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_pizza, container, false);

//        ListView productsListView = root.findViewById(R.id.pizza_products_list_view);
//
//        final ArrayList<String> pizzaProducts = new ArrayList<>();
//
//        final ArrayAdapter<String> adapter;
//        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, pizzaProducts);
//
//        productsListView.setAdapter(adapter);
//
//        try {
//            JSONObject jsonObject = new JSONObject(Tool.getAssetJsonData(getActivity()));
//            JSONArray groups = jsonObject.getJSONArray("groups");
//
//            JSONObject pizza = groups.getJSONObject(0);
//            JSONArray productsArray = pizza.getJSONArray("products");
//
//            for (int i = 0; i < productsArray.length(); i++){
//                String name = productsArray.getJSONObject(i).getString("name");
//
//                pizzaProducts.add(name);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        jsonCall();

        return root;
    }

    public void jsonCall(){
        try {
            JSONObject jsonObject = new JSONObject(Tool.getAssetJsonData(getActivity()));
            JSONArray groups = jsonObject.getJSONArray("groups");

            JSONObject pizzaJSONObject = groups.getJSONObject(0);
            JSONArray productsArray = pizzaJSONObject.getJSONArray("products");

            for (int i = 0; i < productsArray.length(); i++){
                Product pizza = new Product();

                pizza.setName(productsArray.getJSONObject(i).getString("name"));
                pizza.setImgUrl(productsArray.getJSONObject(i).getString("img_url"));
                pizza.setDescription(productsArray.getJSONObject(i).getString("desc"));
                ArrayList<Integer> prices = new ArrayList<>();
                ArrayList<String> sizes = new ArrayList<>();
                JSONArray pricesAndSizesJSONArray = productsArray.getJSONObject(i).getJSONArray("size_price");
                for (int j = 0; j < pricesAndSizesJSONArray.length(); j++){
                    prices.add(pricesAndSizesJSONArray.getJSONObject(j).getInt("price"));
                    if (pricesAndSizesJSONArray.getJSONObject(j).getString("size") == null)
                        continue;
                    sizes.add(pricesAndSizesJSONArray.getJSONObject(j).getString("size"));
                }

                pizza.setPrices(prices);
                pizza.setSizes(sizes);

                pizzaProducts.add(pizza);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        setRAdapter();

        requestQueue = Volley.newRequestQueue(getActivity());
    }

    private void setRAdapter() {
        RvAdapter myAdapter = new RvAdapter(this,lst) ;
        myrv.setLayoutManager(new LinearLayoutManager(this));
        myrv.setAdapter(myAdapter);
    }

}