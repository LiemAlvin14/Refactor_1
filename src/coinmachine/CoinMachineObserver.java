package coinmachine;

import java.util.Observable;
import java.util.Observer;
import java.util.List;

/**
 * 
 * @author Clunctia
 *
 */
public class CoinMachineObserver implements Observer{

	/**
	 * 
	 */
	@Override
	public void update(Observable subject, Object info) {
		if( info != null && info instanceof List ){
			double total = 0.0;
			List<Coin> coinList = (List<Coin>) info;
			for( int i = 0 ; i < coinList.size() ; i++ ){
				total += coinList.get(i).getValue();
			}
			System.out.println("Total amount: "+total);
		}
	}
	
}
