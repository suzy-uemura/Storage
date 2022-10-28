package br.dh.meli.storage02.service;

import br.dh.meli.storage02.model.Book;
import br.dh.meli.storage02.repository.IBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService implements IBookService {

    private final IBookRepository bookRepository;

    @Override
    public Book findById(long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        bookRepository.deleteById(id);
    }
}
