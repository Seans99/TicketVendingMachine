import java.io.*;

public class MyTicket {

    public void viewTickets() {

        //Objekt till huvud meny klassen.
        MainMenu menu = new MainMenu();

        String line;

        try {

            //Söker filen "Ticket".
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Ticket"));

            //Skriver ut filens innehåll.
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            menu.startMenu();

        } catch (IOException e) {
            System.out.println("\nDet finns inga köpta biljetter ännu\n");
            menu.startMenu();
            e.printStackTrace();
        }
    }

    public void newTicket(String startDest, String endDest, double leaveTime, double arrivalTime, int totalCost) {

        try {

            //Skapar en fil med namnet "Ticket".
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Ticket"));

            //Skriver ut de valda tiderna med två decimaler.
            String formattedString1 = String.format("%.02f", leaveTime);
            String formattedString2 = String.format("%.02f", arrivalTime);

            //Skriver ut det man vill inuti filen man har skapat.
            bufferedWriter.write("\t\t---------------\n");
            bufferedWriter.write("\t\tSKÅNETRAFIKEN\n");
            bufferedWriter.write("\t\t---------------\n");
            bufferedWriter.write("\tDitt biljett:\n");
            bufferedWriter.write("\tStart station: " + startDest + "\n");
            bufferedWriter.write("\tSlut station: " + endDest + "\n");
            bufferedWriter.write("\tLämnar station kl " + formattedString1 + "\n");
            bufferedWriter.write(("\tKommer fram senast kl " + formattedString2 + "\n"));
            bufferedWriter.write("\tKöpta biljetter:\n");

            //Skriver ut alla köpta biljetter inuti array listan i DepartureMenu klassen.
            for (String ticket : DepartureMenu.getTickets()) {
                bufferedWriter.write("\t" + "-" + ticket + "\n");
            }

            //Skriver ut den totala kostnaden för resan.
            bufferedWriter.write("\tTotala summa: " + totalCost + " kr" + "\n");
            bufferedWriter.write("\t\t---------------");

            //Behövs för att kunna skriva ut grejer i filen.
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
