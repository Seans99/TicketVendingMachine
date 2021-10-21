import java.util.Scanner;

public class MainMenu {

    //Metoden för kunden att betala den totala summan för sin biljett.
    public void addSaldo(int totalCost) {
        boolean run = true;
        while (run) {
            System.out.println("-----------------------");
            System.out.println("Kostnad på din biljett är: " + totalCost + " kr.");
            System.out.println("Var snäll och mata in rätt antal kr.");
            System.out.println("-----------------------");
            System.out.print("insättning: ");
            int deposit = scan.nextInt();
            if (deposit < totalCost) {
                System.out.println("Du satt in för lite, var snäll och försök igen.");
                continue;
            } else if (deposit > totalCost) {
                System.out.println("Du satt in för mycket pengar, var snäll och försök igen.");
                continue;
            }
            System.out.println("Genomför köp...");
            run = false;
        }
    }

    //Scanner objekt för kundens input.
    Scanner scan = new Scanner(System.in);

    //Huvud menyn.
    public void startMenu() {

        //Objekt till för de andra klasser.
        DepartureMenu travel = new DepartureMenu();
        MyTicket tickets = new MyTicket();

        System.out.println("-------------");
        System.out.println("SKÅNETRAFIKEN");
        System.out.println("-------------");
        System.out.println("1.Sök Resa.");
        System.out.println("2.Mina Biljetter.");
        System.out.println("3.Visa biljett priser.");
        System.out.println("4.Avsluta.");
        System.out.println("-------------");
        System.out.print("Ange val: ");

        try {

            int choice = scan.nextInt();

                //Switch case till huvud menyn.
                switch (choice) {

                    //Om kunden trycker 1 kommer man till res menyn.
                    case 1:
                        travel.destinationMenu();
                        break;

                    //Om kunden trycker 2 visas kundens biljett, om kunden har en.
                    case 2:
                        System.out.println("-----------------------");
                        System.out.println("SENASTE KÖPTA BILJETTEN");
                        System.out.println("-----------------------");
                        tickets.viewTickets();
                        break;

                    //Om kunden trycker 3 visas biljett priserna.
                    case 3:
                        System.out.println("BILJETT PRISER");
                        System.out.println("--------------");
                        System.out.println("-Barn\n -inom skåne 20kr\n -utanför skåne 30kr\n");
                        System.out.println("-Vuxen\n -inom skåne 40kr\n -utanför skåne 50kr\n");
                        System.out.println("-Pensionär\n -inom skåne 30kr\n -utanför skåne 40kr\n");
                        System.out.println("--------------");
                        startMenu();
                        break;

                    //Om kunden trycker 4 stängs systemet av.
                    case 4:
                        System.exit(0);
                        break;
                    //Om kundens input inte finns får han/hon en Error.
                    default:
                        System.out.println("Error " + choice + " finns ej!");
                        startMenu();
                        break;

                }
        } catch(Exception e) {
            MainMenu menu = new MainMenu();
            System.out.println("Error input finns ej!");
            menu.startMenu();
        }
    }

    public static void main(String[] args) {

        //Objekt till start menyn klassen.
        MainMenu menu = new MainMenu();
        menu.startMenu();

    }
}
