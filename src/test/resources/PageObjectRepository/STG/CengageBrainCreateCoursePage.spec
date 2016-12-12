Page Title: Create Course

# Object Definitions
==========================================================================================================================
btn_createNewCourse                             id                              createNewCourse
btn_continue                                    css                             .button
page_createCourse                               id                              create_Course
edtBox_courseName                               css                             .courseName
calendar_startDate                              css                             #calendar1
calendar_endDate                                css                             #calendar2
selectdate                                      xpath                           //*[contains(@class,'state-active')] 
edtBox_endDate                                  id                              endDate
edtBox_startDate                                id                              beginDate
btn_createCourseCengage                         xpath                           //a[@class='button']
msg_courseCreated                               xpath                           //*[text()='The course has been created:']
link_course                                     xpath                           //*[text()='${courseNamedate}']
delete                                          xpath                           //a[contains(text(),'${courseName}')]/../..//a[@title='Delete Course']

==========================================================================================================================