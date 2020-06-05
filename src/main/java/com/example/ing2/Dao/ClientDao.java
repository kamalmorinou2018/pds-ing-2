package com.example.ing2.Dao;

import com.example.ing2.entity.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientDao extends CrudRepository<Client,Integer> {

    List<Client> findByEmailAndPassword(String email, String password);



}
