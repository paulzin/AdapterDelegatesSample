package com.example.paul.adapterdelegatessample;

import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.paul.adapterdelegatessample.adapter.AwesomeAdapter;
import com.example.paul.adapterdelegatessample.delegates.ArticleDelegate;
import com.example.paul.adapterdelegatessample.delegates.SubheadDelegate;
import com.example.paul.adapterdelegatessample.delegates.UserDelegate;
import com.example.paul.adapterdelegatessample.delegates.listeners.ArticleClickListener;
import com.example.paul.adapterdelegatessample.delegates.listeners.UserClickListener;
import com.example.paul.adapterdelegatessample.model.Article;
import com.example.paul.adapterdelegatessample.model.DisplayableItem;
import com.example.paul.adapterdelegatessample.model.Subhead;
import com.example.paul.adapterdelegatessample.model.User;
import com.hannesdorfmann.adapterdelegates2.AdapterDelegatesManager;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ArticleClickListener, UserClickListener {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AdapterDelegatesManager<List<DisplayableItem>> manager = new AdapterDelegatesManager<>();
        manager.addDelegate(new SubheadDelegate(this))
                .addDelegate(new ArticleDelegate(this, this))
                .addDelegate(new UserDelegate(this, this));

        AwesomeAdapter awesomeAdapter = new AwesomeAdapter(manager);
        awesomeAdapter.setItems(getSomeListItems());

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(awesomeAdapter);
    }

    private List<DisplayableItem> getSomeListItems() {
        Lorem lorem = LoremIpsum.getInstance();

        List<DisplayableItem> displayableItems = new ArrayList<>();
        displayableItems.add(new Subhead("Featured articles"));
        displayableItems.add(new Article(color(R.color.md_red_500), lorem.getTitle(1, 4), lorem.getParagraphs(1, 2)));
        displayableItems.add(new Article(color(R.color.md_purple_500), lorem.getTitle(1, 4), lorem.getParagraphs(1, 2)));
        displayableItems.add(new Article(color(R.color.md_cyan_700), lorem.getTitle(1, 4), lorem.getParagraphs(1, 2)));
        displayableItems.add(new Article(color(R.color.md_amber_900), lorem.getTitle(1, 4), lorem.getParagraphs(1, 2)));
        displayableItems.add(new Article(color(R.color.md_pink_700), lorem.getTitle(1, 4), lorem.getParagraphs(1, 2)));
        displayableItems.add(new Article(color(R.color.md_blue_A200), lorem.getTitle(1, 4), lorem.getParagraphs(1, 2)));
        displayableItems.add(new Article(color(R.color.md_grey_700), lorem.getTitle(1, 4), lorem.getParagraphs(1, 2)));
        displayableItems.add(new Subhead("Popular editors"));
        displayableItems.add(new User(color(R.color.md_green_500), lorem.getName(), lorem.getEmail()));
        displayableItems.add(new User(color(R.color.md_pink_400), lorem.getName(), lorem.getEmail()));
        displayableItems.add(new User(color(R.color.md_amber_500), lorem.getName(), lorem.getEmail()));
        displayableItems.add(new User(color(R.color.md_blue_400), lorem.getName(), lorem.getEmail()));
        displayableItems.add(new User(color(R.color.md_blue_grey_600), lorem.getName(), lorem.getEmail()));
        displayableItems.add(new User(color(R.color.md_red_500), lorem.getName(), lorem.getEmail()));

        return displayableItems;
    }

    private @ColorInt int color(@ColorRes int resId) {
        return ContextCompat.getColor(this, resId);
    }

    @Override
    public void onArticleClick() {
        Snackbar.make(recyclerView, "Article clicked", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onBookmarkClick() {
        Snackbar.make(recyclerView, "Bookmark clicked", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onUserClick() {
        Snackbar.make(recyclerView, "User clicked", Snackbar.LENGTH_SHORT).show();
    }
}
