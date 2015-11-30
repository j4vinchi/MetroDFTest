package com.roostera.test.metrodftest;

import java.util.ArrayList;
public class FindPaths {
	
	//Numero de estaciones
	private Node node1;
	private Node node2;
	private Node node3;
	private Node node4;
	private Node node5;
	private Node node6;
	private Node node7;
	private Node node8;
	private Node node9;
	private Node node10;
	private Node node11;
	private Node node12;
	private Node node13;
	private Node node14;
	private Node node15;
	private Node node16;
	private Node node17;
	private Node node18;
	private Node node19;
	private Node node20;
	private Node node21;
	private Node node22;
	private Node node23;
	private Node node24;
	private Node node25;
	private Node node26;
	private Node node27;
	private Node node28;
	private Node node29;
	private Node node30;
	private Node node31;
	private Node node32;
	private Node node33;
	private Node node34;
	private Node node35;
	private Node node36;
	private Node node37;
	private Node node38;
	private Node node39;
	private Node node40;
	private Node node41;
	private Node node42;
	private Node node43;
	private Node node44;
	private Node node45;
	private Node node46;
	private Node node47;
	private Node node48;
	private Node node49;
	private Node node50;
	private Node node51;
	private Node node52;
	private Node node53;
	private Node node54;
	private Node node55;
	private Node node56;
	private Node node57;
	private Node node58;
	private Node node59;
	private Node node60;
	private Node node61;
	private Node node62;
	private Node node63;
	private Node node64;
	private Node node65;
	private Node node66;
	private Node node67;
	private Node node68;
	private Node node69;
	private Node node70;
	private Node node71;
	private Node node72;
	private Node node73;
	private Node node74;
	private Node node75;
	private Node node76;
	private Node node77;
	private Node node78;
	private Node node79;
	private Node node80;
	private Node node81;
	private Node node82;
	private Node node83;
	private Node node84;
	private Node node85;
	private Node node86;
	private Node node87;
	private Node node88;
	private Node node89;
	private Node node90;
	private Node node91;
	private Node node92;
	private Node node93;
	private Node node94;
	private Node node95;
	private Node node96;
	private Node node97;
	private Node node98;
	private Node node99;
	private Node node100;
	private Node node101;
	private Node node102;
	private Node node103;
	private Node node104;
	private Node node105;
	private Node node106;
	private Node node107;
	private Node node108;
	private Node node109;
	private Node node110;
	private Node node111;
	private Node node112;
	private Node node113;
	private Node node114;
	private Node node115;
	private Node node116;
	private Node node117;
	private Node node118;
	private Node node119;
	private Node node120;
	private Node node121;
	private Node node122;
	private Node node123;
	private Node node124;
	private Node node125;
	private Node node126;
	private Node node127;
	private Node node128;
	private Node node129;
	private Node node130;
	private Node node131;
	private Node node132;
	private Node node133;
	private Node node134;
	private Node node135;
	private Node node136;
	private Node node137;
	private Node node138;
	private Node node139;
	private Node node140;
	private Node node141;
	private Node node142;
	private Node node143;
	private Node node144;
	private Node node145;
	private Node node146;
	private Node node147;
	private Node node148;
	private Node node149;
	private Node node150;
	private Node node151;
	private Node node152;
	private Node node153;
	private Node node154;
	private Node node155;
	private Node node156;
	private Node node157;
	private Node node158;
	private Node node159;
	private Node node160;
	private Node node161;
	private Node node162;
	
	
	private int size=1000;
	private ArrayList<Path>pathList;
	private ArrayList<Link>linkList;
	private ArrayList<Node>nodeList;
	private ArrayList<Path>shortestPath;
	private StringBuilder words;
	private ArrayList<Node> used;
	//private ArrayList<PathStep> steps;
	Node fromNode;
	public FindPaths(int from,int to){			
		pathList=new ArrayList<>();
		linkList=new ArrayList<>();
		shortestPath=new ArrayList<>();
		nodeList=new ArrayList<>();
		words=new StringBuilder();
		used=new ArrayList<>();	
		//steps=new ArrayList<>();	
		
		setting();		
	    fromNode=getNode(from);
        findPath(getNode(from),getNode(to));

		System.out.println(pathList.size() + " paths have been found!") ;
		words.append("\n**********************************\n"+pathList.size() + " paths have been found!\n**********************************\n");
		shortestPath();
	}
	
	/*
	 * Metodo para personalizar las instrucciones
	 * de la ruta acorde al Path obtenido
	 */
	public void trainOrder(Path path){
		String myTrain="";
		for (int i=0;i<path.getPath().size();i++){
			if (myTrain.equals("")){
				System.out.println("Take "+getLink(Integer.valueOf(path.getPath().get(i))).getTrain()+" Line a"
					+ "t Station "+getLink(Integer.valueOf(path.getPath().get(i))).getFrom().getNodeID());
				myTrain=getLink(Integer.valueOf(path.getPath().get(i))).getTrain();
				words.append("Take "+getLink(Integer.valueOf(path.getPath().get(i))).getTrain()+" Line a"
					+ "t Station "+getLink(Integer.valueOf(path.getPath().get(i))).getFrom().getNodeID()+"\n");
			} else if (!myTrain.equals(getLink(Integer.valueOf(path.getPath().get(i))).getTrain())){
				System.out.println("Change the train at Station "+getLink(Integer.valueOf(path.getPath().get(i))).getFrom().getNodeID()
						+" to "+getLink(Integer.valueOf(path.getPath().get(i))).getTrain()+" Line.");
				myTrain=getLink(Integer.valueOf(path.getPath().get(i))).getTrain();
				words.append("Change the train at Station "+getLink(Integer.valueOf(path.getPath().get(i))).getFrom().getNodeID()
						+" to "+getLink(Integer.valueOf(path.getPath().get(i))).getTrain()+" Line.\n");
			} 
			if (i==path.getPath().size()-1){
				words.append("Get out at Station "+getLink(Integer.valueOf(path.getPath().get(i))).getTo().getNodeID()+"\n");
				System.out.println("Get out at Station "+getLink(Integer.valueOf(path.getPath().get(i))).getTo().getNodeID()+"\n");
			}			
		}
	}
	public Node getNode(int id){
		return nodeList.get(id-1);
	}
	public Link getLink(int id){
		return linkList.get(id-1);
	}
	
	public void shortestPath(){
		Path result;
        words.append("\nThe shortest path in node-count:\n----------------------------------\n");
		for (int i=0;i<pathList.size();i++){			
			result=pathList.get(i);
			if (result.getPath().size()<size){
				try {shortestPath.clear();}
				catch (java.lang.NullPointerException e){}
				size=result.getPath().size();
				shortestPath.add(result);
			} else if ((result.getPath().size()==size)){
				shortestPath.add(pathList.get(i));
			} else {
			}				
		}
		
		System.out.println("the least nobes path:");
		words.append(shortestPath.get(0).getPath().size()+" nodes are needed.\n----------------------------------\n");
		for (int i=0;i<shortestPath.size();i++){
			System.out.println("Path "+(i+1)+":");
			words.append("Path "+(i+1)+":\n");
			for (int j=0;j<shortestPath.get(i).getPath().size();j++){
				System.out.print(" "+shortestPath.get(i).getPath().get(j));
			}
			trainOrder(shortestPath.get(i));
		}
	}
	
	public void setting(){
		
		//NODO == ESTACIÓN
		//NUMERO DE ESTACIONES
		node1=new Node(1);
		node2=new Node(2);
		node3=new Node(3);
		node4=new Node(4);
		node5=new Node(5);
		node6=new Node(6);
		node7=new Node(7);
		node8=new Node(8);
		node9=new Node(9);
		node10=new Node(10);
		node11=new Node(11);
		node12=new Node(12);
		node13=new Node(13);
		node14=new Node(14);
		node15=new Node(15);
		node16=new Node(16);
		node17=new Node(17);
		node18=new Node(18);
		node19=new Node(19);
		node20=new Node(20);
		node21=new Node(21);
		node22=new Node(22);
		node23=new Node(23);
		node24=new Node(24);
		node25=new Node(25);
		node26=new Node(26);
		node27=new Node(27);
		node28=new Node(28);
		node29=new Node(29);
		node30=new Node(30);
		node31=new Node(31);
		node32=new Node(32);
		node33=new Node(33);
		node34=new Node(34);
		node35=new Node(35);
		node36=new Node(36);
		node37=new Node(37);
		node38=new Node(38);
		node39=new Node(39);
		node40=new Node(40);
		node41=new Node(41);
		node42=new Node(42);
		node43=new Node(43);
		node44=new Node(44);
		node45=new Node(45);
		node46=new Node(46);
		node47=new Node(47);
		node48=new Node(48);
		node49=new Node(49);
		node50=new Node(50);
		node51=new Node(51);
		node52=new Node(52);
		node53=new Node(53);
		node54=new Node(54);
		node55=new Node(55);
		node56=new Node(56);
		node57=new Node(57);
		node58=new Node(58);
		node59=new Node(59);
		node60=new Node(60);
		node61=new Node(61);
		node62=new Node(62);
		node63=new Node(63);
		node64=new Node(64);
		node65=new Node(65);
		node66=new Node(66);
		node67=new Node(67);
		node68=new Node(68);
		node69=new Node(69);
		node70=new Node(70);
		node71=new Node(71);
		node72=new Node(72);
		node73=new Node(73);
		node74=new Node(74);
		node75=new Node(75);
		node76=new Node(76);
		node77=new Node(77);
		node78=new Node(78);
		node79=new Node(79);
		node80=new Node(80);
		node81=new Node(81);
		node82=new Node(82);
		node83=new Node(83);
		node84=new Node(84);
		node85=new Node(85);
		node86=new Node(86);
		node87=new Node(87);
		node88=new Node(88);
		node89=new Node(89);
		node90=new Node(90);
		node91=new Node(91);
		node92=new Node(92);
		node93=new Node(93);
		node94=new Node(94);
		node95=new Node(95);
		node96=new Node(96);
		node97=new Node(97);
		node98=new Node(98);
		node99=new Node(99);
		node100=new Node(100);
		node101=new Node(101);
		node102=new Node(102);
		node103=new Node(103);
		node104=new Node(104);
		node105=new Node(105);
		node106=new Node(106);
		node107=new Node(107);
		node108=new Node(108);
		node109=new Node(109);
		node110=new Node(110);
		node111=new Node(111);
		node112=new Node(112);
		node113=new Node(113);
		node114=new Node(114);
		node115=new Node(115);
		node116=new Node(116);
		node117=new Node(117);
		node118=new Node(118);
		node119=new Node(119);
		node120=new Node(120);
		node121=new Node(121);
		node122=new Node(122);
		node123=new Node(123);
		node124=new Node(124);
		node125=new Node(125);
		node126=new Node(126);
		node127=new Node(127);
		node128=new Node(128);
		node129=new Node(129);
		node130=new Node(130);
		node131=new Node(131);
		node132=new Node(132);
		node133=new Node(133);
		node134=new Node(134);
		node135=new Node(135);
		node136=new Node(136);
		node137=new Node(137);
		node138=new Node(138);
		node139=new Node(139);
		node140=new Node(140);
		node141=new Node(141);
		node142=new Node(142);
		node143=new Node(143);
		node144=new Node(144);
		node145=new Node(145);
		node146=new Node(146);
		node147=new Node(147);
		node148=new Node(148);
		node149=new Node(149);
		node150=new Node(150);
		node151=new Node(151);
		node152=new Node(152);
		node153=new Node(153);
		node154=new Node(154);
		node155=new Node(155);
		node156=new Node(156);
		node157=new Node(157);
		node158=new Node(158);
		node159=new Node(159);
		node160=new Node(160);
		node161=new Node(161);
		node162=new Node(162);
		
		
		
		
		
		
		nodeList.add(node1);
		nodeList.add(node2);
		nodeList.add(node3);
		nodeList.add(node4);		
		nodeList.add(node5);
		nodeList.add(node6);
		nodeList.add(node7);
		nodeList.add(node8);
		nodeList.add(node9);
		nodeList.add(node10);
		nodeList.add(node11);
		nodeList.add(node12);
		nodeList.add(node13);
		nodeList.add(node14);
		nodeList.add(node15);
		nodeList.add(node16);
		nodeList.add(node17);
		nodeList.add(node18);	
		nodeList.add(node19);
		nodeList.add(node20);
		nodeList.add(node21);
		nodeList.add(node22);
		nodeList.add(node23);		
		nodeList.add(node24);
		nodeList.add(node25);
		nodeList.add(node26);		
		nodeList.add(node27);		
		nodeList.add(node28);		
		nodeList.add(node29);
		nodeList.add(node30);
		nodeList.add(node31);
		nodeList.add(node32);
		nodeList.add(node33);
		nodeList.add(node34);
		nodeList.add(node35);
		nodeList.add(node36);
		nodeList.add(node37);
		nodeList.add(node38);
		
		nodeList.add(node39);
		nodeList.add(node40);
		nodeList.add(node41);
		nodeList.add(node42);		
		nodeList.add(node43);
		nodeList.add(node44);
		nodeList.add(node45);
		nodeList.add(node46);
		nodeList.add(node47);
		nodeList.add(node48);
		nodeList.add(node49);
		nodeList.add(node50);
		nodeList.add(node51);
		nodeList.add(node52);
		nodeList.add(node53);
		nodeList.add(node54);
		nodeList.add(node55);
		nodeList.add(node56);	
		nodeList.add(node57);
		nodeList.add(node58);
		nodeList.add(node59);
		nodeList.add(node60);
		nodeList.add(node61);		
		nodeList.add(node62);
		nodeList.add(node63);
		nodeList.add(node64);		
		nodeList.add(node65);		
		nodeList.add(node66);		
		nodeList.add(node67);
		nodeList.add(node68);
		nodeList.add(node69);
		nodeList.add(node70);
		nodeList.add(node71);
		nodeList.add(node72);
		nodeList.add(node73);
		nodeList.add(node74);
		nodeList.add(node75);
		nodeList.add(node76);
	
		nodeList.add(node77);
		nodeList.add(node78);
		nodeList.add(node79);
		nodeList.add(node80);		
		nodeList.add(node81);
		nodeList.add(node82);
		nodeList.add(node83);
		nodeList.add(node84);
		nodeList.add(node85);
		nodeList.add(node86);
		nodeList.add(node87);
		nodeList.add(node88);
		nodeList.add(node89);
		nodeList.add(node90);
		nodeList.add(node91);
		nodeList.add(node92);
		nodeList.add(node93);
		nodeList.add(node94);	
		nodeList.add(node95);
		nodeList.add(node96);
		nodeList.add(node97);
		nodeList.add(node98);
		nodeList.add(node99);		
		nodeList.add(node100);
		nodeList.add(node101);
		nodeList.add(node102);		
		nodeList.add(node103);		
		nodeList.add(node104);		
		nodeList.add(node105);
		nodeList.add(node106);
		nodeList.add(node107);
		nodeList.add(node108);
		nodeList.add(node109);
		nodeList.add(node110);
		nodeList.add(node111);
		nodeList.add(node112);
		nodeList.add(node113);
		nodeList.add(node114);
		
		nodeList.add(node115);
		nodeList.add(node116);
		nodeList.add(node117);
		nodeList.add(node118);
		nodeList.add(node119);
		nodeList.add(node120);
		nodeList.add(node121);
		nodeList.add(node122);
		nodeList.add(node123);
		nodeList.add(node124);
		nodeList.add(node125);	
		nodeList.add(node126);
		nodeList.add(node127);
		nodeList.add(node128);
		nodeList.add(node129);
		nodeList.add(node130);		
		nodeList.add(node131);
		nodeList.add(node132);
		nodeList.add(node133);		
		nodeList.add(node134);		
		nodeList.add(node135);		
		nodeList.add(node136);
		nodeList.add(node137);
		nodeList.add(node138);
		nodeList.add(node139);
		nodeList.add(node140);
		nodeList.add(node141);
		nodeList.add(node142);
		nodeList.add(node143);
		nodeList.add(node144);
		nodeList.add(node145);
		
		nodeList.add(node146);
		nodeList.add(node147);
		nodeList.add(node148);
		nodeList.add(node149);
		nodeList.add(node150);
		nodeList.add(node151);
		nodeList.add(node152);
		nodeList.add(node153);
		nodeList.add(node154);
		nodeList.add(node155);
		nodeList.add(node156);	
		nodeList.add(node157);
		nodeList.add(node158);
		nodeList.add(node159);
		nodeList.add(node160);
		nodeList.add(node161);		
		nodeList.add(node162);
		
		
		//ddd={2,3};
		///////  A line links //////
		
		//LINKS DE LA LINEA 1 OBSERVATORIO A PANTITLAN
		//38-LINKS
		Link link1 = new Link(1,node1,node2,"L1");
		Link link2 = new Link(2,node2,node1,"L1");
		Link link3 = new Link(3,node2,node3,"L1");
		Link link4 = new Link(4,node3,node2,"L1");
		Link link5 = new Link(5,node3,node4,"L1");
		Link link6 = new Link(6,node4,node3,"L1");
		Link link7 = new Link(7,node4,node5,"L1");
		Link link8 = new Link(8,node5,node4,"L1");
		Link link9 = new Link(9,node5,node6,"L1");
		Link link10 = new Link(10,node6,node5,"L1");
		Link link11 = new Link(11,node6,node7,"L1");
		Link link12 = new Link(12,node7,node6,"L1");
		Link link13 = new Link(13,node7,node8,"L1");
		Link link14 = new Link(14,node8,node7,"L1");
		Link link15 = new Link(15,node8,node9,"L1");
		Link link16 = new Link(16,node9,node8,"L1");
		Link link17 = new Link(17,node9,node10,"L1");
		Link link18 = new Link(18,node10,node9,"L1");
		Link link19 = new Link(19,node10,node11,"L1");
		Link link20 = new Link(20,node11,node10,"L1");
		Link link21 = new Link(21,node11,node12,"L1");
		Link link22 = new Link(22,node12,node11,"L1");
		Link link23 = new Link(23,node12,node13,"L1");
		Link link24 = new Link(24,node13,node12,"L1");
		Link link25 = new Link(25,node13,node14,"L1");
		Link link26 = new Link(26,node14,node13,"L1");
		Link link27 = new Link(27,node14,node15,"L1");
		Link link28 = new Link(28,node15,node14,"L1");
		Link link29 = new Link(29,node15,node16,"L1");
		Link link30 = new Link(30,node16,node15,"L1");
		Link link31 = new Link(31,node16,node17,"L1");
		Link link32 = new Link(32,node17,node16,"L1");
		Link link33 = new Link(33,node17,node18,"L1");
		Link link34 = new Link(34,node18,node17,"L1");
		Link link35 = new Link(35,node18,node19,"L1");
		Link link36 = new Link(36,node19,node18,"L1");
		Link link37 = new Link(37,node19,node20,"L1");
		Link link38 = new Link(38,node20,node19,"L1");
		
		
		
		
		////// Line C /////
		
		//LINEA 2 CUATRO CAMINOS A TASQUEÑA
		//24 LINKS  39-84
		Link link39=new Link(39,node21,node22,"L2");
		Link link40=new Link(40,node22,node21,"L2");
		Link link41=new Link(41,node22,node23,"L2");
		Link link42=new Link(42,node23,node22,"L2");
		Link link43=new Link(43,node23,node24,"L2");
		Link link44=new Link(44,node24,node23,"L2");
		Link link45=new Link(45,node24,node25,"L2");
		Link link46=new Link(46,node25,node24,"L2");
		Link link47=new Link(47,node25,node26,"L2");
		Link link48=new Link(48,node26,node25,"L2");
		Link link49=new Link(49,node26,node27,"L2");
		Link link50=new Link(50,node27,node26,"L2");
		Link link51=new Link(51,node27,node28,"L2");
		Link link52=new Link(52,node28,node27,"L2");
		Link link53=new Link(53,node28,node29,"L2");
		Link link54=new Link(54,node29,node28,"L2");
		Link link55=new Link(55,node29,node30,"L2");
		Link link56=new Link(56,node30,node29,"L2");
		Link link57=new Link(57,node30,node31,"L2");
		Link link58=new Link(58,node31,node30,"L2");
		Link link59=new Link(59,node31,node32,"L2");
		Link link60=new Link(60,node32,node31,"L2");
		Link link61=new Link(61,node32,node33,"L2");
		Link link62=new Link(62,node33,node32,"L2");
		Link link63=new Link(63,node33,node34,"L2");
		Link link64=new Link(64,node34,node33,"L2");
		Link link65=new Link(65,node34,node35,"L2");
		Link link66=new Link(66,node35,node34,"L2");
		Link link67=new Link(67,node35,node36,"L2");
		Link link68=new Link(68,node36,node35,"L2");
		Link link69=new Link(69,node36,node37,"L2");
		Link link70=new Link(70,node37,node36,"L2");
		Link link71=new Link(71,node37,node38,"L2");
		Link link72=new Link(72,node38,node37,"L2");
		Link link73=new Link(73,node38,node39,"L2");
		Link link74=new Link(74,node39,node38,"L2");
		Link link75=new Link(75,node39,node40,"L2");
		Link link76=new Link(76,node40,node39,"L2");
		Link link77=new Link(77,node40,node41,"L2");
		Link link78=new Link(78,node41,node40,"L2");
		Link link79=new Link(79,node41,node42,"L2");
		Link link80=new Link(80,node42,node41,"L2");
		
		
		
		
		/////// Line B  ///////
		Link link33=new Link(33,node1,node2,"B");
		Link link34=new Link(34,node2,node1,"B");
		Link link35=new Link(35,node2,node13,"B");
		Link link36=new Link(36,node13,node2,"B");
		Link link37=new Link(37,node13,node14,"B");
		Link link38=new Link(38,node14,node13,"B");
		Link link39=new Link(39,node14,node11,"B");
		Link link40=new Link(40,node11,node14,"B");
		Link link41=new Link(41,node11,node12,"B");
		Link link42=new Link(42,node12,node11,"B");
		
		////// Line D ////
		Link link43=new Link(43,node30,node36,"D");
		Link link44=new Link(44,node36,node30,"D");
		Link link45=new Link(45,node36,node11,"D");
		Link link46=new Link(46,node11,node36,"D");
		Link link47=new Link(47,node11,node33,"D");
		Link link48=new Link(48,node33,node11,"D");
		Link link49=new Link(49,node33,node34,"D");
		Link link50=new Link(50,node34,node33,"D");
		Link link51=new Link(51,node34,node35,"D");
		Link link52=new Link(52,node35,node34,"D");
		Link link53=new Link(53,node35,node37,"D");
		Link link54=new Link(54,node37,node35,"D");
		Link link55=new Link(55,node37,node17,"D");
		Link link56=new Link(56,node17,node37,"D");
		Link link57=new Link(57,node17,node31,"D");
		Link link58=new Link(58,node31,node17,"D");
		Link link59=new Link(59,node31,node38,"D");
		Link link60=new Link(60,node38,node31,"D");
		Link link61=new Link(61,node38,node23,"D");
		Link link62=new Link(62,node23,node38,"D");
		
		///// Line E
		Link link63=new Link(63,node12,node11,"E");
		Link link64=new Link(64,node11,node12,"E");
		Link link65=new Link(65,node11,node27,"E");
		Link link66=new Link(66,node27,node11,"E");
		Link link67=new Link(67,node27,node26,"E");
		Link link68=new Link(68,node26,node27,"E");
		Link link69=new Link(69,node26,node25,"E");
		Link link70=new Link(70,node25,node26,"E");
		Link link71=new Link(71,node25,node24,"E");
		Link link72=new Link(72,node24,node25,"E");
		Link link73=new Link(73,node24,node15,"E");
		Link link74=new Link(74,node15,node24,"E");		
		Link link75=new Link(75,node15,node21,"E");
		Link link76=new Link(76,node21,node15,"E");
		Link link77=new Link(77,node21,node23,"E");
		Link link78=new Link(78,node23,node21,"E");
		
		/////// Line F 
		Link link79=new Link(79,node23,node19,"F");
		Link link80=new Link(80,node19,node23,"F");
		Link link81=new Link(81,node19,node22,"F");
		Link link82=new Link(82,node22,node19,"F");
		Link link83=new Link(83,node8,node22,"F");
		
		Link link84=new Link(84,node22,node8,"F");
		 
		Link link85=new Link(85,node18,node8,"F");
		Link link86=new Link(86,node8,node18,"F");
		Link link87=new Link(87,node10,node18,"F");
		Link link88=new Link(88,node18,node10,"F");
		Link link89=new Link(89,node20,node10,"F");
		Link link90=new Link(90,node10,node20,"F");
		Link link91=new Link(91,node11,node20,"F");
		Link link92=new Link(92,node20,node11,"F");
		Link link93=new Link(93,node12,node11,"F");
		Link link94=new Link(94,node11,node12,"F");
		
		//// Line G
		Link link95=new Link(95,node30,node29,"G");
		Link link96=new Link(96,node29,node30,"G");
		Link link97=new Link(97,node29,node13,"G");
		Link link98=new Link(98,node13,node29,"G");		
		Link link99=new Link(99,node13,node3,"G");
		Link link100=new Link(100,node3,node13,"G");
		Link link101=new Link(101,node3,node6,"G");
		Link link102=new Link(102,node6,node3,"G");
		Link link103=new Link(103,node6,node32,"G");
		Link link104=new Link(104,node32,node6,"G");
		Link link105=new Link(105,node32,node22,"G");
		Link link106=new Link(106,node22,node32,"G");
		Link link107=new Link(107,node22,node21,"G");
		Link link108=new Link(108,node21,node22,"G");
		Link link109=new Link(109,node21,node31,"G");
		Link link110=new Link(110,node31,node21,"G");
		Link link111=new Link(111,node31,node28,"G");
		Link link112=new Link(112,node28,node31,"G");
	
		
		
		node1.addIntoLink(link34);
		node1.addIntoLink(link18);
		node1.addIntoLink(link2);
		node1.addOutList(link33);
		node1.addOutList(link17);
		node1.addOutList(link1);
		
		node2.addIntoLink(link36);
		node2.addIntoLink(link20);
		node2.addIntoLink(link17);
		node2.addIntoLink(link33);
		node2.addOutList(link35);
		node2.addOutList(link19);
		node2.addOutList(link18);
		node2.addOutList(link34);
		
		node3.addIntoLink(link22);
		node3.addIntoLink(link102);
		node3.addIntoLink(link19);
		node3.addIntoLink(link99);
		node3.addOutList(link21);
		node3.addOutList(link101);
		node3.addOutList(link100);
		node3.addOutList(link20);
		
		
		node4.addIntoLink(link1);
		node4.addIntoLink(link4);
		node4.addOutList(link2);
		node4.addOutList(link3);
		
		node5.addIntoLink(link3);
		node5.addIntoLink(link6);
		node5.addOutList(link5);
		node5.addOutList(link4);
		
		node6.addIntoLink(link101);
		node6.addIntoLink(link5);
		node6.addIntoLink(link104);
		node6.addIntoLink(link8);
		node6.addOutList(link7);
		node6.addOutList(link103);
		node6.addOutList(link6);
		node6.addOutList(link102);
		
		node7.addIntoLink(link21);
		node7.addIntoLink(link24);
		node7.addOutList(link23);	
		node7.addOutList(link22);	
		
		node8.addIntoLink(link10);
		node8.addIntoLink(link84);
		node8.addIntoLink(link7);
		node8.addIntoLink(link85);
		node8.addOutList(link86);
		node8.addOutList(link9);
		node8.addOutList(link83);
		node8.addOutList(link8);
		
		node9.addIntoLink(link12);
		node9.addIntoLink(link9);
		node9.addOutList(link11);	
		node9.addOutList(link10);	
		
		node10.addIntoLink(link89);
		node10.addIntoLink(link88);
		node10.addOutList(link90);	
		node10.addOutList(link87);	
		
		node11.addIntoLink(link63);
		node11.addIntoLink(link93);
		node11.addIntoLink(link42);
		node11.addIntoLink(link48);
		node11.addIntoLink(link66);
		node11.addIntoLink(link92);
		node11.addIntoLink(link39);
		node11.addIntoLink(link45);
		node11.addOutList(link46);
		node11.addOutList(link40);
		node11.addOutList(link91);
		node11.addOutList(link65);
		node11.addOutList(link47);
		node11.addOutList(link41);
		node11.addOutList(link94);
		node11.addOutList(link64);
		
		node12.addIntoLink(link41);
		node12.addIntoLink(link94);
		node12.addIntoLink(link64);
		node12.addOutList(link42);	
		node12.addOutList(link93);	
		node12.addOutList(link63);
		
		node13.addIntoLink(link38);
		node13.addIntoLink(link100);
		node13.addIntoLink(link35);
		node13.addIntoLink(link97);
		node13.addOutList(link98);
		node13.addOutList(link37);
		node13.addOutList(link36);
		node13.addOutList(link99);
		
		node14.addIntoLink(link40);
		node14.addIntoLink(link37);
		node14.addOutList(link39);	
		node14.addOutList(link38);
		
		node15.addIntoLink(link30);
		node15.addIntoLink(link14);
		node15.addIntoLink(link76);
		node15.addIntoLink(link11);
		node15.addIntoLink(link27);
		node15.addIntoLink(link73);
		node15.addOutList(link29);
		node15.addOutList(link13);
		node15.addOutList(link75);
		node15.addOutList(link12);
		node15.addOutList(link28);
		node15.addOutList(link74);
		
		node16.addIntoLink(link25);
		node16.addIntoLink(link28);
		node16.addOutList(link27);	
		node16.addOutList(link26);
		
		node17.addIntoLink(link35);
		node17.addIntoLink(link32);
		node17.addIntoLink(link16);
		node17.addIntoLink(link58);
		node17.addIntoLink(link13);
		node17.addIntoLink(link29);
		node17.addOutList(link31);
		node17.addOutList(link15);
		node17.addOutList(link57);
		node17.addOutList(link14);
		node17.addOutList(link30);
		node17.addOutList(link56);
		
		
		node18.addIntoLink(link26);
		node18.addIntoLink(link86);
		node18.addIntoLink(link23);
		node18.addIntoLink(link87);
		node18.addOutList(link88);
		node18.addOutList(link25);
		node18.addOutList(link85);
		node18.addOutList(link24);
		
		node19.addIntoLink(link79);
		node19.addIntoLink(link82);
		node19.addOutList(link81);	
		node19.addOutList(link80);
		
		node20.addIntoLink(link90);
		node20.addIntoLink(link91);
		node20.addOutList(link92);	
		node20.addOutList(link89);
		
		node21.addIntoLink(link75);
		node21.addIntoLink(link78);
		node21.addIntoLink(link110);
		node21.addIntoLink(link107);
		node21.addOutList(link77);	
		node21.addOutList(link108);
		node21.addOutList(link76);	
		node21.addOutList(link109);
		
		node22.addIntoLink(link83);
		node22.addIntoLink(link81);
		node22.addIntoLink(link108);
		node22.addIntoLink(link105);
		node22.addOutList(link82);	
		node22.addOutList(link107);
		node22.addOutList(link106);	
		node22.addOutList(link84);
		
		node23.addIntoLink(link61);
		node23.addIntoLink(link77);
		node23.addIntoLink(link80);
		node23.addOutList(link79);
		node23.addOutList(link78);	
		node23.addOutList(link62);
		
		node24.addIntoLink(link71);
		node24.addIntoLink(link74);
		node24.addOutList(link72);	
		node24.addOutList(link73);
		
		node25.addIntoLink(link72);
		node25.addIntoLink(link69);
		node25.addOutList(link70);	
		node25.addOutList(link71);
		
		node26.addIntoLink(link70);
		node26.addIntoLink(link67);
		node26.addOutList(link68);	
		node26.addOutList(link69);
		
		node27.addIntoLink(link68);
		node27.addIntoLink(link65);
		node27.addOutList(link66);	
		node27.addOutList(link67);
		
		node28.addIntoLink(link31);
		node28.addIntoLink(link15);
		node28.addIntoLink(link111);
		node28.addOutList(link112);	
		node28.addOutList(link16);
		node28.addOutList(link32);
		
		node29.addIntoLink(link98);
		node29.addIntoLink(link95);
		node29.addOutList(link96);	
		node29.addOutList(link97);
		
		node30.addIntoLink(link44);
		node30.addIntoLink(link96);
		node30.addOutList(link43);	
		node30.addOutList(link95);
		
		node31.addIntoLink(link57);
		node31.addIntoLink(link112);
		node31.addIntoLink(link60);
		node31.addIntoLink(link109);
		node31.addOutList(link110);	
		node31.addOutList(link59);
		node31.addOutList(link111);	
		node31.addOutList(link58);
		
		node32.addIntoLink(link106);
		node32.addIntoLink(link103);
		node32.addOutList(link105);	
		node32.addOutList(link104);
		
		node33.addIntoLink(link44);
		node33.addIntoLink(link96);
		node33.addOutList(link43);	
		node33.addOutList(link95);
		
		node34.addIntoLink(link99);
		node34.addIntoLink(link52);
		node34.addOutList(link50);	
		node34.addOutList(link51);
		
		node35.addIntoLink(link54);
		node35.addIntoLink(link51);
		node35.addOutList(link53);	
		node35.addOutList(link52);
		
		node36.addIntoLink(link43);
		node36.addIntoLink(link46);
		node36.addOutList(link45);	
		node36.addOutList(link44);
		
		node37.addIntoLink(link53);
		node37.addIntoLink(link56);
		node37.addOutList(link54);	
		node37.addOutList(link55);
		
		node38.addIntoLink(link59);
		node38.addIntoLink(link62);
		node38.addOutList(link61);	
		node38.addOutList(link60);
		
		linkList.add(link1);
		linkList.add(link2);
		linkList.add(link3);
		linkList.add(link4);
		linkList.add(link5);
		linkList.add(link6);
		linkList.add(link7);
		linkList.add(link8);
		linkList.add(link9);
		linkList.add(link10);
		linkList.add(link11);
		linkList.add(link12);
		linkList.add(link13);
		linkList.add(link14);
		linkList.add(link15);
		linkList.add(link16);
		linkList.add(link17);
		linkList.add(link18);
		linkList.add(link19);
		linkList.add(link20);
		linkList.add(link21);
		linkList.add(link22);
		linkList.add(link23);
		linkList.add(link24);
		linkList.add(link25);
		linkList.add(link26);
		linkList.add(link27);
		linkList.add(link28);
		linkList.add(link29);
		linkList.add(link30);
		linkList.add(link31);
		linkList.add(link32);
		linkList.add(link33);
		linkList.add(link34);
		linkList.add(link35);
		linkList.add(link36);
		linkList.add(link37);
		linkList.add(link38);
		linkList.add(link39);
		linkList.add(link40);
		linkList.add(link41);
		linkList.add(link42);
		linkList.add(link43);
		linkList.add(link44);
		linkList.add(link45);
		linkList.add(link46);
		linkList.add(link47);
		linkList.add(link48);
		linkList.add(link49);
		linkList.add(link50);
		linkList.add(link51);
		linkList.add(link52);
		linkList.add(link53);
		linkList.add(link54);
		linkList.add(link55);
		linkList.add(link56);
		linkList.add(link57);
		linkList.add(link58);
		linkList.add(link59);
		linkList.add(link60);
		linkList.add(link61);
		linkList.add(link62);
		linkList.add(link63);
		linkList.add(link64);
		linkList.add(link65);
		linkList.add(link66);
		linkList.add(link67);
		linkList.add(link68);
		linkList.add(link69);
		linkList.add(link70);
		linkList.add(link71);
		linkList.add(link72);
		linkList.add(link73);
		linkList.add(link74);
		linkList.add(link75);
		linkList.add(link76);
		linkList.add(link77);
		linkList.add(link78);
		linkList.add(link79);
		linkList.add(link80);
		linkList.add(link81);
		linkList.add(link82);
		linkList.add(link83);
		linkList.add(link84);
		linkList.add(link85);
		linkList.add(link86);
		linkList.add(link87);
		linkList.add(link88);
		linkList.add(link89);
		linkList.add(link90);
		linkList.add(link91);
		linkList.add(link92);
		linkList.add(link93);
		linkList.add(link94);
		linkList.add(link95);
		linkList.add(link96);
		linkList.add(link97);
		linkList.add(link98);
		linkList.add(link99);
		linkList.add(link100);
		linkList.add(link101);
		linkList.add(link102);
		linkList.add(link103);
		linkList.add(link104);
		linkList.add(link105);
		linkList.add(link106);	
		linkList.add(link107);
		linkList.add(link108);
		linkList.add(link109);
		linkList.add(link110);
		linkList.add(link111);
		linkList.add(link112);		
	}	
	
	public  void search(Node here,Node aim, PassedNodes nodes, Path history){	   
	    	for (int i=0;i<here.getOutList().size();i++){
	    		if (nodes.getNodes().contains(here.getOutList().get(i).getTo().getNodeID()+"")){    			
	    		} else if (here.getOutList().get(i).getTo()==aim)
	    		{
	    			pathList.add(pathAddLink(history,here.getOutList().get(i)));
	    		} else {
	    			search(here.getOutList().get(i).getTo(),aim, updateNodes(nodes,here.getOutList().get(i).getTo()),pathAddLink(history,here.getOutList().get(i)));  			
	    			continue;
	    		}
	    	}       
	    }
	    
	    public  void findPath(Node one,Node two){
	    	Path myPath=new Path();
			PassedNodes nodes=new PassedNodes();
			nodes.add(one);
	    	search(one,two,nodes,myPath);
	    }
	    
	    public  PassedNodes updateNodes(PassedNodes nodes,Node node){
	    	PassedNodes newNodes=new PassedNodes();
	    	
	    	try{
	    		newNodes=(PassedNodes)nodes.clone();
	    	}catch(Exception e){
	    	}   
	    	newNodes.add(node);
	    	return newNodes;
	    }
	    
	    public  Path pathAddLink(Path path,Link link){
	    	Path newPath=new Path();
	    	try{
	    		newPath=(Path)path.clone();
	    	}catch(Exception e){  		
	    	}   	
	    	newPath.add(link.getLinkID()+"");
	    	return newPath;
	    }
	    
	    public StringBuilder getWords() {
			return words;
		}	
		
	    
}
