/*
 * Classe que defineix una aula d'informàtica d'una universitat. 
 * Es defineix pel seu codi, número d'aula, el seu cost per dia i el tamany de l'aula en metres quadrats.
 */
package universitat;


import java.util.Scanner;

/**
 *
 * @author fgarin
 */
public class AulaInformatica {
    private final static Scanner DADES = new Scanner(System.in);

    private String codi;
    private int numeroAula;
    private double costPerDia;
    private double areaEnMetresQuadrats;

    /*
     * TODO CONSTRUCTOR
     *
     * Nom del mètode: AulaInformatica          
     *
     * Paràmetres: valors per tots els atributs de la classe.
     *
     * Accions:
     * - Assignar als atributs corresponents els valors passats com a paràmetres.
     */

    public AulaInformatica(String codi, int numeroAula, double cosPerDia, double areaEnMetresQuadrats) {
        this.codi = codi;
        this.numeroAula = numeroAula;
        this.costPerDia = cosPerDia;
        this.areaEnMetresQuadrats = areaEnMetresQuadrats;
    }

    /*
     * TODO Heu d'implementar tots els mètodes accessors possibles.  
     */

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

    public double getAreaEnMetresQuadrats() {
        return areaEnMetresQuadrats;
    }

    public void setAreaEnMetresQuadrats(double areaEnMetresQuadrats) {
        this.areaEnMetresQuadrats = areaEnMetresQuadrats;
    }

    /*
     * TODO
     *
     * Nom del mètode: addAulaInformatica
     *
     * Paràmetres: cap
    
     * Accions:
     * - Demanar a l'usuari les dades per consola per crear una nova aula de informatica. Les dades a
     *   demanar són les que necessita el constructor.
     *
     * Retorn: Objecte AulaInformatica creat.
     */


    public AulaInformatica addAulaInformatica(){

        System.out.println("Introdueix el codi de l'aula d'informàtica:");
        String codi = DADES.nextLine();

        System.out.println("Introdueix el número de l'aula:");
        int numeroAula = DADES.nextInt();

        System.out.println("Introdueix el cost per dia:");
        double costPerDia = DADES.nextDouble();

        System.out.println("Introdueix el area en m2: ");
        double area = DADES.nextDouble();


        DADES.nextLine(); // limpieza buffer

        return new AulaInformatica(codi, numeroAula,costPerDia, area);
    }
    

    /*
     * TODO
     *
     * Nom del mètode: updateAulaInformatica
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Demanar a l'usuari que introdueixi les noves dades de l'aula de informatica i modificar els
     *   atributs corresponents d'aquesta aula.
     * - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     *
     * Retorn: cap
     */


    public void updateAulaInformatica(){
        System.out.println("Dades actual de l'aula d'informàtica:");
        System.out.println("Codi: "+ getCodi());
        System.out.println("Numero de l'aula d'informàtica: " + getNumeroAula());
        System.out.println(("Cost per dia: " + getCostPerDia()));

        // noves dades
        System.out.println("\nIntrodueix les noves dades de l'aula d'informàtica:");

        System.out.println("Nou codi: ");
        setCodi(DADES.nextLine());

        System.out.println("Nou numero de l'aula: ");
        setNumeroAula(DADES.nextInt());

        System.out.println("Nou cost per dia: ");
        setCostPerDia(DADES.nextDouble());

        System.out.println("Nou Area en m2: ");
        setAreaEnMetresQuadrats(DADES.nextDouble());

        DADES.nextLine(); // Limpiar buffer

        System.out.println("\nDades actualizades correctament");

    }


    

    /*
     * TODO
     *
     * Nom del mètode: showAulaInformatica
     * 
     * Accions:
     * - Mètode per imprimir les dades de l'aula de informatica i el seu cost de manteniment.
     *
     * Retorn: cap
     */
    public void showAulaInformatica(){
        System.out.println("\n===== Informació de l'aula d'informàtica =====");
        System.out.println("Codi: "+ getCodi()+"\n"+
                "Num. aula: "+ getNumeroAula()+"\n"+
                "Cost per dia: " + getCostPerDia() +" $\n"+
                "Area en m2: " + getAreaEnMetresQuadrats() + " m2"
        );

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
     * - Mètode que retornarà el cost de manteniment de l'aula actual. 
     * - El cost de manteniment per dia és un 30% del cost per dia de l'aula + un 5% de la seva àrea
     *
     * Retorn: cost de manteniment de l'aula (double).
     */

    public double costManteniment(){
        return (0.3 * getCostPerDia()) + (0.05 * getAreaEnMetresQuadrats());
    }
    


}
