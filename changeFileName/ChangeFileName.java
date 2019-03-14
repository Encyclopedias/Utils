import java.io.File;

public class ChangeFileName{

	/*
	 * srcPath is the path of file
	 * 
	 * commonName is the common name after editing. Eg. if commonName is
	 * "Miao",the name will
	 * 
	 * be "Miao_1,Miao_2,Miao_3,...."
	 *
	 */
	public static void changeFileName(String srcPath, String commonName) {

		if(srcPath == null || srcPath.length() == 0)
			System.out.println("srcPath can not be empty");
		
		// get all file name by srcPath
		File file = new File(srcPath);

		if (file.exists()) {
			// the files contains the directory name ,so we have to judge
			String[] files = file.list();
			int counter = 1;
			for (String fileName : files) {

				File fileBefore = new File(srcPath + fileName);
				// get the format of file

				if (fileBefore.isFile()) {
					String format = fileName.substring(fileName.lastIndexOf("."), fileName.length());
					File fileAfter = new File(srcPath + commonName + counter + format);
					fileBefore.renameTo(fileAfter);
					counter++;
				} else
					continue;
			}
		} else {
			System.out.println("Not find Directory");
		}
		System.out.println("All fileNames modify successfully");

	}
}
