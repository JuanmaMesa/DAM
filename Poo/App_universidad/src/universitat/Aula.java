package universitat;

public abstract class Aula  implements UnitatUniversitat{
    private String codi;
    private int numeroAula;
    private double costPerDia;

    public Aula(String codi, int numeroAula, double costPerDia) {
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

    @Override
    public void showUnitatUniversitat() {
        System.out.println("\nLes dades de "+ getNomAula() +" amb codi " + this.getCodi() + " són:");
        System.out.println("\nNúmero "+ getNomAula()+" : " + this.getNumeroAula());
        System.out.println("\nCost per dia: " + this.getCostPerDia());

    }

    @Override
    public void updateUnitatUniversitat() {
        System.out.println("\nCodi de " +getNomAula() + ": " + this.getCodi());
        System.out.println("Entra el nou valor del codi: ");
        setCodi(DADES.nextLine());

        System.out.println("\nNúmero " + getNomAula()+ ": " + this.getNumeroAula());
        System.out.println("\nEntra el nou valor del numero " + getNomAula());
        setNumeroAula(Integer.parseInt(DADES.nextLine()));

        System.out.println("\nCost per dia de "+ getNomAula()+ ":" + this.getCostPerDia());
        System.out.println("Entra el nou valor del cost per dia de " + getNomAula()+ ":");
        setCostPerDia(Double.parseDouble(DADES.nextLine()));

    }

    protected String getNomAula(){
        return"Aula Estandard";
    }
}
