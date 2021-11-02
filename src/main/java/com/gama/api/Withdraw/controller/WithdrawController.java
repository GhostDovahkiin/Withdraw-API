package com.gama.api.Withdraw.controller;

import com.gama.api.Withdraw.model.dto.WithdrawDTO;
import com.gama.api.Withdraw.repository.WithdrawRepository;
import com.gama.api.Withdraw.service.WithdrawService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/current-account/withdraw")
public class WithdrawController {
    private final WithdrawService withdrawService;
    private final WithdrawRepository withdrawRepository;

    @GetMapping(path = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<WithdrawDTO> findAll() {
        return WithdrawDTO.fromAll(withdrawRepository.findAll());
    }

    @GetMapping(path = "/")
    @ResponseStatus(HttpStatus.OK)
    public Page<WithdrawDTO> listPageUser(Pageable pageable) {
        return WithdrawDTO.fromPage(withdrawRepository.findAll(pageable));
    }

    @PostMapping(path = "/{value}")
    @ResponseStatus(HttpStatus.CREATED)
    public WithdrawDTO save(@PathVariable int value){
        return WithdrawDTO.from(withdrawService.save(value));
    }
}
