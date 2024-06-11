package br.com.gabriel.payment_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.payment_api.model.Payroll;

@RestController
@RequestMapping(value = "/api/payments")
public class PayrollController {

	@GetMapping(value = "/{workerId}")
	public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, Payroll payment) {
		return ResponseEntity.ok().body(new Payroll("Gabriel", payment.getDescription(), payment.gethourlyPrice(), 100.0, payment.gethourlyPrice()*payment.getWorkedHours()));
	}
}
