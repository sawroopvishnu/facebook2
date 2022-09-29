package com.facebook2.app.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utils {
	public static Date stringTodate(String date2) {
		 
    	DateFormat format = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);
    	Date date = null;
		try {
			date = format.parse(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
    	
    }
}
