
package com.turquaz.engine.ui.contentassist;
/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.       							*/
/* 																		*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of		*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the		*/
/* GNU General Public License for more details.         				*/
/************************************************************************/

/**
* @author  Onsel
* @version  $Id$
*/
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.contentassist.SubjectControlContentAssistant;
import org.eclipse.jface.contentassist.TextContentAssistSubjectAdapter;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.cloudgarden.resource.SWTResourceManager;

public class TurquazContentAssistant extends SubjectControlContentAssistant{
    TurquazContentAssistProcessors processor = null;

    public TurquazContentAssistant(
            TextContentAssistSubjectAdapter adapter,int type) {
        super();
        
        processor = new TurquazContentAssistProcessors(type);
        
        Color bgColor = SWTResourceManager.getColor(255,255,255);
        this.setProposalSelectorBackground(bgColor);
       
        this.setContentAssistProcessor(processor,
                IDocument.DEFAULT_CONTENT_TYPE);
        this.enableAutoActivation(true);
        this.enableAutoInsert(true);
        this.setAutoActivationDelay(500);

        this.setContextInformationPopupOrientation(IContentAssistant.CONTEXT_INFO_ABOVE);
         
        
        this.setInformationControlCreator(new IInformationControlCreator() {
                    /*
                     * @see org.eclipse.jface.text.IInformationControlCreator#createInformationControl(org.eclipse.swt.widgets.Shell)
                     */
                    public IInformationControl createInformationControl(
                            Shell parent) {
                        return new DefaultInformationControl(parent, presenter);
                    }
                });

       if(!adapter.getControl().isDisposed())
       {
        this.install(adapter);
        installCueLabelProvider(adapter);
       
       }
     

    }  
    
 
    public int findIndex(String text){

     if(processor == null){
     	return -1;
     }
     if(text==null)
     {
     	return -1;
     }
     Proposal []proposals = processor.proposedCodes;
     
     for(int i =0;i<proposals.length;i++){
       	
       	if(proposals[i].text.equals(text)){
       		return i;
       	}
     
     }
    	
     return -1;
    	
    }
    public List getPartialProposal(String text1, String text2){
    	
    	
    	
    	int start = findIndex(text1);
    	int end = findIndex(text2);
        
    	if(start!=-1&&end!=-1){
    		Proposal []proposals = processor.proposedCodes;
    		
    		List list = new ArrayList(); 
    		
    		for(int i=start;i<=end;i++)
    		{
    			list.add(proposals[i].text);
    			
    		}
    		return list;
       	}
    	
    	
    	return new ArrayList();
    }
    
    public void refreshContentAssistant(int type){
    	
        if(processor!=null){
            processor.fillProposalArray(type);
        }
    }

    public SubjectControlContentAssistant createContentAssistant() {
       SubjectControlContentAssistant contentAssistant = new SubjectControlContentAssistant();
       return contentAssistant;
    }

    private static void installCueLabelProvider(
            TextContentAssistSubjectAdapter adapter) {
        ILabelProvider labelProvider = new LabelProvider() {
            /**
             * @inheritDoc
             */
            public String getText(Object element) {
                return "";
            }
        };
        adapter.setContentAssistCueProvider(labelProvider);
    }

    public static final DefaultInformationControl.IInformationPresenter presenter = new DefaultInformationControl.IInformationPresenter() {
        public String updatePresentation(Display display, String infoText,
                TextPresentation presentation, int maxWidth, int maxHeight) {

            StyleRange range = new StyleRange(0, infoText.length(), null, null,
                    SWT.BOLD);

            // Add this style range to the presentation
            presentation.addStyleRange(range);

            // Return the information text

            return infoText;
        }
    };

}