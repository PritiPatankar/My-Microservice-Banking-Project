package com.mybankms.accounts.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(
        name = "ErrorResponse",
        description = "Schema to hold error response information")
@Data
@AllArgsConstructor
public class ErrorResponseDTO {

    @Schema(
            description = "API path where the error occurred",
            example = "/api/create"
    )
    private String apiPath;

    @Schema(
            description = "HTTP Status code of the error response",
            example = "500"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "Error message describing the error",
            example = "Internal Server Error"
    )
    private String errorMessage;

    @Schema(
            description = "Timestamp when the error occurred",
            example = "2024-06-01T12:00:00"
    )
    private LocalDateTime errorTime;




}
