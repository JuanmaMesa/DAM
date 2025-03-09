/*
 * Classe que defineix un Laboratori d'una universitat.
 * Es defineix pel seu codi, numeroLaboratori, cost per dia i la seva capacitat en nombre de persones.
 */
package universitat;


import java.util.Scanner;

/**
 * @author fgarin
 */
public class Laboratori {
    private final static Scanner DADES = new Scanner(System.in);

    private String codi;
    private int numeroLaboratori;
    private double costPerDia;
    private int capacitat;


    public Laboratori(String codi, int numeroLaboratori, double costPerDia, int capacitat) {
        this.codi = codi;
        this.numeroLaboratori = numeroLaboratori;
        this.costPerDia = costPerDia;
        this.capacitat = capacitat;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public int getNumeroLaboratori() {
        return numeroLaboratori;
    }

    public void setNumeroLaboratori(int numeroLaboratori) {
        this.numeroLaboratori = numeroLaboratori;
    }

    public double getCostPerDia() {
        return costPerDia;
    }

    public void setCostPerDia(double costPerDia) {
        this.costPerDia = costPerDia;
    }

    public int getCapacitat() {
        return capacitat;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    public Laboratori addLaboratori() {
        System.out.println("Introdueix el codi del Laboratori:");
        String codi = DADES.nextLine();

        System.out.println("Introdueix el número del laboratori:");
        int numeroLaboratori = DADES.nextInt();

        System.out.println("Introdueix el cost per dia:");
        double costPerDia = DADES.nextDouble();

        System.out.println("Introdueix la capacitat del laboratori:");
        int capacitat = DADES.nextInt();

        DADES.nextLine(); // limpieza de buffer

        return new Laboratori(codi, numeroLaboratori, costPerDia, capacitat);
    }

    public void updateLaboratori() {
        System.out.println("Dades actuals del laboratori:");
        System.out.println("Codi: " + getCodi());
        System.out.println("Numero de l'aula del laboratori: " + getNumeroLaboratori());
        System.out.println("Cost per dia: " + getCostPerDia());
        System.out.println("Capacitat: " + getCapacitat());

        // noves dades
        System.out.println("\nIntrodueix les noves dades del laboratori:");

        System.out.println("Nou codi: ");
        setCodi(DADES.nextLine());

        System.out.println("Nou numero del laboratori: ");
        setNumeroLaboratori(DADES.nextInt());

        System.out.println("Nou cost per dia: ");
        setCostPerDia(DADES.nextDouble());

        System.out.println("Nova capacitat: ");
        setCapacitat(DADES.nextInt());

        DADES.nextLine(); // Limpiar buffer

        System.out.println("\nDades actualizades correctament");
    }

    public void showLaboratori() {

        System.out.println("\n===== Informació del laboratori =====");
        System.out.println("Codi: " + getCodi() + "\n" +
                "Num. laboratori: " + getNumeroLaboratori() + "\n" +
                "Cost per dia: " + getCostPerDia() + " €\n" +
                "Capacitat: " + getCapacitat()
        );

        System.out.println("====================================");
    }


    public double costManteniment() {
        return (0.35 * getCostPerDia()) + (0.10 * getCapacitat());
    }

}
