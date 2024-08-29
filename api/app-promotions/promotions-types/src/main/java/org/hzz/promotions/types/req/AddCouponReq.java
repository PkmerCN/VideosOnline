package org.hzz.promotions.types.req;

import com.alibaba.fastjson2.annotation.JSONField;
import io.gitee.pkmer.fastjson2.enums.BaseEnumReader;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hzz.promotions.types.enums.coupon.DiscountType;
import org.hzz.promotions.types.enums.coupon.ObtainWay;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:1193094618@qq.com">pkmer</a>
 * <br>
 * <a href = "https://gitee.com/pkmer/sonatype-central-publisher">Code Repository</a>
 * At 2024/8/29
 */
@Data
@Schema(description = "添加优惠券请求")
public class AddCouponReq {
    @Schema(description = "优惠券名称",example = "新年大促")
    @NotBlank(message = "优惠券名称不能为空")
    String name;

    @Schema(description = "分类集合",example = "2001,2003,2004")
    @Size(min = 1,message = "分类不能为空")
    List<String> scopes = Collections.emptyList();

    @Schema(description = "是否限定作用范围，false：不限定，true：限定。默认false",example = "false")
    Boolean specific = false;

    @Schema(description = "折扣类型，1：满减，2：每满减，3：折扣，4：无门槛",example = "1")
    @JSONField(deserializeUsing = BaseEnumReader.class)
    @NotNull
    DiscountType discountType;

    @Schema(description = "折扣值，如果是满减则存满减金额，如果是折扣，则存折扣率，8折就是存80",example = "15")
    @NotNull
    Integer discountValue;

    @Schema(description = "最高优惠金额，满减最大，0：表示没有限制，不为0，则表示该券有金额的限制",example = "0")
    @NotNull
    Integer maxDiscountAmount;

    @Schema(description = "获取方式，1：手动领取，2：兑换码",example = "1")
    @JSONField(deserializeUsing = BaseEnumReader.class)
    @NotNull
    ObtainWay obtainWay;

    @Schema(description = "使用门槛，0：表示无门槛，其他值：最低消费金额")
    @NotNull
    Integer thresholdAmount;

    @Schema(description = "总数量，不超过5000",example = "200")
    @NotNull
    Integer totalNum;


    @Schema(description = "每人限领数量，默认1",example = "1")
    private Integer userLimit = 1;
}
