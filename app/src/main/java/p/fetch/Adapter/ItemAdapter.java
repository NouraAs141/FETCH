package p.fetch.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

import p.fetch.FavoriteList;
import p.fetch.Fragment.HomeFragment;
import p.fetch.Item;
import p.fetch.Item_Detail;
import p.fetch.MainActivity;
import p.fetch.R;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{
private ArrayList< Item > mitemlist;
private Context mcontext;
    @NonNull
    @Override

    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater mInflater =LayoutInflater.from(mcontext);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ItemViewHolder ivh = new ItemViewHolder(v);
        return ivh;
    }
public ItemAdapter (Context context, ArrayList < Item > itemlist){
        mcontext = context;
        mitemlist =itemlist;
}

//-------------
    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder, int position) {
        final Item currentItem  = mitemlist.get(position);

        holder.itemImage.setImageResource(currentItem.getImageResource());
        holder.itemName.setText(currentItem.getName());
        holder.itemDes.setText(currentItem.getDescription());

        holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(mcontext, Item_Detail.class);


                //passing data to the item detail activity
                intent.putExtra("Photo: ", currentItem.getImageResource());
                intent.putExtra("Name: ", currentItem.getName());
                intent.putExtra("Item Description: ",currentItem.getDescription());

                //start activity
                mcontext.startActivity(intent);
            }
        });

        //set click Item

       // Picasso.with(mcontext).load(currentItem.getImageResource()).into(holder.itemImage);
       // holder.itemName.setText(currentItem.getName());

        if (HomeFragment.favoriteDatabase.favoriteDao().isFavorite(currentItem .getId())==1)
            holder.btnAddFavourite.setImageResource(R.drawable.ic_favorite_);
        else
            holder.btnAddFavourite.setImageResource(R.drawable.ic_favorite_border_gray_24dp);


        holder.btnAddFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FavoriteList favoriteList=new FavoriteList();
                favoriteList.setId(currentItem.getId());
                favoriteList.setImage(currentItem.getImageResource());
                favoriteList.setName(currentItem.getName());
                favoriteList.setDescription(currentItem.getDescription());


int id = currentItem.getId();
                if (HomeFragment.favoriteDatabase.favoriteDao().isFavorite(id)!=1){
                    holder.btnAddFavourite.setImageResource(R.drawable.ic_favorite_);
                    HomeFragment.favoriteDatabase.favoriteDao().addData(favoriteList);

                }else {
                    holder.btnAddFavourite.setImageResource(R.drawable.ic_favorite_border_gray_24dp);
                    HomeFragment.favoriteDatabase.favoriteDao().delete(favoriteList);

                }


            }
        });
    }


    @Override
    public int getItemCount() {
        return mitemlist.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{

public ImageView btnAddFavourite;
public ImageView itemImage;
public TextView itemName;
public TextView itemDes;
CardView cardView;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
             itemImage=itemView.findViewById(R.id.image_item);
              itemName=itemView.findViewById(R.id.item_name);
           itemDes=itemView.findViewById(R.id.item_description);
            btnAddFavourite=itemView.findViewById(R.id.favorite_button);
            cardView =(CardView)itemView.findViewById(R.id.click_cardView);

        }
    }

}
