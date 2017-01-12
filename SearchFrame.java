import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class SearchFrame extends JFrame{

	private JButton Search;
	private JPanel panel;
    private JScrollPane scrollPane;
	private JRadioButton price1,price2,price3,price4;
    private ButtonGroup priceGrp;
	//private String[] colorsForButtons = {"Red", "White", "Black", "Blue"};
	private JRadioButton c1,c2,c3,c4;
	//private JCheckBox[] colorButtons = new JCheckBox[colorsForButtons.length];
	private ButtonGroup colorGrp;
    private JRadioButton t1,t2,t3,t4;
	private ButtonGroup typeGrp;
    private JComboBox d1,d2,d3,d4;
    private JRadioButton y2,y3,y4,y5;
	private ActionListener listener, colorListener;
	private JTextField searchBar;
	private int[] listOfCars;
	private String searchQuery;
	private CarInformation tempHold;
	private static boolean redToggle, blackToggle, whiteToggle, 
		blueToggle, suvToggle, minivanToggle,sedanToggle, sportToggle,
		priceToggle100, priceToggle200, priceToggle300, priceToggle400, toggle2013, toggle2014, toggle2015, toggle2016;
	private String color, type;
	private int year;
	private static boolean fromFiler = false;

	
	public SearchFrame(){
		super("GoundBnB");
		
		setSize(400, 600);
                this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
                int carNumbers = 50;
                JButton info[] = new JButton[carNumbers];
  
		createButton(info);
		createPanel();
		
		tempHold = new CarInformation();

		if(tempHold.getToggle()){
			listOfCars = tempHold.getListFiltered();
		}
		else{
			listOfCars = tempHold.getListOfCars();
		}
		
		// TESTING INPUT DATA
		for(int i = 0; i < listOfCars.length; i++)
			System.out.println(listOfCars[i]);
		
		
		createControlPanel(listOfCars.length,info);
		
		
	}



	private void createControlPanel(int carNumbers,JButton info[]) {
		// TODO Auto-generated method stub
		
		JPanel type = createCheckbox();
		JPanel color = createCheckbox1();
		JPanel price = createCheckbox2();
		JPanel Search1 = createPanel();
        //JPanel year = createdate2();
		
		
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(4, 1));
		controlPanel.add(type);
		controlPanel.add(color);
		controlPanel.add(price);
		//controlPanel.add(year);
        
		
		JPanel p1 = new JPanel();
		p1.add(Search1);
		
                
                JPanel carPanel = new JPanel();
		carPanel.setLayout(new GridLayout(carNumbers,1));
                JPanel car[] = new JPanel[carNumbers];
                for(int i=0;i<carNumbers;i++){
                    car[i] = creatTextbox(i+1,info[i]);
                    carPanel.add(car[i]);
                }
                
                JPanel mainPanel = new JPanel();
                mainPanel.setLayout(new GridLayout(1,2));
                mainPanel.add(controlPanel);
		
                
                
                mainPanel.add(carPanel);
                scrollPane = new JScrollPane();
                scrollPane.setViewportView(mainPanel);
 
		add(Search1,BorderLayout.NORTH);
		add(controlPanel,BorderLayout.WEST);
		add(scrollPane,BorderLayout.CENTER);


	}
    private JPanel createdate2() {
    	
		y2 = new JRadioButton("2013 ");
		y2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(toggle2013){
					toggle2013 = false;
					listOfCars = tempHold.getListUnfiltered();
					tempHold.setListOfCars(listOfCars);
					

					new SearchFrame();
					setVisible(false);
					
					
				}
				else{
					year = Integer.parseInt(y2.getText());
				
					System.out.println(year);
					
					SearchBarResults getYearList = new SearchBarResults();
					listOfCars = tempHold.getListOfCars();
					
					tempHold.setListUnfiltered(listOfCars);

				
					tempHold.setListOfCars(getYearList.getListOfYear(listOfCars, year));

					new SearchFrame();
					setVisible(false);
					toggle2013 = true;
				}
			}
		});
		y3 = new JRadioButton("2014 ");
		y3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(toggle2014){
					toggle2014 = false;
					listOfCars = tempHold.getListUnfiltered();
					tempHold.setListOfCars(listOfCars);
					

					new SearchFrame();
					setVisible(false);
					
					
				}
				else{
					year = Integer.parseInt(y3.getText());
					System.out.println(year);
					
					SearchBarResults getYearList = new SearchBarResults();
					listOfCars = tempHold.getListOfCars();
					
					tempHold.setListUnfiltered(listOfCars);

				
					tempHold.setListOfCars(getYearList.getListOfYear(listOfCars, year));

					new SearchFrame();
					setVisible(false);
					toggle2014 = true;
				}
			}
		});
		y4 = new JRadioButton("2015 ");
		y4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(toggle2015){
					toggle2015 = false;
					listOfCars = tempHold.getListUnfiltered();
					tempHold.setListOfCars(listOfCars);
					

					new SearchFrame();
					setVisible(false);
					
					
				}
				else{
					year = Integer.parseInt(y4.getText());
			
					System.out.println(year);
					
					SearchBarResults getYearList = new SearchBarResults();
					listOfCars = tempHold.getListOfCars();
					
					tempHold.setListUnfiltered(listOfCars);

				
					tempHold.setListOfCars(getYearList.getListOfYear(listOfCars, year));

					new SearchFrame();
					setVisible(false);
					toggle2015 = true;
				}
			}
		});
		y5 = new JRadioButton("2016 ");
		y5.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(toggle2016){
					toggle2016 = false;
					listOfCars = tempHold.getListUnfiltered();
					tempHold.setListOfCars(listOfCars);
					

					new SearchFrame();
					setVisible(false);
					
					
				}
				else{
					year = Integer.parseInt(y5.getText());
				
					System.out.println(year);
					
					SearchBarResults getYearList = new SearchBarResults();
					listOfCars = tempHold.getListOfCars();
					
					tempHold.setListUnfiltered(listOfCars);

				
					tempHold.setListOfCars(getYearList.getListOfYear(listOfCars, year));

					new SearchFrame();
					setVisible(false);
					toggle2016 = true;
				}
			}
		});
		
		panel = new JPanel();
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,1));
		p.add(y2);
		p.add(y3);
		p.add(y4);
		p.add(y5);
		panel.add(p);
		panel.setBorder(new TitledBorder(new EtchedBorder(),"Year "));
		return panel;
	}

	

	private JPanel createCheckbox2() {
		// TODO Auto-generated method stub
		price1 = new JRadioButton("0-100");
		price1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//if(c1.isSelected()){
				if(priceToggle100){

					priceToggle100 = false;

					listOfCars = tempHold.getListUnfiltered();
					tempHold.setListOfCars(listOfCars);
					
					new SearchFrame();
					setVisible(false);
					
					
				}
				else{
					int min = 0;
					int max = 100;
					System.out.println(min + " " + max);
					
					SearchBarResults getPriceList = new SearchBarResults();
					listOfCars = tempHold.getListOfCars();
					tempHold.setListUnfiltered(listOfCars);
					tempHold.setListOfCars(getPriceList.getListOfPrice(listOfCars, min, max));
					

					new SearchFrame();
					setVisible(false);
	
					priceToggle100 = true;
				}
				//}
				
			}
			
		});
		price2 = new JRadioButton("101-200");
		price2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//if(c1.isSelected()){
				if(priceToggle200){

					priceToggle200 = false;

					listOfCars = tempHold.getListUnfiltered();
					tempHold.setListOfCars(listOfCars);
					
					new SearchFrame();
					setVisible(false);
					
					
				}
				else{
					int min = 101;
					int max = 200;
					System.out.println(min + " " + max);
					
					SearchBarResults getPriceList = new SearchBarResults();
					listOfCars = tempHold.getListOfCars();
					tempHold.setListUnfiltered(listOfCars);
					tempHold.setListOfCars(getPriceList.getListOfPrice(listOfCars, min, max));
					

					new SearchFrame();
					setVisible(false);
	
					priceToggle200 = true;
				}
				//}
				
			}
			
		});
		price3 = new JRadioButton("201-300");
		price3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//if(c1.isSelected()){
				if(priceToggle300){

					priceToggle300 = false;

					listOfCars = tempHold.getListUnfiltered();
					tempHold.setListOfCars(listOfCars);
					
					new SearchFrame();
					setVisible(false);
					
					
				}
				else{
					int min = 201;
					int max = 300;
					System.out.println(min + " " + max);
					
					SearchBarResults getPriceList = new SearchBarResults();
					listOfCars = tempHold.getListOfCars();
					tempHold.setListUnfiltered(listOfCars);
					tempHold.setListOfCars(getPriceList.getListOfPrice(listOfCars, min, max));
					

					new SearchFrame();
					setVisible(false);
	
					priceToggle300 = true;
				}
				//}
				
			}
			
		});
		price4 = new JRadioButton("300+");
		price4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//if(c1.isSelected()){
				if(priceToggle400){

					priceToggle400 = false;

					listOfCars = tempHold.getListUnfiltered();
					tempHold.setListOfCars(listOfCars);
					
					new SearchFrame();
					setVisible(false);
					
					
				}
				else{
					int min = 301;
					int max = 999999;
					System.out.println(min + " " + max);
					
					SearchBarResults getPriceList = new SearchBarResults();
					listOfCars = tempHold.getListOfCars();
					tempHold.setListUnfiltered(listOfCars);
					tempHold.setListOfCars(getPriceList.getListOfPrice(listOfCars, min, max));
					

					new SearchFrame();
					setVisible(false);
	
					priceToggle400 = true;
				}
				//}
				
			}
			
		});
		priceGrp = new ButtonGroup();
                priceGrp.add(price1);
		priceGrp.add(price2);
                priceGrp.add(price3);
                priceGrp.add(price4);
                panel = new JPanel();
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,1));
		p.add(price1);
		p.add(price2);
		p.add(price3);
		p.add(price4);
		panel.add(p);
		panel.setBorder(new TitledBorder(new EtchedBorder(),"Price"));
		return panel;
	}

	private JPanel createCheckbox1() {
		// TODO Auto-generated method stub
		
		/**for(int i = 0; i < colorButtons.length; i++){
			colorButtons[i] = new JCheckBox(colorsForButtons[i]);
			final int superI = i;
			colorButtons[i].addActionListener(new ActionListener(){
			
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(colorButtons[superI].isSelected()){
						
						SearchBarResults getColorResults = new SearchBarResults();
						
						tempHold.setListOfCars(getColorResults.getListOfColors(listOfCars, colorButtons[superI].getText()));

						new SearchFrame();
						setVisible(false);						
					}
					
				}
				
			});
		}
        for(int i = 0; i < colorButtons.length; i++){
        	colorGrp.add(colorButtons[i]);
        }			
        													**/
		c1 = new JRadioButton("Red");		

		c1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//if(c1.isSelected()){
				if(redToggle){

					redToggle = false;

					listOfCars = tempHold.getListUnfiltered();
					tempHold.setListOfCars(listOfCars);
					
					new SearchFrame();
					setVisible(false);
					
					
				}
				else{
					color = c1.getText();
					System.out.println(color);
					
					SearchBarResults getColorList = new SearchBarResults();
					listOfCars = tempHold.getListOfCars();
					tempHold.setListUnfiltered(listOfCars);
					tempHold.setListOfCars(getColorList.getListOfColors(listOfCars, color));
					

					new SearchFrame();
					setVisible(false);
	
					redToggle = true;
				}
				//}
				
			}
			
		});
		c2 = new JRadioButton("White");
		c2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(whiteToggle){
					whiteToggle = false;
					listOfCars = tempHold.getListUnfiltered();
					tempHold.setListOfCars(listOfCars);
					

					new SearchFrame();
					setVisible(false);
					
					
				}
				else{
					color = c2.getText();
					System.out.println(color);
					
					SearchBarResults getColorList = new SearchBarResults();
					listOfCars = tempHold.getListOfCars();
					
					tempHold.setListUnfiltered(listOfCars);

				
					tempHold.setListOfCars(getColorList.getListOfColors(listOfCars, color));

					new SearchFrame();
					setVisible(false);
					whiteToggle = true;
				}
			}
		});
		c3 = new JRadioButton("Black");
		c3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(blackToggle){
					blackToggle = false;
					listOfCars = tempHold.getListUnfiltered();
					tempHold.setListOfCars(listOfCars);
			
					new SearchFrame();
					setVisible(false);
					
					
				}
				else{
					color = c3.getText();
					System.out.println(color);
					
					SearchBarResults getColorList = new SearchBarResults();
					listOfCars = tempHold.getListOfCars();
					tempHold.setListUnfiltered(listOfCars);
				
					tempHold.setListOfCars(getColorList.getListOfColors(listOfCars, color));
					
				
					new SearchFrame();
					setVisible(false);
					blackToggle = true;
				}
				
			}
			
		});
		c4 = new JRadioButton("Blue");
		c4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(blueToggle){
					blueToggle = false;
					listOfCars = tempHold.getListUnfiltered();
					tempHold.setListOfCars(listOfCars);
					
					c4.repaint();
					new SearchFrame();
					setVisible(false);
					
					
				}
				else{
					color = c4.getText();
					System.out.println(color);
					
					SearchBarResults getColorList = new SearchBarResults();
					listOfCars = tempHold.getListOfCars();
					tempHold.setListUnfiltered(listOfCars);
				
					tempHold.setListOfCars(getColorList.getListOfColors(listOfCars, color));
					
					c4.repaint();
					new SearchFrame();
					setVisible(false);
					blueToggle = true;
				}
				
			}
			
		});
		colorGrp = new ButtonGroup();
                colorGrp.add(c1);
                colorGrp.add(c2);
                colorGrp.add(c3);
                colorGrp.add(c4);
		panel = new JPanel();
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,1));
		/**for(int i = 0; i < colorButtons.length; i++){
        	p.add(colorButtons[i]);
        }**/
		p.add(c1);
		p.add(c2);
		p.add(c3);
		p.add(c4);
		panel.add(p);
		panel.setBorder(new TitledBorder(new EtchedBorder(),"Color"));
		
		return panel;
	}

	private JPanel createCheckbox() {
		// TODO Auto-generated method stub
		t1 = new JRadioButton("Sedan");
		t1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(sedanToggle){
					sedanToggle = false;
					listOfCars = tempHold.getListUnfiltered();
					tempHold.setListOfCars(listOfCars);
					

					new SearchFrame();
					setVisible(false);
					
					
				}
				else{
					type = t1.getText();
					System.out.println(type);
					
					SearchBarResults getTypeList = new SearchBarResults();
					listOfCars = tempHold.getListOfCars();
					
					tempHold.setListUnfiltered(listOfCars);

				
					tempHold.setListOfCars(getTypeList.getListOfType(listOfCars, type));

					new SearchFrame();
					setVisible(false);
					sedanToggle = true;
				}
			}
		});
		t2 = new JRadioButton("Sport");
		t2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(sportToggle){
					sportToggle = false;
					listOfCars = tempHold.getListUnfiltered();
					tempHold.setListOfCars(listOfCars);
					

					new SearchFrame();
					setVisible(false);
					
					
				}
				else{
					type = t2.getText();
					System.out.println(type);
					
					SearchBarResults getTypeList = new SearchBarResults();
					listOfCars = tempHold.getListOfCars();
					
					tempHold.setListUnfiltered(listOfCars);

				
					tempHold.setListOfCars(getTypeList.getListOfType(listOfCars, type));

					new SearchFrame();
					setVisible(false);
					sportToggle = true;
				}
			}
		});
		t3 = new JRadioButton("MiniVan");
		t3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(minivanToggle){
					minivanToggle = false;
					listOfCars = tempHold.getListUnfiltered();
					tempHold.setListOfCars(listOfCars);
					

					new SearchFrame();
					setVisible(false);
					
					
				}
				else{
					type = t3.getText();
					System.out.println(type);
					
					SearchBarResults getTypeList = new SearchBarResults();
					listOfCars = tempHold.getListOfCars();
					
					tempHold.setListUnfiltered(listOfCars);

				
					tempHold.setListOfCars(getTypeList.getListOfType(listOfCars, type));

					new SearchFrame();
					setVisible(false);
					minivanToggle = true;
				}
			}
		});
		t4 = new JRadioButton("SUV");
		t4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(suvToggle){
					suvToggle = false;
					listOfCars = tempHold.getListUnfiltered();
					tempHold.setListOfCars(listOfCars);
					

					new SearchFrame();
					setVisible(false);
					
					
				}
				else{
					type = t4.getText();
					System.out.println(type);
					
					SearchBarResults getTypeList = new SearchBarResults();
					listOfCars = tempHold.getListOfCars();
					
					tempHold.setListUnfiltered(listOfCars);

				
					tempHold.setListOfCars(getTypeList.getListOfType(listOfCars, type));

					new SearchFrame();
					setVisible(false);
					suvToggle = true;
				}
			}
		});
		typeGrp = new ButtonGroup();
                typeGrp.add(t1);
		typeGrp.add(t2);
                typeGrp.add(t3);
                typeGrp.add(t4);
                panel = new JPanel();
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,1));
		p.add(t1);
		p.add(t2);
		p.add(t3);
		p.add(t4);
		panel.add(p);
		panel.setBorder(new TitledBorder(new EtchedBorder(),"Type"));
		return panel;
	}

	private void createButton(JButton info[]) {
		// TODO Auto-generated method stub
        Search = new JButton("Search");
		
		class SearchAction implements ActionListener{
			
			public void actionPerformed(ActionEvent e){
				searchQuery = searchBar.getText();
				SearchBarResults getListOfCars = new SearchBarResults();
				tempHold.setListOfCars(getListOfCars.getListOfCars(searchQuery));
				

				new SearchFrame();
				setVisible(false);
			}
		}
		Search.addActionListener(new SearchAction());
                class InfoAction implements ActionListener{
                		int i;
                		public InfoAction(int i){
                			this.i = i;
                		}
                        public void actionPerformed(ActionEvent e){
                        		
                        	
                        		System.out.println(listOfCars[i]);
                        		tempHold.setCarChosen(listOfCars[i]);
                                new DetailFrame();
                                setVisible(false);
                        }
                }
                
                for(int i=0;i<info.length;i++){
                    info[i] = new JButton("Info");
                    info[i].addActionListener(new InfoAction(i));
                }
	}
	
	
	private JPanel createPanel(){
		
		searchBar = new JTextField("Search your car ");
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel p = new JPanel();
		p.add(searchBar);
		p.add(Search);
		panel.add(p);
		//add(panel);
		return panel;
		
	}

        private JPanel creatTextbox(int i,JButton Info) {
        SearchBarResults getCarInfo = new SearchBarResults();
        listOfCars = tempHold.getListOfCars();
        String carInfo = getCarInfo.getCarInfo(listOfCars[i-1]);
        System.out.println(carInfo);
		JTextArea kf= new JTextArea("CarInfo: ");
		String[] carInfoArr = carInfo.split(" ");
		kf.append("\n" + carInfoArr[0]);
		kf.append("\n" + carInfoArr[1]);
		kf.append("\n" + carInfoArr[2]);
		kf.append("\n" + carInfoArr[3]);
		
		/**kf.append("\n Color: " + carInfo[2]);
		kf.append("\n Make: " + carInfo[3]);
		kf.append("\n Type: " + carInfo[4]);
		kf.append("\n Model: " + carInfo[5]);**/
		panel = new JPanel();
		JPanel k = new JPanel();	
		panel.add(k);
		k.add(kf);
		kf.setEditable(false);
		panel.setBorder(new TitledBorder(new EtchedBorder(),""+i));
		panel.add(Info,BorderLayout.EAST);
		return panel;
		
	}

}
