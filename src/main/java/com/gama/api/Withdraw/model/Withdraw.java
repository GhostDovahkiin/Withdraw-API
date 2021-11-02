package com.gama.api.Withdraw.model;

import com.gama.api.Withdraw.model.dto.WithdrawDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(builderClassName = "Builder")
public class Withdraw implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @FutureOrPresent
    private LocalDateTime hour;
    private int value;
    private boolean isFinished = false;
    private String result;

    public Withdraw (int value) {
        this.value = value;
    }

    public static Withdraw to(WithdrawDTO dto) {
        return Withdraw
                .builder()
                .hour(dto.getHour())
                .value(dto.getValue())
                .isFinished(dto.isFinished())
                .result(dto.getResult())
                .build();
    }
}
