package com.codegym.repository;

import com.codegym.model.Inote;
import com.codegym.model.Note_type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface InoteRepository extends PagingAndSortingRepository<Inote,Long> {
    Iterable<Inote> findAllByType(Note_type type);
    Page<Inote> findAllByType(Note_type type,Pageable pageable);
    Page<Inote> findAllByTitleContaining(String title , Pageable pageable);
}
