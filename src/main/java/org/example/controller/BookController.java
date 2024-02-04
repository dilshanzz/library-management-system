package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    final BookService service;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody Book book){
        service.addBook(book);

    }
    @GetMapping("/get")
    public Iterable<BookEntity> getBook(){
        return service.getBooks();
    }

    @DeleteMapping("/{id}")
//    public String deleteBook(@PathVariable Long id){
//      if(  service.deleteBook(id)){
//          return "Deleted";
//      }
//      return "Not Deleted";
//    }
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        return service.deleteBook(id) ?
                ResponseEntity.ok("Deleted"):
                ResponseEntity.notFound().build();

    }

}
