package com.example.administrator.viewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2019/11/4.
 */

public class MainAdapter  extends BaseAdapter{
    private Context context;
    private List<MainModel> models;
     public  MainAdapter (Context context,int  layout_list,List<MainModel> models){
         this.context = context;
         this.models = models;
     }
    @Override
    public int getCount() {
        return this.models.size();
    }

    @Override
    public Object getItem(int position) {
        return this.models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      MainModel model = models.get(position);
      ViewHello viewHello;
      if (convertView ==null){
          viewHello = new  ViewHello();
          convertView = LayoutInflater.from(context).inflate(R.layout.listview_item,null);
          viewHello.imageView= (ImageView)convertView.findViewById(R.id.img);
          viewHello.textView = (TextView) convertView.findViewById(R.id.text);
          convertView.setTag(viewHello);
      }else {
          viewHello = (ViewHello)convertView.getTag();
      }

        ImageLoader.getInstance().displayImage("http://bb.wxtool.cn"+model.getPhoto(),viewHello.imageView);
        viewHello.textView.setText(""+model.getTitle());
        return  convertView;
    }
    private class  ViewHello{
        ImageView imageView;
        TextView textView;
    }
}
