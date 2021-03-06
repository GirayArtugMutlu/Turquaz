package com.turquaz.cash.ui.comp;

import java.util.HashMap;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.jface.contentassist.TextContentAssistSubjectAdapter;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;

import com.turquaz.cash.CashKeys;
import com.turquaz.cash.ui.CashUICashCardSearchDialog;
import com.turquaz.engine.bl.EngBLCashCards;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.interfaces.TurquazContentAssistInterface;
import com.turquaz.engine.ui.contentassist.TurquazContentAssistant;
import com.cloudgarden.resource.SWTResourceManager;


public class CashCardPicker extends org.eclipse.swt.widgets.Composite implements TurquazContentAssistInterface
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private String filter = "";
	private Button btnChoose;
	private Text text1;
	private HashMap cashInfo;

	public CashCardPicker(Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	/**
	 * Initializes the GUI. Auto-generated code - any changes you make will disappear.
	 */
	public void initGUI()
	{
		try
		{
			preInitGUI();
			this.setSize(new org.eclipse.swt.graphics.Point(397, 22));
			this.setEnabled(true);
			GridLayout thisLayout = new GridLayout(4, true);
			this.setLayout(thisLayout);
			{
				text1 = new Text(this, SWT.LEFT);
				text1.setEditable(true);
				text1.setSize(new org.eclipse.swt.graphics.Point(358, 22));
				GridData text1LData = new GridData();
				text1.addModifyListener(new ModifyListener() {
					public void modifyText(ModifyEvent evt) {
						try {
							setDBData(EngBLCashCards.getCard(text1.getText()
								.trim()));
						} catch (Exception ex) {
                            EngBLLogger.log(this.getClass(),ex);;
						}
					}
				});
				text1.setBackground(SWTResourceManager.getColor(255, 150, 150));
				text1LData.verticalAlignment = GridData.FILL;
				text1LData.horizontalAlignment = GridData.FILL;
				text1LData.grabExcessHorizontalSpace = true;
				text1LData.grabExcessVerticalSpace = true;
				text1.setLayoutData(text1LData);
				text1.addFocusListener(new FocusAdapter() {
					public void focusLost(FocusEvent evt) {
						openNewObjectDialog();
					}
				});
			}
			{
				btnChoose = new Button(this, SWT.PUSH | SWT.CENTER);
				GridData btnChooseLData = new GridData();
				btnChooseLData.verticalAlignment = GridData.FILL;
				btnChoose.setLayoutData(btnChooseLData);
				btnChoose.setText("...");
				btnChoose.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						openSearchDialog();
					}
				});
			}
			thisLayout.marginWidth = 0;
			thisLayout.marginHeight = 0;
			thisLayout.numColumns = 4;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 0;
			thisLayout.verticalSpacing = 0;
			this.layout();
			addDisposeListener(new DisposeListener()
			{
				public void widgetDisposed(DisposeEvent e)
				{
				}
			});
			postInitGUI();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e);
		}
	}

	/** Add your pre-init code in here */
	public void preInitGUI()
	{
	}
	/** Add your post-init code in here */
	public TurquazContentAssistant asistant;

	public void postInitGUI()
	{
		TextContentAssistSubjectAdapter adapter = new TextContentAssistSubjectAdapter(text1);
		asistant = new TurquazContentAssistant(adapter, EngBLCommon.CONTENT_ASSIST_CASH);
	}

	public void setText(String arg0)
	{
		text1.setText(arg0);
	}

	public String getText()
	{
		return text1.getText();
	}
	
	public String getCashCardName()
	{
		if(cashInfo==null)
		{
			return null;
		}
		
		return cashInfo.get(CashKeys.CASH_CARD_NAME).toString();
	}
	
	public Integer getCashCardId()
	{
		if(cashInfo==null)
		{
			return null;
		}
		return (Integer)cashInfo.get(CashKeys.CASH_CARD_ID);
		
	}

	public void setData(HashMap info)
	{
		
		cashInfo= info;
        if(info !=null)
        {
           text1.setText(info.get(CashKeys.CASH_CARD_NAME).toString());
           
        }
	}
	
	public Object getData()
	{
		return cashInfo;
		
	}

	public void setDBData(HashMap info)
	{
		cashInfo = info;
		if (info == null)
		{
			text1.setBackground(SWTResourceManager.getColor(255, 150, 150));
		}
		else
		{
			text1.setBackground(SWTResourceManager.getColor(198, 255, 198));
		}
	}	

	public void openNewObjectDialog() {
		// TODO Auto-generated method stub
		
	}

	public void openSearchDialog() {
		String Code = new CashUICashCardSearchDialog(this.getShell(), SWT.NULL).open(text1.getText().trim());
		text1.setText(Code);
		
	}
	
}