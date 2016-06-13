package com.example.paul.adapterdelegatessample.delegates;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.paul.adapterdelegatessample.MainActivity;
import com.example.paul.adapterdelegatessample.R;
import com.example.paul.adapterdelegatessample.delegates.listeners.ArticleClickListener;
import com.example.paul.adapterdelegatessample.model.Article;
import com.example.paul.adapterdelegatessample.model.DisplayableItem;
import com.hannesdorfmann.adapterdelegates2.AbsListItemAdapterDelegate;

import java.util.List;

/**
 * @author Paul Zin
 */
public class ArticleDelegate extends AbsListItemAdapterDelegate<Article, DisplayableItem, ArticleDelegate.ArticleViewHolder> {
    private LayoutInflater inflater;
    private ArticleClickListener clickListener;

    public ArticleDelegate(MainActivity mainActivity, ArticleClickListener clickListener) {
        inflater = mainActivity.getLayoutInflater();
        this.clickListener = clickListener;
    }

    @Override
    protected boolean isForViewType(@NonNull DisplayableItem item, List<DisplayableItem> items, int position) {
        return item instanceof Article;
    }

    @NonNull
    @Override
    public ArticleDelegate.ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        return new ArticleViewHolder(inflater.inflate(R.layout.list_item_article, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull Article item, @NonNull ArticleDelegate.ArticleViewHolder viewHolder) {
        viewHolder.title.setText(item.getTitle());
        viewHolder.description.setText(item.getDescription());
        viewHolder.backgroundView.setBackgroundColor(item.getBackgroundColor());
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView description;
        public View backgroundView;
        public View bookmarkView;

        public ArticleViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.titleTextView);
            description = (TextView) itemView.findViewById(R.id.descriptionTextView);
            description = (TextView) itemView.findViewById(R.id.descriptionTextView);
            backgroundView = itemView.findViewById(R.id.backgroundView);
            bookmarkView = itemView.findViewById(R.id.bookmarkIcon);
            bookmarkView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onBookmarkClick();
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onArticleClick();
                }
            });
        }
    }
}
