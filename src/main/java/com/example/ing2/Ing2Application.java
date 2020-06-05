package com.example.ing2;

import com.example.ing2.Service.ServiceClient;
import com.example.ing2.Service.ServiceCommande;
import com.example.ing2.Service.ServiceProduit;
import com.example.ing2.entity.Client;
import com.example.ing2.entity.Commande;
import com.example.ing2.entity.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ing2Application {

	public static void main(String[] args) {

		SpringApplication.run(Ing2Application.class, args); }

}
