package com.akriti.physicsWallah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.akriti.physicsWallah.Adapter.UserAdapter;
import com.akriti.physicsWallah.Model.User;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
RecyclerView.Adapter adapter;
List<User> user;
String URL_Data="https://my-json-server.typicode.com/easygautam/data/users";
RequestQueue reqQue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recyleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        user=new ArrayList<>();

            loadurl();

    }

    public void loadurl() {
        JsonArrayRequest stringRequest=new JsonArrayRequest(URL_Data, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {

                getvalue(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        reqQue = Volley.newRequestQueue(this);

        reqQue.add(stringRequest);
    }

    public void getvalue(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            User userlist = new User();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);


                userlist.setId(json.getString("id"));
                userlist.setName(json.getString("name"));
                userlist.setSubj(json.getString("subjects"));
                userlist.setQual(json.getString("qualification"));

                userlist.setProfileUrl(json.getString("profileImage"));

            } catch (JSONException e) {

                e.printStackTrace();
            }
            user.add(userlist);
        }

       adapter = new UserAdapter(user, this);

        recyclerView.setAdapter(adapter);
    }



}
