import com.sun.tools.javac.Main;

import java.util.*;

public class DepartureMenu {

    //Klassens fältvariabler.
    private String startDest;
    private String endDest;
    private double leaveTime;
    private double arrivalTime;
    public int totalCost = 0;

    //Array list till biljetterna kunden kan köpa.
    public static ArrayList<String> tickets = new ArrayList<>();

    /*
    Getters och setter till alla privata fältvariablerna
    i den här klassen.
     */

    public String getStartDest() {
        return startDest;
    }

    public void setStartDest(String startDest) {
        this.startDest = startDest;
    }

    public String getEndDest() {
        return endDest;
    }

    public void setEndDest(String endDest) {
        this.endDest = endDest;
    }

    public double getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(double leaveTime) {
        this.leaveTime = leaveTime;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public static ArrayList<String> getTickets() {
        return tickets;
    }

    public static void setTickets(String tickets) {
        DepartureMenu.tickets.add(tickets);
    }

    //Objekt till scanner och huvud meny klassen.
    Scanner scan = new Scanner(System.in);
    MainMenu menu = new MainMenu();

    //Array med alla tillgängliga stationer.
    private final String[] stations = {"Malmö C", "Hjärup", "Lund C", "Eslöv C",
            "Hässleholm C", "Kristianstad C", "Bromölla", "Köpenhamn C", "Hyllie",
            "Triangeln", "Oxie station", "Svedala", "Skurup", "Svarte", "Ystad"};

    //Array för tåg linje 1.
    private final String[] line1 = {"Malmö C", "Hjärup", "Lund C", "Eslöv C",
            "Hässleholm C", "Kristianstad C"};

    //Array för tåg linje 2.
    private final String[] line2 = {"Malmö C", "Lund C", "Hässleholm C",
            "Kristianstad C", "Bromölla"};

    //Array för tåg linje 3.
    private final String[] line3 = {"Köpenhamn C", "Hyllie", "Malmö C", "Triangeln"};

    //Array för tåg linje 4.
    private final String[] line4 = {"Köpenhamn C", "Hyllie", "Malmö C", "Triangeln",
            "Lund C", "Hässleholm C", "Kristianstad C"};

    //Array för tåg linje 5.
    private final String[] line5 = {"Lund C", "Hjärup", "Malmö C", "Triangeln",
            "Hyllie", "Oxie station", "Svedala", "Skurup", "Svarte", "Ystad"};

    /*
    Omvandlar alla Arrays (inte Array List) till en List,
    så att metoderna som används till Arraylist och list
    också fungerar på de vanliga arrays.
     */

    List<String> station1 = Arrays.asList(stations);
    List<String> route1 = Arrays.asList(line1);
    List<String> route2 = Arrays.asList(line2);
    List<String> route3 = Arrays.asList(line3);
    List<String> route4 = Arrays.asList(line4);
    List<String> route5 = Arrays.asList(line5);

    public void destinationMenu() {

        System.out.println("            TÅG RUTTER           ");
        System.out.println("---------------------------------");
        System.out.println("LINJE 1: Malmö C - Hjärup - Lund C - Eslöv C - Hässleholm C - Kristianstad C");
        System.out.println("LINJE 2: Malmö C - Lund C - Hässleholm C - Kristianstad C - Bromölla");
        System.out.println("LINJE 3: Köpenhamn C - Hyllie - Malmö C - Triangeln");
        System.out.println("LINJE 4: Köpenhamn C - Hyllie - Malmö C - Triangeln - " +
                            "Lund C - Hässleholm C - Kristianstad C");
        System.out.println("LINJE 5: Lund C - Hjärup - Malmö C - Triangeln - Hyllie - " +
                            "Oxie station - Svedala  - Skurup - Svarte - Ystad");
        System.out.println("---------------------------------");

        try {
        boolean run = true;
        while (run) {
            //Kunden väljer en station att åka ifrån.
            System.out.print("Ange start station: ");
            String start = scan.nextLine();

            /*
            Detta ger kundens input en stor bokstav i början
            om kunden inte gav namnet en stor bokstav.
            Den gör också att C på slutet alltid är
            en stor bokstav.
             */

            String newStart;
            int stringLength1 = start.length();
            String cap1 = start.substring(0, 1).toUpperCase() + start.substring(1);
            if (start.endsWith("c")) {
                String letter1 = start.substring(0, 1);
                String lastLetter1 = start.substring((stringLength1 - 1), (stringLength1));
                newStart = letter1.toUpperCase()
                        + start.substring(1, start.length() - 1)
                        + lastLetter1.toUpperCase();
            } else {
                newStart = cap1;
            }

            /*
            Om stationen finns kommer den läggas i den privata startDest variabeln.
            Annars får man försöka igen.
             */

            if (station1.contains(newStart)) {
                setStartDest(newStart);
            } else {
                System.out.println(start + " finns ej");
                continue;
            }
            run = false;
        }
        run = true;
        while (run) {
            System.out.print("Ange slut station: ");
            String end = scan.nextLine();

            /*
            Samma som för start så ger den kundens input en stor bokstav i början
            och om den slutar på C så görs den till en stor bokstav också.
             */

            String newEnd;
            int stringLength2 = end.length();
            String cap2 = end.substring(0, 1).toUpperCase() + end.substring(1);
            if (end.endsWith("c")) {
                String letter2 = end.substring(0, 1);
                String lastLetter2 = end.substring((stringLength2 - 1), (stringLength2));
                newEnd = letter2.toUpperCase()
                        + end.substring(1, end.length() - 1)
                        + lastLetter2.toUpperCase();
            } else {
                newEnd = cap2;
            }

            /*
            Om stationen finns kommer den läggas i den privata endDest variabeln.
            Annars får man försöka igen.
             */

            if (station1.contains(newEnd)) {
                setEndDest(newEnd);
            } else {
                System.out.println(end + " finns ej");
                continue;
            }
            run = false;
        }
        } catch (Exception e) {
            System.out.println("Error input finns ej!");
            destinationMenu();
        }

            //Konsolen skriver ut de tillgängliga tåg rutter.
            trainRoutes(startDest,endDest);

            //Kallar på metoden för att välja tider.
            travelTime();

            //Konsolen tar fram menyn för att välja biljetter.
            availableTickets();

    }

    /*
    Skriver ut de tågrutter som har båda stationerna so kunden har angett.
    Och om start stationen kommer före slutstationen i varje array.
     */

    public void trainRoutes(String start, String end) {
        System.out.println("----------------------------------------");
        System.out.println("          TILLGÄNGLIGA RUTTER           ");
        System.out.println("----------------------------------------");
            if (route1.contains(start) && route1.contains(end)) {
                if (route1.indexOf(start) < route1.indexOf(end)) {
                    System.out.println("LINJE 1: Malmö C - Hjärup - Lund C - Eslöv C - Hässleholm C - Kristianstad C");
                }
            }
            if (route2.contains(start) && route2.contains(end)) {
                if (route2.indexOf(start) < route2.indexOf(end)) {
                    System.out.println("LINJE 2: Malmö C - Lund C - Hässleholm C - Kristianstad C - Bromölla");
                }
            }
            if (route3.contains(start) && route3.contains(end)) {
                if (route3.indexOf(start) < route3.indexOf(end)) {
                    System.out.println("LINJE 3: Köpenhamn C - Hyllie - Malmö C - Triangeln");
                }
            }
            if (route4.contains(start) && route4.contains(end)) {
                if (route4.indexOf(start) < route4.indexOf(end)) {
                    System.out.println("LINJE 4: Köpenhamn C - Hyllie - Malmö C - Triangeln - " +
                            "Lund C - Hässleholm C - Kristianstad C");
                }
            }
            if (route5.contains(start) && route5.contains(end)) {
                if (route5.indexOf(start) < route5.indexOf(end)) {
                    System.out.println("LINJE 5: Lund C - Hjärup - Malmö C - Triangeln - Hyllie - " +
                            "Oxie station - Svedala  - Skurup - Svarte - Ystad");
                }
            }
        System.out.println("-----------------------------------------");
    }

    public void travelTime() {

        boolean run = true;
        while (run) {
            //Här får kunden välja en tid att åka från stationen och när han/hon vill komma fram.
            System.out.println("Vilken tid vill du åka från stationen?");
            System.out.println("--------------------------------------");
            System.out.print("Ange tid: ");

            float leaveTime = scan.nextFloat();

            /*
            Om givna tiden är mindre än 0 och högre än 23.59 då ges en Error,
            Och då får kunden försöka igen. Det är samma för avgångs tiden
            fast då får man error om givna tiden är mindre än tiden kunden gav
            då dem vill lämna stationen, och om givna tiden är högre än 23.59.
            */

            if (leaveTime < 0.00 || leaveTime > 23.59) {
                System.out.println("Error vänligen försök igen.");
                continue;
            }
            setLeaveTime(leaveTime);
            run = false;
        }

        run = true;
        while (run) {
            System.out.println("--------------------------------------");
            System.out.println("Vilken tid vill du senast komma fram?");
            System.out.println("--------------------------------------");
            System.out.print("Ange tid: ");
            float arrivalTime = scan.nextFloat();

            if (arrivalTime < leaveTime || arrivalTime > 23.59) {
                System.out.println("Error vänligen försök igen.");
                continue;
            }
            setArrivalTime(arrivalTime);
            run = false;
        }
    }

    //Meny där kunden kan köpa olika biljetter.
    public void availableTickets() {
        System.out.println("--------------");
        System.out.println("Välj biljetter");
        System.out.println("--------------");
        System.out.println("1.Barn\n -inom skåne 20kr\n -utanför skåne 30kr\n");
        System.out.println("2.Vuxen\n -inom skåne 40kr\n -utanför skåne 50kr\n");
        System.out.println("3.Pensionär\n -inom skåne 30kr\n -utanför skåne 40kr\n");
        System.out.println("4.Next");
        System.out.println("--------------");
        System.out.print("Ange val: ");

        try {

            /*
            När kunden har valt en biljett så kommer det läggas in i array listan och
            sedan kan kunden välja en till. Om kunden sedan inte vill köpa fler biljetter
            kan han/hon betala.
             */

            boolean run = true;
            while (run) {

                int choice = scan.nextInt();

                switch (choice) {

                    //Om kunden väjer att åka tåget utanför skåne så höjs priset på biljetterna.

                    //Biljett för barn.
                    case 1:
                        setTickets("Barn");
                        totalCost += 20;
                        if (endDest.equals("Köpenhamn C") || startDest.equals("Köpenhamn C")) {
                            totalCost += 30;
                        }
                        availableTickets();
                        break;

                    //Biljett för vuxen.
                    case 2:
                        setTickets("Vuxen");
                        totalCost += 40;
                        if (endDest.equals("Köpenhamn C") || startDest.equals("Köpenhamn C")) {
                            totalCost += 50;
                        }
                        availableTickets();
                        break;

                    //Biljett för pensionär.
                    case 3:
                        setTickets("Pensionär");
                        totalCost += 30;
                        if (endDest.equals("Köpenhamn C") || startDest.equals("Köpenhamn C")) {
                            totalCost += 40;
                        }
                        availableTickets();
                        break;

                    //Kallar på pay() metoden för att betala biljetten.
                    case 4:
                        run = false;
                        pay();
                        break;

                    //Om kundens input är något annat värde så ges en Error.
                    default:
                        System.out.println("Error" + choice + " Finns ej!");
                        availableTickets();
                }
            }
        } catch (Exception e) {
            DepartureMenu travel = new DepartureMenu();
            System.out.println("Error input finns ej!");
            travel.availableTickets();
        }
    }

    //Metod där kunden kan betala biljetten.
    public void pay() {
        try {
            System.out.println("----------------");
            System.out.println("Vill du betala?");
            System.out.println("Y eller N");
            System.out.println("----------------");
            System.out.print("Ange val: ");
            String input = scan.next();

            //Om kunden väljer att betala får han/hon mata in den tillfrågade summan.
            if (input.equals("Y") || input.equals("y")) {
                menu.addSaldo(totalCost);
                System.out.println("Transaktionen slutförd!");
                System.out.println("Ditt kvitto finns i 'Mina biljetter'");
                System.out.println("Tack för att du åker med Skånetrafiken.");
                //Här kommer kundens biljett att skapas.
                MyTicket ticket = new MyTicket();
                ticket.newTicket(getStartDest(), getEndDest(), getLeaveTime(), getArrivalTime(), totalCost);
                menu.startMenu();

                /*
                Om kunden väljer att inte betala så skickas de till huvud menyn
                och array listan med de valda biljetterna kommer att tömmas.
                 */

            } else if (input.equals("N") || input.equals("n")) {
                    System.out.println("Avbryter köp...");
                    System.out.println("Hej då, vi ses nästa gång");
                    tickets.clear();
                    menu.startMenu();
            } else {
                //Om kunden skriver fel värde ges en Error.
                System.out.println("Error" + input + " Finns ej!");
                pay();
            }
        } catch (Exception e) {
            DepartureMenu travel = new DepartureMenu();
            System.out.println("Error input finns ej!");
            travel.pay();
        }
    }
}
