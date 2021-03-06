package com.sale.cellphone.utils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DateUtils {
	private static final List<Long> times = Arrays.asList(TimeUnit.DAYS.toMillis(365), TimeUnit.DAYS.toMillis(30),
			TimeUnit.DAYS.toMillis(1), TimeUnit.HOURS.toMillis(1), TimeUnit.MINUTES.toMillis(1),
			TimeUnit.SECONDS.toMillis(1));
	private static final List<String> timesString = Arrays.asList("năm", "tháng", "ngày", "giờ", "phút", "giây");

	private static String toDuration(long duration) {

		StringBuffer res = new StringBuffer();
		for (int i = 0; i < DateUtils.times.size(); i++) {
			Long current = DateUtils.times.get(i);
			long temp = duration / current;
			if (temp > 0) {
				res.append(temp).append(" ").append(DateUtils.timesString.get(i)).append(" trước");
				break;
			}
		}
		if ("".equals(res.toString()))
			return "vừa xong";
		else
			return res.toString();
	}

	public static String toAgo(Date date) {
		long duration = System.currentTimeMillis() - date.getTime();
		return toDuration(duration);
	}
}
