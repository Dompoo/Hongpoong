package Dompoo.Hongpoong.request.rental;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
/*
"품목": "장구",
"개수": "1",
"주는 멤버": "산틀",
"날짜": "24/04/18",
"시간": 17
 */
public class RentalEditRequest {

    private String product;

    @Min(value = 1, message = "개수는 1개 이상이어야 합니다.")
    private Integer count;

    private String fromMember;

    @FutureOrPresent(message = "과거 날짜일 수 없습니다.")
    private LocalDate date;

    @Min(value = 9, message = "9시 이상의 시간이어야 합니다.")
    @Max(value = 22, message = "22시 이하의 시간이어야 합니다.")
    private Integer time;

    @Builder
    public RentalEditRequest(String product, Integer count, String fromMember, LocalDate date, Integer time) {
        this.product = product;
        this.count = count;
        this.fromMember = fromMember;
        this.date = date;
        this.time = time;
    }
}
