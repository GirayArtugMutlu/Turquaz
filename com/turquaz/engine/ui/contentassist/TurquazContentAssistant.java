
package com.turquaz.engine.ui.contentassist;
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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class TurquazContentAssistant extends SubjectControlContentAssistant{
    TurquazContentAssistProcessors processor = null;

    public TurquazContentAssistant(
            TextContentAssistSubjectAdapter adapter,int type) {
        super();
        
        processor = new TurquazContentAssistProcessors(type);
        
        this.setContentAssistProcessor(processor,
                IDocument.DEFAULT_CONTENT_TYPE);
        this.enableAutoActivation(true);
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

        this.install(adapter);
        installCueLabelProvider(adapter);

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

    private static final DefaultInformationControl.IInformationPresenter presenter = new DefaultInformationControl.IInformationPresenter() {
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