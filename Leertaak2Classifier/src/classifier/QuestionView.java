package classifier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ouren on 24-2-2016.
 */
public class QuestionView extends JPanel implements ActionListener
{
    private JTextPane question = new JTextPane();
    private int questionCounter;
    QuestionModel model;
    Feature[] features;

    public QuestionView(Feature[] f)
    {
        features = f;
        this.setLayout(new FlowLayout());
        this.add(question);
        question.setEditable(false);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (!(questionCounter >= features.length - 1))
        {
            model = (QuestionModel) e.getSource();
            questionCounter = model.getCounter();
            question.setText("Wilt u een " + features[questionCounter].getName());
        }
        else
        {
            question.setText("Uw auto kwaliteit is " + model.getCategorie());
        }
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(50,10);
    }
}
