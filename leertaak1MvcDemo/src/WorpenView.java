import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ouren on 12-2-2016.
 */
public class WorpenView extends JPanel implements ActionListener {
    private JTextPane aantalWorpen = new JTextPane();
    DobbelsteenModel d;

    public WorpenView()
    {
        this.setLayout(new FlowLayout());
        this.add(aantalWorpen);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        d = (DobbelsteenModel) e.getSource();
        StringBuilder s = new StringBuilder();
        s.append("Aantal worpen: " + d.worpen + "\n");
        s.append("Aantal enen: " + d.ones + "\n");
        s.append("Aantal tweeën: " + d.twos + "\n");
        s.append("Aantal drieën: " + d.threes + "\n");
        s.append("Aantal vieren: " + d.fours + "\n");
        s.append("Aantal vijven: " + d.fives + "\n");
        s.append("Aantal zessen: " + d.sixes + "\n");

        aantalWorpen.setText(s.toString());
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(150,100);
    }
}