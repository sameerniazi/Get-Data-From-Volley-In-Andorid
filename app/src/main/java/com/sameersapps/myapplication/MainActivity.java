package com.sameersapps.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity {
TextView textView;
    Data []dataa,d;
String BaseUrl="https://jsonplaceholder.typicode.com/comments";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.text);

        StringRequest stringRequest=new StringRequest(BaseUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder gsonBuilder=new GsonBuilder();
                Gson gson=gsonBuilder.create();
                dataa=gson.fromJson(response,  Data[].class);
                for(int i=0; i<dataa.length; i++){
                Data da= dataa[i];;
                textView.append("\n"+da.getEmail());
                Log.d("byname",String.valueOf(da.getEmail()));}
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);






    }
}