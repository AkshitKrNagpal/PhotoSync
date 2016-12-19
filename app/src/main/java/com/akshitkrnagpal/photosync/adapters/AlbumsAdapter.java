package com.akshitkrnagpal.photosync.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.akshitkrnagpal.photosync.R;
import com.akshitkrnagpal.photosync.models.Datum;

import java.util.List;

public class AlbumsAdapter extends BaseAdapter {

    public Context context;
    public List<Datum> albums;
    public int total;

    public AlbumsAdapter(Context context, List<Datum> albums){
        this.context = context;
        this.albums = albums;
        total = albums.size();
    }

    @Override
    public int getCount() {
        return albums.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.list_view_album,parent,false);

        TextView album_name = (TextView) view.findViewById(R.id.album_name);

        album_name.setText(albums.get(position).getName());

        return view;
    }
}
