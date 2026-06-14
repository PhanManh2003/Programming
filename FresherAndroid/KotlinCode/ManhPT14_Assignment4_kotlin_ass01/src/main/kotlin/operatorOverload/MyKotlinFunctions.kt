package operatorOverload

// cần file này để cho Main.java gọi'

// cộng tru nhan chia
fun add(a: Long, b: Long): Long {
    return (LongNumber(a) + LongNumber(b)).value
}

fun subtract(a: Long, b: Long): Long {
    return (LongNumber(a) - LongNumber(b)).value
}

fun multiply(a: Long, b: Long): Long {
    return (LongNumber(a) * LongNumber(b)).value
}

fun divide(a: Long, b: Long): Long {
    return (LongNumber(a) / LongNumber(b)).value
}