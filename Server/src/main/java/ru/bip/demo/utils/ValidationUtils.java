package ru.bip.demo.utils;

import ru.bip.demo.entity.BookEntity;
import ru.bip.demo.exception.ValidationException;

public class ValidationUtils {
    public static void validateBook(BookEntity book) throws ValidationException {
        String title= book.getTitle();
        if(title==null || title.isBlank() || title.length()<2 || title.length()>50)
            throw new ValidationException("Название книги должно быть в пределах от 2 до 50 символов");
        String author = book.getAuthor();
        if(author==null || author.isBlank() || author.length()<3 || author.length()>40)
            throw new ValidationException("Название автора должно быть в пределах от 3 до 40 символов");
        String publisher = book.getPublisher();
        if(publisher==null || publisher.isBlank() || publisher.length()<3 || publisher.length()>30)
            throw new ValidationException("Название издательства должно быть в пределах от 3 до 30 символов");
        int year = book.getYear();
        if(year==0||year<1900||year>2023)
            throw new ValidationException("Год книги должен находиться в переделе от 1900 до 2023 года");
        String kind = book.getKind();
        if(kind==null || kind.isBlank() || kind.length()<2 || kind.length()>50)
            throw new ValidationException("Название типа данных должно быть в пределах от 2 до 50 символов");
    }
}
