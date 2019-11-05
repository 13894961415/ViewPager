package com.example.administrator.viewpager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2019/11/4.
 */

public class NewFragment extends Fragment {
    private  MainAdapter adapter;
    private List<MainModel> models;
    private ListView  listView;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_listview,null);
        models = new ArrayList<MainModel>();
        listView = (ListView)view.findViewById(R.id.lv);
        post_list();
        return view;
    }

    private void post_list(){
        OkHttpClient client = new OkHttpClient();
        FormBody formBody = new FormBody.Builder()
                .add("User_Id","10")
                .add("Type_Id","16")
                .add("CurrentPage","1")
                .add("Type","0")
                .add("PageSize","20")
                .add("Token","935424FB8769AABF3C58AAC4E9053764")
                .build();
        final Request request = new Request.Builder()
                .url("http://bb.mansonnet.com/Api/Get_Goods_List")
                .post(formBody)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback(){
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                try {
                    JSONObject jsonObject = new JSONObject(str);
                    JSONArray jsonArray  = jsonObject.getJSONArray("Result");
                    List<MainModel>models1 = JSON.parseArray(""+jsonArray,MainModel.class);
                    models.addAll(models1);
                    send(1,"");
                }catch (JSONException e ){
                    e.printStackTrace();
                }
            }
        });
    }

    private void send(int what, String obj) {
        Message msg = new Message();
        msg.what = what;
        msg.obj = obj;
        handler.sendMessage(msg);
    }
    Handler handler = new Handler(){
        public  void  handleMessage(Message msg){
            switch (msg.what){
                case  1:
                    initData();
                    break;
                default:
            }
        }
    };
    private void initData() {
        adapter = new MainAdapter(getContext(),R.layout.layout_listview,models);
        listView.setAdapter(adapter);



            }
}


