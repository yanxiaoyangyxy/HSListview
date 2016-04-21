package com.example.hslistview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private int width;
	private HorizontalScrollView mHs_view;
	private LinearLayout mLl_view;
	private static final String[] strs = new String[] { "一", "二", "三", "四", "五" };
	private static final String[] strs2 = new String[] { "1", "2", "3", "4", "5" };
	private static final String[] strs3 = new String[] { "one", "two", "three", "four", "five" };
	private int page = 1;
	private View view2;
	private View view1;
	private View view3;
	private ListView lv1;
	private ListView lv2;
	private ListView lv3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mHs_view = (HorizontalScrollView) findViewById(R.id.hsv1);
		mLl_view = (LinearLayout) findViewById(R.id.ll1);
		WindowManager wm = this.getWindowManager();
		width = wm.getDefaultDisplay().getWidth() / 2;
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, LinearLayout.LayoutParams.FILL_PARENT);

		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		view1 = inflater.inflate(R.layout.act_listview1, null, false);
		lv1 = (ListView) view1.findViewById(R.id.lv1);
		view2 = inflater.inflate(R.layout.act_listview2, null, false);
		lv2 = (ListView) view2.findViewById(R.id.lv2);
		view3 = inflater.inflate(R.layout.act_listview3, null, false);
		lv3 = (ListView) view3.findViewById(R.id.lv3);
		lv1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strs));
		view1.setLayoutParams(params);
		lv2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strs2));
		view2.setLayoutParams(params);
		lv3.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strs3));
		view3.setLayoutParams(params);
		mLl_view.addView(view1);
		setListetner();
	}

	private void setListetner() {
		lv1.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				page = 2;
				changeView();
			}
		});
		lv2.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				page = 3;
				changeView();
				onResume();
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
		mHs_view.post(new Runnable() {
			@Override
			public void run() {
				mHs_view.scrollTo(width, 0);
			}
		});
	}

	private void changeView() {
		if (page == 2) {
			if (mLl_view.getChildCount() == 1) {
				mLl_view.addView(view2);
			}
		} else if (page == 3) {
			Log.i("yxy", String.valueOf(mLl_view.getChildCount()));
			if (mLl_view.getChildCount() != 3) {
				mLl_view.addView(view3);
			}
		}
	}
}
