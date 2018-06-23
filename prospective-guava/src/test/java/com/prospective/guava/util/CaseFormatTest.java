package com.prospective.guava.util;

import com.google.common.base.CaseFormat;

/**
 * Created by wanbf on 2018/1/29.
 */
public class CaseFormatTest {
    public static void main(String args[]){
        CaseFormatTest tester = new CaseFormatTest();
        tester.testCaseFormat();
    }

    private void testCaseFormat(){
        String data = "test_data";
        System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, data));
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, data));
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, data));
    }
}
