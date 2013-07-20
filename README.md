green_rider
===========
<br/>
//create user<br/>
http://localhost:9898/api/user/create<br/>
<br/>
type: POST<br/>
request:<br/>
    username, password<br/>
response:<br/>
    uid, app_key<br/>
<br/>
//login<br/>
http://localhost:9898/api/login<br/>
<br/>
type: POST<br/>
request:<br/>
    username, password<br/>
response:<br/>
    success: uid, app_key<br/>
    failed: []<br/>
<br/>
//find all plans<br/>
http://localhost:9898/api/plans<br/>
<br/>
type: GET<br/>
request:<br/>
    null<br/>
response:<br/>
    {<br/>
        {<br/>
            "pid": xx,<br/>
            "planname": xx,<br/>
            "starter": xx,<br/>
            "start_place": xx,<br/>
            "end_place": xx,<br/>
            "start_time": xx,<br/>
            "joiners":<br/>
                {<br/>
                    "uid1", "uid2"...<br/>
                }<br/>
        }<br/>
    }<br/>
<br/>
//create plan<br/>
http://localhost:9898/api/plan/create<br/>
<br/>
type: POST<br/>
request:<br/>
    "pid": xx,<br/>
    "planname": xx,<br/>
    "starter": xx,<br/>
    "start_place": xx,<br/>
    "end_place": xx,<br/>
    "start_time": xx,<br/>
    "joiners": "uid1";"uid2"<br/>
response:<br/>
    status_code: 200<br/>
<br/>
//join a plan<br/>
http://localhost:9898/api/plan/join<br/>
<br/>
type: POST<br/>
request:<br/>
    uid, pid<br/>
response:<br/>
    status_code: 200<br/>



