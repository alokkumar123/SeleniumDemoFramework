# Object Definitions

==================================================================================================================================
div_groupGroup                        xpath            //div[@class='panel-group']
div_groupNameList                     xpath            //div[@class='panel-heading']//a
div_appsInsideGroup                   xpath            //div[@class='panel-heading']//a[text()='${groupName}']/ancestor::div[contains(@class,'panel-default')]//div[@class='front-system']
txt_appName                           xpath            //a/parent::span  
link_platformAvailabilityHome         xpath            //a[contains(text(),'Platform Availability Home')]
singleApp                                    xpath          //div[contains(@style,'${appName}')]
==================================================================================================================================
    