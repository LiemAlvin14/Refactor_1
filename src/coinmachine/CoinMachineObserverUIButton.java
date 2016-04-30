package coinmachine;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * 
 * @author Clunctia
 *
 */

public class CoinMachineObserverUIButton extends JFrame implements Observer{
	private CoinMachine machine;
	private JLabel status;
	private JLabel balance;
	private JProgressBar progressBar;
	private JButton oneBahtCoin;
	private JButton fiveBahtCoin;
	private JButton tenBahtCoin;
	private TitledBorder title;
	
	/**
	 * Initial coin machine ui.
	 * @param machine add coin machine to Observer.
	 */
	public CoinMachineObserverUIButton( CoinMachine machine ) {
		this.machine = machine;
		this.setTitle("Coin Machine");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initComponent();
	}
	
	/**
	 * initial gui set up all parameter and action listener
	 */
	private void initComponent() {
		JPanel window = new JPanel();
		window.setLayout(new BorderLayout());
		JPanel containerLabel = new JPanel();
		containerLabel.setLayout( new FlowLayout() );
		JPanel containerButton = new JPanel();
		containerButton.setLayout( new FlowLayout() );
		
		balance = new JLabel( String.format( "Balance: %d", machine.getBalance() ) );
		balance.setForeground(Color.GREEN);
		status = new JLabel("Status: ");
		
		title = BorderFactory.createTitledBorder("Insert Money");
		containerButton.setBorder(title);
		
		ImageIcon oneBaht = new ImageIcon(CoinMachineObserverUIButton.class.getResource("/images/1baht.png"));
		oneBahtCoin = new JButton(oneBaht);
		ImageIcon fiveBaht = new ImageIcon(CoinMachineObserverUIButton.class.getResource("/images/5baht.png"));
		fiveBahtCoin = new JButton(fiveBaht);
		ImageIcon tenBaht = new ImageIcon(CoinMachineObserverUIButton.class.getResource("/images/10baht.png"));
		tenBahtCoin = new JButton(tenBaht);
		
		
		progressBar = new JProgressBar( 0, 10 );
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.GREEN);
		
		containerLabel.add(balance);
		containerLabel.add(status);
		containerLabel.add(progressBar);
		containerButton.add(oneBahtCoin);
		containerButton.add(fiveBahtCoin);
		containerButton.add(tenBahtCoin);
		
		window.add(containerLabel, BorderLayout.NORTH);
		window.add(containerButton, BorderLayout.CENTER);
		
		OneBahtCoinListener addOneBaht = new OneBahtCoinListener();
		oneBahtCoin.addActionListener(addOneBaht);
		FiveBahtCoinListener addFiveBaht = new FiveBahtCoinListener();
		fiveBahtCoin.addActionListener(addFiveBaht);
		TenBahtCoinListener addTenBaht = new TenBahtCoinListener();
		tenBahtCoin.addActionListener(addTenBaht);
		
		
		this.add(window);
	}
	
	/**
	 * run gui
	 */
	public void run(){
		this.pack();
		this.setVisible(true);
	}
	
	/**
	 * Change balance and increase progress bar.
	 * @param subject
	 * @param info
	 */
	@Override
	public void update(Observable subject, Object info) {
		if( info != null && info instanceof List ){
			balance.setText( String.format("Balance: %d", machine.getBalance() ) );
			progressBar.setValue( machine.getCount() );
		}
	}
	
	/**
	 * 
	 * @author Clunctia
	 *Listener class for one baht button to increase coin in machine.
	 */
	class OneBahtCoinListener implements ActionListener {
		public void actionPerformed ( ActionEvent evt ){
			Coin oneBaht = new Coin(1);
			machine.insert(oneBaht);
		}
	}
	
	/**
	 * 
	 * @author Clunctia
	 *Listener class for five baht button to increase coin in machine.
	 */
	class FiveBahtCoinListener implements ActionListener {
		public void actionPerformed ( ActionEvent evt ){
			Coin fiveBaht = new Coin(5);
			machine.insert(fiveBaht);
		}
	}
	
	/**
	 * 
	 * @author Clunctia
	 *Listener class for ten baht button to increase coin in machine.
	 *
	 */
	class TenBahtCoinListener implements ActionListener {
		public void actionPerformed ( ActionEvent evt ){
			Coin tenBaht = new Coin(10);
			machine.insert(tenBaht);
		}
	}
	
}
