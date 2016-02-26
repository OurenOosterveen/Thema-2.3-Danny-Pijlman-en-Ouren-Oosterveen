package classifier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by ouren on 24-2-2016.
 */
public class QuestionModel
{
    private ArrayList<ActionListener> actionListenerList = new ArrayList<ActionListener>();
    private int questionCounter = 0;
    private String categorie;
    private Feature[] features;
    private Item item;
    private DecisionTree tree;

    public QuestionModel(Feature[] f, Item i, DecisionTree t)
    {
        features = f;
        item = i;
        tree = t;
    }

    public void addActionListener(ActionListener al)
    {
        actionListenerList.add(al);
    }

    public void removeActionListener( ActionListener al){
        if ( actionListenerList.contains( al ) )
            actionListenerList.remove( al );
    }

    private void processEvent(ActionEvent e){
        for( ActionListener l : actionListenerList)
            l.actionPerformed( e );
    }

    public void answerYes()
    {
        nextQuestion("yes");
    }

    public void answerNo()
    {
        nextQuestion("no");
    }

    private void nextQuestion(String s)
    {
        if (!(questionCounter >= features.length))
        {
            Feature f = features[questionCounter];
            f.setValue(s);
            item.setFeatureValue(features[questionCounter].getName(),s);
            categorie = tree.assignCategory(item);
            questionCounter++;
        }
        else
        {

        }
        processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
    }

    public void firstQuestion()
    {
        processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
    }

    public int getCounter()
    {
        return questionCounter;
    }

    public String getCategorie()
    {
        return categorie;
    }
}
