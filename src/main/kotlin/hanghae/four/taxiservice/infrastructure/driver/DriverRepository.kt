package hanghae.four.taxiservice.infrastructure.driver

import hanghae.four.taxiservice.domain.taxi.call.driver.Driver
import org.springframework.data.jpa.repository.JpaRepository

interface DriverRepository : JpaRepository<Driver, Long>
