Page Title: MT4

# Object Definitions
==========================================================================================================================
img_mindTapLogo							xpath			//div[contains(@class,'mindtap-logo')]
div_loaderSpinner						classname		LoadingScreen__spinner
txt_expandedCourseMaterial				xpath			//div[contains(@class,'expanded')]/div[@class='topic-plank']/div
icon_readingActivity					xpath			(//div[contains(@class,'icon reading')])[1]
txt_readingActivityFromCourse			xpath			((//div[contains(@class,'icon reading')])[1]/ancestor::div[@class='flex-row']/div[@class='title launchable']/span)[1]
span_enlargeIcon						xpath			//div[@id='ActivityFrameHeader']//span[contains(@class,'icon-enlarge')]
span_crossIcon							xpath			//div[@id='ActivityFrameHeader']//span[contains(@class,'icon-cross')]
span_shrinkIcon							xpath			//span[contains(@class,'icon-shrink')]
icon_videoActivity						xpath			(//div[contains(@class,'icon media')])[1]
txt_videoActivityFromCourse				xpath			((//div[contains(@class,'icon media')])[1]/ancestor::div[@class='flex-row']/div[@class='title launchable']/span)[1]
txt_ChapterHeading                      xpath                   //div[@class='ActivityFrame-header']//h3
btn_ReadingActivityNext                                 xpath                   //button[@id='nextButton']
btn_tocButton                                           css                     #tocButton  
iframe_mindAppActivity                  css                    .cas-mindApp-activity-iframe
btn_enlargeIconReadingActivity                          css                    .ActivityFrame-icon.icon-enlarge
btn_crossIconReadingActivity                          css                      .ActivityFrame-icon.icon-cross

==========================================================================================================================