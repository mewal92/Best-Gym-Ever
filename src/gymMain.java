import javax.swing.*;

public class gymMain {
    public gymMain() {

        String[] options = {"Sök efter medlem", "Registrera besök", "Avbryt"};
        int selection = JOptionPane.showOptionDialog(null, "",
                "Best Gym Ever", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                member.getIcon(), options, 0);

//kallar på klassernas metod beroende på vad man väljer för option
        switch (selection) {
            case 0:
                new memberFiles();
                break;
            case 1:
                new newVisitor();
                break;
            case 2:
                System.exit(0);
                break;
        }
    }
//main
    public static void main(String[] args) {
        new gymMain();
    }
}