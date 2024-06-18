package org.hzz.context;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/18
 */
public abstract class AppCommonContextHolder<T> {
    private final ThreadLocal<T> threadLocal = new ThreadLocal<>();

    abstract public String getContextName();

    protected void setObject(T t) {
        threadLocal.set(t);
    }

    protected T getObject() {
        return threadLocal.get();
    }

    public void clear() {
        threadLocal.remove();
    }

}
