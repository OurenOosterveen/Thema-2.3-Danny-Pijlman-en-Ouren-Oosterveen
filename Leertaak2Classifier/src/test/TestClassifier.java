package test;
import classifier.*;
import junit.framework.TestCase;



public class TestClassifier extends TestCase {

	public TestClassifier(String arg0) {
		super(arg0);
	}

    private DecisionTree buildTree(){
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
		
		return new DecisionTree(root);
    }
	public void testCategory(){
		
		DecisionTree dt = buildTree();

		FeatureType yn = new FeatureType("YesNo"
						,new String[]{"yes","no"});

		Feature[] features = new Feature[]
		{
				new Feature("AC","yes",yn),
		  		new Feature("ABS","yes",yn),
				new Feature("Radio","yes",yn)
		};
		
		Item item = new Item("car",features);
		
		String category = dt.assignCategory(item);
		assertEquals("high",category);
		
		
		item.setFeatureValue("AC","no");
		category = dt.assignCategory(item);
		assertEquals("above average",category);

		item.setFeatureValue("Radio", "no");
		category = dt.assignCategory(item);
		assertEquals("below average", category);

		item.setFeatureValue("ABS","no");
		category = dt.assignCategory(item);
		assertEquals("low",category);
	}
}
