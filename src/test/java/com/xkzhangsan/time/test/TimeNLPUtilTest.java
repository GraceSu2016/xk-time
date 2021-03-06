package com.xkzhangsan.time.test;

import java.util.List;

import org.junit.Test;

import com.xkzhangsan.time.formatter.DateTimeFormatterUtil;
import com.xkzhangsan.time.nlp.TimeNLP;
import com.xkzhangsan.time.nlp.TimeNLPUtil;

/**
 * 时间自然语言解析工具类测试
 * 
 * @author xkzhangsan
 */
public class TimeNLPUtilTest {

	/**
	 * 常见实例
	 */
	@Test
	public void timeNLPTest() {
		List<TimeNLP> timeNLPList = TimeNLPUtil.parse("Hi，all.下周一下午三点开会");
		System.out.println("Hi，all.下周一下午三点开会");
		System.out.println(DateTimeFormatterUtil.formatToDateTimeStr(timeNLPList.get(0).getTime()) + "-"
				+ timeNLPList.get(0).getIsAllDayTime());

		timeNLPList = TimeNLPUtil.parse("早上六点起床");
		System.out.println("早上六点起床");
		System.out.println(DateTimeFormatterUtil.formatToDateTimeStr(timeNLPList.get(0).getTime()) + "-"
				+ timeNLPList.get(0).getIsAllDayTime());

		timeNLPList = TimeNLPUtil.parse("周一开会");
		System.out.println("周一开会");
		System.out.println(DateTimeFormatterUtil.formatToDateTimeStr(timeNLPList.get(0).getTime()) + "-"
				+ timeNLPList.get(0).getIsAllDayTime());

		timeNLPList = TimeNLPUtil.parse("下下周一开会");
		System.out.println("下下周一开会");
		System.out.println(DateTimeFormatterUtil.formatToDateTimeStr(timeNLPList.get(0).getTime()) + "-"
				+ timeNLPList.get(0).getIsAllDayTime());

		timeNLPList = TimeNLPUtil.parse("6:30 起床");
		System.out.println("6:30 起床");
		System.out.println(DateTimeFormatterUtil.formatToDateTimeStr(timeNLPList.get(0).getTime()) + "-"
				+ timeNLPList.get(0).getIsAllDayTime());

		timeNLPList = TimeNLPUtil.parse("6-3 春游");
		System.out.println("6-3 春游");
		System.out.println(DateTimeFormatterUtil.formatToDateTimeStr(timeNLPList.get(0).getTime()) + "-"
				+ timeNLPList.get(0).getIsAllDayTime());

		timeNLPList = TimeNLPUtil.parse("6月3春游");
		System.out.println("6月3春游");
		System.out.println(DateTimeFormatterUtil.formatToDateTimeStr(timeNLPList.get(0).getTime()) + "-"
				+ timeNLPList.get(0).getIsAllDayTime());

		timeNLPList = TimeNLPUtil.parse("明天早上跑步");
		System.out.println("明天早上跑步");
		System.out.println(DateTimeFormatterUtil.formatToDateTimeStr(timeNLPList.get(0).getTime()) + "-"
				+ timeNLPList.get(0).getIsAllDayTime());

		timeNLPList = TimeNLPUtil.parse("本周日到下周日出差");
		System.out.println("本周日到下周日出差");
		System.out.println(DateTimeFormatterUtil.formatToDateTimeStr(timeNLPList.get(0).getTime()) + "-"
				+ timeNLPList.get(0).getIsAllDayTime());
		System.out.println(DateTimeFormatterUtil.formatToDateTimeStr(timeNLPList.get(1).getTime()) + "-"
				+ timeNLPList.get(1).getIsAllDayTime());

		timeNLPList = TimeNLPUtil.parse("周四下午三点到五点开会");
		System.out.println("周四下午三点到五点开会");
		System.out.println(DateTimeFormatterUtil.formatToDateTimeStr(timeNLPList.get(0).getTime()) + "-"
				+ timeNLPList.get(0).getIsAllDayTime());
		System.out.println(DateTimeFormatterUtil.formatToDateTimeStr(timeNLPList.get(1).getTime()) + "-"
				+ timeNLPList.get(1).getIsAllDayTime());

		timeNLPList = TimeNLPUtil.parse("《辽宁日报》今日报道，7月18日辽宁召开省委常委扩大会，会议从下午两点半开到六点半，主要议题为：落实中央巡视整改要求。",
				"2016-07-19-00-00-00");
		System.out.println("《辽宁日报》今日报道，7月18日辽宁召开省委常委扩大会，会议从下午两点半开到六点半，主要议题为：落实中央巡视整改要求。");
		for (int i = 0; i < timeNLPList.size(); i++) {
			System.out.println("时间文本:" + timeNLPList.get(i).getTimeExpression() + ",对应时间:"
					+ timeNLPList.get(i).getTimeNormFormat());
		}
	}

	/**
	 * 标准时间
	 */
	@Test
	public void normStandardTimeTest() {
		List<TimeNLP> timeNLPList = TimeNLPUtil.parse("2016-07-19对应时间");
		System.out.println("2016-07-19对应时间");
		System.out.println(DateTimeFormatterUtil.formatToDateTimeStr(timeNLPList.get(0).getTime()) + "-"
				+ timeNLPList.get(0).getIsAllDayTime());

		timeNLPList = TimeNLPUtil.parse("2016-07-19 15:30:10对应时间");
		System.out.println("2016-07-19 15:30:10对应时间");
		System.out.println(DateTimeFormatterUtil.formatToDateTimeStr(timeNLPList.get(0).getTime()) + "-"
				+ timeNLPList.get(0).getIsAllDayTime());

		timeNLPList = TimeNLPUtil.parse("2016-07-19 15:30对应时间");
		System.out.println("2016-07-19 15:30对应时间");
		System.out.println(DateTimeFormatterUtil.formatToDateTimeStr(timeNLPList.get(0).getTime()) + "-"
				+ timeNLPList.get(0).getIsAllDayTime());

	}
}
