package calculator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class CalculatorTest {
    @Test
    fun `첫 번째 기능 요구 사항 테스트`() {
        val calculator = Calculator() // 인스턴스 생성

        assertThat(calculator.getSum(null)).isEqualTo(0)
        assertThat(calculator.getSum("")).isEqualTo(0)
        assertThat(calculator.getSum("1,2")).isEqualTo(3)
        assertThat(calculator.getSum("1,2,3")).isEqualTo(6)
        assertThat(calculator.getSum("1,2:3")).isEqualTo(6)
    }

    @Test
    fun `숫자가 아닌 문자 포함 시 예외 발생`() {
        val calculator = Calculator()
        val exception = assertThrows<IllegalArgumentException> {
            calculator.getSum("1,2,a")
        }
        assertThat(exception.message).isEqualTo("Invalid number a")
    }

    @Test
    fun `음수 입력 시 예외 발생`() {
        val calculator = Calculator()
        val exception = assertThrows<IllegalArgumentException> {
            calculator.getSum("-1,2:3")
        }
        assertThat(exception.message).isEqualTo("Invalid number -1")
    }
}