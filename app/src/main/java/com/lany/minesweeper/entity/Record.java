package com.lany.minesweeper.entity;

import org.litepal.crud.DataSupport;

/**
 * Created by user on 2015/6/23.
 */
public class Record extends DataSupport {
    private int id;
    private long recordCreateTime;
    private int recordValue;

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public long getRecordCreateTime() {
        return recordCreateTime;
    }

    public void setRecordCreateTime(long recordCreateTime) {
        this.recordCreateTime = recordCreateTime;
    }

    public int getRecordValue() {
        return recordValue;
    }

    public void setRecordValue(int recordValue) {
        this.recordValue = recordValue;
    }
}
