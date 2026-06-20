package com.mybankms.accounts.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;

@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
@Data
public class AccountsDTO {

    @Schema(
            description = "Account Number",
            example = "1234567890"
    )
    @NotEmpty(message = "Account Number cannot be Null or empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Account number should be 10 digits")
    private Long accountNumber;

    @Schema(
            description = "Account Type",
            example = "Savings"
    )
    @NotEmpty(message = "Account Type cannot be Null or empty")
    private String accountType;

    @Schema(
            description = "Branch Address",
            example = "123 Main St, Anytown, USA"
    )
    @NotEmpty(message = "Branch Address cannot be Null or empty")
    private String branchAddress;


}
