package com.prospective.practice.pay;

/**
 * Created by wanbf on 2018/3/1.
 */
public class ConsultResult {


    public ConsultResult(String paymentType, boolean isEnable, String errorCode) {
        this.paymentType = paymentType;
        this.isEnable = isEnable;
        this.errorCode = errorCode;
    }

    public ConsultResult(String paymentType) {
        this.paymentType = paymentType;
    }

    private String paymentType;

    private boolean isEnable;


    private String errorCode;

    public boolean isEnable() {
        return isEnable;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
