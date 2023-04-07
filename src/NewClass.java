import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class NewClass {
    public static void main(String[] args) throws IOException {
        String[] suradnica = csv.suradnice("4");
        String str = suradnica[0];
        String str2 = suradnica[1];
        float num = Float.parseFloat(str);
        float num2 = Float.parseFloat(str2);

        float y= (float) (((49.02185 - num) / 7.2) * 100000);
        float x= (float)  (((num2-21.19944) / 12.5 )* 100000);
        System.out.println(x);
        System.out.println(y);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(803, 646);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(803, 646));
        frame.add(layeredPane);

        JLabel background = new JLabel();
        background.setIcon(new ImageIcon("C:\\Users\\MIchalPC\\Desktop\\1.jpg"));
        background.setBounds(0, 0, 804, 646);
        JLabel foreground = new JLabel();
        foreground.setIcon(new ImageIcon("C:\\Users\\MIchalPC\\Desktop\\2.jpg"));
        foreground.setBounds((int) x, (int) y, 15, 15);
        layeredPane.add(background, new Integer(0));
        layeredPane.add(foreground, new Integer(1));
        frame.setVisible(true);


    }
}
