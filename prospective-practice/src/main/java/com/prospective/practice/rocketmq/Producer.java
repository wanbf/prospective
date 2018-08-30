package com.prospective.practice.rocketmq;

import com.alibaba.rocketmq.common.message.Message;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;

public class Producer {
    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("Producer");
        producer.setNamesrvAddr("192.168.95.150:9876");
        try {
            producer.start();
            int i = 0;

            while (true) {
                i++;
                Message msg = new Message("PushTopic",
                        "push",
                        "1",
                        ("Just for yyp" + i).getBytes());
                SendResult result = producer.send(msg);

                msg = new Message("PullTopic",
                        "pull",
                        "1",
                        "Just for test.".getBytes());
                result = producer.send(msg);
                System.out.println("id:" + result.getMsgId() +
                        " result:" + result.getSendStatus());
                if (i % 10 == 0) {
                    Thread.sleep(20000);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // producer.shutdown();
        }
    }
}