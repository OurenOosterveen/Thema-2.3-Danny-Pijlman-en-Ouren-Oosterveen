package classifier;

/**
 * Created by ouren on 21-2-2016.
 */
import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TreeFileReader {
    private static final String OPTION_FILE = "./src/classifier/OptiesText.txt";
    private static final String TRAININGSET_FILE = "./src/classifier/TrainingSet.txt";

    private static BufferedReader TrainingSetReader;
    private static BufferedReader OptionsReader;

    private static ArrayList<String> categories = new ArrayList<>();
    private static ArrayList<String> options = new ArrayList<>();
    private static ArrayList<Node> optionList = new ArrayList<>();
    private static Node iroot = null;

    public static void main(String[] args) throws Exception {
        collectDataFromFile();
        buildTreeFromArray();
    }

    public TreeFileReader() {
    }

    public DecisionTree test() throws IOException {
        collectDataFromFile();
        return buildTreeFromArray();
    }

    public static void collectDataFromFile(){
        // Create a File instance
        File trainingSetFile = new File(TRAININGSET_FILE);
        File optionsFile = new File(OPTION_FILE);
        // Create a Scanner for the file

        try
        {
            TrainingSetReader = new BufferedReader(new FileReader(trainingSetFile));
            OptionsReader = new BufferedReader(new FileReader(optionsFile));
        }
        catch (Exception e)
        {
            System.out.println("Could not properly read files");
        }
    }

    public static DecisionTree buildTreeFromArray() throws IOException {


        String optionLine = (String) OptionsReader.readLine();
        int lineNumber = 1;
        Node root = new Node(optionLine);
        optionList.add(root);
        optionLine = (String) OptionsReader.readLine();
        while(optionLine != null){
            for(int i=0;i<(Math.pow(2,lineNumber));i++){
                Node node =new Node(optionLine);
                optionList.add(node);
            }
            optionLine = (String) OptionsReader.readLine();
            lineNumber ++;
        }


        String TrainingSetLine = TrainingSetReader.readLine();
        while(TrainingSetLine != null){

            TrainingSetLine = TrainingSetReader.readLine();
        }
        //(2*n)+1
        for (int i=0; i<Math.pow(2,lineNumber-1);i++){
            Node node = (Node)optionList.get(i);
            node.addChild("yes",(Node)optionList.get((2*i)+1));
            node.addChild("no",(Node)optionList.get((2*i)+2));
        }

        /*int group = 0;
        int[] catGroup = new int[]{30,24,30,24,20,10,68,30,20};
        String catLine = (String) TrainingSetReader.readLine();
        while(catLine != null){
            makeCat(catLine, catGroup[group]);
            group ++;
            catLine = (String) TrainingSetReader.readLine();
        }
        //(2*n)+1
        for (int i=0; i<Math.pow(2,lineNumber-1);i++){
            Node node = (Node)optionList.get(i);
            node.addChild("yes",(Node)optionList.get((2*i)+1));
            node.addChild("no",(Node)optionList.get((2*i)+2));
        }
        iroot = root;*/
        return new DecisionTree(iroot);
    }

    private static void makeTrainingSet(String cat, int aantal)
    {
        for (int i=0; i<aantal;i++){
            Node node =new Node(cat);
            optionList.add(node);
        }
    }
}