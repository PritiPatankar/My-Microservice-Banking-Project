package com.mybankms.accounts.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(
        name = "Response",
        description = "Schema to hold response information")
@Data
@AllArgsConstructor
public class ResponseDTO {

    @Schema(
            description = "Status Code of the API response",
            example = "201"
    )
    private String statusCode;

    @Schema(
            description = "Status Message of the API response",
            example = "Account created successfully"
    )
    private String statusMsg;

}
