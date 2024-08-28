package io.gitee.pkmer.coupon.infrastructure.dao.mapper.coupon;

import io.gitee.pkmer.coupon.infrastructure.dao.model.coupon.Coupon;
import io.gitee.pkmer.coupon.infrastructure.dao.model.coupon.CouponExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CouponMapper {
    long countByExample(CouponExample example);

    int deleteByExample(CouponExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Coupon row);

    int insertSelective(Coupon row);

    List<Coupon> selectByExampleWithBLOBs(CouponExample example);

    List<Coupon> selectByExample(CouponExample example);

    Coupon selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") Coupon row, @Param("example") CouponExample example);

    int updateByExampleWithBLOBs(@Param("row") Coupon row, @Param("example") CouponExample example);

    int updateByExample(@Param("row") Coupon row, @Param("example") CouponExample example);

    int updateByPrimaryKeySelective(Coupon row);

    int updateByPrimaryKeyWithBLOBs(Coupon row);

    int updateByPrimaryKey(Coupon row);
}