package com.example.viacep;

import com.example.viacep.functions.ViaCep;
import com.example.viacep.model.ViaCepRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionRegistration;
import org.springframework.cloud.function.context.FunctionType;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

import java.util.function.Function;

@SpringBootApplication
public class ViacepApplication implements ApplicationContextInitializer<GenericApplicationContext> {

	public static void main(String[] args) {
		SpringApplication.run(ViacepApplication.class, args);
	}

	@Override
	public void initialize(GenericApplicationContext context) {
		context.registerBean("viaCep", FunctionRegistration.class,
				() -> new FunctionRegistration<Function<ViaCepRequest, String>>(new ViaCep())
						.type(FunctionType.from(ViaCepRequest.class).to(String.class).getType()));
	}
}