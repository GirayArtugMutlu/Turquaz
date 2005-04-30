package com.turquaz.accounting.ui.comp;

import org.eclipse.jface.contentassist.SubjectControlContentAssistant;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.jface.contentassist.TextContentAssistSubjectAdapter;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import com.turquaz.accounting.ui.AccUIStaticAccountsDialog;
import com.turquaz.engine.bl.EngBLAccountingAccounts;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.interfaces.TurquazContentAssistInterface;
import com.turquaz.engine.ui.contentassist.TurquazContentAssistant;
import com.cloudgarden.resource.SWTResourceManager;


public class CashAccountPicker extends org.eclipse.swt.widgets.Composite implements TurquazContentAssistInterface
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private String filter = "";
	private Button btnSearch;
	private Text text1;

	public CashAccountPicker(Composite parent, int style)
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
							setDBData(EngBLAccountingAccounts
								.getLeafAccount(text1.getText().trim()));
						} catch (Exception ex) {
                            EngBLLogger.log(this.getClass(),ex);
						}
					}
				});
				text1.setBackground(SWTResourceManager.getColor(254, 254, 254));
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
				btnSearch = new Button(this, SWT.PUSH | SWT.CENTER);
				GridData btnSearchLData = new GridData();
				btnSearchLData.verticalAlignment = GridData.FILL;
				btnSearch.setLayoutData(btnSearchLData);
				btnSearch.setText("...");
				btnSearch.addMouseListener(new MouseAdapter() {
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
	public void postInitGUI()
	{
		TextContentAssistSubjectAdapter adapter = new TextContentAssistSubjectAdapter(text1);
		final SubjectControlContentAssistant asistant = new TurquazContentAssistant(adapter, EngBLCommon.CONTENT_ASSIST_ACCOUNTING_CASH);
	}

	public void verifyData()
	{
		try
		{
			setDBData(EngBLAccountingAccounts.getAccount(text1.getText().trim()));
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex);
		}
	}

	public void setText(String arg0)
	{
		text1.setText(arg0);
	}

	public String getText()
	{
		return text1.getText();
	}

	public void setData(Object obj)
	{
		super.setData(obj);
		TurqAccountingAccount account = (TurqAccountingAccount) obj;
		text1.setText(account.getAccountCode());
	}

	public void setDBData(Object obj)
	{
		super.setData(obj);
	}

	/** Auto-generated event handler method */
	protected void button1MouseUp(MouseEvent evt)
	{
		Object[] obj = new AccUIStaticAccountsDialog(this.getShell(), SWT.NULL).showDialog(filter);
		if (obj[0] != null)
		{
			this.setData(obj[1]);
			text1.setText(obj[0].toString());
		}
	}

	/**
	 * @return Returns the filter.
	 */
	public String getFilter()
	{
		return filter;
	}

	/**
	 * @param filter
	 *             The filter to set.
	 */
	public void setFilter(String filter)
	{
		this.filter = filter;
	}

	public Object getDBData() {
		// TODO Auto-generated method stub
		return super.getData();
	}

	public void openNewObjectDialog() {
		// TODO Auto-generated method stub
		
	}

	public void openSearchDialog() {
		// TODO Auto-generated method stub
		
	}
}