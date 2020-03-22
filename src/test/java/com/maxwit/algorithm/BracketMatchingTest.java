package com.maxwit.algorithm;

import org.junit.Assert;
import org.junit.Test;

public class BracketMatchingTest {

    @Test
    public void test() {
        String ex= "{ () []}";
        Assert.assertTrue(BracketMatching.matching(ex));

        ex = "{(] ()}";
        Assert.assertTrue(!BracketMatching.matching(ex));
    }
}
