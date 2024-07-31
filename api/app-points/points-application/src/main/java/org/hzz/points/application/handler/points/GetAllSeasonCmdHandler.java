package org.hzz.points.application.handler.points;

import lombok.Setter;
import org.hzz.core.converter.TargetAndSourceConverter;
import org.hzz.ddd.core.domain.shared.command.CommandHandler;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.points.application.command.points.GetAllSeasonCmd;
import org.hzz.points.domain.entity.PointsBoardSeasonEntity;
import org.hzz.points.domain.service.points.PointsBoardSeasonDomainService;
import org.hzz.points.types.resp.SeasonVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/31
 */
@Component
public class GetAllSeasonCmdHandler implements CommandHandler,
        AbstractExecuteStrategy<GetAllSeasonCmd, List<SeasonVo>> {

    @Setter(onMethod_ = @Autowired)
    private PointsBoardSeasonDomainService seasonDomainService;

    @Override
    public String mark() {
        return GetAllSeasonCmd.MARK;
    }

    @Override
    public List<SeasonVo> executeWithResp(GetAllSeasonCmd cmd) {
        List<PointsBoardSeasonEntity> allSeason = seasonDomainService.getAllSeason();
        List<SeasonVo> targets = Converter.INSTANCE.toTargets(allSeason);
        // todo caffeine来做缓存
        return targets;
    }

    @Mapper
    interface Converter extends TargetAndSourceConverter<SeasonVo,PointsBoardSeasonEntity>{
        Converter INSTANCE = Mappers.getMapper(Converter.class);
    }
}
