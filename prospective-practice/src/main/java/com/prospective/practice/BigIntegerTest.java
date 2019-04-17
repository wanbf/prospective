package com.prospective.practice;

import com.google.common.collect.Maps;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author wanbf
 * @date 2019/3/3 20:19
 */
public class BigIntegerTest {
    public static void main(String[] args) throws ParseException {
        /*Map<BigInteger,String> map = Maps.newHashMap();
        map.put(BigInteger.valueOf(11),"aa");
        System.out.println(map.get(BigInteger.valueOf(11)));*/
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        Date beginDate = df.parse("2017-06-09 10:22:22");
        Date endDate = df.parse("2019-05-08 11:22:22");
        if (now.after(beginDate) && now.before(endDate)) {
            System.out.println("now time is between  beginDate and enDate");
        } else {
            System.out.println("now time is not between beginDate and enDate");
        }

    }
}
