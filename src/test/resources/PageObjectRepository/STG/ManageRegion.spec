# Object Definitions
==================================================================================================================================
list_regions                xpath               //table[@class='app-table']//td[1]/*
span_trashIcon              xpath               (//table[@class='app-table']//td[1]/*)[${index}]/ancestor::tr/td[last()]/span[contains(@class,'trash')]
btn_delete                  xpath               //button[text()='Delete']
td_searchedSystem           xpath               //table[@class='app-table']/tbody/tr/td[2]
input_searchBox             xpath               //input[@id='searchText']
==================================================================================================================================
    