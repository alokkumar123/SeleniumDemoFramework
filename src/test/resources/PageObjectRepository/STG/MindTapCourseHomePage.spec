Page Title: MT4

# Object Definitions
==========================================================================================================================
modal_errorContent					classname		ErrorModal__dialog
modal_errorHeader					classname		ErrorModal__heading
img_mindTapLogo						xpath			//div[contains(@class,'mindtap-logo')]
div_toolBarManager					xpath			//div[@id='workflowManagerWrapper2']//div[@class='cl-course-pane-navbar']
btn_topicView						id			topicviewButton
txt_buildVer                                            xpath                   //div[@style="display:none"]    
icon_expandCourseMaterial				xpath			(//div[@class='topic-plank']/button[contains(@class,'toggle')])[${index}]
div_expandedCourseMaterial				xpath			//div[@class='add-to-topic']/following-sibling::div[@class='list-column']
btn_closeMindtapLogo                                    xpath                   //*[@class='close']
btn_userDropdown                                        xpath                   //*[@id='userDropdown']
btn_userMenu                                            id                      userDropdown
drpdown_userMenu                                        classname               dropdown-menu
list_userMenuOptions                                    xpath                   //ul[@class='dropdown-menu']//a
dropdown_menu                                           xpath                   //*[@class='dropdown-menu' and @role='menu']
btn_signin                                              xpath                   //*[@type='submit']
input_email                                             xpath                   //input[@name='email']
btn_topicViewIcon                                       xpath                   //*[@id='rollingWeekviewButton']/following-sibling::button[@id='topicviewButton']
txt_Chapter                                             xpath                   //div[@class='topic-name-depth-0'] 
txt_CourseTitle                                         xpath                   //*[@class='course-title'] 
btn_logout                                              xpath                   //a[text()='Logout']
icon_topicListIcon                                      xpath                   //*[@id='topicviewButton']//span[contains(@class,'list')]
txt_ra_title                                            xpath                   //h1[contains(.,'Chapter Introduction')]
txt_app_title                                           xpath                   //h3[contains(.,'Merriam-Webster Dictionary Lookup')]
-------------------------------------------------------------------------------------------------------------------

# AppDock Object Definitions
-------------------------------------------------------------------------------------------------------------------
lnk_appDock                             xpath                   //div[@class='AppDockContainer']//div[text()='${appDock}']/preceding-sibling::img
frame_appDock                           classname                AppDockFrame
frame_AppDockFrame                      css                     .AppDockFrame-iFrame 
txt_appDockHeader                       xpath                   //div[@class='AppDockFrame-header']/h3[contains(@class,'title')]
lnk_appDockCross                        xpath                   //span[@class='AppDockFrame-icon icon-cross']
lnk_appDockEnlarge                      xpath                   //div[@class='AppDockFrame']//span[contains(@class,'enlarge')]
lnk_appDockShrink                       xpath                   //span[contains(@class,'shrink')]
btn_GlosseryAlphabets                   xpath                   (//div[@class='Glossary-filterLetter']//div)[${number}]
txt_GlosseryAlphabets                   xpath                   ((//div[@class='Glossary-filterLetter']//div)[${number}])/text() 
count_GlosseryAlphabets                 xpath                   //div[@class='Glossary-filterLetter']//div 
txt_itemTerm                            xpath                   (//div[@class='Glossary-itemTerm'])[1]
txtbox_Search                           classname               word
btn_submit                              classname               submit
txt_SearchResult                        xpath                   //div[@id='headword']//h1
txt_ChapterFlashcards                   xpath                   //td[@class='FlashCards-deckList-deckTitle']/a  
txt_hover                               xpath                   //img[@alt='${text}']//following-sibling::div[text()='${text}']
-------------------------------------------------------------------------------------------------------------------

# User Menu Object Definitions
-------------------------------------------------------------------------------------------------------------------
btn_userMenu                            id                      userDropdown
drpdown_userMenu                        classname               dropdown-menu
list_userMenuOptions                    xpath                   //ul[@class='dropdown-menu']//a
text_Course_setting                     xpath                   //*[text()='Course Settings']
-------------------------------------------------------------------------------------------------------------------

# System Check Object Definitions
-------------------------------------------------------------------------------------------------------------------
modal_systemCheckContent                classname               modal-content
txt_systemCheckHeader                   classname               modal-title
lnk_closeModal                          classname               close
-------------------------------------------------------------------------------------------------------------------

# Search Content Object Definitions
-------------------------------------------------------------------------------------------------------------------
div_searchToolBarIcon                   xpath                   //span[contains(@class,'icon-search')]
modal_searchContent                     classname               Search
txt_searchHeader                        classname               Search-content-heading
lnk_closeSearchModal                    xpath                   //span[contains(@class,'Search-close-button')]
input_searchTextBox                     id                      Text-Input-Icon
btn_search                              xpath                   //div[contains(@class,'Search-btn')]
lnk_searchTips                          classname               Search-help
dialog_searchResults                    classname               Search-results   
txt_searchResultsHeading                classname               Search-results-heading
list_searchResultsDescription           classname               Search-results-block-description
-------------------------------------------------------------------------------------------------------------------

# Help Icon Object Definitions
-------------------------------------------------------------------------------------------------------------------
div_helpTourIcon                        xpath                   //span[contains(@class,'help icon')]
overlay_joyRideToolTip                  xpath                   //div[contains(@class,'joyride-tooltip--animate')]
txt_joyRideToolTipHeader                classname               joyride-tooltip__header
lnk_closeJoyRideToolTip                 xpath                   //a[contains(@class,'joyride-tooltip__close')]
lnk_tooltipFooter                       xpath                   //div[@class='joyride-tooltip__footer']/a[text()='${lnkName}']
popupOutside                            xpath                   //div[@data-type='close']
-------------------------------------------------------------------------------------------------------------------

