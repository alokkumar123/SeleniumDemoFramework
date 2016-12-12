Page Title: Instructor SSO - Instructor Resource Center

# Object Definitions
==========================================================================================================================
txt_username    		                id	                 	emailId
txt_password    		                id		                password
btn_signin     			                css		                input[type='submit']
img_cengageLogo                                 css                             #logos
btn_signout                                     xpath                           //a[contains(.,'Sign Out')]                                          
txt_searchField                                 css                             #searchword
btn_course                                      xpath                           //span[@class='restitle' and contains(text(),'Automation Test')]
btn_createCourse                                xpath                           //div[@class='courseManage']//*[@class='greenBtn']
page_coulmn                                     id                              columnMain
btn_nextCalender                                xpath                           (//*[text()='Next'])[2]
link_manageCourse                               xpath                           //a[@href='manageCourseKey.htm']
lnk_courseName                                  xpath                           //ul[@class='resources']//span[@class='restitle'][normalize-space(text())='${courseName}']
==========================================================================================================================