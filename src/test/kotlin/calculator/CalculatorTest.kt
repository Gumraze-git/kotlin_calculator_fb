package calculator

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class CalculatorTest {
    @Test
    fun `첫 번째 기능 요구 사항 테스트`() {
        val calculator = Calculator() // 인스턴스 생성

        assertThat(calculator.getSum(null)).isEqualTo(0)
        assertThat(calculator.getSum("")).isEqualTo(0)
        assertThat(calculator.getSum("1,2")).isEqualTo(3)
        assertThat(calculator.getSum("1,2,3")).isEqualTo(6)
    }
}