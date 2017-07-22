package br.com.api.capsrnrb.util;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class LibraryDateHour {
	
	public Calendar nextTimeInMinutes(int pMinutes){
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		
		calendar.add(Calendar.MINUTE, pMinutes);
		
		return calendar;
		
	}
	
	
	public Calendar getCurrentDate(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		
		return calendar;
	}

}
