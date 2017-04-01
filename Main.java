package bucky;


import java.util.Optional;
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    TableView<Product> table;
    TextField nameInput, mnameinput,lnameinput,emailinput,cityinput,priceInput, quantityInput;
    TextField address1input,address2input,zipcodeinput,phoneinput,dateinput;
    ComboBox<String> comboBox,comboBox1,comboBox2,comboBox3,comboBox4;
    static Scanner read = new Scanner(System.in);
	static FileOp fileOp = FileOp.getInstance();
	
	
	
    public static void main(String[] args) {
//		File create
    	fileOp.setFileName("fan.txt");
    	fileOp.openFile();
//    	Read data from fan.txt to data list created.
    	fileOp.initial();    	
		System.out.println("System initialization....");
        launch(args);
    }

    @SuppressWarnings("unchecked")
	@Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Fan's UI - JavaFX");
        
      //********************************* Windows close******************************************************// 
        window.setOnCloseRequest(e -> {
        	e.consume();
        	closeProgram();
        });
        
      
      //********************************* ComboBoxes******************************************************// 
        //combobox set for state
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll("TX","AL","AK","AZ","AR","CA","CO","CT","DE","FL",
        		"GA","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MI","MN","MS",
        		"MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","RI","SC","SD",
        		"TN","UT","VT","VA","WA","WV","WI","WY"
        		);
        comboBox.setPromptText("Please select your home state?");
       
        //combobox set for prof
        comboBox1 = new ComboBox<>();
        comboBox1.getItems().addAll("Yes", "No");
        comboBox1.setPromptText("Proof of purchase attached or?");
        
        comboBox2 = new ComboBox<>();
        comboBox2.getItems().addAll("1990","1991","1992","1993","1994","1995","1996","1997","1998","1999",
        		"2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012",
        		"2013","2014","2015","2016"
        		);
        comboBox2.setPromptText("Year");
        
        comboBox3 = new ComboBox<>();
        comboBox3.getItems().addAll("01","02","03","04","05","06","07",
        		"08","09","10","11","12"
        		);
        comboBox3.setPromptText("Month");
        
        comboBox4 = new ComboBox<>();
        comboBox4.getItems().addAll("1","2","3","4","5","6","7","8","9","10",
        		"11","12","13","14","15","16","17","18","19","20","21","22","23","24","25",
        		"26","27","28","29","30","31"
        		);
        comboBox4.setPromptText("Date");
        
      //********************************* Columns for TableView******************************************************// 
        //Name column
        TableColumn<Product, String> nameColumn = new TableColumn<>("FirstName");
        nameColumn.setMinWidth(150);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        //middleName column
        TableColumn<Product, String> middlenameColumn = new TableColumn<>("Middle");
        middlenameColumn.setMinWidth(100);
        middlenameColumn.setCellValueFactory(new PropertyValueFactory<>("middle"));
        
        //lastnameName column
        TableColumn<Product, String> lastnameColumn = new TableColumn<>("LastName");
        lastnameColumn.setMinWidth(150);
        lastnameColumn.setCellValueFactory(new PropertyValueFactory<>("lastname"));
         
        //Phone column
        TableColumn<Product, String> phoneColumn = new TableColumn<>("Phone#");
        phoneColumn.setMinWidth(200);
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        
        //*************Get date*********************************************//
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
 	   //get current date time with Date()
 	   Date date = new Date();
 	   System.out.println(dateFormat.format(date));

      //********************************* Input Fields******************************************************// 
        //Name input
        nameInput = new TextField();
        nameInput.setPromptText("*FirstName*");
        nameInput.setMinWidth(100);
        
        //MiddleName input
        mnameinput = new TextField();
        mnameinput.setPromptText("MiddleName");
        mnameinput.setMinWidth(100);
        
        //LastName input
        lnameinput = new TextField();
        lnameinput.setPromptText("*LastName*");
        lnameinput.setMinWidth(100);
        
        //city input
        cityinput = new TextField();
        cityinput.setPromptText("*cityinput*");
        cityinput.setMinWidth(100);

      //Address1 input
        address1input = new TextField();
        address1input.setPromptText("*address1*");
        
      //Address2 input
        address2input = new TextField();
        address2input.setPromptText("address2");
        
      //zipcodeinput input
        zipcodeinput = new TextField();
        zipcodeinput.setPromptText("*zipcode*");
        
      //phoneinput input
        phoneinput = new TextField();
        phoneinput.setPromptText("*phone*");
        
      //emailinput input
        emailinput = new TextField();
        emailinput.setPromptText("*email*");
        
      //dateinput input
        dateinput = new TextField();
        dateinput.setEditable(false);
        dateinput.setText(dateFormat.format(date));
        
       
 	  

       
      //********************************* Buttons******************************************************// 
        Button addButton = new Button("Add Record");
        addButton.setOnAction(e -> addButtonClicked());
        
        Button deleteButton = new Button("Delete it");
        deleteButton.setOnAction(e -> deleteButtonClicked());
        
        Button changeButton = new Button("Change it");
        changeButton.setOnAction(e -> changeButtonClicked());
        
        Button clearButton = new Button("Clear input");
        clearButton.setOnAction(e -> clearButtonClicked());
        
//        Button exitButton = new Button("Exist Here");
//        exitButton.setOnAction(e -> exitButtonClicked());


        table = new TableView<>();
        table.getColumns().addAll(nameColumn,middlenameColumn, lastnameColumn,phoneColumn);
        table.setItems(fileOp.getProduct());
       
        
        
      //*********************************table click event******************************************************// 
        table.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override 
            public void handle(MouseEvent event) {
            	 //*************Get date*********************************************//
//                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//         	   //get current date time with Date()
//         	   Date date = new Date();
////         	   System.out.println(dateFormat.format(date));
            	
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {

                    @SuppressWarnings({ "unused" })
					ObservableList<Product> productSelected, allProducts;
                    allProducts = table.getItems();     
                    productSelected=table.getSelectionModel().getSelectedItems();
                    
                    Product product =new Product();
                    product = table.getSelectionModel().getSelectedItem();
                    
                    nameInput.setText(product.getName());
                    
                    mnameinput.setText(product.getMiddle());
                    lnameinput.setText(product.getLastname());
                    emailinput.setText(product.getEmail());
                    cityinput.setText(product.getCity());
                    address1input.setText(product.getAddress1());
                    address2input.setText(product.getAddress2());
                    String Szipcode = String.valueOf(product.getZipcode());
                    zipcodeinput.setText(Szipcode);
                    dateinput.setText(product.getDate());
                    String Sphone = String.valueOf(product.getPhone());
                    phoneinput.setText(Sphone);
                    String state = product.getState();
                    comboBox.setValue(state);
                    comboBox.setPromptText(state);
                   
//                    System.out.println(table.getSelectionModel().getSelectedItem());                   
                }
            }
        });
      //*********************************HBox******************************************************//
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(lnameinput, dateinput,comboBox2,comboBox3,comboBox4,addButton, deleteButton,changeButton,clearButton);
        
        HBox hBox1 = new HBox();
        hBox1.setPadding(new Insets(10,10,10,10));
        hBox1.setSpacing(10);
        hBox1.getChildren().addAll(nameInput, mnameinput,cityinput,emailinput,comboBox);
        
        HBox hBox2 = new HBox();
        hBox2.setPadding(new Insets(10,10,10,10));
        hBox2.setSpacing(10);
        hBox2.getChildren().addAll(address1input, address2input,zipcodeinput,phoneinput,comboBox1);
     
      //*********************************VBox******************************************************//
        VBox vBox = new VBox();
        vBox.getChildren().addAll(table,hBox1, hBox2,hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }
    
  //*********************************Close window******************************************************//
    private void closeProgram(){
    	boolean answer = ConfirmBox.display("Exit","About to leave ?");
    	if(answer){
    		window.close();
    	}
    }
  //*********************************ExitButton******************************************************//
//	private void exitButtonClicked() {
//		closeProgram();
//		// TODO Auto-generated method stub
//
//	}
	  //*********************************clearButton******************************************************//
	public void clearButtonClicked() {
		// TODO Auto-generated method stub
		 //*************Get date*********************************************//
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
 	   //get current date time with Date()
 	   Date date = new Date();
 	   System.out.println(dateFormat.format(date));
		nameInput.clear();
		mnameinput.clear();
		lnameinput.clear();		
		emailinput.clear();
		cityinput.clear();
		address1input.clear();
		address2input.clear();
		zipcodeinput.clear();
		phoneinput.clear();
		dateinput.setText(dateFormat.format(date));
		
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy");
	 	   //get current date time with Date()
	 	   Date dates = new Date();
	 	   
	 	  DateFormat dateFormat2 = new SimpleDateFormat("MM");
	 	   //get current date time with Date()
	 	   Date datess = new Date();
	 	   
	 	  DateFormat dateFormat3 = new SimpleDateFormat("dd");
	 	   //get current date time with Date()
	 	   Date datesss = new Date();
		comboBox2.setPromptText(dateFormat1.format(dates));
		comboBox3.setPromptText(dateFormat2.format(datess));
		comboBox4.setPromptText(dateFormat3.format(datesss));
	}

	//**********************************Add button clicked**********************************//
    public void addButtonClicked(){      
    	Product product = new Product();
    	String statename = comboBox.getValue();
    	String getprof = comboBox1.getValue();
    	String year = comboBox2.getValue();
    	String month = comboBox3.getValue();
    	String day = comboBox4.getValue();
      
        boolean flag = false;
        if (getprof =="Yes"){
        	flag = true;
        }
        product.setState(statename);
        product.setYear(year);
        product.setMonth(month);
        product.setDay(day);
        product.setProf(flag);
        
        //************* For the circumstance like null input for required text fields.********
     if((nameInput.getText().toString() == null)|| "".equals(nameInput.getText().toString())||
    		 (lnameinput.getText().toString() == null)|| "".equals(lnameinput.getText().toString())||
    		 (emailinput.getText().toString() == null)|| "".equals(emailinput.getText().toString())||
    		 (address1input.getText().toString() == null)|| "".equals(address1input.getText().toString())||
    		 (cityinput.getText().toString() == null)|| "".equals(cityinput.getText().toString())||
    		 (phoneinput.getText().toString() == null)|| "".equals(phoneinput.getText().toString())||
    		 (zipcodeinput.getText().toString() == null)|| "".equals(zipcodeinput.getText().toString())||  	
    		 (statename == null)||(statename== "null")||"".equals(statename)

			 ) 
     
    		{
    	 	Alert alert = new Alert(AlertType.ERROR);
    	 	alert.setTitle("Error occured");
    	 	alert.setHeaderText("Ooops,the necessary inputs are empty!");
    	 	alert.showAndWait();
    		}
     else{
    	 //************* For the circumstance like null input for address2 and middle name.********
    	 if((address2input.getText()== null)|| "".equals(address2input.getText()))
    	 	{
    		 product.setAddress2("null");}
    	 	else{
    	 		product.setAddress2(address2input.getText());
    	 		}
    	 
    	 if((mnameinput.getText()== null)|| "".equals(mnameinput.getText()))
    	 	{
    		 product.setMiddle("n");
    		 							}
    	 	else{
    	 			product.setMiddle(mnameinput.getText());
    	 		}
    	 if((year == null)||(year== "null")||"".equals(year)||
 			 (month == null)||(month== "null")||"".equals(month)||
			 (day == null)||(day== "null")||"".equals(day))
    	 	{
    		 DateFormat dateFormat1 = new SimpleDateFormat("yyyy");
  	 	     //get current date time with Date()
    		 Date dates = new Date();
  	 	   
    		 DateFormat dateFormat2 = new SimpleDateFormat("MM");
    		 //get current date time with Date()
    		 Date datess = new Date();
  	 	   
    		 DateFormat dateFormat3 = new SimpleDateFormat("dd");
    		 //get current date time with Date()
    		 Date datesss = new Date();
    		 year = dateFormat1.format(dates);
    		 month = dateFormat2.format(datess);
  	 	   	day = dateFormat3.format(datesss);  	    		 
    	 	}
    	 
    	 	product.setYear(comboBox2.getValue());
    	 	product.setMonth(comboBox3.getValue());
    	 	product.setDay(comboBox4.getValue());
    	 
    	 	product.setName(nameInput.getText()); 
    	 	product.setAddress1(address1input.getText());
    	 	product.setCity(cityinput.getText());
    	 	String realdate = year+"/"+month+"/"+day; 
    	 	product.setDate(realdate);
    	 	product.setEmail(emailinput.getText());
    	 	product.setLastname(lnameinput.getText());
    	 	if(isname(nameInput.getText())&&isname(lnameinput.getText())&&ismiddle(mnameinput.getText()))
    	 	{
    	 	if(isNumeric(phoneinput.getText())&&isNumeric(zipcodeinput.getText()))
    	 	{
        	 if(isPhone(phoneinput.getText())){
        		 
        		 if(iszipcode(zipcodeinput.getText())){
        		 product.setPhone(Long.parseLong(phoneinput.getText())); 
        		 product.setZipcode(Integer.parseInt(zipcodeinput.getText()));
//           >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        		 if(fileOp.addInfo(nameInput.getText(),address1input.getText(),
        		product.getAddress2(),cityinput.getText(),realdate,
        		emailinput.getText(),lnameinput.getText(),product.getMiddle(),
        		Long.parseLong(phoneinput.getText()),
        		Integer.parseInt(zipcodeinput.getText()),statename,flag))
        		 {
        			 table.getItems().add(product);
        			 nameInput.clear();
        			 emailinput.clear();
        			 cityinput.clear();
        			 address1input.clear();
        			 address2input.clear();
        			 zipcodeinput.clear();
        			 phoneinput.clear();
        			 dateinput.clear();
        			 mnameinput.clear();
        			 lnameinput.clear();
        		 }
        		 else{
        			 Alert alert = new Alert(AlertType.ERROR);
        			 alert.setTitle("Error occured");
        			 alert.setHeaderText("Oh,The customer you entered has already existed!");
        			 alert.showAndWait();
        		 	}
        	 	}
        		 else{
        			 Alert alert = new Alert(AlertType.ERROR);
        			 alert.setTitle("Error occured");
        			 alert.setHeaderText("Oh,your zipcode# should be less than 9 digits");
        			 alert.showAndWait(); 
        		 }
        	 	}
        	 	else{
        	 		Alert alert = new Alert(AlertType.ERROR);
        	 		alert.setTitle("Error occured");
        	 		alert.setHeaderText("Oh,your phone# should be less than 21 digits");
        	 		alert.showAndWait();
        	 	}
         		}
         		else{
         			Alert alert = new Alert(AlertType.ERROR);
         			alert.setTitle("Error occured");
         			alert.setHeaderText("Oh,please enter numeric input for zipcode & phone#");
         			alert.showAndWait();
         			}
    	 		}
    	 	
    	 		else{
     			Alert alert = new Alert(AlertType.ERROR);
     			alert.setTitle("Error occured");
     			alert.setHeaderText("Oh,please check your first/middle/last name must less than 20/1/20");
     			alert.showAndWait();
     			}
	 		
    	 	
     		}
    	}
  //**********************************Add button clicked  End**********************************//
    
    
  //************************************Change  Button  Clicked ************************************//
    public void changeButtonClicked() {
		// TODO Auto-generated method stub
	
    	fileOp.openFile();    	
        Product Changedproduct = new Product();
        String statename = comboBox.getValue();
        String getprof = comboBox1.getValue();
        String year = comboBox2.getValue();
    	String month = comboBox3.getValue();
    	String day = comboBox4.getValue();
        boolean flag = false;
        if (getprof =="Yes"){
      	flag = true;
        }
        //************* For the circumstance like null input for required text fields.********
        if((nameInput.getText().toString() == null)|| "".equals(nameInput.getText().toString())||
       		 (lnameinput.getText().toString() == null)|| "".equals(lnameinput.getText().toString())||
       		 (emailinput.getText().toString() == null)|| "".equals(emailinput.getText().toString())||
       		 (address1input.getText().toString() == null)|| "".equals(address1input.getText().toString())||
       		 (cityinput.getText().toString() == null)|| "".equals(cityinput.getText().toString())||
       		 (phoneinput.getText().toString() == null)|| "".equals(phoneinput.getText().toString())||
       		 (zipcodeinput.getText().toString() == null)|| "".equals(zipcodeinput.getText().toString())||  	
       		 (statename == null)||(statename== "null")||"".equals(statename)

   			 ) 
        
       		{
       	 	Alert alert = new Alert(AlertType.ERROR);
       	 	alert.setTitle("Error occured");
       	 	alert.setHeaderText("Ooops,the necessary inputs are empty!");
       	 	alert.showAndWait();
       		}
        else{
        //************* For the circumstance like null input for address2 and middle name.********
        if((address2input.getText()== null)|| "".equals(address2input.getText()))
   	 	{
        	Changedproduct.setAddress2("null");}
        else{
   		 Changedproduct.setAddress2(address2input.getText());
        	}
   	 
   	 	if((mnameinput.getText()== null)|| "".equals(mnameinput.getText()))
   	 	{
   	 		Changedproduct.setMiddle("n");}
   	 	else{
   		Changedproduct.setMiddle(mnameinput.getText());
   	 		}
   	 	
   	 	if((year == null)||(year== "null")||"".equals(year)||
 			 (month == null)||(month== "null")||"".equals(month)||
			 (day == null)||(day== "null")||"".equals(day))
    	 	{
    		 DateFormat dateFormat1 = new SimpleDateFormat("yyyy");
  	 	     //get current date time with Date()
    		 Date dates = new Date();
  	 	   
    		 DateFormat dateFormat2 = new SimpleDateFormat("MM");
    		 //get current date time with Date()
    		 Date datess = new Date();
  	 	   
    		 DateFormat dateFormat3 = new SimpleDateFormat("dd");
    		 //get current date time with Date()
    		 Date datesss = new Date();
    		 year = dateFormat1.format(dates);
    		 month = dateFormat2.format(datess);
  	 	   	 day = dateFormat3.format(datesss);  	    		 
    	 		}
   	 	
   	 		Changedproduct.setName(nameInput.getText());
   	 		Changedproduct.setAddress1(address1input.getText());
       
   	 		Changedproduct.setCity(cityinput.getText());
   	 		Changedproduct.setDate(dateinput.getText());
   	 		Changedproduct.setEmail(emailinput.getText());
   	 		Changedproduct.setLastname(lnameinput.getText());
   	 	if(isname(nameInput.getText())&&isname(lnameinput.getText())&&ismiddle(mnameinput.getText()))
   	 	{
   	 		if(isNumeric(phoneinput.getText())&&isNumeric(zipcodeinput.getText()))
   	 			{
   	 			if(isPhone(phoneinput.getText())){
    		 
   	 				if(iszipcode(zipcodeinput.getText())){
   	 		Changedproduct.setPhone(Long.parseLong(phoneinput.getText()));
   	 		Changedproduct.setZipcode(Integer.parseInt(zipcodeinput.getText()));
   	 		Changedproduct.setState(statename);
   	 		Changedproduct.setProf(flag);
        
        
   	 		ObservableList<Product> productSelected, allProducts;
   	 		allProducts = table.getItems();     
   	 		productSelected=table.getSelectionModel().getSelectedItems();
        
   	 		Product oldproduct =new Product();
        	oldproduct = table.getSelectionModel().getSelectedItem();
        
        	System.out.print("I want to change this record:");
        
        	fileOp.updateInfo(Changedproduct,oldproduct.getName(),oldproduct.getMiddle(),oldproduct.getLastname());
        
        	productSelected.forEach(allProducts::remove); 
        	table.getItems().add(Changedproduct);
        	nameInput.clear();     
        	mnameinput.clear();
        	lnameinput.clear();
        	emailinput.clear();
			cityinput.clear();
			address1input.clear();
			address2input.clear();
			zipcodeinput.clear();
			phoneinput.clear();
			dateinput.clear();
   	 			}
           		 else{
           			 Alert alert = new Alert(AlertType.ERROR);
           			 alert.setTitle("Error occured");
           			 alert.setHeaderText("Oh,your zipcpde# should be less than 9 digits");
           			 alert.showAndWait(); 
           		 }
           	 	}
           	 	else{
           	 		Alert alert = new Alert(AlertType.ERROR);
           	 		alert.setTitle("Error occured");
           	 		alert.setHeaderText("Oh,your phone# should be less than 21 digits");
           	 		alert.showAndWait();
           	 	}
            		}
            		else{
            			Alert alert = new Alert(AlertType.ERROR);
            			alert.setTitle("Error occured");
            			alert.setHeaderText("Oh,please enter numeric input for zipcode & phone#");
            			alert.showAndWait();
            			}
        }
        
   	 else{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error occured");
			alert.setHeaderText("Oh,please check your first/middle/last name must less than 20/1/20");
			alert.showAndWait();
			}
        
        }
    }

    //**************************************Change End*************************************************//    
    
  //***************************************************************************************//
    //Delete button clicked
    public void deleteButtonClicked(){
    	
    	fileOp.openFile();    	
        
        ObservableList<Product> productSelected, allProducts;
        allProducts = table.getItems();     
        productSelected=table.getSelectionModel().getSelectedItems();
        
        Product product =new Product();
        product = table.getSelectionModel().getSelectedItem();
        // Confirmation for deleting a record from the file.
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Delete Section");
        alert.setHeaderText("Are you sure to delete this record ?");
        alert.setContentText("Please Look carefully");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        	fileOp.deleteInfo(product.getName());
            productSelected.forEach(allProducts::remove);  
            // ... user chose OK
        } else {
            // ... user chose CANCEL or closed the dialog
        	 System.out.print("I just want to delete this record, just want :");
             System.out.println(product.getName());  
        }
        
            
    }
  //************************************Delete Button End********************************************//
    
  
    /**
   	judge a input is numeric or not
	 */
	public static boolean isNumeric(String str){
		for(int i = str.length();--i>=0;){		
			if(!Character.isDigit(str.charAt(i))){
				return false;
			}
		}
		return true;
	}

	 /**
   	judge a input less than 21 digits phone#
	 */
	public static boolean isPhone(String str){
		if(str.length()<=21)
		{return true;}
		else{return false;}
	}
	
	 /**
   	judge a input less than 9digits zipcode#
	 */
	public static boolean iszipcode(String str){
		if(str.length()<=9)
		{return true;}
		else{return false;}
	}
	 /**
   	judge middle name input is one character.
	 */
	public static boolean ismiddle(String str){
		if(str.length()==1)
		{return true;}
		else{return false;}
	}
	/**
   	judge first and last name input less than 20 character.
	 */
	public static boolean isname(String str){
		if(str.length()<=20)
		{return true;}
		else{return false;}
	}
	
}