package hanghae.four.taxiservice.domain.pay.payinfo

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "pay_info")
class PayInfo(

    @Column(name = "client_id", nullable = false)
    val clientId: Long,

    @Column(name = "type", nullable = false)
    val type: Type,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {

    enum class Type(
        private val description: String,
    ) {
        CASH("현금"),

        SAMSUNGCARD("삼성카드"),
        HYUNDAICARD("현대카드"),
        LOTTECARD("롯데카드"),

        NAVERPAY("네이버페이"),
        KAKAOPAY("카카오페이"),
        TOSSPAY("토스페이"),
        ;

        fun cashCheck(): Boolean {
            return this == CASH
        }
    }
}
