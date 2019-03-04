package com.mhdss.shop.admin.controller;

import com.mhdss.shop.client.Exception.NotLoginException;
import com.mhdss.shop.client.constants.ErrorCode;
import com.mhdss.shop.client.constants.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;


@RestControllerAdvice
public class ApiErrorController {

    private static final Logger logger = LoggerFactory.getLogger(ApiErrorController.class);

    @ExceptionHandler
    public ResponseData<?> execute(Exception e) {
        logger.error("{}", "System:error", e.getMessage(), e);

        if (e instanceof NotLoginException) {

            return ResponseData.error(ErrorCode.NO_LOGIN);
        }

        if (e instanceof HttpMessageNotReadableException) {
            return ResponseData.error(ErrorCode.HTTP_MESSAGE_READ_ERROR);
        }

        if (e instanceof NoHandlerFoundException) {
            return ResponseData.error(ErrorCode.NO_HANDLER_FOUND);
        }

        return ResponseData.error(ErrorCode.UNKNOWN_ERROR);
    }
}
