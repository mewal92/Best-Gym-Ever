import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class newVisitor {
        newVisitor() {

            while (true) {
                UIManager.put("OptionPane.okButtonText", "Nästa");
                String namnInput = JOptionPane.showInputDialog(null, "Kundens namn och efternamn: ",
                        "Registrera ditt besök", 3);

                //hanterar dålig user input
                if (namnInput.isEmpty()) {
                    UIManager.put("OptionPane.okButtonText", "Gå tillbaka");
                    JOptionPane.showMessageDialog(null, "Du måste ange ett namn!",
                            "Något gick fel", 2);


                } else {
                    UIManager.put("OptionPane.okButtonText", "Registrera besök");
                    String personNrInput = JOptionPane.showInputDialog(null,
                            "Kundens personnummer: ",
                            "Registrera besök", 3);


                    //Skapar en lista för att spara ner personers gymbesök
                    List<String> besök = new ArrayList<>();
                    //sparar ner user input i listan som namn/personnr och dagens datum
                    besök.add(personNrInput + ", " +namnInput + "\nSenaste gymbesök: " + LocalDate.now());

                    //skapar en ny fil med hjälp av printwriter och filewriter för att skriva i, append för inte skriva över
                    //gamla besök
                    try {
                        String filename = "customersBesök.txt";
                        PrintWriter registrera = new PrintWriter(new FileWriter(filename, true));

                        registrera.println(besök + "\n");
                        registrera.close();

                        //Hanterar exceptions med felmeddelanden
                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, "Filen hittades inte.");


                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Något gick fel");
                        throw new RuntimeException(e);


                    }UIManager.put("OptionPane.okButtonText", "Stäng");
                    JOptionPane.showMessageDialog(null, "Tack, ditt besök är registrerat!");
                    break;
                }
            }
        }

    }
