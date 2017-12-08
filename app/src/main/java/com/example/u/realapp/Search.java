package com.example.u.realapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by U on 5/4/2017.
 */

public class Search extends AppCompatActivity {
    ArrayAdapter<String> adapter;
    ListView lv;
    ArrayList<String> arrayCountry;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_view);
        lv = (ListView)findViewById(R.id.listViewForSearch);
        arrayCountry = new ArrayList<>();
        arrayCountry.addAll(Arrays.asList(getResources().getStringArray(R.array.country)));
        adapter = new ArrayAdapter<>(Search.this,android.R.layout.simple_list_item_1,arrayCountry);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = lv.getItemAtPosition(position).toString();
                Toast.makeText(Search.this, ""+text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu,menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<String> templist = new ArrayList<String>();

                for (String temp : arrayCountry){
                    if (temp.toLowerCase().contains(newText.toLowerCase())) {
                        templist.add(temp);
                    }
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(Search.this,android.R.layout.simple_list_item_1,templist);
                lv.setAdapter(adapter);
                return true;
            }
        });



        return super.onCreateOptionsMenu(menu);

    }
}
