package hanghae.four.taxiservice.domain.pay

interface PaymentStore {
    fun store(paymentHistory: Payment): Payment
}
