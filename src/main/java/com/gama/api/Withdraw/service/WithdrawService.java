package com.gama.api.Withdraw.service;

import com.gama.api.Withdraw.exception.WithdrawException;
import com.gama.api.Withdraw.model.Withdraw;
import com.gama.api.Withdraw.repository.WithdrawRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class WithdrawService {
    private static final String FINISHED = "Withdraw completed";
    private static final String NOT_FINISHED = "Withdraw cannot be completed";
    private final WithdrawRepository withdrawRepository;

    public Withdraw save(int value) throws WithdrawException {
        if(value >= 5){
            var withdraw = new Withdraw(value);
            doCount(withdraw);
            return withdrawRepository.save(withdraw);
        }
        throw new WithdrawException();
    }

    private void doCount(Withdraw withdraw) {
        int value = withdraw.getValue();
        var allowedBankNotes = new int[]{100, 50, 20, 10, 5};
        var result = new ArrayList<Integer>(6);
        for(int idx = 0; idx <= 4; idx++) {
            result.add(idx, value / allowedBankNotes[idx]);
            value %= allowedBankNotes[idx];
        }
        withdraw.setFinished(true);
        withdraw.setResult(buildString(allowedBankNotes, result));
    }

    private String buildString(int[] allowedBankNotes, ArrayList<Integer> result) {
        StringBuilder resultString = new StringBuilder();
        for(int idx = 0; idx <= 4; idx ++){
            resultString.append("Notas de ").append(allowedBankNotes[idx]).append(": ").append(result.get(idx)).append(" | ");
        }
        return resultString.toString();
    }
}
