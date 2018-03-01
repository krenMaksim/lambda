package com.kren.yorberton.chapter2;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.text.DateFormatter;

public class Ex2 {
    public final static ThreadLocal<DateFormatter> formatter = ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy")));

    public static void main(String[] args) throws ParseException {
	Format dateFormatter = formatter.get()
					.getFormat();

	System.out.println(dateFormatter.parseObject("01-Jan-1970"));
    }

}
