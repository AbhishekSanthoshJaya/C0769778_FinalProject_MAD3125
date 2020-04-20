# C0769778_W2020_MAD3125_FP
<p align="center" ><img src="https://i.servimg.com/u/f93/18/45/29/87/mainlo10.png" alt="projectlogo" style="float: center; margin-right: 10px;"/></p>

## CUSTOMER BILL MANAGEMENT APP

## PROJECT CONTRIBUTORS

Abhishek Santhosh Jaya

## PROJECT DESCRIPTION
Final project: A program that calculates the total bills of a customer. A bill could be for the internet, hydro or mobile usage. A customer may have multiple bills. 

## PROJECT STRUCTURE
<img src="https://i93.servimg.com/u/f93/18/45/29/87/classt10.png" alt="Class Structure" style="float: left; margin-right: 10px;"/>

## PROJECT OUTPUT
Screenshot | Description
--- | ---
<img src="https://i93.servimg.com/u/f93/18/45/29/87/screen11.png" alt="splashscreen"/> | Custom splash screen that lasts for 5 seconds
<img src="https://i93.servimg.com/u/f93/18/45/29/87/logins10.png" alt="login"/> | Login Screen. Added custom text fields with icons and toggle password feature. User information is read from a json file. Hints and errors are added as well along with a remember me switch.
<img src="https://i93.servimg.com/u/f93/18/45/29/87/webvie10.png" alt="aboutus"/> | About us page done using webview. Webview activity is also the Kotlin class.
<img src="https://i93.servimg.com/u/f93/18/45/29/87/biomet10.png" alt="biometric"/> | Added biometric login option. Also gives the standard password login option.
<img src="https://i93.servimg.com/u/f93/18/45/29/87/invali10.png" alt="invalid_login"/> | Error displayed when login credentials are not valid.
<img src="https://i93.servimg.com/u/f93/18/45/29/87/custom15.png" alt="customerList"/> | List of customers shown in recycler view. Action bar buttons allow you to login and add a customer. Add customer button also added in the right corner.
<img src="https://i93.servimg.com/u/f93/18/45/29/87/custom14.png" alt="customerAddition"/> | Customer addition form. Fields cannot be left empty.
<img src="https://i93.servimg.com/u/f93/18/45/29/87/emailv10.png" alt="invalidEmail"/> | Email validation done with regex.
<img src="https://i93.servimg.com/u/f93/18/45/29/87/newlya10.png" alt="newcustomer"/> | Newly added customer is not present in the customer list. You can also login with the username and password.
<img src="https://i93.servimg.com/u/f93/18/45/29/87/billsv10.png" alt="billslist"/> | Clicking on a customer gives you an overview of his bills and the total amount to be paid.
<img src="https://i93.servimg.com/u/f93/18/45/29/87/custom16.png" alt="emptybills"/> | Clicking on a customer without any bills displays the no bills text. You can add bills and logout using the menu.
<img src="https://i93.servimg.com/u/f93/18/45/29/87/bill_a10.png" alt="newbill"/> | Adding a new bill to a customer. Spinner is used to select the bill type. Fields cannot be left empty.
<img src="https://i93.servimg.com/u/f93/18/45/29/87/invali11.png" alt="invalidnumber"/> | Mobile number validated while trying to add a new mobile bill.
<img src="https://i93.servimg.com/u/f93/18/45/29/87/newly_10.png" alt="addedbill"/> | The newly added bill shows up for the customer with total amount.
<img src="https://i93.servimg.com/u/f93/18/45/29/87/detail19.png" alt="detailedbill"/> | Clicking on a bill shows all the information for that particular bill.

## AGILE USED
[Click here for GITSCRUM link](https://gitscrum.com/abysztech/c0769778-w2020-mad3125-fp)

## REFERENCES 
* [Android.jlelse.eu](https://android.jlelse.eu/material-design-for-android-523996401fc1) - Used for material design implementation
* [Abhiandroid.com](https://abhiandroid.com/programming/json#JSONArray_Parsing_methods) - Used for json parsing
* [JournalDev.com](https://www.journaldev.com/14748/android-textinputlayout-example) - Used in designing TextInputLayouts
* [Medium.com](https://medium.com/viithiisys/android-perfect-way-to-create-splash-screen-ca3c5bee137f) - Creating a splash screen
* [Thecodeexpo.com](https://thecodeexpo.blogspot.com/2018/09/login-screen-remember-me-example.html) - Implementing remember me switch using shared preferences
* [Develop.android.com](https://developer.android.com/guide/topics/ui/layout/recyclerview) - Working with recycler views
* [HowtoDoinJava.com](https://howtodoinjava.com/regex/java-regex-validate-email-address/) - Email validation regex
* [Sitepoint.com](https://www.sitepoint.com/transfer-data-between-activities-with-android-parcelable/) - Implementing parcelable transfer
* [Youtube.com](https://www.youtube.com/watch?v=hwe1abDO2Ag) - Creating a datePicker
* [Stackoverflow.com](https://stackoverflow.com/questions/3646415/how-to-create-edittext-with-rounded-corners) - Creating custom textboxes
* [Joda.org](https://www.joda.org/joda-time/index.html) - Working with Joda-Time
