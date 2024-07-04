package org.hzz.learning.domain.entity;

import lombok.Data;
import org.hzz.ddd.core.domain.shared.Entity;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 统计
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/5
 */
@Data
public class IdAndNumEntity implements Entity {
    private Long id;
    private Integer num;

    public static Map<Long,Integer> toMap(List<IdAndNumEntity> list){
        return list.stream().collect(Collectors.toMap(
                IdAndNumEntity::getId,
                IdAndNumEntity::getNum));
    }
}
