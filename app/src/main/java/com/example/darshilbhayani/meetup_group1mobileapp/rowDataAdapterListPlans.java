package com.example.darshilbhayani.meetup_group1mobileapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class rowDataAdapterListPlans extends BaseAdapter {

    private Context rContext;
    private List<rowDataListPlans> rowDataList;

    public rowDataAdapterListPlans(Context rContext, List<rowDataListPlans> rowDataList) {
        this.rContext = rContext;
        this.rowDataList = rowDataList;
    }

    @Override
    public int getCount() {
        return rowDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return rowDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(rContext, R.layout.listplan_rowdata,null);

        TextView eventNm = v.findViewById(R.id.planNm);
        TextView evenDatTime = v.findViewById(R.id.dateTime);
        TextView duration = v.findViewById(R.id.duration);
        ImageView imgSource = (ImageView) v.findViewById(R.id.img);
        //ImageView imgSourceNav = (ImageView) v.findViewById(R.id.imgforNavigation);

        eventNm.setText(String.valueOf(rowDataList.get(position).getEventNm()));
        evenDatTime.setText(rowDataList.get(position).getDate().toString()+" - "+rowDataList.get(position).getTime().toString());
        duration.setText(String.valueOf(rowDataList.get(position).getDuration()));
        imgSource.setImageResource(rowDataList.get(position).getImgSrc());
        //imgSourceNav.setImageResource(rowDataList.get(position).getImgSrc());

        v.setTag(rowDataList.get(position).getId());

        return v;
    }
}
