# API Links and Parameters

# User
## Transaction: View all users
GET: https://events-api-iuta.onrender.com/user/view-all
Transaction: Add a user

# Transaction: Add a user
POST: https://events-api-iuta.onrender.com/user/add
Request Body Parameters
firstname: Text
lastname: Text
email: Text
password: Text
user_type: Text(user, admin, organizer, pending)

# Transaction: Login
POST: https://events-api-iuta.onrender.com/user/login
Request Body Parameters
email: Text
password: Text

# Transaction: View user info
POST: https://events-api-iuta.onrender.com/user/view
Request Body Parameters
email: Text

# Transation: Update user type
POST: https://events-api-iuta.onrender.com/user/view
Request Body Parameters
email: Text
user_type: Text(user, admin, organizer, pending)


# Event
# Transaction: View all events
GET: https://events-api-iuta.onrender.com/event/view-all

# Transaction: Add an event
POST: https://events-api-iuta.onrender.com/event/add
Request Body Parameters
eventname: Text
organizer: Text
description: Text
location: Text
startdate: Date(yyyy-mm-dd)
enddate: Date(yyyy-mm-dd)
status: Text (ongoing, upcoming, cancelled, finished)

# AttendEvent
# Transaction: View all attendee ids and corresposding event ids
GET: https://events-api-iuta.onrender.com/attend-event/view-all
