package bucky;
import java.util.*;
import java.io.*;
import bucky.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;





public class FileOp {
	private String fileName;

	private FileWriter fw = null;

	private BufferedWriter bw = null;

	private FileReader fr = null;

	private BufferedReader br = null;

	private Scanner x ;
	
	private ArrayList<Product> listInfo = new ArrayList<Product>();



	public static FileOp fileOp = new FileOp();

	// *****************return file operation object*****************
	public static FileOp getInstance() {
		return fileOp;
	}

	

	// *****************return file name*****************
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	// **************************file operations****************************
	//****************** get output stream******************
	public BufferedWriter getOutPutStream() {
		if (checkFile()) {
			try {
				
				fw = new FileWriter(fileName, true);
				bw = new BufferedWriter(fw);
				
			} catch (IOException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bw;
	}

	//****************** close output stream******************
	public void closeOutPutStream() {
		try {
			fw.close();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// *****************get input stream*****************
	public BufferedReader getInPutStream() {
		if (checkFile()) {
			try {
				fr = new FileReader(fileName);
				br = new BufferedReader(fr);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return br;
		// BufferedReader br = new BufferedReader();
	}

	// *****************close input stream*****************
	public void closeInPutStream() {
		try {
			fr.close();
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean addInfo(String name, String address1, String address2, String city,
			String date, String email, String lname, String middle, long phone, int zipcode, String statename,
			boolean flag) {
		// TODO Auto-generated method stub
		boolean flags = false; 
		Product prodct = new Product();
		prodct.setName(name);

		prodct.setAddress1(address1);
		prodct.setAddress2(address2);
		prodct.setCity(city);
		prodct.setDate(date);
		prodct.setEmail(email);
		prodct.setLastname(lname);
		prodct.setMiddle(middle);
		prodct.setPhone(phone);
		prodct.setZipcode(zipcode);
		prodct.setState(statename);
		prodct.setProf(flag);
		for (int i = 0; i < listInfo.size(); i++) {
			if (prodct.getName().equals(listInfo.get(i).getName())&&
					prodct.getMiddle().equals(listInfo.get(i).getMiddle())&&
					prodct.getLastname().equals(listInfo.get(i).getLastname())) {
			
				return flags;
			}
		}
	
		// *****************get input stream*****************
		BufferedWriter bw = getOutPutStream();  
		try {
			listInfo.add(prodct);
			bw.write(prodct.getName() + "\t" + prodct.getAddress1() + "\t"+ prodct.getAddress2() + "\t"
					+ prodct.getCity() + "\t"+ prodct.getDate() + "\t"+ prodct.getEmail() + "\t"
					+ prodct.getLastname() + "\t"+ prodct.getMiddle()+ "\t"+ prodct.getPhone() + "\t"
					+ prodct.getZipcode() + "\t"+ prodct.getState() + "\t"+ prodct.isProf()+ "\t");
			bw.newLine();
			bw.flush(); 
			flags = true; // 添加记录成功
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeOutPutStream(); 
		}
		return flags;
	}

// ****************Open File Function****************
	public void openFile(){
		try {
			x = new Scanner(new File (fileOp.getFileName()));
			System.out.println("I can find and open file");
		}
		catch(Exception e){
			System.out.println("could not find file");
		}
	}
	

	
	
	 //*************Get all of the products one by one*************
    public ObservableList<Product> getProduct(){
    	ObservableList<Product> products = FXCollections.observableArrayList();

        while (x.hasNext()){
        products.add(new Product(x.next(),  x.next(), x.next(), 
        		x.next(), x.next(), 
        		x.next(), x.next(), x.next(),
        		x.nextLong(),
        		x.nextInt(),
        		x.next(),
        		x.nextBoolean()
        		));}
      
  
    	
    	return products;
    }
    
 // ****************initial all information****************
 	public boolean initial() {
 		boolean flag = true;
 	// ****************clear sets****************
 		if (listInfo.size() != 0) {
 			listInfo.clear();
 			 /**
 		     * Removes all of the elements from this list.  The list will
 		     * be empty after this call returns.
 		     */
 		}
 		BufferedReader br = getInPutStream();
 		try {
 			br.readLine();
 			String strInfo = br.readLine();
 			while (strInfo != null) {
 				String[] infos = strInfo.split("\t");
 				Product stuf = new Product();
 				stuf.setName(infos[0]);

 				stuf.setAddress1(infos[1]);
 				stuf.setAddress2(infos[2]);
 				stuf.setCity(infos[3]);
 				stuf.setDate(infos[4]);
 				stuf.setEmail(infos[5]);

 				stuf.setLastname(infos[6]);				
 				stuf.setMiddle(infos[7]);
		
 				stuf.setPhone(Long.parseLong(infos[8]));
 				stuf.setZipcode(Integer.parseInt(infos[9]));
 				stuf.setState(infos[10]);
 				stuf.setProf(Boolean.parseBoolean(infos[11]));

 				listInfo.add(stuf);

 				strInfo = br.readLine();
 				
 			}
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 			flag = false;
 		} finally {
 			closeInPutStream();
 		}
 		// while
 		return flag;
 	}


	/**
	 * update file
	 * 
	 * @return
	 */
	private void updateFile() {
		
		// ****************rewrite file ****************
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
			fileWriter = new FileWriter(fileName);
			bufferedWriter = new BufferedWriter(fileWriter);
			// **********************************************************************************
	
			bufferedWriter.newLine();

			for (int j = 0; j < listInfo.size(); j++) {

				bufferedWriter.write(listInfo.get(j).getName()+"\t"+ listInfo.get(j).getAddress1() + "\t"
						+ listInfo.get(j).getAddress2() + "\t"+ listInfo.get(j).getCity() + "\t"
						+ listInfo.get(j).getDate() + "\t"+ listInfo.get(j).getEmail() + "\t"
						+ listInfo.get(j).getLastname() + "\t"+ listInfo.get(j).getMiddle() + "\t"
						+ listInfo.get(j).getPhone() + "\t"+ listInfo.get(j).getZipcode() + "\t"
						+ listInfo.get(j).getState() + "\t"+ listInfo.get(j).isProf()
						);
				bufferedWriter.newLine();
			}
			bufferedWriter.flush(); 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bufferedWriter.close();
				fileWriter.close(); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("update file");
	
	}

    /**
	 * Delete Function
	 * 
	 * @return
	 */
    public void deleteInfo(String string) {
//    	string = FXCollections.observableArrayList();
    	
    	for (int i = 0; i < listInfo.size(); i++) {
			if (string.equals(listInfo.get(i).getName())) {
				listInfo.remove(i); // eliminate from set
				System.out.println(" ok,delete successful");
				updateFile();			
			}
		}  
	}
    /**
   	 * update one record
     * @param string3 
     * @param string 
        * @param product1 
   	 * 
   	 * @param emp
   	 * @return 
   	 * @return
   	 */
	public void updateInfo(Product Changedproduct, String first, String middle, String last) {
		// TODO Auto-generated method stub
		for (int i = 0; i < listInfo.size(); i++) {
			if ((first.equals(listInfo.get(i).getName()))&&
					(middle.equals(listInfo.get(i).getMiddle())&&
							(last.equals(listInfo.get(i).getLastname())))){
				listInfo.set(i, Changedproduct);//update
		
				
				updateFile();		
			}
		}
		System.out.println("update complete");
	}
	
	
	/**
	 * Check if the file exist or not
	 * 
	 * @return
	 */
	public boolean checkFile() {
		File file = new File(fileName);
		boolean flag = false;
		// ****************if the file not exist,create it ****************
		if (!file.exists()) {
			try {
				flag = file.createNewFile();
				if (flag) {
					System.out.println(fileName + "can't find file");
				}
				fw = new FileWriter(fileName);
				bw = new BufferedWriter(fw);
				
				bw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				closeOutPutStream();
			}
		} else {
			flag = true;
		}
		
		return flag;
	}


}
