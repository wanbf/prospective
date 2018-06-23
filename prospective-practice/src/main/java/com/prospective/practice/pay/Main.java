package com.prospective.practice.pay;

import com.google.common.collect.ImmutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by wanbf on 2018/3/1.
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static final PaymentRemoteService service = new PaymentRemoteServiceImpl();
    private static final CompletionService<ConsultResult> cs = new ExecutorCompletionService<>(Executors.newCachedThreadPool());
    private static final ImmutableList<String> paymentTypes = ImmutableList.of("balance", "kickback", "coupon", "voucher");
    private static List<ConsultResult> availablePayments = new ArrayList<>();

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int paymentTypeLength = paymentTypes.size();
        final CountDownLatch latch = new CountDownLatch(paymentTypeLength);
        for (int i = 0; i < paymentTypeLength; i++) {
            final String paymentType = paymentTypes.get(i);
            cs.submit(() -> {
                try {
                    return service.isEnabled(paymentType);
                } catch (Throwable ex) {
                    return new ConsultResult(paymentType);
                } finally {
                    latch.countDown();
                }
            });
        }

        try {
            latch.await();
            for (int i = 0; i < paymentTypeLength; i++) {
                ConsultResult result = cs.take().get();
                if (result != null && result.isEnable()) {
                    availablePayments.add(result);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("程序运行时间： %sms", endTime - startTime));
    }

}
