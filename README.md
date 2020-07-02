# Liferay integration with MS Dynamics POC

This POC goal is to show-case how we can integrate Liferay DXP with Microsoft Dynamics CRM, not only to pull information from MS Dynamics to be displayed in Liferay but also to push information created on Liferay to MS Dynamics. The challenge we proposed to ourselves was to be able to: 
* List MS Dynamics accounts on a Liferay widget; 
* Create a new MS Dynamics account from Liferay. 

The integration approach is leveraging the [MS Dynamics Web API](https://docs.microsoft.com/en-us/previous-versions/dynamicscrm-2016/developers-guide/mt608128(v=crm.8)?redirectedfrom=MSDN#web-api), which implements the OData (Open Data Protocol) v4. 
OData is an OASIS standard for building and consuming RESTful APIs over rich data sources. 

On the Liferay DXP side, we have created 3 main OSGi modules: 
* Configuration module, which allows us to configure the connection details to the target MS Dynamics account; 
* Rest client module, responsible for calling the MS Web API endpoints; 
* Front-end widget, to display the data and possible actions to our end users.  

A demo of this POC in action can be found [here](https://www.youtube.com/watch?v=ZZTKHMwlJlw)

# Additional Information

To replicate this POC, you will need to have access to a MS Dynamics account. Microsoft allows you to get a free trial account that will be usable for some time, but as one can expect, it has some limitations regarding what you can do with it. One example of the limitations you will encounter is the ability to create specific applicational users, with the required access to your MS Dynamics account. To overcome this issue in the context of this POC, we used a default MS Dynamics user to get an OAuth token, that we then set in the Liferay settings, allowing us to connect to MS Dynamics. Please bear in mind that the OAuth token will be valid for just a few hours. Please find below some useful links, regarding authentication and using postman to query data using the MS Web API:
* [Query Data using the Web API](https://docs.microsoft.com/en-us/powerapps/developer/common-data-service/webapi/query-data-web-api)
* [Set up a Postman environment](https://docs.microsoft.com/en-us/powerapps/developer/common-data-service/webapi/setup-postman-environment#connect-with-your-common-data-service-environment)
* [Use Postman to perform operations with the Web API](https://docs.microsoft.com/en-us/powerapps/developer/common-data-service/webapi/use-postman-perform-operations)

Obtaining the OAuth token with postman would look like this:

![MS Token with postman](https://github.com/fafonso/liferay-ms-dynamics-poc/raw/master/screenshots/getting-ms-oauth-token.gif)

# Contributions

Feel free to send me a pull request if you have any improvements ideas or get in touch if you have any questions / suggestions.