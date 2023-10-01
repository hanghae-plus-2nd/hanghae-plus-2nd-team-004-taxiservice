package hanghae.four.taxiservice.applications.taxi

import hanghae.four.taxiservice.domain.taxi.TaxiCommand
import hanghae.four.taxiservice.domain.taxi.TaxiService
import org.springframework.stereotype.Service

@Service
class TaxiFacade(
    private val taxiService: TaxiService
) {
    fun register(request: TaxiCommand.RegisterTaxi): Long {
        return taxiService.register(request)
    }
}
