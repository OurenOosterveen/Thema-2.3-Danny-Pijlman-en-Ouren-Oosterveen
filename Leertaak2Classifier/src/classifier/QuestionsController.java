package classifier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ouren on 24-2-2016.
 */
public class QuestionsController extends JPanel implements ActionListener
{
    QuestionModel questions;
    private JButton yes = new JButton("Yes");
    private JButton no = new JButton("No");

    public QuestionsController(QuestionModel q)
    {
        questions = q;
        this.add(yes);
        yes.addActionListener(this);
        this.add(no);
        no.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == yes)
        {
            questions.answerYes();
        }
        if (e.getSource() == no)
        {
            questions.answerNo();
        }
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(50,50);
    }
}
