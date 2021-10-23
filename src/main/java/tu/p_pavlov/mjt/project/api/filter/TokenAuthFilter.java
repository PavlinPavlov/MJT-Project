package tu.p_pavlov.mjt.project.api.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;
import tu.p_pavlov.mjt.project.domain.service.TokenService;

import java.util.Objects;

@Component
public class TokenAuthFilter implements WebFilter {

    private static final String NO_TOKEN = "No (legitimate) token passed!";
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenAuthFilter.class);

    private final TokenService tokenService;

    public TokenAuthFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        ServerHttpRequest serverHttpRequest = exchange.getRequest();
        ServerHttpResponse serverHttpResponse = exchange.getResponse();

        String token = getTokenFromRequest(serverHttpRequest);

        if (!StringUtils.hasText(token)) {
            LOGGER.warn("No Authentication!");
            serverHttpResponse.setStatusCode(HttpStatus.UNAUTHORIZED);
            return Mono.empty();
        }

        validate(token);

        return chain.filter(exchange);
    }

    private void validate(String token) {
        LOGGER.info("Validating {}", token);

        String userId = tokenService.extractUserId(token);

        LOGGER.info("Authenticated user with id: {}", userId);
    }

    private String getTokenFromRequest(ServerHttpRequest request) {

        String token;
        try {
            token = Objects.requireNonNull(request.getHeaders().get(AUTHORIZATION_HEADER)).get(0);
        } catch (NullPointerException e) {
            return null;
        }

        if (StringUtils.hasText(token) && token.startsWith(BEARER_PREFIX)) {
            return token.substring(BEARER_PREFIX.length());
        }

        return null;
    }
}