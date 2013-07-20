green_rider
===========

//create user
http://localhost:9898/api/user/create

type: POST
request:
    username, password
response:
    uid, app_key

//login
http://localhost:9898/api/login

type: POST
request:
    username, password
response:
    success: uid, app_key
    failed: []

//find all plans
http://localhost:9898/api/plans

type: GET
request:
    null
response:
    {
        {
            "pid": xx,
            "planname": xx,
            "starter": xx,
            "start_place": xx,
            "end_place": xx,
            "start_time": xx,
            "joiners":
                {
                    "uid1", "uid2"...
                }
        }
    }

//create plan
http://localhost:9898/api/plan/create

type: POST
request:
    "pid": xx,
    "planname": xx,
    "starter": xx,
    "start_place": xx,
    "end_place": xx,
    "start_time": xx,
    "joiners": "uid1";"uid2"
response:
    status_code: 200

//join a plan
http://localhost:9898/api/plan/join

type: POST
request:
    uid, pid
response:
    status_code: 200



