# Object Definitions

====================================================================================
allApps                                      xpath         //div[@class='back card green']//h5[text()='${appName}']/../..
link_breadCrumb                              xpath         //a[contains(text(),'Platform Availability Home')]/parent::span[text()='${appName}']
link_platfromAvailabilityHome                xpath         //a[contains(text(),'Platform Availability Home')]
listOfApps                                   xpath         //div[@class='back card green']//h5
text_screenPage                              xpath         //h6[text()='Platform Availability']
list_dropdownOptions                         xpath         //li[text()='${string}'] 
span_DropDownSelector                        xpath         (//span[@aria-label="open dropdown"])[1]    
span_timeZoneDropDownSelector                xpath         (//span[@aria-label="open dropdown"])[2]
list_timezonedropdownOptions                 xpath          //li[contains(text(),'${string}')] 
applicationCurrentTime                       xpath          //td[text()='${systemTime}']
span_noIssues                                xpath          //span[text()='No Issues']
span_minorDisruption                         xpath          //span[text()='Minor disruption'] 
span_serviceTemporarilyUnavailable           xpath          //span[text()='Service temporarily unavailable'] 
span_plannedMaintenance                      xpath          //span[text()='Planned maintenance'] 
tr_lastHours                                 xpath          //td[text()='4 pm']/parent::tr/parent::tbody/tr[@class='rows-today']
text_currentMonth                            xpath          //div[contains(text(),'${currentMonth}')]
text_days                                    xpath          //tr[@class='title-day']/th[contains(text(),'${day}')] 
hover_anyday                                 xpath          //div[@class='day' and text()='${day}']  
text_dayHeading                              xpath          //h4[contains(text(),'${dayNo}')]
app_singleApp                                xpath          //div[text()='Available']
btn_currnetInformationAlerts                 xpath          //div[@class='info-alerts']
txt_informationalAlert                       xpath          //h4[text()='Informational alerts']
btn_close                                    xpath          //button[text()='Close']
====================================================================================
    