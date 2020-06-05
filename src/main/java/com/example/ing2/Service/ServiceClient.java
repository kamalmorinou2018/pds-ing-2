package com.example.ing2.Service;

import com.example.ing2.Dao.ClientDao;
import com.example.ing2.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceClient {
    @Autowired
    ClientDao clientDao;

    public Client save(Client client){
        return clientDao.save(client);
    }
    public Client findbyid(Integer id){
        return clientDao.findById(id).get();
    }
    public List<Client> findall(){
        return (List<Client>)clientDao.findAll();
    }
    public List<Client> findByEmailAndPass(String email, String pass){
        return clientDao.findByEmailAndPassword(email,pass);
    }



}
