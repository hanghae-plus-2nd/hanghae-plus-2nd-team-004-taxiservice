package hanghae.four.taxiservice.interfaces.taxi.call

import hanghae.four.taxiservice.application.taxi.call.CallFacade
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CallApiController(
    private val callFacade: CallFacade,
    private val callMapper: CallApiMapper,
) {

    @PostMapping("/api/v1/call")
    fun callTaxi(@RequestBody callRequest: CallRequest): ResponseEntity<CallResponse> {
        val callResult = callFacade.call(callMapper.mapToCallCommand(callRequest))
        return ResponseEntity.ok(callMapper.mapToResponse(callResult))
    }

    @GetMapping("/api/v1/call/{callId}")
    fun callTaxi(
        @PathVariable callId: Long,
    ): ResponseEntity<CallDetailResponse> {
        val detailInfo = callFacade.getCallDetailInfo(callId)
        return ResponseEntity.ok(callMapper.mapToCallDetailResponse(detailInfo))
    }

    @GetMapping("/api/v1/call/clients")
    fun getCallingClients(): ResponseEntity<CallingClientsResponse> {
        val callingClients = callFacade.getCallingClients()
        return ResponseEntity.ok(callMapper.mapToCallingClientsResponse(callingClients))
    }
}
