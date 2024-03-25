# API Links and Parameters

# User
## Transaction:View all users
GET:https://events-api-iuta.onrender.com/user/view-all  

## Transaction:Add a user
POST:https://events-api-iuta.onrender.com/user/add  
Request Body Parameters  
firstname:Text  
lastname:Text  
email:Text  
password:Text  
user_type:Text(user, admin, organizer, pending)  

## Transaction:Login
GET:https://events-api-iuta.onrender.com/user/login  
Request Body Parameters   
email:Text  
password:Text  

## Transaction:View user info
GET:https://events-api-iuta.onrender.com/user/view  
Request Body Parameters   
email:Text  

## Transation:Update user type
PUT:https://events-api-iuta.onrender.com/user/update-status  
Request Body Parameters  
email:Text  
status:Text(user, admin, organizer, pending)  


# Event
## Transaction:View all events
GET:https://events-api-iuta.onrender.com/event/view-all  

## Transaction:Add an event
POST:https://events-api-iuta.onrender.com/event/add   
Request Body Parameters  
eventname:Text  
organizer:Text  
description:Text  
location:Text  
startdate:yyyy-mm-dd 
enddate:yyyy-mm-dd 
status:Text (ongoing, upcoming, cancelled, finished)  

## Update event status
PUT:https://events-api-iuta.onrender.com/event/update-status
Request Body Parameters  
eventid:Text  
status:Text  

## Update event thumbnail
PUT:https://events-api-iuta.onrender.com/event/update-thumbnail
Request Body Parameters  
eventid:Text  
thumbnail:Text   


# AttendEvent
## Transaction:View all attendee ids and corresponding event ids  
GET:https://events-api-iuta.onrender.com/attend-event/view-all  

## Transaction:User is interested in the event
POST:https://events-api-iuta.onrender.com/attend-event/interested  
Request Body Parameters  
userid:Text  
eventid:Text

## Transaction:User is approved for the event
PUT:https://events-api-iuta.onrender.com/attend-event/approved  
Request Body Parameters  
userid:Text  
eventid:Text

# Reviews
## Transaction:View all reviews by event id
GET:https://events-api-iuta.onrender.com/reviews/view-by-event  
Request Body Parameters
eventid:Text

## Transaction:Add a review
POST:https://events-api-iuta.onrender.com/reviews/add  
Request Body Parameters
userid:Text
eventid:Text
review:Text

## Transaction:View a review from a user and event
GET:https://events-api-iuta.onrender.com/reviews/view  
Request Body Parameters
userid:Text
eventid:Text