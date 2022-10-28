package br.dh.meli.storage02.service;

import br.dh.meli.storage02.model.Subject;
import br.dh.meli.storage02.repository.ISubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService implements ISubjectService{

    private final ISubjectRepository subjectRepository;

    @Override
    public Subject findById(long id) {
        return subjectRepository.findById(id).orElse(null);
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }
}
