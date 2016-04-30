package coinmachine;

import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * 
 * @author Clunctia
 *
 */
public class CoinMachineObserverUI extends JFrame implements Observer {
	private JLabel showStatus,coins;
	private JTextField showCoins;
	private CoinMachine machine;
	
	
	/**
	 * initial coin machine ui
	 * @param machine add coin machine to Observer.
	 */
	public CoinMachineObserverUI( CoinMachine machine ) {
		this.machine = machine;
		this.setTitle("Coin Machine status");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initComponent();
	}
	
	/**
	 * initial GUI
	 */
	private void initComponent() {
		JPanel container = new JPanel();
		container.setLayout( new BorderLayout() );
		
		JPanel containerUpper = new JPanel();
		containerUpper.setLayout( new FlowLayout() );
		
		JPanel containerLower = new JPanel();
		containerLower.setLayout( new FlowLayout() );
		
		showStatus = new JLabel("Accepting Coins");
		showStatus.setForeground(Color.GREEN);
		
		coins = new JLabel("#Coins: ");
		showCoins = new JTextField(10);
		showCoins.setEditable(false);
		
		containerUpper.add( coins );
		containerUpper.add( showCoins );
		containerLower.add( showStatus );
		
		container.add( containerUpper, BorderLayout.NORTH );
		container.add( containerLower, BorderLayout.SOUTH);
		
		this.add( container );
	}
	
	/**
	 * run gui.
	 */
	public void run(){
		this.pack();
		this.setVisible(true);
	}
	
	/**
	 * change coin machine status on textField and label.
	 * @param subject
	 * @param info
	 */
	@Override
	public void update(Observable subject, Object info) {
		if( info != null && info instanceof List ){
			if( machine.isFull() ){
				showStatus.setText("Unaccept Coins");
				showStatus.setForeground(Color.RED);
			}
			showCoins.setText( String.format( "%d", machine.getCount() ) );
			
		}
	}

}
