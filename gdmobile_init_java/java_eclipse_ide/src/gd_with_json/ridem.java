package gd_with_json;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ridem {
	public static void main(String[] args) throws NoSuchElementException {
		double[] nums = {718.8400000000001, 1067.56, 2280.0999999999995, 
				1927.6000000000001, 9.4, 231.79999999999998, 138.79999999999998};
		for (int r = 0; r < nums.length; r++) {
			double hold = nums[r];
			hold = Math.round(Math.floor(hold*100));
			System.out.print(hold + " ");
			int re = (int) hold;
			System.out.print(re + " ");
			hold = ((double) re) / 100;
			System.out.println(hold);
		}
		for (int rrr = 0; rrr < nums.length; rrr++) {
			double hold = nums[rrr];
			hold = Math.round(Math.floor(hold*100));
			int re = (int) hold;
			hold = Math.round(re / 10);
			hold = (double) re / 10;
			System.out.println(hold + " ");
		}
		
		int levl = 0;
		Scanner freader;
		String[] files = new String[143];
		String follder = "C:\\Users\\User\\eclipse-workspace\\gd_with_json\\";
		File iprex = new File(follder + "g.json");
		try {
			freader = new Scanner(iprex, "UTF-8");
			while (freader.hasNextLine()) {
				String data = freader.nextLine();
				files[levl] = data;
				levl++;
			}
			freader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		levl = 0;
		for (int p = 0; p < 142; p++) {
			File temp = new File(files[p]);	
			temp.delete();
		}
	}
}

