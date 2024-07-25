package org.hzz.remark.infrastructure.repository.mybatis;

import org.hzz.core.repository.nomapper.BaseRepository;
import org.hzz.remark.domain.repository.LikedRecordRepository;
import org.hzz.remark.infrastructure.dao.mapper.liked.LikedRecordMapper;
import org.springframework.stereotype.Repository;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/25
 */
@Repository
public class LikedRecordRepositoryImpl
        extends BaseRepository<LikedRecordMapper>
        implements LikedRecordRepository {
}
