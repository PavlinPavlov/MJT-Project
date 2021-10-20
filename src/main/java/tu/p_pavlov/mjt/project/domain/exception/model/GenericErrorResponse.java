package tu.p_pavlov.mjt.project.domain.exception.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;

@Getter
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class GenericErrorResponse {
    private final HttpStatus status;
    private final String message;
    private final String path;
    private final OffsetDateTime timestamp;
}
