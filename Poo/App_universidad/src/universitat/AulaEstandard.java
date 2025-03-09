/*
 * Classe que defineix una aula estàndard d'una universitat.
 * Es defineixen pel seu codi, número d'aula i el seu cost per dia.
 */
package universitat;


import java.util.Scanner;

/**
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

    public AulaEstandard addAulaEstandard() {
        System.out.println("Introdueix el codi de l'aula:");
        String codi = DADES.nextLine();

        System.out.println("Introdueix el número de l'aula:");
        int numeroAula = DADES.nextInt();

        System.out.println("Introdueix el cost per dia:");
        double costPerDia = DADES.nextDouble();

        DADES.nextLine(); // limpieza buffer

        return new AulaEstandard(codi, numeroAula, costPerDia);
    }

    public void updateAulaEstandard() {
        System.out.println("Dades actual de l'aula:");
        System.out.println("Codi: " + getCodi());
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

        DADES.nextLine(); // limpieza buffer

        System.out.println("\nDades actualizades correctament");
    }

    public void showAulaEstandard() {
        System.out.println("\n===== Informació de l'aula =====");
        System.out.println("Codi: " + getCodi() + "\n" +
                "Num. aula: " + getNumeroAula() + "\n" +
                "Cost per dia: " + getCostPerDia() + " €");

        System.out.println("====================================");
    }

    public double costManteniment() {
        return getCostPerDia() * 0.2;

    }
}