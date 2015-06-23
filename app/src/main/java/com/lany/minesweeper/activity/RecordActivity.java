package com.lany.minesweeper.activity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lany.minesweeper.R;
import com.lany.minesweeper.adapter.RecordAdapter;
import com.lany.minesweeper.entity.Record;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;

/**
 * 显示记录
 */
public class RecordActivity extends BaseActivity {
    private ListView mListView;
    private List<Record> mRecordLists = new ArrayList<>();
    private RecordAdapter mAdapter;
    private TextView mEmptyText;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_record;
    }

    @Override
    protected boolean hasBackButton() {
        return true;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initView();
        initData();
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.record_listview);
        mEmptyText=(TextView)findViewById(R.id.record_empty_text);
    }

    private void initData() {
        mRecordLists = DataSupport.findAll(Record.class);
        if(mRecordLists==null||mRecordLists.size()<1){
            mListView.setVisibility(View.GONE);
            mEmptyText.setVisibility(View.VISIBLE);
        }else{
            mListView.setVisibility(View.VISIBLE);
            mEmptyText.setVisibility(View.GONE);
            mAdapter=new RecordAdapter(this,mRecordLists);
            mListView.setAdapter(mAdapter);
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
            Toast.makeText(this,"清除记录成功",Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
