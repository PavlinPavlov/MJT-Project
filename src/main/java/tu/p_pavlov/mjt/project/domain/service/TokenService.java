package tu.p_pavlov.mjt.project.domain.service;

public interface TokenService {

    String extractUserId(String jwtToken);

}