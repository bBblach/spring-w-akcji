package org.rart.springwakcji.repository;

import org.rart.springwakcji.entity.Spittle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
    Spittle findOne(Long id);
}
