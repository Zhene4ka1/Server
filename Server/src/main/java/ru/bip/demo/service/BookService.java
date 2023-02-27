package ru.bip.demo.service;

import org.springframework.stereotype.Service;
import ru.bip.demo.entity.BookEntity;
import ru.bip.demo.exception.ValidationException;
import ru.bip.demo.repo.BookRepo;
import ru.bip.demo.utils.ValidationUtils;

@Service
public class BookService {
    private final BookRepo repo;
    public BookService(BookRepo repo){
        this.repo = repo;
    }
    public BookEntity save(BookEntity book) throws ValidationException {
        ValidationUtils.validateBook(book);
        return repo.save(book);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }

    public BookEntity find(Long id){return repo.findById(id).get();}
    public Iterable<BookEntity> getAll(){return  repo.findAll();}
}
