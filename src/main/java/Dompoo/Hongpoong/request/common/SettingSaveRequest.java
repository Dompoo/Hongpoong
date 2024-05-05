package Dompoo.Hongpoong.request.common;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SettingSaveRequest {

    @NotNull
    private boolean push;

    @Builder
    public SettingSaveRequest(boolean push) {
        this.push = push;
    }
}
