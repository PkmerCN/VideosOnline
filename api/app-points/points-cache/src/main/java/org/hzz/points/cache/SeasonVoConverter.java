package org.hzz.points.cache;

import org.hzz.core.converter.TargetAndSourceConverter;
import org.hzz.points.domain.entity.PointsBoardSeasonEntity;
import org.hzz.points.types.resp.SeasonVo;
import org.mapstruct.Mapper;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/1
 */
@Mapper(componentModel = "spring")
public interface SeasonVoConverter extends TargetAndSourceConverter<SeasonVo, PointsBoardSeasonEntity> {
}
