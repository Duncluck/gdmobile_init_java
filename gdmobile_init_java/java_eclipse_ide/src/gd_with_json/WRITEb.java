package gd_with_json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class WRITEb {
	public static int wowza = 0;
	public static void main(String[] args) {
		String[] files = new String[190];
		String follder = "C:\\Users\\User\\eclipse-workspace\\gd_with_json\\";
		File list = new File(follder + "gdmobilelist4.txt");
		int levl = 1;
		try {
			Scanner r = new Scanner(list, "UTF-8");
			while (r.hasNext()) {
				String data = r.nextLine();
				String[] type = data.split("\\s+");
				if (type[0].equalsIgnoreCase(levl + ".")) {
					levl++;
				} else {
					eval(levl, newfile(type, data, files), type, data);
				}
			}
			r.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		part2(files);
	}
	
	public static String newfile(String[] celltype, String cellValue, String[] egg) {
		String folder = "C:\\Users\\User\\eclipse-workspace\\gd_with_json\\players\\";
		int wordcount = 1;
		@SuppressWarnings("unused")
		String file = null;
		String name = null;
		
		for (int y = 1; y < celltype.length; y++) {
			String[] splote = celltype[y].split("");
			if (splote[0].equalsIgnoreCase("-")) {
				wordcount = y;
				break;
			}
		}
		switch (wordcount) {
		case 1: cccc(file = folder + celltype[0] + ".json", 
				name = celltype[0], egg); break;
		case 2: cccc(file = folder + celltype[0] + " " + celltype[1] + ".json", 
				name = celltype[0] + " " + celltype[1], egg); break;
		case 3: cccc(file = folder + celltype[0] + " " + celltype[1] + " " + celltype[2] + ".json", 
				name = celltype[0] + " " + celltype[1] + " " + celltype[2], egg); break;
		}
		return file;
	}
		
	public static void cccc(String ei, String name, String[] files) {
		try {
			File myObj = new File(ei);
			if (myObj.createNewFile()) {
				wowza = wowza + 1;
				files[wowza] = name;
				//System.out.println("uh o");
				//System.out.print("u");
			} else {
		        //System.out.println("File already exists.");
		        //System.out.print("I");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	@SuppressWarnings("unchecked")
	public static void eval(int levl, String name, String[] celltype, String cellValue) {
		float lava = (float) levl;
		double score = Math.round(((6000 / (lava + 23)) - 40) * 100.0) / 100.0; 
		//score = Math.round((score + (-0.00015*(lava-50)*(lava-50)+0.5))*100.0)/100.0;
		score = score + Math.round(((0.0025 * lava) + 0.2) * 10.0) / 10.0;
		if (lava == 2) {
			score = 200.00;
		}
		//genius https://whaa.dev/how-to-round-to-one-decimal-place-in-java
		
		try {
			whenAppend(name, score);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void whenAppend(String name, double score) throws IOException {
		//credit to baeldung.com
	    String contentToAppend = score + " ";
	    Files.write(
	      Paths.get(name), 
	      contentToAppend.getBytes(), 
	      StandardOpenOption.APPEND);
	}

/*---------------------------code break---------------------------------------------------------------*/
	/*	public static void container(String name, String[] files) {
		wowza = wowza + 1;
		files[wowza] = name;
		------------boolean allot = false;------------
		
		try {
			for (int i = 0; i < files.length; i++) {
				if (name == "gome") {
					part2(files);
				}
				if (files[i] != "") {
					if (files[i] != "null") { 
					} else {
						files[i] = name;
						System.out.print(files[i]);
					}
				} else {
					files[i] = name;
					System.out.print(files[i]);
				}
			}
		} catch (Exception e) {e.printStackTrace();}
		
	}*/
	
	public static void part2(String[] files) {
		//for (int r = 0; r < files.length; r++) { System.out.println(files[r]); }
		String folder = "C:\\Users\\User\\eclipse-workspace\\gd_with_json\\players\\";
		Scanner myReader;
		try {
			for (int y = 1; y < files.length; y++) {
				double hold = 0;
				if (files[y] == null) {
					break;
				}
				File biprex = new File(folder + files[y] + ".json");
				myReader = new Scanner(biprex, "UTF-8");
				String data = myReader.nextLine();
				String[] points = data.split("\\s+");
				/*for (int i = 0; i < points.length; i++) { 
					System.out.print(points[i] + " ");
				}*/
				for (int j = 0; j < points.length; j++) {
					double temp = Double.valueOf(points[j]);
					hold = temp + hold;
				}
				//System.out.print(hold + "   ");
				//System.out.print(biprex);
			    myReader.close();
			    j(hold, biprex);
			    hold = 0;
			}
			part3(files);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void j(double hold, File biprex) {
		hold = Math.round(Math.floor(hold*100));   //used to have a divide by 10 before the round
		int re = (int) hold;
		hold = ((double) re) / 100;  // was divide by 10 (from before hundredth of points introduced)
		String r = Double.toString(hold);
		//System.out.println(r + "  ");
		try (FileWriter file = new FileWriter(biprex)) {
	        file.write(r); 
	        file.flush();
	
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	//1000, 600, 300, 150, 50, 0
	public static void part3(String[] files) {
		String folder = "C:\\Users\\User\\eclipse-workspace\\gd_with_json\\players\\";
		Scanner eader;
		String[] names = new String[190];
		Double[] points = new Double[190];
		try {
			for (int y = 1; y < files.length; y++) {
				if (files[y] == null) {
					break;
				}
				File biprex = new File(folder + files[y] + ".json");
				eader = new Scanner(biprex, "UTF-8");
				double data = Double.valueOf(eader.nextLine());
				points[y] = data;
				names[y] = files[y];
			}
		} catch (Exception e){	e.printStackTrace();	}
		
		int checkfinal = 1;
		while (checkfinal > 0) {
			//System.out.println("boot");
			checkfinal = 0;
			for (int h = 1; h < names.length; h++) {
				if (points[h+1] == null) { if (h != 0) { break; }}
				double wone = points[h];
				double wtwo = points[h+1];
				if (wtwo > wone) {
					checkfinal++;
					String wonename = names[h];
					names[h] = names[h+1];
					names[h+1] = wonename;
					double wonetemp = points[h];
					points[h] = points[h+1];
					points[h+1] = wonetemp;			
				}
			}
		}
		
		for (int u = 1; u < 190; u++) {
			System.out.print(points[u] + " " + names[u]);
		}
		String[] cats = {"Overlords", "Class S", "Class A", "Class B", "Class C", "Class D"};
		Integer[] bois = {5000,1000,600,300,150,50,0};
		for (int looper = 0; looper < 6; looper++) {
			System.out.print("<br>" + "\n\n" + "<div class=\"infos\">" + "\t" + "<div style=\"padding: 8px\">");
			System.out.print("\n\t" + "<p class=\"mes\" style=\"font-weight: bold; \">" + cats[looper] + ": " + "</p>");
			System.out.print("\n\t" + "<ul class=\"statlist\">");
			for (int w = 1; w < 100; w++) {
				if (points[w] > bois[looper+1] && points[w] < bois[looper]) {
					int decimal = (int) ((int) (points[w]*100) - (Math.floor(points[w])*100));
					System.out.print("\n\t\t" + "<li><p class=\"mes lipad\">" + names[w]);
					System.out.print("<span></span> -" + " " + (int) Math.floor(points[w]));
					if (decimal < 10 ) {
						System.out.print(".<span>" + "0" + decimal + "</span></p></li>");						
					} else {
						System.out.print(".<span>" + decimal + "</span></p></li>");
					}
				}	
			}
			System.out.print("\n\t" + "</ul>" + "\n\t" + "</div>" + "\n" + "</div>" + "\n\n");
		}
	}
}