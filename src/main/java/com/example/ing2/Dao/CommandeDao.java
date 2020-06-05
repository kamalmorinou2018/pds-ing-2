package com.example.ing2.Dao;

import com.example.ing2.entity.Commande;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommandeDao extends CrudRepository<Commande,Integer> {

    List<Commande> findByIdclient(Integer idclint);
    List<Commande> findByIdproduit(Integer idproduit);



}
