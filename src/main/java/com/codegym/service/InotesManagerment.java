package com.codegym.service;

import com.codegym.model.Inote;
import com.codegym.model.Note_type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InotesManagerment {
    Page<Inote> findAll(Pageable pageable);
    void save(Inote inote);
    Inote findById(Long id);
    void remove(Long id);
    Iterable<Inote> findAllByType(Note_type type);
    Page<Inote> findAllByType(Note_type type,Pageable pageable);
    Page<Inote>findAllByTitle(String title, Pageable pageable);
}
