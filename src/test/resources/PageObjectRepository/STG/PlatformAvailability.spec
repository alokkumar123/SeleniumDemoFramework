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
url_systemLogo                      xpath               //div[contains(@class,'system-header ')]//div[@class='system-logo' and not(contains(.,'system test'))]
groupPattern                                 xpath          //div[@class='panel-group']
list_groupPanel                              xpath          //a[@role='tab']
apps_inGroups                                xpath          //a[contains(text(),'${groupName}')]/ancestor::div[@class='panel panel-default']//div[contains(@class,'system-card front green')]
     
=====================================================================================================================
    