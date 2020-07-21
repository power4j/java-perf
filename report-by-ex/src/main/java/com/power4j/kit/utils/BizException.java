package com.power4j.kit.utils;

/**
 * @author CJ (jclazz@outlook.com)
 * @date 2020/6/14
 * @since 1.0
 */
public class BizException extends RuntimeException {
    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }
}
