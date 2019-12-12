package ru.hawoline.testtask.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ru.hawoline.testtask.R;
import ru.hawoline.testtask.adapter.RvAdapter;
import ru.hawoline.testtask.model.Product;
import ru.hawoline.testtask.util.Tool;

public class ProductsActivity extends AppCompatActivity {

    ArrayList<Product> pizzaProducts = new ArrayList<>();
    RequestQueue requestQueue;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        recyclerView = findViewById(R.id.rv);

        jsonCall();
    }

    public void jsonCall(){
        try {
            JSONObject jsonObject = new JSONObject(Tool.getAssetJsonData(this));
            JSONArray groups = jsonObject.getJSONArray("groups");

            Intent intent = getIntent();
            int productGroup = intent.getIntExtra("PRODUCT_GROUP", 0);

            JSONObject pizzaJSONObject = groups.getJSONObject(productGroup);
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

        setRvAdapter(pizzaProducts);

        requestQueue = Volley.newRequestQueue(this);
    }

    private void setRvAdapter(List<Product> lst) {
        RvAdapter myAdapter = new RvAdapter(this,lst) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
    }
}
