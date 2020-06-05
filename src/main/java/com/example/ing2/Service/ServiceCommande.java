package com.example.ing2.Service;

import com.example.ing2.Dao.ClientDao;
import com.example.ing2.Dao.CommandeDao;
import com.example.ing2.entity.Client;
import com.example.ing2.entity.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCommande {
    @Autowired
    public CommandeDao commandeDao;

    public Commande save(Commande c){
        return commandeDao.save(c);
    }
    public Commande findbyid(Integer c){
        return commandeDao.findById(c).get();
    }

    public List<Commande> findByidclient(Integer e){
        return commandeDao.findByIdclient(e);
    }
    public List<Commande> findByall(){
        return (List<Commande>)commandeDao.findAll();
    }

    public List<Commande> findByidproduit(Integer e){
        return commandeDao.findByIdproduit(e);
    }



}
