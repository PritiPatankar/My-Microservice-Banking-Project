package com.mybankms.accounts.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold customer and Account information")
public class CustomerDTO {

    @Schema(
            description = "Customer Name",
            example = "John Doe"
    )
    @NotEmpty(message = "Name cannot be Null or empty")
    @Size(min = 5, max = 30, message = "The length of Customer Name should be between 5 and 30 characters")
    private String name;

    @Schema(
            description = "Customer Email",
            example = "JohnDoe@gamil.com"
    )
    @NotEmpty(message= "Email cannot be Null or empty")
    @Email(message = "Email should be valid value")
    private String email;

    @Schema(
            description = "Customer Mobile Number",
            example = "9876543210"
    )
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Account Details of the Customer"
    )
    private AccountsDTO accountsDTO;
}
