package Dompoo.Hongpoong.response.Instrument;

import Dompoo.Hongpoong.domain.Instrument;
import lombok.Getter;

@Getter
public class InstrumentResponse {
    private Long id;
    private String product;
    private String club;

    public InstrumentResponse(Instrument instrument) {
        this.id = instrument.getId();
        this.product = instrument.getProduct();
        this.club = instrument.getMember().getClub();
    }
}
