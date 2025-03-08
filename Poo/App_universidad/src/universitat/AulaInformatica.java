/*
 * Classe que defineix una aula d'informàtica d'una universitat.
 * Es defineix pel seu codi, número d'aula, el seu cost per dia i el tamany de l'aula en metres quadrats.
 */
package universitat;


import java.util.Scanner;

/**
 * @author fgarin
 */
public class AulaInformatica {
    private final static Scanner DADES = new Scanner(System.in);

    private String codi;
    private int numeroAula;
    private double costPerDia;
    private double areaEnMetresQuadrats;


    public AulaInformatica(String codi, int numeroAula, double cosPerDia, double areaEnMetresQuadrats) {
        this.codi = codi;
        this.numeroAula = numeroAula;
        this.costPerDia = cosPerDia;
        this.areaEnMetresQuadrats = areaEnMetresQuadrats;
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

    public double getAreaEnMetresQuadrats() {
        return areaEnMetresQuadrats;
    }

    public void setAreaEnMetresQuadrats(double areaEnMetresQuadrats) {
        this.areaEnMetresQuadrats = areaEnMetresQuadrats;
    }

    public AulaInformatica addAulaInformatica() {

        System.out.println("Introdueix el codi de l'aula d'informàtica:");
        String codi = DADES.nextLine();

        System.out.println("Introdueix el número de l'aula:");
        int numeroAula = DADES.nextInt();

        System.out.println("Introdueix el cost per dia:");
        double costPerDia = DADES.nextDouble();

        System.out.println("Introdueix el area en m2: ");
        double area = DADES.nextDouble();

        DADES.nextLine(); // limpieza buffer

        return new AulaInformatica(codi, numeroAula, costPerDia, area);
    }

    public void updateAulaInformatica() {
        System.out.println("Dades actual de l'aula d'informàtica:");
        System.out.println("Codi: " + getCodi());
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

    public void showAulaInformatica() {
        System.out.println("\n===== Informació de l'aula d'informàtica =====");
        System.out.println("Codi: " + getCodi() + "\n" +
                "Num. aula: " + getNumeroAula() + "\n" +
                "Cost per dia: " + getCostPerDia() + " $\n" +
                "Area en m2: " + getAreaEnMetresQuadrats() + " m2"
        );

        System.out.println("====================================");
    }

    public double costManteniment() {
        return (0.3 * getCostPerDia()) + (0.05 * getAreaEnMetresQuadrats());
    }
}
