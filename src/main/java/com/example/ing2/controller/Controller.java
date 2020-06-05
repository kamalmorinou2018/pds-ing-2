package com.example.ing2.controller;


import com.example.ing2.Service.ServiceClient;
import com.example.ing2.Service.ServiceCommande;
import com.example.ing2.Service.ServiceProduit;
import com.example.ing2.entity.Client;
import com.example.ing2.entity.Commande;
import com.example.ing2.entity.Precommandes;
import com.example.ing2.entity.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private ServiceClient clientService;
    @Autowired
    private ServiceCommande commandeservice;
    @Autowired
    private ServiceProduit produitservice;
    private static int i=0;

    public String doSomethingAfterStartup() {
        Client client = new Client();
        client.setNom("Kamal Mourinou");
        client.setPassword("kamal");
        client.setEmail("kamalmourinou@gmail.com");
        client.setType("user");
        client = clientService.save(client);
        Client client2 = new Client();
        client2.setNom("Kamal Mourinou");
        client2.setPassword("kamal");
        client2.setEmail("kamaladmin@gmail.com");
        client2.setType("admin");
        client2 = clientService.save(client2);
        Client client3 = new Client();
        client3.setNom("Tuto user");
        client3.setPassword("kamal");
        client3.setEmail("tutouse@gmail.com");
        client3.setType("user");
        client3 = clientService.save(client3);

        for (int i=1;i<=23;i++){
            Produit pre = new  Produit();
            pre.setNom("Casque-PC-Im Model"+i);
            pre.setPrix(Integer.toString(10*i));
            pre.setImage("/produits/"+i+".jpg");
            pre.setQuantiter(Integer.toString(15*i));
            pre = produitservice.save(pre);
            if(i<=9){
                Commande cmd = new Commande();
                cmd.setLivraison("acheter");
                cmd.setIdclient(client.getId());
                cmd.setIdproduit(pre.getId());
                cmd.setDate("0"+i+"/04/2019");
                cmd.setAddresse((i+1)+" rue de Nador 92160 Antony");
                commandeservice.save(cmd);
            }else{
                Commande cmd = new Commande();
                cmd.setLivraison("acheter");
                cmd.setIdclient(client3.getId());
                cmd.setIdproduit(pre.getId());
                cmd.setAddresse((i+1)+" rue de Hoceima 92160 Antony");
                cmd.setDate(i+"/04/2019");
                commandeservice.save(cmd);
            }

        }
    return "les données ajoutés";
    }

    @RequestMapping(value="/")
    public String afficherlesproduit( Model model, HttpServletRequest request, HttpSession session) {
        if(i==0){
            doSomethingAfterStartup();
            i=1;
        }
        String messages = (String) request.getSession().getId();
        Integer messages2 = (Integer) session.getAttribute(messages);
        System.out.println("id session :" + messages);
        if (messages2 == null) {
            Client clientd = new Client();
            model.addAttribute(clientd);
            return "identification";
        } else {
            Client client = clientService.findbyid(messages2);
            if (client.getType() == "admin") {
                List<Commande> mes = commandeservice.findByall();
                ArrayList<Precommandes> pre = new ArrayList<Precommandes>();
                for (int i = 0; i < mes.size(); i++) {
                    Precommandes pr = new Precommandes();
                    pr.setClient(clientService.findbyid(mes.get(i).getIdclient()));
                    pr.setProduit(produitservice.findbyid(mes.get(i).getIdproduit()));
                    pr.setCommande(mes.get(i));
                    pre.add(pr);
                }
                model.addAttribute("pres",pre);
                model.addAttribute("client",client);

                return "index";
            } else {
                List<Commande> mes = commandeservice.findByidclient(messages2);
                ArrayList<Precommandes> pre = new ArrayList<Precommandes>();
                for (int i = 0; i < mes.size(); i++) {
                    Precommandes pr = new Precommandes();
                    pr.setClient(clientService.findbyid(mes.get(i).getIdclient()));
                    pr.setProduit(produitservice.findbyid(mes.get(i).getIdproduit()));
                    pr.setCommande(mes.get(i));
                    pre.add(pr);
                }
                model.addAttribute("pres",pre);
                model.addAttribute("client",client);
                return "index";
            }
        }
    }



    @RequestMapping(value="/changer")
    @ResponseBody
    public String affichertoutmescommandes(@RequestParam("idcommandes") String idcommandes,@RequestParam("value") String value ){
        System.out.println("idcommandes"+idcommandes+"  value "+value);
        Commande cmd = commandeservice.findbyid(Integer.parseInt(idcommandes));
        cmd.setLivraison(value);
        commandeservice.save(cmd);
        return "done";
    }

    // pour se déconnecter
    @GetMapping("/destroy")
    public String destroySession(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }

    // identification
    @GetMapping(value = "/identification")
    public String createProfileView5(Model model) {
        Client client = new  Client();
        model.addAttribute(client);
        return "identification";
    }


    // pour s'inscrire page
    @GetMapping(value = "/signup")
    public String signup(Model model) {
        Client client = new Client();
        model.addAttribute(client);
        return "inscription";
    }

    // identification-methode
    @RequestMapping(value ="/ident")
    public String idenficationclient(@ModelAttribute Client client, Model model, HttpServletRequest request) {
        System.out.println("votre email " + client.getEmail() + "votre password " + client.getPassword());
        System.out.println(clientService.findall().get(0).getEmail()+clientService.findall().get(0).getPassword());

        try {
            List<Client> clientbd = clientService.findByEmailAndPass(client.getEmail().toLowerCase(),client.getPassword().toLowerCase());
            if (clientbd.size()>0) {
                Client client1 = clientbd.get(0);
                request.getSession().setAttribute(request.getSession().getId(), client1.getId());
                return "redirect:/";
            }
        } catch (Exception e) {
            return "identification";
        }
        return "identification";
    }

    // pour inscription-methode
    @RequestMapping("/inscrire")
    public String createcompte(Model model, @ModelAttribute Client client, HttpServletRequest request) {
            clientService.save(client);
            return "redirect:/";
        }
    }


