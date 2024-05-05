package Dompoo.Hongpoong.request.common;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
public class SettingSaveRequest {

    @NotNull
    private boolean push;

    @Builder
    public SettingSaveRequest(boolean push) {
        this.push = push;
    }
}
