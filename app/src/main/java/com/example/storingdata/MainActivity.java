package com.example.storingdata;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editText2);
        textView=findViewById(R.id.textView);


        sharedPreferences=this.getSharedPreferences("com.example.storingdata",Context.MODE_PRIVATE);

        int storedage= sharedPreferences.getInt("storedage",0);

        if(storedage==0){
            textView.setText("your age:");
        }
        else{

            textView.setText("your age:" + storedage);

        }

    }

    public void save(View view){

        if(!editText.getText().toString().matches("")) {

            int age=Integer.parseInt(editText.getText().toString());
            textView.setText("Senin yasin :" + age);

            sharedPreferences.edit().putInt("storedage",age).apply();

        }
    }

    public void delete(View view){

        int storedData=sharedPreferences.getInt("storedage",0);

        if(storedData!=0){

            sharedPreferences.edit().remove("storedage").apply();
            textView.setText("Your age: ");

        }
    }
}

































