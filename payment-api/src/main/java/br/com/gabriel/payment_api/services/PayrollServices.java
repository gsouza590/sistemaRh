package br.com.gabriel.payment_api.services;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import br.com.gabriel.payment_api.FeignClients.UserFeign;
import br.com.gabriel.payment_api.model.Payroll;
import br.com.gabriel.payment_api.model.User;
import br.com.gabriel.payment_api.services.exceptions.ObjectNotFoundExceptions;
import feign.FeignException;

@Service
public class PayrollServices {
	private static final Logger log = LoggerFactory.getLogger(PayrollServices.class);
	private final Environment env;
	private final UserFeign feign;

	public PayrollServices(Environment env, UserFeign feign) {
		this.env = env;
		this.feign = feign;
	}

	public Payroll getPayment(Long workerId, Payroll payroll) {
		log.info("Payroll Service :: Get Request on " + env.getProperty("local.server.port") + "port");
		try {
			User user = feign.findById(workerId).getBody();

			if (Objects.nonNull(user)) {
				return new Payroll(user.getName(), payroll.getDescription(), user.getHourlyPrice(),
						payroll.getWorkedHours(), payroll.getWorkedHours() * user.getHourlyPrice()

				);
			}
		} catch (FeignException.NotFound ex) {
			throw new ObjectNotFoundExceptions("Object not found");
		} catch (Exception ex) {
			throw new IllegalArgumentException("Illegal argument exception");
		}
		return null;
	}
}
