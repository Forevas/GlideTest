package com.example.administrator.glidetest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    private LayoutInflater inflater;
    private Context mContext;
    private GridView gv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflater=LayoutInflater.from(this);
        mContext=this;
        gv=(GridView) findViewById(R.id.gv);
        gv.setAdapter(new MyAdapter());
    }
    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return Constants.urls.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return Constants.urls[position];
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            View view=inflater.inflate(R.layout.grid_item, null);
            ImageView iv=(ImageView) view.findViewById(R.id.iv);
            Glide.with(mContext).load(Constants.urls[position]).centerCrop().into(iv);
//			Picasso.with(mContext).load(Constants.urls[position]).into(iv);
            return view;
        }

    }
}
