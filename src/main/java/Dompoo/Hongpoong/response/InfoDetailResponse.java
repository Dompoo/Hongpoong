package Dompoo.Hongpoong.response;

import Dompoo.Hongpoong.domain.Info;
import lombok.Getter;

@Getter
public class InfoDetailResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final String date;

    public InfoDetailResponse(Info info) {
        this.id = info.getId();
        this.title = info.getTitle();
        this.content = info.getContent();
        this.date = info.getDate().toString();
    }
}
