package com.epicodus.bogglesolitaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.titleTextView) TextView mTitleTextView;
//    @Bind(R.id.randomLetters) TextView mRandomLetters;
    @Bind(R.id.button) Button mButton;
    @Bind(R.id.gridview) GridView mGridView;
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private Random randGen = new Random();
    private String[] boggleLetters = new String[8];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //Typeface

        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // mRandomLetters.setText(random string function result)
                for ( Integer index = 0 ; index < boggleLetters.length; index++ ) {
                    String letter = String.valueOf(alphabet.charAt(randGen.nextInt(25)));
                    boggleLetters[index] = letter;
                }
                Log.d("Result: ", Arrays.toString(boggleLetters));
//                mRandomLetters.setText(Arrays.toString(boggleLetters));
                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, boggleLetters);
                mGridView.setAdapter(adapter);
            }
        });
    }
}
