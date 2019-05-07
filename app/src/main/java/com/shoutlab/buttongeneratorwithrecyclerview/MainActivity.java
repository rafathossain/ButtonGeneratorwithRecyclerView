package com.shoutlab.buttongeneratorwithrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewButton;
    ButtonAdapter buttonAdapter;

    ArrayList<ButtonItems> buttonItems = new ArrayList<>();

    EditText buttons;

    Button generate_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons = findViewById(R.id.button_numbers);
        generate_btn = findViewById(R.id.generate);
        recyclerViewButton = findViewById(R.id.recyclerViewButton);

        recyclerViewButton.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));

        generate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.valueOf(buttons.getText().toString());

                buttonItems = new ArrayList<>();

                for(int i = 0 ; i < count ; i++){
                    buttonItems.add(new ButtonItems(String.valueOf(i+1)));
                }

                buttonAdapter = new ButtonAdapter(MainActivity.this, buttonItems);
                recyclerViewButton.setAdapter(buttonAdapter);
            }
        });
    }
}
