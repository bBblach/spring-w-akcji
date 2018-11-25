package org.rart.springwakcji.repository;

import org.rart.springwakcji.entity.Spitter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SpitterNoDatabaseRepository  implements  SpitterRepository{

    private List<Spitter> spitters = new ArrayList<>();



    @Override
    public Spitter save(Spitter spitter) {
        spitters.add(spitter);
        return spitter;
    }

    @Override
    public Spitter findByLogin(String login) {
        if (spitters !=null && spitters.size() >0 ){
            for(Spitter spitter : spitters){
                String loginFromList = spitter.getLogin();
                if (login.equals(loginFromList)){
                    return  spitter;
                }
            }
        }
        return  null;

    }
}
