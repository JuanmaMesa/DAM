/**
 * Classe que defineix un campus. Es defineix pel seu nom,
 * la seva ubicació, un array d'aules estàndard,
 * un array d'aules d'informàtica i un array de laboratoris.
 */

package universitat;


import java.util.Scanner;

/**
 *
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

    public Campus addCampus(){
        System.out.println("Introdueix el nom del campus:");
        String nom_campus = DADES.nextLine();

        System.out.println("Introdueix la ubicació del campus:");
        String ubicacio = DADES.nextLine();

        return new Campus(nom_campus,ubicacio);
    }


    public void updateCampus(){

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
    

    /*
     * TODO
     *
     * Nom del mètode: costManteniment
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Calcular el cost de manteniment del campus a partir dels costos
     *   de manteniment de les aules i laboratoris del campus.
     *
     * Retorn: cost de manteniment total del campus.
     */

    public double costManteniment(){
        double costTotal = 0;

        // calcular cost laboratoris
        for(int i = 0; i < getpLaboratoris(); i++){
            costTotal+=laboratoris[i].costManteniment();
        }
        // calcular cost Aules Informàtica
        for(int i = 0; i < getpAulansInformatica(); i++){
            costTotal+= aulesInformatica[i].costManteniment();
        }
        // calcular cost aules estandard
        for(int i = 0; i < getpAulesEstandard(); i++){
            costTotal+= aulesEstandard[i].costManteniment();
        }
        return costTotal;
    }
   

    /*
     * TODO
     *
     * Nom del mètode: showCampus
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Mètode per mostrar les dades del campus i el seu cost de manteniment.
     *
     * Retorn: cap
     */
   
    
    /**
     * AulaEstandard
     *
     * TODO
     *
     * Nom del mètode: addAulaEstandard
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Afegeix una nova aula estàndard a l'array d'aulesEstandard
     *   del campus actual si aquest/a no existeix.
     *   Per afegir-lo heu de fer servir el mètode de la classe AulaEstandard
     *   escaient i per comprovar la seva existència el mètode d'aquesta classe
     *   que ens ajuda en aquesta tasca.
     * - Actualitza la posició de l'array de aulesEstandard si s'afegeix.
     * - Mostra el missatge "L'aula estàndard ja existeix" si
     *   no s'ha afegit.
     *
     * Retorn: cap
     */
    

    /**
     *
     * Nom del mètode: selectAulaEstandard
     *
     * Paràmetres: codi de l'aula estàndard
     *
     * Accions:
     * - Mètode que selecciona una aula estàndard de l'array de aulesEstandard del campus actual
     *   a partir del seu codi.
     *
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

    /**
     * AulaInformatica
     *
     * TODO
     *
     * Nom del mètode: addAulaInformatica
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Afegeix una nova aulaInformatica a l'array de aulesInformatica
     *   del campus actual si aquesta no existeix.
     *   Per afegir-la heu de fer servir el mètode de la classe AulaInformatica
     *   escaient i per comprovar la seva existència el mètode d'aquesta classe
     *   que ens ajuda en aquesta tasca.
     * - Actualitza la posició de l'array de aulesInformatica si s'afegeix.
     * - Mostra el missatge "L'aula d'informàtica ja existeix" si
     *   no s'ha afegit.
     *
     * Retorn: cap
     */
    
    
    
    /**
     *
     * Nom del mètode: selectAulaInformatica
     *      
     * Paràmetres: codi de l'aulaInformatica
     *
     * Accions:
     * - Mètode que selecciona una aulaInformatica de l'array de aulesInformatica del campus actual
     *   a partir del seu codi.
     *
     * Retorn: posició de la aulaInformatica seleccionada a l'array de aulesInformatica del campus actual.
     * Si l'aula d'informàtica no existeix retorna -1.
     */    
    public int selectAulaInformatica(String codi) {
        if (codi == null) {
            System.out.println("\nCodi de l'aula d'informàtica:");
            codi = DADES.nextLine();
        }

        for (int i = 0; i < pAulesInformatica; i++) {
            if (aulesInformatica[i].getCodi().equals(codi)) {
                return i;
            }
        }

        return -1;
    }
    
    /**
     * Laboratori
     *
     * TODO
     *
     * Nom del mètode: addLaboratori
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Afegeix un nou laboratori a l'array de laboratoris
     *   del campus actual si aquest no existeix.
     *   Per afegir-lo heu de fer servir el mètode de la classe Laboratori
     *   escaient i per comprovar la seva existència el mètode d'aquesta classe
     *   que ens ajuda en aquesta tasca.
     * - Actualitza la posició de l'array de laboratoris si s'afegeix.
     * - Mostra el missatge "El laboratori ja existeix" si
     *   no s'ha afegit.
     *
     * Retorn: cap
     */
    

    /**
     *
     * Nom del mètode: selectLaboratori
     * 
     * Paràmetres: codi del laboratori
     *
     * Accions:
     * - Mètode que selecciona un laboratori de l'array de laboratoris del campus actual
     *   a partir del seu codi.
     *
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