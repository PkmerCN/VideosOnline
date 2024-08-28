package io.gitee.pkmer.coupon.infrastructure.dao.mapper.coupon;

import io.gitee.pkmer.coupon.infrastructure.dao.model.coupon.CouponScope;
import io.gitee.pkmer.coupon.infrastructure.dao.model.coupon.CouponScopeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CouponScopeMapper {
    long countByExample(CouponScopeExample example);

    int deleteByExample(CouponScopeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CouponScope row);

    int insertSelective(CouponScope row);

    List<CouponScope> selectByExample(CouponScopeExample example);

    CouponScope selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") CouponScope row, @Param("example") CouponScopeExample example);

    int updateByExample(@Param("row") CouponScope row, @Param("example") CouponScopeExample example);

    int updateByPrimaryKeySelective(CouponScope row);

    int updateByPrimaryKey(CouponScope row);
}