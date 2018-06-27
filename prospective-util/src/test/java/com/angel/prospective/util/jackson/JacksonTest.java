package com.angel.prospective.util.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;

import java.io.IOException;

/**
 * Created by wanbf on 2018/6/26.
 */
public class JacksonTest extends TestCase {

    public void test1() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue("{\"name\":\"Bob\", \"age\":13}", User.class);
        assertEquals("Bob", user.getName());
    }

}
