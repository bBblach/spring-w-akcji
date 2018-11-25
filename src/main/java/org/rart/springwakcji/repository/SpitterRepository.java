package org.rart.springwakcji.repository;

import org.rart.springwakcji.entity.Spitter;


public interface SpitterRepository  {



    Spitter save(Spitter spitter);

    Spitter findByLogin(String login);
}
