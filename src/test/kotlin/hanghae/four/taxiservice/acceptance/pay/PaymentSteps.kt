package hanghae.four.taxiservice.acceptance.pay

import hanghae.four.taxiservice.acceptance.AcceptanceTestSteps
import hanghae.four.taxiservice.domain.pay.payinfo.PayInfo
import io.restassured.response.ExtractableResponse
import io.restassured.response.Response
import org.springframework.http.MediaType
import java.math.BigDecimal

class PaymentSteps : AcceptanceTestSteps() {

    companion object {
        fun `택시 요금 결제`(
            clientId: Long,
            callNumber: String,
            payInfo: Long?,
            amount: BigDecimal,
            payType: PayInfo.Type,
        ): ExtractableResponse<Response> {
            val params: MutableMap<String, Any?> = mutableMapOf()
            params.put("clientId", clientId)
            params.put("callNumber", callNumber)
            params.put("payInfoId", payInfo)
            params.put("amount", amount)
            params.put("payType", payType)

            return given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(params)
                .`when`().post("/api/v1/pay")
                .then().log().all().extract()
        }
    }
}
