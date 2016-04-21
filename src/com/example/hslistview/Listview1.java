/**
 * 
 */
package com.example.hslistview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * @file Listview1.java
 * @author xiaoyang
 * @date ����11:16:00
 * @tag
 */
public class Listview1 extends Activity {
	private CityListAdapter Xueliadapter;
	private static final String[] strs = new String[] { "first", "second", "third", "fourth", "fifth" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_listview1);
		ListView moLvCity = (ListView) findViewById(R.id.lv1);
		// Xueliadapter = new CityListAdapter(Listview1.this);
		// moLvCity.setAdapter(Xueliadapter);
		// Xueliadapter.setData(getData());
		moLvCity.setAdapter(new ArrayAdapter<String>(this, R.layout.item_city_list, strs));
	}

	// ����ѧ������
	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> llList = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "��ר");
		map.put("id", "0");
		llList.add(map);
		map = new HashMap<String, Object>();
		map.put("name", "����");
		map.put("id", "1");
		llList.add(map);
		map = new HashMap<String, Object>();
		map.put("name", "�о���");
		map.put("id", "2");
		llList.add(map);
		map = new HashMap<String, Object>();
		map.put("name", "��ʿ");
		map.put("id", "3");
		llList.add(map);
		map = new HashMap<String, Object>();
		map.put("name", "��ʿ��");
		map.put("id", "4");
		llList.add(map);
		map = new HashMap<String, Object>();
		map.put("name", "����");
		map.put("id", "5");
		llList.add(map);
		return llList;
	}
}
