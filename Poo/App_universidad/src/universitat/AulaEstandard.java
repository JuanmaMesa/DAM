/*
 * Classe que defineix una aula estàndard d'una universitat. 
 * Es defineixen pel seu codi, número d'aula i el seu cost per dia.
 */
package universitat;


import java.util.Scanner;

/**
 *
 * @author fgarin
 */
public class AulaEstandard {
    private final static Scanner DADES = new Scanner(System.in);

    private String codi;
    private int numeroAula;
    private double costPerDia;

    public AulaEstandard(String codi, int numeroAula, double costPerDia) {
        this.codi = codi;
        this.numeroAula = numeroAula;
        this.costPerDia = costPerDia;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public int getNumeroAula() {
        return numeroAula;
    }

    public void setNumeroAula(int numeroAula) {
        this.numeroAula = numeroAula;
    }

    public double getCostPerDia() {
        return costPerDia;
    }

    public void setCostPerDia(double costPerDia) {
        this.costPerDia = costPerDia;
    }

    /*
     * TODO Heu d'implementar tots els mètodes accessors possibles.  
     */
    
    

    /*
    * TODO
    *
    * Nom del mètode: addAulaEstandard
    *
    * Accions:
    * - Demanar a l'usuari les dades per consola per crear una nova 
    *   AulaEstandard. Les dades a demanar són les que necessita 
    *   el constructor.
    *
    * Retorn: Objecte AulaEstandard creat.
    */

    public AulaEstandard addAulaEstandard(){
        System.out.println("Introdueix el codi de l'aula:");
        String codi = DADES.nextLine();

        System.out.println("Introdueix el número de l'aula:");
        int numeroAula = DADES.nextInt();

        System.out.println("Introdueix el cost per dia:");
        double costPerDia = DADES.nextDouble();
        // limpieza de buffer?? DADES.nextLine();

        return new AulaEstandard(codi, numeroAula,costPerDia);
    }
   

    /*
     * TODO
     *
     * Nom del mètode: updateAulaEstandard
     * 
     * Paràmetres: cap
     * 
     * Accions:
     * - Demanar a l'usuari que introdueixi les noves dades de l'aula actual i
     *   modificar els atributs corresponents d'aquesta aula.
     * - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     * 
     * Retorn: cap
     */

    public void updateAulaEstandard(){
        System.out.println("Dades actual de l'aula:");
        System.out.println("Codi: "+ getCodi());
        System.out.println("Numero de l'aula: " + getNumeroAula());
        System.out.println(("Cost per dia: " + getCostPerDia()));

        // noves dades
        System.out.println("\nIntrodueix les noves dades de l'aula:");

        System.out.println("Nou codi: ");
        setCodi(DADES.nextLine());

        System.out.println("Nou numero de l'aula: ");
        setNumeroAula(DADES.nextInt());

        System.out.println("Nou cost per dia: ");
        setCostPerDia(DADES.nextDouble());

        System.out.println("\nDades actualizades correctament");

    }
    
    
    /*
     * TODO
     *
     * Nom del mètode: showAulaEstandard
     * 
     * Paràmetres: cap
     * 
     * Accions:
     * - Mètode per mostrar les dades de l'aula actual i el seu cost de manteniment.
     * 
     * Retorn: cap
     */

    public void showAulaEstandard(){
        System.out.println("\n===== Informació de l'aula =====");
        System.out.println("Codi: "+ getCodi()+"\n"+
                           "Num. aula: "+ getNumeroAula()+"\n"+
                           "Cost per dia: " + getCostPerDia() +" $");

        System.out.println("====================================");
    }


   

    /*
     * TODO
     *
     * Nom del mètode: costManteniment
     * 
     * Paràmetres: cap
     * 
     * Accions:
     * - Mètode que calcula el cost de manteniment del AulaEstandard actual
     *   a partir del seu cost per dia (inclou manteniment, neteja...)
     *   El cost de manteniment per dia és un 20% del cost per dia de l'aula
     * 
     * Retorn: cost de manteniment de l'aula (double).
     */

    public double costManteniment(){
        return getCostPerDia() * 0.2;

    }


}