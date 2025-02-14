package calculator

// 첫 번째 기능 요구사항
// 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
// ex) "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
class Calculator {

    fun getSum(text: String?): Int {
        var total = 0

        if (text.isNullOrEmpty()) {
            return 0
        }

        for (number in text.split(Regex("[,:]"))) {
            total += number.toInt()
        }
        return total
    }
}