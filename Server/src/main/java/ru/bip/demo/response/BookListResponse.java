package ru.bip.demo.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.bip.demo.entity.BookEntity;

@Data
@RequiredArgsConstructor
public class BookListResponse extends BaseResponse {
    public BookListResponse(Iterable<BookEntity> data) {
        super(true, "Список книг");
        this.data = data;
    }
    private Iterable<BookEntity> data;
}
