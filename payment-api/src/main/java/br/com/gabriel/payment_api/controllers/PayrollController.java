package br.com.gabriel.payment_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.payment_api.model.Payroll;
import br.com.gabriel.payment_api.services.PayrollServices;

@RestController
@RequestMapping(value = "/api/payments")
public class PayrollController {

	private final PayrollServices service;

	public PayrollController(PayrollServices service) {
		this.service = service;
	}

	@GetMapping(value = "/{workerId}")
	public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, Payroll payment) {

		return ResponseEntity.ok().body(service.getPayment(workerId, payment));
	}
}
