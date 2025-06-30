package com.example.junit_demo;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    CalculatorTest.class,
    EvenCheckerTest.class
})
public class AllTests {
    // No @Test method here
}
