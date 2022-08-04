<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/chatstyle.css">

<link rel="shortcut icon" href="images/favicon.png" type="">

  <title> Chatter </title>

  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

  <!--owl slider stylesheet -->
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
  <!-- nice select  -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css" integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ==" crossorigin="anonymous" />
  <!-- font awesome style -->
  <link href="css/font-awesome.min.css" rel="stylesheet" />

  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />
</head>
<body>
<!-- header section strats -->
           
<!-- end header section -->
    
	<p id="username" style="display: none">${user.username}</p>
	<p id="userAvatar" style="display: none">
		<c:url value="/files/${user.username}/${user.avatar}" />
	</p>
	<div class="container">
		<div class="conversation-container">
			<div class="modal-box border" id="add-group">
				<div class="modal-box-head">
					<div class="modal-box-title">
						Add Group
					</div>
					<div class="modal-box-close toggle-btn" data-id="add-group" onclick="toggleModal(this, false)">
						<i class="fa fa-times"></i>
					</div>
				</div>
				<hr>
				<form action="" onsubmit="return createGroup(event);">
					<div class="modal-box-body">
						<input type="text" class="txt-input txt-group-name" placeholder="Group Name...">
					</div>		
					<button type="submit" class="btn">Create Group</button>		
				</form>
			</div>
			
			<div class="modal-box border" id="add-user">
				<div class="modal-box-head">
					<div class="modal-box-title">
						Add Member
					</div>
					<div class="modal-box-close toggle-btn" data-id="add-user" onclick="toggleModal(this, false)">
						<i class="fa fa-times"></i>
					</div>
				</div>
				<hr>
				<form action="" onsubmit="return addMember(event);">
					<div class="modal-box-body add-member-body">
						<input type="text" class="txt-input txt-group-name" placeholder="Name of member..." onkeyup="searchMemberByKeyword(this)">
						
						<div class="list-user">
							<ul>
							</ul>
						</div>
					</div>		
					<button type="submit" class="btn">Add Members</button>		
				</form>
			</div>
			
			<div class="modal-box border" id="manage-user">
				<div class="modal-box-head">
					<div class="modal-box-title">
						All Member Of Group
					</div>
					<div class="modal-box-close toggle-btn" data-id="manage-user" onclick="toggleModal(this, false)">
						<i class="fa fa-times"></i>
					</div>
				</div>
				<hr>
				<div class="modal-box-body manage-member-body">
					<div class="list-user">
						<ul>
						</ul>
					</div>
				</div>	
			</div>
			
			<div class="left-side active">
				<div class="add-group border toggle-btn" data-id="add-group" onclick="toggleModal(this, true)"><i class="fa fa-plus-circle"></i></div>
				<h2>
					<a href="<c:url value="/users/update"/>"
						style="text-decoration: none; color: white;margin-right: 3rem;">Welcome
						${user.username}</a>
					:
					<a href="<c:url value="/users/logout"/>"
						style="text-decoration: none; color: white; margin-left: 3rem;">Logout</a>
				</h2>
				<div class="tab-control">
					<i class="fa fa-comment active" onclick="chatOne(this)"></i>
					<i class="fa fa-comments" onclick="chatGroup(this)"></i>
				</div>
				<div class="list-user-search">
					<input type="text" class="txt-input" data-type="user" placeholder="Search..." onkeyup="searchUser(this)">
				</div>
				<div class="list-user">
					<ul>
						<c:forEach var="friend" items="${friends}">
                                                    <li id=""${friend.username }" onclick="setReceiver(this);"></li>
								<div class="user-contain">
									<div class="user-img">
										<img id="img-${friend.username}"
											src="<c:url value="/files/${friend.username}/${friend.avatar}" />"
											alt="Image of user">
										<div id="status-${friend.username}" class="user-img-dot"></div>
									</div>
									<div class="user-info">
										<span class="user-name">${friend.username}</span>
									</div>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="right-side" id="receiver"></div>
		</div>
	</div>

</body>
</html>