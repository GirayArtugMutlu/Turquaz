package com.turquaz.inventory.ui;

import java.util.List;

import org.eclipse.swt.layout.GridLayout;


import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.inventory.bl.InvBLProfitAnalysis;


/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* *************************************
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
* for this machine, so Jigloo or this code cannot be used legally
* for any corporate or commercial purpose.
* *************************************
*/
public class InvUIProfitAnalysis extends org.eclipse.swt.widgets.Composite implements SearchComposite{

    public InvBLProfitAnalysis blProfit = new InvBLProfitAnalysis(); 

	public InvUIProfitAnalysis(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setSize(491, 208);
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void search(){
	    try{
	    
	        TurqInventoryCard  invCard = null;
	        List ls = blProfit.getTransactionTotals(0,invCard,DatePicker.formatter.parse("1/1/2004"),DatePicker.formatter.parse("12/12/2004"));
	        
	        for(int i = 0; i<ls.size();i++){
	           System.out.println(ls.get(i));	            
	            
	        }
	        
	        
	        
	        
	    }
	    catch(Exception ex){
	        
	        ex.printStackTrace();
	    
	    }
	    
	    
	}
	public void delete(){
	    
	}
	

    public void exportToExcel() {
        // TODO Auto-generated method stub

    }
    public void printTable() {
        // TODO Auto-generated method stub

    }
}
