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
import java.util.Locale;

import org.eclipse.jface.contentassist.IContentAssistSubjectControl;
import org.eclipse.jface.contentassist.ISubjectControlContentAssistProcessor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContextInformation;
import org.eclipse.jface.text.contentassist.ContextInformationValidator;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.swt.graphics.Point;

import com.turquaz.engine.bl.EngBLAccountingAccounts;
import com.turquaz.engine.bl.EngBLBankCards;
import com.turquaz.engine.bl.EngBLCashCards;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLCurrentCards;
import com.turquaz.engine.bl.EngBLInventoryCards;
import com.turquaz.engine.bl.EngBLInventoryGroups;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqInventoryGroup;


public class TurquazContentAssistProcessors implements
        ISubjectControlContentAssistProcessor {

    int type = -1;

    public TurquazContentAssistProcessors(int type) {
        this.type = type;
        fillProposalArray(type);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeCompletionProposals(org.eclipse.jface.text.ITextViewer,
     *      int)
     */

    /**
     * 0 -accounting 1- inventory 2-accounting leaves 3 customers
     *  
    */
    public void fillProposalArray(int type) {
        try {
            List proposed = new ArrayList();
            if (type == 0) {
                List list = EngBLAccountingAccounts.getAccounts();

                for (int i = 0; i < list.size(); i++) {
                    TurqAccountingAccount acc = (TurqAccountingAccount) list.get(i);
                    proposed.add(new Proposal(acc.getAccountCode(),acc.getAccountName()));
                }

            }
            else if (type == EngBLCommon.CONTENT_ASSIST_INVENTORY) {
                List list = EngBLInventoryCards.getInventoryCards();
                 
                for (int i = 0; i < list.size(); i++) {
                    
                    Object []result = (Object[])list.get(i);
                    proposed.add(new Proposal(result[0].toString(),result[1].toString()));
                
                }

            }
            else if (type == EngBLCommon.CONTENT_ASSIST_ACCOUNT_LEAVES) {
               
                
                List list = EngBLAccountingAccounts.getAccountsForAccountPickers();

                for (int i = 0; i < list.size(); i++) {
                    TurqAccountingAccount acc = (TurqAccountingAccount) list.get(i);
                    proposed.add(new Proposal(acc.getAccountCode(),acc.getAccountName()));
                }

            }
           else if (type == EngBLCommon.CONTENT_ASSIST_CURRENT) {
           		
                List list = EngBLCurrentCards.getCurrentCards();

                
                for (int i = 0; i < list.size(); i++) {
                    Object[] result = ((Object[]) list.get(i));
                    
                    proposed.add(new Proposal(result[1].toString()+" {"+result[0].toString()+"}",null));
                
                }

            }
           
           else if(type==EngBLCommon.CONTENT_ASSIST_CASH){
               
               List list = EngBLCashCards.getCashCards();

               for (int i = 0; i < list.size(); i++) {
                   TurqCashCard card = (TurqCashCard)( list.get(i));
                   
                   proposed.add(new Proposal(card.getCashCardName(),card.getCashCardDefinition()));
               
               }
               
               
           }
           else if(type==EngBLCommon.CONTENT_ASSIST_ACCOUNTING_CASH){
               
               List list = EngBLAccountingAccounts.getCashAccounts();

               for (int i = 0; i < list.size(); i++) {
                   
                   Object[] cards = (Object[])( list.get(i));
                   
                   proposed.add(new Proposal(cards[0].toString(),cards[1].toString()));
               
               }
           }
           else if(type==EngBLCommon.CONTENT_ASSIST_CURRENT_CODE){
               
               List list = EngBLCurrentCards.getCurrentCards();

               
               for (int i = 0; i < list.size(); i++) {
                   Object[] result = ((Object[]) list.get(i));
                   
                   proposed.add(new Proposal(result[0].toString(),result[1].toString()));
               
               }
           }
           else if(type==EngBLCommon.CONTENT_ASSIST_BANK){
               
               List list = EngBLBankCards.getBankCards();

               
               for (int i = 0; i < list.size(); i++) {
                  TurqBanksCard bankCard = ((TurqBanksCard) list.get(i));
                   
                   proposed.add(new Proposal(bankCard.getBankCode(),bankCard.getBankName()+"-"+bankCard.getBankBranchName()+"-"+bankCard.getBankAccountNo()));
               
               }
           }
           else if(type==EngBLCommon.CONTENT_ASSIST_INVENTORY_GROUPS){
               
               List list = EngBLInventoryGroups.getInvGroups();

               
               for (int i = 0; i < list.size(); i++) {
                  TurqInventoryGroup bankCard = ((TurqInventoryGroup) list.get(i));
                   
                   proposed.add(new Proposal(bankCard.getGroupsName(),bankCard.getGroupsDescription()));
               
               }
           }
           else if (type==EngBLCommon.CONTENT_ASSIST_MAIN_ACCOUNTS)
           {
           		List list = EngBLAccountingAccounts.getMainAccounts();
           		
                for (int i = 0; i < list.size(); i++) {
                    TurqAccountingAccount acc = (TurqAccountingAccount) list.get(i);
                    proposed.add(new Proposal(acc.getAccountCode(),acc.getAccountName()));
                }
           }
            proposedCodes = new Proposal[proposed.size()];
            proposed.toArray(proposedCodes);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public ICompletionProposal[] computeCompletionProposals(
            IContentAssistSubjectControl viewer,

            int documentOffset) {
         
        // Retrieve current document
        IDocument doc = viewer.getDocument();

        // Retrieve current selection range
        Point selectedRange = viewer.getSelectedRange();
        List propList = new ArrayList();

        String qualifier = getQualifier(doc, documentOffset);

        // Compute completion proposals
        computeStructureProposals(qualifier, documentOffset, propList);

        // Create completion proposal array
        ICompletionProposal[] proposals = new ICompletionProposal[propList
                .size()];

        // and fill with list elements
        propList.toArray(proposals);

        // Return the proposals
        return proposals;

    }

    public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,

    int documentOffset) {
        
        // Retrieve current document
        IDocument doc = viewer.getDocument();

        // Retrieve current selection range
        Point selectedRange = viewer.getSelectedRange();
        List propList = new ArrayList();

        String qualifier = getQualifier(doc, documentOffset);

        // Compute completion proposals
        computeStructureProposals(qualifier, documentOffset, propList);

        // Create completion proposal array
        ICompletionProposal[] proposals = new ICompletionProposal[propList
                .size()];

        // and fill with list elements
        propList.toArray(proposals);

        // Return the proposals
        return proposals;

    }

    private String getQualifier(IDocument doc, int documentOffset) {

        // Use string buffer to collect characters
        StringBuffer buf = new StringBuffer();
        while (true) {
            try {

                // Read character backwards
                char c = doc.getChar(--documentOffset);

                /*
                 * if(c==' '){ return buf.reverse().toString(); }
                 */

                buf.append(c);

            } catch (BadLocationException e) {

                // Document start reached, no tag found
                return buf.reverse().toString();
            }
        }
    }

    //  Proposal part before cursor
    public Proposal[] proposedCodes;
     
    

    private void computeStructureProposals(String qualifier,
            int documentOffset, List propList) {
        int qlen = qualifier.length();

        qualifier = qualifier.toLowerCase(Locale.getDefault());
        // Loop through all proposals
        for (int i = 0; i < proposedCodes.length; i++) {
           if(propList.size()>1000){
               return;
           }
            String startTag = proposedCodes[i].text;
            String info = proposedCodes[i].info;
           
             
            String text = startTag;
            String lower_text = text.toLowerCase(Locale.getDefault());
           
            // Yes -- compute whole proposal text
            if (lower_text.startsWith(qualifier)) {

                // Derive cursor position
                int cursor = startTag.length();

                // Construct proposal
                CompletionProposal proposal=null;
 
                if(info!=null){
                proposal= new CompletionProposal(text,
                        documentOffset - qlen, qlen, cursor,null,text+" - "+info,null,null);
                }
                else{
                    proposal= new CompletionProposal(text,documentOffset - qlen, qlen, cursor);
                }

                // and add to result list
                propList.add(proposal);
            }

        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getCompletionProposalAutoActivationCharacters()
     */
    public char[] getCompletionProposalAutoActivationCharacters() {
        
        return new char[] { '.', ',',' ' };
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeContextInformation(org.eclipse.jface.text.ITextViewer,
     *      int)
     */
    public IContextInformation[] computeContextInformation(ITextViewer viewer,
            int offset) {

        return null;
    }

    public IContextInformation[] computeContextInformation(
            IContentAssistSubjectControl viewer, int offset) {

        System.out.println("info");
        ContextInformation info = new ContextInformation("111", "deneme");

        return new ContextInformation[] { info };

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getContextInformationAutoActivationCharacters()
     */
    public char[] getContextInformationAutoActivationCharacters() {
        
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getErrorMessage()
     */
    public String getErrorMessage() {
        
        return null;
    }

    public IContextInformationValidator getContextInformationValidator() {
        return new ContextInformationValidator(this);
    }
    
    

}