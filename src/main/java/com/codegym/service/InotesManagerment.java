package com.codegym.service;

import com.codegym.model.Inote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InotesManagerment {
    Page<Inote> findAll(Pageable pageable);
    void save(Inote inote);
    Inote findById(Long id);
    void remove(Long id);



}
