package operatorOverload

class LongNumber(val value: Long) {
    // overload toán tử +
    operator fun plus(other: LongNumber): LongNumber {
        return LongNumber(this.value + other.value)
    }

    // overload toán tử -
    operator fun minus(other: LongNumber): LongNumber {
        return LongNumber(this.value - other.value)
    }

    // overload toán tử *
    operator fun div(other: LongNumber): LongNumber {
        return LongNumber(this.value / other.value)
    }

    // overload toán tử /
    operator fun times(other: LongNumber): LongNumber {
        require(other.value != 0L) { // require sẽ throw exception
            "Không thể chia cho 0"
        }
        return LongNumber(this.value * other.value)
    }
}