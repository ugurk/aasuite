<?php
	$username = strtoupper($_REQUEST['username']);
	$password = strtoupper($_REQUEST['password']);
	if ('ADMIN' == $username && 'ADMIN' == $password) {
  		gotoAdminView();
	}
	else {
		if ('' == $password) {
			header("Location: loginError.php");
		}
		else if ('' == $username) {
			header("Location: loginError.php");
		}
		else {
			gotoView();
		}
	}
	
	function gotoAdminView() {
		header("Location: adminview.php");
	}
	
	function gotoView() {
		header("Location: view.php");
	}
?>