package org.hzz.core.converter;

import org.hzz.common.date.DateUtil;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
public interface BaseConverter {
    @Named("mapDateToLocalDateTime")
    default LocalDateTime mapDateToLocalDateTime(Date date) {
        return DateUtil.changeDateToLocalDateTime(date);
    }

    @Named("mapLocalDateTimeToDate")
    default Date mapLocalDateTimeToDate(LocalDateTime dateTime) {
        return DateUtil.changeLocalDateTimeToDate(dateTime);
    }
}
