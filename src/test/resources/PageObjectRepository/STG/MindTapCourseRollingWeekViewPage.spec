Page Title: MT4

# Object Definitions
==========================================================================================================================
txt_weekNo                                           xpath                         //span[@aria-label='Week ${weekNo}']
txt_dateFirstWeek                                    xpath                         (//span[@class='date-range'])[1]
txt_currentWeek                                      xpath                         //*[@id='current-week-heading']/following-sibling::span
txt_currentDayAndDate                                xpath                         //span[@id='current-day-icon-no-content']/following-sibling::span
txt_currentWeekIcon                                  xpath                         //*[@id='current-week-icon' and @title='Current Week']
txt_currentDayAndDateIcon                            xpath                         //*[@id='current-day-icon-no-content' and @title='Current Day']
icon_rollingWeekview                                 id                            rollingWeekviewButton
icon_expandView                                      xpath                         //span[@aria-label='Expand Week ${weekNo}']
icon_collapseView                                    xpath                         //span[@aria-label='Collapse Week ${weekNo}']
txt_currentWeekNumber                                xpath                         //*[@id='current-week-heading']/preceding-sibling::h4//span
txt_addToWeekButton                                  xpath                         //button[@class='add-to-week-button']
icon_calender                                        xpath                         //button[@id='rollingWeekviewButton']//*[contains(@class,'calendar')]
verify_rollingWeekView                               xpath                         //button[@id='rollingWeekviewButton']/following-sibling::button[@id='topicviewButton']
txt_CourseMaterials                                  xpath                         //div[text()='Course Materials']

==========================================================================================================================