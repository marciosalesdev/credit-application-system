package me.dio.credit.application.system.controller

import me.dio.credit.application.system.dto.CustomerDto
import me.dio.credit.application.system.dto.CustomerVIew
import me.dio.credit.application.system.entity.Customer
import me.dio.credit.application.system.impl.CustomerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerResource (
private val customerService: CustomerService
) {
    @PostMapping
    fun saveCustomer(@RequestBody customerDto: CustomerDto): String {
        val savedCustomer = this.customerService.save(customerDto.toEntity())
        return "Customer ${savedCustomer.email} saved! "
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): CustomerVIew {
        val customer: Customer = this.customerService.findNyId(id)
        return CustomerVIew(customer)
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: Long) = this.customerService.delete(id)
}