package com.example.paul.adapterdelegatessample.delegates;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.paul.adapterdelegatessample.R;
import com.example.paul.adapterdelegatessample.model.DisplayableItem;
import com.example.paul.adapterdelegatessample.model.Subhead;
import com.hannesdorfmann.adapterdelegates2.AbsListItemAdapterDelegate;

import java.util.List;

/**
 * @author Paul Zin
 */
public class SubheadDelegate extends AbsListItemAdapterDelegate<Subhead, DisplayableItem, SubheadDelegate.SubheadViewHolder> {
    private LayoutInflater inflater;

    public SubheadDelegate(Activity activity) {
        this.inflater = activity.getLayoutInflater();
    }

    @Override
    protected boolean isForViewType(@NonNull DisplayableItem item, List<DisplayableItem> items, int position) {
        return item instanceof Subhead;
    }

    @NonNull
    @Override
    public SubheadViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        return new SubheadViewHolder(inflater.inflate(R.layout.list_item_subhead, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull Subhead item, @NonNull SubheadViewHolder viewHolder) {
        viewHolder.subheadTextView.setText(item.getText());
    }


    static class SubheadViewHolder extends RecyclerView.ViewHolder {
        public TextView subheadTextView;

        public SubheadViewHolder(View itemView) {
            super(itemView);
            subheadTextView = (TextView) itemView.findViewById(R.id.subheadTextView);
        }
    }
}
