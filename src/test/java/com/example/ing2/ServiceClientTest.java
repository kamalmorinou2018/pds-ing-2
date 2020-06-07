package com.example.ing2;

import com.example.ing2.Dao.ClientDao;
import com.example.ing2.Service.ServiceClient;
import com.example.ing2.entity.Client;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
public class ServiceClientTest {

    @Mock
    private ClientDao clientDao;

    @Test
    	void contextLoads() {
    	}


    @Test
    public void saveClient_WhenOk() {

        Client newclient = new Client();
        newclient.setId(123);
        newclient.setEmail("Alex@hotmail.com");
        newclient.setNom("Kamal");
        newclient.setPassword("1234545689-+");
        newclient.setType("utilisateur");
        newclient.setPrenom("Mourinou");


        when(clientDao.save(Mockito.any(Client.class))).thenReturn(newclient);
    }

    @Test
    public void findById_whenOk() {

        Client newclient = new Client();
        newclient.setId(1);
        newclient.setEmail("Alex@hotmail.com");
        newclient.setNom("Kamal");
        newclient.setPassword("1234545689-+");
        newclient.setType("utilisateur");
        newclient.setPrenom("Mourinou");

        when(clientDao.findById(1)).thenReturn(Optional.of(newclient));


    }

    @Test
    public void findAll_shouldReturnListoOfClient_whenOk(){
       List<Client> all = new ArrayList();

       Client client = new Client();
       client.setId(1);
       client.setEmail("Alex@hotmail.com");
       client.setNom("Kamal");
       client.setPassword("1234545689-+");
       client.setType("utilisateur");
       client.setPrenom("Mourinou");


        Client clienttwo = new Client();
        clienttwo.setId(2);
        clienttwo.setEmail("Alex@hotmail.es");
        clienttwo.setNom("Fabien");
        clienttwo.setType("utilisateur");
        clienttwo.setPrenom("Mourinou");
        clienttwo.setPassword("1234545689-+");

        all.add(client);
        all.add(clienttwo);


        when(clientDao.findAll()).thenReturn(all);
        verify(clientDao).findAll();
    }


     @Test
     public void findByEmailAndPass_shoulClient_whenOk(){
          List<Client> liste = new ArrayList<>();
        Client client = new Client();
        client.setId(1);
        client.setEmail("Alex@hotmail.com");
        client.setNom("Kamal");
        client.setPassword("1234545689-+");
        client.setType("utilisateur");
        client.setPrenom("Mourinou");

        liste.add(client);

        when(clientDao.findByEmailAndPassword(client.getEmail(), client.getPassword())).thenReturn(liste);
     }
}
