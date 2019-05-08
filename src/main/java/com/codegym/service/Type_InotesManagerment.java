package com.codegym.service;

import com.codegym.model.Inote;
import com.codegym.model.Note_type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Type_InotesManagerment {
    Page<Note_type> findAll(Pageable pageable);
    Iterable<Note_type> findAll();

    void save(Note_type type);
    Note_type findById(Long id);
    void remove(Long id);

}
