package com.cos.crud.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyUtils {
	public static Timestamp getCurrentTime() {
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		Calendar cal = Calendar.getInstance();
		String today = null;
		today = formatter.format(cal.getTime());
		Timestamp ts = Timestamp.valueOf(today);
		System.out.println(ts);
		return ts;
	}
}
