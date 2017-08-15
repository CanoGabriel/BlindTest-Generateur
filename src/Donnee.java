import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class Donnee {
	public String videoDirectoryPath = "";
	public String webTitle = "";
	public String sitePath = "";
	public ArrayList<Video> videoList = new ArrayList<Video>();

	public Video curVideo = null;
	public int idVideo = -1;

	public void initData(String Vpath,String title) {
		videoDirectoryPath = Vpath;
		webTitle = title;
		while(! videoList.isEmpty())
			videoList.remove(0);
		System.gc();
		
		File[] files = null; 
		File directoryToScan = new File(Vpath);
		files = directoryToScan.listFiles();
		int i = 0;
		for(File f : files) {
			videoList.add(new Video(f, f, i));
			i++;
		}
	}
	
	public int chercher(String nom) {
		Video i;
		int j;
		for(j = 0; j < videoList.size() ; j++) {
			i = videoList.get(j);
			if(nom.equals(i.VidNomExt))
				break;
		}
		if(j == videoList.size())
			return -1;
		return j;
	}
	
	public void actualiserVList() {
		if(idVideo != -1 && idVideo < videoList.size())
			videoList.set(idVideo, curVideo);
	}
	
	public void buildDirectory() {
		String siteDir =sitePath+"/"+webTitle ;
		File dir = new File(siteDir);
		if(dir.mkdirs())
		{
			String htmlDir = siteDir+"/"+"htmlContent";
			String imgDir = siteDir+"/"+"imgContent";
			String mediaDir = siteDir+"/"+"mediaContent";
			File html =		new File(htmlDir),
				 img = 		new File(imgDir),
				 media = 	new File(mediaDir);
			html.mkdir();
			img.mkdir();
			media.mkdir();
			copierFichier(new File("sommaire.css"), new File(siteDir+"/sommaire.css"));
			copierFichier(new File("script.js"), new File(htmlDir+"/script.js"));
			copierFichier(new File("style.css"), new File(htmlDir+"/style.css"));
			copierFichier(new File("paper.jpg"), new File(siteDir+"/paper.jpg"));
			copierFichier(new File("paper.jpg"), new File(htmlDir+"/paper.jpg"));
		}
	}
	
	public boolean copierFichier(File source, File dest) { 
	    try (InputStream sourceFile = new java.io.FileInputStream(source);  
	            OutputStream destinationFile = new FileOutputStream(dest)) { 
	        // Lecture par segment de 0.5Mo  
	        byte buffer[] = new byte[512 * 1024]; 
	        int nbLecture; 
	        while ((nbLecture = sourceFile.read(buffer)) != -1){ 
	            destinationFile.write(buffer, 0, nbLecture); 
	        } 
	    } catch (IOException e){ 
	        e.printStackTrace(); 
	        return false; // Erreur 
	    } 
	    return true; // Résultat OK   
	}
	
	public boolean deplacerFichier(File source, File destination) { 
	    if (!destination.exists()) { 
	        // On essaye avec renameTo() 
	        boolean result = source.renameTo(destination); 
	        if (!result) { 
	            // On essaye de copier. 
	            result = true; 
	            result &= copierFichier(source, destination); 
	            // Puis d'effacer. 
	            if (result) { 
	                result &= source.delete(); 
	            } 
	        } 
	        return result; 
	    } 
	    // Si le fichier destination existe, on annule... 
	    return false; 
	}
	//preciser l'extension '.html'
	public void createPage(String name, String ongletTitre, String pageTitre, String sourceImg, String sourceAudio, String formatAudio, String sourceVideo, String formatVideo, String titreChanson    , String lienPrecedent, String lienSommaire, String lienSuivant) throws IOException{
	   	 File f = new File(name);
	   	 String [] html = new String[12];
	   	 //Initialisation
	   	 html[0] = "<!DOCTYPE htlm>\n<htlm>\n\t<head>\n\t\t<title>";
	   	 html[1] = "</title>\n\t\t<meta charset=\"utf-8\">\n\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"/>\n\t</head>\n\t<body>\n\t\t<h1>";
	   	 html[2] = "</h1>\n\t\t<ul>\n\t\t\t<li class=\"hidden onglet1\">Audio</li>\n\t\t\t<li class=\"hidden onglet2\">Video</li>\n\t\t\t<li class=\"hidden onglet3\">Reponse</li>\n\t\t</ul>\n\t\t<div class=\"content\">\n\t\t\t<div class=\"hidden block1\">\n\t\t\t\t<div>\n\t\t\t\t\t<img src=\"";
	   	 html[3] = "\">\n\t\t\t\t\t<audio controls>\n\t\t\t\t\t\t<source src=\"";
	   	 html[4] = "\" type=\"audio/";
	   	 html[5] = "\">\n\t\t\t\tYour browser does not support the audio element..\n\t\t\t\t\t</audio>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t<div class=\"hidden block2\">\n\t\t\t\t<video width=\"1920\" controls>\n\t\t\t\t\t<source src=\"";
	   	 html[6] = "\" type=\"video/";
	   	 html[7] = "\">\n\t\t\tYour browser does not support the video element.\n\t\t\t\t</video>\n\t\t\t</div>\n\t\t\n\t\t\t<div class=\"hidden block3\"><p>";
	   	 html[8] = "</p></div> \n\t\t</div>\n\t\t<div id=\"footer\">\n\t\t\t<ul>\n\t\t\t\t<li><a href=\"";
	   	 html[9] = "\">precedent</a></li>\n\t\t\t\t<li><a href=\"";
	   	 html[10] = "\">sommaire</a></li>\n\t\t\t\t<li><a href=\"";
	   	 html[11] = "\">suivant</a></li>\n\t\t\t</ul>\n\t\t</div>\n\t\t<script src=\"script.js\" type=\"text/javascript\"></script>\n\t</body>\n</htlm>";
	   	 
	   	 //Ecriture du fichier
	   	 FileWriter fw = new FileWriter(f);
	   	 BufferedWriter out = new BufferedWriter(fw);
	   	 
	   	 out.write(html[0]);
	   	 out.write(ongletTitre);
	   	 
	   	 out.write(html[1]);
	   	 out.write(pageTitre);

	   	 out.write(html[2]);
	   	 out.write(sourceImg);
	   	 
	   	 out.write(html[3]);
	   	 out.write(sourceAudio);
	   	 
	   	 out.write(html[4]);
	   	 out.write(formatAudio);
	   	 
	   	 out.write(html[5]);
	   	 out.write(sourceVideo);
	   	 
	   	 out.write(html[6]);
	   	 out.write(formatVideo);
	   	 
	   	 out.write(html[7]);
	   	 out.write(titreChanson);
	   	 
	   	 out.write(html[8]);
	   	 out.write(lienPrecedent);
	   	 
	   	 out.write(html[9]);
	   	 out.write(lienSommaire);
	   	 
	   	 out.write(html[10]);
	   	 out.write(lienSuivant);
	   	 
	   	 out.write(html[11]);
	   	 
	   	 out.close();
	    }
	public void createSommaire() {
		File f = new File(sitePath+webTitle+"/sommaire.html");
		String debut = "<!DOCTYPE html>\n<!DOCTYPE html>\n<html>\n<head>\n\t<title>Sommaire</title>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"sommaire.css\"/>\n</head>\n\t<body>\n\t\t<h1 id=\"titre\">"
				+ webTitle+" : Sommaire"+"</h1>\n\t\t<ul>";
		String fin = "\t\t</ul>\n\t</body>\n</html>";
		String ouvert = "\n\t\t\t<li>\n\t\t\t<a href=\"";
		//lien page
		String milieu = "\"><img src=\"";
		//lien image carre sommaire
		String ferme ="\"></a>\n\t\t\t</li>\n";

		//Ecriture du fichier
		FileWriter fw;
		try {
			fw = new FileWriter(f);

			BufferedWriter out = new BufferedWriter(fw);

			out.write(debut);

			for(int i = 1 ; i <= videoList.size() ; i++) {
				out.write(ouvert);
				out.write("htmlContent/"+i+".html");
				out.write(milieu);
				out.write("imgContent/carre_"+i+".jpg");
				out.write(ferme);
			}

			out.write(fin);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void generateImg() {
		ImageCreator ip = new ImageCreator();
		String path = sitePath;
		if(sitePath.charAt(sitePath.length()-1)!= '\\' && sitePath.charAt(sitePath.length()-1) != '/')
			path += "/";
		path +=webTitle+"/imgContent/";
		System.out.println(path);
		for(int i = 1;  i <= videoList.size();i++) {
			ip.createSize(path+"carre_"+i+".jpg", ""+i, 500, 500);
			ip.create(path+i+".jpg", "No "+i);
		}
	}
	
	public void createSite() {
		buildDirectory();
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		generateImg();
		createSommaire();
		String path = sitePath+"/"+webTitle;
		for(int i = 1 ; i <= videoList.size();i++) {
			Video vid = videoList.get(i-1);
			copierFichier(new File(vid.videoPath), new File(path+"/mediaContent/"+vid.VidNomExt));
			vid.videoPath = path+"/mediaContent/"+vid.VidNomExt;
			File temp = new File(vid.audioPath);
			if(temp.exists()) {
				copierFichier(temp, new File(path+"/mediaContent/"+vid.AudNomExt));
				vid.audioPath = path+"/mediaContent/"+vid.AudNomExt;
			}
			try {
				if(i==1)
					createPage(path+"/htmlContent/" + i+".html", ""+i, webTitle+" : no "+i, path+"/imgContent/"+i+".jpg", vid.audioPath, "mpeg", vid.videoPath, "webm", vid.nom, "#", "../sommaire.html", (i+1)+".html");
				else if(i== videoList.size())
					createPage(path+"/htmlContent/" + i+".html", ""+i, webTitle+" : no "+i, path+"/imgContent/"+i+".jpg", vid.audioPath, "mpeg", vid.videoPath, "webm", vid.nom, (i-1)+".html", "../sommaire.html", "#");
				else
					createPage(path+"/htmlContent/" + i+".html", ""+i, webTitle+" : no "+i, path+"/imgContent/"+i+".jpg", vid.audioPath, "mpeg", vid.videoPath, "webm", vid.nom, (i-1)+".html", "../sommaire.html", (i+1)+".html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
