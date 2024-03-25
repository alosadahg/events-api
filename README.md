# API Links and Parameters
  
# User
## Transaction: View all users
GET:https://events-api-iuta.onrender.com/user/view-all  
Returns: JSON
  
## Transaction: Add a user
POST:https://events-api-iuta.onrender.com/user/add  
Request Body Parameters  
firstname:Text  
lastname:Text  
email:Text  
password:Text  
user_type:Text(user, admin, organizer, pending)  
Returns: String
  
## Transaction: Login
POST:https://events-api-iuta.onrender.com/user/login  
Request Body Parameters   
email:Text  
password:Text  
Returns: JSON if successful, String if failed  
  
## Transaction: View user info
POST:https://events-api-iuta.onrender.com/user/view  
Request Body Parameters   
email:Text  
Returns: JSON if successful, String if failed  
  
## Transaction: Update user type
PUT:https://events-api-iuta.onrender.com/user/update-status  
Request Body Parameters  
email:Text  
status:Text(user, admin, organizer, pending)  
Returns: JSON if successful, String if failed  
  
## Transaction: Update user information
PUT:https://events-api-iuta.onrender.com/user/update-user-info  
Request Body Parameters  
firstname:Text  
lastname:Text  
email:Text  
password:Text  
Returns: 0 if failed, 1 if successful  
  
# Event
## Transaction: View all events
GET:https://events-api-iuta.onrender.com/event/view-all
Returns: JSON

## Transaction: View all events by an organizer
GET:https://events-api-iuta.onrender.com/event/view-by-organizer
Request Body Parameters
organizerid:Text 
Returns: JSON
  
## Transaction: Add an event
POST:https://events-api-iuta.onrender.com/event/add   
Request Body Parameters  
eventname:Text  
organizer:Text  
description:Text  
location:Text  
startdate:yyyy-mm-dd 
enddate:yyyy-mm-dd 
status:Text (ongoing, upcoming, cancelled, finished) 
thumbnail:Text 
Returns: JSON if successful, String if failed  
  
## Transaction: Update event status
PUT:https://events-api-iuta.onrender.com/event/update-status
Request Body Parameters  
eventid:Text  
status:Text (ongoing, upcoming, cancelled, finished)  
Returns: JSON if successful, String if failed  
  
## Transaction: Update event thumbnail
PUT:https://events-api-iuta.onrender.com/event/update-thumbnail
Request Body Parameters  
eventid:Text  
thumbnail:Text   
Returns: JSON if successful, String if failed   
  
## Transaction: Upvote
PUT:https://events-api-iuta.onrender.com/event/upvote
Request Body Parameters
eventid:Text 
Returns: JSON if successful, String if failed  
  
## Transaction: Update event information
PUT:https://events-api-iuta.onrender.com/event/update-event-info   
Request Body Parameters  
eventname:Text  
organizer:Text  
description:Text  
location:Text  
startdate:yyyy-mm-dd 
enddate:yyyy-mm-dd 
status:Text (ongoing, upcoming, cancelled, finished)  
Returns: 0 if failed, 1 if successful  
  
## Transaction: Delete an event
DELETE:https://events-api-iuta.onrender.com/event/delete
Request Body Parameters
eventid:Text 
Returns: 0 if failed, 1 if successful  
  
# AttendEvent
## Transaction: View all attendee ids and corresponding event ids  
GET:https://events-api-iuta.onrender.com/attend-event/view-all  
Returns: JSON
  
## Transaction: View all interested and approved events by user  
POST:https://events-api-iuta.onrender.com/attend-event/view-by-user
Request Body Parameters
userid:Text  
Returns: JSON
  
## Transaction: User is interested in the event
POST:https://events-api-iuta.onrender.com/attend-event/interested  
Request Body Parameters  
userid:Text  
eventid:Text
Returns: JSON if successful, String if failed  
  
## Transaction: User is approved for the event
PUT:https://events-api-iuta.onrender.com/attend-event/approved  
Request Body Parameters  
userid:Text  
eventid:Text  
Returns: JSON if successful, String if failed  
  
## Transaction: Cancel user interest to attend event
DELETE:https://events-api-iuta.onrender.com/attend-event/cancel  
Request Body Parameters
userid:Text  
eventid:Text  
Returns: 0 if failed, 1 if successful  
  
# Reviews
## Transaction: View all reviews by event id
POST:https://events-api-iuta.onrender.com/reviews/view-by-event  
Request Body Parameters
eventid:Text
Returns: JSON if successful, String if failed  
  
## Transaction: Add a review
POST:https://events-api-iuta.onrender.com/reviews/add  
Request Body Parameters
userid:Text
eventid:Text
review:Text
Returns: JSON if successful, String if failed  
  
## Transaction: View a review from a user and event
POST:https://events-api-iuta.onrender.com/reviews/view  
Request Body Parameters
userid:Text
eventid:Text
Returns: JSON if successful, String if failed  
  