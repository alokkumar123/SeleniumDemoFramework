Page Title: Manage Courses

# Object Definitions
==========================================================================================================================
txt_manageCourseHeader				xpath                           //div[@id='columnMain']//h1
btn_manageCourse                                css                             .orangeBtn
txt_courseKey                                   xpath                           //label[@for='courseKey' and @style] 
edtBox_timeZone                                 xpath                           .//select[@id='timeZone']//option[@selected='selected']
txt_courseName                                  id                              courseName
btn_cancel                                      css                             .btns_rt
txt_organisationName                            id                              welcomeBox
btn_editCourseDetails				xpath                           //a[normalize-space(text())='${CourseName}']/ancestor::tr//a[@title='Edit Course']
==========================================================================================================================