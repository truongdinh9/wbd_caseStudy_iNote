package com.codegym.service.impl;

import com.codegym.model.Inote;
import com.codegym.repository.InoteRepository;
import com.codegym.service.InotesManagerment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public class InotesManagermentImpl implements InotesManagerment {
    @Autowired
    InoteRepository inoteRepository;

    @Override
    public Page<Inote> findAll(Pageable pageable) {
        return inoteRepository.findAll(pageable);
    }

    @Override
    public void save(Inote inote) {
        inoteRepository.save(inote);
    }

    @Override
    public Inote findById(Long id) {
        return inoteRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        inoteRepository.delete(id);

    }
}
