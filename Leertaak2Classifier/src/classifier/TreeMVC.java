package classifier;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ouren on 24-2-2016.
 */
public class TreeMVC extends JApplet{
    DecisionTree tree;
    Feature[] features;
    Item item;

    QuestionsController controller;
    QuestionModel model;
    QuestionView view;

    public void init()
    {
        resize(250, 100);

        buildTree();

        createFeatures();

        model = new QuestionModel(features, item, tree);

        controller = new QuestionsController(model);
        controller.setBackground(Color.white);
        getContentPane().add(controller, BorderLayout.SOUTH);

        view = new QuestionView(features);
        view.setBackground(Color.white);
        getContentPane().add(view, BorderLayout.CENTER);

        model.addActionListener(view);

        model.firstQuestion();
    }

    private void buildTree(){
        Node root = new Node("AC");

        Node n1=new Node("ABS");
        Node n2=new Node("ABS");
        root.addChild("yes",n1);
        root.addChild("no",n2);

        Node sn1 = new Node("Radio");
        Node sn2 = new Node("Radio");
        Node sn3 = new Node("Radio");
        Node sn4 = new Node("Radio");
        n1.addChild("yes", sn1);
        n1.addChild("no", sn2);
        n2.addChild("yes", sn3);
        n2.addChild("no", sn4);

        // leaves
        Node l1 = new Node("high");
        Node l2 = new Node("above average");
        Node l3 = new Node("below average");
        Node l4 = new Node("low");

        sn1.addChild("yes",l1);
        sn1.addChild("no",l2);

        sn2.addChild("yes",l2);
        sn2.addChild("no",l3);

        sn3.addChild("yes",l2);
        sn3.addChild("no",l3);

        sn4.addChild("yes",l3);
        sn4.addChild("no",l4);

        tree = new DecisionTree(root);
    }

    private void createFeatures()
    {
        FeatureType yn = new FeatureType("YesNo"
                ,new String[]{"yes","no"});

        features = new Feature[]
                {
                        new Feature("AC","yes",yn),
                        new Feature("ABS","yes",yn),
                        new Feature("Radio","yes",yn)
                };

        item = new Item("car",features);
    }
}
