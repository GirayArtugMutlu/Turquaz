package com.turquaz.engine.ui.contentassist;

import java.util.ArrayList;
import java.util.List;

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

import com.turquaz.accounting.bl.AccBLAccountAdd;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.engine.bl.EngBLAccountingAccounts;
import com.turquaz.engine.bl.EngBLCurrentCards;
import com.turquaz.engine.bl.EngBLInventoryCards;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqInventoryCard;

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
                    proposed.add(acc.getAccountCode());
                }

            }
            else if (type == 1) {
                List list = EngBLInventoryCards.getInventoryCards();

                for (int i = 0; i < list.size(); i++) {
                    TurqInventoryCard acc = (TurqInventoryCard)list.get(i);
                    proposed.add(acc.getCardInventoryCode());
                }

            }
            else if (type == 2) {
                AccBLAccountAdd blAccount = new AccBLAccountAdd();
                
                List list = blAccount.getAccountsForAccountPickers();

                for (int i = 0; i < list.size(); i++) {
                    TurqAccountingAccount acc = (TurqAccountingAccount) list.get(i);
                    proposed.add(acc.getAccountCode());
                }

            }
           else if (type == 3) {
           		
                List list = EngBLCurrentCards.getCurrentCards();

                for (int i = 0; i < list.size(); i++) {
                    TurqCurrentCard card = (TurqCurrentCard) list.get(i);
                    proposed.add(card.getCardsCurrentCode());
                }

            }
            proposedCodes = new String[proposed.size()];
            proposed.toArray(proposedCodes);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public ICompletionProposal[] computeCompletionProposals(
            IContentAssistSubjectControl viewer,

            int documentOffset) {
         // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
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
    private String[] proposedCodes;

    private void computeStructureProposals(String qualifier,
            int documentOffset, List propList) {
        int qlen = qualifier.length();

        // Loop through all proposals
        for (int i = 0; i < proposedCodes.length; i++) {
            String startTag = proposedCodes[i];

            String text = startTag;
            // Yes -- compute whole proposal text
            if (text.startsWith(qualifier)) {

                // Derive cursor position
                int cursor = startTag.length();

                // Construct proposal

                CompletionProposal proposal = new CompletionProposal(text,
                        documentOffset - qlen, qlen, cursor);

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
        // TODO Auto-generated method stub
        return new char[] { '.', ',' };
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
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getErrorMessage()
     */
    public String getErrorMessage() {
        // TODO Auto-generated method stub
        return null;
    }

    public IContextInformationValidator getContextInformationValidator() {
        return new ContextInformationValidator(this);
    }

}