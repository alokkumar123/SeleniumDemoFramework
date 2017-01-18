# Object Definitions

==================================================================================================================================
input_serachBox                              xpath          //input[@id='searchText']
button_addNew                                xpath          //button[text()='${addNew}'] 
h4_formInfo                                  xpath          //h4[text()='${data}'] 
input_text                                   xpath          //label[contains(text(),'${formField}')]/ancestor::div[contains(@class,'form-group')]//*[@class='form-control']
div_menuItems                                xpath          //div[@class='Select-menu']//div[text()='${permission}']
link_newData                                 xpath          //a[text()='${data}'] 
text_permission                              xpath          //a[text()='New Role']/ancestor::tr/td[contains(text(),'${permission}')]  
span_deleteNewUser                           xpath          //a[contains(text(),'${editUserName}')]/ancestor::tr//span[contains(@class,'glyphicon')]
div_selectPermission                         xpath          //span[@class='Select-arrow']
==================================================================================================================================
    