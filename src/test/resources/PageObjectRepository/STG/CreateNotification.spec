# Object Definitions
==================================================================================================================================
btn_createNotification                       xpath           //button[text()='Create new notification']
div_selectMonitor                            xpath           //div[text()='Select monitors'] 
div_monitorName                              xpath           //div[text()='${monitorName}']  
div_commentSection                           xpath           //textarea[@placeholder='Work being done']
div_endTimeBox                               xpath           (//b[text()='End time']/..//div//input[@class='form-control'])[1]
div_selectTimeMode                           xpath           //button[text()='Time']
btn_close                                    xpath           //button[text()='Close']
div_mintueSlider                             xpath          (//div[@class='handle'])[2]
div_endTimeSecondBox                         xpath          (//b[text()='End time']/..//div//input[@class='form-control'])[2]
span_notification                            xpath           //span[contains(text(),'${message}')]     
input_searchBox                              xpath          //input[@id='searchText']
span_deleteNotification                      xpath          //*[text()='${message}']/ancestor::tr//span[contains(@class,'glyphicon')]
button_delete                                xpath          //button[text()='Delete']
btn_ok                                       xpath          //button[text()='OK']
btn_save                                     xpath          //button[text()='Save']
input_enabledCheckBox                        xpath          //div[@id='enabled']//input[@type='checkbox']   
==================================================================================================================================
    