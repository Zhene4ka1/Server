package ru.bip.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bip.demo.entity.BookEntity;
import ru.bip.demo.response.BaseResponse;
import ru.bip.demo.response.BookListResponse;
import ru.bip.demo.response.BookResponse;
import ru.bip.demo.service.BookService;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
    private BookService service;

    private BookController(BookService service){
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll(){
        return ResponseEntity.ok(new BookListResponse(service.getAll()));
    }


    @PostMapping("/add")
    public ResponseEntity<BookResponse> registration(@RequestBody BookEntity data){
        try {
                BookEntity temp=service.save(data);
                return ResponseEntity.ok(new BookResponse(true,"Книга добавлена",temp));
            }catch(Exception e){
                return ResponseEntity.badRequest().body(new BookResponse(false, e.getMessage(), null));
            }
        }

        @PostMapping("/update")
    public ResponseEntity<BookResponse> update(@RequestBody BookEntity data){
            try {
                BookEntity temp=service.save(data);
                return ResponseEntity.ok(new BookResponse(true,"В книгу внесены изменения",temp));
            }catch(Exception e){
                return ResponseEntity.badRequest().body(new BookResponse(false, "В книгу не внесены изменения",null));
            }
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getById(@PathVariable long id){
        try {
            BookEntity book = service.find(id);
            return ResponseEntity.ok(new BookResponse(true,"Книга найдена",book));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new BookResponse(false, "Книга не найдена",null));
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(new BaseResponse(true, "Книга удалена"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, "Книга не удалена"));
        }
    }
}
