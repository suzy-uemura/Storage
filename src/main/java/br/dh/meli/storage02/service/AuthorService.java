package br.dh.meli.storage02.service;

import br.dh.meli.storage02.dto.AuthorDTO;
import br.dh.meli.storage02.model.Author;
import br.dh.meli.storage02.repository.IAuthorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService implements IAuthorService{

    private IAuthorRepository authorRepository;

    public AuthorService(IAuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author inserir(Author author) {
        author.getAddress().setAuthor(author);
        return authorRepository.save(author);
    }

    @Override
    public Author findById(long id) {
        //nao add direto no return pq se retornar vazio da um excessao
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if(optionalAuthor.isPresent()) {
            return optionalAuthor.get();
        }
        return null;
    }

    @Override
    public void delete(long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public AuthorDTO getById(long id) {
        return authorRepository.getById(id);
    }

    @Override
    public Author getNativeById(long id) {
        return authorRepository.getNativeById(id);
    }

    @Override
    public AuthorDTO getDtoEagle(long id) {
        return authorRepository.getDtoEagle(id);
    }
}
