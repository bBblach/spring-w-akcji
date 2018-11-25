package org.rart.springwakcji.repository;

import org.rart.springwakcji.entity.Spittle;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SpittleNoDataBaseRpository implements SpittleRepository {
    @Override
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittles = new ArrayList<>(count);

        for (int i =0; i<20; i++){
            Spittle spittle = new Spittle(("Spittle no=" + (i+1)) , LocalDateTime.now());
            spittles.add(spittle);
        }
        return  spittles;
    }

    @Override
    public Spittle findOne(Long id) {
        String message = "Spittle id = "+ 12345 ;
        Spittle spittle = new Spittle(message, LocalDateTime.now() );
        return spittle;
    }
}
