import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MhdApp {
    public void findMhd(String number) throws IOException {
        Csv field = new Csv();
        String[] positions = field.suradnice(number);
        String mapposition1 = positions[0];
        String mapposition2 = positions[1];
        float num = Float.parseFloat(mapposition1);
        float num2 = Float.parseFloat(mapposition2);

        float positionappx= (float) (((49.02185 - num) / 7.2) * 100000);
        float positionappy= (float)  (((num2-21.19944) / 12.5 )* 100000);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(803, 646);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(803, 646));
        frame.add(layeredPane);

        JLabel background = new JLabel();
        background.setIcon(new ImageIcon("imagemap/1.jpg"));
        background.setBounds(0, 0, 804, 646);
        JLabel foreground = new JLabel();
        foreground.setIcon(new ImageIcon("imagemap/2.jpg"));
        foreground.setBounds((int) positionappx, (int) positionappy, 15, 15);

        layeredPane.add(background, new Integer(0));
        layeredPane.add(foreground, new Integer(1));
        frame.setVisible(true);


    }
}
