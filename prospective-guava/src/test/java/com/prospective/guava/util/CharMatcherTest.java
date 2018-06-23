package com.prospective.guava.util;

import com.google.common.base.CharMatcher;

/**
 * Created by wanbf on 2018/1/29.
 */
public class CharMatcherTest {
    public static void main(String args[]){
        CharMatcherTest tester = new CharMatcherTest();
        tester.testCharMatcher();
    }

    private void testCharMatcher(){
        System.out.println(CharMatcher.DIGIT.retainFrom("mahesh123")); // only the digits
        System.out.println(CharMatcher.WHITESPACE.trimAndCollapseFrom("     Mahesh     Parashar ", ' '));
        // trim whitespace at ends, and replace/collapse whitespace into single spaces
        System.out.println(CharMatcher.JAVA_DIGIT.replaceFrom("mahesh123", "*")); // star out all digits
        System.out.println(CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom("mahesh123"));
        // eliminate all characters that aren't digits or lowercase
    }
}
