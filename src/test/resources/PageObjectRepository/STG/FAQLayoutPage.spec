# Object Definitions
==================================================================================================================================
span_collapseSection                 xpath              (//span[@title='Collapse section'])[1]
span_expendSection                   xpath              (//span[@title='Expand section'])[1]    
link_faq                             xpath               //a[text()='FAQ']  
h4_ListOfQuestions                   xpath               //h4[@role='presentation']
div_QuesAndAnsBlock                  xpath               //div[@class='panel panel-default']
div_blockSpecificQuestion            xpath               (//div[@class='panel panel-default'])[${val}]//a
div_blockSpecificAnswer              xpath               (//div[@class='panel panel-default'])[${val}]//div[@class='panel-body']
span_plusIcon                        xpath                (//span[contains(@class,'glyphicon-plus')])[1]         
input_defaultQuestion                xpath                (//span[text()='Question']/parent::div/parent::div//input[@value='${text}'])[1]   
input_defaultAnswer                  xpath                (//div[@class='note-editable panel-body' and text()='${text}'])[1]
iframe_NewQueAns                     xpath                 (//input[@value='New Question'])[1]/ancestor::div[contains(@class,'control-label full-width')]//iframe[@src='/summernote/answerEditor.html']     
==================================================================================================================================
    