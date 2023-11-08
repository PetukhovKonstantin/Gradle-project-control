package task2

const val LIMIT_IN_MONTH = 75_000
const val COMMISSION_PERCENT = 0.75
const val MINIMAL_COMMISSION = 35

fun main() {
    val type = "Mastercard"
    val prevTransfersInMonth = 70_000
    val amount = 6_000

    println("При переводе $amount руб. комиссия составит ${calcCommission(amount, type, prevTransfersInMonth)} руб.")
}

fun calcCommission(amount: Int, type: String = "VK Pay", prevTransfersInMonth: Int = 0): Int {
    var result = 0
    if (!(((type == "Mastercard" || type == "Maestro") && (prevTransfersInMonth+amount) < LIMIT_IN_MONTH) || type == "VK Pay"))
    {
        val commissionTotal = amount * COMMISSION_PERCENT / 100
        result = if (commissionTotal < MINIMAL_COMMISSION) MINIMAL_COMMISSION else (commissionTotal).toInt()
    }
    return result
}
