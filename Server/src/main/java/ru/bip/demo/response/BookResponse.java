package ru.bip.demo.response;

import lombok.Data;
import ru.bip.demo.entity.BookEntity;

@Data
public class BookResponse extends BaseResponse{
    private BookEntity data;

    public BookResponse(BookEntity data) {
        this.data = data;
    }

    public BookResponse(boolean success, String message, BookEntity data) {
        super(success, message);
        this.data = data;
    }
}
