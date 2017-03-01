# Object Definitions
==================================================================================================================================
list_searchSystem                            xpath          //tbody/tr/td[3]/a
input_searchBox                              xpath          //input[@id='searchText']
button_Create                                xpath          //button[text()='Create']
div_SystemName                               xpath          //div[@id='name']/input
button_save                                  xpath          //button[text()='Save']
link_newCreatedSystem                        xpath          //td//a[contains(text(),'${newSystem}')]
h4_createSystem                              xpath          //h4[contains(text(),'Create')]
div_discription                              xpath          //textarea[@placeholder='Application description'] 
text_description                             xpath          //td[contains(@data-search-text,'${description}')]    
link_moveUp                                  xpath          (//tr//a[text()='Move up'])[3]  
text_moveUp                                  xpath          (//tr//a[text()='Move up'])[3]/ancestor::tr/td[3]/a 
span_deleteSyetem                            xpath          //a[contains(text(),'${newSystem}')]/ancestor::tr//span[contains(@class,'glyphicon')]
button_delete                                xpath          //button[text()='Delete']
==================================================================================================================================
    