package org.hzz.common.date;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * 时间工具
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/26
 */
public class DateUtil {

    public static final String DEFAULT_MONTH_FORMAT_COMPACT = "yyyyMM";

    /**
     * 格式202407
     */
    public static DateTimeFormatter getMonthFormatCompact(){
        return DateTimeFormatter.ofPattern(DEFAULT_MONTH_FORMAT_COMPACT);
    }

   public static LocalDateTime changeDateToLocalDateTime(Date date){
       return date != null ? LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()) : null;
   }

   public static Date changeLocalDateTimeToDate(LocalDateTime dateTime){
       return dateTime != null ? Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant()) : null;
   }

    /**
     * 获取指定日期的起始时间
     * @param dateTime 指定日期
     * @return 起始时间
     */
   public static LocalDateTime getStartOfDay(LocalDateTime dateTime){
        if (dateTime == null){
            throw new IllegalArgumentException("dateTime 不能为空");
        }
//        return dateTime.toLocalDate().atStartOfDay();
        return dateTime.toLocalDate().atTime(LocalTime.MIN);
   }

    /**
     * 获取指定日期的结束时间
     * @param dateTime 指定日期
     * @return 结束时间
     */
    public static LocalDateTime getEndOfDay(LocalDateTime dateTime){
        if (dateTime == null){
            throw new IllegalArgumentException("dateTime 不能为空");
        }

        return dateTime.toLocalDate().atTime(LocalTime.MAX);
    }


    /**
     * 返回当前时间所在周的周开始时间
     */
   public static LocalDateTime getStartOfWeek(){
       LocalDateTime now = LocalDateTime.now();
       return now.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
               .withHour(0)
               .withMinute(0)
               .withSecond(0);
   }


    /**
     * 返回当前时间所在周的周结束时间
     */
   public static LocalDateTime getEndOfWeek(){
       LocalDateTime now = LocalDateTime.now();
       return now.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY))
               .withHour(23)
               .withMinute(59)
               .withSecond(59);
   }

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().format(getMonthFormatCompact()));
        System.out.println("当前时间: " + LocalDateTime.now());
        System.out.println("本周起始时间: " + getStartOfWeek());
        System.out.println("本周结束时间: " + getEndOfWeek());

        System.out.println("今天的起始时间: " + getStartOfDay(LocalDateTime.now()));
        System.out.println("今天的结束时间: " + getEndOfDay(LocalDateTime.now()));
    }
}
