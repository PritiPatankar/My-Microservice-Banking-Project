package com.mybankms.accounts.controller;

import com.mybankms.accounts.Constants.AccountsConstants;
import com.mybankms.accounts.DTO.AccountsContactInfoDTO;
import com.mybankms.accounts.DTO.CustomerDTO;
import com.mybankms.accounts.DTO.ErrorResponseDTO;
import com.mybankms.accounts.DTO.ResponseDTO;
import com.mybankms.accounts.service.IAccountsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "CRUD REST APIs for Accounts Management",
        description = "APIs to create, fetch, update and delete account details"
)
@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
//@AllArgsConstructor //by this, a constructor with iAccountsService will be generated so no need to use @Autowired annotation.
public class AccountsController {

    private final IAccountsService iAccountsService;

    public AccountsController(IAccountsService iAccountsService) {
        this.iAccountsService = iAccountsService;
    }

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    private Environment environment;

    @Autowired
    private AccountsContactInfoDTO accountsContactInfoDTO;

    @Operation(
            summary = "Create Account API",
            description = "API to create account details for a customer"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    }
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAccount(@Valid @RequestBody CustomerDTO customerDTO){
        iAccountsService.createAccount(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @Operation(
            summary = "Fetch Account API",
            description = "API to fetch account details for a customer based on mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    }
    )
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDTO> fetchAccountDetails(@RequestParam @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits") String mobileNumber){
        CustomerDTO customerDTO = iAccountsService.fetchAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDTO);
    }

    @Operation(
            summary = "Update Account API",
            description = "API to update account details for a customer"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Account details updated successfully"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error while updating account details"),
    }
    )
    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateAccountDetails( @Valid @RequestBody CustomerDTO customerDTO){
        boolean isUpdated = iAccountsService.updateAccount(customerDTO);
        if(isUpdated){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDTO(AccountsConstants.STATUS_500, AccountsConstants.MESSAGE_500));
        }
    }

    @Operation(
            summary = "Delete Account API",
            description = "API to delete account details for a customer based on mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    }
    )
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteAccountDetails(@RequestParam @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits") String mobileNumber) {
        boolean isDeleted = iAccountsService.deleteAccount(mobileNumber);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDTO(AccountsConstants.STATUS_500, AccountsConstants.MESSAGE_500));
        }
    }

    @Operation(
            summary = "Get Build information",
            description = "Get Build information that is deployed into accounts microservice"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    }
    )
    @GetMapping("/build-info")
    public ResponseEntity<String> getBuildInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(buildVersion);
    }

    @Operation(
            summary = "Get Contact Info API",
            description = "Get the build information of the Accounts microservice"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    }
    )
    @GetMapping("/contact-info")
    public ResponseEntity<AccountsContactInfoDTO> getContactInfo() {
        return ResponseEntity.status(HttpStatus.OK).body(accountsContactInfoDTO);
    }
}
