package br.dh.meli.storage02.controller;

import br.dh.meli.storage02.dto.AuthorDTO;
import br.dh.meli.storage02.model.Author;
import br.dh.meli.storage02.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<Author> insert(@RequestBody Author author) {
        return ResponseEntity.ok(authorService.inserir(author));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable long id) {
        Author author = authorService.findById(id);
        if(author != null) {
            return ResponseEntity.ok(author);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<AuthorDTO> getById (@PathVariable long id) {
        AuthorDTO author = authorService.getById(id);
        if(author != null) {
            return ResponseEntity.ok(author);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/eagle/{id}")
    public ResponseEntity<AuthorDTO> getDtoEagleId (@PathVariable long id) {
        AuthorDTO author = authorService.getDtoEagle(id);
        if(author != null) {
            return ResponseEntity.ok(author);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/native/{id}")
    public ResponseEntity<Author> getNativeById (@PathVariable long id) {
        Author author = authorService.getNativeById(id);
        if(author != null) {
            return ResponseEntity.ok(author);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        authorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
