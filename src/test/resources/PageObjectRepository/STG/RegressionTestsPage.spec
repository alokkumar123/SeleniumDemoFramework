# Object Definitions
==================================================================================================================================
div_RegressionApp                   xpath           //div[text()='Regression Tests']
div_SystemColorStatus               xpath           //div[text()='${system}']/ancestor::div[@class='front-system']//div[@class='system-status-icon'] 
url_systemLogo                      xpath               //div[contains(@class,'system-header ')]//div[@class='system-logo' and not(contains(.,'system test'))]
groupPattern                        xpath               //div[@class='panel-group']
list_groupPanel                     xpath               //a[@role='tab']
apps_inGroups                       xpath               //a[contains(text(),'${groupName}')]/ancestor::div[@class='panel panel-default']//div[contains(@class,'system-card front green')]
list_panelGroups                    xpath               //div[@class='panel panel-default']
list_groupHeading                   xpath               //div[@class='panel panel-default']/div[@class='panel-heading']//a
list_frontGroups                    classname           front-system
div_systemLogo                      xpath               //div[contains(@style,'${systemUrl}')]
txt_systemName                      xpath               //a/parent::span
list_panelCollapse                  xpath               //div[@class='panel-collapse collapse in']//div[@class='front-system']//div[contains(@class,'system-header ')]//div[@class='system-logo' and not(contains(.,'system test'))]
list_system                         xpath               //div[@class='monitor-name']  
button_Admin                                 xpath          //a[@class='dropdown-toggle']  
link_adminPage                               xpath          //a[text()='Admin page']
button_createNotification                    xpath          //button[text()='Create new notification']
div_selectMonitor                            xpath          //div[text()='Select monitors']
list_allApp                                  xpath          //div[text()='${appName}']
select_timeZone                              xpath          //b[contains(text(),'Time zone')]/parent::div/div[@role='combobox']
list_estTime                                 xpath          //li[contains(text(),'EST')]
select_endDate                               xpath          (//b[text()='End time']/..//div//input[@class='form-control'])[1]  
text_currentDate                             xpath          //td[@class='current-day']
text_endDate                                 xpath          //td[@class='current-day']/parent::tr/td[text()='${date}']    
button_OK                                    xpath          //button[text()='OK']
commentSection                               xpath          //textarea[@placeholder='Work being done']   
link_login                                   xpath          //a[text()='Sign in']
userName                                     xpath          //input[@placeholder ='Enter login']    
password                                     xpath          //input[@placeholder ='Enter password']
button_login                                 xpath          //button[text()='Login']    
button_save                                  xpath          //button[text()='Save']   
div_startDate                                xpath          (//input[@class='form-control'])[1]  
div_endDate                                  xpath          (//input[@class='form-control'])[2]   
link_adminButton                             xpath          //li[@class='login-tab dropdown']//a[@class='dropdown-toggle']
link_adminPage                               xpath          //a[text()='Admin page']  
select_system                                xpath           //div[text()='${appName}']
div_eventContainer                           xpath           //div[@class='event-item-container']
div_eventType                                xpath           //div[text()='${eventType}']
link_link_RegressionTest                     xpath           //a[contains(text(),'Regression Tests')]      
link_RegressionTestMonitor                   xpath           //a[contains(text(),'${monitorName}')]   

==================================================================================================================================
    