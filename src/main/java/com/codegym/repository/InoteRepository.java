package com.codegym.repository;

import com.codegym.model.Inote;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InoteRepository extends PagingAndSortingRepository<Inote,Long> {
}
