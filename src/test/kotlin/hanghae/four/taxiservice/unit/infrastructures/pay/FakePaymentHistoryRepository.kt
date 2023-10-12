package hanghae.four.taxiservice.unit.infrastructures.pay

import hanghae.four.taxiservice.domain.pay.PaymentHistory
import hanghae.four.taxiservice.domain.pay.PaymentHistoryStore
import java.util.concurrent.atomic.AtomicLong

class FakePaymentHistoryRepository : PaymentHistoryStore {
    private val autoGeneratedId: AtomicLong = AtomicLong(0)
    private val paymentHistories: ArrayList<PaymentHistory> = ArrayList()

    override fun store(paymentHistory: PaymentHistory): PaymentHistory {
        if (paymentHistory.id == null) {
            val savePaymentHistory = PaymentHistory(
                id = autoGeneratedId.incrementAndGet(),
                clientId = paymentHistory.clientId,
                callId = paymentHistory.callId,
                type = paymentHistory.type,
                amount = paymentHistory.amount
            )

            paymentHistories.add(savePaymentHistory)
            return savePaymentHistory
        }

        paymentHistories.removeIf { p -> p.id == paymentHistory.id }
        paymentHistories.add(paymentHistory)
        return paymentHistory
    }
}