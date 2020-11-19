package com.example.weather.db;

import java.util.ArrayList;
import java.util.List;

import com.example.weather.model.city;
import com.example.weather.model.country;
import com.example.weather.model.province;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class coolweather {

	/**
	 * ���ݿ���
	 */
	public static final String DB_NAME = "cool_weather";

	/**
	 * ���ݿ�汾
	 */
	public static final int VERSION = 1;

	private static coolweather coolWeatherDB;

	private SQLiteDatabase db;

	/**
	 * ���췽��˽�л�
	 */
	private coolweather(Context context) {
		weather dbHelper = new weather(context,
				DB_NAME, null, VERSION);
		db = dbHelper.getWritableDatabase();
	}

	/**
	 * ��ȡCoolWeatherDB��ʵ��
	 */
	public synchronized static coolweather getInstance(Context context) {
		if (coolWeatherDB == null) {
			coolWeatherDB = new coolweather(context);
		}
		return coolWeatherDB;
	}

	/**
	 * ��Provinceʵ���洢�����ݿ�
	 */
	public void saveProvince(province province) {
		if (province != null) {
			ContentValues values = new ContentValues();
			values.put("province_name", province.getprovinceName());
			values.put("province_code", province.provinceCode());
			db.insert("Province", null, values);
		}
	}

	/**
	 * �����ݿ��ȡȫ�����е�ʡ����Ϣ
	 */
	public List<province> loadProvinces() {
		List<province> list = new ArrayList<province>();
		Cursor cursor = db
				.query("Province", null, null, null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				province province = new province();
				province.setId(cursor.getInt(cursor.getColumnIndex("id")));
				province.setprovinceName(cursor.getString(cursor
						.getColumnIndex("province_name")));
				province.setprovinceCode(cursor.getString(cursor
						.getColumnIndex("province_code")));
				list.add(province);
			} while (cursor.moveToNext());
		}
		return list;
	}

	/**
	 * ��Cityʵ���洢�����ݿ�
	 */
	public void saveCity(city city) {
		if (city != null) {
			ContentValues values = new ContentValues();
			values.put("city_name", city.CityName());
			values.put("city_code", city.CityCode());
			values.put("province_id", city.getprovinceId());
			db.insert("City", null, values);
		}
	}

	/**
	 * �����ݿ��ȡĳʡ�����еĳ�����Ϣ
	 */
	public List<city> loadCities(int provinceId) {
		List<city> list = new ArrayList<city>();
		Cursor cursor = db.query("City", null, "province_id = ?",
				new String[] { String.valueOf(provinceId) }, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				city city = new city();
				city.setId(cursor.getInt(cursor.getColumnIndex("id")));
				city.getCityName(cursor.getString(cursor
						.getColumnIndex("city_name")));
				city.getCityCode(cursor.getString(cursor
						.getColumnIndex("city_code")));
				city.setprovinceId(provinceId);
				list.add(city);
			} while (cursor.moveToNext());
		}
		return list;
	}

	/**
	 * ��Countryʵ���洢�����ݿ�
	 */
	public void savecountry(country country) {
		if (country != null) {
			ContentValues values = new ContentValues();
			values.put("county_name", country.CountryName());
			values.put("county_code", country.CountryCode());
			values.put("city_id", country.getcityId());
			db.insert("County", null, values);
		}
	}

	/**
	 * �����ݿ��ȡĳ���������е�����Ϣ
	 */
	public List<country> loadCounties(int cityId) {
		List<country> list = new ArrayList<country>();
		Cursor cursor = db.query("County", null, "city_id = ?",
				new String[] { String.valueOf(cityId) }, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				country county = new country();
				county.setId(cursor.getInt(cursor.getColumnIndex("id")));
				county.getCountryName(cursor.getString(cursor
						.getColumnIndex("county_name")));
				county.getCountryCode(cursor.getString(cursor
						.getColumnIndex("county_code")));
				county.setcityId(cityId);
				list.add(county);
			} while (cursor.moveToNext());
		}
		return list;
	}

}

