package org.hzz.learning.infrastructure.dao.mapper.record;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hzz.learning.domain.entity.IdAndNumEntity;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/5
 */
@Mapper
public interface RecordExtMapper {

    List<IdAndNumEntity> countUserFinishedSections(
            @Param("userId") Long userId,
            @Param("startTime")LocalDateTime startTime,
            @Param("endTime")LocalDateTime endTime
            );
}
