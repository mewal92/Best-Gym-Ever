import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class memberFiles extends member {
    public memberFiles() {

//Skapar listan members
        List<member> members = new ArrayList<>();

        UIManager.put("OptionPane.okButtonText", "Sök");
        String userInput = JOptionPane.showInputDialog(null, "Sök med för och efternamn eller personnummer(10 siffror) ",
                "Sök efter medlem", 3);

        //öppnar upp filereadern med try-with-resources och läser in filen
        try (BufferedReader reader = new BufferedReader(new FileReader("customers.txt"))) {
            String line1, line2;
            String member = " ";


            //splittar på första raden för att plocka ut namn och id
            while ((line1 = reader.readLine()) != null) {
                String[] splitname = line1.split(", ");
                String[] splitID = line1.trim().split(", ");
                line2 = reader.readLine();

                String name = "";
                String idNumber = "";
                String date = "";
                String activeMember = "";

                //konkatinerar de inlästa raderna till dom tomma strängarna som skapats
                name += splitname[splitname.length - 1];
                idNumber += splitID[0];
                date += line2.trim();

                //parsear datumet och gör en if sats för att se om membership är aktivt eller inte
                LocalDate tempDate = LocalDate.parse(date);
                LocalDate currentDate = LocalDate.now().minusYears(1);
                if (tempDate.isAfter(currentDate)) {
                    activeMember += "Medlemskapet är aktivt";
                }
                if (tempDate.isBefore(currentDate)) {
                    activeMember += "Medlemskapet har gått ut";
                }

                //sparar ner medlemmarna från filen till min lista
                members.add(new member(name, idNumber, tempDate, activeMember));


                //hanterar user input och söker efter likadana namn/personnummer i listan och skriver ut en sträng om den hittas
                if (name.equalsIgnoreCase(userInput.trim()) || idNumber.equals((userInput.trim()))) {
                    member += ("Namn: " + name + "\n Medlem sedan: " + date + "\n" + "Status: " + activeMember);

                    UIManager.put("OptionPane.okButtonText", "Ok");
                    JOptionPane.showMessageDialog(null, member);


                } else if (userInput.isBlank()) {
                    JOptionPane.showMessageDialog(null, "Sökningen måste innehålla namn eller personnr");
                    break;

                }
            }
         //hanterar exceptions från try med catches, och skriver felmeddelande
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
