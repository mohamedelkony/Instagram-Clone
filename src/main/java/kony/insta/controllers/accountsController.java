package kony.insta.controllers;

import kony.insta.exceptions.NotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import kony.insta.dto.account.*;
import kony.insta.services.AccountsService;

import javax.validation.Valid;
import javax.validation.constraints.*;

@RestController
@RequestMapping("/account")
@Validated
public class accountsController {

    private final AccountsService accountsService;

    public accountsController(AccountsService accountsService) {
        this.accountsService = accountsService;
    }

    @PostMapping
    public registerDTOres register(@RequestBody @Valid registerDTO user) {
        return this.accountsService.registerUser(user);
    }

    @GetMapping("/{username}")
    public getUserDTO getUser(@PathVariable String username) {
        return this.accountsService.getUser(username);
    }
}
