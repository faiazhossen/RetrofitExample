package com.example.faiaz.retrofitexample.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.faiaz.retrofitexample.MainActivity;
import com.example.faiaz.retrofitexample.R;
import com.example.faiaz.retrofitexample.pojo.MultipleResource;

import java.util.List;

/**
 * Created by FAIAZ on 11/25/2017.
 */

public class MainAdapter extends BaseAdapter {
    LayoutInflater inflater;
    MultipleResource responseList;
    TextView textView;
    public MainAdapter(MainActivity mainActivity, MultipleResource res) {
        inflater = LayoutInflater.from(mainActivity);
        responseList = res;
    }

    @Override
    public int getCount() {
        return responseList.getData().getItems().size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = inflater.inflate(R.layout.single_list_item,viewGroup,false);
            textView = (TextView) view.findViewById(R.id.text);
        }
        textView.setText(responseList.getData().getItems().get(i).getName());
        return view;
    }
}
