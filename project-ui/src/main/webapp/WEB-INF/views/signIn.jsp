<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<script type="text/javascript">
	/* Replace #your_subdomain# by the subdomain of a Site in your OneAll account */
	var oneall_subdomain = 'somewebpage';

	/* The library is loaded asynchronously */
	var oa = document.createElement('script');
	oa.type = 'text/javascript';
	oa.async = true;
	oa.src = '//' + oneall_subdomain + '.api.oneall.com/socialize/library.js';
	var s = document.getElementsByTagName('script')[0];
	s.parentNode.insertBefore(oa, s);
</script>
<script type="text/javascript">
	var oa = document.createElement('script');
	oa.type = 'text/javascript';
	oa.async = true;
	oa.src = '//somewebpage.api.oneall.com/socialize/library.js'
	var s = document.getElementsByTagName('script')[0];
	s.parentNode.insertBefore(oa, s)
</script>
<script src="http://userapi.com/js/api/openapi.js"
	type="text/javascript" charset="windows-1251"></script>
<script type="text/javascript" src="//vk.com/js/api/openapi.js?112"></script>
<script type="text/javascript"
	src="/js/LoginRadius-HTML5-SDK-b0ba9ac/LoginRadiusSDK.2.0.0.js"></script>



<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">


<meta name="author" content="Lesnikovich Dmitry">


<title>Sign In</title>
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap-theme.min.css">
<script type="text/javascript"
	src="http://code.jquery.com/jquery.min.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>

<link href="signin.css" rel="stylesheet">
</head>

<body>


	<div class="container">

		<form class="form-signin" role="form" method="post">
            <meta name="user credentials form" />
			<h2 class="form-signin-heading">Please sign in</h2>
            <meta name="email form" />
			<input size="20" type="email" class="form-control"
				placeholder="Email address" required autofocus name="login">
            <meta name="password form" />
			<input size="20" type="password" class="form-control"
				placeholder="Password" required name="password"> <label
				class="checkbox"> <input type="checkbox" value="remember-me">
				Remember me
			</label>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
			<input type="hidden" name="action" value="signIn">
		</form>
		<br /> <br />



		<div id="oa_social_login_container"></div>

		<script type="text/javascript">
			/* Replace #your_callback_uri# with the url to your own callback script */
			var your_callback_script = 'http://localhost:8080/social';

			/* Embeds the buttons into the container oa_social_login_container */
			var _oneall = _oneall || [];
			_oneall.push([ 'social_login', 'set_providers',
					[ 'facebook', 'google', 'vkontakte', 'twitter' ] ]);
			_oneall.push([ 'social_login', 'set_callback_uri',
					your_callback_script ]);
			_oneall.push([ 'social_login', 'do_render_ui',
					'oa_social_login_container' ]);
		</script>
    </div>
</body>
</html>
