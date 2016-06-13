package com.example.paul.adapterdelegatessample.adapter;

import android.support.annotation.NonNull;

import com.example.paul.adapterdelegatessample.model.DisplayableItem;
import com.hannesdorfmann.adapterdelegates2.AdapterDelegatesManager;
import com.hannesdorfmann.adapterdelegates2.ListDelegationAdapter;

import java.util.List;

/**
 * @author Paul Zin
 */
public class AwesomeAdapter extends ListDelegationAdapter<List<DisplayableItem>> {

    public AwesomeAdapter(@NonNull AdapterDelegatesManager<List<DisplayableItem>> delegatesManager) {
        super(delegatesManager);
    }
}
