package org.hzz.auth.repository.mybatis;

import org.hzz.auth.dao.TestConnectionMapper;
import org.hzz.auth.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/22
 */
@Repository
public class TestRespositoryImpl implements TestRepository {
    @Autowired
    private TestConnectionMapper testConnectionMapper;
    @Override
    public String testConnection() {
        return testConnectionMapper.testConnection();
    }
}
