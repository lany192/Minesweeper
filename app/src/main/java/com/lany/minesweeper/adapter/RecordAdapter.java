package com.lany.minesweeper.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lany.minesweeper.R;
import com.lany.minesweeper.entity.Record;

import java.text.SimpleDateFormat;
import java.util.List;

public class RecordAdapter extends BaseAdapter {
    private Context mContext;
    private List<Record> mRecordLists;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public RecordAdapter(Context context, List<Record> records) {
        this.mContext = context;
        this.mRecordLists = records;
    }

    @Override
    public int getCount() {
        if (mRecordLists != null) {
            return mRecordLists.size();
        }
        return 0;
    }

    @Override
    public Record getItem(int position) {
        if (mRecordLists != null) {
            return mRecordLists.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.record_item_layout, null);
            viewHolder.createTimeText = (TextView) convertView
                    .findViewById(R.id.record_listview_item_create_time);
            viewHolder.recordValuseText = (TextView) convertView
                    .findViewById(R.id.record_listview_item_valuse);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Record record = mRecordLists.get(position);
        if (record != null) {
            long createTime = record.getRecordCreateTime();
            String time = format.format(createTime);
            if (!TextUtils.isEmpty(time)) {
                viewHolder.createTimeText.setText(time);
            }
            viewHolder.recordValuseText.setText(record.getRecordValue() + mContext.getString(R.string.second));
        }
        return convertView;
    }

    private class ViewHolder {
        private TextView createTimeText;
        private TextView recordValuseText;
    }
}
