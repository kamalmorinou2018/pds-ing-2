package com.example.ing2;

import com.example.ing2.Dao.CommandeDao;
import com.example.ing2.entity.Client;
import com.example.ing2.entity.Commande;
import com.example.ing2.entity.Produit;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ServiceCommandeTest {
    @Mock
    private CommandeDao commandeDao;

    @Test
    void contextLoads() {
    }

    @Test
    public void save_shouldSaveTheCommande_whenOk(){

        Commande commande = new Commande();
        commande.setId(1);
        commande.setIdclient(1);
        commande.setIdproduit(1);
        commande.setDate("19/09/2019");
        commande.setLivraison("Acheté");
        commande.setAddresse("4 rue De paillard");

        when(commandeDao.save(Mockito.any(Commande.class))).thenReturn(commande);
    }

    @Test
    public void findbyid_shouldReturnTheCommande_WhenOk() {

        Commande commande = new Commande();
        commande.setId(1);
        commande.setIdclient(1);
        commande.setIdproduit(1);
        commande.setDate("19/09/2019");
        commande.setLivraison("Acheté");
        commande.setAddresse("4 rue De paillard");

        when(commandeDao.findById(1)).thenReturn(Optional.of(commande));

    }

    @Test
    public void findbyIdClient_shouldReturnNull_whenIdClientIsNotValid(){

        Commande commande = new Commande();
        commande.setId(1);
        commande.setIdclient(1);
        commande.setIdproduit(1);
        commande.setDate("19/09/2019");
        commande.setLivraison("Acheté");
        commande.setAddresse("4 rue de paillard");


        Commande commandeTwo = new Commande();
        commandeTwo.setId(2);
        commandeTwo.setIdclient(1);
        commandeTwo.setIdproduit(2);
        commandeTwo.setDate("11/09/2019");
        commandeTwo.setLivraison("Acheté");
        commandeTwo.setAddresse("14 rue de paillard");

        Client client = new Client();
        client.setId(1);
        client.setEmail("Alex@hotmail.com");
        client.setNom("Kamal");
        client.setPassword("1234545689-+");
        client.setType("utilisateur");
        client.setPrenom("Mourinou");

        List<Commande> listCommandes = new ArrayList();
        listCommandes.add(commande);
        listCommandes.add(commandeTwo);


   when(commandeDao.findByIdclient(4)).thenReturn(null);


    }


}
