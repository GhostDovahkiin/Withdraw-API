package com.gama.api.Withdraw.model.dto;

import com.gama.api.Withdraw.model.Withdraw;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
public class WithdrawDTO implements Serializable {

    @NotNull
    private Long id;

    @FutureOrPresent
    @NotNull
    @NotEmpty
    @NotBlank
    private LocalDateTime hour;

    @Min(message = "The withdraw minimum value is $5", value = 5)
    @NotNull
    @NotEmpty
    private int value;
    private boolean isFinished;
    private String result;

    public static WithdrawDTO from(Withdraw entity) {
        return WithdrawDTO
                .builder()
                .id(entity.getId())
                .hour(LocalDateTime.now())
                .value(entity.getValue())
                .isFinished(entity.isFinished())
                .result(entity.getResult())
                .build();
    }

    public static List<WithdrawDTO> fromAll(List<Withdraw> withdraws) {
        return withdraws.stream().map(WithdrawDTO::from).collect(Collectors.toList());
    }

    public static Page<WithdrawDTO> fromPage(Page<Withdraw> pages) {
        return pages.map(WithdrawDTO::from);
    }
}
