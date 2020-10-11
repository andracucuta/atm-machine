package com.cucutaa.atmmachine.rest;

import com.cucutaa.atmmachine.dto.AccountDetailsDTO;
import com.cucutaa.atmmachine.dto.CardActivationRequestDTO;
import com.cucutaa.atmmachine.dto.ATMRequest;
import com.cucutaa.atmmachine.model.CardActivationRequest;
import com.cucutaa.atmmachine.service.AccountService;
import com.cucutaa.atmmachine.service.CardService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.UUID;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final CardService cardService;

    @PutMapping(path = "/{accountNo}/cards/{cardId}/activate", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> activateCard(@PathVariable UUID accountNo,
                                             @PathVariable UUID cardId,
                                             @RequestHeader UUID clientId,
                                             @RequestBody CardActivationRequest cardActivationRequest) {

        var cardActivationRequestDTO = new CardActivationRequestDTO(
                accountNo, cardId, cardActivationRequest.getActivationPin(), clientId);

        cardService.activateCard(cardActivationRequestDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping(path = "/{accountNo}/deposit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deposit(@PathVariable String accountNo,
                                   @RequestHeader UUID clientId,
                                   @RequestHeader UUID atmMachineId,
                                   @RequestBody @Valid ATMRequest depositRequest) {

        accountService.deposit(atmMachineId, clientId, accountNo, depositRequest);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Deposit was successful");
    }


    @PutMapping(path = "/{accountNo}/withdraw", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> withdraw(@PathVariable String accountNo,
                                    @RequestHeader UUID clientId,
                                    @RequestHeader UUID atmMachineId,
                                    @RequestBody @Valid ATMRequest withdrawRequest) {

        accountService.withdraw(atmMachineId, accountNo, clientId, withdrawRequest);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Withdraw was successful");
    }

    @GetMapping(path = "/{accountNo}/checkBalance", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDetailsDTO> checkBalance(@PathVariable String accountNo,
                                   @RequestHeader UUID clientId,
                                   @RequestHeader UUID atmMachineId) {
        return ResponseEntity.ok(accountService.checkBalance(atmMachineId, accountNo, clientId));
    }
}
