# Object Definitions
==========================================================================================================================
modal_htmlCodeSniffer                   id                  HTMLCS-wrapper		
txt_htmlCodeSnifferHeader               classname           HTMLCS-header
lnk_close                               classname           HTMLCS-close
div_settings                            classname           HTMLCS-settings
div_useStandard                         id                  HTMLCS-settings-use-standard
div_issueCount                          id                  HTMLCS-settings-issue-count
div_issueCountHelp                      id                  HTMLCS-settings-issue-count-help
div_viewReport                          id                  HTMLCS-settings-view-report
div_issueTileError                      css                 .HTMLCS-error
div_issueTileWarning                    css                 .HTMLCS-warning
div_issueTileNotices                    css                 .HTMLCS-notice
txt_issueTitleValue                     xpath               //div[contains(@class,'${issueType}')]/div[@class='HTMLCS-tile-text']/strong
drpdown_useStandard                     id                  HTMLCS-settings-use-standard-select
label_checkboxStatus                    xpath               //div[contains(@class,'${issueType}')]/label
span_checkboxSlider                     xpath               //div[contains(@class,'${issueType}')]//span[@class='HTMLCS-checkbox-slider']
btn_pageNumber                          css                 .HTMLCS-page-number
btn_nextPage                            css                 .HTMLCS-nav-button.HTMLCS-next
txt_errorMsg                            xpath               //span[@class='HTMLCS-issue-type HTMLCS-error']/following-sibling::span
btn_nextEnabled                         xpath               //div[@class='HTMLCS-navigation']//span[3][not(contains(@class,'HTMLCS-disabled'))]
list_accessibilityIssues                xpath               //ol[@class='HTMLCS-issue-list'][${index}]//span[1]
txt_issueTitleReport                    xpath               //ol[@class='HTMLCS-issue-list'][${index}]//span[1]/following-sibling::span



==========================================================================================================================