package com.example.apigatewayservice.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class GlobalFilter extends AbstractGatewayFilterFactory<GlobalFilter.Config> {

	public GlobalFilter() {
		super(Config.class);
	}

	@Override
	public GatewayFilter apply(Config config) {
		// Global pre filter
		return (exchange, chain) -> {
			ServerHttpRequest request = exchange.getRequest();
			ServerHttpResponse response = exchange.getResponse();

			log.info("Global Filter Base Message = {}", config.getBaseMessage());

			if (config.isPreLogger()) {
				log.info("Global Filter Start: Request ID = {}", request.getId());
			}

			// Global post filter
			return chain.filter(exchange).then(
				Mono.fromRunnable(() -> {
						if (config.isPostLogger()) {
							log.info("Global Filter End: Response Code = {}", response.getStatusCode());
						}
					}
				));
		};
	}

	@Getter
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Config {
		private String baseMessage;
		private boolean preLogger;
		private boolean postLogger;
	}
}
