package calculator

// 첫 번째 기능 요구사항
// 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
// ex) "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6

// 두 번째 기능 요구사항
// 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다.
// 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
// ex) "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.

// 세 번째 기능 요구사항
// 사용자가 잘못된 값을 입력할 경우`IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
class Calculator {

    fun getSum(text: String?): Int {
        var total = 0

        if (text.isNullOrEmpty()) {
            return 0
        }

        for (number in text.split(Regex("[,:]"))) {
            if (!number.all { it.isDigit() }) {
                throw IllegalArgumentException("Invalid number $number")
            }

            val num = number.toInt()
            if (num < 0) {
                throw IllegalArgumentException("Invalid number $number")
            }
            total += num
        }
        return total
    }
}