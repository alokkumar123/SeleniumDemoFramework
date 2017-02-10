# Object Definitions
==================================================================================================================================
link_login                                   xpath          //a[text()='Sign in']
userName                                     xpath          //input[@placeholder ='Enter login']    
password                                     xpath          //input[@placeholder ='Enter password']
button_login                                 xpath          //button[text()='Login']    
div_adminMenu                                xpath          //div[@class='admin-menu']//li
button_Create                                xpath          //button[text()='Create']
div_monitorName                              xpath          //div[@id='name']/input
list_allApp                                  xpath          //li[text()='All systems']  
commentSection                               xpath          //textarea[@placeholder='Work being done']
button_save                                  xpath          //button[text()='Save']
link_MenuName                                xpath          //a[text()='${menuName}'] 
div_externalServiceId                        xpath          //div[@id='externalServiceID']/input    
link_newCreatedMonitor                       xpath          //a[contains(text(),'${monitorName}')]  
button_Admin                                 xpath          //li[@class='login-tab dropdown']//a[@class='dropdown-toggle']
logout_adminPage                             xpath          //a[text()='Log out']   
table_appTableGrid                           xpath          //table[@class='app-table']
span_gridFields                              xpath          //span[text()='${string}'] 
input_searchBox                              xpath          //input[@id='searchText']
link_breadCrumb                              xpath          //a[contains(text(),'Platform Availability Home')]/parent::div[contains(text(),'${breadCrumb}')] 
link_ok                                      xpath          //button[text()='OK']  
serarched_text                               xpath          //td[contains(@data-search-text,'${searchingText}')]
span_deleteMonitors                          xpath          //a[contains(text(),'${monitorName}')]/ancestor::tr//span[contains(@class,'glyphicon')] 
button_delete                                xpath          //button[text()='Delete']   
button_AddNewUser                            xpath          //button[text()='Add a New User']
text_newUserScreen                           xpath          //h4[text()='Add new user']
span_shortingFields                          xpath          //div[@class='container']//td[${index}]
span_Assending                               xpath          (//span[contains(@class,'glyphicon-chevron-up')])[${index}] 
span_Desending                               xpath          (//span[contains(@class,'glyphicon-chevron-down')])[${index}] 
searched_text                                xpath          //td[contains(@data-search-text,'${searchingText}')]
input_text                                   xpath          //label[contains(text(),'${formField}')]/ancestor::div[contains(@class,'form-group')]//input[@class='form-control']
div_Selector                                 xpath          //div[@class='Select-placeholder']
div_menuItems                                xpath          //div[@class='Select-menu']/div 
div_ItemRoles                                xpath          //div[@class='container']//a      
div_userName                                 xpath          //div[@class='container']//a[text()='${useName}'] 
div_editedUserName                           xpath          //div[@class='container']//a[text()='${editUserName}']   
td_oldValue                                  xpath          //td[text()='${userName}']  
td_newValue                                  xpath          //td[text()='${editUserName}'] 
span_deleteNewUser                           xpath          //a[contains(text(),'${editUserName}')]/ancestor::tr//span[contains(@class,'glyphicon')]
button_popUp                                 xpath          //button[text()='${popUp}']    
==================================================================================================================================
    