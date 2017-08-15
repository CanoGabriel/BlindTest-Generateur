import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanneauInput extends JPanel{
	public PanneauInput() {
		this.setLayout(new GridLayout(2,1));

		JPanel haut = new JPanel(),bas = new JPanel();

		haut.setLayout(new GridLayout(4, 1));
		JPanel haut_l1 = new JPanel(),
				haut_l2 = new JPanel(),
				haut_l3 = new JPanel(),
				haut_l4 = new JPanel();
		haut.add(haut_l1);
		haut.add(haut_l2);
		haut_l2.setBackground(Color.CYAN);
		haut.add(haut_l3);
		haut.add(haut_l4);
		haut_l4.setBackground(Color.CYAN);

		bas.setLayout(new GridLayout(1, 2));

		JPanel bas_gauche = new JPanel(),
				bas_droit = new JPanel();
		bas.add(bas_gauche);
		bas_gauche.setBackground(Color.GRAY);
		bas.add(bas_droit);
		bas_droit.setLayout(new GridLayout(5, 1));

		JPanel bas_droit_l1 = new JPanel(),
				bas_droit_l2 = new JPanel(),
				bas_droit_l3 = new JPanel(),
				bas_droit_l4 = new JPanel(),
				bas_droit_l5 = new JPanel();
		bas_droit.add(bas_droit_l1);
		bas_droit_l1.setBackground(Color.GREEN);
		bas_droit.add(bas_droit_l2);
		bas_droit.add(bas_droit_l3);
		bas_droit_l3.setBackground(Color.GREEN);
		bas_droit.add(bas_droit_l4);
		bas_droit.add(bas_droit_l5);
		bas_droit_l5.setBackground(Color.GREEN);

		this.add(haut);
		this.add(bas);
		
		haut_l1.add(new JLabel("Intitulé du Site"));
		JTextField h2 = new JTextField();
		h2.setColumns(20);
		//h2.setS
		//haut_l2.add(h2);
	}

}
