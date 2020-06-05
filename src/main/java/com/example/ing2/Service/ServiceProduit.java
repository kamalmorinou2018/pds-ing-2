package com.example.ing2.Service;

import com.example.ing2.Dao.ClientDao;
import com.example.ing2.Dao.ProduitDao;
import com.example.ing2.entity.Client;
import com.example.ing2.entity.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProduit {
    @Autowired
    ProduitDao produitDao;
    public Produit save(Produit p){
        return produitDao.save(p);
    }
    public Produit findbyid(Integer p){
        return produitDao.findById(p).get();
    }
    public List<Produit> findall(){
        return (List<Produit>)produitDao.findAll();
    }


}
