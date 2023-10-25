package me.dio.credit.application.system.service

import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import me.dio.credit.application.system.impl.CustomerService
import me.dio.credit.application.system.repository.CustomerRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ActiveProfiles
import java.math.BigDecimal


@ActiveProfiles("test")
@ExtendWith(MockKExtension::class)
class CustomerServiceTest {
    @MockK lateinit var customerRepository: CustomerRepository
    @InjectMockKs lateinit var customerService: CustomerService

    @Test
    fun 'should create customer'(){
        //given

        //when

        //then
    }
    private fun buildCustomer(
    firstName: String = "Marcio",
    lastName: String = "Sales",
    cpf: String = "075.970.310-84",
    email: String = "marciosales@123.com",
    password: String = "1234123",
    zipCode: String = "12345",
    street: String = "Rua omar",
    income: BigDecimal = BigDecimal.valueOf(1000.0),
    id: Long = 1L,
        ){





    ) {
    }


}