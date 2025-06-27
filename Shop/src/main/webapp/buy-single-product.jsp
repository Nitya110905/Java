<%@page import="Dao.product_dao"%>
<%@page import="model.product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="buyer-header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Hero area Start-->

	<%
	int pid = Integer.parseInt(request.getParameter("pid"));
	%>

	<%
	product p = product_dao.getProductByPid(pid);
	%>
	<div class="hero-area section-bg2">
		<div class="container">
			<div class="row">
				<div class="col-xl-12">
					<div class="slider-area">
						<div
							class="slider-height2 slider-bg4 d-flex align-items-center justify-content-center">
							<div class="hero-caption hero-caption2">
								<h2>Product Details</h2>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--  Hero area End -->
	<!--  services-area start-->
	<div class="services-area2 pt-50">
		<div class="container">
			<div class="row">
				<div class="col-xl-12">
					<div class="row">
						<div class="col-xl-12">
							<!-- Single -->
							<div class="single-services d-flex align-items-center mb-0">
								<div class="features-img">
									<img src="product image/<%=p.getPimage()%>" height="200px"
										width="200px" alt="">
								</div>
								<div class="features-caption">
									<h3><%=p.getPname()%></h3>
									<p>
										By
										<%=p.getPcompany()%></p>
									<div class="price">
										<span>Rs. <%=p.getPprice()%></span>
									</div>
									<div class="review">
										<div class="rating">
											<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
												class="fas fa-star"></i> <i class="fas fa-star"></i> <i
												class="fas fa-star-half-alt"></i>
										</div>
									</div>
									<form action="Cart_Controller" method="post">
										<input type="hidden" name="cid" value="<%=b.getId()%>">
										<input type="hidden" name="pid" value="<%=p.getPid()%>">
										<button class="btn btn-primary px-3" name="action" value="addtocart">
											<i class="fa fa-shopping-cart mr-1"></i> Add To Cart
										</button>
									</form>
									<form action="Wishlist_Controller" method="post">
										<input type="hidden" name="cid" value="<%=b.getId()%>">
										<input type="hidden" name="pid" value="<%=p.getPid()%>">
										<button class="btn btn-primary px-3" name="action" value="add">
											<i class="fa fa-shopping-cart mr-1"></i> Add To WishList
										</button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- services-area End-->
	<!--Books review Start -->
	<section class="our-client section-padding best-selling">
		<div class="container">
			<div class="row">
				<div class="offset-xl-1 col-xl-10">
					<div class="nav-button f-left">
						<!--Nav Button  -->
						<nav>
							<div class="nav nav-tabs " id="nav-tab" role="tablist">
								<a class="nav-link active" id="nav-one-tab" data-bs-toggle="tab"
									href="#nav-one" role="tab" aria-controls="nav-one"
									aria-selected="true">Description</a> <a class="nav-link"
									id="nav-two-tab" data-bs-toggle="tab" href="#nav-two"
									role="tab" aria-controls="nav-two" aria-selected="false">Author</a>
								<a class="nav-link" id="nav-three-tab" data-bs-toggle="tab"
									href="#nav-three" role="tab" aria-controls="nav-three"
									aria-selected="false">Comments</a> <a class="nav-link"
									id="nav-four-tab" data-bs-toggle="tab" href="#nav-four"
									role="tab" aria-controls="nav-four" aria-selected="false">Review</a>
							</div>
						</nav>
						<!--End Nav Button  -->
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<!-- Nav Card -->
			<div class="tab-content" id="nav-tabContent">
				<div class="tab-pane fade show active" id="nav-one" role="tabpanel"
					aria-labelledby="nav-one-tab">
					<!-- Tab 1 -->
					<div class="row">
						<div class="offset-xl-1 col-lg-9">
							<p><%=p.getPdesc()%></p>
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="nav-two" role="tabpanel"
					aria-labelledby="nav-two-tab">
					<!-- Tab 2 -->
					<div class="row">
						<div class="offset-xl-1 col-lg-9">
							<p><%=p.getPcompany()%></p>
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="nav-three" role="tabpanel"
					aria-labelledby="nav-three-tab">
					<!-- Tab 3 -->
					<div class="row">
						<div class="offset-xl-1 col-lg-9">
							<p><%=p.getPdesc()%></p>
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="nav-four" role="tabpanel"
					aria-labelledby="nav-four-tab">
					<!-- Tab 4 -->
					<div class="row">
						<div class="offset-xl-1 col-lg-9">
							<p><%=p.getPdesc()%></p>
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="nav-five" role="tabpanel"
					aria-labelledby="nav-five-tab">
					<!-- Tab 5 -->
					<div class="row">
						<div class="offset-xl-1 col-lg-9"></div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Books review End -->
</body>
</html>