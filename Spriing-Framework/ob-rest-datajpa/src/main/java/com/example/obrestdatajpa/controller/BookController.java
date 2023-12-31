package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final Logger log = LoggerFactory.getLogger(BookController.class);
    //atributos
    private BookRepository bookRepository;

    //constructores

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    // CRUD sobre la entidad Book

    // Buscar todos los libros
    @GetMapping("/api/books")
    public List<Book> findAll(){
        // recuperar y devolver los libros de base de datos
        return bookRepository.findAll();
    }
    // Buscar un solo libro en case de datos segun su Id
    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findOneById(@PathVariable Long id){

        Optional<Book> bookOpt = bookRepository.findById(id);
        // Opcion 1
//        if (bookOpt.isPresent())
//            return ResponseEntity.ok(bookOpt.get());
//        else
//            return ResponseEntity.notFound().build();
        //Opcion 2
      return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    // Crear un nuevo libro en base de datos

    @PostMapping("/api/books")
    public ResponseEntity<Book> create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        //guardar el libro recibido por parametro en la base de datos
        if (book.getId() != null){
            log.warn("Trying to create a book wiith id");
            System.out.println("Trying to create a book with id");
            return ResponseEntity.badRequest().build();
        }
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }

    // actualizar un libro existente en base de datos
    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book){
        if (book.getId() == null ){
            log.warn("Trying to update a non existent book");
            return ResponseEntity.badRequest().build();
        }
        if (!bookRepository.existsById(book.getId())){
            return ResponseEntity.notFound().build();
        }
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }
    // borrar un libro en base de datos

    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id){

        if (!bookRepository.existsById(id)){
            log.warn("Trying to delete a non existent book");
            return ResponseEntity.notFound().build();
        }
        bookRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/api/books")
    public ResponseEntity<Book> deleteAll(){
        log.info("REST Request for delete all books");
        bookRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
