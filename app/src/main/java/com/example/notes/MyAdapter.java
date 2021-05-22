package com.example.notes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> items;
    private int Elemento;

    public MyAdapter(Context context, int layout, List<String> items) {
        this.context = context;
        this.layout = layout;
        this.items = items;
        Elemento = R.layout.grid_item;
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //ViewHolder holder;
        //View v = convertView;

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            //convertView = layoutInflater.inflate(R.layout.list_item, null);
            convertView = layoutInflater.inflate(Elemento, null);
           // holder = new ViewHolder();
            //holder.nombreTextView = convertView.findViewById(R.id.textViewGrid);
           // convertView.setTag(holder);
            //v = layoutInflater.inflate(R.layout.list_item, null);
        }else{
           // holder = (ViewHolder) convertView.getTag();
        }

        //String nombreActual = items.get(position);
       // holder.nombreTextView.setText(nombreActual);

        return convertView;
    }
    
    public void agregarImagen(){
        Elemento = R.layout.grid_item;
        this.notifyDataSetChanged();
    }

    public void agregarNota(){
        Elemento = R.layout.grid_item2;
        this.notifyDataSetChanged();
    }

    static class ViewHolder {
        public TextView nombreTextView;
    }

}