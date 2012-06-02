package com.google.code.beanmatchers;

import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static java.lang.Boolean.TRUE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class BooleanGeneratorTest {

    private BooleanGenerator unitUnderTest;

    @Mock
    private Random randomMock;

    @BeforeMethod
    public void setUp() {
        initMocks(this);
        unitUnderTest = new BooleanGenerator(randomMock);
    }

    @Test
    public void shouldGenerateRandomInteger() {
        // given
        Boolean expectedValue = TRUE;
        when(randomMock.nextBoolean()).thenReturn(expectedValue);

        // when
        Boolean result = unitUnderTest.generate();

        // then
        assertThat(result, is(expectedValue));
    }
}
