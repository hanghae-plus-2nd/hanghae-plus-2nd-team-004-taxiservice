package hanghae.four.taxiservice.domain.taxi.call

import hanghae.four.taxiservice.domain.taxi.TaxiAllocator
import hanghae.four.taxiservice.domain.taxi.TaxiFinder
import hanghae.four.taxiservice.domain.taxi.call.dispatch.toCallResult
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CallService(
    val taxiFinder: TaxiFinder,
    val taxiAllocator: TaxiAllocator,
) {
    fun call(callCommand: CallCommand): CallResult {
        // todo: locking 조회 시점엔 택시가 running 상태가 아니어도 최종 시점엔 running 상태일 수 있음
        val usableTaxis = taxiFinder.findUsableTaxis(callCommand.type)
        return taxiAllocator.execute(usableTaxis, callCommand).toCallResult()
    }
}