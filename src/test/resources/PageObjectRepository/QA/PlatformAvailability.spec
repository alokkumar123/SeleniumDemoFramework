# Object Definitions
=====================================================================================================================
div_app_systemApp                   xpath               //div[contains(@class,'system-card front green')]     
div_lastUpdatedTime                 xpath               //div[contains(@class,'system-card front green')]//div[@class='system-last-update']/span[2]
div_platformName                    xpath               //div[@class='back card green']//h5[text()='${appName}']/../..
lnk_productSupportLink              xpath               //a[text()='Need Product Support?']  
list_backgroundImageHeader          xpath               //div[@class='back card green']//h5 
txt_appTitles                       xpath               //span[@class='group-header panel-title']
link_tilte                          xpath               //a[text()='${text}'] 
appsInsideTitle                     xpath               //a[text()='${text}']/parent::span/parent::div/..//div[text()='Available']
url_systemLogo                      xpath               //div[contains(@class,'system-header ')]//div[contains(@style,'logo')]
groupPattern                        xpath               //div[@class='panel-group']
list_groupPanel                     xpath               //a[@role='tab']
apps_inGroups                       xpath               //a[contains(text(),'${groupName}')]/ancestor::div[@class='panel panel-default']//div[contains(@class,'system-card front green')]
list_panelGroups                    xpath               //div[@class='panel panel-default']
list_groupHeading                   xpath               //div[@class='panel panel-default']/div[@class='panel-heading']//a
list_frontGroups                    classname           front-system
div_systemLogo                      xpath               //div[contains(@style,'${systemUrl}')]
txt_systemName                      xpath               //a/parent::span
list_panelCollapse                  xpath               //div[@class='panel-collapse collapse in']//div[@class='front-system']//div[contains(@class,'system-header ')]//div[@class='system-logo' and not(contains(.,'system test'))]
div_systemUnderGroups               xpath               //div[@class='panel-collapse collapse in']//div[contains(@class,'system-card front green')]
div_lastUpdatedTimeUnderGroups      xpath               //div[@class='panel-collapse collapse in']//div[contains(@class,'system-card front green')]//div[@class='system-last-update']/span[2]
div_msgInfo                         xpath               //div[contains(@style,'${systemName}')]/ancestor::div[contains(@class,'system-header')]//div[@class='info-messages']
link_login                                   xpath          //a[text()='Sign in']
userName                                     xpath          //input[@placeholder ='Enter login']    
password                                     xpath          //input[@placeholder ='Enter password']
button_login                                 xpath          //button[text()='Login']
button_createNotification                    xpath          //button[text()='Create new notification']
div_selectMonitor                            xpath          //div[text()='Select monitors']
div_monitorName                              xpath          //div[text()='${systemName}'] 
div_endTimeBox                               xpath          (//b[text()='End time']/..//div//input[@class='form-control'])[1]
div_selectTimeMode                           xpath          //button[text()='Time']
div_mintueSlider                             xpath          (//div[@class='handle'])[2]  
div_commentBox                               xpath          //textarea[@placeholder='Work being done']  
btn_close                                    xpath          //button[text()='Close']   
btn_ok                                       xpath          //button[text()='OK']
link_platfromAvailabilityHome                xpath          //a[contains(text(),'Platform Availability Home')]
td_msgDislpyaing                             xpath          //span[text()='${message}']   
btn_save                                     xpath          //button[text()='Save']  
div_endTimeSecondBox                         xpath          (//b[text()='End time']/..//div//input[@class='form-control'])[2]  
div_startTimeBox                             xpath          (//b[text()='Start time']/..//div//input[@class='form-control'])[1]
div_startSecondTimeBox                       xpath          (//b[text()='Start time']/..//div//input[@class='form-control'])[2]
btn_prvMonth                                 xpath          //button[@class='prev-month']
div_enableCheckBox                           xpath          //div[@id='enabled']//input[@type='checkbox']
input_searchBox                              xpath          //input[@id='searchText']    
button_Admin                                 xpath          //li[@class='login-tab dropdown']//a[@class='dropdown-toggle']
logout_adminPage                             xpath          //a[text()='Log out']   
link_ok                                      xpath          //button[text()='OK']   
td_textTBD                                   xpath          //td[@data-search-text='TBD'] 
span_deleteMonitors                          xpath          //*[contains(text(),'${monitorName}')]/ancestor::tr//span[contains(@class,'glyphicon')]
button_delete                                xpath          //button[text()='Delete']
link_adminButton                             xpath          //li[@class='login-tab dropdown']//a[@class='dropdown-toggle']
link_adminPage                               xpath          //a[text()='Admin page']  
checkBox_NoEndDate                           xpath          //b[contains(text(),'No end date ')]/parent::div//input[@type='checkbox'] 
link_defaultUser                             xpath          //a[@id='techcheck-nav-dropdown']
link_logout                                  xpath          //a[text()='Log out']
btn_Ok                                       xpath          //button[text()='OK']  
div_evntType                                 xpath          //div[text()='Informational Message'] 
iframe_commentBox                            xpath           //iframe[@src='/summernote/editNotifications.html']
div_commentBox                               xpath            //div[@class='note-editable panel-body']
=====================================================================================================================
    