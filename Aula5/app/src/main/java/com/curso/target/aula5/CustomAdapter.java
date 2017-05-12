package com.curso.target.aula5;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewGroupCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

import static android.R.attr.resource;

/**
 * Created by sala01 on 12/05/2017.
 */

public class CustomAdapter extends ArrayAdapter<Item> {

    Context context;
    List<Item> itens;

    public CustomAdapter(Context context, List<Item> itens) {
        super(context, R.layout.item, itens);
        this.context = context;
        this.itens = itens;
    }


    class ViewHolder{
        TextView name, local, likes;
        ImageView avatar, photo;

        public ViewHolder() {

        }

        public ViewHolder(TextView name, TextView local, TextView likes, ImageView avatar, ImageView photo) {
            this.name = name;
            this.local = local;
            this.likes = likes;
            this.avatar = avatar;
            this.photo = photo;
        }

        public TextView getName() {
            return name;
        }

        public void setName(TextView name) {
            this.name = name;
        }

        public TextView getLocal() {
            return local;
        }

        public void setLocal(TextView local) {
            this.local = local;
        }

        public TextView getLikes() {
            return likes;
        }

        public void setLikes(TextView likes) {
            this.likes = likes;
        }

        public ImageView getAvatar() {
            return avatar;
        }

        public void setAvatar(ImageView avatar) {
            this.avatar = avatar;
        }

        public ImageView getPhoto() {
            return photo;
        }

        public void setPhoto(ImageView photo) {
            this.photo = photo;
        }
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater =  LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item,parent,false);
            viewHolder.name = (TextView)convertView.findViewById(R.id.textView3);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        
        //viewHolder.name.setText();
        return convertView;
    }



}
