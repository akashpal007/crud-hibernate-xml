<%@page import="java.util.Objects"%>
<%@page import="com.j2ee.vo.ProductLineVO"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>Productlines</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="bg-secondary">
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="index.jsp"><i class="fa fa-ravelry" aria-hidden="true"></i></a>
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="productlines">Product Lines</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="products">Products</a>
    </li>
  </ul>
</nav>
	<%
		List<ProductLineVO> productLines = (List<ProductLineVO>) session.getAttribute("productLines");
	%>
	<div id="accordion">
		<div class="card bg-success">
			<a class="collapsed card-link" data-toggle="collapse"
				href="#collapseTwo"><div class="card-header text-white h4 text-center">Product lines
					Insert & Update Operation</div></a>
			<div id="collapseTwo" class="collapse" data-parent="#accordion">
				<div class="card-body container-fluid p-2">
					<div class="row">
						<div class="col bg-light rounded m-3">
							<div class="d-flex justify-content-center">
								<h4>Product lines Insert Row</h4>
							</div>
							<div>
								<form action="productlinesInsert" method="post">
									<div class="form-group">
										<label for="productLine">Product Line:</label> <input
											type="text" class="form-control" placeholder="Product Line"
											id="productLine" name="productLine" required>
									</div>
									<div class="form-group">
										<label for="textDescription">TextDescription:</label>
										<textarea class="form-control" rows="5" id="textDescription"
											name="textDescription" required></textarea>
									</div>
									<button class="btn btn-primary" type="submit">Insert</button>
								</form>
							</div>
						</div>
						<div class="col bg-light rounded m-3">
							<div class="d-flex justify-content-center">
								<h4>Product lines Update Row</h4>
							</div>
							<div>
								<form action="productlinesEdit" method="post">
									<!-- <div class="form-group">
							<label for="productLine">Product Line:</label> <input type="text"
								class="form-control" placeholder="Product Line" id="productLine"
								name="productLine" required>
						</div> -->
									<div class="form-group">
										<label for="productLine">Product Line:</label> <select
											class="form-control" id="productLine" name="productLine"
											required>
											<%
												if (Objects.nonNull(productLines)) {
													for (ProductLineVO lineVO : productLines) {
														out.print(
																"<option value='" + lineVO.getProductLine() + "'>" + lineVO.getProductLine() + "</option>");
													}
												} else {
													out.print("<option>No Product Lines Available</option>");
												}
											%>

										</select>
									</div>
									<div class="form-group">
										<label for="textDescription">TextDescription:</label>
										<textarea class="form-control" rows="5" id="textDescription"
											name="textDescription" required></textarea>
									</div>
									<button class="btn btn-primary" type="submit">Update</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- <div class="container-fluid bg-success p-2"></div> -->
	<div class="container-fluid p-2">
		<div class="d-flex justify-content-center text-white">
			<h2>Product lines Table Data</h2>
		</div>
		<div id="products-table-area" class="m-3 p-3 text-white">
			<%
				if (Objects.nonNull(productLines)) {
					out.print("<table class='table table-dark table-striped table-hover table-bordered'><thead>");
					out.print("<tr><th scope='col'>Product Line</th>");
					out.print("<th scope='col'>Description</th>");
					out.print("<th scope='col'>Action</th>");
					out.print("</tr></thead><tbody>");
					for (ProductLineVO lineVO : productLines) {
						out.print("<tr><td>" + lineVO.getProductLine() + "</td>");
						out.print("<td>" + lineVO.getTextDescription() + "</td>");
						out.print("<td><a href='productlinesDelete?productLine=" + lineVO.getProductLine()
								+ "'><i class='fa fa-trash-o fa-2x text-white' aria-hidden='true'></i></a></td></tr>");
					}
					out.print("</tbody></table>");
				} else {
					out.print("No Table Available");
				}
			%>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
</body>
</html>
