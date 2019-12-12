package ru.hawoline.testtask;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;

import ru.hawoline.testtask.ui.ProductsActivity;

public class MainActivity extends AppCompatActivity {

    Button pizzaButton;
    Button comboButton;
    Button pastaButton;
    Button burgersAndRollsButton;
    Button snacksButton;
    Button dessertsButton;
    Button drinksButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pizzaButton = findViewById(R.id.pizza_button);
        comboButton = findViewById(R.id.combo_button);
        pastaButton = findViewById(R.id.pasta_button);
        burgersAndRollsButton = findViewById(R.id.burgers_and_rolls_button);
        snacksButton = findViewById(R.id.snacks_button);
        dessertsButton = findViewById(R.id.desserts_button);
        drinksButton = findViewById(R.id.drinks_button);


        pizzaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProductsActivity.class);
                intent.putExtra("PRODUCT_GROUP", 0);
                startActivity(intent);
            }
        });

        comboButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProductsActivity.class);
                intent.putExtra("PRODUCT_GROUP", 1);
                startActivity(intent);
            }
        });

        pastaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProductsActivity.class);
                intent.putExtra("PRODUCT_GROUP", 2);
                startActivity(intent);
            }
        });

        burgersAndRollsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProductsActivity.class);
                intent.putExtra("PRODUCT_GROUP", 3);
                startActivity(intent);
            }
        });

        snacksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProductsActivity.class);
                intent.putExtra("PRODUCT_GROUP", 4);
                startActivity(intent);
            }
        });

        dessertsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProductsActivity.class);
                intent.putExtra("PRODUCT_GROUP", 5);
                startActivity(intent);
            }
        });

        drinksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProductsActivity.class);
                intent.putExtra("PRODUCT_GROUP", 6);
                startActivity(intent);
            }
        });
    }
}
