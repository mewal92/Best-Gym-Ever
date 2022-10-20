import javax.swing.*;
import java.text.ParseException;
import java.time.LocalDate;

public class member {
    private String name;
    private String idNumber;
    public LocalDate date;
    private ImageIcon Icon;
    String activeMember;

// konstruktor
    public member(String name, String idNumber, LocalDate date, String activeMember) throws ParseException {
        this.name = name;
        this.idNumber = idNumber;
        this.date = date;
        this.activeMember = activeMember;
    }
//skapar upp en member med tomma strängar för att kunna läsa in/spara text från fil till member
    public member() {
        name = " ";
        idNumber = " ";
        date = LocalDate.now();
        activeMember = "";
    }


public String getActiveMember() { return activeMember;}

    public String getName() {
        return name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public LocalDate getDate() {return date;}


    //ikon till huvudprogram
    public static ImageIcon getIcon() {
        return new ImageIcon("bge.png");

    }
}
