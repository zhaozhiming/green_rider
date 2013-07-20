<p><span>//create user</span><br /><span>http://localhost:9898/api/user/create</span><br /><br /><span>type: POST</span><br /><span>request:</span><br /><span>&nbsp; &nbsp; username, password</span><br /><span>response:</span><br /><span>&nbsp; &nbsp; uid, app_key</span></p>
<p><span style="color: #ff0000;"><strong>================================</strong></span><br /><span>//login</span><br /><span>http://localhost:9898/api/login</span><br /><br /><span>type: POST</span><br /><span>request:</span><br /><span>&nbsp; &nbsp;username, password</span><br /><span>response:</span><br /><span>&nbsp; &nbsp;success: uid, app_key</span><br /><span>&nbsp; &nbsp;failed: []</span></p>
<p>&nbsp;</p>
<p><span style="color: #ff0000;"><strong>================================</strong></span><br /><span>//create plan</span><br /><span>http://localhost:9898/api/plan/create</span><br /><br /><span>type: POST</span><br /><span>request:</span><br /><span>&nbsp; &nbsp;"planname": xx,</span><br /><span>&nbsp; &nbsp;"starter": uid,</span><br /><span>&nbsp; &nbsp;"start_place": xx,</span><br /><span>&nbsp; &nbsp;"end_place": xx,</span><br /><span>&nbsp; &nbsp;"start_time": xx</span><br /><span>response:</span></p>
<p>&nbsp; &nbsp;pid: xx,<br /><span>&nbsp; &nbsp;status_code: 200</span></p>
<p><span style="color: #ff0000;"><strong>================================</strong></span><br /><span>//join a plan</span><br /><span>http://localhost:9898/api/plan/join</span><br /><br /><span>type: POST</span><br /><span>request:</span><br /><span>&nbsp; &nbsp;uid, pid</span><br /><span>response:</span><br /><span>&nbsp; &nbsp;status_code: 200</span></p>
<p><span style="color: #ff0000;"><strong>================================</strong></span></p>
<p><span>//find plans by uid, select both starter and joiner<br />http://localhost:9898/api/plans/{uid}<br /><br />type: GET<br />request:<br />&nbsp; &nbsp;uid<br />response:<br /></span></p>
<p>&nbsp; &nbsp;{<br />&nbsp; &nbsp;&nbsp; &nbsp;{<br />&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;"pid": xx,<br />&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;"planname": xx,<br />&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;"starter": &nbsp;{ uid, username},<br />&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;"start_place": xx,<br />&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;"end_place": xx,<br />&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;"start_time": xx,</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"role": xx, &nbsp;// "starter" or "joiner"&nbsp;<br />&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;"joiners":<br />&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;{ &nbsp;&nbsp;</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;{uid, username},&nbsp;{uid, username}</p>
<p>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;}<br />&nbsp; &nbsp;&nbsp; &nbsp;}<br />&nbsp; &nbsp;}</p>
<p>&nbsp;</p>
<p><span><strong>================================</strong></span></p>
<p>//find all plans&nbsp;<br />http://localhost:9898/api/plans<br /><br />type: GET<br />request:<br />&nbsp; &nbsp;null<br />response:</p>
<p>&nbsp; &nbsp;{<br />&nbsp; &nbsp;&nbsp; &nbsp;{<br />&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;"pid": xx,<br />&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;"planname": xx,<br />&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;"starter": &nbsp;{ uid, username},<br />&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;"start_place": xx,<br />&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;"end_place": xx,<br />&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;"start_time": xx,</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"role": xx, &nbsp;// &nbsp;"none"<br />&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;"joiners":<br />&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;{ &nbsp;&nbsp;</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;{uid, username},&nbsp;{uid, username}</p>
<p>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;}<br />&nbsp; &nbsp;&nbsp; &nbsp;}<br />&nbsp; &nbsp;}</p>
<p><span style="font-size: 14px; line-height: 1.5;">&nbsp;</span></p>
<p><span>&nbsp;</span></p>
<p>&nbsp;</p>