package Dompoo.Hongpoong.request.common;

import lombok.Builder;
import lombok.Data;

@Data
public class SettingRequest {

    private boolean push;

    @Builder
    public SettingRequest(boolean push) {
        this.push = push;
    }
}
