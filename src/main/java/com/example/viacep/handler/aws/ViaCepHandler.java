package com.example.viacep.handler.aws;

import com.example.viacep.model.ViaCepRequest;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class ViaCepHandler extends SpringBootRequestHandler<ViaCepRequest, String> {
}
