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

import p.fetch.Adapter.ItemAdapter;
import p.fetch.FavoriteList;
import p.fetch.MainActivity;
import p.fetch.R;

public class FavoriteFragment extends Fragment  {
private RecyclerView rv;
    private FavoriteAdapter adapter;
public View v;
public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
    v= inflater.inflate(R.layout.fragment_favorite , container, false);


    rv = (RecyclerView) v.findViewById(R.id.favorite_page);
    rv.setHasFixedSize(true);
    rv.setLayoutManager(new LinearLayoutManager(v.getContext()));

    getFavData( );
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
