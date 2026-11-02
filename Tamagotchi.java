public class Tamagotchi {

    private int age;
    private int dureeDeVie;
    private int maxEnergie;
    private int energie;
    private String nom;

    // Constructeur
    public Tamagotchi(String nom) {
        this.nom = nom;
        this.age = 0;

        this.dureeDeVie = (int) (Math.random() * 6) + 9;
        this.maxEnergie = (int) (Math.random() * 5) + 5;
        this.energie = (int) (Math.random() * (this.maxEnergie - 2)) + 3;
    }

    // Afficher l'etat du tamagotchi
    public void parler() {
        if (energie > 5) {
            System.out.println(nom + " : tout va bien !");
        } else {
            System.out.println(nom + " : je suis affamé !");
        }
    }

    // Nourrir le tamagotchi
    public void manger() {
        if (energie >= maxEnergie) {
            System.out.println(nom + " : je n'ai pas faim !!");
        } else {
            int nourriture = (int) (Math.random() * 3) + 1;
            energie = energie + nourriture;

            if (energie > maxEnergie) {
                energie = maxEnergie;
            }

            System.out.println(nom + " : Merci !");
        }
    }

    // Verifier si l'age limite est atteint
    public boolean ageLimite() {
        return age == dureeDeVie;
    }

    // Faire vivre le tamagotchi pendant un cycle
    public boolean vivre() {
        if (age == dureeDeVie) {
            return true;
        }

        if (energie <= 0) {
            System.out.println(nom + " : je meurs... Arrrggh !");
            return false;
        }

        age = age + 1;
        energie = energie - 1;

        if (ageLimite()) {
            System.out.println(nom + " : c'est gagné pour moi !");
        } else {
            parler();
        }

        return true;
    }

    // Recuperer le nom du tamagotchi
    public String getNom() {
        return nom;
    }
}

