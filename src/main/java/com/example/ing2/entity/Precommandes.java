package com.example.ing2.entity;

public class Precommandes {
    private Commande commande;
    private Produit produit;
    private Client client;


    public Precommandes() {
    }


    public Commande
    getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
