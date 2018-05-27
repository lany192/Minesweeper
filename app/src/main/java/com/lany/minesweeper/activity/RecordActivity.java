package com.lany.minesweeper.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lany.box.activity.BaseActivity;
import com.lany.box.utils.ListUtils;
import com.lany.minesweeper.R;
import com.lany.minesweeper.adapter.RecordAdapter;
import com.lany.minesweeper.entity.Record;

import org.litepal.crud.DataSupport;

import java.util.List;

import butterknife.BindView;

/**
 * 显示记录
 */
public class RecordActivity extends BaseActivity {
    @BindView(R.id.record_listview)
    ListView mListView;
    @BindView(R.id.record_empty_text)
    TextView mEmptyText;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_record;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initData();
    }

    private void initData() {
        List<Record> items = DataSupport.findAll(Record.class);
        if (ListUtils.isEmpty(items)) {
            mListView.setVisibility(View.GONE);
            mEmptyText.setVisibility(View.VISIBLE);
        } else {
            mListView.setVisibility(View.VISIBLE);
            mEmptyText.setVisibility(View.GONE);
            mListView.setAdapter(new RecordAdapter(items));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_record, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.record_menu_clear) {
            DataSupport.deleteAll(Record.class);
            initData();
            Toast.makeText(this, "清除记录成功", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
