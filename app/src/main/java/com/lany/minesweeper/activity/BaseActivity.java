package com.lany.minesweeper.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.LayoutParams;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import com.lany.minesweeper.R;

/**
 * 所有activity的基类
 */
public abstract  class BaseActivity extends AppCompatActivity implements OnClickListener {
	protected final String TAG = this.getClass().getSimpleName();
	protected LayoutInflater mInflater;
	private ActionBar mActionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "onCreate");
		onBeforeSetContentView();
		if (getLayoutId() != 0) {
			setContentView(getLayoutId());
		}
		mInflater = getLayoutInflater();// 要在initActionBar之前
		if (hasActionBar()) {
			initActionBar();
		}
		init(savedInstanceState);
	}


	/**
	 * setContentView之前要做的事情
	 */
	protected void onBeforeSetContentView() {
	}

	/**
	 * 是否需要ActionBar
	 */
	protected boolean hasActionBar() {
		return true;
	}



	/**
	 * 设置布局文件R.layout
	 */
	protected abstract int getLayoutId();

	protected View inflateView(int resId) {
		return mInflater.inflate(resId, null);
	}

	/**
	 * 获得ActionBarTitle
	 */
	protected int getActionBarTitle() {
		return R.string.app_name;
	}

	/**
	 * 是否需要返回按钮
	 */
	protected boolean hasBackButton() {
		return false;
	}

	/**
	 * ActionBar自定义视图的R.layout
	 * 
	 * @return
	 */
	protected int getActionBarCustomViewLayoutRescId() {
		return 0;
	}

	/**
	 * 是否需要自定义头部视图,默认不自定义
	 * 
	 * @return
	 */
	protected boolean hasActionBarCustomView() {
		return false;
	}

	protected abstract void init(Bundle savedInstanceState);

	/**
	 * 自行处理自定义后的视图
	 */
	protected void handlerActionBarCustomViewAction(View customActionbarView) {

	}

	protected void initActionBar() {
		mActionBar = getSupportActionBar();
		mActionBar.setDisplayShowTitleEnabled(true);
		mActionBar.setDisplayUseLogoEnabled(true);

		if (hasBackButton()) {
			mActionBar.setDisplayShowHomeEnabled(false);
			mActionBar.setDisplayHomeAsUpEnabled(true);
		}
		if (hasActionBarCustomView()) {
			mActionBar.setDisplayShowCustomEnabled(true);
			int layoutRes = getActionBarCustomViewLayoutRescId();
			View actionBarView = inflateView(layoutRes);
			LayoutParams params;
			if (isAllActionBarCustom()) {
				//XLog.i(TAG, "全部");
				params = new LayoutParams(LayoutParams.MATCH_PARENT,
						LayoutParams.MATCH_PARENT);
			} else {
				//XLog.i(TAG, "右边");
				params = new LayoutParams(LayoutParams.WRAP_CONTENT,
						LayoutParams.MATCH_PARENT);
				params.gravity = Gravity.RIGHT;
			}
			mActionBar.setCustomView(actionBarView, params);
			handlerActionBarCustomViewAction(actionBarView);
		}
		mActionBar.setTitle(getActionBarTitle());
	}

	protected boolean isAllActionBarCustom() {
		return false;
	}

	public void setActionBarTitle(int resId) {
		if (resId != 0) {
			setActionBarTitle(getString(resId));
		}
	}

	public void setActionBarTitle(String title) {
		if (hasActionBar()) {
			mActionBar.setTitle(title);
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			onBackPressed();
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {

	}

	@Override
	protected void onDestroy() {
		Log.i(TAG, "onDestroy");
		super.onDestroy();
	}
}