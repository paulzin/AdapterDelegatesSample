package com.example.paul.adapterdelegatessample.delegates;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.paul.adapterdelegatessample.R;
import com.example.paul.adapterdelegatessample.delegates.listeners.UserClickListener;
import com.example.paul.adapterdelegatessample.model.DisplayableItem;
import com.example.paul.adapterdelegatessample.model.User;
import com.hannesdorfmann.adapterdelegates2.AbsListItemAdapterDelegate;

import java.util.List;

/**
 * @author Paul Zin
 */
public class UserDelegate extends AbsListItemAdapterDelegate<User, DisplayableItem, UserDelegate.UserViewHolder> {
    private LayoutInflater inflater;
    private UserClickListener clickListener;

    public UserDelegate(Activity activity, UserClickListener clickListener) {
        this.inflater = activity.getLayoutInflater();
        this.clickListener = clickListener;
    }

    @Override
    protected boolean isForViewType(@NonNull DisplayableItem item, List<DisplayableItem> items, int position) {
        return item instanceof User;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        return new UserViewHolder(inflater.inflate(R.layout.list_item_user, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull User item, @NonNull UserViewHolder viewHolder) {
        viewHolder.avatarView.setBackgroundTintList(ColorStateList.valueOf(item.getAvatarColor()));
        viewHolder.nameTextView.setText(item.getFullName());
        viewHolder.emailTextView.setText(item.getEmail());
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        public View avatarView;
        public TextView nameTextView;
        public TextView emailTextView;

        public UserViewHolder(View itemView) {
            super(itemView);
            avatarView = itemView.findViewById(R.id.avatarView);
            nameTextView = (TextView) itemView.findViewById(R.id.userNameTextView);
            emailTextView = (TextView) itemView.findViewById(R.id.userEmailTextView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onUserClick();
                }
            });
        }
    }
}
