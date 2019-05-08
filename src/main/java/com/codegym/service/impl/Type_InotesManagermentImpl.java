package com.codegym.service.impl;

import com.codegym.model.Inote;
import com.codegym.model.Note_type;
import com.codegym.repository.InoteRepository;
import com.codegym.repository.Note_TypeRepository;
import com.codegym.service.Type_InotesManagerment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.lang.reflect.Type;

public class Type_InotesManagermentImpl implements Type_InotesManagerment {
    @Autowired
    Note_TypeRepository typeRepository;

    @Override
    public Page<Note_type> findAll(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    public Iterable<Note_type> findAll() {
        return typeRepository.findAll();
    }

    @Override
    public void save(Note_type type) {
        typeRepository.save(type);
    }

    @Override
    public Note_type findById(Long id) {
        return typeRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        typeRepository.delete(id);

    }
}
