import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
@SuppressWarnings("serial")
public class Fenetre extends JFrame implements ActionListener{
	private JPanel IHM1 = new JPanel();
	private JPanel IHM2 = new JPanel();

	private JPanel IHM1_north		= new JPanel();
	private JPanel IHM1_north_l1	= new JPanel();
	private JPanel IHM1_north_l2	= new JPanel();
	private JPanel IHM1_north_l3	= new JPanel();
	private JPanel IHM1_center		= new JPanel();
	private JPanel IHM1_south		= new JPanel();
	private JPanel IHM1_south_l1	= new JPanel();
	private JPanel IHM1_south_l2	= new JPanel();
	private JPanel IHM1_south_l3	= new JPanel();
	private JPanel IHM1_south_l3_c1	= new JPanel();
	private JPanel IHM1_south_l3_c2	= new JPanel();
	
	private JPanel IHM2_north = new JPanel();
	private JPanel IHM2_center = new JPanel();
	private JPanel IHM2_south = new JPanel();
	private JPanel IHM2_south_c1 = new JPanel();
	private JPanel IHM2_south_c2 = new JPanel();
	private JPanel IHM2_north_l1 = new JPanel();
	private JPanel IHM2_north_l2= new JPanel();

	private JTextField IHM1_txt_titre = new JTextField();
	private JTextField IHM1_txt_videoPath = new JTextField();
	private JTextField IHM1_txt_nom = new JTextField();
	private JTextField IHM1_txt_audioPath = new JTextField();
	private JTextField IHM1_txt_sitePath = new JTextField();

	private Boutton IHM1_btn_suivant = new Boutton("Suivant");
	private Boutton IHM1_btn_ok = new Boutton("ok");
//	private Boutton IHM1_btn_nom = new Boutton("ok");
	private Boutton IHM1_btn_aud_nom = new Boutton("ok");
	
	private JLabel IHM2_lab_titre = new JLabel();
	private JLabel IHM2_lab_VPath = new JLabel();
	
	private JButton IHM2_btn_valider = new Boutton("Valider");
	private JButton IHM2_btn_precedent = new Boutton("Precedent");
	

	private JTree arbre;
	private JTable tableau;

	private Donnee data = new Donnee();
	public Fenetre() {
		this.setContentPane(new JPanel());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 300);
		this.setTitle("Fenetre par defaut");
		this.setLocationRelativeTo(null);

		this.setVisible(true);
	}

	public Fenetre(String titre, int width,int height) {
		super();
		initIHM1();
		initIHM2();
		this.setContentPane(this.IHM1);
		
		IHM1_btn_ok.addActionListener(this);
		IHM1_btn_aud_nom.addActionListener(this);
//		IHM1_btn_nom.addActionListener(this);
		IHM1_btn_suivant.addActionListener(this);
		IHM2_btn_precedent.addActionListener(this);
		IHM2_btn_valider.addActionListener(this);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setTitle(titre);
		this.setLocationRelativeTo(null);
		this.setResizable(true);

		this.setVisible(true);
	}

	private void initIHM1() {
		//Instantiation des diffï¿½rents composants de la fenetre

		//Attribution des Layouts
		IHM1.			setLayout(new BorderLayout());
		IHM1_north.		setLayout(new GridLayout(3, 1));
		IHM1_north_l1.	setLayout(new BorderLayout());
		IHM1_north_l2.	setLayout(new BorderLayout());
		IHM1_north_l3.	setLayout(new BorderLayout());
		IHM1_center.	setLayout(new BorderLayout());
		IHM1_south.		setLayout(new GridLayout(3, 1));
		IHM1_south_l1.	setLayout(new BorderLayout());
		IHM1_south_l2.	setLayout(new BorderLayout());
		IHM1_south_l3.	setLayout(new GridLayout(1, 2));

		//Placement des ï¿½lï¿½ments dans leur conteneur
		IHM1_north_l1.add(IHM1_txt_titre, BorderLayout.CENTER);
		IHM1_north_l2.add(IHM1_txt_sitePath, BorderLayout.CENTER);
		IHM1_north_l3.add(IHM1_txt_videoPath, BorderLayout.CENTER);
		IHM1_south_l1.add(IHM1_txt_nom, BorderLayout.CENTER);
//		IHM1_south_l1.add(IHM1_btn_nom, BorderLayout.EAST);
		IHM1_south_l2.add(IHM1_txt_audioPath, BorderLayout.CENTER);
		IHM1_south_l2.add(IHM1_btn_aud_nom, BorderLayout.EAST);
		IHM1_south_l3_c1.add(IHM1_btn_ok);
		IHM1_south_l3_c2.add(IHM1_btn_suivant);
		
		//Agencement des conteneurs
		IHM1.add(IHM1_north, BorderLayout.NORTH);
		IHM1.add(IHM1_center, BorderLayout.CENTER);
		IHM1.add(IHM1_south, BorderLayout.SOUTH);
		
		IHM1_north.add(IHM1_north_l1, BorderLayout.CENTER);
		IHM1_north.add(IHM1_north_l2, BorderLayout.CENTER);
		IHM1_north.add(IHM1_north_l3, BorderLayout.CENTER);

		IHM1_south.add(IHM1_south_l1, BorderLayout.CENTER);
		IHM1_south.add(IHM1_south_l2, BorderLayout.CENTER);
		IHM1_south.add(IHM1_south_l3, BorderLayout.CENTER);
		
		IHM1_south_l3.add(IHM1_south_l3_c1);
		IHM1_south_l3.add(IHM1_south_l3_c2);
		
		buildDefaultTree(IHM1_center);
		
		//Gestion du rendu
		IHM1_txt_titre.		setBorder(BorderFactory.createTitledBorder("Intitule du site :"));
		IHM1_txt_videoPath.	setBorder(BorderFactory.createTitledBorder("Chemin vers le dossier contenant les videos :"));
		IHM1_txt_nom.		setBorder(BorderFactory.createTitledBorder("Rï¿½ponse associe à la video :"));
		IHM1_txt_audioPath.	setBorder(BorderFactory.createTitledBorder("Chemin vers l'audio de la video associe e la video :"));
		IHM1_txt_sitePath.	setBorder(BorderFactory.createTitledBorder("Chemin vers l'emplacement qui contiendra le dossier du site :"));

	}
	
	private void initIHM2() {
		//Attribution des Layouts
		IHM2.			setLayout(new BorderLayout());
		IHM2_north.		setLayout(new GridLayout(2, 1));
		IHM2_south.		setLayout(new GridLayout(1, 2));
		IHM2_north_l1.	setLayout(new BorderLayout());
		IHM2_north_l2.	setLayout(new BorderLayout());
		IHM2_center.	setLayout(new BorderLayout());
		IHM2_south_c1.	setLayout(new BorderLayout());
		IHM2_south_c2.	setLayout(new BorderLayout());
		
		//Placement des ï¿½lï¿½ments dans leur conteneur
		IHM2_north_l1.add(IHM2_lab_titre, BorderLayout.CENTER);
		IHM2_north_l2.add(IHM2_lab_VPath, BorderLayout.CENTER);
		
		IHM2_south_c1.add(IHM2_btn_precedent);
		IHM2_south_c2.add(IHM2_btn_valider);
		
		buildTab(IHM2_center);
		
		//Agencement des conteneurs		
		IHM2.add(IHM2_north, BorderLayout.NORTH);
		IHM2.add(IHM2_center, BorderLayout.CENTER);
		IHM2.add(IHM2_south, BorderLayout.SOUTH);
		IHM2_north.add(IHM2_north_l1);
		IHM2_north.add(IHM2_north_l2);
		
		IHM2_south.add(IHM2_south_c1);
		IHM2_south.add(IHM2_south_c2);
		
		//Gestion du rendu
		IHM2_north.setPreferredSize(new Dimension(this.getWidth(), 100));
		
		IHM2_lab_titre.setBorder(BorderFactory.createTitledBorder("Titre :"));
		IHM2_lab_VPath.setBorder(BorderFactory.createTitledBorder("Emplacement du dossier qui contiandra le site :"));
		
//		IHM2_north.setPreferredSize(new Dimension(this.getWidth(), 100));
//		IHM2_south.setPreferredSize(new Dimension(this.getWidth(), 50));
	}

	private void buildDefaultTree(JPanel pan) {
		//Crï¿½ation d'une racine
		DefaultMutableTreeNode racine = new DefaultMutableTreeNode("");
		//Nous crï¿½ons, avec notre hiï¿½rarchie, un arbre
		arbre = new JTree(racine);
		arbre.setRootVisible(false);
		IHM1_center.removeAll();
		IHM1_center.add(new JScrollPane(arbre), BorderLayout.CENTER);
		actualiser();
	}
	private void buildTree(String path) {
		System.out.println("path :"+path);
		DefaultMutableTreeNode racine = new DefaultMutableTreeNode(path);

		data.initData(path, IHM1_txt_titre.getText());
		Video vid = null;
		for (int i = 0 ;i < data.videoList.size(); i++) {
			racine.add(new DefaultMutableTreeNode(data.videoList.get(i).VidNomExt));
			//			System.out.println(f.getName());
		}
		arbre = new JTree(racine);
		arbre.setRootVisible(false);
		arbre.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				// TODO Auto-generated method stub
				Video vid = null;
				data.idVideo = data.chercher(arbre.getLastSelectedPathComponent().toString());
				if(data.idVideo != -1)
					vid = data.videoList.get(data.idVideo);
				IHM1_txt_audioPath.setText(vid.audioPath);
				IHM1_txt_nom.setText(vid.nom);
				data.curVideo = vid;
				
//				IHM1_btn_nom.setEnabled(true);
				IHM1_txt_nom.setEnabled(true);
				IHM1_btn_aud_nom.setEnabled(true);
				IHM1_txt_audioPath.setEnabled(true);
			}
		});
		IHM1_center.removeAll();
		IHM1_center.add(new JScrollPane(arbre), BorderLayout.CENTER);
		actualiser();
	}
	
	@SuppressWarnings("rawtypes")
	private void buildTab(JPanel pan) {
		Vector<String> titre = new Vector<String>();
		titre.addElement("Video");
		titre.addElement("Audio");
		titre.addElement("Rï¿½ponse");
		
		Vector<Vector> d = new Vector<Vector>();
		Vector<String> val;
		for(int i = 0 ; i < data.videoList.size();i++) {
			Video vid = data.videoList.get(i);
			val = new Vector<String>();
			val.addElement(vid.VidNomExt);
			val.addElement(vid.AudNomExt);
			val.addElement(vid.nom);
			d.addElement(val);
		}
		tableau = new JTable(d,titre);
		pan.removeAll();
		pan.add(new JScrollPane(tableau), BorderLayout.CENTER);
		actualiser();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == IHM1_btn_ok) {
			data.videoDirectoryPath = ""+IHM1_txt_videoPath.getText();
			data.webTitle = ""+IHM1_txt_titre.getText();
			data.sitePath = ""+IHM1_txt_sitePath.getText();
			buildTree(IHM1_txt_videoPath.getText());
			IHM1_btn_aud_nom.setEnabled(false);
//			IHM1_btn_nom.setEnabled(false);
			
			IHM1_txt_audioPath.setText("");
			IHM1_txt_nom.setText("");
		}
		
		if(arg0.getSource() == IHM1_btn_aud_nom) {
			data.curVideo.audioPath = IHM1_txt_audioPath.getText();
			data.curVideo.nom = IHM1_txt_nom.getText();
			System.out.println(data.curVideo.audioPath);
			data.actualiserVList();
		}
//		if(arg0.getSource() == IHM1_btn_nom) {
//			data.curVideo.nom = IHM1_txt_nom.getText();
//			System.out.println(data.curVideo.nom);
//			data.actualiserVList();
//		}
		
		if(arg0.getSource() == IHM1_btn_suivant) {
			IHM2_lab_titre.setText(data.webTitle);
			IHM2_lab_VPath.setText(data.sitePath);
			buildTab(IHM2_center);
			setContentPane(IHM2);
			actualiser();
		}
		
		if(arg0.getSource() == IHM2_btn_precedent) {
			setContentPane(IHM1);
			actualiser();
		}
		
		if(arg0.getSource() == IHM2_btn_valider) {
			data.createSite();
		}
		//System.out.println("debug : "+IHM1_txt_videoPath.getText());
	}
	
	private void actualiser() {
		this.repaint();
		this.revalidate();
	}
	private class Boutton extends JButton implements MouseListener{
		public Boutton(String s) {
			super(s);
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}
}
