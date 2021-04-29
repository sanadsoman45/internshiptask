package com.example.internshiptask2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static final String url = "https://backend-test-zypher.herokuapp.com/testData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest arrayrequest = new JsonObjectRequest(Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("responsemsg","response is:"+response.toString());
                try {
                    Log.d("responsemsg","title is:"+response.getString("title"));
                    Log.d("responsemsg","title is:"+response.getString("imageURL"));
                    Log.d("responsemsg","title is:"+response.getString("success_url"));
                    viewDialog dialog = new viewDialog();
                    dialog.showDialog(MainActivity.this,response.getString("title"),response.getString("imageURL"),response.getString("success_url"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Errormsg", "Error msg is:" + error.getMessage());
            }
        });
        queue.add(arrayrequest);
    }
}