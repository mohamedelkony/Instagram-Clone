package kony.insta.controllers;

import kony.insta.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import kony.insta.dto.account.*;
import kony.insta.services.AccountsService;

@RestController
@RequestMapping("/account")
public class accountsController {


    private final AccountsService accountsService;

    public accountsController(AccountsService accountsService) {
        this.accountsService = accountsService;
    }

    @PostMapping
    public long register(@RequestBody registerDTO user) {
        return this.accountsService.registerUser(user);
    }


    @GetMapping("/{id}")
    public getUserDTO getUser(@PathVariable Long id) throws NotFoundException {
        return  this.accountsService.getUser(id);
    }
}
