import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class KolokwiumFunkcjaLiniowa  extends JFrame implements ActionListener {
	
	// y=ax+b
	
	JTextField wartosc_a;
	JTextField wartosc_b;
	JTextField wartosc_x;
	JButton oblicz;
	JLabel wartosc_koncowa_y;

	public static void main(String[] args) {
		KolokwiumFunkcjaLiniowa frame = new KolokwiumFunkcjaLiniowa();
		frame.initUI();
	}

	private void initUI() {
		
		wartosc_a = new JTextField("Podaj wspó³czynnik kierunkowy a: ");
		wartosc_b = new JTextField("Podaj wyraz wolny b: ");
		wartosc_x = new JTextField("Podaj argument x: ");
		oblicz = new JButton("Oblicz wartoœæ funkcji dla podanych wartoœci!");
		oblicz.addActionListener(this);
		wartosc_koncowa_y = new JLabel();
		
		
		this.add(wartosc_a);
		this.add(wartosc_b);
		this.add(wartosc_x);
		this.add(oblicz);
		this.add(wartosc_koncowa_y);
		
		this.setLayout(new GridLayout(5, 1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(400, 600);
		this.setVisible(true);
		this.setTitle("Funkcja Liniowa");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(oblicz.equals(e.getSource())) {
			obliczFunkcje();
		}
		
	}

	private void obliczFunkcje() {
		
		try {
		String pole_liczba_a = wartosc_a.getText();
		double podanaLiczba_a = Double.parseDouble(pole_liczba_a);
		
		String pole_liczba_b = wartosc_b.getText();
		double podanaLiczba_b = Double.parseDouble(pole_liczba_b);
		
		String pole_liczba_x = wartosc_x.getText();
		double podanaLiczba_x = Double.parseDouble(pole_liczba_x);
		
		double wartosc_y = (double) podanaLiczba_a*podanaLiczba_b+podanaLiczba_x; 
		wartosc_koncowa_y.setText("Wartoœæ funkcji dla podanych parametrów to: " + String.valueOf(wartosc_y));
		
		if(wartosc_a.getText().isEmpty()) {
			wartosc_koncowa_y.setText("Proszê podaæ poprawne dane");
		}
		
		if(wartosc_b.getText().isEmpty()) {
			wartosc_koncowa_y.setText("Proszê podaæ poprawne dane");
		}
		
		if(wartosc_x.getText().isEmpty()) {
			wartosc_koncowa_y.setText("Proszê podaæ poprawne dane");
		}
		
	} catch(NumberFormatException e1) {
		wartosc_koncowa_y.setText("Wprowadz liczby!");
	}
		
	}
}
