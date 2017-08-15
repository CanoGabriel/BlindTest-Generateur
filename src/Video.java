import java.io.File;

public class Video {
	public String nom;
	public String VidNomExt;
	public String AudNomExt;
	public String videoPath;
	public String audioPath;
	public boolean videoToConv;                                                   //vrai si doit être convcerti
	public boolean audioToConv;                                                   //idem                       

	public Video(File video,File audio,int id) {
		String temp [] = video.getName().split("[.]");

		nom = temp[(temp.length == 1)?0:temp.length-2];
		VidNomExt = video.getName();
		videoPath = video.getAbsolutePath();
		audioPath = audio.getAbsolutePath();
		AudNomExt = audio.getName();
		
		formatCheck("webm","mp3");
		
	}

	public Video(File v) {
		videoPath = v.getAbsolutePath();
		audioPath = v.getAbsolutePath();
		nom = convertPathToName(v.getAbsolutePath());
		VidNomExt = v.getName();
		AudNomExt = v.getName();
		formatCheck("webm","webm");
		
	}

	public String getNom() {
		return nom;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public String getAudioPath() {
		return audioPath;
	}

	private String replaceSpace(String str) {
		String out = "";
		for (int i = 0; i< str.length(); i++)
			out += (str.charAt(i) =='_')?' ':str.charAt(i);
		return out;
	}

	private String convertPathToName(String path) {
		if(path.contains("/")) {
			String [] parts = path.split("/");
			if(parts[parts.length - 1].contains(".")) {
				String [] parts2 = parts[parts.length - 1].split("[.]");
				return replaceSpace(parts2[parts2.length - 2]);
			}
			return replaceSpace(parts[parts.length - 1]);
		}
		return replaceSpace(path);
	}

	private void formatCheck(String Vext, String Aext) {
		//pour la video
		if(videoPath.contains(".")) {
			String [] parts = videoPath.split("[.]");
			videoToConv = (parts[parts.length - 1].equals(Vext));
		}
		//pour l'audio
		if(audioPath.contains(".")) {
			String [] parts = audioPath.split("[.]");
			audioToConv = (parts[parts.length - 1].equals(Aext));
		}
	}
	
	public String toString2() {
		return nom+"\n"+videoPath+"\n"+videoToConv+"\n"+audioPath+"\n"+audioToConv;
	}
	public String toString() {
		return nom;
	}
}
