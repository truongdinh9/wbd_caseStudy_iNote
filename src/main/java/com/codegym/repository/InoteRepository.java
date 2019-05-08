package com.codegym.repository;

import com.codegym.model.Inote;
import com.codegym.model.Note_type;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface InoteRepository extends PagingAndSortingRepository<Inote,Long> {
    Iterable<Inote> findAllByType(Note_type type);
}
