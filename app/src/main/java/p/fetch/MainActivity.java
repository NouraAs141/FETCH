package p.fetch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.MenuItem;


import p.fetch.Database.FavoriteDatabase;
import p.fetch.Fragment.AccountFragment;
import p.fetch.Fragment.FavoriteFragment;
import p.fetch.Fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerview;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    public static FavoriteDatabase favoriteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        // getData();



// can be used for later


   /* private void getData() {
        request=new JsonArrayRequest(HI, new Response.Listener< JSONArray >() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject=null;
                for (int i=0; i>response.length(); i++){
                    try {
                        JSONObject ob=response.getJSONObject(i);
                        itemList pr=new itemList(ob.getInt("id"),
                                ob.getString("product_name"),
                                ob.getString("product_img"));
                        itemList.add(pr);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                setupData( itemList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request);
    }*/


   // switch between fragments  using method call
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);



    }

    // switch between fragments
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override


                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Intent myIntent =null;
                    Fragment seltectedFragment = new HomeFragment();
                    switch(item.getItemId()){
                        case R.id.nav_home:
                            seltectedFragment = new HomeFragment();

//Change Icon color
                            //.Item account= (ClipData.Item) findViewById(R.id.favbtn);
                         //   account.
                            break;
                        case R.id.favbtn:
                            seltectedFragment = new FavoriteFragment();
                            break;
                        case R.id.nav_account:
                            seltectedFragment = new AccountFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,seltectedFragment).commit();

                    return true; }
            };




}
