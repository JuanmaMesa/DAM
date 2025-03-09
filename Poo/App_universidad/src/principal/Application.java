package principal;

import universitat.Campus;
import universitat.Universitat;

import java.util.Scanner;


/**
 * @author fgarin
 */
public class Application {
    private final static Scanner DADES = new Scanner(System.in);

    private static Universitat[] universitats = new Universitat[10];
    private static int pUniversitat = 0; //Primera posició buida del vector universitats
    private static Universitat universitatActual = null;

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opcio = 0;

        do {
            System.out.println("\nMenú principal. Selecciona una opció:");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Gestió d'universitats");
            System.out.println("\n2. Gestió de campus");
            System.out.println("\n3. Gestió d'aules estàndard");
            System.out.println("\n4. Gestió d'aules d'informàtica");
            System.out.println("\n5. Gestió de laboratoris");
            System.out.println("\n");

            opcio = Integer.parseInt(DADES.nextLine());

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    menuUniversitats();
                    break;
                case 2:
                    if (universitatActual != null) {
                        menuCampus();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la universitat al menú 1. Gestió d'universitats.");
                    }
                    break;
                case 3:
                    if (universitatActual != null) {
                        menuAulesEstandard();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar el campus al menú 1. Gestió de campus.");
                    }
                    break;
                case 4:
                    if (universitatActual != null) {
                        menuAulesInformatica();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar el campus al menú 1. Gestió de campus.");
                    }
                    break;
                case 5:
                    if (universitatActual != null) {
                        menuLaboratoris();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar el campus al menú 1. Gestió de campus.");
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuUniversitats() {
        int opcio;

        do {
            int indexSel;
            System.out.println("\nMenú d'universitats. Selecciona una opció:");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Seleccionar");
            System.out.println("\n3. Modificar");
            System.out.println("\n4. Llistar");
            System.out.println("\n");

            opcio = Integer.parseInt(DADES.nextLine());

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    Universitat novaUniversitat = Universitat.addUniversitat();

                    indexSel = selectUniversitat(novaUniversitat);

                    if (indexSel == -1) {
                        universitats[pUniversitat] = novaUniversitat;
                        pUniversitat++;
                    } else {
                        System.out.println("\nLa universitat ja existeix");
                    }

                    break;
                case 2:
                    indexSel = selectUniversitat(null);

                    if (indexSel >= 0) {
                        universitatActual = universitats[indexSel];
                    } else {
                        System.out.println("\nNo existeix aquesta universitat");
                    }
                    break;
                case 3:
                    indexSel = selectUniversitat(null);

                    if (indexSel >= 0) {
                        universitats[indexSel].updateUniversitat();
                    } else {
                        System.out.println("\nNo existeix aquesta universitat");
                    }
                    break;
                case 4:
                    for (int i = 0; i < pUniversitat; i++) {
                        universitats[i].showUniversitat();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuCampus() {
        int opcio = 0;
        int indexSel;
        do {
            System.out.println("\nMenú Campus. Selecciona una opció:");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llista Campus");
            System.out.println("\n");

            opcio = Integer.parseInt(DADES.nextLine());

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    universitatActual.addCampus();
                    break;
                case 2:
                    indexSel = universitatActual.selectCampus(null);

                    if (indexSel >= 0) {
                        universitatActual.getCampus()[indexSel].updateCampus();
                    } else {
                        System.out.println("\nNo existeix aquest campus");
                    }
                    break;
                case 3:
                    if (universitatActual.getpCampus() == 0) {
                        System.out.println("La universitat encare no te cap Campus");
                    }
                    for (int i = 0; i < universitatActual.getpCampus(); i++) {
                        universitatActual.getCampus()[i].showCampus();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }

        } while (opcio != 0);
    }

    public static void menuAulesEstandard() {

        int opcio = 0;
        int indexSel;
        do {
            System.out.println("\nMenú Aules Estàndard: Selecciona una opció:");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llista Aules Estàndard");
            System.out.println("\n");

            opcio = Integer.parseInt(DADES.nextLine());

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    universitatActual.addAulaEstandardCampus();
                    break;
                case 2:
                    universitatActual.updateAulaEstandardCampus();
                    break;
                case 3:
                    indexSel = universitatActual.selectCampus(null);

                    if (indexSel != -1) {
                        for (int i = 0; i < universitatActual.getCampus()[indexSel].getpAulesEstandard(); i++) {
                            for (int j = 0; j < universitatActual.getCampus()[indexSel].getpAulesEstandard(); j++)
                                universitatActual.getCampus()[indexSel].getAulesEstandard()[j].showAulaEstandard();
                        }
                    } else {
                        System.out.println("\nEl campus no té cap Aula estandàrd");
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuAulesInformatica() {
        int opcio = 0;
        int indexSel;
        do {
            System.out.println("\nMenú Aules Informàtiques: Selecciona una opció:");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llista aules d'informàtica");
            System.out.println("\n");

            opcio = Integer.parseInt(DADES.nextLine());

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    universitatActual.addAulaInformaticaCampus();
                    break;
                case 2:
                    universitatActual.updateAulaInformaticaCampus();
                    break;
                case 3:
                    indexSel = universitatActual.selectCampus(null);

                    if (indexSel != -1) {
                        for (int i = 0; i < universitatActual.getCampus()[indexSel].getpAulansInformatica(); i++) {
                            for (int j = 0; j < universitatActual.getCampus()[indexSel].getpAulansInformatica(); j++)
                                universitatActual.getCampus()[indexSel].getAulesInformatica()[j].showAulaInformatica();
                        }
                    } else {
                        System.out.println("\nEl campus no té cap Aula d'informàtica");
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuLaboratoris() {
        int opcio = 0;
        int indexSel;
        do {
            System.out.println("\nMenú Aules Laboratoris: Selecciona una opció:");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llista Laboratoris");
            System.out.println("\n");

            opcio = Integer.parseInt(DADES.nextLine());

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    universitatActual.addLaboratoriCampus();
                    break;
                case 2:
                    universitatActual.updateLaboratoriCampus();
                    break;
                case 3:
                    indexSel = universitatActual.selectCampus(null);

                    if (indexSel != -1) {
                        for (int i = 0; i < universitatActual.getCampus()[indexSel].getpLaboratoris(); i++) {
                            for (int j = 0; j < universitatActual.getCampus()[indexSel].getpLaboratoris(); j++)
                                universitatActual.getCampus()[indexSel].getLaboratoris()[j].showLaboratori();
                        }
                    } else {
                        System.out.println("\nEl campus no té cap Laboratori");
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }


    public static Integer selectUniversitat(Universitat Universitat) {
        String nom;

        if (Universitat == null) {
            System.out.println("\nNom de la universitat:");
            nom = DADES.nextLine();
        } else {
            nom = Universitat.getNomUniversitat();
        }

        for (int i = 0; i < pUniversitat; i++) {
            if (universitats[i].getNomUniversitat().equals(nom)) {
                return i;
            }
        }

        return -1;
    }
}
