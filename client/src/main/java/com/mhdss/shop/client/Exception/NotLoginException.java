package com.mhdss.shop.client.Exception;

/**
 * 未登录异常 携带当前登录失效接口URL,及登录接口的URL
 */
@SuppressWarnings("serial")
public class NotLoginException extends RuntimeException {

	public NotLoginException() {
	}

	public NotLoginException(String message) {
		super(message);
	}

	public NotLoginException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotLoginException(Throwable cause) {
		super(cause);
	}

	public NotLoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
