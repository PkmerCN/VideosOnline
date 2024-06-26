package org.hzz.common.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 时间工具
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/26
 */
public class DateUtil {

   public static LocalDateTime changeDateToLocalDateTime(Date date){
       return date != null ? LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()) : null;
   }

   public static Date changeLocalDateTimeToDate(LocalDateTime dateTime){
       return dateTime != null ? Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant()) : null;
   }
}
