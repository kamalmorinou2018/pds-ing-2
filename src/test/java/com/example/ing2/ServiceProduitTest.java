package com.example.ing2;


import com.example.ing2.Dao.ProduitDao;
import com.example.ing2.entity.Client;
import com.example.ing2.entity.Produit;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ServiceProduitTest {

    @Mock
    private ProduitDao produitDao;

    @Test
    void contextLoads() {
    }

    @Test
    public void save_ShouldSaveTheProduct_WhenOk(){

        Produit produit = new Produit();
        produit.setId(1);
        produit.setNom("Montre");
        produit.setPrix("200");
        produit.setQuantite("10");
        produit.setImage("C/abbe");

        when(produitDao.save(Mockito.any(Produit.class))).thenReturn(produit);
    }

    @Test
    public void findById_whenOk() {

        Produit produit = new Produit();
        produit.setId(1);
        produit.setNom("téléphone");
        produit.setPrix("250");
        produit.setQuantite("5");
        produit.setImage("C//abbe");

        when(produitDao.findById(1)).thenReturn(Optional.of(produit));

        when(produitDao.findById(2)).thenReturn(Optional.empty());

    }




}
