package p.fetch;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;

import java.util.ArrayList;

import p.fetch.Adapter.ItemAdapter;
import p.fetch.Database.FavoriteDatabase;

public class HomePage extends AppCompatActivity {
/*
    private RecyclerView mRecyclerview;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_favorite);
        super.onCreate(savedInstanceState);
        ArrayList < Item > itemList = new ArrayList <>( );
        itemList.add(new Item(R.drawable.ic_android_black_24dp, "Bag", "large bag with straps", 3));
        itemList.add(new Item(R.drawable.ic_android_black_24dp, "Bag", "large bag with straps", 4));
        itemList.add(new Item(R.drawable.ic_android_black_24dp, "Bag", "large bag with straps", 5));


        mRecyclerview = findViewById(R.id.home);
        mRecyclerview.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ItemAdapter(this, itemList);
        mRecyclerview.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerview.setAdapter(mAdapter);

    }*/
}
