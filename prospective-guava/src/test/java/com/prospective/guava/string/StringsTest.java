package com.prospective.guava.string;

import com.google.common.base.CaseFormat;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import junit.framework.TestCase;

import java.util.Collection;

public class StringsTest extends TestCase {
    public void test1() {
        Joiner joiner = Joiner.on("; ").skipNulls();
        String str = joiner.join("Harry", null, "Ron", "Hermione");
        assertEquals("Harry; Ron; Hermione", str);
    }

    public void testSplitter() {
        Iterable<String> iterable = Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("foo,bar,,   qux");
        Collection<String> collection = Lists.newArrayList();
        for (String str : iterable) {
            collection.add(str);
        }
        assertEquals(3, collection.size());

        String str = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME");
        assertEquals("constantName", str);
    }
}
