# Object Definitions
==========================================================================================================================
modal_appSplashContent				classname		modal-content
txt_appSplashHeader				xpath			//div[contains(@class,'splashheader')]
btn_appSplashClose				classname		close
list_pillNavigationLinks			xpath			//div[contains(@class,'AppSplashModal')]//ul[contains(@class,'nav-pills')]//a
list_footerNavigationLinks			xpath			//div[@class='AppSplashModal-copyright']//ul[@class='footer-nav']/li
h2_appSplashModalCourseName			xpath			//div[contains(@class,'splash-bookinfo')]/div[contains(@class,'snapInfo')]/h2[contains(@class,'AppSplashModal-courseName')]
txt_appSplashModalAuthorName			xpath			//ul[@class='AppSplashModal-bookCredits']/li[contains(@class,'book-authors')]
img_appSplashModalCoverPage			xpath			//div[contains(@class,'AppSplashModal-navigationTabs')]//img[@class='img-responsive']
p_appSplashModalCourseDate			classname		AppSplashModal-courseDate
btn_appSplashModalGo				xpath			//button[contains(@class,'AppSplashModal-goButton')]
span_appSplashModalCopyRightInfo		xpath			(//p[@class='AppSplashModal-copyrightLine']/span)[${index}]
h3_appSplashModalTabHeader			xpath			//div[contains(@class,'AppSplashModal-navigationTabs')]//div[contains(@class,'tab-pane fade active')]//h3
txt_appSplashCourseDetail			xpath			//div[contains(@class,'tab-pane fade active')]//*[text()='${courseDetail}']/following-sibling::p[1]		
btn_supportInformation                          xpath                   //*[text()='Support Information']
txt_courseKey                                   xpath                   (//h4[contains(text(),'Course Key')]/following-sibling::p)[1]
txt_organisationName                            xpath                   (//h4[contains(text(),'Course Key')]/following-sibling::p)[2]
txt_buildversion                                xpath                   (//h4[contains(text(),'Course Key')]/following-sibling::p)[3]
==========================================================================================================================