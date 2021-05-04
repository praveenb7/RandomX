package com.example.randomnumbergenerator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RNG extends AppCompatActivity {

    private TextView rangetext, result, credit;
    private EditText start, end;
    private Button generate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_n_g);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Random Number Generator");

        rangetext = (TextView)findViewById(R.id.rangetext);
        start = (EditText)findViewById(R.id.startno);
        end = (EditText)findViewById(R.id.endno);
        result = (TextView)findViewById(R.id.result1);
        generate = (Button)findViewById(R.id.rbtn);
        credit = (TextView)findViewById(R.id.credits);


        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
                */
                InputMethodManager inputManager = (InputMethodManager) getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                View focusedView = getCurrentFocus();

                if (focusedView != null) {
                    inputManager.hideSoftInputFromWindow(focusedView.getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
                }

                String st = start.getText().toString();
                String em = end.getText().toString();


                if(st.isEmpty()){
                    start.setError("Enter a number");
                    start.requestFocus();
                }
                else if(em.isEmpty()){
                    end.setError("Enter a number");
                    end.requestFocus();
                }
                else if((!st.isEmpty()) && (!em.isEmpty())){
                    try{
                        int a = Integer.parseInt(st);
                        int b = Integer.parseInt(em);
                        int res = (int)Math.floor(Math.random()*(b-a+1)+a);
                        result.setText("Result: " + Integer.toString(res));
                        result.setVisibility(View.VISIBLE);
                    }
                    catch (NumberFormatException e){
                        Toast.makeText(getApplicationContext(),"Enter Number!!!",Toast.LENGTH_SHORT);
                    }


                }

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}