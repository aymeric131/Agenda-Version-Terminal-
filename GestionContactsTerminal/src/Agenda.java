import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
    //Attributs
    private ArrayList<Contact> listeContacts = new ArrayList<>();

    public ArrayList<Contact> getListeContacts() {
        return listeContacts;
    }

    public void setListeContacts(ArrayList<Contact> listeContacts) {
        this.listeContacts = listeContacts;
    }

    //Methods
    public void ajouterContact(Contact c) {
        String addLastName = c.getNom().toLowerCase();
        String addFirstName = c.getPrenom().toLowerCase();
        int exist = 0;
        if (!listeContacts.isEmpty()) {
            for (Contact contact : listeContacts) {
                if (addLastName.equals(contact.getNom().toLowerCase()) && addFirstName.equals(contact.getPrenom().toLowerCase())) {
                    System.out.println("Ce contact existe déjà !!.. ");
                    exist++;
                }
            }
            if (exist == 0) {
                this.listeContacts.add(c);
            }
        } else {
            this.listeContacts.add(c);
        }
    }

    public void supprimerContact(String nom, String prenom) {
        nom = nom.toLowerCase();
        prenom = prenom.toLowerCase();
        Contact searchedContact = null;
        boolean exist = false;
        for (Contact contact : listeContacts) {
            String lastName = contact.getNom().toLowerCase();
            String firstName = contact.getPrenom().toLowerCase();
            if (lastName.equals(nom) && firstName.equals(prenom)) {
                searchedContact = contact;
                exist = true;
            }
        }
        if (!exist) {
            System.out.println("Ce contact n'existe pas ...");
        } else {
            System.out.println("Voulez vous vraiment supprimer " + searchedContact.getNom() + " " + searchedContact.getPrenom() + " de votre agenda ? (Oui ou Non) ");
            Scanner scanner = new Scanner(System.in);
            String res = scanner.next().toLowerCase();
            if (res.equals("oui")) {
                this.listeContacts.remove(searchedContact);
                System.out.println("Vous venez de supprimer " + searchedContact.getNom() + " " + searchedContact.getPrenom() + " de votre agenda");
            }
        }
    }

    public void search(String a) {
        a = a.toLowerCase();
        System.out.println("Contact(s) contenant " + a);
        for (Contact c : this.listeContacts) {
            if (c.getNom().toLowerCase().contains(a) || c.getPrenom().toLowerCase().contains(a)) {
                System.out.println(c);
            }
        }
    }

    public void afficherAgenda() {
        if (this.listeContacts.isEmpty()) {
            System.out.println("Vous n'avez aucun contact dans votre Agenda");
        } else {
            System.out.println("Votre Liste de contacts : ");
            for (Contact contact : this.listeContacts) {
                System.out.println(contact);
            }
        }
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "listeContacts=" + listeContacts +
                '}';
    }
}

