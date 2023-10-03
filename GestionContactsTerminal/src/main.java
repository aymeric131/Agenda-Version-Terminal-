import javax.swing.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Agenda monRepertoire = new Agenda();
        String menu = "\n #####     MENU    #####\n"
                + "1) Ajouter un contact\n"
                + "2) Afficher l'agenda\n"
                + "3) Pour recherche des contacts\n"
                + "4) Supprimer un contact\n"
                + "5) Fermer l'agenda\n \n" +
                "Saisir choix: ";

        System.out.print(menu);
        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();
        while (choix != 5) {
            switch (choix) {
                case 1:
                    System.out.println("Ajouter votre contact");
                    System.out.print("Nom : ");
                    String nom = sc.next();

                    System.out.print("Prénom : ");
                    String prenom = sc.next();

                    System.out.print("Téléphone : ");
                    String tel = sc.next();

                    Contact newContact = new Contact(nom, prenom, tel);
                    monRepertoire.ajouterContact(newContact);
                    System.out.print(menu);
                    break;

                case 2:
                    monRepertoire.afficherAgenda();
                    System.out.print(menu);
                    break;
                case 3:
                    System.out.println("Qui cherchez-vous ?");
                    String searched = sc.next();
                    monRepertoire.search(searched);
                    System.out.print(menu);
                    break;
                case 4:
                    if (monRepertoire.getListeContacts().isEmpty()) {
                        System.out.println("Votre répertoire est vide vous ne pouvez donc pas supprimer un contact :) ");
                        System.out.print(menu);
                    } else {
                        System.out.print("Quel contact voulez-vous supprimer ? \n Nom :");
                        String firstname = sc.next();
                        System.out.print("Prenom : ");
                        String name = sc.next();
                        monRepertoire.supprimerContact(firstname, name);
                        System.out.print(menu);
                    }
                    break;

                default:
                    System.out.println("Choix invalide");
                    System.out.print(menu);
                    break;
            }
            choix = sc.nextInt();
        }
        System.out.println("Bye Bye ... ");

    }
}