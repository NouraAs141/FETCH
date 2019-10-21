package p.fetch.adapters;

import android.content.Context;
import androidx.appcompat.app.AppCompatDelegate.NightMode;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
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
import android.R;
public abstract class AnimatedRecyclerViewAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected Context mContext;

    public AnimatedRecyclerViewAdapter(Context context) {
        this.mContext = context;
    }

    private void setAnimation(View view, int position) {
        AnimationSet set = new AnimationSet(true);

        ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        Animation fadeInAnimation = AnimationUtils.loadAnimation(mContext, android.R.anim.fade_in);

        set.addAnimation(scaleAnimation);
        set.addAnimation(fadeInAnimation);

        set.setDuration(500);

        view.startAnimation(set);
    }

    @Override
    public void onBindViewHolder(final VH holder, int position) {
        setAnimation(holder.itemView, position);
    }

    @Override
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        holder.itemView.clearAnimation();
    }
}