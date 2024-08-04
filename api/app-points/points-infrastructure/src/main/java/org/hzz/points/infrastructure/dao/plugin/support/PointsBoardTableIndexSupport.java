package org.hzz.points.infrastructure.dao.plugin.support;

/**
 * 赛季积分表水平拆分支持
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/4
 */
public class PointsBoardTableIndexSupport {
    private static final ThreadLocal<Integer> pointsBoardTableIndexthreadLocal = new ThreadLocal<>();

    public static void setTableIndex(Integer index) {
        pointsBoardTableIndexthreadLocal.set(index);
    }

    public static Integer getTableIndex() {
        return pointsBoardTableIndexthreadLocal.get();
    }

    public static void clear() {
        pointsBoardTableIndexthreadLocal.remove();
    }
}
