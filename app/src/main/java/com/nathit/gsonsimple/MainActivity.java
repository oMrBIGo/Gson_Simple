package com.nathit.gsonsimple;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nathit.gsonsimple.adapter.userAdapter;
import com.nathit.gsonsimple.model.userModel;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<userModel> modelArrayList;
    private RecyclerView recyclerView;
    private userAdapter mUserAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadData();
        buildRecyclerView();
        setInsertButton();

    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("SharedPef", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<userModel>>() {}.getType();
        modelArrayList = gson.fromJson(json, type);

        if (modelArrayList == null) {
            modelArrayList = new ArrayList<>();
        }
    }

    private void buildRecyclerView() {
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        mUserAdapter = new userAdapter(modelArrayList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mUserAdapter);
    }

    private void setInsertButton() {
        Button buttonIns = (Button) findViewById(R.id.button_insert);
        buttonIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText line1 = (EditText) findViewById(R.id.edittext_line_1);
                EditText line2 = (EditText) findViewById(R.id.edittext_line_2);
                insertItem(line1.getText().toString(), line2.getText().toString());

            }
        });
    }

    private void insertItem(String line1, String line2) {
        modelArrayList.add(new userModel(line1,line2));
        mUserAdapter.notifyItemInserted(modelArrayList.size());
    }


}