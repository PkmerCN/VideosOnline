package org.hzz.application.command;

import lombok.experimental.Accessors;
import org.hzz.application.handler.AddCouponHandler;
import io.gitee.pkmer.ddd.shared.command.CommandWithMark;
import io.gitee.pkmer.ddd.shared.service.CmdService;
import org.hzz.promotions.types.enums.coupon.DiscountType;
import org.hzz.promotions.types.enums.coupon.ObtainWay;
import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:1193094618@qq.com">pkmer</a>
 * <br>
 * <a href = "https://gitee.com/pkmer/sonatype-central-publisher">Code Repository</a>
 * At 2024/8/29
 * 添加优惠券命令
 * {@link AddCouponHandler}
 */
@Data
@Accessors(chain = true)
public class AddCouponCmd implements CommandWithMark {
    // 优惠券名称，可以和活动名称保持一致
    String name;
    // 分类集合
    List<String> scopes = Collections.emptyList();

    // 是否限定作用范围，false：不限定，true：限定。默认false
    Boolean specific;
    // 折扣类型，1：满减，2：每满减，3：折扣，4：无门槛
    DiscountType discountType;

    // 折扣值，如果是满减则存满减金额，如果是折扣，则存折扣率，8折就是存80
    Integer discountValue;
    // 最高优惠金额，满减最大，0：表示没有限制，不为0，则表示该券有金额的限制
    Integer maxDiscountAmount;
    // 获取方式：1：手动领取，2：兑换码
    ObtainWay obtainWay;

    // 使用门槛，0：表示无门槛，其他值：最低消费金额
    Integer thresholdAmount;

    // 总数量，不超过5000
    Integer totalNum;

    // 每个人限领的数量，默认1
    Integer userLimit;

    // 创建人
    private Long creater;

    // 更新人
    private Long updater;

    public static final String MARK = AddCouponCmd.class.getName();

    @Override
    public String mark() {
        return MARK;
    }

    public void execute(CmdService cmdService) {
       cmdService.handleCommand(this);
    }
}
