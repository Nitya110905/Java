<%@page import="Dao.product_dao"%>
<%@page import="model.product"%>
<%@page import="Dao.cart_dao"%>
<%@page import="model.cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file = "buyer-header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <section class="cart_area">
            <div class="container">
                <div class="cart_inner">
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Product</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Price</th>
                                    <th scope="col">Quantity</th>
                                    <th scope="col">Total price</th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                            <%int net_price = 0; %>
						<%
						List<cart> list = cart_dao.getCartByCusId(b.getId());
						%>
						<%
						for (cart c : list) {
							net_price = net_price+c.getTotal_price();
						%>
						<% 
						product p = product_dao.getProductByPid(c.getPid());
						%>
                                <tr>
                                    <td>
                                        <div class="media">
                                            <div class="d-flex">
                                                <img src="product image/<%=p.getPimage() %>" style="width: 100px;" alt="" />
                                            </div>
                                        </div>
                                    </td>
                                    <td><%=p.getPname() %></td>
                                    <td>
                                        <h5>Rs. <%=p.getPprice() %></h5>
                                    </td>
                                    <td>
                                        <div class="product_count">
                                        <form action="Cart_Controller" method="get">
										<input type="hidden" name="cart_id" value="<%=c.getCart_id() %>">
										<input type="hidden" name="pid" value="<%=c.getPid() %>">
										<input type="hidden" name="pprice" value="<%=c.getPprice() %>">
										<input type="number" name="qty" min="0" value="<%=c.getQty()%>" onchange="this.form.submit();">
									
                                        </div>
                                    </td>
                                    <td>
                                        <h5>Rs. <%=c.getTotal_price()%></h5>
                                    </td>
                                    <td>
                                        <td class="align-middle"><a href="buyer-remove-cart.jsp?cart_id=<%=c.getCart_id() %>" class="btn btn-danger">Remove</a></td>
                                    </td>
                                </tr>
                                </form>
                                <%
						}
						%>
                                
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>  
                                    <td></td>
                                    <td></td>
                                    
                                    <td>
                                        <h5>Subtotal</h5>
                                    </td>
                                    <td>
                                        <h5>Rs. <%out.print(net_price); %></h5>
                                    </td>
                                </tr>
                                <tr class="shipping_area">
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    
                                
                                    <td>
                                        <div class="shipping_box">
                                            <ul class="list">
                                                
                                                <li>
                                                    Free Shipping
                                                    <input type="radio" aria-label="Radio button for following text input">
                                                </li>
                                            </ul>
                                            <h6>
                                                Calculate Shipping
                                                <i class="fa fa-caret-down" aria-hidden="true"></i>
                                            </h6>
                                            <select class="shipping_select">
                                                <option value="1">Bangladesh</option>
                                                <option value="2">India</option>
                                                <option value="4">Pakistan</option>
                                            </select>
                                            <select class="shipping_select section_bg">
                                                <option value="1">Select a State</option>
                                                <option value="2">Select a State</option>
                                                <option value="4">Select a State</option>
                                            </select>
                                            <input class="post_code" type="text" placeholder="Postcode/Zipcode" />
                                            <a class="btn" href="#">Update Details</a>
                                        </div>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="checkout_btn_inner float-right">
                            <a class="btn" href="buyer-home.jsp">Continue Shopping</a>
                            <a class="btn checkout_btn" href="#">Proceed to checkout</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
</body>
</html>