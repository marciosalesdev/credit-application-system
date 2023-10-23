package me.dio.credit.application.system.controller

import me.dio.credit.application.system.dto.CreditDto
import me.dio.credit.application.system.dto.CreditViewList
import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.impl.CreditService
import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors


@RestController
@RequestMapping("/api/credits")
class CreditResource (
    private val  creditService : CreditService
){
  @PostMapping
  fun saveCredit(@RequestBody creditDto: CreditDto): String{
val credit: Credit = this.creditService.save(creditDto.toEntity())
      return "Credit ${credit.creditCode} - Customer ${credit.customer?.firstName} saved!"
  }
  @GetMapping
  fun findAllByCustomerId(@RequestParam(value = "customerId") customerId: Long): List<CreditViewList>{
     return this.creditService.findAllByCustomer(customerId).stream().map{ credit :Credit -> CreditViewList(credit) }.collect(Collectors.toList())
  }
}