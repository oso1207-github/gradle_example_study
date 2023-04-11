package org.example;

/*
* • 요구사항
*• 간단한 사칙연산을 할 수 있다.
*• 양수로만 계산할 수 있다.
*• 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.
*• MVC패턴(Model-View-Controller) 기반으로 구현한다.
* */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;


public class CalculatorTest {

    @DisplayName("연산을 수행한다.")
    @ParameterizedTest // 해당 어노테이션을 사용하기 위해서는 정적 메서드이어야 한다.
    @MethodSource("formulAndResult")
    void calculateTest(int operand1, String operator, int operand2, int result) {

        int calculateResult = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        assertThat(result).isEqualTo(3);

    }

    public static Stream<Arguments> formulAndResult() {
        return Stream.of(
                arguments(1, "+", 2, 3)
        );
    }

    @DisplayName("덧셈 연산을 수행한다.")
    @Test
    void additionTest() {

        int result = Calculator.calculate(new PositiveNumber(1), "+", new PositiveNumber(2));

        assertThat(result).isEqualTo(3);

    }

    @DisplayName("뺄셈 연산을 수행한다.")
    @Test
    void subtractionTest() {

        int result = Calculator.calculate(new PositiveNumber(2), "-", new PositiveNumber(2));

        assertThat(result).isEqualTo(1);

    }
}
