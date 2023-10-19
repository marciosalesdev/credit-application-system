package me.dio.credit.application.system.impl


import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.repository.CreditRepository
import me.dio.credit.application.system.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService)
    :ICreditService {

    override fun save(credit: Credit): Credit {
       credit.apply {
           customer = customerService.findNyId(credit.customer?.id!!)
       }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> {
        TODO("Not yet implemented")
    }

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
       val credit: Credit = (this.creditRepository.findByCreditCode((creditCode))
       ?: throw RuntimeException("CreditCode $creditCode not found"))
    return if (credit.customer?.id == customerId) credit else throw RuntimeException("Contact admin")
       /* if (credit.customer?.id == customerId){
            return credit
        } else{
            throw RuntimeException("Contact admin")
        }*/
    }
}


}