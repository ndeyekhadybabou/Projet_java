import java.util.Scanner;

public class SimulTamagotchis {

    public static void main(String[] args) {

        Scanner clavier = new Scanner(System.in);

        System.out.print("Combien de tamagotchis voulez-vous ? ");
        int n = clavier.nextInt();
        clavier.nextLine();

        if (n <= 0) {
            System.out.println("Le nombre doit être supérieur à zéro.");
            clavier.close();
            return;
        }

        Tamagotchi[] tamagotchis = new Tamagotchi[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Quel nom pour le nouveau tamagotchi : ");
            String nom = clavier.nextLine();

            tamagotchis[i] = new Tamagotchi(nom);
        }

        boolean perdu = false;
        boolean gagne = false;
        int cycle = 1;

        while (!perdu && !gagne) {

            System.out.println("\n------- Cycle no " + cycle + " -------");

            for (int i = 0; i < n; i++) {
                if (!tamagotchis[i].vivre()) {
                    perdu = true;
                    break;
                }
            }

            if (perdu) {
                System.out.println("\nPERDU !!");
                break;
            }

            gagne = true;

            for (int i = 0; i < n; i++) {
                if (!tamagotchis[i].ageLimite()) {
                    gagne = false;
                    break;
                }
            }

            if (gagne) {
                System.out.println("\nGAGNÉ !! Tous les tamagotchis ont atteint leur âge limite.");
                break;
            }

            System.out.println("\nQuel tamagotchi voulez-vous nourrir ?");

            for (int i = 0; i < n; i++) {
                if (!tamagotchis[i].ageLimite()) {
                    System.out.println("(" + i + ") " + tamagotchis[i].getNom());
                }
            }

            System.out.println("(-1) Ne nourrir personne");
            System.out.print("Nourrir quel tamagotchi ? ");

            int choix = clavier.nextInt();

            if (choix == -1) {
                System.out.println("Vous n'avez nourri aucun tamagotchi.");
            } else if (choix >= 0 && choix < n) {
                if (!tamagotchis[choix].ageLimite()) {
                    tamagotchis[choix].manger();
                } else {
                    System.out.println("Ce tamagotchi a déjà atteint son âge limite.");
                }
            } else {
                System.out.println("Choix invalide. Aucun tamagotchi n'a été nourri.");
            }

            cycle++;
        }

        clavier.close();
    }
}
