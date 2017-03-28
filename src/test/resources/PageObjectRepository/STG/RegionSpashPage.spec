# Object Definitions
==================================================================================================================================
td_systemApp                            xpath           //td//a[text()='${appName}']   
div_regionField                         xpath           //div[@id='region']//div[contains(@class,'rw-dropdownlist ')]//div
btn_save                                xpath           //button[text()='${button}']   
singleApp                               xpath           //div[contains(@style,'${appName}')]
link_admin                              xpath           //li[@class='login-tab dropdown']//a[@class='dropdown-toggle']
link_adminPage                          xpath           //a[text()='Admin page']
li_otherRegion                          xpath           //div[@id='region']//li[text()='${region}']         
div_spalshLocation                      xpath           //div[@class='location-link']/a
option_setRegion                        xpath           //option[text()='${region}']
btn_ok                                  xpath           //button[contains(text(),'OK')]     
div_groupGroup                          xpath           //div[@class='panel-group']
div_groupNameList                       xpath           //div[@class='panel-heading']//a
div_appsInsideGroup                     xpath           //div[@class='panel-heading']//a[text()='${groupName}']/ancestor::div[contains(@class,'panel-default')]//div[@class='front-system']
txt_appName                             xpath           //a/parent::span  
link_platformAvailabilityHome           xpath           //a[contains(text(),'Platform Availability Home')]
==================================================================================================================================
    