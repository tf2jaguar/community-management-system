<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>成员信息</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Exchange Education a Responsive Web Template, Bootstrap Web Templates, Flat Web Templates, Android Compatible Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- css files -->
<link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="../css/chromagallery.css" rel="stylesheet" type="text/css" media="all" />
<link href="../css/info.css" rel="stylesheet" type="text/css"   />
<!-- /css files -->
<!-- fonts -->
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Viga' rel='stylesheet' type='text/css'>
<!-- /fonts -->
<link rel="icon" href="../images/pande.png">
</head>
<body id="index.html" data-spy="scroll" data-target=".navbar" data-offset="60">
<!-- About Section -->
<section class="about-us">
	<h3 class="text-center slideanim">社团成员</h3>
	<p class="text-center slideanim">成员信息</p>
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6">
				<div class="about-details">
					<div class="row">
						<div class="col-sm-2 col-xs-12">
							<img src="../header/about-img1.jpg" class="img-responsive slideanim" alt="about-img">
						</div>
						<div class="col-sm-10 col-xs-12">						
							<div class="about-info slideanim">
								<h5>赵德柱</h5>
								<p>会长：学生社团会长是学生社团的执行机构，是学生社团的最高行政管理机构。有新生会员队长的任免权；具有管理协会的一切活动的权力；对副会长以及各部长具有监督义务同时也具有对部长的任免权；会长及各职能机构各司其职，共同为学校学生社团的发展贡献力量。</p>
							</div>
						</div>
					</div>						
				</div>
			</div>
			<div class="col-lg-6 col-md-6">
				<div class="about-details">
					<div class="row">
						<div class="col-sm-2 col-xs-12">
							<img src="../header/about-img2.jpg" class="img-responsive slideanim" alt="about-img">
						</div>	
						<div class="col-sm-10 col-xs-12">
							<div class="about-info slideanim">
								<h5>李小花</h5>
								<p>副会长：协助会长组织协会的日常社团活动，有新生会员队长的推荐权；机动性强，可以肩负部长一职，随时弥补社团的空缺。对副会长以及各部长具有监督的权力。</p>
							</div>
						</div>
					</div>		
				</div>
			</div>
		</div>
		<div class="row below">
			<div class="col-lg-6 col-md-6">
				<div class="about-details">
					<div class="row">
						<div class="col-sm-2 col-xs-12">
							<img src="../header/about-img3.jpg" class="img-responsive slideanim" alt="about-img">
						</div>
						<div class="col-sm-10 col-xs-12">
							<div class="about-info slideanim">
								<h5>张小美</h5>
								<p>组织文化部长：负责社团内部的组织、人事的管理工作；负责社团文化建设，通过建立社团品牌文化以树立社团形象；负责监督并协助会长做好各项规章制度的修订与更新工作；负责社团会员的考核评选：学期性：优秀团队、优秀队长、优秀会员；学年性：社团积极份子、年度优秀团队、年度优秀队长、年度优秀会员的评选。</p>
							</div>
						</div>
					</div>		
				</div>
			</div>
			<div class="col-lg-6 col-md-6">
				<div class="about-details">
					<div class="row">
						<div class="col-sm-2 col-xs-12">
							<img src="../header/about-img4.jpg" class="img-responsive slideanim" alt="about-img">
						</div>
						<div class="col-sm-10 col-xs-12">
							<div class="about-info slideanim">
								<h5>王大锤</h5>
								<p>网络宣传部长：负责社团的海报、横幅、喷绘、写真、展板、广播等宣传工作；具有接受社团联培训与联系社团联一起做好宣传的义务；负责社团文化以及社团活动的宣传；负责社团工作简报和活动简报的撰写工作和社团活动的新闻采访工作。社团工作和活动视频制作、技术支持等。</p>
							</div>
						</div>
					</div>		
				</div>
			</div>
		</div>	
	</div>
</section>
<!-- /About Section -->	

<!-- js files -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/SmoothScroll.min.js"></script>
<!-- js files for gallery -->
<script src="js/chromagallery.pkgd.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() 
		{
		    $(".mygallery").chromaGallery();
		});
	</script>
<!-- /js files for gallery -->	
<!-- Back To Top -->
<script src="../js/backtotop.js"></script>
<!-- /Back To Top -->
<script>
$(document).ready(function(){
  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {

  // Store hash
  var hash = this.hash;

  // Using jQuery's animate() method to add smooth page scroll
  // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
  $('html, body').animate({
    scrollTop: $(hash).offset().top
  }, 900, function(){

    // Add hash (#) to URL when done scrolling (default click behavior)
    window.location.hash = hash;
    });
  });
})
</script>
<script>
$(window).scroll(function() {
  $(".slideanim").each(function(){
    var pos = $(this).offset().top;

    var winTop = $(window).scrollTop();
    if (pos < winTop + 600) {
      $(this).addClass("slide");
    }
  });
});
</script>
<!-- /js files -->
</body>
</html>