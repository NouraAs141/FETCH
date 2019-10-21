package p.fetch.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import p.fetch.FavoriteList;
import p.fetch.R;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {
private ArrayList < FavoriteList > favoriteLists;
       public  Context context;

public FavoriteAdapter(ArrayList< FavoriteList > favoriteLists, Context context) {
        this.favoriteLists = favoriteLists;
        this.context = context;
        }

@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_favorite_item,viewGroup,false);
        return new ViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        FavoriteList fl=favoriteLists.get(i);
       // Picasso.get(context).load(fl.getImage()).into(viewHolder.img);
    viewHolder.iname.setText(fl.getName());
    viewHolder.ides.setText(fl.getDescription());

        }

@Override
public int getItemCount() {
        return favoriteLists.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder{
    ImageView img;
    TextView iname,ides;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        img=(ImageView)itemView.findViewById(R.id.image_item_f);
        iname=(TextView)itemView.findViewById(R.id.item_name_f);
        ides=(TextView)itemView.findViewById(R.id.item_description_f);
    }
}
}
//check