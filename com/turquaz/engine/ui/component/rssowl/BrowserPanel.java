/*   **********************************************************************  **
 **	 	Copyright notice																											 **
 **                                                                          **
 **   (c) 2003-2004 RSSOwl Development Team                                  **
 **   http://www.rssowl.org/                                                 **
 **                                                                          **
 **   All rights reserved                                                    **
 **																																					 **
 **		This program and the accompanying materials are made available under 	 **
 **	 	the terms of the Common Public License v1.0 which accompanies this		 **
 **	 	distribution, and is available at:																		 **
 **		http://www.rssowl.org/legal/cpl-v10.html															 **
 **																																					 **
 **   A copy is found in the file cpl-v10.html and important notices to the  **
 **   license from the team is found in the textfile LICENSE.txt distributed **
 **   in this package.                                                       **
 **	 																																				 **
 **		This copyright notice MUST APPEAR in all copies of the file!					 **
 **																																					 **
 **	 	Contributors:																													 **
 **	  	RSSOwl - initial API and implementation (bpasero@rssowl.org)				 **
 **																																					 **
 **	 **********************************************************************	 */
package com.turquaz.engine.ui.component.rssowl;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.LocationAdapter;
import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.browser.StatusTextEvent;
import org.eclipse.swt.browser.StatusTextListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import com.turquaz.engine.Messages;
import com.turquaz.engine.ui.EngUIMainFrame;

/**
 * This is the Web-Browser support for RSSOwl. It loads a Browser in a Composite and opens URLs.
 * 
 * @author <a href="mailto:bpasero@rssowl.org">Benjamin Pasero </a>
 * @version 1.0
 */
public class BrowserPanel extends Composite
{
	private ToolItem itemBack;
	private ToolItem itemForward;
	private ToolItem itemHome;
	private ToolItem itemNewTab;
	private ToolItem itemReload;
	private ToolItem itemStop;
	private boolean showControls;
	private boolean showNewTabControl;
	boolean blockNav;
	Text location;
	Label status;
	Label statusProgressBar;
	Browser browser;

	/**
	 * Instantiate a new this
	 * 
	 * @param parent
	 *             The parent composite
	 * @param parentTabItem
	 *             The parent CTabItem containing the Browser if available
	 * @param showControls
	 *             TRUE if the controls should be visible
	 * @param showNewTabControl
	 *             TRUE if the "Open new Tab" button should be visible
	 */
	public BrowserPanel(Composite parent, boolean showControls, boolean showNewTabControl)
	{
		super(parent, SWT.NULL);
		this.showControls = showControls;
		this.showNewTabControl = showNewTabControl;
		/** Display browser with controls */
		if (showControls)
			initComponents();
		/** Display browser without controls */
		else
			initComponentsNoControls();
	}

	/** Init the browser */
	private void initBrowser()
	{
		browser = new Browser(this, SWT.BORDER);
		/** GridData used by the browser widget */
		GridData data = LayoutDataShop.createGridData(GridData.FILL_BOTH, 3);
		data.grabExcessHorizontalSpace = true;
		data.grabExcessVerticalSpace = true;
		browser.setLayoutData(data);
		/** Status label */
		status = new Label(this, SWT.NONE);
		status.setLayoutData(LayoutDataShop.createGridData(GridData.FILL_HORIZONTAL, 2));
		/** Label displaying the progress bar */
		statusProgressBar = new Label(this, SWT.NONE);
		statusProgressBar.setFont(FontShop.dialogFont);
		statusProgressBar.setImage(PaintShop.getProgressIcon(0));
		statusProgressBar.setLayoutData(new GridData(SWT.END, SWT.CENTER, false, false));
		/** Status Text Listener */
		browser.addStatusTextListener(new StatusTextListener()
		{
			public void changed(StatusTextEvent event)
			{
				onStatusTextChange(event);
			}
		});
		/** Progress Listener */
		browser.addProgressListener(new ProgressListener()
		{
			public void changed(ProgressEvent event)
			{
				onProgressChange(event);
			}

			/** Reset progress bar on completion */
			public void completed(ProgressEvent event)
			{
				onProgressCompletion();
			}
		});
		/** Location Listener */
		browser.addLocationListener(new LocationAdapter()
		{
			public void changed(LocationEvent event)
			{
				updateNavToolItems();
			}

			public void changing(LocationEvent event)
			{
				location.setText(event.location);
			}
		});
	}

	/** Create the browser to use with no controls */
	private void initBrowserNoControls()
	{
		browser = new Browser(this, SWT.NONE);
		/** GridData used by the browser widget */
		browser.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		/**
		 * The location listener is added to the browser to block the navigation in that widget if "blockNav" is set to TRUE. RSSOwl will
		 * open the selected link in a new tab or the external browser.
		 */
		browser.addLocationListener(new LocationAdapter()
		{
			/**
			 * Workaround to reset the blockNav flag back to TRUE after a news was displayed. The changed() event is triggered, when the
			 * loading of the page is done.
			 */
			public void changed(LocationEvent event)
			{
				setBlockNav(true);
			}

			/**
			 * If the blockNav flag is set to TRUE, stop loading and show the link in a new tab or open it external.
			 */
			public void changing(LocationEvent event)
			{
				if (blockNav)
				{
					/** Disallow location loading */
					event.doit = false;
				}
			}
		});
	}

	/** Init all components */
	private void initComponents()
	{
		this.setLayout(LayoutShop.createGridLayout(3, 3, 3));
		this.setSize(462, 370);
		/** Toolbar */
		ToolBar toolbar = new ToolBar(this, SWT.FLAT);
		/** Navigate back in history */
		itemBack = new ToolItem(toolbar, SWT.PUSH);
		itemBack.setToolTipText(Messages.getString("BrowserPanel.0")); //$NON-NLS-1$
		itemBack.setImage(new Image(EngUIMainFrame.display, getClass().getResourceAsStream("/icons/backward.gif"))); //$NON-NLS-1$
		itemBack.setDisabledImage(new Image(EngUIMainFrame.display, getClass().getResourceAsStream("/icons/backward_disabled.gif"))); //$NON-NLS-1$
		itemBack.addDisposeListener(DisposeListenerImpl.getInstance());
		itemBack.addListener(SWT.Selection, new Listener()
		{
			public void handleEvent(Event event)
			{
				if (WidgetShop.isset(browser))
					browser.back();
			}
		});
		/** Navigate forward in history */
		itemForward = new ToolItem(toolbar, SWT.PUSH);
		itemForward.setToolTipText(Messages.getString("BrowserPanel.3")); //$NON-NLS-1$
		itemForward.setImage(new Image(EngUIMainFrame.display, getClass().getResourceAsStream("/icons/forward.gif"))); //$NON-NLS-1$
		itemForward.setDisabledImage(new Image(EngUIMainFrame.display, getClass().getResourceAsStream("/icons/forward_disabled.gif"))); //$NON-NLS-1$
		itemForward.addDisposeListener(DisposeListenerImpl.getInstance());
		itemForward.addListener(SWT.Selection, new Listener()
		{
			public void handleEvent(Event event)
			{
				if (WidgetShop.isset(browser))
					browser.forward();
			}
		});
		/** Stop loading */
		itemStop = new ToolItem(toolbar, SWT.PUSH);
		itemStop.setToolTipText(Messages.getString("BrowserPanel.6")); //$NON-NLS-1$
		itemStop.setImage(new Image(EngUIMainFrame.display, getClass().getResourceAsStream("/icons/stop.gif"))); //$NON-NLS-1$
		itemBack.addDisposeListener(DisposeListenerImpl.getInstance());
		itemStop.addListener(SWT.Selection, new Listener()
		{
			public void handleEvent(Event event)
			{
				if (WidgetShop.isset(browser))
					browser.stop();
			}
		});
		/** Reload webpage */
		itemReload = new ToolItem(toolbar, SWT.PUSH);
		itemReload.setToolTipText(Messages.getString("BrowserPanel.8")); //$NON-NLS-1$
		itemReload.setImage(new Image(EngUIMainFrame.display, getClass().getResourceAsStream("/icons/reload.gif"))); //$NON-NLS-1$
		itemBack.addDisposeListener(DisposeListenerImpl.getInstance());
		itemReload.addListener(SWT.Selection, new Listener()
		{
			public void handleEvent(Event event)
			{
				if (WidgetShop.isset(browser))
					browser.refresh();
			}
		});
		/** Navigate to home url */
		itemHome = new ToolItem(toolbar, SWT.PUSH);
		itemHome.setImage(new Image(EngUIMainFrame.display, getClass().getResourceAsStream("/icons/home.gif"))); //$NON-NLS-1$
		itemHome.setDisabledImage(new Image(EngUIMainFrame.display, getClass().getResourceAsStream("/icons/home_disabled.gif"))); //$NON-NLS-1$
		itemHome.addDisposeListener(DisposeListenerImpl.getInstance());
		itemHome.addListener(SWT.Selection, new Listener()
		{
			public void handleEvent(Event event)
			{
				if (WidgetShop.isset(browser))
					browser.setUrl("http://www.turquaz.com"); //$NON-NLS-1$
			}
		});
		/** Set back, forward and home disabled */
		itemBack.setEnabled(false);
		itemForward.setEnabled(false);
		itemHome.setEnabled(true);
		/** Input field to enter a URL */
		location = new Text(this, SWT.BORDER);
		GridData data = LayoutDataShop.createGridData(GridData.FILL_HORIZONTAL, 2);
		data.grabExcessHorizontalSpace = true;
		location.setLayoutData(data);
		/** Browse to url after enter */
		location.addListener(SWT.DefaultSelection, new Listener()
		{
			public void handleEvent(Event e)
			{
				browser.setUrl(location.getText());
			}
		});
		/** Tweak Text Widget */
		WidgetShop.tweakTextWidget(location);
		/** Setup the browser to use */
		initBrowser();
		browser.setUrl("http://www.turquaz.com"); //$NON-NLS-1$
	}

	/** Init components without the controls */
	private void initComponentsNoControls()
	{
		this.setLayout(LayoutShop.createGridLayout(1, 0, 0));
		/** The parent uses FormLayout, so use FormData for Layout */
		this.setLayoutData(LayoutDataShop.createFormData(0, 0, 0, 0));
		/** Create the browser to be used with no controls */
		initBrowserNoControls();
	}

	/**
	 * Set HTML text to the browser
	 * 
	 * @param text
	 *             HTML code
	 */
	private void setText(String text)
	{
		/** We have to allow navigation to display the news */
		setBlockNav(false);
		/** Re-Create Browser if it was disposed already */
		if (!WidgetShop.isset(browser))
		{
			if (showControls)
				initBrowser();
			else
				initBrowserNoControls();
		}
		/** Set Text to display in Browser */
		browser.setText(text);
		/** Might be hidden */
		if (!this.isVisible())
			this.setVisible(true);
	}

	/**
	 * Dispose the browser
	 */
	public void dispose()
	{
		/** Dispose browser */
		browser.dispose();
		/** Explicitly force GC to clean browser */
		browser = null;
		/** Dispose browser panel */
		super.dispose();
	}

	/**
	 * Get the browser panel
	 * 
	 * @return Composite The browser panel
	 */
	Composite getthis()
	{
		return this;
	}

	/**
	 * Hide the Newstext Browser Panel
	 */
	void hideNoControlsBrowser()
	{
		this.setVisible(false);
	}

	/**
	 * Called whenever the Progress is changing
	 * 
	 * @param event
	 *             The ProgressEvent
	 */
	void onProgressChange(ProgressEvent event)
	{
		/** Return in case no progress was made yet */
		if (event.total == 0)
			return;
		/** Calculate ratio */
		int ratio = event.current * 100 / event.total;
		/** Set the Progress bar in dependance of the ratio */
		if (ratio == 100)
			statusProgressBar.setImage(PaintShop.getProgressIcon(100));
		else if (ratio >= 80)
			statusProgressBar.setImage(PaintShop.getProgressIcon(80));
		else if (ratio >= 60)
			statusProgressBar.setImage(PaintShop.getProgressIcon(60));
		else if (ratio >= 40)
			statusProgressBar.setImage(PaintShop.getProgressIcon(40));
		else
			statusProgressBar.setImage(PaintShop.getProgressIcon(20));
		/** Update the Progress Bar */
		statusProgressBar.update();
	}

	/**
	 * Called whenever the Progress is completed
	 */
	void onProgressCompletion()
	{
		statusProgressBar.setImage(PaintShop.getProgressIcon(0));
		/** Update the Progress Bar */
		statusProgressBar.update();
	}

	/**
	 * Called whenever the Status Text is changing
	 * 
	 * @param event
	 *             The StatusTextEvent
	 */
	void onStatusTextChange(StatusTextEvent event)
	{
		status.setText(event.text);
		updateNavToolItems();
	}

	/**
	 * Open a new URL in the browser
	 * 
	 * @param url
	 *             URL of the webpage
	 */
	void openUrl(String url)
	{
		/** Set the URL as Tooltip to the Home Button and enable it */
		if (showControls)
		{
			itemHome.setEnabled(true);
			itemHome.setToolTipText(url);
		}
		/** Re-Create Browser if it was disposed already */
		if (!WidgetShop.isset(browser))
		{
			if (showControls)
				initBrowser();
			else
				initBrowserNoControls();
		}
		/** Launch URL in Browser */
		browser.setUrl(url);
	}

	/**
	 * Set TRUE to block navigation in the browser widget. Any selected links will open in a new tab or the external browser. Set FALSE to
	 * allow navigation in the browser. When setting text to the browser, blockNav has to be FALSE to display the text!
	 * 
	 * @param blockNav
	 *             The blockNav to set.
	 */
	void setBlockNav(boolean blockNav)
	{
		this.blockNav = blockNav;
	}

	/**
	 * Update "Back" and "Forward" tool items
	 */
	void updateNavToolItems()
	{
		if (WidgetShop.isset(itemBack))
			itemBack.setEnabled(browser.isBackEnabled());
		if (WidgetShop.isset(itemForward))
			itemForward.setEnabled(browser.isForwardEnabled());
	}
}