package com.lany.minesweeper.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lany.box.adapter.BasicAdapter;
import com.lany.minesweeper.R;
import com.lany.minesweeper.entity.Record;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class RecordAdapter extends BasicAdapter<Record> {
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    public RecordAdapter(List<Record> items) {
        super(items);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = getItemView(R.layout.record_item_layout, parent);
            viewHolder.createTimeText = (TextView) convertView
                    .findViewById(R.id.record_listview_item_create_time);
            viewHolder.recordValuseText = (TextView) convertView
                    .findViewById(R.id.record_listview_item_valuse);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Record record = getItem(position);
        if (record != null) {
            long createTime = record.getRecordCreateTime();
            String time = format.format(createTime);
            if (!TextUtils.isEmpty(time)) {
                viewHolder.createTimeText.setText(time);
            }
            viewHolder.recordValuseText.setText(record.getRecordValue() + getContext().getString(R.string.second));
        }
        return convertView;
    }

    private class ViewHolder {
        private TextView createTimeText;
        private TextView recordValuseText;
    }
}
