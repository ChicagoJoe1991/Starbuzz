package com.example.walter.starbuzz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.app.ListActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinkCategoryActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //make sure to delete the setContentView code for Activities using ListActivity layouts
        super.onCreate(savedInstanceState);

        //create a separate class called Drink to put the array in
        ArrayAdapter<Drink> listAdapter = new ArrayAdapter<Drink>(
                //this is the current activity
                this,
                //This is a built-in layout resource. it tells the array adapter to display each
                //item in the array in a single text view
                android.R.layout.simple_list_item_1,
                //the array
                Drink.drinks);
        //attach the array adapter to the list view using the ListView setAdapter method()
        ListView listDrinks = getListView();
        listDrinks.setAdapter(listAdapter);

    }
    public void onListItemClick(ListView listView,
                                View itemView,
                                int position,
                                long id){
        Intent intent = new Intent(DrinkCategoryActivity.this, DrinkActivity.class);
        intent.putExtra(DrinkActivity.EXTRA_DRINKNO, (int) id);
        startActivity(intent);
    }
}
