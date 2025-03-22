/*
 * Classe que defineix una aula d'informàtica d'una universitat.
 * Es defineix pel seu codi, número d'aula, el seu cost per dia i el tamany de l'aula en metres quadrats.
 */
package universitat;


import java.util.Scanner;

/**
 * @author fgarin
 */
public class AulaInformatica extends Aula {
    private double areaEnMetresQuadrats;


    public AulaInformatica(String codi, int numeroAula, double costPerDia, double areaEnMetresQuadrats) {
        super(codi, numeroAula, costPerDia);
        this.areaEnMetresQuadrats = areaEnMetresQuadrats;
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
                "Cost per dia: " + getCostPerDia() + " €\n" +
                "Area en m2: " + getAreaEnMetresQuadrats() + " m2"
        );

        System.out.println("====================================");
    }

    public double costManteniment() {
        return (0.3 * getCostPerDia()) + (0.05 * getAreaEnMetresQuadrats());
    }

    @Override
    public void updateUnitatUniversitat() {
        super.updateUnitatUniversitat();

        System.out.println("\nÀrea en metres quadrats de l'aula d'informàtica: " + this.getAreaEnMetresQuadrats());
        System.out.println("Entra el nou valor de l'àrea en metres quadrats de l'aula d'informàtica:");
        areaEnMetresQuadrats = Double.parseDouble(DADES.nextLine());



    }

    @Override
    public void showUnitatUniversitat() {
        super.showUnitatUniversitat();
        System.out.println("\nL'àrea en metres quadrats de l'aula: " + this.getAreaEnMetresQuadrats());
        System.out.println("\nCost de manteniment: " + this.costManteniment() + " EUR");


    }

    @Override
    protected String getNomAula() {
        return "Aula d'informàtica";
    }
}



