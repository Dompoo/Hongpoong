package Dompoo.Hongpoong.response;

import Dompoo.Hongpoong.domain.Info;
import lombok.Getter;

@Getter
public class InfoListResponse {

    private final Long id;
    private final String title;
    private final String date;

    public InfoListResponse(Info info) {
        this.id = info.getId();
        this.title = info.getTitle();
        this.date = info.getDate().toString();
    }
}
