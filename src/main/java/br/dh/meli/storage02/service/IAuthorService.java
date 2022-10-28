package br.dh.meli.storage02.service;

import br.dh.meli.storage02.dto.AuthorDTO;
import br.dh.meli.storage02.model.Author;

public interface IAuthorService {
    Author inserir(Author author);
    Author findById(long id);
    void delete(long id);
    AuthorDTO getById(long id);
    Author getNativeById(long id);

    AuthorDTO getDtoEagle(long id);
}
