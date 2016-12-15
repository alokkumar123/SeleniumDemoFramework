# Object Definitions

==================================================================================================================
app                                     xpath               //div[@class='back card green']//h5[text()='${appName}']/../..
breadCrumb                              xpath               //a[contains(text(),'Platform Availability Home')]/parent::span[text()='${appName}']
platfromAvailabilityHome                xpath               //a[contains(text(),'Platform Availability Home')]
app_List                                xpath               //div[@class='back card green']//h5
screenPage                              xpath               //h6[text()='Platform Availability']
dropdownOptions                         xpath               //ul[@id='rw_19__listbox']/li[text()='${string}'] 
DropDownSelector                        xpath               (//div[contains(@class,'rw-dropdownlist')])[1]    
timeZoneDropDownSelector                xpath               (//div[contains(@class,'rw-dropdownlist')])[2]
timezonedropdownOptions                 xpath               //ul[@id='rw_20__listbox']/li[contains(text(),'${string}')] 
==================================================================================================================
    