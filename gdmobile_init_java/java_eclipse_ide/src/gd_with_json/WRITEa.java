package gd_with_json;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WRITEa {
	public static void main(String[] args) {
		String follder = "C:\\Users\\User\\eclipse-workspace\\gd_with_json\\";
		File list = new File(follder + "gdmobilelist4.txt");
		int levl = 1;
		try {
			Scanner r = new Scanner(list);
			while (r.hasNext()) {
				if (levl == 5 ) {break;}
				String data = r.nextLine();
				String[] typee = data.split(""); // \\s+
				String[] type = data.split("\\s+");
				if (typee[0].equalsIgnoreCase("\"")) {
				//if (type[0].equalsIgnoreCase(levl + ".")) {
					levl++;
					if (levl != 2) {
						System.out.print("\n" + "\t" + "\t" + "</ul>" + "\n" + "\t" + "</div>");
						System.out.print("\n" + "</div>" + "\n" + "<br>" + "\n" + "\n");
					}
					pink(type, levl);
				} else {
					pink2(type, data);
				}
			}
			r.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
/*
		try {
			FileInputStream file = new FileInputStream(new File("C:/Users/Owner/Documents/gdmobilelist.xlsx"));
			Workbook workbook = new XSSFWorkbook(file);
			DataFormatter dataFormatter = new DataFormatter();
			Iterator<Sheet> sheets = workbook.sheetIterator();
			while(sheets.hasNext()) {
				Sheet sh = sheets.next();
				System.out.println("Sheet name is "+sh.getSheetName());
				System.out.println("---------");
				Iterator<Row> iterator = sh.iterator();
				while(iterator.hasNext()) {
					Row row = iterator.next();
					Iterator<Cell> cellIterator = row.iterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						String cellValue = dataFormatter.formatCellValue(cell);
						//System.out.println(cellValue);
						
						String[] celltype = cellValue.split("\\s+");
						
						for (int j = 0; j < celltype.length; j++) {
							System.out.print(celltype[j]);
						}
						
						System.out.print("\n");
						if (celltype[0].equalsIgnoreCase(levl + ".") || celltype[0].equalsIgnoreCase(levl+1 + ".")) {
							levl++;
							if (levl != 2) {
								System.out.print("\n" + "\t" + "\t" + "</ul>" + "\n" + "\t" + "</div>");
								System.out.print("\n" + "</div>" + "\n" + "<br>" + "\n" + "\n");
							}
							pink(celltype);
						} else {
							pink2(celltype, cellValue);
						}
					}
				}
			}
			workbook.close();
		} catch(Exception e) {
			e.printStackTrace();
		}*/
	
	public static void pink(String[] celltype, int levl) {
		System.out.print("<br>" + "\n" + "<div class=\"holdback\">" + "\n" + "\t" + "<button type=\"button\" class=\"collapsible\">");
		System.out.print("\n" + "\t" + "\t" + "<span style=\"font-weight:bold; font-size: 18px;\">");
		System.out.print("\n" + "\t" + "\t" + "\t" + (levl-1) + ". ");
		for (int j = 0; j < celltype.length - 2; j++) {
			System.out.print(celltype[j]);
			if (j != celltype.length - 3) {
				System.out.print(" ");
			}
		}
		System.out.print("</span>" + "\n" + "\t" + "\t" + "\t" + "<span style=\"font-style: oblique; font-size: 14px;\">");
		System.out.print("   ");
		/*
		for (int j = celltype.length - 2; j < celltype.length; j++) {
			System.out.print(" ");
			System.out.print(celltype[j]);
		}
		*/
		float lava = (float) levl;
		double score = Math.round(((6000 / (lava + 23)) - 40) * 10.0) / 10.0; 
		//score = Math.round((score + (-0.00015*(lava-50)*(lava-50)+0.5))*100.0)/100.0;
		score = score + Math.round(((0.0025 * lava) + 0.2) * 10.0) / 10.0;
		int tmep = (int) (score *10);
		score = Math.round((double)tmep/10);
		if (lava == 2) {
			score = 200.00;
		}
		System.out.print("(~" + score + " points)");
		System.out.print("</span>");
		System.out.print("\n" + "\t" + "\t" + "\t" + "<svg id=\"quan\" style=\"display: block;  transform: rotate(0deg);\">");
		System.out.print("\n" + "\t" + "\t" + "\t" + "\t" + "<path d=\"M5.41 7.59L4 9l8 8 8-8-1.41-1.41L12 14.17\"></path>");
		System.out.print("\n" + "\t" + "\t" + "\t" + "</svg>" + "\n" + "\t" + "\t" + "</button>");
		System.out.print("\n" + "\t" + "<div class=\"content\">" + "\n" + "\t" + "\t" + "<ul class=\"statlist\">");
	}
	
	public static void pink2(String[] celltype, String cellValue) {
		System.out.print("\n" + "\t" + "\t" + "\t" + "<li><p class='mes lipad'>");
		char cha = cellValue.charAt(cellValue.length() - 1);
		//System.out.print(checker);
		if (cha != ')') {
			System.out.print("<strong>");
			for (int j = 0; j < celltype.length - 2; j++) {
				System.out.print(celltype[j]);
				if (j < celltype.length - 4) {
					System.out.print(" ");
				}
			}
			System.out.print("</strong> - ");
			System.out.print("<a class='mes lipad' href='");
			System.out.print(celltype[celltype.length - 1]);
			System.out.print("'>");
			System.out.print(celltype[celltype.length - 1]);
			System.out.print("</a>" + "\n" + "\t" + "\t" + "\t" + "\t" + "</p></li>");
		} else {
			for (int j = 0; j < celltype.length - 2; j++) {
				System.out.print(celltype[j]);
				System.out.print(" ");
			}
			System.out.print("<a class='mes lipad' href='");
			System.out.print(celltype[celltype.length - 2]);
			System.out.print("'>");
			System.out.print(celltype[celltype.length - 2]);
			System.out.print("</a>" + "\n" + "\t" + "\t" + "\t" + "\t" + "<span>   ");
			System.out.print(celltype[celltype.length - 1]);
			System.out.print("</span></p></li>");
		}
	}
}