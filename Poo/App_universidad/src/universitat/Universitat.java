/*
 * Classe que defineix una universitat, que es defineix pel seu nom,
 * la seva ubicació i un array de campus.
 */

package universitat;


import java.util.Scanner;

/**
 * @author fgarin
 */
public class Universitat {
    private final static Scanner DADES = new Scanner(System.in);

    private String nomUniversitat;
    private String ubicacioSeu;
    private Campus[] campus = new Campus[5];
    private int pCampus = 0; //Primera posició buida de l'array de campus


    public Universitat(String nomUniversitat, String ubicacioSeu) {
        this.nomUniversitat = nomUniversitat;
        this.ubicacioSeu = ubicacioSeu;
    }

    public String getNomUniversitat() {
        return nomUniversitat;
    }

    public void setNomUniversitat(String nomUniversitat) {
        this.nomUniversitat = nomUniversitat;
    }

    public String getUbicacioSeu() {
        return ubicacioSeu;
    }

    public void setUbicacioSeu(String ubicacioSeu) {
        this.ubicacioSeu = ubicacioSeu;
    }

    public Campus[] getCampus() {
        return campus;
    }

    public void setCampus(Campus[] campus) {
        this.campus = campus;
    }

    public int getpCampus() {
        return pCampus;
    }

    public void setpCampus(int pCampus) {
        this.pCampus = pCampus;
    }


    public static Universitat addUniversitat() {
        System.out.println("Introdueix el nom de la Universitat:");
        String nomUniversitat = DADES.nextLine();

        System.out.println("Introdueix la ubicació:");
        String ubicacio = DADES.nextLine();


        return new Universitat(nomUniversitat, ubicacio);
    }

    public void updateUniversitat() {
        System.out.println("Dades actuals de la universitat:");
        System.out.println("Nom Universitat: " + getNomUniversitat());
        System.out.println("Ubicació de la seu: " + getUbicacioSeu());

        System.out.println("\nIntrodueix noves dades de la universitat ");

        System.out.println("Nou nom de la universitat: ");
        setNomUniversitat(DADES.nextLine());

        System.out.println("Nova ubicació: ");
        setUbicacioSeu(DADES.nextLine());

        System.out.println("\nDades actualizades correctament");
    }


    public double costManteniment() {
        double costTotal = 0;

        for (int i = 0; i < getpCampus(); i++) {
            costTotal += getCampus()[i].costManteniment();
        }
        return Math.round(costTotal * 100.0)/100.0;
    }

    public void showUniversitat() {

        System.out.println("\n===== Informació de la Universitat =====");
        System.out.println("Nom: " + getNomUniversitat());
        System.out.println("Ubicació: " + getUbicacioSeu());


        double costTotalManteniment = costManteniment();
        System.out.println("Cost total de manteniment: " + costTotalManteniment + " €");
        System.out.println("====================================");
    }

    public void addCampus() {
        Campus nouCampus = Campus.addCampus();
        boolean campusExisteix = false;
        boolean espai = true;

        for (int i = 0; i < getpCampus(); i++) {

            if (getCampus()[i].getNomCampus().equalsIgnoreCase(nouCampus.getNomCampus())) {
                System.out.println("El campus ja existeix");
                campusExisteix = true;
            }
        }
        if (getpCampus() >= 5) {
            espai = false;
            System.out.println("No hi ha més espai per afegir campus");
        }

        if (!campusExisteix && espai) {
            getCampus()[getpCampus()] = nouCampus;
            setpCampus(getpCampus() + 1);
            System.out.println("Campus afegit correctament");
        }
    }

    public int selectCampus(String nom) {
        if (nom == null) {
            System.out.println("\nNom del campus:");
            nom = DADES.nextLine();
        }

        for (int i = 0; i < pCampus; i++) {
            if (campus[i].getNomCampus().equals(nom)) {
                return i;

            }
        }
        return -1;
    }

    public void addAulaEstandardCampus() {
        int index = selectCampus(null);

        if (index != -1) {
            campus[index].addAulaEstandard();
        } else {
            System.out.println("\nEl campus no existeix");
        }
    }

    public void updateAulaEstandardCampus() {
        int indexCampus = selectCampus(null);

        if (indexCampus != -1) {
            int indexAulaEstandard = campus[indexCampus].selectAulaEstandard(null);

            if (indexAulaEstandard != -1) {
                campus[indexCampus].getAulesEstandard()[indexAulaEstandard].updateAulaEstandard();
            } else {
                System.out.println("\nL'aula estàndard no existeix");
            }
        } else {
            System.out.println("\nEl campus no existeix");
        }
    }

    public void addAulaInformaticaCampus() {
        int index = selectCampus(null);

        if (index != -1) {
            campus[index].addAulaInformatica();
        } else {
            System.out.println("\nLEl campus no existeix");
        }
    }

    public void updateAulaInformaticaCampus() {
        int indexCampus = selectCampus(null);

        if (indexCampus != -1) {
            int indexAulaInformatica = campus[indexCampus].selectAulaInformatica(null);

            if (indexAulaInformatica != -1) {
                campus[indexCampus].getAulesInformatica()[indexAulaInformatica].updateAulaInformatica();
            } else {
                System.out.println("\nL'aula d'informàtica no existeix");
            }
        } else {
            System.out.println("\nEl campus no existeix");
        }
    }

    public void addLaboratoriCampus() {
        int index = selectCampus(null);

        if (index != -1) {
            campus[index].addLaboratori();
        } else {
            System.out.println("\nEl campus no existeix");
        }
    }

    public void updateLaboratoriCampus() {
        int indexCampus = selectCampus(null);

        if (indexCampus != -1) {
            int indexLaboratori = campus[indexCampus].selectLaboratori(null);

            if (indexLaboratori != -1) {
                campus[indexCampus].getLaboratoris()[indexLaboratori].updateLaboratori();
            } else {
                System.out.println("\nEl laboratori no existeix");
            }
        } else {
            System.out.println("\nEl campus no existeix");
        }
    }
}
