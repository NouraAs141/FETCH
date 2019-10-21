package p.fetch.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import p.fetch.Adapter.FavoriteAdapter;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import p.fetch.Adapter.ItemAdapter;
import p.fetch.Database.FavoriteDatabase;
import p.fetch.FavoriteList;
import p.fetch.MainActivity;
import p.fetch.R;

public class FavoriteFragment extends Fragment  {
private RecyclerView rv;
    private FavoriteAdapter adapter;
    public static FavoriteDatabase favorite_frag_Database;
public View v;
public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
    v= inflater.inflate(R.layout.fragment_favorite , container, false);


    rv = (RecyclerView) v.findViewById(R.id.favorite_page);
    rv.setHasFixedSize(true);
    rv.setLayoutManager(new LinearLayoutManager(v.getContext()));

    getFavData( );
    favorite_frag_Database = Room.databaseBuilder(v.getContext(), FavoriteDatabase.class, "myfavdb").allowMainThreadQueries( ).build( );
    return v;
}

    private void getFavData() {
        ArrayList < FavoriteList > favoriteLists = (ArrayList < FavoriteList >) HomeFragment.favoriteDatabase.favoriteDao( ).getFavoriteData( );

        adapter = new FavoriteAdapter( favoriteLists, v.getContext());
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new GridLayoutManager(v.getContext(), 2));
        rv.setAdapter(adapter);

    }

}
