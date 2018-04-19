package com.krok.error;

import java.util.regex.Matcher;

/**
 * Created by Mateusz Krok on 2018-04-19.
 */
public class AppException extends Exception {

    private AppError errorCode;

    private String message;

    private Object[] messageParams;

    private transient Throwable cause;

    public AppException(AppError errorCode, Object... msgParams) {
        this.errorCode = errorCode;
        this.message = replace(errorCode.getMessage(), msgParams);
        this.messageParams = msgParams;
    }

    public AppException(Throwable e, AppError errorCode, Object... msgParams) {
        this.cause = e;
        this.errorCode = errorCode;
        this.message = replace(errorCode.getMessage(), msgParams);
        this.messageParams = msgParams;
    }

    public AppError getErrorCode() {
        return errorCode;
    }

    public String getCodeMessage() {
        return "[" + getErrorCode() + "] " + message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object[] getMessageParams() {
        return messageParams;
    }

    public void setMessageParams(Object[] messageParams) {
        this.messageParams = messageParams;
    }

    @Override
    public synchronized Throwable getCause() {
        return cause;
    }

    @Override
    public String toString() {
        AppError code = getErrorCode();
        String msg = message;
        String name = getClass().getName();
        if (msg == null) {
            return new StringBuffer(name.length() + 12).append(name).append(": [").append(code).append("]").toString();
        } else {
            return new StringBuffer(name.length() + 13 + msg.length()).append(name).append(": [").append(code).append("] ").append(msg).toString();
        }
    }

    static String replace(String pMessage, Object[] pParams) {
        if (pParams != null && pMessage != null) {
            for (int i = 0; i < pParams.length; i++) {
                pMessage = pMessage.replaceAll("\\{" + i + "\\}", ((pParams.length > i && pParams[i] != null) ? Matcher.quoteReplacement(pParams[i].toString()) : "null"));
            }
        }
        return pMessage;
    }

}
