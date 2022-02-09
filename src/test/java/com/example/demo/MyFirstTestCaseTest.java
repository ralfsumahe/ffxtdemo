package com.example.demo;

import org.junit.jupiter.api.*;

import java.time.Duration;

@DisplayName("我的第一个测试用例")
public class MyFirstTestCaseTest {

    @BeforeAll
    public static void init() {
        System.out.println("初始化数据");
    }

    @AfterAll
    public static void cleanup() {
        System.out.println("清理数据");
    }

    @BeforeEach
    public void tearup() {
        System.out.println("当前测试方法开始");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("当前测试方法结束");
    }

    @DisplayName("我的第一个测试")
    @Test
    void testFirstTest() {
        System.out.println("我的第一个测试开始测试");
    }

    @DisplayName("我的第二个测试")
    @Test
    void testSecondTest() {
        System.out.println("我的第二个测试开始测试");
    }

    @DisplayName("重复测试")
    @RepeatedTest(value = 3, name = RepeatedTest.LONG_DISPLAY_NAME)
    void testRepeated() {
        System.out.println("重复测试开始");
    }

    @Test
    @DisplayName("组断言")
    void testGroupAssertions() {
        int[] numbers = {0, 1, 2, 3, 4, 5};
        Assertions.assertAll(
                () -> Assertions.assertEquals(0, numbers[0]),
                () -> Assertions.assertEquals(1, numbers[2]),
                () -> Assertions.assertEquals(2, numbers[2])
        );
    }

    @Test
    @DisplayName("1秒内完成")
    void testShouldCompleteOneSeconds() {
        Assertions.assertAll(
                () -> Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
                    Thread.sleep(2000);
                    System.out.println("测试结束1");
                }),

                () -> Assertions.assertTimeout(Duration.ofSeconds(1), () -> {
                    Thread.sleep(2000);
                    System.out.println("测试结束2");
                })
        );
    }

}