package p.fetch.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;

import p.fetch.Adapter.ItemAdapter;
import p.fetch.Database.FavoriteDatabase;
import p.fetch.Item;
import p.fetch.R;




public class HomeFragment extends Fragment  {
private RecyclerView mRecyclerview;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private View v;
    public static FavoriteDatabase favoriteDatabase;

public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

    ArrayList < Item > itemList = new ArrayList <>( );
    itemList.add(new Item(R.drawable.ic_android_black_24dp, "Android One", "Icon", 3));
    itemList.add(new Item(R.drawable.ic_android_black_24dp, "Android Two", "large ", 4));
    itemList.add(new Item(R.drawable.ic_android_black_24dp, "Android Three", "Colored", 5));
v = inflater.inflate(R.layout.fragment_home , container, false);

    mRecyclerview =v.findViewById(R.id.home);
    mRecyclerview.setHasFixedSize(true);
    mLayoutManager = new LinearLayoutManager(v.getContext());
    mAdapter = new ItemAdapter(v.getContext(), itemList);
    mRecyclerview.setLayoutManager(new GridLayoutManager(v.getContext(), 2));
    mRecyclerview.setAdapter(mAdapter);
    favoriteDatabase = Room.databaseBuilder(v.getContext(), FavoriteDatabase.class, "myfavdb").allowMainThreadQueries( ).build( );

    return v;

}

}
