*** Settings ***
Documentation           Test to check RF envirement w/ SeleniumLibrary & ChromeDriver
Library         SeleniumLibrary   15.0   5.0

*** Variables ***
${Browser}      Chrome

${URL}          http://localhost:8080
${Sleep}        5

*** Test Cases ***
View Shoppinglist Test Case
        Open Browser    ${URL}       ${BROWSER}
	Sleep	${SLEEP}
        Page Should Contain     Shopping List Example

Add tea to the input field
        Input Text      new-item-title  Tea
        Page Should contain     Tea
        Open Browser    ${URL}       ${BROWSER}
	Sleep	${SLEEP}
        

Check Contents Test Case
        Page Should Contain     Milk
        Page Should Contain     Eggs
        Page Should Contain     Bread

check if Page contains statement
        Page Should contain     There are 3 items in the shopping list

*** Keywords ***
