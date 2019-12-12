package ru.hawoline.testtask.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import ru.hawoline.testtask.R;
import ru.hawoline.testtask.model.Product;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {

    RequestOptions requestOptions;
    private Context context;
    private List<Product> products;

    public RvAdapter(Context context, List<Product> list){
        this.context = context;
        this.products = list;

        requestOptions = new RequestOptions()
                .centerCrop();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view;
        LayoutInflater mInflater = LayoutInflater.from(context);
        view = mInflater.inflate(R.layout.product_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_name.setText(products.get(position).getName());
        holder.tv_description.setText(products.get(position).getDescription());
        StringBuilder prices = new StringBuilder();
        StringBuilder sizes = new StringBuilder();

        prices.append("Prices: ");
        sizes.append("Sizes: ");

        for (int i = 0; i < products.get(position).getSizes().size(); i++){
            sizes.append(products.get(position).getSizes().get(i));
            sizes.append(" ");
        }

        for (int i = 0; i < products.get(position).getPrices().size(); i++){
            prices.append(products.get(position).getPrices().get(i));
            prices.append(" ");
        }

        holder.tv_prices.setText(prices.toString());
        holder.tv_sizes.setText(sizes.toString());

//        Glide.with(context).load(products.get(position).getImgUrl()).apply(requestOptions).into(holder.productIV);
        URL url = null;
        try {
            url = new URL("http://image10.bizrate-images.com/resize?sq=60&uid=2216744464");
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            holder.productIV.setImageBitmap(bmp);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name, tv_description, tv_prices, tv_sizes;
        ImageView productIV;


        public MyViewHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.product_name);
            tv_prices = itemView.findViewById(R.id.product_prices);
            tv_description = itemView.findViewById(R.id.product_description);
            tv_sizes = itemView.findViewById(R.id.product_sizes);
            productIV = itemView.findViewById(R.id.product_image);
        }
    }
}
