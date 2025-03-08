/**
 * Classe que defineix un campus. Es defineix pel seu nom,
 * la seva ubicació, un array d'aules estàndard,
 * un array d'aules d'informàtica i un array de laboratoris.
 */

package universitat;


import java.util.Scanner;

/**
 * @author fgarin
 */
public class Campus {
    private final static Scanner DADES = new Scanner(System.in);

    private String nomCampus;
    private String ubicacio;

    private AulaEstandard[] aulesEstandard = new AulaEstandard[100];
    private int pAulesEstandard = 0; //Primera posició buida de l'array d'aules estàndard
    private AulaInformatica[] aulesInformatica = new AulaInformatica[100];
    private int pAulansInformatica = 0; //Primera posició buida de l'array d'aules d'informàtica
    private Laboratori[] laboratoris = new Laboratori[100];
    private int pLaboratoris = 0; //Primera posició buida de l'array de laboratoris


    public Campus(String nomCampus, String ubicacio) {
        this.nomCampus = nomCampus;
        this.ubicacio = ubicacio;
    }

    public String getNomCampus() {
        return nomCampus;
    }

    public void setNomCampus(String nomCampus) {
        this.nomCampus = nomCampus;
    }

    public String getUbicacio() {
        return ubicacio;
    }

    public void setUbicacio(String ubicacio) {
        this.ubicacio = ubicacio;
    }

    public AulaEstandard[] getAulesEstandard() {
        return aulesEstandard;
    }

    public void setAulesEstandard(AulaEstandard[] aulesEstandard) {
        this.aulesEstandard = aulesEstandard;
    }

    public int getpAulesEstandard() {
        return pAulesEstandard;
    }

    public void setpAulesEstandard(int pAulesEstandard) {
        this.pAulesEstandard = pAulesEstandard;
    }

    public AulaInformatica[] getAulesInformatica() {
        return aulesInformatica;
    }

    public void setAulesInformatica(AulaInformatica[] aulesInformatica) {
        this.aulesInformatica = aulesInformatica;
    }

    public int getpAulansInformatica() {
        return pAulansInformatica;
    }

    public void setpAulansInformatica(int pAulansInformatica) {
        this.pAulansInformatica = pAulansInformatica;
    }

    public Laboratori[] getLaboratoris() {
        return laboratoris;
    }

    public void setLaboratoris(Laboratori[] laboratoris) {
        this.laboratoris = laboratoris;
    }

    public int getpLaboratoris() {
        return pLaboratoris;
    }

    public void setpLaboratoris(int pLaboratoris) {
        this.pLaboratoris = pLaboratoris;
    }

    public Campus addCampus() {
        System.out.println("Introdueix el nom del campus:");
        String nom_campus = DADES.nextLine();

        System.out.println("Introdueix la ubicació del campus:");
        String ubicacio = DADES.nextLine();

        return new Campus(nom_campus, ubicacio);
    }

    public void updateCampus() {

        System.out.println("Dades actual del campus:");
        System.out.println("Nom del campus: " + getNomCampus());
        System.out.println("Ubicació: " + getUbicacio());

        // noves dades
        System.out.println("\nIntrodueix les noves dades del campus:");

        System.out.println("Nou nom: ");
        setNomCampus(DADES.nextLine());

        System.out.println("Nova ubicació: ");
        setUbicacio(DADES.nextLine());

        System.out.println("\nDades actualizades correctament");
    }

    public double costManteniment() {
        double costTotal = 0;

        // calcular cost laboratoris
        for (int i = 0; i < getpLaboratoris(); i++) {
            costTotal += getLaboratoris()[i].costManteniment();
        }
        // calcular cost Aules Informàtica
        for (int i = 0; i < getpAulansInformatica(); i++) {
            costTotal += getAulesInformatica()[i].costManteniment();
        }
        // calcular cost aules estandard
        for (int i = 0; i < getpAulesEstandard(); i++) {
            costTotal += getAulesInformatica()[i].costManteniment();
        }
        return costTotal;
    }

    public void showcampus() {
        System.out.println("\n===== Informació del campus =====");
        System.out.println("Nom: " + getNomCampus() + "\n" +
                "Ubicació: " + getUbicacio() + "\n");
        System.out.println("Cost manteniment: " + costManteniment() + " €");
        System.out.println("====================================");
    }

    public void addAulaEstandard() {
        AulaEstandard novaAula = new AulaEstandard("", 0, 0).addAulaEstandard();
        boolean aulaExisteix = false;
        boolean espacio = true;
        for (int i = 0; i < getpAulesEstandard(); i++) {
            if (getAulesEstandard()[i].getCodi().equalsIgnoreCase(novaAula.getCodi())) {
                System.out.println("L'aula estàndard ja existeix");
                aulaExisteix = true;
            }
        }

        if (getpAulesEstandard() > 99) {
            espacio = false;
            System.out.println("No hi ha espai per afegir més aules");
        }

        if (!aulaExisteix && espacio) {
            getAulesEstandard()[getpAulesEstandard()] = novaAula;
            setpAulesEstandard(getpAulesEstandard() + 1);
            System.out.println("Aula afegida correctament");
        }

    }


    /**
     * Nom del mètode: selectAulaEstandard
     * <p>
     * Paràmetres: codi de l'aula estàndard
     * <p>
     * Accions:
     * - Mètode que selecciona una aula estàndard de l'array de aulesEstandard del campus actual
     * a partir del seu codi.
     * <p>
     * Retorn: posició de l'aula estàndard seleccionada a l'array de aulesEstandard del campus actual.
     * Si l'aula estàndard no existeix retorna -1.
     */
    public int selectAulaEstandard(String codi) {
        if (codi == null) {
            System.out.println("\nCodi de l'aula estàndard:");
            codi = DADES.nextLine();
        }

        for (int i = 0; i < pAulesEstandard; i++) {
            if (aulesEstandard[i].getCodi().equals(codi)) {
                return i;
            }
        }

        return -1;
    }

    public void addAulaInformatica() {
        AulaInformatica novaAula = new AulaInformatica("", 0, 0, 0).addAulaInformatica();
        boolean aulaExisteix = false;
        boolean espacio = true;

        for (int i = 0; i < getpAulansInformatica(); i++) {
            if (getAulesInformatica()[i].getCodi().equalsIgnoreCase(novaAula.getCodi())) {
                System.out.println("L'aula d'informàtica ja existeix");
                aulaExisteix = true;
            }
        }

        if (getpAulansInformatica() > 99) {
            espacio = false;
            System.out.println("No hi ha espai per afegir més aules");
        }

        if (!aulaExisteix && espacio) {
            getAulesInformatica()[getpAulansInformatica()] = novaAula;
            setpAulansInformatica(getpAulansInformatica() + 1);
            System.out.println("Aula d'informàtica afegida correctament");
        }
    }


    /**
     * Nom del mètode: selectAulaInformatica
     * <p>
     * Paràmetres: codi de l'aulaInformatica
     * <p>
     * Accions:
     * - Mètode que selecciona una aulaInformatica de l'array de aulesInformatica del campus actual
     * a partir del seu codi.
     * <p>
     * Retorn: posició de la aulaInformatica seleccionada a l'array de aulesInformatica del campus actual.
     * Si l'aula d'informàtica no existeix retorna -1.
     */
    public int selectAulaInformatica(String codi) {
        if (codi == null) {
            System.out.println("\nCodi de l'aula d'informàtica:");
            codi = DADES.nextLine();
        }

        for (int i = 0; i < getpAulansInformatica(); i++) {
            if (aulesInformatica[i].getCodi().equals(codi)) {
                return i;
            }
        }

        return -1;
    }

    public void addLaboratori() {
        Laboratori novaAula = new Laboratori("", 0, 0, 0).addLaboratori();
        boolean aulaExisteix = false;
        boolean espacio = true;
        for (int i = 0; i < getpLaboratoris(); i++) {
            if (getLaboratoris()[i].getCodi().equalsIgnoreCase(novaAula.getCodi())) {
                System.out.println("Laboratori ja existeix");
                aulaExisteix = true;
            }
        }

        if (getpLaboratoris() > 99) {
            espacio = false;
            System.out.println("No hi ha més espai per afegir més laboratoris");
        }

        if (!aulaExisteix && espacio) {
            getLaboratoris()[getpLaboratoris()] = novaAula;
            setpLaboratoris(getpAulesEstandard() + 1);
            System.out.println("Laboratori afegit correctament");
        }
    }

    /**
     * Nom del mètode: selectLaboratori
     * <p>
     * Paràmetres: codi del laboratori
     * <p>
     * Accions:
     * - Mètode que selecciona un laboratori de l'array de laboratoris del campus actual
     * a partir del seu codi.
     * <p>
     * Retorn: posició de la laboratori seleccionada a l'array d'laboratoris del campus actual.
     * Si el laboratori no existeix retorna -1.
     */

    public int selectLaboratori(String codi) {
        if (codi == null) {
            System.out.println("\nCodi del laboratori:");
            codi = DADES.nextLine();
        }

        for (int i = 0; i < pLaboratoris; i++) {
            if (laboratoris[i].getCodi().equals(codi)) {
                return i;
            }
        }
        return -1;
    }
}