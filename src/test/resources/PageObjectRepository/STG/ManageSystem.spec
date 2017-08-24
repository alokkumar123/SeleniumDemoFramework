# Object Definitions
==================================================================================================================================
list_searchSystem               xpath          //tbody/tr/td[3]/a
input_searchBox                 xpath          //input[@id='searchText']
button_Create                   xpath          //button[text()='Create']
div_SystemName                  xpath          //label[text()='Name *']/parent::div//input
button_save                     xpath          //button[text()='Save']
link_newCreatedSystem           xpath          //td//a[contains(text(),'${newSystem}')]
h4_createSystem                 xpath          //h4[contains(text(),'Create')]
div_discription                 xpath          //textarea[@placeholder='Application description'] 
text_description                xpath          //td[contains(@data-search-text,'${description}')]    
link_moveUp                     xpath          (//tr//a[text()='Move up'])[3]  
text_moveUp                     xpath          (//tr//a[text()='Move up'])[3]/ancestor::tr/td[3]/a 
span_deleteSystem               xpath          //a[contains(text(),'${newSystem}')]/ancestor::tr//span[contains(@class,'glyphicon')]
button_delete                   xpath          //button[text()='Delete']
span_trashIcon                  xpath          //table[@class='app-table']//td[3]/*[text()='${systemName}']/ancestor::tr//span[contains(@class,'trash')]
modal_deleteContent             xpath           //div[@class='modal-dialog']
txt_deleteHeader                xpath           //div[@class='modal-header']/h4
btn_modalFooter                 xpath           //div[@class='modal-dialog']//button[text()='${buttonName}']
list_acessDefault               xpath           //div[contains(text(),'Public')]
list_accessLevelSelect          xpath           //li[contains(text(),'${'systemAccessLevel'}')]
list_selectMonitor              xpath            //div[contains(text(),'Select monitors')]
select_monitorName              xpath            //div[@class='Select-menu-outer']//*[text()='${monitorName}']
select_monitorNameAdmin         xpath           //div[aria-activedescendant="react-select-3--option-0"]    
==================================================================================================================================