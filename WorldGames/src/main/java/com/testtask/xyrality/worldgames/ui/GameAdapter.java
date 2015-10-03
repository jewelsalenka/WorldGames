package com.testtask.xyrality.worldgames.ui;

import android.app.Activity;
import android.content.Context;
import android.provider.UserDictionary;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.testtask.xyrality.worldgames.R;
import com.testtask.xyrality.worldgames.rest.model.World;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olena Bezuhla(jewelsalenka@gmail.com) on 10/3/15 6:12 PM .
 */
public class GameAdapter extends BaseAdapter{
    private List<World> mWords;
    private Context mContext;

    public GameAdapter(Context context) {
        mContext = context;
        mWords = new ArrayList<>();
    }

    public void setWords(List<World> words){
        mWords = words;
    }

    static class ViewHolderItem{
        TextView mName;
        TextView mCountry;
        TextView mStatus;
        TextView mUrl;
    }
    @Override
    public int getCount() {
        return mWords.size();
    }

    @Override
    public World getItem(int position) {
        return mWords.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderItem viewHolderItem;
        if (convertView == null){
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.game_item, parent,false);
            viewHolderItem = new ViewHolderItem();
            viewHolderItem.mName = (TextView) convertView.findViewById(R.id.game_name);
            viewHolderItem.mStatus = (TextView) convertView.findViewById(R.id.game_status);
            viewHolderItem.mCountry = (TextView) convertView.findViewById(R.id.game_country);
            viewHolderItem.mUrl = (TextView) convertView.findViewById(R.id.game_url);
            convertView.setTag(viewHolderItem);
        } else {
            viewHolderItem = (ViewHolderItem) convertView.getTag();
        }

        World world = getItem(position);
        viewHolderItem.mName.setText(world.getmName());
        viewHolderItem.mStatus.setText(world.getmStatus().getmDesc());
        viewHolderItem.mCountry .setText(world.getmCountry());
        viewHolderItem.mUrl.setText(world.getmUrl());
        return convertView;
    }
}
