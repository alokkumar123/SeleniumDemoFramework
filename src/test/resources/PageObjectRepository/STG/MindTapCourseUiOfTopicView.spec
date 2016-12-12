# Object Definitions
==========================================================================================================================

size_chapterName                            xpath                            //*[@class='topic-name-depth-0']
txt_chapterName                             xpath                            (//div[contains(text(),'Chapter ${number}')])[1]
txt_chapterSubChp                           xpath                            //*[@class='jump-link' and text()='${text}']
ui_topicView                                xpath                            //*[@class='topic-plank']//div[@class='topic-name-depth-0' and text()='${text}']/../following-sibling::div[@class='cl-topic']
btn_Add                                     xpath                            //button[@class='add-to-topic-button']
==========================================================================================================================