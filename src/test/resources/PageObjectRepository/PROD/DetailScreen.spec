# Object Definitions

==================================================================================================================================
div_errorMessage                             xpath         //div[contains(text(),'Detailed data view coming soon...')]
txt_appName                                  xpath         //a/parent::span
div_app_systemApp                            xpath         //div[contains(@class,'system-card front green')]
allApps                                      xpath         //div[@class='back card green']//h5[text()='${appName}']/../..
link_breadCrumb                              xpath         //a[contains(text(),'Platform Availability Home')]/parent::span[text()='${appName}']
link_platfromAvailabilityHome                xpath         //a[contains(text(),'Platform Availability Home')]
listOfApps                                   xpath         //div[@class='back card green']//h5
text_screenPage                              xpath         //h6[text()='Platform Availability']
list_dropdownOptions                         xpath         //li[text()='${string}'] 
span_DropDownSelector                        xpath         (//div[contains(@class,'rw-dropdownlist')])[1]
span_timeZoneDropDownSelector                xpath         (//div[contains(@class,'rw-dropdownlist')])[2]
list_timezonedropdownOptions                 xpath          //li[contains(text(),'${timeZone}')] 
applicationCurrentTime                       xpath          //td[text()='${systemTime}']
span_noIssues                                xpath          //span[text()='No Issues']
span_minorDisruption                         xpath          //span[text()='Minor disruption'] 
span_serviceTemporarilyUnavailable           xpath          //span[text()='Service temporarily unavailable'] 
span_plannedMaintenance                      xpath          //span[text()='Planned maintenance'] 
tr_lastHours                                 xpath          //td[text()='${systemTime}']/parent::tr/parent::tbody/tr[@class='rows-today']
text_currentMonth                            xpath          //div[contains(text(),'${currentMonth}')]
text_days                                    xpath          //tr[@class='title-day']/th[contains(text(),'${day}')] 
hover_anyday                                 xpath          //div[@class='day' and text()='${day}']  
text_dayHeading                              xpath          //h4
app_singleApp                                xpath          //div[text()='Available']
btn_currnetInformationAlerts                 xpath          //div[@class='info-alerts']
txt_informationalAlert                       xpath          //h4[text()='Informational alerts']
btn_close                                    xpath          //button[text()='Close']
img_AppColor                                 xpath          //h5[text()='${appName}']/ancestor::div[1]//img
text_appAvailability                         xpath          //h5[text()='${appName}']/ancestor::div[2]//div[@class='status-text']
table_systemStatus                           xpath          //table[contains(@class,'system-status')]
singleApp                                    xpath          //div[contains(@style,'${appName}')]     
greenColor_timeFrame                         xpath          //div[@class='green']       
div_appColorOnPlatform                       xpath          //div[contains(@style,'${appName}')]/ancestor::div[contains(@class,'system-header green')]//div[contains(@class,'system-status-icon-container')]
td_colorFrame                                xpath          //td[contains(@class,'cell-status')]/div[@class='${color}']/../.. 
tr_colorTime                                 xpath          (//td[contains(@class,'cell-status')]/div[@class='${color}']/../../td)[${s}]
td_colorMinute                               xpath          //td[contains(@class,'cell-status')]/div[contains(@class,'${color}')]
redColor                                     xpath          //td[contains(@class,'cell-status')]/div[@class='${color}']/../..//div[@class='${color}']
minute                                       xpath          //td[contains(text(),'${hours}')]/..//td[not(contains(@style,'text-align'))]/div 
==================================================================================================================================
    