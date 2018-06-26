package com.prospective.guava.common;

import com.google.common.base.Preconditions;
import org.junit.Test;

public class PreConditionsTest {
    @Test
    public void test() {
        int i = 0;
       try{
           Preconditions.checkArgument(i > 1, "123");
       }catch (Exception e){
           System.out.println(11);
       }
    }
}
