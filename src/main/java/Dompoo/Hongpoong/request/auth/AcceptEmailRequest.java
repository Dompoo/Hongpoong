package Dompoo.Hongpoong.request.auth;

import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AcceptEmailRequest {

    @Min(value = 1, message = "승인/거절할 이메일을 선택해주세요.")
    private Long id;

    private boolean acceptResult;

    @Builder
    public AcceptEmailRequest(Long id, boolean acceptResult) {
        this.id = id;
        this.acceptResult = acceptResult;
    }
}