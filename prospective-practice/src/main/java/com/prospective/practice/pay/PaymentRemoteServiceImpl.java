package com.prospective.practice.pay;

/**
 * Created by wanbf on 2018/3/1.
 */
public class PaymentRemoteServiceImpl implements PaymentRemoteService {
    @Override
    public ConsultResult isEnabled(String paymentType) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if ("balance".equals(paymentType))
            return new ConsultResult("balance", true, "");
        return null;
    }
}
