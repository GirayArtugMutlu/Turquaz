package com.turquaz.engine.ui.component;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class TextWithButton extends org.eclipse.swt.widgets.Composite {

	private Button button1;
	private Text text1;
	public TextWithButton(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	/**
	* Initializes the GUI.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void initGUI(){
		try {
			preInitGUI();
	
			text1 = new Text(this,SWT.NULL);
			button1 = new Button(this,SWT.PUSH| SWT.CENTER);
	
			this.setSize(new org.eclipse.swt.graphics.Point(274,32));
			this.setEnabled(true);
	
			GridData text1LData = new GridData();
			text1LData.verticalAlignment = GridData.FILL;
			text1LData.horizontalAlignment = GridData.FILL;
			text1LData.widthHint = -1;
			text1LData.heightHint = -1;
			text1LData.horizontalIndent = 0;
			text1LData.horizontalSpan = 1;
			text1LData.verticalSpan = 1;
			text1LData.grabExcessHorizontalSpace = true;
			text1LData.grabExcessVerticalSpace = true;
			text1.setLayoutData(text1LData);
			text1.setSize(new org.eclipse.swt.graphics.Point(240,32));
	
			GridData button1LData = new GridData();
			button1LData.verticalAlignment = GridData.FILL;
			button1LData.horizontalAlignment = GridData.BEGINNING;
			button1LData.widthHint = 28;
			button1LData.heightHint = -1;
			button1LData.horizontalIndent = 0;
			button1LData.horizontalSpan = 1;
			button1LData.verticalSpan = 1;
			button1LData.grabExcessHorizontalSpace = false;
			button1LData.grabExcessVerticalSpace = false;
			button1.setLayoutData(button1LData);
			button1.setText("...");
			button1.setSize(new org.eclipse.swt.graphics.Point(28,32));
			GridLayout thisLayout = new GridLayout(4, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 0;
			thisLayout.marginHeight = 0;
			thisLayout.numColumns = 4;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 0;
			thisLayout.verticalSpacing = 0;
			this.layout();
	
			postInitGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** Add your pre-init code in here 	*/
	public void preInitGUI(){
		
		  addListener(SWT.Resize, new Listener() {
		    public void handleEvent(Event e) {
		     onResize();
		    }
		   });

		   addListener(SWT.FocusIn, new Listener() {
		    public void handleEvent(Event e) {
		     onFocusIn();
		    }
		   });
		   addListener(SWT.MouseUp,new Listener(){
		   	public void handleEvent(Event e){
		   		onMouseUp();
		   }
		   } );
		   
		
	}
    
	public void addMouseListener(MouseAdapter adapter){
		button1.addMouseListener(adapter);
		
	}
	/** Add your post-init code in here 	*/
	public void postInitGUI(){
		
		
		
	}
	 void onResize() {
	 	  Rectangle area = getClientArea();
	 	  this.setBounds(0, 0, area.width, area.height);
	 	 }

	void onFocusIn() {
	  text1.setFocus();
	 }
 
	void onMouseUp(){

	}
	
	
	
}
